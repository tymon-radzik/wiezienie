package com.radzik.wiezienie;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Wiezienie extends JavaPlugin {

  @Override
    public void onEnable(){
        getLogger().info("Enabled !");
    }
 
    @Override
    public void onDisable() {
    	getLogger().info("Disabled !");
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if(cmd.getName().equalsIgnoreCase("zamknij") && args.length == 1){ 
    		Player player = (Player) sender;
    		Player target = player.getServer().getPlayer(args[0]);
    		if (target.isOnline())
    		{
    			Location location = new Location(target.getWorld(), 445, 52, -645);
        		target.teleport(location);
        		target.sendMessage("Użytkownik " + player.getDisplayName() + ChatColor.RED + " zamknął " + target.getDisplayName() + " w więzieniu !");
        		player.sendMessage("Zamknięto użytkownika " + target.getDisplayName() + ChatColor.RED + " w więzieniu !");
        		return true;			
    		}
    		else
    		{
    			
    			player.sendMessage(ChatColor.RED + "Podany przez Ciebie użytkownik - " + ChatColor.GREEN + target.getDisplayName() + ChatColor.RED +  " - nie jest online !");
    			
    		}
    		
    	} 
    	if(cmd.getName().equalsIgnoreCase("uwolnij") && args.length == 1){ 
    		Player player = (Player) sender;
    		Player target = player.getServer().getPlayer(args[0]);
    		if (target.isOnline())
    		{
    			Location location = new Location(target.getWorld(), 520, 52, -664);
        		target.teleport(location);
        		getLogger().info("Użytkownik " + player.getDisplayName() + ChatColor.GREEN + " wypuścił " + target.getDisplayName() + " z więzienia !");
        		target.sendMessage("Użytkownik " + player.getDisplayName() + ChatColor.GREEN + " wypuścił Cię z więzienia !");
        		player.sendMessage("Uwolniono użytkownika " + target.getDisplayName() + ChatColor.GREEN + " z więzienia !");
        		return true;
    		}
    		else 
    		{
    			player.sendMessage(ChatColor.RED + "Podany przez Ciebie użytkownik - " + ChatColor.GREEN + target.getDisplayName() + ChatColor.RED +  " - nie jest online !");
    			
    		}
    		
    	}
    	
    	return false; 
    }


	
}
