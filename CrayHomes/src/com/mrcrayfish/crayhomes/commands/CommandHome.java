package com.mrcrayfish.crayhomes.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.mrcrayfish.crayhomes.CrayHomes;
import com.mrcrayfish.crayhomes.main.HomeGUI;

public class CommandHome implements CommandExecutor
{

	CrayHomes plugin = null;

	public CommandHome(CrayHomes plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3)
	{
		if (!(sender instanceof Player))
		{
			return true;
		}

		if (!plugin.config.useCompass)
		{
			if (CrayHomes.perms.has((Player) sender, "crayhomes.use") | sender.isOp())
			{
				Player player = (Player) sender;
				player.openInventory(HomeGUI.createHomeInventory(plugin, player));
				return true;
			}
			else
			{
				sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
				return true;
			}
		}
		else
		{
			sender.sendMessage(ChatColor.RED + "CrayHomes is using the Compass instead.");
		}
		return false;
	}

}
