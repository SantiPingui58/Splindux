package com.santipingui58.spleef.utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
 
public class SortMapByValue {
 
	public static TreeMap<String, Integer> sortedMapSpleefELO = new TreeMap <String, Integer> ();
	public static TreeMap<String, Integer> sortedMapFFASpleefWins = new TreeMap <String, Integer> ();
	public static TreeMap<String, Integer> sortedMapMonthlyFFASpleefWins = new TreeMap <String, Integer> ();
	
	public static int getTopRankSpleefELO(Player p) {
		sortMapSpleefELO();
			
			int num = 0;
			Set<String> elo = Main.data.getConfig().getConfigurationSection("data").getKeys(false);
	    	for (@SuppressWarnings("unused") String s : elo) {
	    		num++;
	    		}
				for(int i = 1; i < num+1 ; i++){
		              Entry<String, Integer> e = sortedMapSpleefELO.pollFirstEntry();         
		              String pname = e.getKey();
		              if (pname.equals(p.getName())) {
		            	 
		            	  return i;
		              }
			
		
				}
				return sortedMapSpleefELO.size();
	}
	
	public static int getTopRankFFASpleefWins(Player p) {
		sortMapFFASpleefWins();
			
			int num = 0;
			Set<String> wins = Main.data.getConfig().getConfigurationSection("data").getKeys(false);
	    	for (@SuppressWarnings("unused") String s : wins) {
	    		num++;
	    		}
				for(int i = 1; i < num+1 ; i++){
		              Entry<String, Integer> e = sortedMapFFASpleefWins.pollFirstEntry();
		              String pname = e.getKey();
		              if (pname.equals(p.getName())) {
		            	 
		            	  return i;
		              }
			
		
				}
				return sortedMapFFASpleefWins.size();
	}
	
	public static TreeMap<String, Integer> getTop10SpleefELO() {
		sortMapSpleefELO();
		int num = 0;
		TreeMap<String, Integer> list = new TreeMap<String,Integer>();
		Set<String> elo = Main.data.getConfig().getConfigurationSection("data").getKeys(false);
    	for (@SuppressWarnings("unused") String s : elo) {
    		if (num <=11) {
    		num++;
    		} else {
    			break;
    		}
    		}
		for(int i = 1; i < num+1 ; i++){
            Entry<String, Integer> e = sortedMapSpleefELO.pollFirstEntry();
            String pname = e.getKey();
            Integer score = e.getValue();
            list.put(pname, score);
            
		}
		
		
		return list;
	}
	
	public static TreeMap<String, Integer> getTop10FFASpleefWins() {
		sortMapFFASpleefWins();
		int num = 0;
		TreeMap<String, Integer> list = new TreeMap<String,Integer>();
		Set<String> wins = Main.data.getConfig().getConfigurationSection("data").getKeys(false);
    	for (@SuppressWarnings("unused") String s : wins) {
    		if (num <=11) {
    		num++;
    		} else {
    			break;
    		}
    		}
		for(int i = 1; i < num+1 ; i++){
            Entry<String, Integer> e = sortedMapFFASpleefWins.pollFirstEntry();
            String pname = e.getKey();
            Integer score = e.getValue();
            list.put(pname, score);
            
		}
		
		
		return list;
	}
	
	public static TreeMap<String, Integer> getTop10MonthlyFFASpleefWins() {
		sortMapMonthlyFFASpleefWins();
		int num = 0;
		TreeMap<String, Integer> list = new TreeMap<String,Integer>();
		Set<String> wins = Main.data.getConfig().getConfigurationSection("ffa_monthly").getKeys(false);
    	for (@SuppressWarnings("unused") String s : wins) {
    		if (num <=11) {
    		num++;
    		} else {
    			break;
    		}
    		}
		for(int i = 1; i < num+1 ; i++){
            Entry<String, Integer> e = sortedMapMonthlyFFASpleefWins.pollFirstEntry();
            String pname = e.getKey();
            Integer score = e.getValue();
            list.put(pname, score);
            
		}
		
		
		return list;
	}
	
	
	
	
	public static  void sortMapSpleefELO() {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Set<String> elo = Main.data.getConfig().getConfigurationSection("data").getKeys(false);
    	for (String s : elo) {
    		
    		map.put(Main.data.getConfig().getString("data." +s + ".name"), Main.data.getConfig().getInt("data."+s+".ELO"));
    		if (Main.data.getConfig().getString("data."+s+".name")==null) {
    			Bukkit.broadcastMessage(s);
    		}
    	}

		 sortedMapSpleefELO = sortMapByValue(map);
		return; 
		
	}
	
	public static  void sortMapFFASpleefWins() {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Set<String> elo = Main.data.getConfig().getConfigurationSection("data").getKeys(false);
    	for (String s : elo) {
    		map.put(Main.data.getConfig().getString("data." +s + ".name"), Main.data.getConfig().getInt("data."+s+".FFASpleefStats.Ganadas"));
    	}

		 sortedMapFFASpleefWins = sortMapByValue(map);
		return; 
		
	}
	
public static  void sortMapMonthlyFFASpleefWins() {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Set<String> elo = Main.data.getConfig().getConfigurationSection("ffa_monthly").getKeys(false);
    	for (String s : elo) {
    		map.put(s, Main.data.getConfig().getInt("ffa_monthly."+s));
    	}

		 sortedMapMonthlyFFASpleefWins = sortMapByValue(map);
		return; 
		
	}
 
	public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
		Comparator<String> comparator = new ValueComparator(map);
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}
	
	
}