package me.geertjanknapen.PlaytimeBan.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.geertjanknapen.PlaytimeBan.Main;
import utils.Utils;

public class LeaveListener implements Listener {
	@SuppressWarnings("unused")
	private static Main plugin;
	
	public LeaveListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if (p instanceof Player) {
			Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("leave_message").replace("<player>", p.getName())));
		}
	}
}
