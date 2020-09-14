package me.geertjanknapen.PlaytimeBan.commands;

import me.geertjanknapen.PlaytimeBan.Main;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
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
			p.sendMessage(ChatColor.YELLOW + "Hey daar " + ChatColor.DARK_PURPLE + p.getName() + ChatColor.YELLOW + "!");
			
			// Played since is p.getFirstPlayed();
			Instant date = Instant.ofEpochMilli(p.getFirstPlayed());
			LocalDateTime localtime = LocalDateTime.ofInstant(date, ZoneOffset.systemDefault());
			p.sendMessage(ChatColor.YELLOW + "Je speelt al sinds: " + ChatColor.DARK_PURPLE + localtime + ChatColor.YELLOW + " op deze server.");
		}
		
		return false;
	}
}
