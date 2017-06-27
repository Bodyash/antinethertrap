package me.bodyash.antinethertrap;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private FileConfiguration c;

	public void onDisable() {
	}

	public void onEnable() {

		if (!new File(getDataFolder(), "config.yml").exists()) {
			saveDefaultConfig();
		}
		c = getConfig();
		long delay = (c.getInt("check-interval") * 20);
		if (c.getBoolean("async")){
			new Looper(c).runTaskTimerAsynchronously(this, 20L, delay);
		}else{
			new Looper(c).runTaskTimer(this, 20L, delay);
		}
		
	}

}
