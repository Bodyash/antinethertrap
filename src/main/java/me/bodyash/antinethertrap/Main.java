package me.bodyash.antinethertrap;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Main extends JavaPlugin {

	private FileConfiguration c;

	public void onDisable() {
	}

	public void onEnable() {

		if (!new File(getDataFolder(), "config.yml").exists()) {
			saveDefaultConfig();
		}
		c = getConfig();
		long delay = (c.getInt("place-idle-time") * 20);
		BukkitTask TaskName = new Looper(c).runTaskTimerAsynchronously(this, 20L, delay);
	}

}
