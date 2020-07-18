package de.haizon.simplescoreboard.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**********************************************************************************
 *     Urheberrechtshinweis                                                       *
 *     Copyright @ Max H. 2020                                                    *
 *     Erstellt: 18.07.2020 / 20:02                                            *
 *                                                                                *
 *     Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.           *
 *     Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,   *
 *     bei Max H. Alle Rechte vorbehalten.                                        *
 *                                                                                *
 *     Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,        *
 *     öffentlichen Zugänglichmachen oder andere Nutzung                          *
 *     bedarf der ausdrücklichen, schriftlichen Zustimmung von Max H.             *
 *********************************************************************************/

public class ScoreHandler {

    public static void setScoreboard(Player p, List<String> l, String name){
        List<String> lines = new ArrayList<>();
        lines.addAll(l);
        ScoreboardManager sm = Bukkit.getScoreboardManager();
        Scoreboard s = sm.getNewScoreboard();
        Objective o = s.registerNewObjective("abc", "dummy");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        Collections.reverse(lines);
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.equals("  ")) {
                line = " &" + (i / 10) + "&" + (i % 10) + " ";
            } else {
                line = line;
            }
            String rewriteLine = PlaceholderAPI.setPlaceholders(p, line);
            line = ChatColor.translateAlternateColorCodes('&', rewriteLine);
            o.getScore(PlaceholderAPI.setPlaceholders(p, line)).setScore(i);
        }
        p.setScoreboard(s);
    }

}
