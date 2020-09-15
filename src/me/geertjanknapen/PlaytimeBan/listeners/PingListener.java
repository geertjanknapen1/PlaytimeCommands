package me.geertjanknapen.PlaytimeBan.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.geertjanknapen.PlaytimeBan.Main;
import utils.Utils;

public class PingListener implements Listener{
	@SuppressWarnings("unused")
	private static Main plugin;
	
	public PingListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPing(ServerListPingEvent e) {
		e.setMotd(Utils.chat("&aSpigot 1.16.2 &7Plugin Test Server"));
	}
}
