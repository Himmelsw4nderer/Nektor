package game

import base.NektorRuleSet
import ranking.NektorRankingPlayer

object NektorGameGame{
    //all teams and or players are stored here
    var contenders: ArrayList<NektorGameContender> = ArrayList()

    //all played rounds
    var rounds: ArrayList<NektorGameRound> = ArrayList()
    //the round that is played right now
    private var playableRound: NektorGameRound =  newRound()

    //ruleSet of the game
    var ruleSet: NektorRuleSet = NektorRuleSet(0,"standard", ArrayList()) // TODO Standard ruleSet

    fun changeRuleSet(rules: NektorRuleSet){
        this.ruleSet = rules
    }

    //adds a player to the game
    fun addPlayer(player: NektorRankingPlayer, score: Int){
        //adds player to contenders after conversion into Game.GamePlayer
        contenders.add(player.makeGamePlayer(score))

        //creating the a new GameRound format
        playableRound = updateRound()
    }

    //adds a team to the game
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

    //adding a score to a contender
    fun addScore(score: Int, contender: Int, teamMate: Int = 0){
        contenders[contender].addPoints(score, teamMate)

        //if new Round is beginning
        if (playableRound[contender][teamMate] != 0){
            nextRound()
        }
        //adding the score to the round
        playableRound[contender].setScore(teamMate, score)
    }

    //returning the score to a contender
    fun getScore(contender: Int, teamMate: Int? = null): Int{
        if (teamMate == null){
            return contenders[contender].getScore()
        }
        return contenders[contender].getPlayerScore(teamMate)
    }

    //starting a next round
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

    //returning the name of a contender
    fun getName(contender: Int, teamMate: Int? = null): String = contenders[contender].getName(teamMate)

    fun getHistory(): ArrayList<NektorGameRound>{
        var tmp = rounds
        tmp.add(playableRound)
        return tmp
    }
}