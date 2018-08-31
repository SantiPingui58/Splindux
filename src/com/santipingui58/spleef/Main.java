package com.santipingui58.spleef;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.santipingui58.spleef.commands.AfkCommand;
import com.santipingui58.spleef.commands.CrumbleCommand;
import com.santipingui58.spleef.commands.DuelCommand;
import com.santipingui58.spleef.commands.EndGameCommand;
import com.santipingui58.spleef.commands.FlyCommand;
import com.santipingui58.spleef.commands.FriendsCommand;
import com.santipingui58.spleef.commands.HGCommand;
import com.santipingui58.spleef.commands.HeadCommand;
import com.santipingui58.spleef.commands.LeaveCommand;
import com.santipingui58.spleef.commands.MatchesCommand;
import com.santipingui58.spleef.commands.MsgCommand;
import com.santipingui58.spleef.commands.NickCommand;
import com.santipingui58.spleef.commands.PartyCommand;
import com.santipingui58.spleef.commands.PingCommand;
import com.santipingui58.spleef.commands.PlayToCommand;
import com.santipingui58.spleef.commands.RankCommand;
import com.santipingui58.spleef.commands.RankingCommand;
import com.santipingui58.spleef.commands.ResetCommand;
import com.santipingui58.spleef.commands.RideCommand;
import com.santipingui58.spleef.commands.SCCommand;
import com.santipingui58.spleef.commands.SpectCommand;
import com.santipingui58.spleef.commands.SpleefCommand;
import com.santipingui58.spleef.commands.StaffCommand;
import com.santipingui58.spleef.commands.StatsCommand;
import com.santipingui58.spleef.commands.VoteNameMCCommand;
import com.santipingui58.spleef.game.BuildSpleefPvPGame;
import com.santipingui58.spleef.game.FFASpleefGame;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.game.RankedSpleefGame;
import com.santipingui58.spleef.game.Spleef2v2Game;
import com.santipingui58.spleef.game.SpleefGame;
import com.santipingui58.spleef.listener.NPCListener;
import com.santipingui58.spleef.listener.PlayerChat;
import com.santipingui58.spleef.listener.PlayerJoin;
import com.santipingui58.spleef.listener.PlayerLeave;
import com.santipingui58.spleef.listener.PlayerListener;
import com.santipingui58.spleef.listener.VotifierListener;
import com.santipingui58.spleef.managers.BroadcastManager;
import com.santipingui58.spleef.managers.CapsuleManager;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.DeathManager;
import com.santipingui58.spleef.managers.EconomyManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.managers.SpleefRankManager;
import com.santipingui58.spleef.utils.Configuration;
import com.santipingui58.spleef.utils.Cooldown1_9;
import com.santipingui58.spleef.utils.Damage1_9;
import com.santipingui58.spleef.utils.HolographicAPI;
import com.santipingui58.spleef.utils.Scoreboard;
import com.yapzhenyie.GadgetsMenu.economy.GEconomyProvider;

import ru.tehkode.permissions.bukkit.PermissionsEx;



public class Main extends JavaPlugin {
		
	  private static Plugin pl;
	  private static Game game;
	  private static int maxplayers;
	  public static Configuration arena, data, anuncios, ranking,votes;
	  public static String mapa;
	  static File config;
	  File file;


	  public static Plugin get() {
	    return pl;
	  }
	
	 public static String getMap() {
		    return mapa;
		  }

	 public static int getMaxPlayers() {
		    return maxplayers;
		  }

	  public static Game getGame() {
	    return game;
	  }

	  @Override
	  public void onEnable() {
		  
		    pl = this;
		    
		     config = new File(getDataFolder(), "config.yml");

		    if (!config.exists()) {
		      getConfig().options().copyDefaults(true);
		      saveConfig();
		    }
		    getConfig();
		    saveDefaultConfig();
		    arena = new Configuration(this, "arena");    
		    data = new Configuration(this, "data");
		    anuncios = new Configuration(this, "anuncios");
		    ranking = new Configuration(this, "ranking");
		    votes = new Configuration(this, "votes");
		    
		    
		    
		    maxplayers = getConfig().getInt("maxplayers");
		    
		    
		    getCommand("spleef").setExecutor(new SpleefCommand());
		    getCommand("duel").setExecutor(new DuelCommand());
		    getCommand("reset").setExecutor(new ResetCommand());
		    getCommand("crumble").setExecutor(new CrumbleCommand());
		    getCommand("playto").setExecutor(new PlayToCommand());
		    getCommand("nick").setExecutor(new NickCommand());
		    getCommand("endgame").setExecutor(new EndGameCommand());
		    getCommand("spect").setExecutor(new SpectCommand());
		    getCommand("stats").setExecutor(new StatsCommand());
		    getCommand("rank").setExecutor(new RankCommand());
		    getCommand("ping").setExecutor(new PingCommand());
		    getCommand("leave").setExecutor(new LeaveCommand());
		    getCommand("friends").setExecutor(new FriendsCommand());
		    getCommand("party").setExecutor(new PartyCommand());
		    getCommand("pchat").setExecutor(new PartyCommand());
		    getCommand("pc").setExecutor(new PartyCommand());
		    getCommand("hg").setExecutor(new HGCommand());
		    getCommand("afk").setExecutor(new AfkCommand());
		    getCommand("fly").setExecutor(new FlyCommand());
		    getCommand("ride").setExecutor(new RideCommand());
		    getCommand("head").setExecutor(new HeadCommand());
		    getCommand("msg").setExecutor(new MsgCommand());
		    getCommand("r").setExecutor(new MsgCommand());
		    getCommand("staff").setExecutor(new StaffCommand());
		    getCommand("schat").setExecutor(new StaffCommand());
		    getCommand("matches").setExecutor(new MatchesCommand());
		    getCommand("votenamemc").setExecutor(new VoteNameMCCommand());
		    getCommand("ranking").setExecutor(new RankingCommand());
		    getCommand("sc").setExecutor(new SCCommand());
		    
		    getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		    getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
		    getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		    getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		    getServer().getPluginManager().registerEvents(new Cooldown1_9(), this);
		    getServer().getPluginManager().registerEvents(new Damage1_9(), this);
		    getServer().getPluginManager().registerEvents(new NPCListener(), this);
		    getServer().getPluginManager().registerEvents(new VotifierListener(), this);
		    getServer().getPluginManager().registerEvents(new BuildSpleefPvPGame(), this);
		    
		    GEconomyProvider.setMysteryDustStorage(new EconomyManager(this, "Splindux"));
		   
		    
		    new BukkitRunnable() {
				@Override
				public void run() {
					try {
		    getServer().createWorld(new WorldCreator("splindux").environment(Environment.NORMAL));
		    getServer().createWorld(new WorldCreator("construccion").environment(Environment.NORMAL));
		    getServer().createWorld(new WorldCreator("arenas").environment(Environment.NORMAL));
		   
		    getServer().getLogger().info("mundos y arenas cargadas");
					} catch (Exception e) {
						  getServer().getLogger().info("Error al intentar cargar las arenas");
					}
				}
			}.runTaskLater(Main.get(), 5L);	
			 new BukkitRunnable() {
					@Override
					public void run() {
			 if (arena.getConfig().contains("arenas")) {
		    		GameManager.getManager().loadArenas();
		    }
					}
				}.runTaskLater(Main.get(), 6L);	
				
		    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.get(), new Runnable()
		    {
		        public void run()
		        {
		        	for (Player p : Bukkit.getOnlinePlayers()) {
		        		if (GameManager.getManager().isInGame(p)) {
		        			
		        		Game g = GameManager.getManager().getArenabyPlayer(p);
		        		
		        		if (!g.getInGameSpect().contains(p)) {
		        		DeathManager.onWalk(p);
		        	}
		        		
		        		} else {
		        			PlayerListener.onMove(p);
		        		}
		        
	        }
		        	}
	      }
	      , 0L, 8L);
		        
	  
		    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.get(), new Runnable()
		    {

				public void run()
		        { 
					VotifierListener.voteTime();
		        }
			  }
		      , 0L, 20*60L);
					
		       
		    
		    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.get(), new Runnable()
		    {

				public void run()
		        { 
					HolographicAPI.rotar();
		        }
			  }
		      , 0L, 20*20L);
		    
		    
	  
		    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.get(), new Runnable()
		    {

				@SuppressWarnings("deprecation")
				public void run()
		        {
					
				
		        	
	                Date date = new Date();
	                
	               
	                 if (date.getHours() == 0 && date.getMinutes() == 0 && date.getSeconds() == 0) {
	                	 
	 	                if (date.getDate()==1){
	 	                	DataManager.resetMonthlyFFAWins();
	 	                }
	 	               Set<String> rankeds = Main.data.getConfig().getConfigurationSection("data").getKeys(false);   
	 	               
	 	               Bukkit.getScheduler().runTaskAsynchronously(Main.get(), new Runnable() {
	 	                  @Override
	 	                  public void run() {
	 	                	 for (String s : rankeds) {   
	 	                		if (PermissionsEx.getUser(Main.data.getConfig().getString("data." + s + ".name")).has("splindux.extreme")) {
	 	                			DataManager.setRankeds("data." + s + ".rankeds", 30);
	 	                		} else if (PermissionsEx.getUser(Main.data.getConfig().getString("data." + s + ".name")).has("splindux.epic")) {
	 	                			DataManager.setRankeds("data." + s + ".rankeds", 20);
	 	                		}  else if (PermissionsEx.getUser(Main.data.getConfig().getString("data." + s + ".name")).has("splindux.vip")) {
	 	                			DataManager.setRankeds("data." + s + ".rankeds", 15);
	 	                		}  else {
	 	                			DataManager.setRankeds("data." + s + ".rankeds", 10);
	 	                		}
	 	                	}
	 	                  }
	 	              });
	                	
	                	
	                }
		        	
	                 
	                 for (Player p : Bukkit.getOnlinePlayers()) {
		    				if (GameManager.getManager().isInGame(p) || GameManager.getManager().isSpectating(p)) {
		        			 new Scoreboard().createScoreboardGame(p);
		        		} else {
		        			new Scoreboard().createScoreboard(p);
		        			} 
		        		}
	                          
	                 
	                 
		        	for (final Game g : GameManager.getManager().getArenasList()) {
		        		if (GameManager.getManager().getInGameArenas().contains(g)) {
		        			
		        			if (g.getPoints1() >= g.getWin()) {
		        				if (g.getType().equalsIgnoreCase("spleef")) {
		        					if (GameManager.getManager().isRanked(g)) {
		        						RankedSpleefGame.gameOver(g.getPlayer1().get(0), g.getPlayer2().get(0), g.getId());
		        					} else {
		        						SpleefGame.gameOver(g.getPlayer1().get(0), g.getPlayer2().get(0), g.getId());
		        					}
		        				} else if (g.getType().equalsIgnoreCase("spleef2v2")) {
		        					if (GameManager.getManager().isRanked(g)) {
		        						//RankedSpleefGame.gameOver(g.getPlayer1().get(0), g.getPlayer2().get(0), g.getId());
		        					} else {
		        						Spleef2v2Game.gameOver(g.getPlayer1(), g.getPlayer2(), g.getId());
		        					}
		        				}
		        			} else if (g.getPoints2() >= g.getWin()) {
		        				if (g.getType().equalsIgnoreCase("spleef")) {
		        					if (GameManager.getManager().isRanked(g)) {
		        						RankedSpleefGame.gameOver(g.getPlayer2().get(0), g.getPlayer1().get(0), g.getId());
		        					} else {
		        						SpleefGame.gameOver(g.getPlayer2().get(0), g.getPlayer1().get(0), g.getId());
		        					}
		        				} else if (g.getType().equalsIgnoreCase("spleef2v2")) {
		        					if (GameManager.getManager().isRanked(g)) {
		        						//RankedSpleefGame.gameOver(g.getPlayer1().get(0), g.getPlayer2().get(0), g.getId());
		        					} else {
		        						Spleef2v2Game.gameOver(g.getPlayer2(), g.getPlayer1(), g.getId());
		        					}
		        				}
		        			}
		        			
		        			
		        			
		        		try {
		        		Set<Game> dup = findDuplicates(GameManager.getManager().getInGameArenas());
		        			if (dup.contains(g)) {
		        				Iterator<Game> i = GameManager.getManager().getInGameArenas().iterator();
		        				while (i.hasNext()) {
		        					Game ga = i.next();
		        					if (ga.equals(g)) {
		        						i.remove();
		        					}
		        					
		        				}
		        			}
		        		} catch (Exception e) {}
		        		
		        		        if (g.getCanPlay() == false) {
		        		        	if (g.getType().equalsIgnoreCase("spleef") || g.getType().equalsIgnoreCase("spleef2v2")
		        		        			|| g.getType().equalsIgnoreCase("BuildSpleefPvP") || 
		        		        			g.getType().equalsIgnoreCase("bowspleef")) {
		        		        	if (g.getArenaStarting() > 1) {
		        		        	g.ArenaStarting();
		        		        
		        		        	for (Player p1 : g.getPlayer1()) {
		        		        	if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
		        		        		  p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7La ronda comienza en &6" + g.getArenaStarting() + "&7!")); 
		        		        	  } else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
		        		        		  p1.sendMessage("§7The round starts in §6" + g.getArenaStarting() + "§7!");
		        		        	  }
		        		        	}
		        		        	  
		        		        	  for (Player sp : g.getSpectators()) {
		        		        		  if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
		        			        		  sp.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7La ronda comienza en &6" + g.getArenaStarting() + "&7!")); 
		        			        	  } else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
		        			        		  sp.sendMessage("§7The round starts in §6" + g.getArenaStarting() + "§7!");
		        			        	  }
		        		        	  }
		        		        	  for (Player p2 : g.getPlayer2()) {
		        		        	  if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
		        		        		  p2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7La ronda comienza en &6" + g.getArenaStarting() + "&7!")); 
		        		        	  } else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
		        		        		  p2.sendMessage("§7The round starts in §6" + g.getArenaStarting() + "§7!");
		        		        	  }
		        		        	  
		        		        	  }
		        		        	} else {
		        		        		g.resetArenaStarting();
		        		        		if (g.getType().equalsIgnoreCase("spleef") || g.getType().equalsIgnoreCase("BuildSpleefPvP")
		        		        				|| g.getType().equalsIgnoreCase("bowspleef")) {
		        		        			if (g.getType().equalsIgnoreCase("bowspleef")) {
		        		        				for (Player p1 : g.getPlayer1()) {
		        		        					p1.getInventory().addItem(new ItemStack(Material.ARROW));
		        		        				}
		        		        				for (Player p2 : g.getPlayer2()) {
		        		        					p2.getInventory().addItem(new ItemStack(Material.ARROW));
		        		        				}
		        		        			}
		        		        		CapsuleManager.removeCapsula(g.getSpawn1());
		        		        		CapsuleManager.removeCapsula(g.getSpawn2());
		        		        		
		        		        		} else if (g.getType().equalsIgnoreCase("spleef2v2")) {
		        		        			CapsuleManager.removeCapsula(g.getSpawn1A());
		        		        			CapsuleManager.removeCapsula(g.getSpawn1B());
			        		        		CapsuleManager.removeCapsula(g.getSpawn2A());
			        		        		CapsuleManager.removeCapsula(g.getSpawn2B());
		        		        		}
		        		        		g.trueCanPlay();
		        		        		
		        		        	}
		        		        } else if (g.getType().equalsIgnoreCase("ffaspleef")) {		        		       
		        		        			 if (g.getArenaStarting() > 1) {
		     		        		        	g.ArenaStarting();
		     		        		        	for (Player p : g.getPlayers()) {
		     		        		        		if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
		     			        		        		  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7La ronda comienza en &6" + g.getArenaStarting() + "&7!")); 
		     			        		        	  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
		     			        		        		  p.sendMessage("§7The round starts in §6" + g.getArenaStarting() + "§7!");
		     			        		        	  }
		     		        		        	}
		        		        			 } else {
		 		        		        		g.resetArenaStarting();  		
				        		        		g.trueCanPlay();
				        		        	}
		        		        			 
		        		        			 
		        		        		 }      		        	
		        		        	 } else {
			        		        	 g.addTime();
			        		        	 	if (g.getType().equalsIgnoreCase("ffaspleef")) {
			        		        	 		if (g.getTime() == 240) {
			        		        	 			for (Player p : g.getPlayers()) {
			     		        		        		if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			     		        		        			  p.sendMessage("§3[SpleefFFA] §aQueda §c1 minuto §a de partida!");
			     			        		        	  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			     			        		        		  p.sendMessage("§3[SpleefFFA] §c1 minute §a left of the game!");
			     			        		        	  }
			     		        		        	}
			        		        	 			
			        		        	 			for (Player p : g.getQueue()) {
			     		        		        		if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			     		        		        			  p.sendMessage("§3[SpleefFFA] §aQueda §c1 minuto §a de partida!");
			     			        		        	  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			     			        		        		  p.sendMessage("§3[SpleefFFA] §c1 minute §a left of the game!");
			     			        		        	  }
			     		        		        	}
			        		        	 			
			        		        	 		} else if (g.getTime() >= 299) {
			        		        	 			
			        		        	 			FFASpleefGame.gameOver(null, g.getId());
			        		        	 		}
				        		        }	              
		        		        	 }
		        	}
	        }
	      }
	  }
	      , 0L, 20L);
		
		    
		      
		    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.get(), new Runnable()
		    {
				public void run()
		        {
					BroadcastManager.Broadcast(); 
							HolographicAPI.update();			
		        }
		      }
		      , 0L, 300*20L);   
	  }
	  

		    	
	  @Override
	 public void onDisable() {
		  for (Game g : GameManager.getManager().getArenasList()) {
			  for (Player p : g.getPlayer1()) {
				  p.performCommand("/lobby");
			  }
			  for (Player p : g.getPlayer2()) {
				  p.performCommand("/lobby");
			  }
			  for (Player p : g.getSpectators()) {
				  p.performCommand("/lobby");
			  }
		  }
		  try {
		 for (Game g : GameManager.getManager().getArenasList()) {
			 g.getQueue().clear();
	
			 if (g.getType().equalsIgnoreCase("spleef")) {
			 if (GameManager.getManager().isRanked(g)) {
				 RankedSpleefGame.gameOver(null, null, g.getId()); 
			 } else {
			 SpleefGame.gameOver(null, null, g.getId()); 
			 }
		 } else if (g.getType().equalsIgnoreCase("spleef2v2")) {
			 if (GameManager.getManager().isRanked(g)) {
			 } else {
			 Spleef2v2Game.gameOver(null, null, g.getId()); 
			 }
		 } else if (g.getType().equalsIgnoreCase("ffaspleef")){
			 FFASpleefGame.gameOver(null, g.getId());
			 for (Player pa : g.getQueue()) {
				  pa.teleport(Main.getLoc(Main.arena.get("lobby"), true));
				  Main.giveItems(pa);
			 } 
			 g.getQueue().clear();
			 for (Player pa : g.getPlayers()) {
				  pa.teleport(Main.getLoc(Main.arena.get("lobby"), true));
				  Main.giveItems(pa);
			 }
			 
			 g.getPlayers().clear();
			 
			 
		 } 
			 }
		  } catch(Exception e) {}
	 }
 
	  public static String setLoc(Location loc, boolean pitch)
	  {
	    if (pitch) {
	      return loc.getWorld().getName() + "," + loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ() + "," + loc.getYaw() + "," + loc.getPitch();
	    }
	    return loc.getWorld().getName() + "," + loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ();
	  }

	  public static Location getLoc(String path, boolean pitch)
	  {
	    Location loc = null;
	    if (!pitch) {
	      String[] locs = path.split(",");
	      loc = new Location(Bukkit.getWorld(locs[0]), Integer.parseInt(locs[1]), Integer.parseInt(locs[2]), Integer.parseInt(locs[3]));
	      loc.add(0.5D, 0.0D, 0.5D);
	      return loc;
	    }
	    String[] locs = path.split(",");
	    loc = new Location(Bukkit.getWorld(locs[0]), Integer.parseInt(locs[1]), Integer.parseInt(locs[2]), Integer.parseInt(locs[3]), Float.valueOf(locs[4]).floatValue(), Float.valueOf(locs[5]).floatValue());
	    loc.add(0.5D, 0.0D, 0.5D);
	    return loc;
	  }

	  public static Location getLoc(String path)
	  {
	    String[] locs = path.split(",");

	    Location loc = new Location(Bukkit.getWorld(locs[0]), Integer.parseInt(locs[1]), Integer.parseInt(locs[2]), Integer.parseInt(locs[3]));
	    loc.add(0.5D, 0.0D, 0.5D);
	    return loc;
	  }

	  
	  public static ItemStack getSkull(String url) {
	        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	        if(url.isEmpty())return head;
	       
	       
	        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
	        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
	        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
	        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
	        Field profileField = null;
	        try {
	            profileField = headMeta.getClass().getDeclaredField("profile");
	            profileField.setAccessible(true);
	            profileField.set(headMeta, profile);
	        } catch (NoSuchFieldException e1) {
	            e1.printStackTrace();
	        } catch (IllegalArgumentException e1) {}
	        catch (IllegalAccessException e1) {}
	        head.setItemMeta(headMeta);
	        return head;
	    }
	  
	  public static boolean containsIgnoreCase(String str, String searchStr) {
	        if (str == null || searchStr == null) {
	            return false;
	        }
	        int len = searchStr.length();
	        int max = str.length() - len;
	        for (int i = 0; i <= max; i++) {
	            if (str.regionMatches(true, i, searchStr, 0, len)) {
	                return true;
	            }
	        }
	        return false;
	    }
	  
	  public static void giveItems(Player p) {
		  p.setGameMode(GameMode.ADVENTURE);
		  p.getInventory().clear();
		  SpleefRankManager.checkLevel(p);
		  for (PotionEffect effect : p.getActivePotionEffects())
		        p.removePotionEffect(effect.getType());
		  
		  
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			p.getInventory().setItem(0, Game.rankeditemesp);
			p.getInventory().setItem(1, Game.unrankeditemesp);
			p.getInventory().setItem(4, Game.gadgetsesp);
			p.getInventory().setItem(6, Game.partiesesp);
			p.getInventory().setItem(7, Game.giftsesp);
			p.getInventory().setItem(8, Game.opcionesesp);
			
		} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")){
			p.getInventory().setItem(0, Game.rankeditemeng);
			p.getInventory().setItem(1, Game.unrankeditemeng);
			p.getInventory().setItem(4, Game.gadgetseng);
			p.getInventory().setItem(6, Game.partieseng);
			p.getInventory().setItem(7, Game.giftseng);
			p.getInventory().setItem(8, Game.opcioneseng);
		} else {
			p.sendMessage("§cAn error has ocurred while joining the Server. Please leave and join again, if the problem persists, contact a Staff of the Server.");
		}
	  }
	  
	  public static void givequeueItems(Player p) {
		  p.getInventory().clear();
		  p.closeInventory();
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			p.getInventory().setItem(8, Game.leavequeueesp);
		} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")){
			p.getInventory().setItem(8, Game.leavequeueeng);
		} else {
			p.sendMessage("§cAn error has ocurred while joining the Server. Please leave and join again, if the problem persists, contact a Staff of the Server.");
		}
	  }
	  
	  
	  public static <T> Set<T> findDuplicates(Collection<T> list) {

		    Set<T> duplicates = new LinkedHashSet<T>();
		    Set<T> uniques = new HashSet<T>();

		    for(T t : list) {
		        if(!uniques.add(t)) {
		            duplicates.add(t);
		        }
		    }

		    return duplicates;
		}
	  

	  }
	
	

