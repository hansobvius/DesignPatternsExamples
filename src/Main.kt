import asynchronous.*
import asynchronous.combine.runFlow
import builder.MazeBuilder
import builder.initializeBuilder

fun main(args: Array<String>) = runFlow()


private fun contextOperator(){
    val list = listOf(1,2,3,4,5)
    runChangeContextFlow<Int>(list)
}

private fun printFlowBuilder(){
    val list = listOf(1,2,3,4,5)
    flowBuilder(list)
}

private fun printFlowTool(){
    val flowTool = FlowTool()
    flowTool.getFlow
}

private fun printAsyncClass(){
    val asyncClass = AsyncClass()
    asyncClass.runAsync
}