package com.santipingui58.spleef.commands;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.PartyManager;
import com.santipingui58.spleef.utils.Party;

public class PartyCommand implements CommandExecutor{

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
			Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("party")){			
			if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§3/party invite <jugador> §7- §eInvita jugadores a tu Party");
					p.sendMessage("§3/party accept <jugador> §7- §eAceptar invitación a una Party");
					p.sendMessage("§3/party remove <jugador> §7- §eElimina jugadores de tu Party");
					p.sendMessage("§3/party duel <jugador> §7- §eMandar duelo al lider de otra Party");
					p.sendMessage("§3/party leader <jugador> §7- §eDar el liderazgo de tu Party a otro miembro de la misma");
					p.sendMessage("§3/party disband §7- §eDeshacer la Party");
					p.sendMessage(" ");				
					p.sendMessage("§3/party list §7- §eVer los integrantes de la Party");	
					p.sendMessage("§3/party leave §7- §eSalir de la Party");	
					p.sendMessage("§3/party help §7- §eMuestra esta ayuda");	
					p.sendMessage(" ");
					p.sendMessage("§3/pchat <texto> §7- §eHablar por el chat de la Party");
					p.sendMessage("§3/pc §7- §eHablar unicamente por el chat de la Party");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					
					p.sendMessage("§3/party invite <player> §7- §eInvite players to your Party");
					p.sendMessage("§3/party accept <jugador> §7- §eAccept an invitation to a Party");
					p.sendMessage("§3/party remove <player> §7- §eRemove player from your Party");			
					p.sendMessage("§3/party duel <player> §7- §eDuel the leader of another Party");
					p.sendMessage("§3/party leader <player> §7- §eGive the leader of the Party to another player of it");
					p.sendMessage("§3/party disband §7- §eDisband the Party");
					p.sendMessage(" ");
					p.sendMessage("§3/party list §7- §eSee the players of the Party");	
					p.sendMessage("§3/party leave §7- §eLeave the Party");	
					p.sendMessage("§3/party help §7- §eDisplays this help");	
					p.sendMessage(" ");
					p.sendMessage("§3/pchat <text> §7- §eTalk in the Party's chat");
					p.sendMessage("§3/pc §7- §eTalk only for the Party's chat");
				}
			} else if (args[0].equalsIgnoreCase("invite")) {
				if (args.length == 2) {
					Player pa = Bukkit.getPlayer(args[1]);
					if (Bukkit.getOnlinePlayers().contains(pa)) {
					PartyManager.getManager().invitePlayer(p, pa);
						} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cEl jugador §b" + args[1] + "§c no existe o no se encuentra conectado.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cThe player §b" + args[1] + "§c doesn't exists or is not online.");
						}
					}
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§3/party invite <jugador> §7- §eInvita jugadores a tu Party");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§3/party invite <player> §7- §eInvite players to your Party");
					}
				}
			} else if (args[0].equalsIgnoreCase("remove")) {
				if (args.length == 2) {
					Player pa = Bukkit.getPlayer(args[1]);
					if (Bukkit.getOnlinePlayers().contains(pa) && PartyManager.getManager().getPartyByAnyPlayer(p).getPlayers().contains(pa)) {
						if (PartyManager.getManager().getPartyByAnyPlayer(p).getLeader().equals(p)) {
						PartyManager.getManager().removePlayer(p, pa);
						} else {
							  if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
									 p.sendMessage("§5[Party] §cNecesitas ser el Lider de la Party para invitar jugadores.");
								  
							  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								  p.sendMessage("§5[Party] §cYou need to be the Leader of the Party to invite players.");
							  }
						}
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cEl jugador §b" + args[1] + "§c no existe o no se encuentra en tu Party.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cThe player §b" + args[1] + "§c doesn't exists or is not in your Party.");
						}
					}
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§3/party remove <jugador> §7- §eElimina jugadores de tu Party");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§3/party remove <player> §7- §eRemove player from your Party");	
					}
				}
			} else if (args[0].equalsIgnoreCase("leave")) {
				if (args.length == 1) {
					PartyManager.getManager().quitPartyPlayer(p);
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§3/party leave §7- §eSalir de la Party");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§3/party leave §7- §eLeave the Party");	
					}
					}
			} else if (args[0].equalsIgnoreCase("accept")) {
				if (args.length == 2) {
					Player pa = Bukkit.getPlayer(args[1]);
					if (Bukkit.getOnlinePlayers().contains(pa)) {
						PartyManager.getManager().acceptParty(p, pa);
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cEl jugador §b" + args[1] + "§c no existe o no se encuentra conectado.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cThe player §b" + args[1] + "§c doesn't exists or is not online.");
						}
					}
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§3/party leave §7- §eSalir de la Party");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§3/party leave §7- §eLeave the Party");	
					}
				}
			} else if (args[0].equalsIgnoreCase("list")) {
				if (PartyManager.getManager().isInParty(p)) {
					Party party = PartyManager.getManager().getPartyByAnyPlayer(p);
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§5-=-=-=-§e[Party]§5-=-=-=-");
					p.sendMessage("§aLider: §b" + party.getLeader().getName());
					
					
					List<String> names = new ArrayList<String>();
					
					
					for (Player pa : party.getPlayers()) {
						if (!party.getPlayers().isEmpty()) {
						names.add(pa.getName());
						} else {
						break;
						}
					}
					
					String result = String.join(", ", names);
					
					p.sendMessage("§aJugadores: §b" + result);
					p.sendMessage("§5-=-=-=-§e[Party]§5-=-=-=-");
					
					
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§5-=-=-=-§e[Party]§5-=-=-=-");
					p.sendMessage("§aLeader: §b" + party.getLeader().getName());
					
					
					List<String> names = new ArrayList<String>();
					
					
					for (Player pa : party.getPlayers()) {
						if (!party.getPlayers().isEmpty()) {
						names.add(pa.getName());
						} else {
						break;
						}
					}
					
					String result = String.join(", ", names);
					
					p.sendMessage("§aPlayers: §b" + result);
					
					p.sendMessage("§5-=-=-=-§e[Party]§5-=-=-=-");
				}
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNecesitas estar en una Party para ejecutar este comando.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou need to be in a Party to execute this command.");
				}
			}
			} else if (args[0].equalsIgnoreCase("leader")) {
				if (args.length == 2) {
					if (PartyManager.getManager().isInParty(p)) {
					Player pa = Bukkit.getPlayer(args[1]);
					if (Bukkit.getOnlinePlayers().contains(pa) && PartyManager.getManager().getPartyByAnyPlayer(p).getPlayers().contains(pa)) {
						if (PartyManager.getManager().getPartyByAnyPlayer(p).getLeader().equals(p)) {
							PartyManager.getManager().changeLeader(p, pa);
						} else {
							  if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
									 p.sendMessage("§5[Party] §cNecesitas ser el Lider de la Party para ceder el liderazgo de la Party.");
								  
							  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								  p.sendMessage("§5[Party] §cYou need to be the Leader of the Party to give the leadership to someone else.");
							  }
						}
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cEl jugador §b" + args[1] + "§c no existe o no se encuentra en tu Party.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cThe player §b" + args[1] + "§c doesn't exists or is not in your Party.");
						}
					}
					
					
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§cNecesitas estar en una Party para ejecutar este comando.");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§cYou need to be in a Party to execute this command.");
					}
				}
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§3/party leader <jugador> §7- §eDar el liderazgo de tu Party a otro miembro de la misma");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§3/party leader <player> §7- §eGive the leader of the Party to another player of it");
					}
				}
			
			}
		
		} else if (cmd.getName().equalsIgnoreCase("pchat")) {
			if (PartyManager.getManager().isInParty(p)) {
				
				 StringBuilder builder = new StringBuilder();
				    for (int i = 0; i < args.length; i++)
				    {
				      builder.append(args[i]).append(" ");
				    }
				  String message = builder.toString();
				  
				  for (Player party :PartyManager.getManager().getPartyByAnyPlayer(p).getPlayers()) {
					  if (!message.isEmpty()) {
					  party.sendMessage("§5[Party]§f " + p.getName() + "§a: §f" + message);
					  }
					  
				  }
				  if (!message.isEmpty()) {
				  PartyManager.getManager().getPartyByAnyPlayer(p).getLeader().sendMessage("§5[Party]§f " + p.getName() + "§a: §f" + message);
				  }
				  
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNecesitas estar en una Party para ejecutar este comando.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou need to be in a Party to execute this command.");
				}
			}
			
		} else if (cmd.getName().equalsIgnoreCase("pc")) {
			if (PartyManager.getManager().isInParty(p)) {
				if (PartyManager.getManager().isInPartyMode(p)) {
					
					PartyManager.getManager().removePartyMode(p);
					
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§3Ya no estás hablando por el chat de la Party");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")){
						p.sendMessage("§3You are not longer talking in the Party's chat");
					}
					
				} else if (!PartyManager.getManager().isInPartyMode(p)) {
					PartyManager.getManager().addPartyMode(p);
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§3Ahora estás hablando por el chat de la Party");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")){
						p.sendMessage("§3Now you are talking in the Party's chat");
					}
				
				}
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNecesitas estar en una Party para ejecutar este comando.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou need to be in a Party to execute this command.");
				}
			}
		}
		}
		return false;
	}
}