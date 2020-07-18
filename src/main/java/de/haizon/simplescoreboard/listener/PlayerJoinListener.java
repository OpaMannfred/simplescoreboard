package de.haizon.simplescoreboard.listener;

import de.haizon.simplescoreboard.utils.Data;
import de.haizon.simplescoreboard.utils.ScoreHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**********************************************************************************
 *     Urheberrechtshinweis                                                       *
 *     Copyright @ Max H. 2020                                                    *
 *     Erstellt: 18.07.2020 / 20:10                                            *
 *                                                                                *
 *     Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.           *
 *     Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,   *
 *     bei Max H. Alle Rechte vorbehalten.                                        *
 *                                                                                *
 *     Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,        *
 *     öffentlichen Zugänglichmachen oder andere Nutzung                          *
 *     bedarf der ausdrücklichen, schriftlichen Zustimmung von Max H.             *
 *********************************************************************************/

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        ScoreHandler.setScoreboard(player, Data.list, Data.title);
    }

}
