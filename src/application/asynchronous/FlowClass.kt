package application.asynchronous

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class FlowClass {

    val printValue = runBlocking {
        flowStream().collect { value ->
            println("value: $value")
        }
    }

    private fun flowStream(): Flow<Int> = flow {
        for(i in 0..10){
            delay(500)
            emit(i)
        }
    }
}