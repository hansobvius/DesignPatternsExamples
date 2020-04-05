package builder

/*
    exemple link: https://medium.com/@vicidroiddev/using-builders-in-kotlin-data-class-e8a08797ed56
 */

class Person(
    val name: String,
    val age: Int,
    val genre: String) {

    class Builder{

        private lateinit var name: String
        private var age: Int = 0
        private lateinit var genre: String

        fun name(name: String) = apply{
            this.name = name
        }

        fun age(age: Int) = apply{
            this.age = age
        }

        fun genre(genre: String) = apply{
            this.genre = genre
        }

        fun build() = Person(
            name,
            age,
            genre
        )
    }
}

val person = Person.Builder()
    .age(30)
    .genre("male")
    .name("Thiago")
    .build()