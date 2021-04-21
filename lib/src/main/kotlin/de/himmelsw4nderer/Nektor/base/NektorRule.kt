package base

/**
 * A rule.
 * 
 * @constructor Creates an basic rule with name, id and value.
 * @property name The name of this rule.
 * @property id The id of this rule.
 * @property value The value of this rule.
 */
class NektorRule(var id: Int, var name: String?, var value:Int){

    companion object {
        const val RULE_START_SCORE: Int = 0 //This Rule sets the starting score value (saved as int)
        const val RULE_SCORE_MODE: Int = 1 //This Rule sets if the score should add up or reduce or both or something else (saved in int as mode ids)
    }

    /**
     * Change the value of this rule.
     */
    fun changeValue(value: Int){
        this.value = value
    }
}