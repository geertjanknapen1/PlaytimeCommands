package me.geertjanknapen.PlaytimeBan;

import org.bukkit.plugin.java.JavaPlugin;

import me.geertjanknapen.PlaytimeBan.commands.PlaytimeInfoCommand;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		new PlaytimeInfoCommand(this);
	}
}
