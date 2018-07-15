package com.santipingui58.spleef.menu.eng;



import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import com.santipingui58.spleef.managers.PartyManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;
import com.santipingui58.spleef.utils.Party;




public class PartyMenu extends MenuBuilder {

	public PartyMenu(Player p) {
		super("§3Party Menu", 6);
		Party party = PartyManager.getManager().getPartyByAnyPlayer(p);
		ItemStack leader = new ItemStack(Material.SKULL_ITEM, 1, (short)3);       
        SkullMeta leaderMeta = (SkullMeta) leader.getItemMeta();
        leaderMeta.setOwner(party.getLeader().getName());
        List<String> lore = new ArrayList<String>();
        lore.add("§b§l" + party.getLeader().getName());
        leaderMeta.setLore(lore);
		leaderMeta.setDisplayName("§5§lParty Leader");
	    leader.setItemMeta(leaderMeta);
	    
       ItemStack sign = new ItemBuilder(Material.SIGN).setTitle("§3Players").
		build();
		
       ItemStack panel = new ItemBuilder(Material.STAINED_GLASS_PANE,1, (short)14).setTitle("§cNo Player").
    			build();
        
		
		
		s(4, new ItemBuilder(Material.DIAMOND).setTitle("§6§lChange Player's Order").
				addLore("§aSet the position of the players of the Party").
				build());

		s(10, new ItemBuilder(Material.DIAMOND_SPADE).setTitle("§b§lRanked Queues").
				addLore("§aJoin Ranked queues for 2v2 or 3v3 games").
				build());
		
		s(13, new ItemBuilder(Material.GOLD_SPADE).setTitle("§e§lParty Games").
				addLore("§aPlay different games with your Party's players").
				build());
	
		s(16, new ItemBuilder(Material.IRON_SPADE).setTitle("§b§lDuel Parties").
				addLore("§aView and challenge other parties to a duel.").
				build());
		
		s(22, leader);
		
		s(28, sign);
		s(34, sign);
		s(37, sign);
		s(43, sign);
		
		s(29, panel);
		s(30, panel);
		s(31, panel);
		s(32, panel);
		s(33, panel);
		
		s(38, panel);
		s(39, panel);
		s(40, panel);
		s(41, panel);
		s(42, panel);
		
		if (party.getPlayers().size() == 0) {
			
		} else if (party.getPlayers().size() <= 10) {
			 for(int i=0; i<party.getPlayers().size(); i++) { 
				 
				 	Player pa = party.getPlayers().get(i);
				 
				 	ItemStack player = new ItemStack(Material.SKULL_ITEM, 1, (short)3);      
			        SkullMeta playerMeta = (SkullMeta) player.getItemMeta();
			        playerMeta.setOwner(pa.getName());
			        if (pa.isOnline()) {
				        playerMeta.setDisplayName("§a" + pa.getName());
			        } else {
			        	playerMeta.setDisplayName("§c" + pa.getName());
			        }
			        player.setItemMeta(playerMeta);
			       
			        
			        
			        if (i<=4) {
			        	s(29+i, player);
			        } else if (i<=9){
			        	s(33+i, player);
			        }
				 
			 }
			
			
		} else {
		        	
			 for(int i=0; i<9; i++) { 
				 
				 	Player pa = party.getPlayers().get(i);
				 
				 	ItemStack player = new ItemStack(Material.SKULL_ITEM, 1, (short)3);       
			        SkullMeta playerMeta = (SkullMeta) player.getItemMeta();
			        playerMeta.setOwner(pa.getName());
			        if (pa.isOnline()) {
				        playerMeta.setDisplayName("§a" + pa.getName());
			        } else {
			        	playerMeta.setDisplayName("§c" + pa.getName());
			        }
			        player.setItemMeta(playerMeta);
			       
			        
			        
			        if (i<=4) {
			        	s(29+i, player);
			        } else if (i<=8){
			        	s(38+i, player);
			        } 
			 }
			 
			 
			 
			 
			 ItemStack more = new ItemStack(Material.TOTEM);       
		        ItemMeta moreMeta = more.getItemMeta();
		        List<String> loremore = new ArrayList<String>();
		       
			 
			 
			 for(int i=9; i<party.getPlayers().size(); i++) { 
				 Player pa = party.getPlayers().get(i);
				 if (pa.isOnline()) {
				 loremore.add("§b- §a " + pa.getName());
			 } else {
				 loremore.add("§b- §c " + pa.getName());
			 }       
			 }
			 
			   moreMeta.setLore(loremore);
		        more.setItemMeta(moreMeta);
		        
		        s(42, more);
		}
		
		
		
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
	if (slot == 13) {
		new PartyGamesMenu(p).o(p);
	}
	}
	

}
