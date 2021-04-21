package game

/**
 * A game Score.
 *
 * @constructor Creates an empty score with a specific size.
 * @property size The size of the contender.
 */
class NektorGameScore(size: Int) : ArrayList<Int>(){
    init{
        var pos = 0
        while(pos < size){
            this.add(0)
            pos++
        }
    }


    /**
     * Sets the score of the player to the given score.
     */
    fun setScore(player: Int, score:Int){
        this[player] = score
    }
}