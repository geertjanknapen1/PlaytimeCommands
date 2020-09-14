package me.geertjanknapen.PlaytimeBan.commands;

import me.geertjanknapen.PlaytimeBan.Main;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlaytimeInfoCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	private long t;
	
	HashMap<UUID, Long> time = new HashMap<UUID, Long>();
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		time.put(event.getPlayer().getUniqueId(), System.currentTimeMillis());
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		t = System.currentTimeMillis() - time.get(p.getUniqueId());
		
	}
	
	public PlaytimeInfoCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("playtimeinfo").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Alleen spelers mogen dit commando gebruiken!");
			return true;
		}
		
		Player p = (Player) sender;
		
		String timePlayed = convertMapWithIteration(time);
		
		if (cmd.getName().equalsIgnoreCase("playtimeinfo")) {
			// Do command stuff
			p.sendMessage("Hey daar " + p.getName() + "!");
			
			// Played since is p.getFirstPlayed();
			Instant date = Instant.ofEpochMilli(p.getFirstPlayed());
			LocalDateTime localtime = LocalDateTime.ofInstant(date, ZoneOffset.systemDefault());
			p.sendMessage("Je speelt al sinds: " + localtime);
			
			p.sendMessage(timePlayed);
			return false;
		}
		
		return false;
	}
	
	public String convertMapWithIteration(HashMap<UUID, Long> map) {
		StringBuilder mapAsString = new StringBuilder("{");
		for (UUID key : map.keySet()) {
			mapAsString.append(key + "=" + map.get(key) + ", ");
		}
		mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
		return mapAsString.toString();
	}

}
