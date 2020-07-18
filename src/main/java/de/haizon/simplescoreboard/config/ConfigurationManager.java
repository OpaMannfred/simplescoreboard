package de.haizon.simplescoreboard.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ConfigurationManager {
	
	private Plugin plugin;
	
	private File configFile;
	private FileConfiguration config;
	private String resourceName;
	
	public ConfigurationManager(String resourceName, Plugin instance) {
		this.plugin = instance;
		this.resourceName = resourceName;
	}
	
	public void setupConfig() {
		try {
			yamlsetup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void yamlsetup()
	throws Exception{
	    this.configFile = new File(plugin.getDataFolder(), resourceName);
	    this.config = new YamlConfiguration();
	    if (!this.configFile.exists()){
	    	this.configFile.getParentFile().mkdirs();
	    	copy(plugin.getResource(resourceName), this.configFile);
		}
	    configLoad();
	}
	
	private void configLoad()
	throws Exception{
		try{
			config.load(configFile);
	    }
		catch (Exception e){
			e.printStackTrace();
	    }
	}
	
	private void copy(InputStream in, File file){
		try{
			OutputStream out = new FileOutputStream(file);
		    	byte[] buf = new byte[1024];
		    	int len;
		    	while ((len = in.read(buf)) > 0){
		    		out.write(buf, 0, len);
		    	}
		    out.close();
		    in.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
