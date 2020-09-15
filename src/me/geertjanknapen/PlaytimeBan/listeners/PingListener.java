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
		String[] motdArr = 
			{
					"&aSpigot 1.16.2 &6Plugin Test Server",
					"&5Geert-Jan's Plugin Test Paradijs!",
					"&c&bPlugin's?! &d&bWe got 'em!"
			};
		Random rand = new Random();
		int randInt = rand.nextInt(motdArr.length);
		e.setMotd(Utils.chat(motdArr[randInt]));
	}
}
