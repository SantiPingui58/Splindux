package com.santipingui58.spleef.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.utils.ItemBuilder;

public class Game {

	public static ItemStack rankeditemesp = new ItemBuilder (Material.DIAMOND_SPADE).setTitle("§b§lCola para ranked").build();
	public static ItemStack unrankeditemesp = new ItemBuilder (Material.IRON_SPADE).setTitle("§b§lCola para Unranked").build();
	public static ItemStack opcionesesp = new ItemBuilder (Material.REDSTONE_COMPARATOR).setTitle("§c§lOpciones").build();
	public static ItemStack torneosesp = new ItemBuilder (Material.GOLD_INGOT).setTitle("§6§lEventos").build();
	public static ItemStack leavequeueesp = new ItemBuilder (Material.REDSTONE_TORCH_ON).setTitle("§aSalir de la cola").build();
	public static ItemStack partiesesp = new ItemBuilder (Material.BLAZE_POWDER).setTitle("§3Menu de Party").build();
	
	public static ItemStack rankeditemeng = new ItemBuilder (Material.DIAMOND_SPADE).setTitle("§b§lRanked Queue").build();
	public static ItemStack unrankeditemeng = new ItemBuilder (Material.IRON_SPADE).setTitle("§b§lUnranked Queue").build();
	public static ItemStack opcioneseng = new ItemBuilder (Material.REDSTONE_COMPARATOR).setTitle("§c§lOptions").build();
	public static ItemStack torneoseng = new ItemBuilder (Material.GOLD_INGOT).setTitle("§6§lTournaments").build();
	public static ItemStack leavequeueeng = new ItemBuilder (Material.REDSTONE_TORCH_ON).setTitle("§aLeave the queue").build();
	public static ItemStack partieseng = new ItemBuilder (Material.BLAZE_POWDER).setTitle("§3Party's Menu").build();
	
		private final String id;
	 	private final String tipo;
	    private final Location spawn1;
	    private final Location spawn2;
	    private final Location arena1;
	    private final Location arena2;
	    private final Location spect;
	    private final List<Player> player1 = new ArrayList<Player>();
	    private final List<Player> player2 = new ArrayList<Player>(); 
	    private final List<Player> ffaplayers = new ArrayList<Player>(); 
	    private final List<Player> queue = new ArrayList<Player>();
	  
	    
	    private int rounds;
	    private boolean canPlay;
	    private boolean isFFAStarting;
	    private int arena_starting;
	    private int points1;
	    private int points2;
	    private int time;
	    private int win;
	    private int task;
	    private final List<Player> spectators = new ArrayList<Player>();
	    private final List<Player> ingamespect = new ArrayList<Player>();
	    
	    private final HashMap<Player, Integer> crumblereset = new HashMap<Player,Integer>();
	    private final HashMap<Player, Integer> playtorequest = new HashMap<Player,Integer>();
	    private final List<Player>  endgamereset = new ArrayList<Player>();
	    private final List<Player> reset = new ArrayList<Player>();

	    
	    
	    
	    public Game(Location spawn1, Location spawn2, Location arena1,
	    		Location arena2, Location spect, String id, String tipo) {
	        this.spawn1 = spawn1;
	        this.spawn2 = spawn2;
	        this.arena1 = arena1;
	        this.arena2 = arena2;
	        this.spect = spect;
	        this.id = id;
	        this.tipo = tipo;

	    }
	    	 
		  
	    
	    public List<Player> getReset() {
	    	return this.reset;
	    }
	    
	    public int getTask() {
	    	return this.task;
	    }
	    public String getType() {
	    	return this.tipo;
	    }
	    
	    public int getWin() {
	    	return this.win;
	    }
	    
	    
	    public void setWin(Integer i) {
	    	this.win = i;
	    }
	    
	    public void resetWin() {
	    	this.win = 5;
	    }
	    
	    public List<Player> getPlayers() {
	    	if (this.tipo.equalsIgnoreCase("ffaspleef")) {
	    		return this.ffaplayers;
	    	}
	    	return null;
	    }
	    
	    
	    public List<Player> getEndGame() {
	    	return this.endgamereset;
	    }
	    
	    public HashMap<Player, Integer> getCrumble() {
	    	return this.crumblereset;
	    }
	    
	    public HashMap<Player, Integer> getPlayTo() {
	    	return this.playtorequest;
	    }
	    
	    
	    public String getId() {
	        return this.id;
	    }
	    public int getTime() {
	    	return this.time;
	    }
	    public void addTime() {
	    	this.time++;
	    }

	   
	    public void resetTime() {
	    	this.time = 0;
	    }
	    
	    public int getPoints1() {
	    	return this.points1;
	    }
	    
	    public int getPoints2() {
	    	return this.points2;
	    }
	    
	    public void addPoints1() {
	    	this.points1++;
	    }
	    
	    public void addPoints2() {
	    	this.points2++;
	    }
	    
	    public void resetPoints() {
	    	this.points1 = 0;
	    	this.points2 = 0;
	    }
	    
	    public int getRounds() {
	    	return this.rounds;
	    }
	   
	    public void addRounds() {
	    	this.rounds++;
	    }
	    
	    public void resetRounds() {
	    	this.rounds = 0;
	    }
	 
	    public int getArenaStarting() {
	    	return this.arena_starting;
	    }
	    
	    public void resetArenaStarting() {
	    	this.arena_starting = 6;
	    }
	    
	    public void ArenaStarting() {
	    	this.arena_starting--;
	    }
	    
	    public boolean getCanPlay() {
	    	return this.canPlay;
	    }
	    
	    public void trueCanPlay() {
	    	this.canPlay = true;
	    }
	    
	    public void falseCanPlay() {
	    	this.canPlay = false;
	    }
	    
	    public boolean isFFAStarting() {
	    	return this.isFFAStarting;
	    }
	    
	    public void trueFFAStarting() {
	    	this.isFFAStarting = true;
	    }
	    
	    public void falseFFAStarting() {
	    	this.isFFAStarting = false;
	    }
	    
	    
	    public List<Player> getPlayer1() {
	        return this.player1;
	    }
	    
	    public List<Player> getPlayer2() {
	        return this.player2;
	    }
	    public List<Player> getSpectators() {
	        return this.spectators;
	    }
	    
	    public List<Player> getInGameSpect() {
	        return this.ingamespect;
	    }
	    
	    public List<Player> getQueue() {
	        return this.queue;
	    }
	    
	    
	    
	    public Location getSpawn1A() { 	
	    	int x1 =  this.spawn1.getBlockX() + 2;
	    	int y1 = this.spawn1.getBlockY();
	    	int z1 = this.spawn1.getBlockZ();	
	    	return new Location (this.spawn1.getWorld(), x1,y1,z1);
	    }
    
	    public Location getSpawn1B() {
	    	int x1 =  this.spawn1.getBlockX() - 2;
	    	int y1 = this.spawn1.getBlockY();
	    	int z1 = this.spawn1.getBlockZ();	
	    	return new Location (this.spawn1.getWorld(), x1,y1,z1);
	    }
	    
	    public Location getSpawn2A() { 	
	    	int x1 =  this.spawn2.getBlockX() + 2;
	    	int y1 = this.spawn2.getBlockY();
	    	int z1 = this.spawn2.getBlockZ();	
	    	return new Location (this.spawn2.getWorld(), x1,y1,z1);
	    }
    
	    public Location getSpawn2B() {
	    	int x1 =  this.spawn2.getBlockX() - 2;
	    	int y1 = this.spawn2.getBlockY();
	    	int z1 = this.spawn2.getBlockZ();	
	    	return new Location (this.spawn2.getWorld(), x1,y1,z1);
	    }
	    
	    public Location getSpawn2() {
	    	return this.spawn2;
	    }
	    
	    public Location getSpawn1() {
	    	return this.spawn1;
	    }
	    
	    public Location getArena1() {
	    	return this.arena1;
	    }
	    
	    public Location getArena2() {
	    	return this.arena2;
	    }
	    
	    
	    public Location getSpect() {
	    	return this.spect;
	    }
	    
	}
	


