package com.santipingui58.spleef.menu.eng;



import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.commands.DuelCommand;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;




public class DuelRequestMenu extends MenuBuilder {

	public static HashMap<Player,Integer> page = new HashMap<Player,Integer>();
	
	public DuelRequestMenu(Player p) {
		super("§a§lDuel a " + DuelCommand.temprequest.get(p).getName(), 2);
		
		if (page.get(p) == 1) {

		s(0, new ItemBuilder(Material.SNOW_BLOCK).setTitle("§aSnow Spleef - Mapa al azar").
				build());
		s(1, new ItemBuilder(Material.DIAMOND_SWORD).setTitle("§aBuild Spleef PvP - Mapa al azar").
				build());
		s(9, new ItemBuilder(Material.SNOW_BLOCK).setTitle("§aSnow Spleef - Selecciona un mapa").
				build());
		s(10, new ItemBuilder(Material.DIAMOND_SWORD).setTitle("§aBuild Spleef PvP - Selecciona un mapa").
				build());
		s(10, new ItemBuilder(Material.BOW).setTitle("§aBow Spleef - Selecciona un mapa").
				build());
		s(2, new ItemBuilder(Material.BOW).setTitle("§cBow Spleef - Mapa al zar").build());
		
		} else if (page.get(p)==2) {
			if (DuelCommand.game.get(p).equalsIgnoreCase("spleef")) {

				s(0, new ItemBuilder(Material.MAP).setTitle("§a§lSCT").
						build());
				
				s(1, new ItemBuilder(Material.MAP).setTitle("§a§lEnd").
						build());
				s(2, new ItemBuilder(Material.MAP).setTitle("§a§lJardín").
						build());
				s(3, new ItemBuilder(Material.MAP).setTitle("§a§lKraken").
						build());
				s(4, new ItemBuilder(Material.MAP).setTitle("§a§lIgnition").
						build());
				s(5, new ItemBuilder(Material.MAP).setTitle("§a§lNeon").
						build());
				s(6, new ItemBuilder(Material.MAP).setTitle("§a§lRuinas").
						build());
				
			} else if (DuelCommand.game.get(p).equalsIgnoreCase("BuildSpleefPvP")) {
				s(0, new ItemBuilder(Material.MAP).setTitle("§a§lTest").
						build());
			}  else if (DuelCommand.game.get(p).equalsIgnoreCase("bowspleef")) {
				s(0, new ItemBuilder(Material.MAP).setTitle("§a§lTest").
						build());
			} 
			
			
		}
	
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 0) {
			if (page.get(p)==1) {
				p.closeInventory();
				DuelCommand.game.put(p, "spleef");
				DuelCommand.duelrequest.put(p, DuelCommand.temprequest.get(p));
				msg(p);
			} else if (page.get(p)==2) {
				p.closeInventory();
				if (DuelCommand.game.get(p).equalsIgnoreCase("spleef")) {
					DuelCommand.map.put(p, "SCT");
				} else if (DuelCommand.game.get(p).equalsIgnoreCase("BuildSpleefPvP")) {
					DuelCommand.map.put(p, "Test");
				}  else if (DuelCommand.game.get(p).equalsIgnoreCase("bowspleef")) {
					DuelCommand.map.put(p, "Test");
				}
				DuelCommand.duelrequest.put(p, DuelCommand.temprequest.get(p));
				msg(p);
			}
		} else if (slot ==1) {
			if (page.get(p)==1) {
				p.closeInventory();
				DuelCommand.game.put(p, "BuildSpleefPvP");
				DuelCommand.duelrequest.put(p, DuelCommand.temprequest.get(p));
				msg(p);
				} else if (page.get(p)==2) {
					p.closeInventory();
					if (DuelCommand.game.get(p).equalsIgnoreCase("spleef")) {
						DuelCommand.map.put(p, "End");
					} 
					DuelCommand.duelrequest.put(p, DuelCommand.temprequest.get(p));
					msg(p);
				}
		} else if (slot == 2) {
			if (page.get(p)==1) {
				p.closeInventory();
				DuelCommand.game.put(p, "bowspleef");
				DuelCommand.duelrequest.put(p, DuelCommand.temprequest.get(p));
				msg(p);
			} else if (page.get(p)==2) {
					p.closeInventory();
					if (DuelCommand.game.get(p).equalsIgnoreCase("spleef")) {
						DuelCommand.map.put(p, "Jardin");
					} 
					DuelCommand.duelrequest.put(p, DuelCommand.temprequest.get(p));
					msg(p);
			}
		} else if (slot==3) {
			if (page.get(p)==2) {
				p.closeInventory();
				if (DuelCommand.game.get(p).equalsIgnoreCase("spleef")) {
					DuelCommand.map.put(p, "Kraken");
				} 
				DuelCommand.duelrequest.put(p, DuelCommand.temprequest.get(p));
				msg(p);
			}
		} else if (slot==4) {
			if (page.get(p)==2) {
				p.closeInventory();
				if (DuelCommand.game.get(p).equalsIgnoreCase("spleef")) {
					DuelCommand.map.put(p, "Ignition");
				} 
				DuelCommand.duelrequest.put(p, DuelCommand.temprequest.get(p));
				msg(p);
			}
		} else if (slot==5) {
			if (page.get(p)==2) {
				p.closeInventory();
				if (DuelCommand.game.get(p).equalsIgnoreCase("spleef")) {
					DuelCommand.map.put(p, "Neon");
				} 
				DuelCommand.duelrequest.put(p, DuelCommand.temprequest.get(p));
				msg(p);
			}
		} else if (slot==6) {
			if (page.get(p)==2) {
				p.closeInventory();
				if (DuelCommand.game.get(p).equalsIgnoreCase("spleef")) {
					DuelCommand.map.put(p, "Ruinas");
				} 
				DuelCommand.duelrequest.put(p, DuelCommand.temprequest.get(p));
				msg(p);
			}
		} else if (slot==9) {
			page.put(p, 2);
			DuelCommand.game.put(p, "spleef");
			new DuelRequestMenu(p).o(p);
		} else if (slot==10) {
			page.put(p, 2);
			DuelCommand.game.put(p, "BuildSpleefPvP");
			new DuelRequestMenu(p).o(p);
		} else if (slot==10) {
			page.put(p, 2);
			DuelCommand.game.put(p, "bowspleef");
			new DuelRequestMenu(p).o(p);
		}
	}
	
	
	static void msg(Player p) {
		
		if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			p.sendMessage("§aLe has enviado un duelo a §b" + DuelCommand.temprequest.get(p).getName() + "§a, de §6 " +
		 getGame(p)+"§a, " + getMap(p));  
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("§aYou have sent a duel to §b" + DuelCommand.temprequest.get(p).getName() + "§a, of  §6"
						+ getGame(p)+"§a, " + getMap(p));
			}
				if (DataManager.getLang(DuelCommand.temprequest.get(p)).equalsIgnoreCase("ESP")) {
				DuelCommand.temprequest.get(p).sendMessage("§3[Spleef] §aHas recibido un duelo de §b" + p.getName() + "§a de §6, " +
				getGame(p)+"§a, " +getMap(p));
				
				TextComponent message = new TextComponent("§2§l[Click para aceptar]");
				message.setColor( ChatColor.GREEN );
				message.setBold( true );
				message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/duel accept "+p.getName()));
				message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bAceptar el duelo").create()));
				DuelCommand.temprequest.get(p).spigot().sendMessage(message);
				
				} else if (DataManager.getLang(DuelCommand.temprequest.get(p)).equalsIgnoreCase("ENG")) {
					DuelCommand.temprequest.get(p).sendMessage("§3[Spleef] §aYou have received a duel of §b" + p.getName() + "§a, of §6" +
				getGame(p)+"§a, " + getMap(p));
					TextComponent message = new TextComponent("§2§l[Click to accept]");
					message.setColor( ChatColor.GREEN );
					message.setBold( true );
					message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/duel accept "+p.getName()));
					message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bAccept the duel").create()));
					DuelCommand.temprequest.get(p).spigot().sendMessage(message);
				}	
				DuelCommand.temprequest.remove(p);
	}
	
	static String getGame(Player p) {
		if (DuelCommand.game.get(p).equalsIgnoreCase("spleef")) {
			return "Spleef";
		} else if (DuelCommand.game.get(p).equalsIgnoreCase("bowspleef")) {
			return "BowSpleef";
		} else if (DuelCommand.game.get(p).equalsIgnoreCase("BuildSpleefPvP")) {
			return "BuildSpleefPvP";
		}
		
		return null;
		
	}
	
	static String getMap(Player p) {
		if (DuelCommand.map.get(p) == null) {
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				return "§aen un mapa al azar.";
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				return "§ain a random map.";
			}
		} else {
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				return "§aen el mapa §6§l"+DuelCommand.map.get(p)+"§a.";
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				return "§ain the map §6§l"+DuelCommand.map.get(p)+"§a.";
			}
		}
		return null;
	}

}
