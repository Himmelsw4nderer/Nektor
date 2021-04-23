package base

/**
 * A rule.
 * 
 * @constructor Creates an basic rule with name, id and value.
 * @property name The name of this rule.
 * @property id The id of this rule.
 * @property value The value of this rule.
 */
class NektorRule(private var value:Int){

    companion object {
        /**
         * This rulevalue is equal to true
         */
        const val RULE_BOOL_TRUE = 1
        /**
         * This rulevalue is equal to false
         */
        const val RULE_BOOL_FALSE = 0


        /**
         * This rule sets the starting score value (saved as int)
         */
        const val RULE_START_SCORE: Int = 0
        /**
         * This rule sets if the score should add up or reduce or both or something else (saved in int as mode ids)
         */
        const val RULE_SCORE_MODE: Int = 1
        /**
         * This rule sets if the highest score wins (can be 0 for highest and 1 for lowest)
         */
        const val RULE_LOWEST_SCORE_WINS: Int = 2
    }

    /**
     * Change the value of this rule.
     */
    fun changeValue(value: Int){
        this.value = value
    }

    /**
     * Returns the value of this rule.
     * 
     * @return The value of this rule.
     */
    fun getValue(): Int = value
}