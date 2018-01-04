package com.santipingui58.spleef.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;

public class FriendsManager {

	  public static boolean areFriends(Player p1, Player p2) {
		  if (Main.data.getConfig().contains("data." + p1.getUniqueId()) &&
				  Main.data.getConfig().contains("data." + p1.getUniqueId())) {
			  if (getFriends(p1).contains(p2.getName()) && getFriends(p2).contains(p1.getName())) {
				  return true;
			  }
		  }
		  return false;
	  }
	  
	public static List<String> getFriends(Player p) {
		 List<String> friends = new ArrayList<String>();
		try {
		  if (Main.data.getConfig().contains("data." + p.getUniqueId())) {
				  Set<String> a = Main.data.getConfig().getConfigurationSection("data." + p.getUniqueId() + ".friends").getKeys(false);
				  for (String s : a) {
					  friends.add(s);
				  }
				  return friends;
		  }
		  } catch (Exception ex){}
		
		return friends;
  
	  } 
	
	public static void removeFriend (Player p1, String p2) {
		if (Main.data.getConfig().contains("data." + p1.getUniqueId())) {
			try {
			  Main.data.getConfig().set("data." + p1.getUniqueId() + ".friends." + p2, null);
			  
			  
			  Set<String> a = Main.data.getConfig().getConfigurationSection("data").getKeys(false);
			  
			  for (String s : a) {
				  if (Main.data.getConfig().getString("data." + s + ".name").equalsIgnoreCase(p2)) {
					  Main.data.getConfig().set("data." + s + ".friends." + p1.getName(), null);
					  break;
				  }
			  }
			  
			} catch (Exception e) {}
		  }
	}
	
	public static void addFriend(Player p1, String p2) {
		  if (Main.data.getConfig().contains("data." + p1.getUniqueId())) {
			  Main.data.getConfig().set("data." + p1.getUniqueId() + ".friends", p2);
		  }
	}
	
}
