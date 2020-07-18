package de.haizon.simplescoreboard;

import de.haizon.simplescoreboard.config.ConfigurationManager;
import de.haizon.simplescoreboard.listener.PlayerJoinListener;
import de.haizon.simplescoreboard.utils.FileReader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**********************************************************************************
 *     Urheberrechtshinweis                                                       *
 *     Copyright @ Max H. 2020                                                    *
 *     Erstellt: 18.07.2020 / 20:01                                            *
 *                                                                                *
 *     Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.           *
 *     Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,   *
 *     bei Max H. Alle Rechte vorbehalten.                                        *
 *                                                                                *
 *     Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,        *
 *     öffentlichen Zugänglichmachen oder andere Nutzung                          *
 *     bedarf der ausdrücklichen, schriftlichen Zustimmung von Max H.             *
 *********************************************************************************/

public class SimpleScoreboard extends JavaPlugin {

    private static SimpleScoreboard instance;
    private static FileReader fileReader;
    private ConfigurationManager pluginConfig;

    public void onEnable(){
        instance = this;
        setupConfig();
        fileReader = new FileReader("SimpleScoreboard", "config.yml");
        if(!fileReader.isDirExists() && !fileReader.isFileExisting()){
            fileReader.createDir();
            fileReader.createFile();
            setupConfig();
        }
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        } else {
            throw new RuntimeException("Could not find PlaceholderAPI!! Plugin can not work without it!");
        }

    }

    public void setupConfig(){
        pluginConfig = new ConfigurationManager("config.yml", this);
        pluginConfig.setupConfig();
    }

    public static SimpleScoreboard getInstance() {
        return instance;
    }

    public static FileReader getFileReader() {
        return fileReader;
    }
}
