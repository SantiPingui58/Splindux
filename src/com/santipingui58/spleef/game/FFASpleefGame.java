package com.santipingui58.spleef.game;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
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
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.managers.SpleefRankManager;

public class FFASpleefGame implements Listener  {


  public static int task;
  public static ItemStack paladia = new ItemStack (Material.DIAMOND_SPADE);
  public static ItemStack palahie = new ItemStack (Material.IRON_SPADE);

  
  
  @SuppressWarnings("deprecation")
public static void startCountdown(String id) {
	  
	  ItemMeta meta = paladia.getItemMeta(); 
	  ItemMeta meta1 = palahie.getItemMeta();
      meta.spigot().setUnbreakable(true);
      meta1.spigot().setUnbreakable(true);
      meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
      meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
      paladia.setItemMeta(meta);
      palahie.setItemMeta(meta1);
      final Game g = GameManager.getManager().getArena(id);
      GameManager.getManager().reinicio(g);
     for (final Player p : g.getQueue()) {
    	 g.getPlayers().add(p);
     p.setFlying(false);
     p.setGameMode(GameMode.SURVIVAL);
     p.teleport(g.getSpawn1());
     
     
     if (DataManager.getNightVision(p)) {
    	 p.addPotionEffect(new PotionEffect (PotionEffectType.NIGHT_VISION, 0, 100000));
     }
     
     
     
     new BukkitRunnable() {
			@Override
			public void run() {
				 p.getInventory().clear();
				if (p.hasPermission("splindux.donator")) {
					p.getInventory().addItem(paladia);
				} else {
					p.getInventory().addItem(palahie);
				}
				
				 
		      
			}
		}.runTaskLater(Main.get(), 3L);	
       }
     
     g.getQueue().clear();
     
     
    GameManager.getManager().Countdown(g);
  
  }

  
public static void gameOver(Player ganador, String id) {
	  
	  final Game g = GameManager.getManager().getArena(id);
		try {
		Player winner = g.getPlayers().get(0);
		g.getPlayers().remove(winner);
		winner.getInventory().clear();
		Main.givequeueItems(winner);
		winner.setGameMode(GameMode.ADVENTURE);
		winner.teleport(g.getSpect());
		DataManager.addFFASpleefGames(winner);
		DataManager.addFFASpleefWins(winner);
		SpleefRankManager.levelUp(winner);
		SpleefRankManager.levelUp(winner);
		g.getQueue().add(winner);
		g.resetArenaStarting();
		if (g.getQueue().size() >= 3) {
		for (Player pl : g.getPlayers()) {
			if (!(pl.equals(winner))) {
			if (DataManager.getLang(pl).equalsIgnoreCase("ESP")) {
				pl.sendMessage("§3[SpleefFFA] §b" + winner.getName() + " §6ha ganado la partida! La siguiente comenzará en 10 segundos.");
			} else if (DataManager.getLang(pl).equalsIgnoreCase("ENG")) {
				pl.sendMessage("§3[SpleefFFA] §b" + winner.getName() + " §6has won the game! The next one starts in 10 seconds.");
			}
			}
	}
		
		for (Player pl : g.getQueue()) {
			if (DataManager.getLang(pl).equalsIgnoreCase("ESP")) {
				pl.sendMessage("§3[SpleefFFA] §b" + winner.getName() + " §6ha ganado la partida! La siguiente comenzará en 10 segundos.");
			} else if (DataManager.getLang(pl).equalsIgnoreCase("ENG")) {
				pl.sendMessage("§3[SpleefFFA] §b" + winner.getName() + " §6has won the game! The next one starts in 10 seconds.");
			}
	}
		} else {
			for (Player pl : g.getPlayers()) {
				if (!(pl.equals(winner))) {
				if (DataManager.getLang(pl).equalsIgnoreCase("ESP")) {
					pl.sendMessage("§3[SpleefFFA] §b" + winner.getName() + " §6ha ganado la partida!");
				} else if (DataManager.getLang(pl).equalsIgnoreCase("ENG")) {
					pl.sendMessage("§3[SpleefFFA] §b" + winner.getName() + " §6has won the game!");
				}
				}
		}
			for (Player pl : g.getQueue()) {
				if (DataManager.getLang(pl).equalsIgnoreCase("ESP")) {
					pl.sendMessage("§3[SpleefFFA] §b" + winner.getName() + " §6ha ganado la partida! La siguiente comenzará en 10 segundos.");
				} else if (DataManager.getLang(pl).equalsIgnoreCase("ENG")) {
					pl.sendMessage("§3[SpleefFFA] §b" + winner.getName() + " §6has won the game! The next one starts in 10 seconds.");
				}
		}
		}
		
		

		
		 Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.get(), new Runnable()
		    {

				public void run()
		        {  if (g.getQueue().size() >= 3) {
		        	startCountdown(g.getId());
		          }
					
		        }
		      }
		      , 200L);
		
		
		
		
		} catch (Exception e) {}
		g.getPlayers().clear();
		
		
		
		
  }
  
  
		
	
  
	

	 
	 
	 

  
  
}
