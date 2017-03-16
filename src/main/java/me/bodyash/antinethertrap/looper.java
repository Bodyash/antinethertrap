package me.bodyash.antinethertrap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class looper extends org.bukkit.scheduler.BukkitRunnable {

  
  
  public void run() {
    if (!Bukkit.getOnlinePlayers().isEmpty()) {
      for (Player p : Bukkit.getOnlinePlayers()) {
        if (p.getLocation().getBlock().getType() == Material.PORTAL) {
          if (!vars.playersInPortal.containsKey(p)) {
            vars.playersInPortal.put(p, Integer.valueOf(7));
          }
          else if (((Integer)vars.playersInPortal.get(p)).intValue() <= 1) {
            if (p.getLocation().getBlock().getType() == Material.PORTAL) {
              p.getLocation().getBlock().setType(Material.AIR);
              p.sendMessage(vars.c("Ловушка &aдеактивированна"));
            }
          } else {
            vars.playersInPortal.put(p, Integer.valueOf(((Integer)vars.playersInPortal.get(p)).intValue() - 1));
            
            if (((Integer)vars.playersInPortal.get(p)).intValue() < 5) {
            	 p.sendMessage(vars.c("Ловушка &cобнаружена&r, де-активация через " + ((Integer)vars.playersInPortal.get(p)).toString()));
            }
            
          }
        }
        else if (vars.playersInPortal.containsKey(p))
        {
          vars.playersInPortal.remove(p);
        }
      }
    }
  }
}
