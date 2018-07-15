package com.santipingui58.spleef.menu.eng;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.managers.PartyManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;
import com.santipingui58.spleef.utils.Party;



public class PartyGamesMenu extends MenuBuilder {

	
	
	
	public PartyGamesMenu(Player p) {
		super("§6§lParty Games", 3);
		
		ItemStack spleef1v1 = new ItemStack(Material.DIAMOND_SPADE);       
        ItemMeta spleef1v1Meta = spleef1v1.getItemMeta();
		
        ItemStack spleef2v2 = new ItemStack(Material.DIAMOND_SPADE);       
        ItemMeta spleef2v2Meta = spleef2v2.getItemMeta();
        
		Party party = PartyManager.getManager().getPartyByAnyPlayer(p);	
		List<Player> players = new ArrayList<Player>();
		players.add(party.getLeader());
		for (Player pa : party.getPlayers()) {
			if (pa.isOnline()) {
				if (!GameManager.getManager().isInGame(pa)) {
					players.add(pa);
					
				} else {
					if (!GameManager.getManager().isRanked(GameManager.getManager().getArenabyPlayer(pa))) {
						players.add(pa);
					}
				}
			}
		}
		s(2,new ItemBuilder (Material.SNOW_BLOCK).setTitle("§aSpleef FFA").build());
		
		if (players.size() >=4) {
			if (players.size()%4 == 0) {
				spleef2v2Meta.setDisplayName("§aSpleef 2v2");
				 List<String> lore = new ArrayList<String>();
				 for(int i=0; i<players.size(); i=i+4) {
					 Player p1 = players.get(i);
					 Player p2 = players.get(i+1);
					 Player p3 = players.get(i+2);
					 Player p4 = players.get(i+3);
					 lore.add("§a"+ p1.getName()+"-"+ p2.getName() + "§7 vs §a" + p3.getName() + "-" + p4.getName());
			}
				 
				 spleef2v2Meta.setLore(lore);
				 spleef2v2.setItemMeta(spleef2v2Meta);
				 s(1,spleef2v2);
			
		} else {
			spleef2v2Meta.setDisplayName("§6Spleef 2v2");
			 List<String> lore = new ArrayList<String>();
			for(int i=0; i<players.size(); i=i+4) {
				int number = 0;
				try {
					 Player p1 = players.get(i);
					 number=1;
					 Player p2 = players.get(i+1);
					 number=2;
					 Player p3 = players.get(i+2);
					 number=3;
					 Player p4 = players.get(i+3);
					 lore.add("§a"+ p1.getName()+"-"+ p2.getName() + "§7 vs §a" + p3.getName() + "-" + p4.getName());
				} catch (Exception e) {
					lore.add("§cNon-rival:");
					if (number==1) {
						lore.add("§a"+players.get(i).getName());
					} else if (number==2) {
						lore.add("§a"+players.get(i).getName());
						lore.add("§a"+players.get(i+1).getName());
					} else if (number==3) {
						lore.add("§a"+players.get(i).getName());
						lore.add("§a"+players.get(i+1).getName());
						lore.add("§a"+players.get(i+2).getName());
					}
					
				}
				 
				 
			 }
			 spleef2v2Meta.setLore(lore);
			spleef2v2.setItemMeta(spleef2v2Meta);
			 s(1,spleef2v2);
		}
		} else {
			spleef2v2Meta.setDisplayName("§cSpleef 2v2");
			List<String> lore1 = new ArrayList<String>();
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			lore1.add("§cNo hay suficientes jugadores para esta modalidad.");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				lore1.add("§cThere are not enough players to play this game.");
			}
			
			spleef2v2Meta.setLore(lore1);
			spleef2v2.setItemMeta(spleef2v2Meta);
			 s(1,spleef2v2);
			
		}
		
		if (players.size() >= 2) {
		if (players.size()%2 == 0) {
			spleef1v1Meta.setDisplayName("§aSpleef 1v1");
			 List<String> lore = new ArrayList<String>();
			 for(int i=0; i<players.size(); i=i+2) {
				 Player p1 = players.get(i);
				 Player p2 = players.get(i+1);
				 lore.add("§a"+ p1.getName() + "§7 vs §a" + p2.getName());
				 
				 
			 }
			 spleef1v1Meta.setLore(lore);
			 spleef1v1.setItemMeta(spleef1v1Meta);
			 s(0,spleef1v1);
			 
		} else {
			spleef1v1Meta.setDisplayName("§6Spleef 1v1");
			 List<String> lore = new ArrayList<String>();
			for(int i=0; i<players.size(); i=i+2) {
				try {
				 Player p1 = players.get(i);
				 Player p2 = players.get(i+1);
				 lore.add("§a"+ p1.getName() + "§7vs§a" + p2.getName());
				} catch (Exception e) {
					Player pa = players.get(i);
					lore.add("§cNon-rival:");
					lore.add("§a"+pa.getName());
				}
				 
				 
			 }
			 spleef1v1Meta.setLore(lore);
			spleef1v1.setItemMeta(spleef1v1Meta);
			 s(0,spleef1v1);
		}
		} else {

			
			spleef1v1Meta.setDisplayName("§cSpleef 1v1");
			List<String> lore = new ArrayList<String>();
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			lore.add("§cNo hay suficientes jugadores para esta modalidad.");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				lore.add("§cThere are not enough players to play this game.");
			}
			spleef1v1Meta.setLore(lore);
			spleef1v1.setItemMeta(spleef1v1Meta);
			s(0,spleef1v1);
		}
		
		
		}
        
		
	
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		
		Party party = PartyManager.getManager().getPartyByAnyPlayer(p);	
		List<Player> players = new ArrayList<Player>();
			players.add(party.getLeader());
			for (Player pa : party.getPlayers()) {
				if (pa.isOnline()) {
					if (!GameManager.getManager().isInGame(pa)) {
						players.add(pa);					
					} else {
						if (!GameManager.getManager().isRanked(GameManager.getManager().getArenabyPlayer(pa))) {
							players.add(pa);
						}
					}
				}
			}	
		
		
		if (slot == 0) {
			if (party.getLeader().equals(p)) {
				if (players.size() >=2) {
					if (players.size()%2 == 0) {
						for(int i=0; i<players.size(); i=i+2) {
							 Player p1 = players.get(i);
							 Player p2 = players.get(i+1);
							 GameManager.getManager().DuelGame(p1, p2, null);						 
						 }
					} else {
						for(int i=0; i<players.size(); i=i+2) {
						try {
							Player p1 = players.get(i);
							 Player p2 = players.get(i+1);
							 GameManager.getManager().DuelGame(p1, p2, null);
						} catch (Exception e) {}
					}
					}
				}
			} else {
				p.closeInventory();
				 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					 p.sendMessage("§5[Party] §cNecesitas ser el Lider de la Party para hacer esto.");
				  
			  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				  p.sendMessage("§5[Party] §cYou need to be the Leader of the Party to do this.");
			  }

			}
	

	
		} else if (slot == 1) {
			if (party.getLeader().equals(p)) {
				if (players.size() >=4) {
					if (players.size()%4 == 0) {
						for(int i=0; i<players.size(); i=i+4) {
							 Player p1 = players.get(i);
							 Player p2 = players.get(i+1);
							 Player p3 = players.get(i+2);
							 Player p4 = players.get(i+3);
							 GameManager.getManager().DuelGame2v2(p1, p2, p3, p4, null);			 
						 }
					} else {
						for(int i=0; i<players.size(); i=i+4) {
							try {
								 Player p1 = players.get(i);
								 Player p2 = players.get(i+1);
								 Player p3 = players.get(i+2);
								 Player p4 = players.get(i+3);
								 GameManager.getManager().DuelGame2v2(p1, p2, p3, p4, null);
							} catch (Exception e) {	
							 
							}
						 }
					}
				}
			} else {
				p.closeInventory();
				 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					 p.sendMessage("§5[Party] §cNecesitas ser el Lider de la Party para hacer esto.");
				  
			  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				  p.sendMessage("§5[Party] §cYou need to be the Leader of the Party to do this.");
			  }

			}
	

		
			
			
			
			
		} else if (slot == 2) {
			if (party.getLeader().equals(p)) {
			for (Player pa : players){
				GameManager.getManager().addSpleefFFAQueue(pa);
			}
			} else {
				p.closeInventory();
				 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					 p.sendMessage("§5[Party] §cNecesitas ser el Lider de la Party para hacer esto.");
				  
			  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				  p.sendMessage("§5[Party] §cYou need to be the Leader of the Party to do this.");
			  }

			}
		} else if (slot == 25) {
			new Unranked2vs2Menu(p).o(p);
		} else if (slot == 26) {
			p.closeInventory();
			p.sendMessage("§o§cComing soon...");
		}
	}

}
