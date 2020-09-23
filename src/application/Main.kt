package application

import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>){
//    val flowClass = FlowClass()
//    flowClass.printValue
//    val asyncClass = AsyncClass()
//    asyncClass.runAsync
//    initializeBuilder()
//    println(getFormatDate(date))
//    doFlow()
    val name = returnLastName()
    println(convertMinuteToHour(90.toString()))
}

fun convertMinuteToHour(length: String?): String {
    if(length == null || length.isEmpty() || length == "0") return ""

    val h: String?
    val m: String?

    val hour = length.toLong() / 60
    val min = length.toLong() % 60

    if(hour.toString().length > 2) h = hour.toString().slice(0..1)
    else h = hour.toString()

    if(min < 10)m = "0" + min.toString()
    else m = min.toString()

    return "${h}:${m}"
}


val date = "2020-06-25T17:37:13.991Z"
val dateold = "2020-06-02T00:00:00.000Z"

val fullName = "name1.name2.name3.name4.name5"

private const val DATE_PATTERN = "dd/MM/yyyy"

fun getFormatDate(s: String): String? {
    try {
        val dateFormat = SimpleDateFormat(DATE_PATTERN)
        val newDate = Date(s.toLong())
        val formatedDate = dateFormat.format(newDate)
        return formatedDate
    } catch (e: Exception) {
        return e.toString()
    }
}

fun dateFormatCatalogue(value: String?): String?{
    var newString = ""
    var pos = 0
    val dateList = mutableListOf<String>()
    value!!.forEachIndexed { i, c -> if(c == 'T') pos = i }
    value.subSequence(0, pos).toString().split("-").forEachIndexed { index, s ->
        if(index == 0) dateList += s
        else dateList += s.plus( "/")
    }
    for(i in (dateList.size - 1) downTo 0)  newString += dateList[i]
    return newString
}

fun returnLastName(): String{
    var name: String? = null
    val finalName = fullName.split(".")
    finalName.forEachIndexed { position, value ->
        if(position == finalName.size - 1) name = value
    }
    return name!!
}