package builder

class MazeBuilder {

    fun buildMaze(){}

    fun buildRoom(room: Int){}

    fun buildDoor(roomFrom: Int, roomTo: Int){}

    fun getMaze(): MazeBuilder = this

    protected constructor()
}

val mazeBuilder = MazeBuilder::class

fun create(builder: MazeBuilder): MazeBuilder{
    builder.buildMaze()
    builder.buildRoom(1)
    builder.buildRoom(2)
    builder.buildDoor(1, 2)
    return builder.getMaze()
}