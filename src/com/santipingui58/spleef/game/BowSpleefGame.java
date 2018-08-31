package com.santipingui58.spleef.game;



import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.EconomyManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.managers.SpleefRankManager;
import com.santipingui58.spleef.utils.Scoreboard;

public class BowSpleefGame implements Listener  {




public static int task;
  public static ItemStack bow = new ItemStack(Material.BOW);
  
  
  
	  @SuppressWarnings("deprecation")
	public static void startCountdown(String id) {
		  
		  
		  ItemMeta meta = bow.getItemMeta();
	      meta.spigot().setUnbreakable(true);
	      meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	      bow.setItemMeta(meta);
	      bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
	      bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
	      
	     final Game g = GameManager.getManager().getArena(id);
	     final Player  p1 = g.getPlayer1().get(0);
	     final Player  p2 = g.getPlayer2().get(0);
	     p1.setFlying(false);
	     p2.setFlying(false);
	     p1.setAllowFlight(false);
	     p2.setAllowFlight(false);
	     p1.teleport(g.getSpawn1());
	     p2.teleport(g.getSpawn2());
	     p1.setGameMode(GameMode.SURVIVAL);
	     p2.setGameMode(GameMode.SURVIVAL);
	     
	     if (DataManager.getNightVision(p1)) {
	    	 p1.addPotionEffect(new PotionEffect (PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
	     }
	     
	     if (DataManager.getNightVision(p2)) {
	    	 p2.addPotionEffect(new PotionEffect (PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
	     }
	     
	     
	     p1.getInventory().clear();
	     p2.getInventory().clear();
	     new BukkitRunnable() {
				@Override
				public void run() {				
					p1.getInventory().addItem(bow);				
					p2.getInventory().addItem(bow);
			      
				}
			}.runTaskLater(Main.get(), 3L);	
	      
	      
	      new Scoreboard().createScoreboardGame(p1);
        	new Scoreboard().createScoreboardGame(p2);
	  
        	GameManager.getManager().Countdown(g);

	  }
	  
	  
	  public static void gameOver(Player ganador, Player perdedor, String id) {
	  	
		  Player player1 = null;
		  Player player2 = null;
		  Game g = GameManager.getManager().getArena(id);
		  g.falseCanPlay();
		  GameManager.getManager().getInGameArenas().remove(g);
		  try {
	  		   player1 = g.getPlayer1().get(0);
	  		   player2 = g.getPlayer2().get(0);
	  		  
	  		  g.resetRounds();
	  		  GameManager.getManager().reinicio(g);
	  		Iterator<Game> i = GameManager.getManager().getInGameArenas().iterator();
			while (i.hasNext()) {
				Game ga = i.next();
				if (ga.equals(g)) {
					i.remove();
				}
				
			}
	  		  g.resetTime();
		  } catch (Exception e) {}
		  
	  		  if (ganador == null && perdedor == null) {
	  			try {
					  for (Player p1 : g.getPlayer1()) {
						  p1.teleport(Main.getLoc(Main.arena.get("lobby"), true));
						  Main.giveItems(p1);
					  }
					  
					for (Player p2 : g.getPlayer2()) {
						  p2.teleport(Main.getLoc(Main.arena.get("lobby"), true));
						  Main.giveItems(p2);

					
					  }
				  } catch (Exception e) {}
				
				g.resetPoints();
				 g.getPlayer1().clear();
				 g.getPlayer2().clear();
				 
	  		  } else if (g.getPoints1() >= 5) {


	  			  
	  			SpleefRankManager.giveExp(perdedor,1);
  	  			SpleefRankManager.giveExp(ganador, 3);
  	  			EconomyManager.addCoins(ganador, 10,true);
  	  			EconomyManager.addCoins(perdedor, 1,true);
		  		   for (Player sp : g.getSpectators()) {
		  			 sp.sendMessage("§3[BowSpleef] §a" + ganador.getName() + " §7le ha ganado a §c" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
		  		   }
	  				  ganador.sendMessage("§3[BowSpleef] §aLe has ganado a §b" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  				  
	  				perdedor.sendMessage("§3[BowSpleef] §cHas perdido contra §a" + ganador.getName() 
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  				
	  				  perdedor.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  ganador.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  g.resetPoints();
	  					  g.getPlayer1().clear();
	  					  g.getPlayer2().clear();
	  					  
	  				  
	  				  Main.giveItems(ganador);
	  				  Main.giveItems(perdedor);
	  					
	  			  } else if (g.getPoints2() >= 5) {

	  				SpleefRankManager.giveExp(perdedor,1);
	  	  			SpleefRankManager.giveExp(ganador, 3);
	  	  		EconomyManager.addCoins(ganador, 10,true);
  	  			EconomyManager.addCoins(perdedor, 1,true);
	  	  			
	  	  		   for (Player sp : g.getSpectators()) {
	  	  			 sp.sendMessage("§3[BowSpleef] §a" + ganador.getName() + " §7le ha ganado a §c" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  	  		   }
	  				  ganador.sendMessage("§3[BowSpleef] §aLe has ganado a §b" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  				  
	  				perdedor.sendMessage("§3[BowSpleef] §cHas perdido contra §a" + ganador.getName() 
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  				
	  				  perdedor.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  ganador.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  
	  				 g.resetPoints();
	  				 g.getPlayer1().clear();
	  				 g.getPlayer2().clear();
	  				Main.giveItems(ganador);
	  				  Main.giveItems(perdedor);

	  					
	  			  } else if (ganador == player1) {
	  				  
	  				SpleefRankManager.giveExp(perdedor,1);
	  	  			SpleefRankManager.giveExp(ganador, 3);
	  	  		EconomyManager.addCoins(ganador, 10,true);
  	  			EconomyManager.addCoins(perdedor, 1,true);
	  	  		   
	  	  		   for (Player sp : g.getSpectators()) {
	  	  			   sp.sendMessage("§3[BowSpleef] §a" + ganador.getName() + " §7le ha ganado a §c" + perdedor.getName() 
		  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  	  		   }
	  	  		   
	  				  ganador.sendMessage("§3[BowSpleef] §aLe has ganado a §b" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  				  
	  				perdedor.sendMessage("§3[BowSpleef] §cHas perdido contra §a" + ganador.getName() 
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  				
	  				  perdedor.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  ganador.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  
	  				 g.resetPoints();
	  				 g.getPlayer1().clear();
	  				 g.getPlayer2().clear();

	  				Main.giveItems(ganador);
	  				  Main.giveItems(perdedor);  
	  				  
	  				  
	  			  } else if (ganador == player2) {
	  				  
	  				
	  				SpleefRankManager.giveExp(perdedor,1);
	  	  			SpleefRankManager.giveExp(ganador, 3);
	  	  		EconomyManager.addCoins(ganador, 10,true);
  	  			EconomyManager.addCoins(perdedor, 1,true);
  	  			
	  				  ganador.sendMessage("§3[BowSpleef] §aLe has ganado a §b" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  				  
	  				perdedor.sendMessage("§3[BowSpleef] §cHas perdido contra §a" + ganador.getName() 
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  				
	  				for (Player sp : g.getSpectators()) {
		  			  	 sp.sendMessage("§3[BowSpleef] §a" + ganador.getName() + " §7le ha ganado a §c" + perdedor.getName() 
		  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
		  			  	}
	  				
	  				  perdedor.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  ganador.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  
	  				  g.resetPoints();
	  				 g.getPlayer1().clear();
	  				 g.getPlayer2().clear();
	  				 
	  				 
	  				Main.giveItems(ganador);
	  				Main.giveItems(perdedor);
	  				  
	  			  } else {
	  				  try {
	  					  for (Player p1 : g.getPlayer1()) {
	  						  p1.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  						  Main.giveItems(p1);
	  					  }
	  					  
	  					for (Player p2 : g.getPlayer2()) {
	  						  p2.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  						  Main.giveItems(p2);
	  					  }
	  					
	  				  } catch (Exception e) {}
	  				
	  				g.resetPoints();
	  				 g.getPlayer1().clear();
	  				 g.getPlayer2().clear();
	  				 for (Player po : Bukkit.getOnlinePlayers()) {
	  					 new Scoreboard().createScoreboard(po);
	  				 }
	  			  }
	  		
	  		 for (Player sp : g.getSpectators()) {
	  			  if (g.getSpectators().size() >= 1) {
	  			//		sp.performCommand("spect leave");
		  			  	 Main.giveItems(sp);
		  			   sp.setGameMode(GameMode.SURVIVAL);
		  			  	 sp.teleport(Main.getLoc(Main.arena.get("lobby"), true));
		 
		  			  	} else {
		  			  		return;
		  			  	}
	  			  }
	  				
	  				 g.getSpectators().clear();
	  		  
	  		  
	  	  }
	  
	 
	  
		
}
	  
	
	

