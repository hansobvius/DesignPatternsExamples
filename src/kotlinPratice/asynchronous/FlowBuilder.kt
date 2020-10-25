package kotlinPratice.asynchronous

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class FlowBuilder<T>{

    fun print(list: List<T>) = runBlocking {
        showBuilder(list)
    }

    private suspend fun showBuilder(list: List<T>){
        (list).asFlow().collect{
            println("asFlow: $it")
        }
    }

    suspend fun flowOperator(list: List<T>){
        (list).asFlow()
            .map{ request -> performRequest(request) }
            .collect{ response -> println(response) }
    }
    suspend fun performRequest(request: T){
        delay(5_00)

    }
}

fun <T> flowBuilder(list: List<T>) = runBlocking {
    flowOperator(list)
}

suspend fun <T> showBuilder(list: List<T>){
    (list).asFlow().collect{
        println("asFlow: $it")
    }
}

// collect print´s the response returned by `map` operator
suspend fun <T> flowOperator(list: List<T>){
    (list).asFlow()
        .map{ request -> performRequest(request) }
        .collect{ response -> println(response) }
}
suspend fun <T> performRequest(request: T): String{
    delay(5_00)
    return "request: $request"
}
