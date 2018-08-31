package com.santipingui58.spleef.game;


import java.util.Iterator;

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
import com.santipingui58.spleef.managers.EconomyManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.managers.SpleefRankManager;

public class FFASpleefGame implements Listener  {


	private static  ItemStack paladia = new ItemStack (Material.DIAMOND_SPADE);
	private static  ItemStack palahie = new ItemStack (Material.IRON_SPADE);
  	private static ItemStack bolanieve = new ItemStack(Material.SNOW_BALL);
  
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
    	 if (p.hasPermission("splindux.disguise")) Bukkit.dispatchCommand(Main.get().getServer().getConsoleSender(), "ud " + p.getName());
    	 p.setFlying(false);
    	 p.setAllowFlight(false);
    	 p.setGameMode(GameMode.SURVIVAL);
    	 p.getPassengers().clear();
    	 p.teleport(g.getSpawn1());
     
     
     if (DataManager.getNightVision(p)) {
    	 p.addPotionEffect(new PotionEffect (PotionEffectType.NIGHT_VISION, 0, Integer.MAX_VALUE));
     }
     
     
     
     new BukkitRunnable() {
			@Override
			public void run() {
				 p.getInventory().clear();
				if (p.hasPermission("splindux.donator")) {
					p.getInventory().addItem(paladia);
					bolanieve.setAmount(4);
					p.getInventory().addItem(bolanieve);
				} else {
					p.getInventory().addItem(palahie);
					bolanieve.setAmount(2);
					p.getInventory().addItem(bolanieve);
				}
				
				 
		      
			}
		}.runTaskLater(Main.get(), 3L);	
       }
     
     g.getQueue().clear();
     
    GameManager.getManager().getInGameArenas().add(g);
    GameManager.getManager().Countdown(g);
  
  }

  
public static void gameOver(Player winner, String id) {
	  
	  final Game g = GameManager.getManager().getArena(id);
	  GameManager.getManager().reinicio(g);
		g.resetArenaStarting();
		g.resetTime();
		
		
		Iterator<Game> i = GameManager.getManager().getInGameArenas().iterator();
		while (i.hasNext()) {
			Game ga = i.next();
			if (ga.equals(g)) {
				i.remove();
			}
			
		}
		
		if (Bukkit.getOnlinePlayers().contains(winner)) {
			
		try {
		g.getPlayers().remove(winner);
		winner.getInventory().clear();
		Main.givequeueItems(winner);
		winner.setGameMode(GameMode.ADVENTURE);
		winner.teleport(g.getSpect());
		DataManager.addFFASpleefGames(winner);
		DataManager.addFFASpleefWins(winner);
		SpleefRankManager.giveExp(winner, 2);
		EconomyManager.addCoins(winner, 3,true);
		g.getQueue().add(winner);
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
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.get(), new Runnable()
	    {

			public void run()  {  
				if (g.getQueue().size()+g.getPlayers().size() >= 3) {
	        	startCountdown(g.getId());  
	          } else {
	        	  for (Player pa : g.getQueue()) {
	            	  if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
	    					pa.sendMessage("§3[FFASpleef] §cNo hay suficientes jugadores, partida cancelada.");
	    				} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
	    					pa.sendMessage("§3[FFASpleef] §cThere are not enough players, game cancelled.");
	    				}  
	    			}
	          }
				
	        }
	      }
	      , 200L);
		
		
		
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
					pl.sendMessage("§3[SpleefFFA] §b" + winner.getName() + " §6ha ganado la partida!");
				} else if (DataManager.getLang(pl).equalsIgnoreCase("ENG")) {
					pl.sendMessage("§3[SpleefFFA] §b" + winner.getName() + " §6has won the game!");
				}
		}
		}
		

		
		
		
		} catch (Exception e) {}
	  } else {
		  if (g.getQueue().size()+g.getPlayers().size() >= 3) {
		  for (Player pl : g.getPlayers()) {
				if (DataManager.getLang(pl).equalsIgnoreCase("ESP")) {
					pl.sendMessage("§3[SpleefFFA] §6La partida ha terminado en empate! La siguiente comenzará en 10 segundos.");
				} else if (DataManager.getLang(pl).equalsIgnoreCase("ENG")) {
					pl.sendMessage("§3[SpleefFFA] §6 The game has finished in a draw! The next one starts in 10 seconds.");
				}
				g.getQueue().add(pl);
				pl.teleport(g.getSpect());
				
		}
		  
		  for (Player pl : g.getSpectators()) {
				if (DataManager.getLang(pl).equalsIgnoreCase("ESP")) {
					pl.sendMessage("§3[SpleefFFA] §6La partida ha terminado en empate!");
				} else if (DataManager.getLang(pl).equalsIgnoreCase("ENG")) {
					pl.sendMessage("§3[SpleefFFA] §6 The game has finished in a draw!");
				}
				
		}
		  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.get(), new Runnable()
		    {
		public void run()  {  
			if (g.getQueue().size() >= 3) {
      	startCountdown(g.getId());
        } else {
        	g.falseFFAStarting();
      	  for (Player pa : g.getQueue()) {
      	  if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
					pa.sendMessage("§3[FFASpleef] §cNo hay suficientes jugadores, partida cancelada.");
				} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
					pa.sendMessage("§3[FFASpleef] §cThere are not enough players, game cancelled.");
				}  
			}
        }
			
      }
    }
    , 200L);
	  } else {

		  
		  for (Player pl : g.getPlayers()) {
				if (DataManager.getLang(pl).equalsIgnoreCase("ESP")) {
					pl.sendMessage("§3[SpleefFFA] §6La partida ha terminado en empate!");
				} else if (DataManager.getLang(pl).equalsIgnoreCase("ENG")) {
					pl.sendMessage("§3[SpleefFFA] §6 The game has finished in a draw!");
				}
				
				pl.teleport(g.getSpect());
				g.getQueue().add(pl);
		}
		  
		  for (Player pl : g.getSpectators()) {
				if (DataManager.getLang(pl).equalsIgnoreCase("ESP")) {
					pl.sendMessage("§3[SpleefFFA] §6La partida ha terminado en empate!");
				} else if (DataManager.getLang(pl).equalsIgnoreCase("ENG")) {
					pl.sendMessage("§3[SpleefFFA] §6 The game has finished in a draw!");
				}
	  }
	  }
	  
	  }
	  
		g.getPlayers().clear();
		
		
  }
  
  
		
	
  
  
}
