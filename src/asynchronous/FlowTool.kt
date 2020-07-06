package asynchronous

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class FlowTool{

    private suspend fun getDataFlow(): Flow<Int> = flow{
        for(i in 10 downTo 0){
            delay(100)
            emit(i)
        }
    }

    val getFlow = runBlocking{
        getDataFlow().collect{ value ->
            println(value)
        }
    }
}