package com.santipingui58.spleef.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;

public class FriendsManager {

	  public static boolean areFriends(Player p1, Player p2) {
		  if (Main.data.getConfig().contains("data." + p1.getUniqueId()) &&
				  Main.data.getConfig().contains("data." + p2.getUniqueId())) {
			  if (getFriends(p1)==null|| getFriends(p2)==null) {
				 return false; 
			  }
			  if (getFriends(p1).contains(p2.getUniqueId()) && getFriends(p2).contains(p1.getUniqueId())) {
				  return true;
			  }
		  }
		  return false;
	  }
	  
	public static List<String> getFriends(Player p) {
		  if (Main.data.getConfig().contains("data." + p.getUniqueId()+".friends")) {
				return Main.data.getConfig().getStringList("data."+p.getUniqueId()+".friends");
				  }
		return null;
  
	  } 
	
	
	
	public static void beFriends(Player p1, Player p2) {
		List<String> friends_p1 = new ArrayList<String>();
		List<String> friends_p2 = new ArrayList<String>();
		
		if (getFriends(p1)!=null) {
			for (String f : getFriends(p1)) {
				friends_p1.add(f);
			}
		}
		friends_p1.add(p2.getUniqueId().toString());
		
		
		
		
		if (getFriends(p2)!=null) {
			for (String f : getFriends(p2)) {
				friends_p2.add(f);
			}
		}
		friends_p2.add(p1.getUniqueId().toString());
		
		  if (Main.data.getConfig().contains("data." + p1.getUniqueId()) && 
			  Main.data.getConfig().contains("data."+p2.getUniqueId())) {
			  Main.data.getConfig().set("data." + p1.getUniqueId() + ".friends", friends_p1);
			  Main.data.getConfig().set("data." + p2.getUniqueId() + ".friends", friends_p2);
			  Main.data.save();
		  }
	}
	
}
