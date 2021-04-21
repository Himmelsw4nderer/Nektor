// lib/src/main/kotlin/de/himmelsw4nderer/nektor/game/NektorGameGame.kt
package game

import base.NektorRuleSet
import ranking.NektorRankingPlayer

/**
 * A basic game
 *
 * @constructor creates a empty Game
 */

object NektorGameGame{

    //all teams and or players are stored here
    var contenders: ArrayList<NektorGameContender> = ArrayList()

    //all played rounds
    var rounds: ArrayList<NektorGameRound> = ArrayList()
    //the round that is played right now
    private var playableRound: NektorGameRound =  newRound()

    //ruleSet of the game
    var ruleSet: NektorRuleSet = NektorRuleSet(0,"standard", ArrayList()) // TODO Standard ruleSet


    /**
     * changes the ruleset of the game to [rules]
     */
    fun changeRuleSet(rules: NektorRuleSet){
        this.ruleSet = rules
    }

    /**
     * adds [player] to the game with [score]
     */
    fun addPlayer(player: NektorRankingPlayer, score: Int){
        //adds player to contenders after conversion into Game.GamePlayer
        contenders.add(player.makeGamePlayer(score))

        //creating the a new GameRound format
        playableRound = updateRound()
    }

    /**
     * adds a team of [playersRaw] to the game with [scores], a [mode] and a [name] 
     */
    fun addTeam(playersRaw: ArrayList<NektorRankingPlayer>, scores: ArrayList<Int>, mode: Int, name: String){
        //list of players for the team
        val players: ArrayList<NektorGamePlayer> = ArrayList()
        //converting all players to GamePlayers
        var index = 0
        while(index < playersRaw.size){
            players.add(playersRaw[index].makeGamePlayer(scores[index]))
            index++
        }
        //creating the Team and add it to the contenders
        contenders.add(NektorGameTeam(players, mode, name))

        //creating the a new GameRound format
        playableRound = updateRound()
    }

    /**
     * adding the [score] to the contender with position [contender] of contender and if possible teammate with position [teamMate] of the teammate 
     */
    fun addScore(score: Int, contender: Int, teamMate: Int = 0){
        contenders[contender].addPoints(score, teamMate)

        //if new Round is beginning
        if (playableRound[contender][teamMate] != 0){
            nextRound()
        }
        //adding the score to the round
        playableRound[contender].setScore(teamMate, score)
    }

    /**
     * takes the position [contender] of contender and the position [teamMate] of teammate if possible
     *
     * @return the score of the contender or the score of the teammate from the contender
     */
    fun getScore(contender: Int, teamMate: Int? = null): Int{
        if (teamMate == null){
            return contenders[contender].getScore()
        }
        return contenders[contender].getPlayerScore(teamMate)
    }

    /**
     * starting a new round
     */
    fun nextRound(){
        rounds.add(playableRound)
        playableRound = newRound()
    }

    //creating a new gameRound regarding the type and so on of the contenders
    private fun newRound() : NektorGameRound{
        //Array of the lengths from each contender
        var lengths: ArrayList<Int> = ArrayList()

        //adding the lengths from each contender to the array
        for (contender in contenders) {
            lengths.add(contender.size())
        }

        //returning the gameRound made out of the Array
        return NektorGameRound(lengths)
    }

    //Updates the current round to fit the new contender Count
    private fun updateRound(): NektorGameRound {
        var newRound = newRound()
        var pos = 0
        while (pos < playableRound.size){
            newRound[pos] = playableRound[pos]
            pos++
        }
        return newRound
    }

    /**
     * takes the position [contender] of contender and the position [teamMate] of teammate if possible
     *
     * @return the name of the contender or the score of the teammate from the contender
     */
    fun getName(contender: Int, teamMate: Int? = null): String = contenders[contender].getName(teamMate)

    /**
     * @return the history of rounds that are played
     */
    fun getHistory(): ArrayList<NektorGameRound>{
        //adding round that ios currently running
        var tmp = rounds
        tmp.add(playableRound)
        //returning the Array
        return tmp
    }

    /**
     * @return the amount of rounds that are played
     */
    fun getRoundCount() = getHistory().size

}