package game

interface NektorGameContender {
    //adding Points to a contender
    fun addPoints(score: Int, teamMate: Int = 0){}

    //returning the score of the contender
    fun getScore():Int = 0

    //returning the size of the contenders Team /  normal 1
    fun size():Int = 1

    //returns the Score of a player
    fun getPlayerScore(teamMate: Int): Int = 0

    //returns the name
    fun getName(teamMate: Int? = null): String = ""
}
