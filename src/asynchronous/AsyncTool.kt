package asynchronous

import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.CoroutineContext

class AsyncClass{

    lateinit var scope: CoroutineScope

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