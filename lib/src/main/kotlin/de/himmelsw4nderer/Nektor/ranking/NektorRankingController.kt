package ranking

/**
 * A ranking controller.
 *
 * @constructor Creates an empty ranking controller.
 */
class NektorRankingController {
    
     /**
     * The game history.
     */
    var games : ArrayList<NektorRankingGame> = ArrayList()

     /**
     * All Players.
     */
    var players : ArrayList<NektorRankingPlayer> = ArrayList()

    /**
     * All gamemodes.
     */
    var gamemodeIds : ArrayList<String> = ArrayList()

    /**
     * Returns the players sorted by their total winrate.
     *
     * @return The players sorted by their total winrate.
     */
    fun getPlayersByTotalWinRate(): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getTotalDrawRate() })
    /**
     * Returns the players sorted by their total loserate.
     *
     * @return The players sorted by their total loserate.
     */
    fun getPlayersByTotalLoseRate(): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getTotalDrawRate() })
    /**
     * Returns the players sorted by their total drawrate.
     *
     * @return The players sorted by their total drawrate.
     */
    fun getPlayersByTotalDrawRate(): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getTotalDrawRate() })

    /**
     * Returns the players sorted by their winrate in a given gamemode.
     *
     * @return The players sorted by their winrate in a given gamemode.
     */
    fun getPlayersByWinRate(ruleSetId : Int): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getWinRate(ruleSetId) })
    /**
     * Returns the players sorted by their loserate in a given gamemode.
     *
     * @return The players sorted by their loserate in a given gamemode.
     */
    fun getPlayersByLoseRate(ruleSetId : Int): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getLoseRate(ruleSetId) })
    /**
     * Returns the players sorted by their drawrate in a given gamemode.
     *
     * @return The players sorted by their drawrate in a given gamemode.
     */
    fun getPlayersByDrawRate(ruleSetId : Int): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getDrawRate(ruleSetId) })

    /**
     * Returns the players sorted by their total games.
     *
     * @return The players sorted by their total games.
     */
    fun getPlayersByTotalGames(): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getTotalGames() })
    /**
     * Returns the players sorted by their total wins.
     *
     * @return The players sorted by their total wins.
     */
    fun getPlayersByTotalWins(): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getTotalWins() })
    /**
     * Returns the players sorted by their total loses.
     *
     * @return The players sorted by their total loses.
     */
    fun getPlayersByTotalLoses(): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getTotalLoses() })
    /**
     * Returns the players sorted by their total draws.
     *
     * @return The players sorted by their total draws.
     */
    fun getPlayersByTotalDraws(): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getTotalDraws() })

    /**
     * Returns the players sorted by their games in a given gamemode.
     *
     * @return The players sorted by their games in a given gamemode.
     */
    fun getPlayersByGames(ruleSetId : Int): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getGames(ruleSetId) })
    /**
     * Returns the players sorted by their wins in a given gamemode.
     *
     * @return The players sorted by their wins in a given gamemode.
     */
    fun getPlayersByWins(ruleSetId : Int): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getWins(ruleSetId) })
    /**
     * Returns the players sorted by their loses in a given gamemode.
     *
     * @return The players sorted by their loses in a given gamemode.
     */
    fun getPlayersByLoses(ruleSetId : Int): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getLoses(ruleSetId) })
    /**
     * Returns the players sorted by their draws in a given gamemode.
     *
     * @return The players sorted by their draws in a given gamemode.
     */
    fun getPlayersByDraws(ruleSetId : Int): ArrayList<NektorRankingPlayer> = ArrayList(players.sortedBy { it.getDraws(ruleSetId) })

    /**
     * Returns the game history.
     *
     * @return The game history.
     */
    fun getMatchHistory(): ArrayList<NektorRankingGame> = games

    /**
     * Returns the game history of a given player.
     *
     * @return The game history of a given player.
     */
    fun getMatchHistoryByPlayer(playerId : Int): ArrayList<NektorRankingGame>{
        var playerGames : ArrayList<NektorRankingGame> = ArrayList()

        //finding the player fitting to the id
        for (player in players) {
            if(player.getId() == playerId){
                //adding all games that are in the history of the player
                for (game in games) {
                    if(player.getHistoryIds().contains(game.getId())){
                        playerGames.add(game)
                    }
                }
            }
        }
        //returning the list
        return playerGames
    }

    /**
     * Returns the game history of a given ruleset/gamemode.
     *
     * @return The game history of a given ruleset/gamemode.
     */
    fun getMatchHistoryByRuleSet(ruleSetId : Int): ArrayList<NektorRankingGame>{
        var ruleSetGames : ArrayList<NektorRankingGame> = ArrayList()

        //adding every game that has the given ruleset id
        for(game in games) {
            if(game.getRuleSetId() == ruleSetId){
                ruleSetGames.add(game)
            }
        }

        //returning the list
        return ruleSetGames
    }
}