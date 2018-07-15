package com.santipingui58.spleef.menu.esp;



import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.listener.VotifierListener;
import com.santipingui58.spleef.menu.MenuBuilder;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;




public class VoteMenu extends MenuBuilder {

	public VoteMenu(Player p) {
		super("§b§lVota por el Server", 5);
		
		ItemStack discord = Main.getSkull("http://textures.minecraft.net/texture/7873c12bffb5251a0b88d5ae75c7247cb39a75ff1a81cbe4c8a39b311ddeda");
		SkullMeta discordMeta = (SkullMeta) discord.getItemMeta();
		List<String> lore_discord = new ArrayList<String>();
		lore_discord.add("§cLas recompensas aun no están implementadas!");
		//lore_discord.add("§7Join our Discord Server and win:");
		//lore_discord.add("§7- §a100 SpleefEXP Points");
		//lore_discord.add("§7- §bSplinBox #5");
		discordMeta.setLore(lore_discord);
		discordMeta.setDisplayName("§9Entra al Servidor de Discord");
		discord.setItemMeta(discordMeta);
		
		ItemStack twitter = Main.getSkull("http://textures.minecraft.net/texture/dcb76166d1e1e449457b5c4436b3f48b7d768ac60f19e2c6b25ea42c4bad7c");
		SkullMeta twitterMeta = (SkullMeta) twitter.getItemMeta();
		List<String> lore_twitter = new ArrayList<String>();
		lore_twitter.add("§cLas recompensas aun no están implementadas!");
		//lore_twitter.add("§7Join our Discord Server and win:");
		//lore_twitter.add("§7- §a100 SpleefEXP Points");
		//lore_twitter.add("§7- §bSplinBox #5");
		twitterMeta.setLore(lore_twitter);
		twitterMeta.setDisplayName("§bSíguenos en Twitter");
		twitter.setItemMeta(twitterMeta);
		
		ItemStack youtube = Main.getSkull("http://textures.minecraft.net/texture/b4353fd0f86314353876586075b9bdf0c484aab0331b872df11bd564fcb029ed");
		SkullMeta youtubeMeta = (SkullMeta) youtube.getItemMeta();
		List<String> lore_youtube = new ArrayList<String>();
		lore_youtube.add("§cLas recompensas aun no están implementadas!");
		//lore_youtube.add("§7Join our Discord Server and win:");
		//lore_youtube.add("§7- §a100 SpleefEXP Points");
		//lore_youtube.add("§7- §bSplinBox #5");
		youtubeMeta.setLore(lore_youtube);
		youtubeMeta.setDisplayName("§cSuscríbete a nuestro canal de Youtube");
		youtube.setItemMeta(youtubeMeta);
		
		ItemStack retweet = Main.getSkull("http://textures.minecraft.net/texture/dcb76166d1e1e449457b5c4436b3f48b7d768ac60f19e2c6b25ea42c4bad7c");
		SkullMeta retweetMeta = (SkullMeta) retweet.getItemMeta();
		List<String> lore_retweet = new ArrayList<String>();
		lore_retweet.add("§cLas recompensas aun no están implementadas!");
		//lore_retweet.add("§7Join our Discord Server and win:");
		//lore_retweet.add("§7- §a100 SpleefEXP Points");
		//lore_retweet.add("§7- §bSplinBox #5");
		retweetMeta.setLore(lore_retweet);
		retweetMeta.setDisplayName("§bRetwittea el Server");
		retweet.setItemMeta(retweetMeta);
		
		ItemStack video = Main.getSkull("http://textures.minecraft.net/texture/70b569b6ac365d5a41f5cad072ff506af2397265249e2d55f89bac94e0c8");
		SkullMeta videoMeta = (SkullMeta) video.getItemMeta();
		List<String> lore_video = new ArrayList<String>();
		lore_video.add("§cLas recompensas aun no están implementadas!");
		//lore_video.add("§7Join our Discord Server and win:");
		//lore_video.add("§7- §a100 SpleefEXP Points");
		//lore_video.add("§7- §bSplinBox #5");
		videoMeta.setLore(lore_video);
		videoMeta.setDisplayName("§cMira un video");
		video.setItemMeta(videoMeta);
		
		ItemStack namemc = Main.getSkull("http://textures.minecraft.net/texture/685269937ad7ac59d986dfbee8b3d2cf4dff8ba2be18c876b3a9c849e7a1f2");
		SkullMeta namemcMeta = (SkullMeta) namemc.getItemMeta();
		List<String> lore_namemc = new ArrayList<String>();
		if (!Main.votes.getConfig().contains("namemcvotes."+p.getUniqueId())) {
		lore_namemc.add("§7Danos like en NameMC y gana:");
		lore_namemc.add("§7- §a50 SpleefEXP Points");
		lore_namemc.add("§7- §bSplinBox #4");
		lore_namemc.add("§7- §6100 Coins ");
		lore_namemc.add("§cAdvertencia§7: Esta opción es solo para usuarios §bPremium");
		} else {
			lore_namemc.add("§cYa nos has dado like en NameMC");
		}
		
		namemcMeta.setLore(lore_namemc);
		namemcMeta.setDisplayName("§aDanos like en NameMC");
		namemc.setItemMeta(namemcMeta);
		

		s(29, discord);
		s(30, twitter);
		s(22, video);
		s(31,namemc);
		s(32, retweet);
		s(33,youtube);
		
		ItemStack minecraftservers;
		ItemStack planetminecraft;
		ItemStack minecraftMP;
		ItemStack cuarentaservidores;
		ItemStack topg;
		
		if (Main.votes.getConfig().contains("players."+p.getName()+".minecraftservers")) {
			minecraftservers = new ItemStack(Material.COAL);
			ItemMeta minecraftserversMeta = minecraftservers.getItemMeta();
			minecraftserversMeta.setDisplayName("§cVota en MinecraftServers");
			List<String> lore = new ArrayList<String>();
			lore.add("§cPuedes volver a votar en: " + VotifierListener.minutesToHours(Main.votes.getConfig()
					.getInt("players."+p.getName()+".minecraftservers")));
			minecraftserversMeta.setLore(lore);
			minecraftservers.setItemMeta(minecraftserversMeta);
		} else {
		minecraftservers = new ItemStack(Material.DIAMOND);
		ItemMeta minecraftserversMeta = minecraftservers.getItemMeta();
		minecraftserversMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		minecraftserversMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		minecraftserversMeta.setDisplayName("§aVota en MinecraftServers");
		List<String> lore = new ArrayList<String>();
		 lore.add("§7Rewards:");
		 lore.add("§7- §a10 SpleefEXP Points");
		 lore.add("§7- §650 Coins");
		 int votestoday = 0;
			if (Main.votes.getConfig().contains("players."+p.getName()+".votestoday")) {
				 votestoday = Main.votes.getConfig().getInt("players."+p.getName()+".votestoday");
			}
		 if (p.hasPermission("splindux.vote.5")) {
			 lore.add("§7- §b1 Ranked");
		 } else if (p.hasPermission("splindux.vote.4")) {
			 if (votestoday<4) {
				 lore.add("§7- §b1 Ranked");
			 }
		 } else {
			 if (votestoday<3) {
				 lore.add("§7- §b1 Ranked");
			 }
		 }
		 minecraftserversMeta.setLore(lore);
		minecraftservers.setItemMeta(minecraftserversMeta);
		}
		
		if (Main.votes.getConfig().contains("players."+p.getName()+".planetminecraft")) {
			planetminecraft = new ItemStack(Material.COAL);
			ItemMeta planetminecraftMeta = planetminecraft.getItemMeta();
			planetminecraftMeta.setDisplayName("§cVota en PlanetMinecraft");
			List<String> lore = new ArrayList<String>();
			lore.add("§cPuedes volver a votar en: " + VotifierListener.minutesToHours(Main.votes.getConfig()
					.getInt("players."+p.getName()+".planetminecraft")));
			planetminecraftMeta.setLore(lore);
			planetminecraft.setItemMeta(planetminecraftMeta);
		} else {
			planetminecraft = new ItemStack(Material.DIAMOND);
		ItemMeta planetminecraftMeta = planetminecraft.getItemMeta();
		planetminecraftMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		planetminecraftMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		planetminecraftMeta.setDisplayName("§aVota en PlanetMinecraft");
		List<String> lore = new ArrayList<String>();
		 lore.add("§7Rewards:");
		 lore.add("§7- §a10 SpleefEXP Points");
		 lore.add("§7- §650 Coins");
		 int votestoday = 0;
			if (Main.votes.getConfig().contains("players."+p.getName()+".votestoday")) {
				 votestoday = Main.votes.getConfig().getInt("players."+p.getName()+".votestoday");
			}
		 if (p.hasPermission("splindux.vote.5")) {
			 lore.add("§7- §b1 Ranked");
		 } else if (p.hasPermission("splindux.vote.4")) {
			 if (votestoday<4) {
				 lore.add("§7- §b1 Ranked");
			 }
		 } else {
			 if (votestoday<3) {
				 lore.add("§7- §b1 Ranked");
			 }
		 }
		 planetminecraftMeta.setLore(lore);
		planetminecraft.setItemMeta(planetminecraftMeta);
		}
		
		
		if (Main.votes.getConfig().contains("players."+p.getName()+".minecraftMP")) {
			minecraftMP = new ItemStack(Material.COAL);
			ItemMeta minecraftMPMeta = minecraftMP.getItemMeta();
			minecraftMPMeta.setDisplayName("§cVota en MinecraftMP");
			List<String> lore = new ArrayList<String>();
			lore.add("§cPuedes volver a votar en: " + VotifierListener.minutesToHours(Main.votes.getConfig()
					.getInt("players."+p.getName()+".minecraftMP")));
			minecraftMPMeta.setLore(lore);
			minecraftMP.setItemMeta(minecraftMPMeta);
			
		} else {
			minecraftMP = new ItemStack(Material.DIAMOND);
		ItemMeta minecraftMPMeta = minecraftMP.getItemMeta();
		minecraftMPMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		minecraftMPMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		minecraftMPMeta.setDisplayName("§aVota en MinecraftMP");
		List<String> lore = new ArrayList<String>();
		 lore.add("§7Rewards:");
		 lore.add("§7- §a10 SpleefEXP Points");
		 lore.add("§7- §650 Coins");
		 int votestoday = 0;
			if (Main.votes.getConfig().contains("players."+p.getName()+".votestoday")) {
				 votestoday = Main.votes.getConfig().getInt("players."+p.getName()+".votestoday");
			}
		 if (p.hasPermission("splindux.vote.5")) {
			 lore.add("§7- §b1 Ranked");
		 } else if (p.hasPermission("splindux.vote.4")) {
			 if (votestoday<4) {
				 lore.add("§7- §b1 Ranked");
			 }
		 } else {
			 if (votestoday<3) {
				 lore.add("§7- §b1 Ranked");
			 }
		 }
		 minecraftMPMeta.setLore(lore);
		minecraftMP.setItemMeta(minecraftMPMeta);
		}
		
		
		
		if (Main.votes.getConfig().contains("players."+p.getName()+".40servidores")) {
			cuarentaservidores = new ItemStack(Material.COAL);
			ItemMeta cuarentaservidoresMeta = cuarentaservidores.getItemMeta();
			cuarentaservidoresMeta.setDisplayName("§cVota en 40Servidores");
			List<String> lore = new ArrayList<String>();
			lore.add("§cPuedes volver a votar en: " + VotifierListener.minutesToHours(Main.votes.getConfig()
					.getInt("players."+p.getName()+".40servidores")));
			cuarentaservidoresMeta.setLore(lore);
			cuarentaservidores.setItemMeta(cuarentaservidoresMeta);
		} else {
			cuarentaservidores = new ItemStack(Material.DIAMOND);
		ItemMeta cuarentaservidoresMeta = cuarentaservidores.getItemMeta();
		cuarentaservidoresMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		cuarentaservidoresMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		cuarentaservidoresMeta.setDisplayName("§cVota en 40Servidores");
		List<String> lore = new ArrayList<String>();
		lore.add("§cComing soon!");
		cuarentaservidoresMeta.setLore(lore);
		cuarentaservidores.setItemMeta(cuarentaservidoresMeta);
		}
		
		
		if (Main.votes.getConfig().contains("players."+p.getName()+".topg")) {
			topg = new ItemStack(Material.COAL);
			ItemMeta topgMeta = topg.getItemMeta();
			topgMeta.setDisplayName("§cVota en TopG");
			List<String> lore = new ArrayList<String>();
			lore.add("§cPuedes volver a votar en: " + VotifierListener.minutesToHours(Main.votes.getConfig()
					.getInt("players."+p.getName()+".topg")));
			topgMeta.setLore(lore);
			topg.setItemMeta(topgMeta);
		} else {
			topg = new ItemStack(Material.DIAMOND);
		ItemMeta topgMeta = topg.getItemMeta();
		topgMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		topgMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		topgMeta.setDisplayName("§aVota en TopG");
		List<String> lore = new ArrayList<String>();
		 lore.add("§7Recompensas:");
		 lore.add("§7- §a10 SpleefEXP Points");
		 lore.add("§7- §650 Coins");
		 int votestoday = 0;
			if (Main.votes.getConfig().contains("players."+p.getName()+".votestoday")) {
				 votestoday = Main.votes.getConfig().getInt("players."+p.getName()+".votestoday");
			}
		 if (p.hasPermission("splindux.vote.5")) {
			 lore.add("§7- §b1 Ranked");
		 } else if (p.hasPermission("splindux.vote.4")) {
			 if (votestoday<4) {
				 lore.add("§7- §b1 Ranked");
			 }
		 } else {
			 if (votestoday<3) {
				 lore.add("§7- §b1 Ranked");
			 }
		 }
		 topgMeta.setLore(lore);
		topg.setItemMeta(topgMeta);
		}
		
		
		
		s(11, minecraftservers);	
		s(12,planetminecraft);
		s(13,minecraftMP);
		s(14,cuarentaservidores);
		s(15, topg);
		
	
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot==11) {
			if (Main.votes.getConfig().contains("players."+p.getName()+".minecraftservers")) {
					p.sendMessage("§e§lSplin§b§lDux§5§lVotes §cYa has votado aquí hoy.");
			} else {
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
				TextComponent message = new TextComponent("Click para ir a MinecraftServers");
				message.setColor( ChatColor.GREEN );
				message.setBold( true );
				message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "http://minecraftservers.org/vote/488043"));
				
				message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bVota en MinecraftServers!").create() ) );
				p.spigot().sendMessage( message);
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
			}
			p.closeInventory();
		} else if (slot==12) {
			if (Main.votes.getConfig().contains("players."+p.getName()+".planetminecraft")) {
					p.sendMessage("§e§lSplin§b§lDux§5§lVotes §cYa has votado aquí hoy.");
			} else {
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
				TextComponent message = new TextComponent("Click para ir a PlanetMinecraft");
				message.setColor( ChatColor.GREEN );
				message.setBold( true );
				message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "https://www.planetminecraft.com/server/splindux/vote/"));
				
				message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bVota en Minecraft-MP").create() ) );
				p.spigot().sendMessage( message);
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
			}
			p.closeInventory();
		} else if (slot==13) {
			if (Main.votes.getConfig().contains("players."+p.getName()+".minecraftMP")) {
					p.sendMessage("§e§lSplin§b§lDux§5§lVotes §cYa has votado aquí hoy.");
			} else {
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
				TextComponent message = new TextComponent("Click para ir a Minecraft-MP");
				message.setColor( ChatColor.GREEN );
				message.setBold( true );
				message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "http://minecraft-mp.com/server/189229/vote/"));
				
				message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bVota en Minecraft-MP!").create() ) );
				p.spigot().sendMessage( message);
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
			}
			
			p.closeInventory();
		} else if (slot==15) {
			if (Main.votes.getConfig().contains("players."+p.getName()+".topg")) {
				p.sendMessage("§e§lSplin§b§lDux§5§lVotes §cYa has votado aquí hoy.");
		} else {
			p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
			TextComponent message = new TextComponent("Click para ir a TopG");
			message.setColor( ChatColor.GREEN );
			message.setBold( true );
			message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "https://topg.org/Minecraft/in-486086"));
			
			message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bVota en TopG!").create() ) );
			p.spigot().sendMessage( message);
			p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
		}
		
		p.closeInventory();
	} else if (slot == 29) {
			p.closeInventory();
			p.sendMessage("§9Discord Server: §e§lhttps://discord.gg/JkbCaxf");
		} else if (slot == 30) {
			p.closeInventory();
			p.sendMessage("§bTwitter: §e§lhttps://twitter.com/SplinduxServer");
		} else if (slot == 31) {
			p.closeInventory();
			p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
			TextComponent message = new TextComponent("Click para ir a NameMC");
			message.setColor( ChatColor.GREEN );
			message.setBold( true );
			message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "https://es.namemc.com/server/mc.splindux.com"));
			
			message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bVota en NameMC!").create() ) );
			p.spigot().sendMessage( message);
			p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
			
			p.sendMessage("§7Necesitas crearte una cuenta en NameMC si no tienes una, y posteriormente darle like al server.");
			p.sendMessage("§7Una vez hecho esto, haz click en el botón de abajo");
			TextComponent button = new TextComponent("§6§l[Reclamar recompensa]");
			button.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/votenamemc"));
			button.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bHaz click una vez votado en NameMC!").create() ) );
			p.spigot().sendMessage( button);	
			
		}else if (slot == 33) {
			p.closeInventory();
			p.sendMessage("§cYoutube: §e§lhttps://www.youtube.com/c/SantiPingui58");
		}
	}
	

}
