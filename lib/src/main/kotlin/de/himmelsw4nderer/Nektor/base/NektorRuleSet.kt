package base

/**
 * A ruleset or gamemode.
 * 
 * @constructor Creates an basic ruleset with name, id and arguments (rules).
 * @property name The name of this ruleset.
 * @property id The id of this ruleset.
 * @property rules The rules of this ruleset.
 */
class NektorRuleSet (var id: Int, var name: String, var rules: ArrayList<NektorRule>){

    companion object {
        /**
         * This string saves the standard ruleset
         */
        const val BASIC_RULE_SET_STRING = "0;basic_0|0|0"
    }

    /**
     * Returns the value of a given rule.
     *
     * @return The value of a given rule.
     */
    fun getRuleValue(pos: Int): Int = rules[pos].getValue()

    /**
     * Change the value of a given rule.
     */
    fun changeRuleValue(pos: Int, value: Int){
        rules[pos].changeValue(value)
    }

    /**
     * Returns a ruleset from a data string.
     *
     * @return A ruleset from a data string
     */
    fun setRuleSetFromString(string: String) : NektorRuleSet{

        //spliting the prefix from the rules
        var strings = string.split("_")

        //splitting the string on |
        var rulesString = strings[1].split("|")

        var rules: ArrayList<NektorRule> = ArrayList()
        //splitting the rules and adding them to the list
        for(rule in rulesString){
            rules.add(NektorRule(rule.toInt()))
        }

        return NektorRuleSet(rulesString[0].toInt(), rulesString[1], rules)
    }
}