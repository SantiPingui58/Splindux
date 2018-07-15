package com.santipingui58.spleef.game;



import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
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
import com.santipingui58.spleef.utils.ItemBuilder;
import com.santipingui58.spleef.utils.Scoreboard;

public class BuildSpleefPvPGame implements Listener  {

	public static HashMap<Player,Integer> nieve = new HashMap<Player,Integer>();



public static int task;
  public static ItemStack pala_1 = new ItemStack (Material.DIAMOND_SPADE);
  public static ItemStack pala_2 = new ItemStack (Material.IRON_SPADE);
  public static ItemStack pala_3 = new ItemStack (Material.STONE_SPADE);
  
  
	static ItemStack snowblock = new ItemBuilder(Material.SNOW_BLOCK).setAmount(10).build();
	static ItemStack snowball = new ItemBuilder(Material.SNOW_BALL).setAmount(10).build();
  
	  @SuppressWarnings("deprecation")
	public static void startCountdown(String id) {
		  
		  
		  
		  ItemMeta meta = pala_1.getItemMeta();
	      meta.spigot().setUnbreakable(true);
	      meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	      pala_1.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
	      pala_1.setItemMeta(meta);
	      
	      pala_2.setDurability((short) 30);
	      pala_2.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
	      
	      pala_3.setDurability((short) 10);
	      pala_3.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
	      
	      final Game g = GameManager.getManager().getArena(id);
	     final Player  p1 = g.getPlayer1().get(0);
	     final Player  p2 = g.getPlayer2().get(0);
	     Main.get().getLogger().info("Spleef normal iniciado");
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
	     
	     
	     
	     new BukkitRunnable() {
				@Override
				public void run() {
					 giveGameItems(p1);
					 giveGameItems(p2);
			      
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
		  GameManager.getManager().removeInGameArena(g);
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
		  			 sp.sendMessage("§3[BuildSpleefPvP] §a" + ganador.getName() + " §7le ha ganado a §c" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
		  		   }
	  				  ganador.sendMessage("§3[BuildSpleefPvP] §aLe has ganado a §b" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  				  
	  				perdedor.sendMessage("§3[BuildSpleefPvP] §cHas perdido contra §a" + ganador.getName() 
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  				
	  				  perdedor.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  ganador.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  g.resetPoints();
	  					  g.getPlayer1().clear();
	  					  g.getPlayer2().clear();
	  					  
	  				  
	  				  Main.giveItems(ganador);
	  				  Main.giveItems(perdedor);
	  					nieve.remove(ganador);
	  					nieve.remove(perdedor);
	  					
	  					
	  					
	  					
	  			  } else if (g.getPoints2() >= 5) {

	  				SpleefRankManager.giveExp(perdedor,1);
	  	  			SpleefRankManager.giveExp(ganador, 3);
	  	  		EconomyManager.addCoins(ganador, 10,true);
  	  			EconomyManager.addCoins(perdedor, 1,true);
	  	  			
	  	  		   for (Player sp : g.getSpectators()) {
	  	  			 sp.sendMessage("§3[BuildSpleefPvP] §a" + ganador.getName() + " §7le ha ganado a §c" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  	  		   }
	  				  ganador.sendMessage("§3[BuildSpleefPvP] §aLe has ganado a §b" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  				  
	  				perdedor.sendMessage("§3[BuildSpleefPvP] §cHas perdido contra §a" + ganador.getName() 
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
	  	  			   sp.sendMessage("§3[BuildSpleefPvP] §a" + ganador.getName() + " §7le ha ganado a §c" + perdedor.getName() 
		  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  	  		   }
	  	  		   
	  				  ganador.sendMessage("§3[BuildSpleefPvP] §aLe has ganado a §b" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  				  
	  				perdedor.sendMessage("§3[BuildSpleefPvP] §cHas perdido contra §a" + ganador.getName() 
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
  	  			
	  				  ganador.sendMessage("§3[BuildSpleefPvP] §aLe has ganado a §b" + perdedor.getName() 
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  				  
	  				perdedor.sendMessage("§3[BuildSpleefPvP] §cHas perdido contra §a" + ganador.getName() 
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  				
	  				for (Player sp : g.getSpectators()) {
		  			  	 sp.sendMessage("§3[BuildSpleefPvP] §a" + ganador.getName() + " §7le ha ganado a §c" + perdedor.getName() 
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
	  
	  
		public static void giveGameItems(Player p) {
				
			nieve.put(p, 200);
			p.getInventory().clear();
			p.getInventory().setItem(0,pala_1);
			p.getInventory().setItem(1,pala_2);
			p.getInventory().setItem(2,pala_3);
			p.getInventory().setItem(8, snowblock);
			p.getInventory().setItem(7, snowball);
			
		}
	  
	 
		
		@EventHandler
		public void snowBall(ProjectileLaunchEvent e) {
			if (e.getEntity().getShooter() instanceof Player) {
				if (e.getEntity() instanceof Snowball) {
				Player p = (Player) e.getEntity().getShooter();
				if (GameManager.getManager().isInGame(p)) {
					if (GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("BuildSpleefPvP")) {
						int n = nieve.get(p);
						if (n>0) {
							n--;
							nieve.put(p, n);
							 new BukkitRunnable() {
									@Override
									public void run() {
										p.getInventory().setItem(7, snowball);
									}
								}.runTaskLater(Main.get(), 2L);	
								
							
							  new Scoreboard().createScoreboardGame(p);
						} else {
							e.setCancelled(true);
						}
					}
					}
				}
			}
		}
	  
		
		@EventHandler 
		public void blockPlace(BlockPlaceEvent e) {
			Player p = e.getPlayer();
			if (GameManager.getManager().isInGame(p)) {
				Game g = GameManager.getManager().getArenabyPlayer(p);
				if (g.getType().equalsIgnoreCase("BuildSpleefPvP")) {
					
					if (e.getBlock().getLocation().distance(g.getSpawn1()) > 25 && 
							e.getBlock().getLocation().distance(g.getSpawn2()) > 25) {
						e.setCancelled(true);
					}
					int n = nieve.get(p);
					if (n>4) {
						n = n-4;
						nieve.put(p,n);
						p.getInventory().setItem(8, snowblock);
						g.getPlacedBlocks().add(e.getBlock());
						  new Scoreboard().createScoreboardGame(p);
					} else {
						e.setCancelled(true);
					}
				}
			}
			
		}
	  
		@EventHandler
		public void blockBreak(BlockBreakEvent e) {
			Player p = e.getPlayer();
			if (!e.getBlock().getType().equals(Material.SNOW_BLOCK)) {
				return;
			}
			if (GameManager.getManager().isInGame(p)) {
				if (GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("BuildSpleefPvP")) {
					int n = nieve.get(p);
					n++;
					nieve.put(p,n);
					  new Scoreboard().createScoreboardGame(p);
				}
		} 
	  
}
		
}
	  
	
	

