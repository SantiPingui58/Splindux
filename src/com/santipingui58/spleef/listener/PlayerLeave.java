package com.santipingui58.spleef.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.game.RankedSpleefGame;
import com.santipingui58.spleef.game.SpleefGame;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.utils.Scoreboard;

public class PlayerLeave implements Listener {

	@EventHandler 
	public void onLeave (PlayerQuitEvent e) {
		Player p = e.getPlayer();
			e.setQuitMessage(null);	
				
				
				for (Player pa : Bukkit.getOnlinePlayers()) {
					if (!GameManager.getManager().isInGame(pa) || !GameManager.getManager().isSpectating(pa))
				 new Scoreboard().createScoreboard(pa);
			}
				
				
				if (GameManager.getManager().isInGame(p)) {
					Game g = GameManager.getManager().getArenabyPlayer(p);
					
					if (GameManager.getManager().isRanked(g)) {
						Player ganador = null;
						if (g.getPlayer1().contains(p)){
							ganador = g.getPlayer2().get(0);
						} else {
							ganador = g.getPlayer1().get(0);
						}
						
						RankedSpleefGame.gameOver(ganador, p, g.getId());
						
					} else if (g.getType().equalsIgnoreCase("ffaspleef")) {
						try {
						g.getQueue().remove(p);
						} catch (Exception ex) {}
						
						try {
							g.getPlayers().remove(p);
						} catch (Exception ex) {}
						
						
						
					} else {
						Player ganador = null;
						if (g.getPlayer1().contains(p)){
							ganador = g.getPlayer2().get(0);
						} else {
							ganador = g.getPlayer1().get(0);
						}
						
						SpleefGame.gameOver(ganador, p, g.getId());
					}
				} 
				
				for (Game g : GameManager.getManager().getArenasList()) {
					if (g.getSpectators().contains(p)) {
						g.getSpectators().remove(p);
						
					}
					
					if (g.getQueue().contains(p)) {
						g.getQueue().remove(p);
					}
				}
				

	}
	
}
