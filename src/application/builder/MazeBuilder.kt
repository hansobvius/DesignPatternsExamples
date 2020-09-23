package application.builder

class MazeBuilder() {

    inner class Builder(){

        fun build(): MazeBuilder =
            MazeBuilder()

        fun buildMaze(){
            println("Build Maze")
        }

        fun buildRoom(room: Int){
            println("Build Maze with $room room")
        }

        fun buildDoor(roomFrom: Int, roomTo: Int){
            println("Build Maze with a door from $roomFrom to $roomTo")
        }
    }
}

fun initializeBuilder(): MazeBuilder =
    MazeBuilder().Builder().apply {
        buildMaze()
        buildRoom(1)
        buildDoor(3, 4)
    }.build()
