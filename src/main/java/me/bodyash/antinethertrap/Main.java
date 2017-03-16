package me.bodyash.antinethertrap;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Main extends JavaPlugin {
  
  public void onDisable() { 
  }
  
  public void onEnable() { 
    BukkitTask TaskName = new looper().runTaskTimerAsynchronously(this, 20L, 80L);
  }
  
}
