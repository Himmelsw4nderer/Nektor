package game

import base.NektorPlayer

/**
 * A game player.
 *
 * @constructor Creates an game player with score, name and id.
 * @property score the score of this player.
 * @property name the name of this player.
 * @property id the id of this player.
 */
class NektorGamePlayer(private var score: Int, name: String, id: Int) : NektorPlayer(name, id), NektorGameContender {

    /**
     * Adds a score to the player. Teammate is only used for teams and not players.
     */
    override fun addPoints(score: Int, teamMate:Int) {
        super.addPoints(score, teamMate)
        this.score += score
    }

    /**
     * Returns the score of the player.
     *
     * @return The score of the player.
     */
    override fun getScore(): Int{
        super.getScore()
        return score
    }

    /**
     * Returns the score of the player. Teammate is only used for teams and not players.
     *
     * @return The score of the player.
     */
    override fun getPlayerScore(teamMate: Int): Int {
        super.getPlayerScore(teamMate)
        return score
    }

    /**
     * Returns the name of the player. Teammate is only used for teams and not players.
     *
     * @return The name of the player.
     */
    override fun getName(teamMate: Int?): String {
        super.getName(teamMate)
        return name
    }
}