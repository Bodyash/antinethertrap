package me.bodyash.antinethertrap;

import java.util.HashMap;

public class vars
{
  public vars() {}
  
  public static String c(String chat) {
    String message = org.bukkit.ChatColor.translateAlternateColorCodes('&', chat);
    return message;
  }
  
  public static HashMap<org.bukkit.entity.Player, Integer> playersInPortal = new HashMap();
}
