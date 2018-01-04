package com.santipingui58.spleef.utils;

import org.bukkit.attribute.Attribute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Cooldown1_9 implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(16.0D);
	}
	  
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(16.0D);
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent e) {
	    e.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(16.0D);
	}
}