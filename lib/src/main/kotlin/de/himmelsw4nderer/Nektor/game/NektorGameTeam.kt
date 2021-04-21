package game

class NektorGameTeam (var players: ArrayList<NektorGamePlayer>, val MODE: Int, val name: String) : NektorGameContender {

    companion object {
        const val MODE_EQUAL_SCORE: Int = 0 //Mode when the whole team has one score (Stored in the first player)
        const val MODE_ADD_SCORE: Int = 1 //Mode when the player Score for themself and the team score is all player scores added up
    }

    //adding points to the Base.Player
    override fun addPoints(score: Int, teamMate:Int) {
        super.addPoints(score,teamMate)
        players[teamMate].addPoints(score)
    }

    //returning the teams score
    override fun getScore(): Int{
        super.getScore()
        var score: Int = 0
        //counting together all scores of players
        for(player in players){
            score += player.getScore()
        }
        return score
    }

    //returns the score of a player
    override fun getPlayerScore(teamMate: Int): Int{
        super.getPlayerScore(teamMate)
        return players[teamMate].getScore()
    }

    //returning a BasePlayer
    fun getPlayer(teamMate: Int) = players[teamMate]

    //returning the size of the players so the size of the team
    override fun size(): Int = players.size

    //returning the name of the team or a player
    override fun getName(teamMate: Int?): String {
        super.getName(teamMate)
        if(teamMate == null) {
            return name
        }
        return players[teamMate].getName()
    }
}