package game

class NektorGameRound(lengths: ArrayList<Int>) : ArrayList<NektorGameScore>() {
    init {
        for (length in lengths) {
            this.add(NektorGameScore(length))
        }
    }
}