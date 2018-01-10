package com.santipingui58.spleef.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.santipingui58.spleef.managers.DataManager;

public class HeadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, final String[] args) {
		
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
	
		if(cmd.getName().equalsIgnoreCase("head")){
			final Player p = (Player) sender;
			if (p.hasPermission("splindux.head")) {
				if (args.length == 0) {
					
					 ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);       
				        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
				        headMeta.setOwner(p.getName());
				        head.setItemMeta(headMeta);
				        p.getInventory().setHelmet(head);
				       
				        if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				        	p.sendMessage("§aAhora estas usando la cabeza de §6 " + p.getName());
				        } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				        	p.sendMessage("§aNow you are wearing the head of §6 " + p.getName());
				        }
				        
				} else {
					if (args[0].equalsIgnoreCase("clear")) {
						  p.getInventory().setHelmet(null);
					} else {
						 if (args[0].length() <= 16) {
					ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);       
			        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
			        headMeta.setOwner(args[0]);
			        head.setItemMeta(headMeta);
			        p.getInventory().setHelmet(head);
			        
			        if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			        	p.sendMessage("§aAhora estas usando la cabeza de §6 " + args[0]);
			        } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			        	p.sendMessage("§aNow you are wearing the head of §6 " + args[0]);
			        }
			        
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				        	p.sendMessage("§cEse nombre es demasiado largo.");
				        } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				        	p.sendMessage("§cThat name is too long");
				        }
					}
					}
				}
				
				
				
			}  else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNo tienes permiso para ejecutar este comando.");
					p.sendMessage("§aNecesitass un rango "
							+ "§a§l[VIP]§a o superior para poder usar esto, visita la tienda para más información: §bhttp://splinduxstore.buycraft.net/");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou don't have permission to execute this command.");
					p.sendMessage("§aYou need a rank "
							+ "§a§l[VIP] §aor higher to use this, visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
				
				} 
			} 
		}
		}
		
		return false;
			}
	
	
	
}
