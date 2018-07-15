package com.santipingui58.spleef.commands;

import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.SpleefRankManager;
import com.santipingui58.spleef.utils.SortMapByValue;




public class StatsCommand implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			if(cmd.getName().equalsIgnoreCase("stats")){
				if (args.length == 0) { 
					sender.sendMessage("§a/stats top <spleef|ffaspleef>");
					sender.sendMessage("§a/stats <player>");
				} else {
					 if (args[0].equalsIgnoreCase("top")) {
					if (args.length <= 1) {
							sender.sendMessage("§a/stats top <spleef|ffaspleef>");
							return true;
					} else if (args.length == 2) {
						if (args[1].equalsIgnoreCase("spleef")) {
							sender.sendMessage("§6-=-=-=-[§aTop 10 Elo §b§lSpleef§6]-=-=-=-");

						
						SortMapByValue.sortMapSpleefELO();
						
						for(int i = 1; i < 11 ; i++){
							try {
								Entry<String, Integer> e = SortMapByValue.sortedMapSpleefELO.pollFirstEntry();
							String pname = e.getKey();		            	 
							Integer score = e.getValue();
							sender.sendMessage("§6#"+ i + "§a " + pname + "§7:§b " + score);
				              } catch (Exception ex) {
				            	  sender.sendMessage("§6#"+ i + "§a NO_PLAYER" + "§7:§b 0");
				              }
							}
						sender.sendMessage("§6-=-=-=-[§aTop 10 Elo §b§lSpleef§6]-=-=-=-");
						sender.sendMessage(" ");
						sender.sendMessage(" ");
							return true;
				
						
					} else if (args[1].equalsIgnoreCase("ffaspleef")) {
						
						sender.sendMessage("§6-=-=-=-[§aTop 10 Wins §b§lFFASpleef§6]-=-=-=-");

							
							SortMapByValue.sortMapFFASpleefWins();
							
							for(int i = 1; i < 11 ; i++){
								try {
									Entry<String, Integer> e = SortMapByValue.sortedMapFFASpleefWins.pollFirstEntry();
								String pname = e.getKey();		            	 
								Integer score = e.getValue();
								sender.sendMessage("§6#"+ i + "§a " + pname + "§7:§b " + score);
					              } catch (Exception ex) {
					            	  sender.sendMessage("§6#"+ i + "§a NO_PLAYER" + "§7:§b 0");
					              }
								}
								return true;
				}
					
			}
				}  else {
					Player pa = Bukkit.getPlayer(args[0]);
				if (Bukkit.getOnlinePlayers().contains(pa)) {
				
					sender.sendMessage(" ");
					sender.sendMessage(" ");
					sender.sendMessage("§6-=-=-=-[§a§lEstadísticas§6]-=-=-=-");
					sender.sendMessage("§fRango Spleef: " +
							SpleefRankManager.getSpleefRankString(SpleefRankManager.getSpleefRankInt(Main.data.getConfig().getString("data." + pa.getUniqueId() + ".spleefrank")), false));
					sender.sendMessage("§6Nivel: §a" + DataManager.getLevel(pa));
					sender.sendMessage(" ");
					sender.sendMessage("§ePosición: §6#" + SortMapByValue.getTopRankSpleefELO(pa));
					sender.sendMessage("§eELO: §b" + DataManager.getElo(pa));
					sender.sendMessage(" ");
					sender.sendMessage("§6SPLEEF 1SV1");
					sender.sendMessage("§aJugadas: §b" + DataManager.getGames(pa));
					sender.sendMessage("§aGanadas: §b" + DataManager.getWins(pa));
					sender.sendMessage("§aPerdidas: §b" + DataManager.getLoses(pa));
					sender.sendMessage("§aG/J: §b" + DataManager.getKD(pa) + "§b%");
					sender.sendMessage("§6FFA SPLEEF");
					sender.sendMessage("§aJugadas: §b" + DataManager.getFFASpleefGames(pa));
					sender.sendMessage("§aGanadas: §b" + DataManager.getFFASpleefWins(pa));
					sender.sendMessage("§6-=-=-=-[§a§lEstadísticas§6]-=-=-=-");
				return true;
				} 
				
			}
			}
			}
		} else {
		if(cmd.getName().equalsIgnoreCase("stats")){
			Player p = (Player) sender;
			if (args.length == 0) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage(" ");
					p.sendMessage(" ");
					p.sendMessage("§6-=-=-=-[§a§lEstadísticas§6]-=-=-=-");
					p.sendMessage("§fRango Spleef: " +
							SpleefRankManager.getSpleefRankString(SpleefRankManager.getSpleefRankInt(Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank")), false));
					p.sendMessage("§6Nivel: §a" + DataManager.getLevel(p));
					p.sendMessage(" ");
					p.sendMessage("§ePosición: §6#" + SortMapByValue.getTopRankSpleefELO(p));
					p.sendMessage("§eELO: §b" + DataManager.getElo(p));
					p.sendMessage(" ");
					p.sendMessage("§6SPLEEF 1SV1");
					p.sendMessage("§aJugadas: §b" + DataManager.getGames(p));
					p.sendMessage("§aGanadas: §b" + DataManager.getWins(p));
					p.sendMessage("§aPerdidas: §b" + DataManager.getLoses(p));
					p.sendMessage("§aG/J: §b" + DataManager.getKD(p) + "§b%");
					p.sendMessage("§6FFA SPLEEF");
					p.sendMessage("§aJugadas: §b" + DataManager.getFFASpleefGames(p));
					p.sendMessage("§aGanadas: §b" + DataManager.getFFASpleefWins(p));
					p.sendMessage("§6-=-=-=-[§a§lEstadísticas§6]-=-=-=-");
				}  else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage(" ");
					p.sendMessage(" ");
					p.sendMessage("§6-=-=-=-[§a§lStats§6]-=-=-=-");
					p.sendMessage("§fSpleef rank: " +
					SpleefRankManager.getSpleefRankString(SpleefRankManager.getSpleefRankInt(Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank")), true));
					p.sendMessage("§6Level: §a" + DataManager.getLevel(p));
					p.sendMessage(" ");
					p.sendMessage("§ePosition: §6#" + SortMapByValue.getTopRankSpleefELO(p));
					p.sendMessage("§eELO: §b" + DataManager.getElo(p));
					p.sendMessage(" ");
					p.sendMessage("§6SPLEEF 1SV1");
					p.sendMessage("§aGames: §b" + DataManager.getGames(p));
					p.sendMessage("§aWins: §b" + DataManager.getWins(p));
					p.sendMessage("§aLoses: §b" + DataManager.getLoses(p));
					p.sendMessage("§aW/P: §b" + DataManager.getKD(p) + "§b%");
					p.sendMessage("§6FFA SPLEEF");
					p.sendMessage("§aGames: §b" + DataManager.getFFASpleefGames(p));
					p.sendMessage("§aWins: §b" + DataManager.getFFASpleefWins(p));
					p.sendMessage("§6-=-=-=-[§a§lStats§6]-=-=-=-");
					
				}
				return true;
			} 	else if (args[0].equalsIgnoreCase("top")) {
				if (args.length == 1) {
						p.sendMessage("§a/stats top <spleef|ffaspleef>");
						return true;
				} else if (args.length == 2) {
					if (args[1].equalsIgnoreCase("spleef")) {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§6-=-=-=-[§aTop 10 Elo §b§lSpleef§6]-=-=-=-");

					
					SortMapByValue.sortMapSpleefELO();
					
					for(int i = 1; i < 11 ; i++){
						try {
							Entry<String, Integer> e = SortMapByValue.sortedMapSpleefELO.pollFirstEntry();
						String pname = e.getKey();		            	 
						Integer score = e.getValue();
			            	  p.sendMessage("§6#"+ i + "§a " + pname + "§7:§b " + score);
			              } catch (Exception ex) {
			            	  p.sendMessage("§6#"+ i + "§a NO_PLAYER" + "§7:§b 0");
			              }
						}
					p.sendMessage("§6-=-=-=-[§aTop 10 Elo §b§lSpleef§6]-=-=-=-");
					p.sendMessage(" ");
					p.sendMessage(" ");
						return true;
			
					}  else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§6-=-=-=-[§aTop 10 Elo §b§lSpleef§6]-=-=-=-");

						
						SortMapByValue.sortMapSpleefELO();
						
						for(int i = 1; i < 11 ; i++){
							try {
								Entry<String, Integer> e = SortMapByValue.sortedMapSpleefELO.pollFirstEntry();
							String pname = e.getKey();		            	 
							Integer score = e.getValue();
				            	  p.sendMessage("§6#"+ i + "§a " + pname + "§7:§b " + score);
				              } catch (Exception ex) {
				            	  p.sendMessage("§6#"+ i + "§a NO_PLAYER" + "§7:§b 0");
				              }
							}
							return true;
					}
				} else if (args[1].equalsIgnoreCase("ffaspleef")) {
					
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§6-=-=-=-[§aTop 10 Wins §b§lFFASpleef§6]-=-=-=-");

						
						SortMapByValue.sortMapFFASpleefWins();
						
						for(int i = 1; i < 11 ; i++){
							try {
								Entry<String, Integer> e = SortMapByValue.sortedMapFFASpleefWins.pollFirstEntry();
							String pname = e.getKey();		            	 
							Integer score = e.getValue();
				            	  p.sendMessage("§6#"+ i + "§a " + pname + "§7:§b " + score);
				              } catch (Exception ex) {
				            	  p.sendMessage("§6#"+ i + "§a NO_PLAYER" + "§7:§b 0");
				              }
							}
							return true;
				
						}  else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§6-=-=-=-[§aTop 10 Wins §b§lFFASpleef§6]-=-=-=-");

							
							SortMapByValue.sortMapFFASpleefWins();
							
							for(int i = 1; i < 11 ; i++){
								try {
									Entry<String, Integer> e = SortMapByValue.sortedMapFFASpleefWins.pollFirstEntry();
								String pname = e.getKey();		            	 
								Integer score = e.getValue();
					            	  p.sendMessage("§6#"+ i + "§a " + pname + "§7:§b " + score);
					              } catch (Exception ex) {
					            	  p.sendMessage("§6#"+ i + "§a NO_PLAYER" + "§7:§b 0");
					              }
								}
								return true;
						}
				}
			}
				} else {
						Player pa = Bukkit.getPlayer(args[0]);
					if (Bukkit.getOnlinePlayers().contains(pa) && p.hasPermission("splindux.staff")) {
					
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage(" ");
						p.sendMessage(" ");
						p.sendMessage("§6-=-=-=-[§a§lEstadísticas§6]-=-=-=-");
						p.sendMessage("§fRango Spleef: " +
								SpleefRankManager.getSpleefRankString(SpleefRankManager.getSpleefRankInt(Main.data.getConfig().getString("data." + pa.getUniqueId() + ".spleefrank")), false));
						p.sendMessage("§6Nivel: §a" + DataManager.getLevel(pa));
						p.sendMessage(" ");
						p.sendMessage("§ePosición: §6#" + SortMapByValue.getTopRankSpleefELO(pa));
						p.sendMessage("§eELO: §b" + DataManager.getElo(pa));
						p.sendMessage(" ");
						p.sendMessage("§6SPLEEF 1SV1");
						p.sendMessage("§aJugadas: §b" + DataManager.getGames(pa));
						p.sendMessage("§aGanadas: §b" + DataManager.getWins(pa));
						p.sendMessage("§aPerdidas: §b" + DataManager.getLoses(pa));
						p.sendMessage("§aG/J: §b" + DataManager.getKD(pa) + "§b%");
						p.sendMessage("§6FFA SPLEEF");
						p.sendMessage("§aJugadas: §b" + DataManager.getFFASpleefGames(pa));
						p.sendMessage("§aGanadas: §b" + DataManager.getFFASpleefWins(pa));
						p.sendMessage("§6-=-=-=-[§a§lEstadísticas§6]-=-=-=-");
					}  else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage(" ");
						p.sendMessage(" ");
						p.sendMessage("§6-=-=-=-[§a§lStats§6]-=-=-=-");
						p.sendMessage("§fRango Spleef: " +
								SpleefRankManager.getSpleefRankString(SpleefRankManager.getSpleefRankInt(Main.data.getConfig().getString("data." + pa.getUniqueId() + ".spleefrank")), true));
						p.sendMessage("§6Level: §a" + DataManager.getLevel(pa));
						p.sendMessage(" ");
						p.sendMessage("§ePosition: §6#" + SortMapByValue.getTopRankSpleefELO(pa));
						p.sendMessage("§eELO: §b" + DataManager.getElo(pa));
						p.sendMessage(" ");
						p.sendMessage("§6SPLEEF 1SV1");
						p.sendMessage("§aGames: §b" + DataManager.getGames(pa));
						p.sendMessage("§aWins: §b" + DataManager.getWins(pa));
						p.sendMessage("§aLoses: §b" + DataManager.getLoses(pa));
						p.sendMessage("§aW/P: §b" + DataManager.getKD(pa) + "§b%");
						p.sendMessage("§6FFA SPLEEF");
						p.sendMessage("§aGames: §b" + DataManager.getFFASpleefGames(pa));
						p.sendMessage("§aWins: §b" + DataManager.getFFASpleefWins(pa));
						p.sendMessage("§6-=-=-=-[§a§lStats§6]-=-=-=-");
						
					}
					return true;
					} 
					
				}
		}
			
		
		
		}
			 
		
	
		return false;
	
	
		
	
	}
}