package com.santipingui58.spleef.listener;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.util.BlockIterator;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.commands.AfkCommand;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.managers.PartyManager;
import com.santipingui58.spleef.menu.esp.OptionsMenu;
import com.santipingui58.spleef.menu.esp.RankedMenu;
import com.santipingui58.spleef.menu.esp.TournamentsMenu;
import com.santipingui58.spleef.menu.esp.UnrankedMenu;




public class PlayerListener implements Listener {

	public static HashMap<Player, Location> location = new HashMap<Player,Location>();
	public static HashMap<Player, Location> ffalocation = new HashMap<Player,Location>();
	public static HashMap<Player,Integer> afkqueue = new HashMap<Player, Integer>();
	public static HashMap<Player,Integer> antiAfkFFA = new HashMap<Player, Integer>();
	
	@SuppressWarnings("deprecation")
	@EventHandler (priority = EventPriority.HIGHEST)
	public static void onInteract(PlayerInteractEvent e) {
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			if(e.getPlayer().getItemInHand().equals(Game.rankeditemesp)) {
				if (DataManager.getRankeds(e.getPlayer()) >= 1) {
				new RankedMenu(e.getPlayer()).o(e.getPlayer()); 
				} else {
					if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						e.getPlayer().sendMessage("§cNo tienes más Rankeds para jugar.");
						e.getPlayer().sendMessage("§bVota para conseguir más Rankeds: /votar");
					} else if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ENG")) {
						e.getPlayer().sendMessage("§cYou do not have rankeds left to play.");
						e.getPlayer().sendMessage("§bVote to win more rankeds: /vote");
					}
				}
			} 
			if(e.getPlayer().getItemInHand().equals(Game.rankeditemeng)) {
				if (DataManager.getRankeds(e.getPlayer()) >= 1) {
				new com.santipingui58.spleef.menu.eng.RankedMenu(e.getPlayer()).o(e.getPlayer()); 
				} else {
					if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						e.getPlayer().sendMessage("§cNo tienes más Rankeds para jugar.");
						e.getPlayer().sendMessage("§bVota para conseguir más Rankeds: /votar");
					} else if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ENG")) {
						e.getPlayer().sendMessage("§cYou do not have rankeds left to play.");
						e.getPlayer().sendMessage("§bVote to win more rankeds: /vote");
					}
				}
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.unrankeditemesp)) {
				new UnrankedMenu(e.getPlayer()).o(e.getPlayer());
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.unrankeditemeng)) {
				new com.santipingui58.spleef.menu.eng.UnrankedMenu(e.getPlayer()).o(e.getPlayer());
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.torneosesp)) {
				new TournamentsMenu(e.getPlayer()).o(e.getPlayer());
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.torneoseng)) {
				new com.santipingui58.spleef.menu.eng.TournamentsMenu(e.getPlayer()).o(e.getPlayer());
			} 
		
			if(e.getPlayer().getItemInHand().equals(Game.opcionesesp)) {
				new OptionsMenu(e.getPlayer()).o(e.getPlayer());
				return;
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.opcioneseng)) {
				new com.santipingui58.spleef.menu.eng.OptionsMenu(e.getPlayer()).o(e.getPlayer());
				return;
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.partieseng)) {
				if (PartyManager.getManager().isInParty(e.getPlayer())) {
				//	new OptionsMenu(e.getPlayer()).o(e.getPlayer());
				} else {
						e.getPlayer().sendMessage("§cNecesitas estar en una Party para usar este Item. Crea una invitando jugadores con "
								+ "§3/party invite <Jugador>");
				}
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.partieseng)) {
				if (PartyManager.getManager().isInParty(e.getPlayer())) {
				//	new OptionsMenu(e.getPlayer()).o(e.getPlayer());
				} else {
						e.getPlayer().sendMessage("§cYou need to be in a Party to use this Item. Create one inviting players with "
								+ "§3/party invite <Player>");
					
				}
			} 
			
			
			if(e.getPlayer().getItemInHand().equals(Game.leavequeueeng)) {
				GameManager.getManager().leaveQueue(e.getPlayer());
				return;
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.leavequeueesp)) {
				GameManager.getManager().leaveQueue(e.getPlayer());
				return;
			} 
			
		}
	}
	
	@EventHandler
	public static void onPing (ServerListPingEvent e) {
		Bukkit.getConsoleSender().sendMessage("§f[" + e.getAddress() + "] has pinged." );
	}
	
	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void onSnowball(ProjectileHitEvent e)
	  {
	    Player p = (Player)e.getEntity().getShooter();
	    if (GameManager.getManager().isInGame(p)) {
	    	if (GameManager.getManager().getArenabyPlayer(p).getCanPlay()) {
	    BlockIterator iterator = new BlockIterator(e.getEntity().getWorld(), e.getEntity().getLocation().toVector(), e.getEntity().getVelocity().normalize(), 0.0D, 4);
	    Block hitblock = null;
	    while (iterator.hasNext()) {
	      hitblock = iterator.next();

	      if (hitblock.getTypeId() != 0)
	      {
	        break;
	      }
	    }
	    if (hitblock.getType() == Material.SNOW_BLOCK)
	    {
	      p.playSound(hitblock.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.5F, 2.0F);
	      hitblock.setType(Material.AIR);
	    }
	    
	    	}
	  } 
	    }
	
	
	
	@EventHandler
	public static void onCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		afkqueue.remove(p);
		if (GameManager.getManager().isInGame(p)) {
			if (e.getMessage().equalsIgnoreCase("fly")) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNo puedes ejecutar este comando dentro de una partida.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou can't execute this command while playing a match.");
				}
				e.setCancelled(true);
			}
		}
	}
	
	
	
	@EventHandler
	public static void onBreak (BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (GameManager.getManager().isInGame(p)) {
			if (GameManager.getManager().getArenabyPlayer(p).getCanPlay() == false ) {
				e.setCancelled(true);
		}
			
			if (e.getBlock().getType().equals(Material.SNOW_BLOCK)) {
				return;
			} 
				e.setCancelled(true);
			} 
		 
	
	if (p.hasPermission("splindux.admin")) {
		if (p.getGameMode().equals(GameMode.CREATIVE))
			return;
		}

	e.setCancelled(true);
			
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onPlace (BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if (GameManager.getManager().isInGame(p)) {
			if (!e.getBlock().getType().equals(Material.SNOW_BLOCK)) {
				e.setCancelled(true);
			}
		}
		
		if (GameManager.getManager().isInQueue(p)) {
			e.setCancelled(true);
		}
		
		if (p.getItemInHand().equals(Game.opcionesesp) ||
				p.getItemInHand().equals(Game.opcioneseng) || 
				p.getItemInHand().equals(Game.leavequeueeng) ||
				p.getItemInHand().equals(Game.leavequeueesp)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public static void onDeath (EntityDamageByEntityEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public static void onHurt (EntityDamageEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public static void onHunger (FoodLevelChangeEvent e) {
		e.setCancelled(true);
	} 

	@EventHandler
	public void onTeleport (PlayerTeleportEvent e) {
		Player p = e.getPlayer();
		
		for (Entity pa : p.getPassengers()) {
			p.getPassengers().remove(pa);
		}
		
		if (p.isInsideVehicle()) {
			p.leaveVehicle();
		}
		
		for (Game g : GameManager.getManager().getArenasList())
		if (g.getSpectators().contains(p)) {
			if (e.getCause().equals(TeleportCause.SPECTATE)) {
				e.setCancelled(true);
			}
		}

	}
	
	
	@EventHandler
	  public void onDrop (PlayerDropItemEvent e) {
		  e.setCancelled(true);
	  }
	
	@EventHandler
	public void onHand (PlayerSwapHandItemsEvent e) {
		e.setCancelled(true);
	}
	
	
	public static void onMove (Player p) {
		
		if (GameManager.getManager().isInFFAQueue(p)) {
		if (ffalocation.containsKey(p)) {
			if (ffalocation.get(p).equals(GameManager.getManager().getFFAQueue(p).getSpect())) {
		if (antiAfkFFA.containsKey(p)) {
			int time = antiAfkFFA.get(p);
			time++;
			antiAfkFFA.put(p, time);
			if (time >= 200) {
				ffalocation.remove(p);
				antiAfkFFA.remove(p);
				
						
						if (!GameManager.getManager().getFFAQueue(p).getPlayers().isEmpty()) {
						GameManager.getManager().leaveQueue(p);
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§3[FFASpleef] §cAparentemente te encuentras AFK, por lo que has sido removido del juego.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§3[FFASpleef] §cAparently you are AFK, so you have been removed from the game.");
						}
					
						}
					
				
			} 
		} else {
			antiAfkFFA.put(p, 1);
		}
		
		
		} 
		
		} else {
			ffalocation.put(p, p.getLocation());
		}
		
		}
		
		
		
		if (location.containsKey(p)) {
			if (location.get(p).equals(p.getLocation())) {			
				if (p.hasPermission("splindux.afk")) {
				if (afkqueue.containsKey(p)) {
					int time = afkqueue.get(p);
					time++;
					afkqueue.put(p, time);
					if (time >= 750) {
						location.remove(p);
						afkqueue.remove(p);
						if (!AfkCommand.isAfk(p)) {
						AfkCommand.addAfk(p);		
						}
					} 
				} else {
					afkqueue.put(p, 1);
				}
				}
			} else {
				if (AfkCommand.isAfk(p)) {
				AfkCommand.removeAfk(p);
				}
				location.remove(p);
			}
		} else {
			location.put(p, p.getLocation());
		}
		
		
		
		
		
		if (p.getWorld().getName().equalsIgnoreCase("splindux")) {
			if (p.getLocation().getBlockY() <= 0) {
				 p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
			}
			
		
			
			if (Main.getLoc(Main.arena.get("lobby"), true).distance(p.getLocation()) >= 100) {
				 p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
			}
			
			
			
		}
		
		
		
		
		
		for (Game g : GameManager.getManager().getArenasList()) {
			try {
			if (g.getSpectators().contains(p)) {
				Player p1 = g.getPlayer1().get(0);
				Player p2 = g.getPlayer2().get(0);
				if (p.getWorld() == p1.getWorld()) {
					if (p.getLocation().distance(p1.getLocation()) > 50) {
						p.teleport(p1);
					}
					} 
				
				if (p.getWorld() == p2.getWorld()) {
					if (p.getLocation().distance(p2.getLocation()) > 50) {
						p.teleport(p2);
					}
					}
				
			}
			} catch (Exception e) {}
		}
	
	}
	
	
	
	
	
	
	
}
