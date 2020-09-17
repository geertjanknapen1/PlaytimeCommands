package me.geertjanknapen.PlaytimeBan.listeners;

import java.util.Random;

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
		// Create an array with some motd's and a random to select a random motd
		Random rand = new Random();
		int randInt = rand.nextInt(4);
		e.setMotd(Utils.chat(plugin.getConfig().getString("motd_" + randInt)));
	}
}
