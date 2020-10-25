package kotlinPratice.functions

class dudeClass(){

    init{

    }

    private fun doThing(){
        val objectList = initiateDude()
    }

    private fun initiateDude(): List<Dude>{
        val list = mutableListOf<Dude>()
        for(i in 1..10){
            list.add(Dude(id = i))
        }
        return list
    }

    private fun <T> List<T>.getSomething(list: List<T>): List<T>?{
        val getNew =  forEach() { obj ->
//          filter{  }
        }

        return null
    }
}

data class Dude(
    val id: Int = 0,
    val name: String = "Thiago")

