package me.bodyash.antinethertrap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Looper extends org.bukkit.scheduler.BukkitRunnable {

	FileConfiguration c;

	public Looper(FileConfiguration c) {
		this.c = c;
	}

	public void run() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			synchronized (p) {
				if (p.getLocation().getBlock().getType() == Material.PORTAL) {
					if (!Vars.playersInPortal.containsKey(p)) {
						Vars.playersInPortal.put(p, Integer.valueOf(7));
					} else if (((Integer) Vars.playersInPortal.get(p)).intValue() <= 1) {
						Location l = p.getLocation();
						if (l.getBlock().getType() == Material.PORTAL) {
							l.getBlock().setType(Material.AIR);
							p.sendMessage(Vars.c(c.getString("trap-deactivated-msg")));
						}
					} else {
						Vars.playersInPortal.put(p,
								Integer.valueOf(((Integer) Vars.playersInPortal.get(p)).intValue() - 1));

						if (((Integer) Vars.playersInPortal.get(p)).intValue() < 5) {
							p.sendMessage(Vars.c(replace(c.getString("trap-found-timer-msg"), p)));
						}

					}
				} else if (Vars.playersInPortal.containsKey(p)) {
					Vars.playersInPortal.remove(p);
				}
			}
		}
	}

	private String replace(String msg, Player pl) {
		msg.replaceAll("%s", ((Integer) Vars.playersInPortal.get(pl)).toString());
		return msg;
	}
}
