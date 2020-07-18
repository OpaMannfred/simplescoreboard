package de.haizon.simplescoreboard.utils;

import de.haizon.simplescoreboard.SimpleScoreboard;

import java.util.List;

/**********************************************************************************
 *     Urheberrechtshinweis                                                       *
 *     Copyright @ Max H. 2020                                                    *
 *     Erstellt: 18.07.2020 / 20:23                                            *
 *                                                                                *
 *     Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.           *
 *     Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,   *
 *     bei Max H. Alle Rechte vorbehalten.                                        *
 *                                                                                *
 *     Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,        *
 *     öffentlichen Zugänglichmachen oder andere Nutzung                          *
 *     bedarf der ausdrücklichen, schriftlichen Zustimmung von Max H.             *
 *********************************************************************************/

public class Data {

    public static List<String> list = SimpleScoreboard.getInstance().getFileReader().readWithList("scoreboard.list");
    public static String title = SimpleScoreboard.getInstance().getFileReader().readWithColor("scoreboard.title");

}
