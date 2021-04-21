package ranking

import game.NektorGamePlayer
import base.NektorPlayer
import game.NektorGameGame

/**
 * A ranked player.
 *
 * @constructor Creates an player out of the given games, wins, draws, loses, name and id.
 * @property games The games of the player.
 * @property wins The wins of the player.
 * @property draws The draws of the player.
 * @property loses The loses of the player.
 * @property name The name of the player.
 * @property id The id of the player.
 */
class NektorRankingPlayer (var games:ArrayList<Int>, var wins:ArrayList<Int>, var draws:ArrayList<Int>, var loses:ArrayList<Int>, name: String, id: Int) : NektorPlayer(name, id), NektorRankingContender {

    /**
     * All games of the player
     */
    var totalGames: Int = total(games)
    /**
     * All wins of the player
     */
    var totalWins: Int = total(wins)
    /**
     * All draws of the player
     */
    var totalDraws: Int = total(draws)
    /**
     * All loses of the player
     */
    var totalLoses: Int = total(loses)

    /**
     * Returns the games of the player.
     *
     * @return The games of the player.
     */
    fun totalGames(): Int = totalGames
    /**
     * Returns the wins of the player.
     *
     * @return The wins of the player.
     */
    fun totalWins(): Int = totalWins
    /**
     * Returns the draws of the player.
     *
     * @return The draws of the player.
     */
    fun totalDraws(): Int = totalDraws
    /**
     * Returns the loses of the player.
     *
     * @return The loses of the player.
     */
    fun totalLoses(): Int = totalLoses

    /**
     * Returns the games of the player in a specific gamemode.
     *
     * @return The games of the player in a specific gamemode.
     */
    fun games(pos: Int):Int = games[pos]
    /**
     * Returns the wins of the player in a specific gamemode.
     *
     * @return The wins of the player in a specific gamemode.
     */
    fun wins(pos: Int):Int = wins[pos]
    /**
     * Returns the draws of the player in a specific gamemode.
     *
     * @return The draws of the player in a specific gamemode.
     */
    fun draws(pos: Int):Int = draws[pos]
    /**
     * Returns the loses of the player in a specific gamemode.
     *
     * @return The loses of the player in a specific gamemode.
     */
    fun loses(pos: Int):Int = loses[pos]

    /**
     * Returns the winrate of the player.
     *
     * @return The winrate of the player.
     */
    fun winRate(pos: Int):Float = wins[pos]/games[pos].toFloat()*100
    /**
     * Returns the drawrate of the player.
     *
     * @return The drawrate of the player.
     */
    fun drawRate(pos: Int):Float = draws[pos]/games[pos].toFloat()*100
    /**
     * Returns the loserate of the player.
     *
     * @return The loserate of the player.
     */
    fun loseRate(pos: Int):Float = loses[pos]/games[pos].toFloat()*100


    //calculating a total out of Int Array
    private fun total(array: ArrayList<Int>): Int{
        var total = 0
        for (int in array) {
            total += int
        }
        return total
    }

    /**
     * Returns a game player out of this ranked player.
     *
     * @return A game player out of this ranked player.
     */
    fun makeGamePlayer(score: Int): NektorGamePlayer = NektorGamePlayer(score, name, id)

    /**
     * Adds a game to the player.
     */
    fun addGame(game: NektorGameGame){
        //TODO
    }
}