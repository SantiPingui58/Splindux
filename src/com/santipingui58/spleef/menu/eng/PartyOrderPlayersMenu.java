package com.santipingui58.spleef.menu.eng;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.managers.PartyManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;
import com.santipingui58.spleef.utils.Party;



public class PartyOrderPlayersMenu extends MenuBuilder {

	
	 private static HashMap<Party,List<Player>> partyorder = new HashMap<Party, List<Player>>();
	 
	public PartyOrderPlayersMenu(Player p) {
		super("§b§lOrder Players", 3);
		
		s(1, new ItemBuilder(Material.BOOK).setTitle("§aSelect the players in the order you want them to be in the party.").
				build());
		
		Party party = PartyManager.getManager().getPartyByAnyPlayer(p);
		
			if (!partyorder.containsKey(party)) {
				partyorder.put(party, party.getPlayers());
			}
			
			
			
			
			
			for (Player pa : partyorder.get(party)) {
				
			 	ItemStack player = new ItemStack(Material.SKULL_ITEM, 1, (short)3);      
		        SkullMeta playerMeta = (SkullMeta) player.getItemMeta();
		        playerMeta.setOwner(pa.getName());
		        if (pa.isOnline()) {
			        playerMeta.setDisplayName("§a" +pa.getName());
		        } 
		        player.setItemMeta(playerMeta);
		        
				
			}
		
		
		
		
	
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 11) {
			GameManager.getManager().addUnrankedQueue(p, null);
		} else if (slot == 15) {
			new MapSelectorMenu(p).o(p);
		}
		else if (slot == 26) {
			new UnrankedMenu(p).o(p);
		}
	}

}
