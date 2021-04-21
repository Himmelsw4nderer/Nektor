package base

/**
 * A ruleset or gamemode.
 * 
 * @constructor Creates an basic ruleset with name, id and arguments (rules).
 * @property name The name of this ruleset.
 * @property id The id of this ruleset.
 * @property args The rules of this ruleset.
 */
class NektorRuleSet (var id: Int, var name: String, var args: ArrayList<NektorRule>){

    /**
     * Returns the value of a given rule.
     *
     * @return The value of a given rule.
     */
    fun getRuleValue(pos: Int): Int = args[pos].value

    /**
     * Change the value of a given rule.
     */
    fun changeRuleValue(pos: Int, value: Int){
        args[pos].changeValue(value)
    }
}