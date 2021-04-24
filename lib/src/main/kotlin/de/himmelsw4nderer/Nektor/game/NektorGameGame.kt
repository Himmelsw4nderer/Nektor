package game

import base.NektorRuleSet
import base.NektorRule
import ranking.NektorRankingPlayer

/**
 * A basic game.
 *
 * @constructor Creates a empty Game.
 */

object NektorGameGame{

    /**
     * All teams and or players are stored here.
     */
    var contenders: ArrayList<NektorGameContender> = ArrayList()

    /**
     * All played rounds.
     */
    var rounds: ArrayList<NektorGameRound> = ArrayList()
    /**
     * The round that is played right now.
     */
    private var playableRound: NektorGameRound =  newRound()

    /**
     * Ruleset of the game.
     */
    var ruleSet: NektorRuleSet = NektorRuleSet(0,"standard", ArrayList()) // TODO Standard ruleSet


    /**
     * Changes the ruleset of the game to rules.
     */
    fun changeRuleSet(ruleSet: NektorRuleSet){
        this.ruleSet = ruleSet
    }

    /**
     * Adds a player to the game with score.
     */
    fun addPlayer(player: NektorRankingPlayer, score: Int = ruleSet.getRuleValue(NektorRule.RULE_START_SCORE)){
        //adds player to contenders after conversion into Game.GamePlayer
        contenders.add(player.makeGamePlayer(score))

        //creating the a new GameRound format
        playableRound = updateRound()
    }

    /**
     * Adds a team of players to the game with scores, a mode and a name.
     */
    fun addTeam(players: ArrayList<NektorRankingPlayer>, mode: Int, name: String , scores: ArrayList<Int>? = null){
        var finalScores = ArrayList<Int>()
        //if there is no scores input
        if(scores == null){
            //adding standard value
            for(player in players){
                finalScores.add(ruleSet.getRuleValue(NektorRule.RULE_START_SCORE))
            }
        } else {
            finalScores = scores
        }

        //list of players for the team
        val teamMembers: ArrayList<NektorGamePlayer> = ArrayList()
        //converting all players to GamePlayers
        var index = 0
        while(index < players.size){
            teamMembers.add(players[index].makeGamePlayer(finalScores[index]))
            index++
        }
        //creating the Team and add it to the contenders
        contenders.add(NektorGameTeam(teamMembers, mode, name))

        //creating the a new GameRound format
        playableRound = updateRound()
    }

    /**
     * Adding the score to the contender and if possible teamMate.
     */
    fun addScore(score: Int, contender: Int, teamMate: Int = 0){

        //applying multiply rule
        var finalScore = score * ruleSet.getRuleValue(NektorRule.RULE_SCORE_MULTIPLY)

        contenders[contender].addPoints(finalScore, teamMate)

        //if new Round is beginning
        if (playableRound[contender][teamMate] != 0){
            nextRound()
        }
        //adding the score to the round
        playableRound[contender].setScore(teamMate, finalScore)
    }

    /**
     * Returns the score of contender or teamMate if possible.
     *
     * @return The score of the contender or the score of the teammate.
     */
    fun getScore(contender: Int, teamMate: Int? = null): Int{
        if (teamMate == null){
            return contenders[contender].getScore()
        }
        return contenders[contender].getPlayerScore(teamMate)
    }

    /**
     * Returns the name of the contender or the teamMate if possible.
     *
     * @return The name of the contender or the name of the teamMate.
     */
    fun getName(contender: Int, teamMate: Int? = null): String = contenders[contender].getName(teamMate)

    /**
     * Starting a new round.
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
        for (pos in (0..playableRound.size-1)){
            newRound[pos] = playableRound[pos]
        }
        return newRound
    }

    /**
     * Returns the history of rounds that are played.
     *
     * @return The history of rounds that are played.
     */
    fun getHistory(): ArrayList<NektorGameRound>{
        //adding round that ios currently running
        var completeHistory = rounds
        completeHistory.add(playableRound)
        //returning the Array
        return completeHistory
    }

    /**
     * Returns the amount of rounds that are played.
     *
     * @return The amount of rounds that are played.
     */
    fun getRoundCount() = getHistory().size

    /**
     * Returns the contenders sorted due to the score.
     *
     * @return The contenders sorted due to the score.
     */
    fun getContendersByStandings(): ArrayList<NektorGameContender>{

        var sortedContenders = ArrayList(contenders.sortedBy { it.getScore() })

        //returning the Array according to the rules of the lowest score wins
        if(ruleSet.getRuleValue(NektorRule.RULE_LOWEST_SCORE_WINS) == NektorRule.RULE_BOOL_TRUE){
            return sortedContenders
        } else {
            //reversing the array and returning
            return kotlin.collections.ArrayList(sortedContenders.reversed())
        }
 
    }
}