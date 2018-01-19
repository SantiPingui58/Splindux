package com.santipingui58.spleef.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Party {

	Player leader;
	List<Player> players =  new ArrayList<Player>();
	
	
	  public Party(Player leader, List<Player> players) {
	        this.leader = leader;
	        this.players = players;

	    }
	
	  
	  public Player getLeader() {
		  return this.leader;
	  }
	  public void setLeader(Player p) {
		  players.add(this.leader);
		  this.leader = p;  
	  }
	  
	  public List<Player> getPlayers() {
		  return this.players;
	  }
	  
	  public void addPlayer(Player p) {
		  this.players.add(p);
	  }
	  
	  public int getPartySize() {
		  int size = this.players.size() + 1;
		  return size;

	  }
	  
}

