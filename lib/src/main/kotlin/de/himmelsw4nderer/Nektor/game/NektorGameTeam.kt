package game

/**
 * A game team.
 *
 * @constructor Creates an team out of the given players with a given name and mode.
 * @property players the players of the team.
 * @property MODE the mode of the team.
 * @property name the name of the team.
 */
class NektorGameTeam (var players: ArrayList<NektorGamePlayer>, val MODE: Int, val name: String) : NektorGameContender {

    companion object {
        const val MODE_EQUAL_SCORE: Int = 0 //Mode when the whole team has one score (Stored in the first player)
        const val MODE_ADD_SCORE: Int = 1 //Mode when the player Score for themself and the team score is all player scores added up
    }

    /**
     * Adds the given score to the teammate.
     */
    override fun addPoints(score: Int, teamMate:Int) {
        super.addPoints(score,teamMate)
        players[teamMate].addPoints(score)
    }

    /**
     * Returns the score of the team.
     *
     * @return The score of the team.
     */
    override fun getScore(): Int{
        super.getScore()
        var score: Int = 0
        //counting together all scores of players
        for(player in players){
            score += player.getScore()
        }
        return score
    }

    /**
     * Returns the score of the teammate.
     *
     * @return The score of the teammate.
     */
    override fun getPlayerScore(teamMate: Int): Int{
        super.getPlayerScore(teamMate)
        return players[teamMate].getScore()
    }

    /**
     * Returns the player of the team.
     *
     * @return The player of the team.
     */
    fun getPlayer(teamMate: Int) = players[teamMate]

    /**
     * Returns the size of the team.
     *
     * @return The size of the team.
     */
    override fun size(): Int = players.size

    /**
     * Returns the name of the team or a player from the team.
     *
     * @return The name of the team or a player from the team.
     */
    override fun getName(teamMate: Int?): String {
        super.getName(teamMate)
        if(teamMate == null) {
            return name
        }
        return players[teamMate].getName()
    }
}