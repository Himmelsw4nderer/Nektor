package ranking

import game.NektorGamePlayer
import base.NektorPlayer
import game.NektorGameGame

class NektorRankingPlayer (var games:ArrayList<Int>, var wins:ArrayList<Int>, var draws:ArrayList<Int>, var loses:ArrayList<Int>, name: String, id: Int) : NektorPlayer(name, id), NektorRankingContender {

    //variables for total wins
    var totalGames: Int = total(games)
    var totalWins: Int = total(wins)
    var totalDraws: Int = total(draws)
    var totalLoses: Int = total(loses)

    //returning total wins, games, draws, loses
    fun totalGames(): Int = totalGames
    fun totalWins(): Int = totalWins
    fun totalDraws(): Int = totalDraws
    fun totalLoses(): Int = totalLoses

    //returning games, wins, draws, loses of a specific gameMode
    fun games(pos: Int):Int = games[pos]
    fun wins(pos: Int):Int = wins[pos]
    fun draws(pos: Int):Int = draws[pos]
    fun loses(pos: Int):Int = loses[pos]

    //returning win-, lose- and and drawRate
    fun winRate(pos: Int):Float = wins[pos]/games[pos].toFloat()*100
    fun drawRate(pos: Int):Float = draws[pos]/games[pos].toFloat()*100
    fun loseRate(pos: Int):Float = loses[pos]/games[pos].toFloat()*100


    //calculating a total out of Int Array
    private fun total(array: ArrayList<Int>): Int{
        var total = 0
        for (int in array) {
            total += int
        }
        return total
    }

    //start an instance of Game.GamePlayer out of a Ranking.RankingPlayer
    fun makeGamePlayer(score: Int): NektorGamePlayer = NektorGamePlayer(score, name, id)

    //adds a game to the Players stats
    fun addGame(game: NektorGameGame){
        //TODO
    }
}