import kotlinPratice.asynchronous.*
import kotlinPratice.functions.printNameFromExtensionExample

fun main(args: Array<String>) = printNameFromExtensionExample()


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