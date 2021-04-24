package game

/**
 * A game Score.
 *
 * @constructor Creates an empty score with a specific size.
 * @property size The size of the contender.
 */
class NektorGameScore(size: Int) : ArrayList<Int>(){
    init{
        for(pos in (0..size)){
            this.add(0)
        }
    }


    /**
     * Sets the score of the player to the given score.
     */
    fun setScore(player: Int, score:Int){
        this[player] = score
    }
}