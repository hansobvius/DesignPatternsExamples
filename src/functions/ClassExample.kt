package functions

fun printNameFromExtensionExample(){
    val `class` = GetClass.getClass()
    `class`.printName()
}

class ClassExample(val name: String = "Thiago", val age: Int = 35)

fun ClassExample.printName(){
    println("My name is ${name}")
}

object GetClass{
    fun getClass(): ClassExample = ClassExample()
}