package game

import base.NektorPlayer

class NektorGamePlayer(private var score: Int, name: String, id: Int) : NektorPlayer(name, id), NektorGameContender {

    //adding points to the Base.Player
    override fun addPoints(score: Int, teamMate:Int) {
        super.addPoints(score, teamMate)
        this.score += score
    }

    //returning the score
    override fun getScore(): Int{
        super.getScore()
        return score
    }

    //returning the score
    override fun getPlayerScore(teamMate: Int): Int {
        super.getPlayerScore(teamMate)
        return score
    }

    override fun getName(teamMate: Int?): String {
        super.getName(teamMate)
        return name
    }
}