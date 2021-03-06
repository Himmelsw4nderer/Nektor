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
 * @property gameHistoryIds The id of the player.
 * @property name The name of the player.
 * @property id The id of the player.
 */
class NektorRankingPlayer (var games:ArrayList<Int>, var wins:ArrayList<Int>, var draws:ArrayList<Int>, var loses:ArrayList<Int>, var gameHistoryIds:ArrayList<Int>, name: String, id: Int) : NektorPlayer(name, id) {

    /**
     * Returns the game history of the player.
     *
     * @return The game history of the player.
     */
    fun getHistoryIds(): ArrayList<Int> = gameHistoryIds

    /**
     * Returns the games of the player.
     *
     * @return The games of the player.
     */
    fun getTotalGames(): Int = games.sum()
    /**
     * Returns the wins of the player.
     *
     * @return The wins of the player.
     */
    fun getTotalWins(): Int = wins.sum()
    /**
     * Returns the draws of the player.
     *
     * @return The draws of the player.
     */
    fun getTotalDraws(): Int = draws.sum()
    /**
     * Returns the loses of the player.
     *
     * @return The loses of the player.
     */
    fun getTotalLoses(): Int = loses.sum()

    /**
     * Returns the games of the player in a specific gamemode.
     *
     * @return The games of the player in a specific gamemode.
     */
    fun getGames(pos: Int):Int = games[pos]
    /**
     * Returns the wins of the player in a specific gamemode.
     *
     * @return The wins of the player in a specific gamemode.
     */
    fun getWins(pos: Int):Int = wins[pos]
    /**
     * Returns the draws of the player in a specific gamemode.
     *
     * @return The draws of the player in a specific gamemode.
     */
    fun getDraws(pos: Int):Int = draws[pos]
    /**
     * Returns the loses of the player in a specific gamemode.
     *
     * @return The loses of the player in a specific gamemode.
     */
    fun getLoses(pos: Int):Int = loses[pos]

    /**
     * Returns the total winrate of the player.
     *
     * @return The total winrate of the player.
     */
    fun getTotalWinRate():Float = wins.sum()/games.sum().toFloat()*100
    /**
     * Returns the total drawrate of the player.
     *
     * @return The total drawrate of the player.
     */
    fun getTotalDrawRate():Float = draws.sum()/games.sum().toFloat()*100
    /**
     * Returns the total loserate of the player.
     *
     * @return The total loserate of the player.
     */
    fun getTotalLoseRate():Float = loses.sum()/games.sum().toFloat()*100

    /**
     * Returns the winrate of the player in one gamemmode.
     *
     * @return The winrate of the player in one gamemmode.
     */
    fun getWinRate(pos: Int):Float = wins[pos]/games[pos].toFloat()*100
    /**
     * Returns the drawrate of the player in one gamemmode.
     *
     * @return The drawrate of the player in one gamemmode.
     */
    fun getDrawRate(pos: Int):Float = draws[pos]/games[pos].toFloat()*100
    /**
     * Returns the loserate of the player in one gamemmode.
     *
     * @return The loserate of the player in one gamemmode.
     */
    fun getLoseRate(pos: Int):Float = loses[pos]/games[pos].toFloat()*100

    /**
     * Returns a game player out of this ranked player.
     *
     * @return A game player out of this ranked player.
     */
    fun makeGamePlayer(score: Int): NektorGamePlayer = NektorGamePlayer(score, getName(), getId())

    /**
     * Adds a game to the player.
     */
    fun addGame(game: NektorGameGame){
        //TODO
    }
}