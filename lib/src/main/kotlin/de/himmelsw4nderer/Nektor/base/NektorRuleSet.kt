package base

class NektorRuleSet (var id: Int, var name: String, var args: ArrayList<NektorRule>){

    //returns the ruleValue
    fun getRuleValue(pos: Int): Int = args[pos].value

    //Change the rules value
    fun changeRuleValue(pos: Int, value: Int){
        args[pos].changeValue(value)
    }
}