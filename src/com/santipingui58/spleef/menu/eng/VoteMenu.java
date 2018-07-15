package com.santipingui58.spleef.menu.eng;



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
		super("§b§lVote the Server", 5);
		
		ItemStack discord = Main.getSkull("http://textures.minecraft.net/texture/7873c12bffb5251a0b88d5ae75c7247cb39a75ff1a81cbe4c8a39b311ddeda");
		SkullMeta discordMeta = (SkullMeta) discord.getItemMeta();
		List<String> lore_discord = new ArrayList<String>();
		lore_discord.add("§cRewards are not implemented yet!");
		//lore_discord.add("§7Join our Discord Server and win:");
		//lore_discord.add("§7- §a100 SpleefEXP Points");
		//lore_discord.add("§7- §bSplinBox #5");
		discordMeta.setLore(lore_discord);
		discordMeta.setDisplayName("§9Join Discord Server");
		discord.setItemMeta(discordMeta);
		
		ItemStack twitter = Main.getSkull("http://textures.minecraft.net/texture/dcb76166d1e1e449457b5c4436b3f48b7d768ac60f19e2c6b25ea42c4bad7c");
		SkullMeta twitterMeta = (SkullMeta) twitter.getItemMeta();
		List<String> lore_twitter = new ArrayList<String>();
		lore_twitter.add("§cRewards are not implemented yet!");
		//lore_twitter.add("§7Join our Discord Server and win:");
		//lore_twitter.add("§7- §a100 SpleefEXP Points");
		//lore_twitter.add("§7- §bSplinBox #5");
		twitterMeta.setLore(lore_twitter);
		twitterMeta.setDisplayName("§bFollow us in Twitter");
		twitter.setItemMeta(twitterMeta);
		
		ItemStack youtube = Main.getSkull("http://textures.minecraft.net/texture/b4353fd0f86314353876586075b9bdf0c484aab0331b872df11bd564fcb029ed");
		SkullMeta youtubeMeta = (SkullMeta) youtube.getItemMeta();
		List<String> lore_youtube = new ArrayList<String>();
		lore_youtube.add("§cRewards are not implemented yet!");
		//lore_youtube.add("§7Join our Discord Server and win:");
		//lore_youtube.add("§7- §a100 SpleefEXP Points");
		//lore_youtube.add("§7- §bSplinBox #5");
		youtubeMeta.setLore(lore_youtube);
		youtubeMeta.setDisplayName("§cSuscribe to our Youtube Channel");
		youtube.setItemMeta(youtubeMeta);
		
		ItemStack retweet = Main.getSkull("http://textures.minecraft.net/texture/dcb76166d1e1e449457b5c4436b3f48b7d768ac60f19e2c6b25ea42c4bad7c");
		SkullMeta retweetMeta = (SkullMeta) retweet.getItemMeta();
		List<String> lore_retweet = new ArrayList<String>();
		lore_retweet.add("§cRewards are not implemented yet!");
		//lore_retweet.add("§7Join our Discord Server and win:");
		//lore_retweet.add("§7- §a100 SpleefEXP Points");
		//lore_retweet.add("§7- §bSplinBox #5");
		retweetMeta.setLore(lore_retweet);
		retweetMeta.setDisplayName("§bRetweet the Server");
		retweet.setItemMeta(retweetMeta);
		
		ItemStack video = Main.getSkull("http://textures.minecraft.net/texture/70b569b6ac365d5a41f5cad072ff506af2397265249e2d55f89bac94e0c8");
		SkullMeta videoMeta = (SkullMeta) video.getItemMeta();
		List<String> lore_video = new ArrayList<String>();
		lore_video.add("§cRewards are not implemented yet!");
		//lore_video.add("§7Join our Discord Server and win:");
		//lore_video.add("§7- §a100 SpleefEXP Points");
		//lore_video.add("§7- §bSplinBox #5");
		videoMeta.setLore(lore_video);
		videoMeta.setDisplayName("§cWatch a Video");
		video.setItemMeta(videoMeta);
		
		ItemStack namemc = Main.getSkull("http://textures.minecraft.net/texture/685269937ad7ac59d986dfbee8b3d2cf4dff8ba2be18c876b3a9c849e7a1f2");
		SkullMeta namemcMeta = (SkullMeta) namemc.getItemMeta();
		List<String> lore_namemc = new ArrayList<String>();
		if (!Main.votes.getConfig().contains("namemcvotes."+p.getUniqueId())) {
		lore_namemc.add("§7Like us at NameMC and win:");
		lore_namemc.add("§7- §a50 SpleefEXP Points");
		lore_namemc.add("§7- §bSplinBox #4");
		lore_namemc.add("§7- §6100 Coins ");
		lore_namemc.add("§cWarning§7: This option is only for §bPremium §7account players");
		} else {
			lore_namemc.add("§cYou already liked us at NameMC");
		}
		
		namemcMeta.setLore(lore_namemc);
		namemcMeta.setDisplayName("§aLike us at NameMC");
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
			minecraftserversMeta.setDisplayName("§cVote in MinecraftServers");
			List<String> lore = new ArrayList<String>();
			lore.add("§cYou can vote again in: " + VotifierListener.minutesToHours(Main.votes.getConfig()
					.getInt("players."+p.getName()+".minecraftservers")));
			minecraftserversMeta.setLore(lore);
			minecraftservers.setItemMeta(minecraftserversMeta);
		} else {
		minecraftservers = new ItemStack(Material.DIAMOND);
		ItemMeta minecraftserversMeta = minecraftservers.getItemMeta();
		minecraftserversMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		minecraftserversMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		minecraftserversMeta.setDisplayName("§aVote at MinecraftServers");
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
			planetminecraftMeta.setDisplayName("§cVote in PlanetMinecraft");
			List<String> lore = new ArrayList<String>();
			lore.add("§cYou can vote again in: " + VotifierListener.minutesToHours(Main.votes.getConfig()
					.getInt("players."+p.getName()+".planetminecraft")));
			planetminecraftMeta.setLore(lore);
			planetminecraft.setItemMeta(planetminecraftMeta);
		} else {
			planetminecraft = new ItemStack(Material.DIAMOND);
		ItemMeta planetminecraftMeta = planetminecraft.getItemMeta();
		planetminecraftMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		planetminecraftMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		planetminecraftMeta.setDisplayName("§aVote at PlanetMinecraft");
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
			minecraftMPMeta.setDisplayName("§cVote at MinecraftMP");
			List<String> lore = new ArrayList<String>();
			lore.add("§cYou can vote again in: " + VotifierListener.minutesToHours(Main.votes.getConfig()
					.getInt("players."+p.getName()+".minecraftMP")));
			minecraftMPMeta.setLore(lore);
			minecraftMP.setItemMeta(minecraftMPMeta);
			
		} else {
			minecraftMP = new ItemStack(Material.DIAMOND);
		ItemMeta minecraftMPMeta = minecraftMP.getItemMeta();
		minecraftMPMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		minecraftMPMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		minecraftMPMeta.setDisplayName("§aVote at MinecraftMP");
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
			cuarentaservidoresMeta.setDisplayName("§cVote at 40Servidores");
			List<String> lore = new ArrayList<String>();
			lore.add("§cYou can vote again in: " + VotifierListener.minutesToHours(Main.votes.getConfig()
					.getInt("players."+p.getName()+".40servidores")));
			cuarentaservidoresMeta.setLore(lore);
			cuarentaservidores.setItemMeta(cuarentaservidoresMeta);
		} else {
			cuarentaservidores = new ItemStack(Material.DIAMOND);
		ItemMeta cuarentaservidoresMeta = cuarentaservidores.getItemMeta();
		cuarentaservidoresMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		cuarentaservidoresMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		cuarentaservidoresMeta.setDisplayName("§cVote at 40Servidores");
		List<String> lore = new ArrayList<String>();
		lore.add("§cComing soon!");
		cuarentaservidoresMeta.setLore(lore);
		cuarentaservidores.setItemMeta(cuarentaservidoresMeta);
		}
		
		
		if (Main.votes.getConfig().contains("players."+p.getName()+".topg")) {
			topg = new ItemStack(Material.COAL);
			ItemMeta topgMeta = topg.getItemMeta();
			topgMeta.setDisplayName("§cVote at TopG");
			List<String> lore = new ArrayList<String>();
			lore.add("§cYou can vote again in: " + VotifierListener.minutesToHours(Main.votes.getConfig()
					.getInt("players."+p.getName()+".topg")));
			topgMeta.setLore(lore);
			topg.setItemMeta(topgMeta);
		} else {
			topg = new ItemStack(Material.DIAMOND);
		ItemMeta topgMeta = topg.getItemMeta();
		topgMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		topgMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		topgMeta.setDisplayName("§aVote at TopG");
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
					p.sendMessage("§e§lSplin§b§lDux§5§lVotes §cYou have already voted here today.");
			} else {
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
				TextComponent message = new TextComponent("Click to go to MinecraftServers");
				message.setColor( ChatColor.GREEN );
				message.setBold( true );
				message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "http://minecraftservers.org/vote/488043"));
				
				message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bVote at MinecraftServers!").create() ) );
				p.spigot().sendMessage( message);
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
			}
			p.closeInventory();
		} else if (slot==12) {
			if (Main.votes.getConfig().contains("players."+p.getName()+".planetminecraft")) {
					p.sendMessage("§e§lSplin§b§lDux§5§lVotes §cYou have already voted here today.");
			} else {
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
				TextComponent message = new TextComponent("Click to go to PlanetMinecraft");
				message.setColor( ChatColor.GREEN );
				message.setBold( true );
				message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "https://www.planetminecraft.com/server/splindux/vote/"));
				
				message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bVote at Minecraft-MP").create() ) );
				p.spigot().sendMessage( message);
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
			}
			p.closeInventory();
		} else if (slot==13) {
			if (Main.votes.getConfig().contains("players."+p.getName()+".minecraftMP")) {
					p.sendMessage("§e§lSplin§b§lDux§5§lVotes §cYou have already voted here today.");
			} else {
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
				TextComponent message = new TextComponent("Click to go to Minecraft-MP");
				message.setColor( ChatColor.GREEN );
				message.setBold( true );
				message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "http://minecraft-mp.com/server/189229/vote/"));
				
				message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bVote at Minecraft-MP!").create() ) );
				p.spigot().sendMessage( message);
				p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
			}
			
			p.closeInventory();
		} else if (slot==15) {
			if (Main.votes.getConfig().contains("players."+p.getName()+".topg")) {
				p.sendMessage("§e§lSplin§b§lDux§5§lVotes §cYou have already voted here today.");
		} else {
			p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
			TextComponent message = new TextComponent("Click to go to TopG");
			message.setColor( ChatColor.GREEN );
			message.setBold( true );
			message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "https://topg.org/Minecraft/in-486086"));
			
			message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bVote at TopG!").create() ) );
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
			TextComponent message = new TextComponent("Click to go to NameMC");
			message.setColor( ChatColor.GREEN );
			message.setBold( true );
			message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "https://es.namemc.com/server/mc.splindux.com"));
			
			message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bVote at NameMC!").create() ) );
			p.spigot().sendMessage( message);
			p.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-");
			
			p.sendMessage("§7You need to create an account at NameMC if you don't have one, then like for the server.");
			p.sendMessage("§7Once you did this, click in the button below");
			TextComponent button = new TextComponent("§6§l[Claim Reward]");
			button.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/votenamemc"));
			button.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bClick here once you voted for us at NameMC!").create() ) );
			p.spigot().sendMessage( button);	
			
		}else if (slot == 33) {
			p.closeInventory();
			p.sendMessage("§cYoutube: §e§lhttps://www.youtube.com/c/SantiPingui58");
		}
	}
	

}
