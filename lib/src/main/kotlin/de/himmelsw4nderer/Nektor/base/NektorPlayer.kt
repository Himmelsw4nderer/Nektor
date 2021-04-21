package base

/**
 * A basic Player.
 *
 * @constructor Creates an basic player with name and id.
 * @property name the name of this player.
 * @property id the id of this player.
 */
open class NektorPlayer(var name:String, var id:Int) {
    /**
     * Returns the name of the player.
     *
     * @return The name of the player.
     */
    fun name():String = name
    /**
     * Returns the id of the player.
     *
     * @return The id of the player.
     */
    fun id():Int = id
}