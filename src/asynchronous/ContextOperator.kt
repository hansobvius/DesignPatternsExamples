@file:Suppress("UNCHECKED_CAST")

package asynchronous

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

/**
    Flow operation can initiate and terminate in different context´s dispatchers
*/


@ExperimentalCoroutinesApi
fun <T> runChangeContextFlow(list: List<T>) = runBlocking {
    flowDispatcher(list).collect { value ->
        println("value: $value")
    }
}

@ExperimentalCoroutinesApi
private suspend fun <T> flowDispatcher(list: List<T>): Flow<T> = flow<T> {
    for(i in 0..list.size){
        delay(5_00)
        emit(i as T)
    }
}.flowOn(Dispatchers.Default)