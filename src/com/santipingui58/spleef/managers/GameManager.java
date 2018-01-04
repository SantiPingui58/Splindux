package com.santipingui58.spleef.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.FFASpleefGame;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.game.RankedSpleefGame;
import com.santipingui58.spleef.game.SpleefGame;


public class GameManager {
	
	
	
	private static GameManager am;

    
    private final List<Game> arenas = new ArrayList<Game>();
    private final List<Game> rankedgames = new ArrayList<Game>();
    private GameManager() {}
    
    
    public static GameManager getManager() {
        if (am == null)
            am = new GameManager();

        return am;
    }
    
    public Game getArena(String s){
        for (Game a : this.arenas) {
            if (a.getId() == s) {
                return a;
            }
        }

        return null; // Not found
    }
    
    public boolean isRanked(Game g) {
    	if (this.rankedgames.contains(g)) {
    		return true;
    	}
    	return false;
    }
    
    public boolean is2vs2Spleef (Game g) {
    	if (g.getPlayer1().size() == 2 || g.getPlayer2().size() == 2) {
    		return true;
    	}
    	return false;
    }
    
    public Game getArenabyPlayer (Player p) {
    	for (Game a : this.arenas) {
    		if (a.getType().equalsIgnoreCase("spleef")) {
    		if (a.getPlayer1().contains(p) || a.getPlayer2().contains(p) || a.getSpectators().contains(p)) {
    			return a;
    		}
    		} else if (a.getType().equalsIgnoreCase("ffaspleef")) {
    			if (a.getPlayers().contains(p) || a.getSpectators().contains(p)) {
    				return a;
    			}
    		}
    	}
    	return null;
    }
    
 
    public Game loadArena(Location spawn1, Location spawn2,Location arena1, Location arena2, Location spect, String id, String tipo) {       

        Game a = new Game(spawn1, spawn2, arena1, arena2,spect, id, tipo);
        this.arenas.add(a);

        return a;
    }
    
    public void loadArenas() { 
    	int arenasint = 0;
    	Set<String> arenas = Main.arena.getConfig().getConfigurationSection("arenas").getKeys(false);
    		for (String b : arenas) {		
    			Location spawn1 = Main.getLoc(Main.arena.getConfig().getString("arenas." + b + ".spawn1"), true);
				Location spawn2 = Main.getLoc(Main.arena.getConfig().getString("arenas." + b + ".spawn2"), true);
				Location arena1 = Main.getLoc(Main.arena.getConfig().getString("arenas." + b + ".arena1"), true);
				Location arena2 = Main.getLoc(Main.arena.getConfig().getString("arenas." + b + ".arena2"), true);
				Location spect = Main.getLoc(Main.arena.getConfig().getString("arenas." +b + ".spect"), true);
				String tipo = Main.arena.getConfig().getString("arenas." +b + ".type");
				arenasint++;
				GameManager.getManager().loadArena(spawn1, spawn2, arena1, arena2, spect, b, tipo);
    		}
    		
    		Main.get().getLogger().info(arenasint+ " arenas cargadas!");
    }
    
    
    
    public void Countdown(final Game g) {
    		g.falseCanPlay();
    		reinicio(g);
    		if (g.getType().equalsIgnoreCase("spleef")) {
    			if (GameManager.getManager().is2vs2Spleef(g)) {
    				
    			} else {
    		cristalcolocar(g.getSpawn1(), g.getSpawn2());
    			}
    		}
    		      }

    	
    
    
    
    public void reinicio(Game g) {
    	
		  Location a = g.getArena1();
		  Location b =g.getArena2();
		  int ax = a.getBlockX();
		  int az = a.getBlockZ();
		  
		  int y = a.getBlockY();
		  
		  int bx = b.getBlockX();
		  int bz = b.getBlockZ();
		  
		  	
		  for (int x = ax; x < bx; x++) {
			  for (int z = az; z < bz; z++) {
				  Location aire = new Location (a.getWorld(), x, y, z);
				  if (aire.getBlock().getType().equals(Material.AIR)) {
				  aire.getBlock().setType(Material.SNOW_BLOCK);
				  }
			  }
		  }
	  }
    
    
    
    public void cristalquitar (Location l1, Location l2) {
		  int x1 =  l1.getBlockX();
			 int y1 = l1.getBlockY();
			 int z1 = l1.getBlockZ();
			 
			 int x2 =  l2.getBlockX();
			 int y2 = l2.getBlockY();
			 int z2 = l2.getBlockZ();
			 
			 int x1_1 = x1 +1;
			 int x1_2 = x1 -1;
			 
			 int x2_1 = x2 +1;
			 int x2_2 = x2 -1;
			 
			 int z1_1 = z1+1;
			 int z1_2 = z1-1;
			 
			 int z2_1 = z2+1;
			 int z2_2 = z2-1;
			 
			 Location vidrio1_1 = new Location (l1.getWorld(), x1_1, y1,z1);
			 Location vidrio1_2 = new Location (l1.getWorld(), x1_1, y1 + 1,z1);
			 
			 Location vidrio1_3 = new Location (l1.getWorld(), x1_2, y1,z1);
			 Location vidrio1_4 = new Location (l1.getWorld(), x1_2, y1+1,z1);
			 
			 Location vidrio1_5 = new Location (l1.getWorld(), x1, y1, z1_1);
			 Location vidrio1_6 = new Location (l1.getWorld(), x1, y1+1, z1_1);
			 
			 
			 Location vidrio1_7 = new Location (l2.getWorld(), x1, y1, z1_2);
			 Location vidrio1_8 = new Location (l2.getWorld(), x1, y1+1, z1_2);
			 Location vidrio1_9 = new Location (l2.getWorld(), x1,y1+2,z1);
			 
			 
			 
			 Location vidrio2_1 = new Location (l2.getWorld(), x2_1, y2,z2);
			 Location vidrio2_2 = new Location (l2.getWorld(), x2_1, y2 + 1,z2);
			 Location vidrio2_3 = new Location (l2.getWorld(), x2_2, y2,z2);
			 Location vidrio2_4 = new Location (l2.getWorld(), x2_2, y2+1,z2);
			 Location vidrio2_5 = new Location (l2.getWorld(), x2, y2, z2_1);
			 Location vidrio2_6 = new Location (l2.getWorld(), x2, y2+1, z2_1);
			 Location vidrio2_7 = new Location (l2.getWorld(), x2, y2, z2_2);
			 Location vidrio2_8 = new Location (l2.getWorld(), x2, y2+1, z2_2);
			 Location vidrio2_9 = new Location (l2.getWorld(), x2,y2+2,z2);
			 
			 
			 vidrio1_1.getBlock().setType(Material.AIR);
			 vidrio1_2.getBlock().setType(Material.AIR);
			 vidrio1_3.getBlock().setType(Material.AIR);
			 vidrio1_4.getBlock().setType(Material.AIR);
			 vidrio1_5.getBlock().setType(Material.AIR);
			 vidrio1_6.getBlock().setType(Material.AIR);
			 vidrio1_7.getBlock().setType(Material.AIR);
			 vidrio1_8.getBlock().setType(Material.AIR);
			 vidrio1_9.getBlock().setType(Material.AIR);
			 
			 vidrio2_1.getBlock().setType(Material.AIR);
			 vidrio2_2.getBlock().setType(Material.AIR);
			 vidrio2_3.getBlock().setType(Material.AIR);
			 vidrio2_4.getBlock().setType(Material.AIR);
			 vidrio2_5.getBlock().setType(Material.AIR);
			 vidrio2_6.getBlock().setType(Material.AIR);
			 vidrio2_7.getBlock().setType(Material.AIR);
			 vidrio2_8.getBlock().setType(Material.AIR);
			 vidrio2_9.getBlock().setType(Material.AIR);
			 
			 
		  }
    
    
    public  void cristalcolocar(Location l1, Location l2) {
		 int x1 =  l1.getBlockX();
		 int y1 = l1.getBlockY();
		 int z1 = l1.getBlockZ();
		 
		 int x2 =  l2.getBlockX();
		 int y2 = l2.getBlockY();
		 int z2 = l2.getBlockZ();
		 
		 int x1_1 = x1 +1;
		 int x1_2 = x1 -1;
		 
		 int x2_1 = x2 +1;
		 int x2_2 = x2 -1;
		 
		 int z1_1 = z1+1;
		 int z1_2 = z1-1;
		 
		 int z2_1 = z2+1;
		 int z2_2 = z2-1;
		 
		 Location vidrio1_1 = new Location (l1.getWorld(), x1_1, y1,z1);
		 Location vidrio1_2 = new Location (l1.getWorld(), x1_1, y1 + 1,z1);	 
		 Location vidrio1_3 = new Location (l1.getWorld(), x1_2, y1,z1);
		 Location vidrio1_4 = new Location (l1.getWorld(), x1_2, y1+1,z1);	 
		 Location vidrio1_5 = new Location (l1.getWorld(), x1, y1, z1_1);
		 Location vidrio1_6 = new Location (l1.getWorld(), x1, y1+1, z1_1);	 
		 Location vidrio1_7 = new Location (l2.getWorld(), x1, y1, z1_2);
		 Location vidrio1_8 = new Location (l2.getWorld(), x1, y1+1, z1_2);
		 Location vidrio1_9 = new Location (l2.getWorld(), x1,y1+2,z1);
		 
		 
		 Location vidrio2_1 = new Location (l2.getWorld(), x2_1, y2,z2);
		 Location vidrio2_2 = new Location (l2.getWorld(), x2_1, y2 + 1,z2);
		 Location vidrio2_3 = new Location (l2.getWorld(), x2_2, y2,z2);
		 Location vidrio2_4 = new Location (l2.getWorld(), x2_2, y2+1,z2);
		 Location vidrio2_5 = new Location (l2.getWorld(), x2, y2, z2_1);
		 Location vidrio2_6 = new Location (l2.getWorld(), x2, y2+1, z2_1);
		 Location vidrio2_7 = new Location (l2.getWorld(), x2, y2, z2_2);
		 Location vidrio2_8 = new Location (l2.getWorld(), x2, y2+1, z2_2);
		 Location vidrio2_9 = new Location (l2.getWorld(), x2,y2+2,z2);
		 
		 
		 vidrio1_1.getBlock().setType(Material.GLASS);
		 vidrio1_2.getBlock().setType(Material.GLASS);
		 vidrio1_3.getBlock().setType(Material.GLASS);
		 vidrio1_4.getBlock().setType(Material.GLASS);
		 vidrio1_5.getBlock().setType(Material.GLASS);
		 vidrio1_6.getBlock().setType(Material.GLASS);
		 vidrio1_7.getBlock().setType(Material.GLASS);
		 vidrio1_8.getBlock().setType(Material.GLASS);
		 vidrio1_9.getBlock().setType(Material.GLASS);
		 
		 vidrio2_1.getBlock().setType(Material.GLASS);
		 vidrio2_2.getBlock().setType(Material.GLASS);
		 vidrio2_3.getBlock().setType(Material.GLASS);
		 vidrio2_4.getBlock().setType(Material.GLASS);
		 vidrio2_5.getBlock().setType(Material.GLASS);
		 vidrio2_6.getBlock().setType(Material.GLASS);
		 vidrio2_7.getBlock().setType(Material.GLASS);
		 vidrio2_8.getBlock().setType(Material.GLASS);
		 vidrio2_9.getBlock().setType(Material.GLASS);
		 
		 
	  }
	  
    public void cristalquitar2v2 (Location l1, Location l2, Location l3, Location l4) {
    		int x1 =  l1.getBlockX() + 2;
			 int y1 = l1.getBlockY();
			 int z1 = l1.getBlockZ();
			 
			 int x2 =  l2.getBlockX() - 2;
			 int y2 = l2.getBlockY();
			 int z2 = l2.getBlockZ();
			 
			 
			 int x3 =  l3.getBlockX() + 2;
			 int y3 = l3.getBlockY();
			 int z3 = l3.getBlockZ();
			 
			 int x4 =  l4.getBlockX() - 2;
			 int y4 = l4.getBlockY();
			 int z4 = l4.getBlockZ();
			 
			 int x1_1 = x1 +1;
			 int x1_2 = x1 -1;
			 
			 int x2_1 = x2 +1;
			 int x2_2 = x2 -1;
			 
			 int z1_1 = z1+1;
			 int z1_2 = z1-1;
			 
			 int z2_1 = z2+1;
			 int z2_2 = z2-1;
			 
			 int x3_1 = x1 +1;
			 int x3_2 = x1 -1;
			 
			 int x4_1 = x2 +1;
			 int x4_2 = x2 -1;
			 
			 int z3_1 = z1+1;
			 int z3_2 = z1-1;
			 
			 int z4_1 = z2+1;
			 int z4_2 = z2-1;
			 
			 
			 
			 Location vidrio1_1 = new Location (l1.getWorld(), x1_1, y1,z1);
			 Location vidrio1_2 = new Location (l1.getWorld(), x1_1, y1 + 1,z1);		 
			 Location vidrio1_3 = new Location (l1.getWorld(), x1_2, y1,z1);
			 Location vidrio1_4 = new Location (l1.getWorld(), x1_2, y1+1,z1);		 
			 Location vidrio1_5 = new Location (l1.getWorld(), x1, y1, z1_1);
			 Location vidrio1_6 = new Location (l1.getWorld(), x1, y1+1, z1_1);
			 Location vidrio1_7 = new Location (l2.getWorld(), x1, y1, z1_2);
			 Location vidrio1_8 = new Location (l2.getWorld(), x1, y1+1, z1_2);
			 Location vidrio1_9 = new Location (l2.getWorld(), x1,y1+2,z1);

			 Location vidrio2_1 = new Location (l2.getWorld(), x2_1, y2,z2);
			 Location vidrio2_2 = new Location (l2.getWorld(), x2_1, y2 + 1,z2);
			 Location vidrio2_3 = new Location (l2.getWorld(), x2_2, y2,z2);
			 Location vidrio2_4 = new Location (l2.getWorld(), x2_2, y2+1,z2);
			 Location vidrio2_5 = new Location (l2.getWorld(), x2, y2, z2_1);
			 Location vidrio2_6 = new Location (l2.getWorld(), x2, y2+1, z2_1);
			 Location vidrio2_7 = new Location (l2.getWorld(), x2, y2, z2_2);
			 Location vidrio2_8 = new Location (l2.getWorld(), x2, y2+1, z2_2);
			 Location vidrio2_9 = new Location (l2.getWorld(), x2,y2+2,z2);
			 
			 Location vidrio3_1 = new Location (l3.getWorld(), x3_1, y3,z3);
			 Location vidrio3_2 = new Location (l3.getWorld(), x3_1, y3 + 1,z3);
			 Location vidrio3_3 = new Location (l3.getWorld(), x3_2, y3,z3);
			 Location vidrio3_4 = new Location (l3.getWorld(), x3_2, y3+1,z3);
			 Location vidrio3_5 = new Location (l3.getWorld(), x3, y3, z3_1);
			 Location vidrio3_6 = new Location (l3.getWorld(), x3, y3+1, z3_1);
			 Location vidrio3_7 = new Location (l3.getWorld(), x3, y3, z3_2);
			 Location vidrio3_8 = new Location (l3.getWorld(), x3, y3+1, z3_2);
			 Location vidrio3_9 = new Location (l3.getWorld(), x3,y3+2,z3);
			 
			 Location vidrio4_1 = new Location (l4.getWorld(), x4_1, y4,z4);
			 Location vidrio4_2 = new Location (l4.getWorld(), x4_1, y4 + 1,z4);
			 Location vidrio4_3 = new Location (l4.getWorld(), x4_2, y4,z4);
			 Location vidrio4_4 = new Location (l4.getWorld(), x4_2, y4+1,z4);
			 Location vidrio4_5 = new Location (l4.getWorld(), x4, y4, z4_1);
			 Location vidrio4_6 = new Location (l4.getWorld(), x4, y4+1, z4_1);
			 Location vidrio4_7 = new Location (l4.getWorld(), x4, y4, z4_2);
			 Location vidrio4_8 = new Location (l4.getWorld(), x4, y4+1, z4_2);
			 Location vidrio4_9 = new Location (l4.getWorld(), x4,y4+2,z4);
			 
			 
			 
			 vidrio1_1.getBlock().setType(Material.AIR);
			 vidrio1_2.getBlock().setType(Material.AIR);
			 vidrio1_3.getBlock().setType(Material.AIR);
			 vidrio1_4.getBlock().setType(Material.AIR);
			 vidrio1_5.getBlock().setType(Material.AIR);
			 vidrio1_6.getBlock().setType(Material.AIR);
			 vidrio1_7.getBlock().setType(Material.AIR);
			 vidrio1_8.getBlock().setType(Material.AIR);
			 vidrio1_9.getBlock().setType(Material.AIR);
			 
			 vidrio2_1.getBlock().setType(Material.AIR);
			 vidrio2_2.getBlock().setType(Material.AIR);
			 vidrio2_3.getBlock().setType(Material.AIR);
			 vidrio2_4.getBlock().setType(Material.AIR);
			 vidrio2_5.getBlock().setType(Material.AIR);
			 vidrio2_6.getBlock().setType(Material.AIR);
			 vidrio2_7.getBlock().setType(Material.AIR);
			 vidrio2_8.getBlock().setType(Material.AIR);
			 vidrio2_9.getBlock().setType(Material.AIR);
			 
			 
			 vidrio3_1.getBlock().setType(Material.AIR);
			 vidrio3_2.getBlock().setType(Material.AIR);
			 vidrio3_3.getBlock().setType(Material.AIR);
			 vidrio3_4.getBlock().setType(Material.AIR);
			 vidrio3_5.getBlock().setType(Material.AIR);
			 vidrio3_6.getBlock().setType(Material.AIR);
			 vidrio3_7.getBlock().setType(Material.AIR);
			 vidrio3_8.getBlock().setType(Material.AIR);
			 vidrio3_9.getBlock().setType(Material.AIR);
			 
			 vidrio4_1.getBlock().setType(Material.AIR);
			 vidrio4_2.getBlock().setType(Material.AIR);
			 vidrio4_3.getBlock().setType(Material.AIR);
			 vidrio4_4.getBlock().setType(Material.AIR);
			 vidrio4_5.getBlock().setType(Material.AIR);
			 vidrio4_6.getBlock().setType(Material.AIR);
			 vidrio4_7.getBlock().setType(Material.AIR);
			 vidrio4_8.getBlock().setType(Material.AIR);
			 vidrio4_9.getBlock().setType(Material.AIR);
			 
			 
		  }
  
    public void cristalcolocar2v2 (Location l1, Location l2, Location l3, Location l4) {
		int x1 =  l1.getBlockX() + 2;
		 int y1 = l1.getBlockY();
		 int z1 = l1.getBlockZ();
		 
		 int x2 =  l2.getBlockX() - 2;
		 int y2 = l2.getBlockY();
		 int z2 = l2.getBlockZ();
		 
		 
		 int x3 =  l3.getBlockX() + 2;
		 int y3 = l3.getBlockY();
		 int z3 = l3.getBlockZ();
		 
		 int x4 =  l4.getBlockX() - 2;
		 int y4 = l4.getBlockY();
		 int z4 = l4.getBlockZ();
		 
		 int x1_1 = x1 +1;
		 int x1_2 = x1 -1;
		 
		 int x2_1 = x2 +1;
		 int x2_2 = x2 -1;
		 
		 int z1_1 = z1+1;
		 int z1_2 = z1-1;
		 
		 int z2_1 = z2+1;
		 int z2_2 = z2-1;
		 
		 int x3_1 = x1 +1;
		 int x3_2 = x1 -1;
		 
		 int x4_1 = x2 +1;
		 int x4_2 = x2 -1;
		 
		 int z3_1 = z1+1;
		 int z3_2 = z1-1;
		 
		 int z4_1 = z2+1;
		 int z4_2 = z2-1;
		 
		 
		 
		 Location vidrio1_1 = new Location (l1.getWorld(), x1_1, y1,z1);
		 Location vidrio1_2 = new Location (l1.getWorld(), x1_1, y1 + 1,z1);		 
		 Location vidrio1_3 = new Location (l1.getWorld(), x1_2, y1,z1);
		 Location vidrio1_4 = new Location (l1.getWorld(), x1_2, y1+1,z1);		 
		 Location vidrio1_5 = new Location (l1.getWorld(), x1, y1, z1_1);
		 Location vidrio1_6 = new Location (l1.getWorld(), x1, y1+1, z1_1);
		 Location vidrio1_7 = new Location (l2.getWorld(), x1, y1, z1_2);
		 Location vidrio1_8 = new Location (l2.getWorld(), x1, y1+1, z1_2);
		 Location vidrio1_9 = new Location (l2.getWorld(), x1,y1+2,z1);

		 Location vidrio2_1 = new Location (l2.getWorld(), x2_1, y2,z2);
		 Location vidrio2_2 = new Location (l2.getWorld(), x2_1, y2 + 1,z2);
		 Location vidrio2_3 = new Location (l2.getWorld(), x2_2, y2,z2);
		 Location vidrio2_4 = new Location (l2.getWorld(), x2_2, y2+1,z2);
		 Location vidrio2_5 = new Location (l2.getWorld(), x2, y2, z2_1);
		 Location vidrio2_6 = new Location (l2.getWorld(), x2, y2+1, z2_1);
		 Location vidrio2_7 = new Location (l2.getWorld(), x2, y2, z2_2);
		 Location vidrio2_8 = new Location (l2.getWorld(), x2, y2+1, z2_2);
		 Location vidrio2_9 = new Location (l2.getWorld(), x2,y2+2,z2);
		 
		 Location vidrio3_1 = new Location (l3.getWorld(), x3_1, y3,z3);
		 Location vidrio3_2 = new Location (l3.getWorld(), x3_1, y3 + 1,z3);
		 Location vidrio3_3 = new Location (l3.getWorld(), x3_2, y3,z3);
		 Location vidrio3_4 = new Location (l3.getWorld(), x3_2, y3+1,z3);
		 Location vidrio3_5 = new Location (l3.getWorld(), x3, y3, z3_1);
		 Location vidrio3_6 = new Location (l3.getWorld(), x3, y3+1, z3_1);
		 Location vidrio3_7 = new Location (l3.getWorld(), x3, y3, z3_2);
		 Location vidrio3_8 = new Location (l3.getWorld(), x3, y3+1, z3_2);
		 Location vidrio3_9 = new Location (l3.getWorld(), x3,y3+2,z3);
		 
		 Location vidrio4_1 = new Location (l4.getWorld(), x4_1, y4,z4);
		 Location vidrio4_2 = new Location (l4.getWorld(), x4_1, y4 + 1,z4);
		 Location vidrio4_3 = new Location (l4.getWorld(), x4_2, y4,z4);
		 Location vidrio4_4 = new Location (l4.getWorld(), x4_2, y4+1,z4);
		 Location vidrio4_5 = new Location (l4.getWorld(), x4, y4, z4_1);
		 Location vidrio4_6 = new Location (l4.getWorld(), x4, y4+1, z4_1);
		 Location vidrio4_7 = new Location (l4.getWorld(), x4, y4, z4_2);
		 Location vidrio4_8 = new Location (l4.getWorld(), x4, y4+1, z4_2);
		 Location vidrio4_9 = new Location (l4.getWorld(), x4,y4+2,z4);
		 
		 
		 
		 vidrio1_1.getBlock().setType(Material.GLASS);
		 vidrio1_2.getBlock().setType(Material.GLASS);
		 vidrio1_3.getBlock().setType(Material.GLASS);
		 vidrio1_4.getBlock().setType(Material.GLASS);
		 vidrio1_5.getBlock().setType(Material.GLASS);
		 vidrio1_6.getBlock().setType(Material.GLASS);
		 vidrio1_7.getBlock().setType(Material.GLASS);
		 vidrio1_8.getBlock().setType(Material.GLASS);
		 vidrio1_9.getBlock().setType(Material.GLASS);
		 
		 vidrio2_1.getBlock().setType(Material.GLASS);
		 vidrio2_2.getBlock().setType(Material.GLASS);
		 vidrio2_3.getBlock().setType(Material.GLASS);
		 vidrio2_4.getBlock().setType(Material.GLASS);
		 vidrio2_5.getBlock().setType(Material.GLASS);
		 vidrio2_6.getBlock().setType(Material.GLASS);
		 vidrio2_7.getBlock().setType(Material.GLASS);
		 vidrio2_8.getBlock().setType(Material.GLASS);
		 vidrio2_9.getBlock().setType(Material.GLASS);
		 
		 
		 vidrio3_1.getBlock().setType(Material.GLASS);
		 vidrio3_2.getBlock().setType(Material.GLASS);
		 vidrio3_3.getBlock().setType(Material.GLASS);
		 vidrio3_4.getBlock().setType(Material.GLASS);
		 vidrio3_5.getBlock().setType(Material.GLASS);
		 vidrio3_6.getBlock().setType(Material.GLASS);
		 vidrio3_7.getBlock().setType(Material.GLASS);
		 vidrio3_8.getBlock().setType(Material.GLASS);
		 vidrio3_9.getBlock().setType(Material.GLASS);
		 
		 vidrio4_1.getBlock().setType(Material.GLASS);
		 vidrio4_2.getBlock().setType(Material.GLASS);
		 vidrio4_3.getBlock().setType(Material.GLASS);
		 vidrio4_4.getBlock().setType(Material.GLASS);
		 vidrio4_5.getBlock().setType(Material.GLASS);
		 vidrio4_6.getBlock().setType(Material.GLASS);
		 vidrio4_7.getBlock().setType(Material.GLASS);
		 vidrio4_8.getBlock().setType(Material.GLASS);
		 vidrio4_9.getBlock().setType(Material.GLASS);
		 
		 
	  }
	  
  
    
    public void crumble (Game g, int por) {
    	
    	  Location a = g.getArena1();
		  Location b =g.getArena2();
		  int ax = a.getBlockX();
		  int az = a.getBlockZ();
		  
		  int y = a.getBlockY();
		  
		  int bx = b.getBlockX();
		  int bz = b.getBlockZ();
		  

		  Player p1 = g.getPlayer1().get(0);
		  Player p2 = g.getPlayer2().get(0);
		  
		  
		  for (int x = ax; x < bx; x++) {
			  for (int z = az; z < bz; z++) {
				  Location aire = new Location (a.getWorld(), x, y, z);
				  if (!(p1.getLocation() == aire) || (!(p2.getLocation() == aire)) || 
						  !(g.getSpawn1() == aire) || (!(g.getSpawn2() == aire))) {
				  if (aire.getBlock().getType().equals(Material.SNOW_BLOCK)) {
				  aire.getBlock().setType(Material.AIR);
				  }
				  }
			  }
		  }
    }
    
    
    
    
    
    
    
    public boolean isStarted(Game g) {
    	if (g.getType().equalsIgnoreCase("ffaspleef")) {
    		if (g.getPlayers().isEmpty()) {
    			return false;
    		}
    		return true;
    	} else {
    	if ((g.getPlayer1().isEmpty()) && (g.getPlayer2().isEmpty())) {
    		return false;
    	} 
    	return true;
    }
    }
    
    public boolean isInGame(Player p) {
        for (Game a : this.arenas) {
        	if (a.getType().equalsIgnoreCase("spleef")) {
        		 if (a.getPlayer1().contains(p) || a.getPlayer2().contains(p))
                     return true;
        	} else if (a.getType().equalsIgnoreCase("ffaspleef")) {
        		if (a.getPlayers().contains(p))
        				  return true;
        	}
        	
           
        }
        return false;
    }
    
    public boolean isSpectating(Player p) {
        for (Game a : this.arenas) {
            if (a.getSpectators().contains(p))
                return true;
        }
        return false;
    }
    
    
    
    public int getQueueMapListRanked (String name) {
    	int queue = 0;
    	for (Game ga : this.arenas) {
    		if (ga.getType().equalsIgnoreCase("spleef")) {
    		if (GameManager.getManager().rankedgames.contains(ga)) {
    		if (ga.getId().contains(name)) {
    			queue = queue + ga.getQueue().size();
    		}
    	}
    	}
    	}
    	
		return queue;
    	
    }
    
    public int getQueueMapListUnranked (String name) {
    	int queue = 0;
    	for (Game ga : this.arenas) {
    		if (ga.getType().equalsIgnoreCase("spleef")) {
    		if (!GameManager.getManager().rankedgames.contains(ga)) {
    		if (ga.getId().contains(name)) {
    			queue = queue + ga.getQueue().size();
    		}
    	}
    		}
    	}
    	
		return queue;
    	
    }
    
    
    public List<Game> getArenasList() {
		return this.arenas;
    	
    }
    
    public void leaveQueue(Player p) {
    	for (Game g : getArenasList()) {
    		if (g.getQueue().contains(p)) {
    			g.getQueue().remove(p);
    			if (g.getType().equalsIgnoreCase("ffaspleef")) {
					if (!GameManager.getManager().isStarted(g)) {
						if (g.getQueue().size() <= 3) {
						for (Player pa : g.getQueue()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3[FFASpleef] §cNo hay suficientes jugadores, partida cancelada.");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3[FFASpleef] §cThere are not enough players, game cancelled.");
							}
						}
						}
					}
				}
    		}
    	}
    	p.teleport(Main.getLoc(Main.arena.getConfig().getString("lobby")));
    	if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    		p.sendMessage("§3[Spleef] §6Has salido de la cola");
    	} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
    		p.sendMessage("§3[Spleef] §6You have been removed from the queue");
    	}
    	
    	
    	
    	p.getInventory().clear();
    	Main.giveItems(p);
    }
    
    
    
    public void addSpleefFFAQueue (Player p) {
    	for (final Game g : this.arenas) {
    			if (g.getType().equalsIgnoreCase("ffaspleef")) {
    				Main.givequeueItems(p);
    				g.getQueue().add(p);
    				p.teleport(g.getSpect());
    				if (GameManager.getManager().isStarted(g)) {
    					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    		    			p.sendMessage("§3[Spleef] §6Añadido a la cola para §aFFASpleef");
    		    			p.sendMessage("§aPodrás jugar una vez que la actual partida termine.");
    		    		} else 	if (DataManager.getLang(p).equalsIgnoreCase("ESP")) { 
    		    			p.sendMessage("§3[Spleef] §6Added to the queue for §aFFASpleef");
    		    			p.sendMessage("§aYou can play when the current game is over.");
    		    		}
    					
    				} else {
    					for (Player pa: g.getQueue()) {
    						if (pa != p) {
    							if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
    	    		    			pa.sendMessage("§3[Spleef] §b" + p.getName() + " §aha entrado a la Queue. §7(§e" + g.getQueue().size() + "§7)");
    	    		    		} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) { 
    	    		    			pa.sendMessage("§3[Spleef] §b" + p.getName() + " §ahas joined the Queue. §7(§e" + g.getQueue().size() + "§7)");
    	    		    		}
    						}
    					}
    					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    		    			p.sendMessage("§3[Spleef] §6Añadido a la cola para §aFFASpleef");
    		    		} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) { 
    		    			p.sendMessage("§3[Spleef] §6Added to the queue for §aFFASpleef");
    		    		}
    					if (g.getQueue().size() >= 3) {
    						for (Player pa : g.getQueue()) {
    							if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
    	    		    			pa.sendMessage("§3[Spleef] §6La partida comenzará en 5 segundos.");
    	    		    		} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) { 
    	    		    			pa.sendMessage("§3[Spleef] §6The game starts in 5 seconds.");
    	    		    		}
    						}
    						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.get(), new Runnable()
    					    {

    							public void run()
    					        {  if (g.getQueue().size() >= 3) {
    					        	FFASpleefGame.startCountdown(g.getId());
    					          }
    								
    					        }
    					      }
    					      , 100L);
    				}
    				}	
    				return;
    	}
    			
    	}
    	
    	
    	if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			 p.sendMessage("§cNo hay arenas disponibles en este momento, por favor intenta más tarde.");
		 } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			 p.sendMessage("§cThere are not available arenas, please try again later.");
		 }
		p.closeInventory();
		
		//Scoreboard FFASpleef hacer
   	return;
    	
    }
    
  
    
    public void addUnrankedQueue(Player p, String id) {	
    	if (id == null) { 	
    		for (Game g : this.arenas) {
    			if (g.getType().equalsIgnoreCase("spleef")) {
    			if (g.getPlayer1().isEmpty() && g.getPlayer2().isEmpty()) {
    		if (g.getQueue().size() >= 1) {
    			if (!GameManager.getManager().rankedgames.contains(g)) {
    			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    			p.sendMessage("§3[Spleef] §6Añadido a la cola §bUnranked §6para §aSnow Spleef 1vs1§6, en el mapa §b" + g.getId());
    			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
    				p.sendMessage("§3[Spleef] §6Added to the §bUnranked §6queue for §aSnow Spleef 1vs1§6, in the arena §b" + g.getId());
    			}
    			g.getQueue().add(p);
    			checkQueue(g, false);
    			Main.givequeueItems(p);
    			return;
    			}
    		}
    			}  
    		}
    			}
    		
    			ArrayList<Game> av = new ArrayList<Game>();
    			for (Game g : this.arenas) {
    				if (g.getType().equalsIgnoreCase("spleef")) {
    				if (g.getPlayer1().isEmpty() && g.getPlayer2().isEmpty()) {
    				if (g.getQueue().isEmpty()) {
    					av.add(g);
    				}
    				}
    			}
    	}
    			int min = 0;
				int max = av.size()-1;
				Random randomNo = new Random();
				for (Game ga : av) {
					int no = 0;
					try {
				 no = randomNo.nextInt((max-min) + 1) + min;
					} catch (Exception e) {
						no = 0;
					}
				ga = av.get(no);
    					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    		    			p.sendMessage("§3[Spleef] §6Añadido a la cola §bUnranked §6para §aSnow Spleef 1vs1§6, en el mapa §b" + ga.getId());
    		    			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
    		    				p.sendMessage("§3[Spleef] §6Added to the §bUnranked §6queue for §aSnow Spleef 1vs1§6, in the arena §b" + ga.getId());
    		    			}
    				ga.getQueue().add(p);
    				Main.givequeueItems(p);
    				return;
				
    			
    	
    	}
    		if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				 p.sendMessage("§cNo hay arenas disponibles en este momento, por favor intenta más tarde.");
			 } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				 p.sendMessage("§cThere are not available arenas, please try again later.");
			 }
    		
    		} else {
    				for (Game g : this.arenas) {
    					if (g.getType().equalsIgnoreCase("spleef")) {
    					if (g.getPlayer1().isEmpty() && g.getPlayer2().isEmpty()) {
    					if (Main.containsIgnoreCase(g.getId(), id)) {
    		    		if (g.getQueue().size() >= 1) {
    		    			if (!GameManager.getManager().rankedgames.contains(g)) {
    		    				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    		    	    			p.sendMessage("§3[Spleef] §6Añadido a la cola §bUnranked §6para §aSnow Spleef 1vs1§6, en el mapa §b" + g.getId());
    		    	    			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
    		    	    				p.sendMessage("§3[Spleef] §6Added to the §bUnranked §6queue for §aSnow Spleef 1vs1§6, in the arena §b" + g.getId());
    		    	    			}
    		    			g.getQueue().add(p);
    		    			checkQueue(g, false);
    		    			Main.givequeueItems(p);
    		    			return;
    		    			}
    		    		}
    		    		}
    		    			}  
    				}
    		}
    				
    					ArrayList<Game> av = new ArrayList<Game>();
    		    			for (Game g : this.arenas) {
    		    				if (g.getType().equalsIgnoreCase("spleef")) {
    		    				if (g.getPlayer1().isEmpty() && g.getPlayer2().isEmpty()) {
    		    				if (Main.containsIgnoreCase(g.getId(), id)) {
    		    					if (g.getQueue().isEmpty()) {
    		    						av.add(g);
    		    					}
    		    				}
    		    					int min = 0;
		    						int max = av.size()-1;
		    						Random randomNo = new Random();
		    						int no = 0;
		    						try {
		    						 no = randomNo.nextInt((max-min) + 1) + min;
		    						} catch (Exception e) {
		    							no = 0;
		    						}
    		    					for (Game ga : av) {
    		    						
    		    						ga = av.get(no);
    		    						
    		    						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    		    			    			p.sendMessage("§3[Spleef] §6Añadido a la cola §bUnranked §6para §aSnow Spleef 1vs1§6, en el mapa §b" + ga.getId());
    		    			    			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
    		    			    				p.sendMessage("§3[Spleef] §6Added to the §bUnranked §6queue for §aSnow Spleef 1vs1§6, in the arena §b" + ga.getId());
    		    			    			}
    		    				ga.getQueue().add(p);
    		    				Main.givequeueItems(p);
    		    				return;
    		    				}
    		    			
    		    				}
    		    			}
    		    			}
    				
    				 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    					 p.sendMessage("§cNo hay arenas disponibles en este momento, por favor intenta más tarde.");
    				 } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
    					 p.sendMessage("§cThere are not available arenas, please try again later.");
    				 }			
    		} 
    	}

    
    
    public void addRankedQueue(Player p, String id) {	
    	if (id == null) { 	
    		for (Game g : this.arenas) {
    			if (g.getType().equalsIgnoreCase("spleef")) {
    			if (g.getPlayer1().isEmpty() && g.getPlayer2().isEmpty()) {
    		if (g.getQueue().size() >= 1) {
    			if (GameManager.getManager().rankedgames.contains(g)) {
    				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    	    			p.sendMessage("§3[Spleef] §6Añadido a la cola §bRanked §6para §aSnow Spleef 1vs1§6, en el mapa §b" + g.getId());
    	    			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
    	    				p.sendMessage("§3[Spleef] §6Added to the §bRanked §6queue for §aSnow Spleef 1vs1§6, in the arena §b" + g.getId());
    	    			}
    			g.getQueue().add(p);
    			checkQueue(g, true);
    			Main.givequeueItems(p);
    			return;
    			}
    		}
    		}  
    			}
    	}
    			ArrayList<Game> av = new ArrayList<Game>();
    			for (Game g : this.arenas) {
    				if (g.getType().equalsIgnoreCase("spleef")) {
    				if (g.getPlayer1().isEmpty() && g.getPlayer2().isEmpty()) {
    				if (g.getQueue().isEmpty()) {
    				av.add(g);
    				}
    			}
    				}
    			}
    			
    			int min = 0;
				int max = av.size()-1;
				Random randomNo = new Random();
				int no = 0;
				try {
				 no = randomNo.nextInt((max-min) + 1) + min;		
				} catch (Exception e) {
					no = 0;
				}
    			for (Game ga : av) {
    				ga = av.get(no);
    					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
        	    			p.sendMessage("§3[Spleef] §6Añadido a la cola §bRanked §6para §aSnow Spleef 1vs1§6, en el mapa §b" + ga.getId());
        	    			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
        	    				p.sendMessage("§3[Spleef] §6Added to the §bRanked §6queue for §aSnow Spleef 1vs1§6, in the arena §b" + ga.getId());
        	    			}
    				GameManager.getManager().rankedgames.add(ga);
    				ga.getQueue().add(p);
    				Main.givequeueItems(p);
    				return;
    				
    			
    				}
    		
    		if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				 p.sendMessage("§cNo hay arenas disponibles en este momento, por favor intenta más tarde.");
			 } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				 p.sendMessage("§cThere are not available arenas, please try again later.");
			 }
    		
    		} else {
    				for (Game g : this.arenas) {
    					if (g.getType().equalsIgnoreCase("spleef")) {
    					if (g.getPlayer1().isEmpty() && g.getPlayer2().isEmpty()) {
    					if (Main.containsIgnoreCase(g.getId(), id)) {
    		    		if (g.getQueue().size() >= 1) {
    		    			if (GameManager.getManager().rankedgames.contains(g)) {
    		    				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    		    	    			p.sendMessage("§3[Spleef] §6Añadido a la cola §bRanked §6para §aSnow Spleef 1vs1§6, en el mapa §b" + g.getId());
    		    	    			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
    		    	    				p.sendMessage("§3[Spleef] §6Added to the §bRanked §6queue for §aSnow Spleef 1vs1§6, in the arena §b" + g.getId());
    		    	    			}
    		    			g.getQueue().add(p);
    		    			checkQueue(g, true);
    		    			Main.givequeueItems(p);
    		    			return;
    		    			}
    		    		}
    		    			}  
    				}
    					}
    		}
    				
    				ArrayList<Game> av = new ArrayList<Game>();
    		    			for (Game g : this.arenas) {
    		    				if (g.getPlayer1().isEmpty() && g.getPlayer2().isEmpty()) {
    		    				if (Main.containsIgnoreCase(g.getId(), id)) {
    		    					if (g.getQueue().isEmpty()) {
    		    						av.add(g);
    		    					}
    		    				}
    		    					}
    		    				}
    		    			
    		    			int min = 0;
    						int max = av.size()-1;
    						Random randomNo = new Random();
    						int no = 0;
    						try {
    						no = randomNo.nextInt((max-min) + 1) + min;	
    						} catch (Exception e) {
    							no = 0;
    						}
    		    				for (Game ga : av) {
    		    					ga = av.get(no);
    		    						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    		    	    	    			p.sendMessage("§3[Spleef] §6Añadido a la cola §bRanked §6para §aSnow Spleef 1vs1§6, en el mapa §b" + ga.getId());
    		    	    	    			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
    		    	    	    				p.sendMessage("§3[Spleef] §6Added to the §bRanked §6queue for §aSnow Spleef 1vs1§6, in the arena §b" + ga.getId());
    		    	    	    			}
    		    				GameManager.getManager().rankedgames.add(ga);
    		    				ga.getQueue().add(p);
    		    				Main.givequeueItems(p);
    		    				return;
    		    				
    		    				}
    		    		
    		    			}
    				
    				 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
    					 p.sendMessage("§cNo hay arenas disponibles en este momento, por favor intenta más tarde.");
    				 } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
    					 p.sendMessage("§cThere are not available arenas, please try again later.");
    				 }			
    		} 
    	
    	
    


public void DuelGame (Player p1, Player p2, String id) {
	if (id == null) {
		ArrayList<Game> av = new ArrayList<Game>();
		 for (Game g : getArenasList()) {
			 if (g.getType().equalsIgnoreCase("spleef")) {
			 if (g.getQueue().size() == 0) {
				 av.add(g);
			 }
			 }
		 }
		 	int min = 0;
			int max = av.size()-1;
			Random randomNo = new Random();
			int no = randomNo.nextInt((max-min) + 1) + min;		
			
		 	for (Game ga : av) {
		 		ga = av.get(no);
				 ga.getQueue().add(p1);
					ga.getQueue().add(p2);
					checkQueue(ga, false);
					return;
			 }
		 	
		 
		 if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
			 p1.sendMessage("§cNo hay arenas disponibles en este momento, por favor intenta más tarde.");
		 } else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
			 p1.sendMessage("§cThere are not available arenas, please try again later.");
		 }
		if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
		 p2.sendMessage("§cNo hay arenas disponibles en este momento, por favor intenta más tarde.");
		} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
			p2.sendMessage("§cThere are not available arenas, please try again later.");
		}
		 return;
	} else {
	for (Game g : getArenasList()) {
		if (g.getType().equalsIgnoreCase("spleef")) {
		if (Main.containsIgnoreCase(g.getId(), id)) {
			if (g.getQueue().size() == 0) {
			g.getQueue().add(p1);
			g.getQueue().add(p2);
			checkQueue(g,false);
			return;
			}
		}
		}
		
		 if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
			 p1.sendMessage("§cNo hay arenas disponibles en este momento, por favor intenta más tarde.");
		 } else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
			 p1.sendMessage("§cThere are not available arenas, please try again later.");
		 }
		if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
		 p2.sendMessage("§cNo hay arenas disponibles en este momento, por favor intenta más tarde.");
		} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
			p2.sendMessage("§cThere are not available arenas, please try again later.");
		}
	}
	}
}

public void checkQueue(Game g, boolean isranked) {
		if (g.getQueue().size() >= 2) {
			Player p1 = g.getQueue().get(0);
			Player p2 = g.getQueue().get(1);
			
			g.getQueue().remove(p1);
			g.getQueue().remove(p2);
			
			g.getPlayer1().add(p1);
			g.getPlayer2().add(p2);
			
			
			
			if (isranked == true) { 
				if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
				p1.sendMessage("§3[Spleef] §6Rival encontrado: §a" + p2.getName() + "§7(§e" + DataManager.getElo(p2) + "§7)");
				} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
					p1.sendMessage("§3[Spleef] §6Found opponent : §a" + p2.getName() + "§7(§e" + DataManager.getElo(p2) + "§7)");
				}
				
				if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
					p2.sendMessage("§3[Spleef] §6Rival encontrado: §a" + p1.getName() + "§7(§e" + DataManager.getElo(p1) + "§7)");
					} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
						p2.sendMessage("§3[Spleef] §6Found opponent : §a" + p1.getName() + "§7(§e" + DataManager.getElo(p1) + "§7)");
					}
	        	g.resetWin();
	        	g.resetArenaStarting();
	   	      g.resetPoints();
	   	      g.resetRounds();
	   	      g.resetTime();
	   	      p1.getInventory().clear();
	   	      p2.getInventory().clear(); 	  
	   	      DataManager.playedRanked(p1);
	   	   DataManager.playedRanked(p2);
	   	      
	        RankedSpleefGame.startCountdown(g.getId());
	        } else  { 
	        	g.resetWin();
	        	 g.resetArenaStarting();
	   	      g.resetPoints();
	   	      g.resetRounds();
	   	      g.resetTime();
	   	   p1.getInventory().clear();
	   	      p2.getInventory().clear();   	  
	        	SpleefGame.startCountdown(g.getId());
	        }
			
		}
	
}
 
public void resetRequest(Player p) {
	Game g = GameManager.getManager().getArenabyPlayer(p);
	if (!g.getReset().isEmpty() && !g.getReset().contains(p)) {
		reinicio(g);
		for (Player p1 : g.getPlayer1()) {
			if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
			p1.sendMessage("§3[Spleef]§6 Arena reiniciada");
			} else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
				p1.sendMessage("§3[Spleef]§6 Arena restarted");
			}
			p1.teleport(g.getSpawn1());
		}
		for (Player p2 : g.getPlayer2()) {
			if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
			p2.sendMessage("§3[Spleef]§6 Arena reiniciada");
			} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
				p2.sendMessage("§3[Spleef]§6 Arena restarted");
			}
			p2.teleport(g.getSpawn2());
		}
		g.getReset().clear();
		
	} else {
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			p.sendMessage("§3[Spleef]§6 Has solicitado reiniciar la arena");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("§3[Spleef]§6 You have requested to reset the arena");
			}
			if (g.getPlayer1().contains(p)) {
				Player p2 = GameManager.getManager().getArenabyPlayer(p).getPlayer2().get(0);
				if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
				p2.sendMessage("§3[Spleef]§aTu oponente ha solicitado reiniciar la arena, coloca §b/reset §apara reiniciarla.");
				} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
					p2.sendMessage("§3[Spleef]§a Your oponent has requested to reset the arena, type §b/reset §a to reset it.");
				}
			} else if (g.getPlayer2().contains(p)) {
				Player p1 = GameManager.getManager().getArenabyPlayer(p).getPlayer1().get(0);
				if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
				p1.sendMessage("§3[Spleef]§aTu oponente ha solicitado reiniciar la arena, coloca §b/reset §apara reiniciarla.");
				} else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
					p1.sendMessage("§3[Spleef]§a Your oponent has requested to reset the arena, type §b/reset §a to reset it.");
				}
			}
				
		g.getReset().add(p);
	}
	
}

public void endgameRequest(Player p) {
	Game g = GameManager.getManager().getArenabyPlayer(p);
	if (!g.getEndGame().isEmpty() && !g.getEndGame().contains(p)) {
		SpleefGame.gameOver(null, null, g.getId());
		for (Player p1 : g.getPlayer1()) {
			if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
			p1.sendMessage("§3[Spleef]§6 La partida ha finalizado en empate");
			} else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
				p1.sendMessage("§3[Spleef]§6 The match has finished in a draw");
			}
		}
		for (Player p2 : g.getPlayer2()) {
			if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
			p2.sendMessage("§3[Spleef]§6 La partida ha finalizado en empate");
			} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
				p2.sendMessage("§3[Spleef]§6 The match has finished in a draw");
			}
		}
		g.getEndGame().clear();
		
	} else {
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			p.sendMessage("§3[Spleef]§6 Has solicitado finalizar la partida");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("§3[Spleef]§6 You have requested to end the match");
			}
			if (g.getPlayer1().contains(p)) {
				Player p2 = GameManager.getManager().getArenabyPlayer(p).getPlayer2().get(0);
				if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
				p2.sendMessage("§3[Spleef] §aTu oponente ha solicitado finalizar la partida, coloca §b/endgame §apara terminarala.");
				} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
					p2.sendMessage("§3[Spleef]§a Your oponent has requested to end the match, type §b/endgame §a to finish it.");
				}
			} else if (g.getPlayer2().contains(p)) {
				Player p1 = GameManager.getManager().getArenabyPlayer(p).getPlayer1().get(0);
				if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
				p1.sendMessage("§3[Spleef] §aTu oponente ha solicitado finalizar la partida, coloca §b/endgame §apara terminarala.");
				} else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
					p1.sendMessage("§3[Spleef]§a Your oponent has requested to end the match, type §b/endgame §a to finish it.");
				}
			}
				
		g.getEndGame().add(p);
	}
	
}
    
}
