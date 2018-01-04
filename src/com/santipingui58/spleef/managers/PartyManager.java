package com.santipingui58.spleef.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.utils.Party;


public class PartyManager {

	 private final List<Party> parties = new ArrayList<Party>();
	 private static HashMap<Player,List<Player>> partyrequest = new HashMap<Player, List<Player>>();
	 
	private static PartyManager pm;
	
	
	  public static PartyManager getManager() {
	        if (pm == null)
	            pm = new PartyManager();

	        return pm;
	    }
	  
	
	  public Party getPartyByLeader(Player pl){
	        for (Party p : this.parties) {
	            if (p.getLeader() == pl) {
	                return p;
	            }
	        }

	        return null; // Not found
	    }
	  
	  public boolean isInParty(Player p) {
		  for (Party pa : this.parties) {
			  if (pa.getLeader() == p || pa.getPlayers().contains(p)) {
				  return true;
			  }
		  }
		  
		  return false;
	  }
	  
	  
	  
	  
	  public Party getPartyByAnyPlayer (Player pl) {
		  
		  for (Party p : this.parties) {
	            if (p.getLeader() == pl || p.getPlayers().contains(pl)) {
	                return p;
	            }
	        }

	        return null; // Not found
	    }
	  
	  public List<Party> getAllParties() {
		  return this.parties;
	  }
	  
	  public void invitePlayer(final Player sender, Party pa, final Player p) {
		  
		  Player leader = pa.getLeader();
		  
		if (!this.isInParty(sender)) {
			Party party = new Party(sender, null);
			this.parties.add(party);
		}
		  
		  if (this.isInParty(p)) {
			  if (pa.getPlayers().contains(p)) {
				
				 if (DataManager.getLang(leader).equalsIgnoreCase("ESP")) {
					 leader.sendMessage("§cEste jugador ya se encuentra en tu Party.");
				 } else if (DataManager.getLang(leader).equalsIgnoreCase("ENG")) {
					 leader.sendMessage("§cThis player is already in your Party.");
					 
				 }
				 return;
				 
			  } else {
				  if (DataManager.getLang(leader).equalsIgnoreCase("ESP")) {
						 leader.sendMessage("§cEste jugador ya se encuentra en una Party.");
					 } else if (DataManager.getLang(leader).equalsIgnoreCase("ENG")) {
						 leader.sendMessage("§cThis player is already in a Party.");						 
					 }
					 return;
					 }
		  } else {
			  List<Player> requesteds = new ArrayList<Player>();
			  try {
				  requesteds = partyrequest.get(sender);
				  
			  } catch (Exception e) {}
			  requesteds.add(p);
			  partyrequest.put(sender, requesteds);
			  
			  
			 if (DataManager.getLang(sender).equalsIgnoreCase("ESP")) {
			  sender.sendMessage("§eHas invitado a §b " + p.getName() + " §e a tu Party. El jugador tiene 1 minuto para aceptarlo." );
			 } else if (DataManager.getLang(sender).equalsIgnoreCase("ENG")) {
				  sender.sendMessage("§eYou have invited §b " + p.getName() + " §e to your Party. The player has 1 minute to accept it." );
			 }
			 
			 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				 p.sendMessage("§eEl jugador §b" + sender.getName() + "§e te ha invitado a su Party, escribe §a/party accept " 
			 + sender.getName() + "§e para aceptarla. §7(La solicitud expira en 1 minuto.)");
			 } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				 p.sendMessage("§eThe player §b" + sender.getName() + "§e has invited you to his/her Party, type §a/party accept " 
						 + sender.getName() + "§e to join it. §§7(The request will expire in 1 minute.)");
			 		}
			  
			  
			  @SuppressWarnings("unused")
				int task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.get(), new Runnable()
			    {

					@Override
					public void run() {
						try {
							 List<Player> requesteds = new ArrayList<Player>();			 
							 requesteds = partyrequest.get(sender);
							 requesteds.remove(p);
						} catch (Exception e) {}
					}
			    }
			    , 1200L);
		  }
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  }
	
	
	
	
	




