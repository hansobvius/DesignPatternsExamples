package kotlinPratice.asynchronous

import kotlinx.coroutines.*
import java.util.*

class AsyncClass{

    lateinit var scope: CoroutineScope

    private val coroutineScope: CoroutineScope by lazy{
        CoroutineScope(SupervisorJob() + Dispatchers.Main)
    }

    private fun _getScope(): CoroutineScope?{
        scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
        return scope
    }

    val runAsync = _getScope()!!.async{
        val first = async(start = CoroutineStart.LAZY){
            doFirst()
        }
        val second = async(start = CoroutineStart.LAZY){
            doSecond()
        }
        first.start()
        second.start()
        println("${first.await()} / ${second.await()}")
    }

    val runJobAndAsync = runBlocking{
        val first = async{
            this.launch {
                doFirst()
            }
        }
        val second = doSecond()
        val message = "${first.await()} / ${second}"
        println(message)
    }

    private suspend fun doFirst(): Int = Random().nextInt(10)

    private suspend fun doSecond(): Int = Random().nextInt(20)
}