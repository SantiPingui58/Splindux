package com.santipingui58.spleef.managers;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.santipingui58.spleef.Main;
import com.yapzhenyie.GadgetsMenu.api.GadgetsMenuAPI;
import com.yapzhenyie.GadgetsMenu.economy.GEconomyProvider;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;

public class EconomyManager extends GEconomyProvider {

	


	public EconomyManager(Plugin plugin, String storage) {
		super(plugin, storage);
	}

	
	private static EconomyManager pm;
	
	
	  public static EconomyManager getManager() {
	        if (pm == null)
	            pm = new EconomyManager(Main.get(), "Splindux");

	        return pm;
	    }


	
	
	  public static void addCoins(Player p, Integer i,boolean multiplier) {
		  if (!Main.data.getConfig().contains("data."+p.getUniqueId()+".coins")) {
				Main.data.getConfig().set("data."+p.getUniqueId()+ ".coins", 0);
			}
		  
		  int coins = Main.data.getConfig().getInt("data."+p.getUniqueId()+ ".coins");
			if (multiplier) {
			if (p.hasPermission("splindux.extreme")) {
				i = (int) ((i*1.5));
			} else if (p.hasPermission("splindux.epic")) {
				i = (int) ((i*1.25));
			} else if (p.hasPermission("splindux.vip")) {
				i = (int) ((i*1.1));
			} 
			}
			coins = coins+i;
			Main.data.getConfig().set("data."+p.getUniqueId()+ ".coins", coins);
			Main.data.save();
			
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				p.sendMessage("§aHas ganado §6"+i+" coins");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("§aYou have won §6"+i+" coins");
			}
	  } 
		
		
		
	//}

	  public static PlayerManager getPlayerManager(Player player) {
		    PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(player);
			return playerManager;
		}
	  
	  
	@Override
	public  void addMysteryDust(PlayerManager pm, int i) {
		
		Player p = pm.getPlayer();
		if (!Main.data.getConfig().contains("data."+p.getUniqueId()+".coins")) {
			Main.data.getConfig().set("data."+p.getUniqueId()+ ".coins", 0);
		}
		
		int coins = Main.data.getConfig().getInt("data."+p.getUniqueId()+ ".coins");
		coins = coins+i;
		Main.data.getConfig().set("data."+p.getUniqueId()+ ".coins", coins);
		Main.data.save();
	}

	@Override
	public int getMysteryDust(PlayerManager pm) {
		Player p = pm.getPlayer();
		
		if (!Main.data.getConfig().contains("data."+p.getUniqueId()+".coins")) {
			Main.data.getConfig().set("data."+p.getUniqueId()+ ".coins", 0);
		}
		
		int coins = Main.data.getConfig().getInt("data."+p.getUniqueId()+ ".coins");
		return coins;
	}

	@Override
	public void removeMysteryDust(PlayerManager pm, int i) {
		
		Player p = pm.getPlayer();
		if (!Main.data.getConfig().contains("data."+p.getUniqueId()+".coins")) {
			Main.data.getConfig().set("data."+p.getUniqueId()+ ".coins", 0);
		}
		
		int coins = Main.data.getConfig().getInt("data."+p.getUniqueId()+ ".coins");
		
		
		
		coins = coins-i;
		Main.data.getConfig().set("data."+p.getUniqueId()+ ".coins", coins);
		Main.data.save();
		
	}

	@Override
	public void setMysteryDust(PlayerManager arg0, int arg1) {
		
	}

	@Override
	public int syncMysteryDust(PlayerManager arg0) {
		return 0;
	}
	
	
	
	
	
	
	
	
}
