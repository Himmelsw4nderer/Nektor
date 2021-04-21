package game

/**
 * A game Round.
 *
 * @constructor Creates an empty round with a specific length.
 * @property lengths The size of each contender.
 */
class NektorGameRound(lengths: ArrayList<Int>) : ArrayList<NektorGameScore>() {
    init {
        for (length in lengths) {
            this.add(NektorGameScore(length))
        }
    }
}