package me.geertjanknapen.PlaytimeBan.commands;

import me.geertjanknapen.PlaytimeBan.Main;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlaytimeInfoCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
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
		
		if (cmd.getName().equalsIgnoreCase("playtimeinfo")) {
			// Do command stuff
			p.sendMessage("Hey daar " + p.getName() + "!");
			
			// Played since is p.getFirstPlayed();
			Instant date = Instant.ofEpochMilli(p.getFirstPlayed());
			LocalDateTime utc = LocalDateTime.ofInstant(date, ZoneOffset.UTC);
			p.sendMessage("Je speelt al sinds: " + utc);
			return false;
		}
		
		return false;
	}
}
