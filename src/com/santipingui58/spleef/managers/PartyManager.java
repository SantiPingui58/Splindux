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
	 private List<Player> pcmode = new ArrayList<Player>();
	 
	private static PartyManager pm;
	
	
	  public static PartyManager getManager() {
	        if (pm == null)
	            pm = new PartyManager();

	        return pm;
	    }
	  
	public void createParty(Player leader) {
		
		Party party = new Party(leader);
		this.parties.add(party);
	}
	  
	  
	public void getPartyOrder(Party pa) {
		
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
	  
	  
	  public boolean isInPartyMode(Player p) {
		  if (this.pcmode.contains(p)) return true;
		  return false;
	  }
	  
	  
	  public void addPartyMode(Player p) {
		  this.pcmode.add(p);
	  }
	  
	  public void removePartyMode (Player p) {
		  this.pcmode.remove(p);
	  }
	  
	  
	  public void addPlayertoParty(Player p, Party party) {
		  party.getPlayers().add(p);
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
	  
	  public void changeLeader(Player leader, Player p) {
		  Party party = this.getPartyByAnyPlayer(leader);
		  
		  if (party.getLeader().equals(leader)) {
			  if (party.getPlayers().contains(p)) {
				  party.setLeader(p);
				  
				  for (Player pa : party.getPlayers()) {
					  if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						  pa.sendMessage("§5[Party] §b" + leader.getName() + "§a le ha dado el Lider de la Party a §b" + p.getName());
					  } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						  pa.sendMessage("§5[Party] §b" + leader.getName() + "§a has given the Leadership of the Party to §b" + p.getName());
					  }
				  }
				  
				  if (DataManager.getLang(leader).equalsIgnoreCase("ESP")) {
					  leader.sendMessage("§5[Party]§a Le has dado el Lider de la Party a §b" + p.getName());
				  } else if (DataManager.getLang(leader).equalsIgnoreCase("ENG")) {
					  leader.sendMessage("§5[Party] §aYou have gave the Leadership of the Party to §b" + p.getName());
				  }
				  
				  if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					  p.sendMessage("§5[Party] §b" + leader.getName() + "§a te ha dado el Lider de la Party");
				  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					  p.sendMessage("§5[Party] §b" + leader.getName() + "§a has given you the Leadership of the Party");
				  }
				  
				  
			  } else {
				  if (DataManager.getLang(leader).equalsIgnoreCase("ESP")) {
					  leader.sendMessage("§cEl jugador §b" + leader.getName() + "§c no existe o no se encuentra en tu Party.");
					} else if (DataManager.getLang(leader).equalsIgnoreCase("ENG")) {
						leader.sendMessage("§cThe player §b" + leader.getName() + "§c doesn't exists or is not in your Party.");
					}
			  }
		  }
		  
	  }
	  
	  
	  
	  
	  public void invitePlayer(final Player sender, final Player p) {
		  
		  if (PartyManager.getManager().getPartyByLeader(sender) == null) {
			  this.createParty(sender);
		  }
		  
		  Party party = PartyManager.getManager().getPartyByLeader(sender);
		  
		  Player leader = party.getLeader();
		  
		
		  if (sender.equals(getPartyByAnyPlayer(sender).getLeader())) {
		  if (this.isInParty(p)) {
			  if (party.getPlayers().contains(p)) {
				
				 if (DataManager.getLang(leader).equalsIgnoreCase("ESP")) {
					 leader.sendMessage("§5[Party] §cEste jugador ya se encuentra en tu Party.");
				 } else if (DataManager.getLang(leader).equalsIgnoreCase("ENG")) {
					 leader.sendMessage("§5[Party] §cThis player is already in your Party.");
					 
				 }
				 return;
				 
			  } else {
				  if (DataManager.getLang(leader).equalsIgnoreCase("ESP")) {
						 leader.sendMessage("§5[Party] §cEste jugador ya se encuentra en una Party.");
					 } else if (DataManager.getLang(leader).equalsIgnoreCase("ENG")) {
						 leader.sendMessage("§5[Party] §cThis player is already in a Party.");						 
					 }
					 return;
					 }
		  } else {
			  
			  
			  List<Player> requesteds = new ArrayList<Player>();
			if (partyrequest.containsKey(leader)) {
				
				for (Player pa : partyrequest.get(leader)) {
					requesteds.add(pa);
				}
				
			} 
				if (!requesteds.contains(p)) {
				requesteds.add(p);
				}
				partyrequest.put(leader, requesteds);
			
			  
			 if (DataManager.getLang(sender).equalsIgnoreCase("ESP")) {
			  sender.sendMessage("§5[Party] §eHas invitado a §b " + p.getName() + " §e a tu Party. El jugador tiene 1 minuto para aceptarlo." );
			 } else if (DataManager.getLang(sender).equalsIgnoreCase("ENG")) {
				  sender.sendMessage("§5[Party] §eYou have invited §b " + p.getName() + " §e to your Party. The player has 1 minute to accept it." );
			 }
			 
			 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				 p.sendMessage("§5[Party] §eEl jugador §b" + sender.getName() + "§e te ha invitado a su Party, escribe §a/party accept " 
			 + sender.getName() + "§e para aceptarla. §7(La solicitud expira en 1 minuto.)");
			 } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				 p.sendMessage("§5[Party] §eThe player §b" + sender.getName() + "§e has invited you to his/her Party, type §a/party accept " 
						 + sender.getName() + "§e to join it. §7(The request will expire in 1 minute.)");
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
						} catch (Exception e) {
						}
					}
			    }
			    , 1200L);
		  }
	  } else {
		  if (DataManager.getLang(sender).equalsIgnoreCase("ESP")) {
				 	 sender.sendMessage("§5[Party] §cNecesitas ser el Lider de la Party para invitar jugadores.");
			  
		  } else if (DataManager.getLang(sender).equalsIgnoreCase("ENG")) {
			  sender.sendMessage("§5[Party] §cYou need to be the Leader of the Party to invite players.");
		  }
	  }
	  }
	  
	  
	  
	  
	  
	  public void acceptParty(Player p, Player leader) {
		  if (!partyrequest.containsKey(leader)) {
			  if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				  p.sendMessage("§5[Party] §cNo tienes una solicitud de Party de §b " + leader.getName());
			  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				  p.sendMessage("§5[Party] §cYou dont have a Party solicitude from §b" + leader.getName());
			  }
			  return;
		  }
		  if (partyrequest.get(leader).contains(p)) {
			  partyrequest.get(leader).remove(p);
			  Party party = getPartyByLeader(leader);
			  party.getPlayers().add(p);
			  
			  for (Player pa : party.getPlayers()) {
				  if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
					  pa.sendMessage("§5[Party] §b" +p.getName() + " §eha entrado a la Party!");
				  } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
					  pa.sendMessage("§5[Party] §b" +p.getName() + " §ehas joined the Party!");
				  } 
			  }
			  
			  if (DataManager.getLang(party.getLeader()).equalsIgnoreCase("ESP")) {
				  party.getLeader().sendMessage("§5[Party] §b" +p.getName() + " §eha entrado a la Party!");
			  } else if (DataManager.getLang(party.getLeader()).equalsIgnoreCase("ENG")) {
				  party.getLeader().sendMessage("§5[Party] §b" +p.getName() + " §ehas joined the Party!");
			  } 
			  
		  } else {
			  if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				  p.sendMessage("§5[Party] §cNo tienes una solicitud de Party de §b " + leader.getName());
			  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				  p.sendMessage("§5[Party] §cYou dont have a Party solicitude from §b" + leader.getName());
			  }
		  }

	  }
	  
	  
	  
	  
	  
	  public void disbandParty(Player leader) {
		  if (this.isInParty(leader)) {
			  Party party =this.getPartyByAnyPlayer(leader);
			  if (party.getLeader().equals(leader)) {
				  for (Player p : party.getPlayers()) {
					  if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						  p.sendMessage("§5[Party] §cLa Party ha sido disolvida!");
					  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						  p.sendMessage("§5[Party] §cLa Party ha sido disolvida!");
					  }
				  }
				  
				  if (DataManager.getLang(leader).equalsIgnoreCase("ESP")) {
					  leader.sendMessage("§5[Party] §cHas disuelto la Party!");
				  } else if (DataManager.getLang(leader).equalsIgnoreCase("ENG")) {
					  leader.sendMessage("§5[Party] §cYou have dissolved the Party!");
				  }
				  
				  this.parties.remove(party);		  
			  } 
		  }
	  }
	  
	  
	  public void removePlayer(Player leader, Player p) {
		  Party party = this.getPartyByAnyPlayer(leader);
		  
		  if (party.getLeader().equals(leader)) {
			  if (!leader.equals(p)) {
				  party.getPlayers().remove(p);
				  
				  for (Player pa : party.getPlayers()) {
					  if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						  pa.sendMessage("§5[Party] §b" + leader.getName() + " §cha removido a §b " + p.getName() + "§c de la Party!");
					  } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						  pa.sendMessage("§5[Party] §b" + leader.getName() + " §chas removed §b" + p.getName() + "§c from the Party!");
					  }
				  }
				  
				  if (DataManager.getLang(leader).equalsIgnoreCase("ESP")) {
					  leader.sendMessage("§5[Party] §cHas removido a §b " + p.getName() + "§c de la Party!");
				  } else if (DataManager.getLang(leader).equalsIgnoreCase("ENG")) {
					  leader.sendMessage("§5[Party] §cYou have removed §b" + p.getName() + "§c from the Party!");
				  }
				  
				  
			  } else {
				  disbandParty(leader);
			  }
		  }
		  
	  }
	   
	  
	  public void quitPartyPlayer (Player p) {
		  if (this.isInParty(p)) {
			  Party party = this.getPartyByAnyPlayer(p);
			  if (party.getLeader().equals(p)) {
				  disbandParty(p);
			  } else {
				  
			  party.getPlayers().remove(p);
			 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				 p.sendMessage("§5[Party] §aHas salido de la Party!");
			 } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				 p.sendMessage("§5[Party] §aYou left the Party!");
			 }
			 
			 for (Player pa : party.getPlayers()) {
				 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					 pa.sendMessage("§5[Party] §b" + p.getName() +" §cha salido de la Party!");
				 } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					 pa.sendMessage("§5[Party] §b" + p.getName() + "§cleft the Party!");
				 }
			 }
			 
			  }
			  
	  } else {
		  if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			  p.sendMessage("§5[Party] §cNo te encuentras en ninguna Party.");
		  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			  p.sendMessage("§5[Party] §cYou are not in any Party.");
		  }
		  }
	  }
	  
	  
	  
	 
 	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  }
	
	
	
	
	




