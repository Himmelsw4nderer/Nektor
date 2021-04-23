package game

/**
 * A game contender.
 */
interface NektorGameContender{
    /**
     * Adds a score to the contender.
     */
    fun addPoints(score: Int, teamMate: Int = 0){}

    /**
     * Returns the score of the contender.
     *
     * @return The score of the contender.
     */
    fun getScore():Int = 0

    /**
     * Returns the size of the contender mostly used for teams.
     *
     * @return The size of the contender.
     */
    fun size():Int = 1

    /**
     * Returns the score of a player of the contender mostly used for teams.
     *
     * @return The score of a player of the contender.
     */
    fun getPlayerScore(teamMate: Int): Int = 0

    /**
     * Returns the name of the contender.
     *
     * @return The name of the contender.
     */
    fun getName(teamMate: Int? = null): String = ""
}
