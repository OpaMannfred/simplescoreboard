package de.haizon.simplescoreboard.utils;

import com.google.common.base.Charsets;
import de.haizon.simplescoreboard.SimpleScoreboard;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/***************************************************
 * Hinweise                                        
 * Copyright © Max H. 2020                          
 * Erstellt: 06.07.2020 / 20:15
 **************************************************/

public class FileReader {

    private String FILE_DIR;
    private String FILE_NAME;

    private static File file;
    public static File dir;
    public static YamlConfiguration cfg;

    public FileReader(String FILE_DIR, String FILE_NAME) {
        this.FILE_DIR = FILE_DIR;
        this.FILE_NAME = FILE_NAME;
        dir = new File("plugins//" + FILE_DIR);
        file = new File("plugins//" + FILE_DIR, FILE_NAME);
        cfg = YamlConfiguration.loadConfiguration(file);
    }

    public String readWithoutColor(String RAW_CONTENT){
        return cfg.getString(RAW_CONTENT);
    }

    public boolean readWithBoolean(String RAW_CONTENT){
        return cfg.getBoolean(RAW_CONTENT);
    }

    public int readWithInteger(String RAW_CONTENT){
        return cfg.getInt(RAW_CONTENT);
    }

    public long readWithLong(String RAW_CONTENT){
        return cfg.getLong(RAW_CONTENT);
    }


    public List readWithList(String RAW_CONTENT){
        return cfg.getStringList(RAW_CONTENT);
    }

    public String readWithColor(String RAW_CONTENT){
        return cfg.getString(RAW_CONTENT).replace('&', '§');
    }

    public boolean isFileExisting(){
        return file.exists();
    }

    public boolean isDirExists(){
        return dir.exists();
    }

    public void createDir(){
        if(!isDirExists()){
            dir.mkdir();
        }
    }

    public void createFile(){
        if(!isFileExisting()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void reload(){
        cfg = YamlConfiguration.loadConfiguration(file);
        InputStream defaultConfigStream = SimpleScoreboard.getInstance().getResource("config.yml");
        if (defaultConfigStream != null) {
            cfg.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defaultConfigStream, Charsets.UTF_8)));
        }
    }
}
