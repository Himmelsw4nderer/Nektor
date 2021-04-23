package base

/**
 * A basic Player.
 *
 * @constructor Creates an basic player with name and id.
 * @property name The name of this player.
 * @property id The id of this player.
 */
open class NektorPlayer(private var name:String, private var id:Int) {
    /**
     * Returns the name of the player.
     *
     * @return The name of the player.
     */
    fun getName():String = name
    /**
     * Returns the id of the player.
     *
     * @return The id of the player.
     */
    fun getId():Int = id
}