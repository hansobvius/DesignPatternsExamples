package delegate

/**
 * The given example are in Wikpedia article https://en.wikipedia.org/wiki/Delegation_pattern
 */

var theCloseShape: CloseShape? = null


fun runDelegate(){
    val rectValue = Rectangle(10, 10).area()
    println("The area is: ${rectValue}m")
}

fun runWithDelegation(){
    val delegated = Window(object : CloseShape{
        override fun area(): Int = 10 * 10
    })
    println("The area is: ${delegated.area()}m")
}

interface CloseShape{
    fun area(): Int
}

class Rectangle(val width: Int, val height: Int): CloseShape{

    override fun area() = width * height
}

class Window(private val bounds: CloseShape): CloseShape by bounds