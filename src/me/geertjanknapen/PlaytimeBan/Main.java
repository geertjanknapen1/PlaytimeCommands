package me.geertjanknapen.PlaytimeBan;

import org.bukkit.plugin.java.JavaPlugin;

import me.geertjanknapen.PlaytimeBan.commands.PlaytimeInfoCommand;
import me.geertjanknapen.PlaytimeBan.listeners.JoinListener;
import me.geertjanknapen.PlaytimeBan.listeners.LeaveListener;
import me.geertjanknapen.PlaytimeBan.listeners.PingListener;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new PlaytimeInfoCommand(this);
		new JoinListener(this);
		new LeaveListener(this);
		new PingListener(this);
	}
}
