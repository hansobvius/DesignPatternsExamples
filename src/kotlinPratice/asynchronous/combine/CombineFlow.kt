package kotlinPratice.asynchronous.combine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

suspend fun setLetterA(){
    delay(1000L)
    println("LETTER A")
}

suspend fun setLetterB(){
    delay(100L)
    println("LETTER B")
}

fun runFlow() = runBlocking{
    val letterA =  flowOf(setLetterA())
    val letterB = flowOf(setLetterB())

    letterA.combine(letterB){A, B ->
        "$A$B"
    }.collect{
        print("result: ${it}")
    }
}

