package ranking

/**
 * A ranking game.
 *
 * @constructor Creates an gsme out of the given id, ruleset, contenders and rounds.
 * @property id The id of the game.
 * @property ruleSetId The id of the gamemode/ruleset.
 * @property contenderIds The id of players.
 * @property rounds The rounds of the game.
 */
class NektorRankingGame(private var id: Int, private var ruleSetId: Int, contenderIds: ArrayList<ArrayList<Int>>, history: ArrayList<ArrayList<Int>>) {

    /**
     * Returns the id.
     *
     * @return The id.
     */
    fun getId(): Int = id

    /**
     * Returns the ruleset id.
     *
     * @return The ruleset id.
     */
    fun getRuleSetId(): Int = ruleSetId
}