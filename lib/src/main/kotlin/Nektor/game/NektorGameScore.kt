package game

class NektorGameScore(length: Int) : ArrayList<Int>(){
    init{
        var pos = 0
        while(pos < length){
            this.add(0)
            pos++
        }
    }

    fun setScore(player: Int, score:Int){
        this[player] = score
    }
}