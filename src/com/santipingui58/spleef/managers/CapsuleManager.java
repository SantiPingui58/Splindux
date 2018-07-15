package com.santipingui58.spleef.managers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;

public class CapsuleManager {

	
	
	public static void setSelectedCapsule(Player p,String capsule) {
	if (Main.data.getConfig().contains("data."+p.getUniqueId())) {
		Main.data.getConfig().set("data."+p.getUniqueId()+".cosmetics.capsule", capsule);
		Main.data.save();
	}
	}
	
	
	
	
	public static void generateCapsula(Player player, Location loc) {
		int locX = loc.getBlockX();
		int locY = loc.getBlockY();
		int locZ = loc.getBlockZ();
		
		
		Location a = new Location (loc.getWorld(), locX+1, locY, locZ-1);
		Location b = new Location (loc.getWorld(), locX, locY, locZ-1);
		Location c = new Location (loc.getWorld(), locX-1, locY, locZ-1);
		Location d = new Location (loc.getWorld(), locX+1, locY, locZ);
		Location e = new Location (loc.getWorld(), locX,locY,locZ);
		Location f = new Location (loc.getWorld(), locX-1,locY,locZ);
		Location g = new Location (loc.getWorld(),locX+1,locY,locZ+1);
		Location h = new Location (loc.getWorld(),locX,locY,locZ+1);
		Location i = new Location (loc.getWorld(),locX-1,locY,locZ+1);
		
		Location j = new Location (loc.getWorld(), locX+1, locY+1, locZ-1);
		Location k = new Location (loc.getWorld(), locX, locY+1, locZ-1);
		Location l = new Location (loc.getWorld(), locX-1, locY+1, locZ-1);
		Location m = new Location (loc.getWorld(), locX+1, locY+1, locZ);
		Location n = new Location (loc.getWorld(), locX,locY+1,locZ);
		Location o = new Location (loc.getWorld(), locX-1,locY+1,locZ);
		Location p = new Location (loc.getWorld(),locX+1,locY+1,locZ+1);
		Location q = new Location (loc.getWorld(),locX,locY+1,locZ+1);
		Location r = new Location (loc.getWorld(),locX-1,locY+1,locZ+1);
		
		Location s = new Location (loc.getWorld(), locX+1, locY+2, locZ-1);
		Location t = new Location (loc.getWorld(), locX, locY+2, locZ-1);
		Location u = new Location (loc.getWorld(), locX-1, locY+2, locZ-1);
		Location v = new Location (loc.getWorld(), locX+1, locY+2, locZ);
		Location w = new Location (loc.getWorld(), locX,locY+2,locZ);
		Location x = new Location (loc.getWorld(), locX-1,locY+2,locZ);
		Location y = new Location (loc.getWorld(),locX+1,locY+2,locZ+1);
		Location z = new Location (loc.getWorld(),locX,locY+2,locZ+1);
		Location aa = new Location (loc.getWorld(),locX-1,locY+2,locZ+1);
		
		setCapsula(player, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, aa);
		
	}
	
public static void removeCapsula(Location loc) {
	
	int locX = loc.getBlockX();
	int locY = loc.getBlockY();
	int locZ = loc.getBlockZ();
	
	Location edgeMin = new Location (loc.getWorld(), locX-2, locY, locZ-2);
	Location edgeMax = new Location (loc.getWorld(),locX+2,locY+3,locZ+2);
	
	
	  for (int x = edgeMin.getBlockX(); x < edgeMax.getBlockX(); x ++) {
	        for (int y = edgeMin.getBlockY(); y < edgeMax.getBlockY(); y ++) {
	            for (int z = edgeMin.getBlockZ(); z < edgeMax.getBlockZ(); z ++) {
			  Location aire = new Location (loc.getWorld(), x, y, z);
			  aire.getBlock().setType(Material.AIR);
			  }
		  } 
		  }
	  
	  
	  
	
	  
	  
	  	
	  
	  
	  }
	
	
	@SuppressWarnings("deprecation")
	public static void setCapsula(Player player, Location a, Location b, Location c, 
			Location d, Location e, Location f, Location g, Location h, Location i,
			Location j, Location k, Location l, Location m, Location n, Location o, Location p,
			Location q, Location r, Location s, Location t, Location u, Location v,Location w,
			Location x, Location y,Location z, Location aa) {
		if (!Main.data.getConfig().contains("data."+player.getUniqueId()+ ".cosmetics.capsule")) {
			Main.data.getConfig().set("data."+player.getUniqueId()+ ".cosmetics.capsule", "default");
		}
		String selected_capsule = Main.data.getConfig().getString("data." + player.getUniqueId() + ".cosmetics.capsule");
		
		if (selected_capsule.startsWith("glass_")) {
			short color_id=0;
			if (selected_capsule.equalsIgnoreCase("glass_white")) {
				color_id =0;	
			} 
			else if (selected_capsule.equalsIgnoreCase("glass_orange")) {
				color_id =1;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_magenta")) {
				color_id =2;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_lightblue")) {
				color_id =3;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_yellow")) {
				color_id =4;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_lima")) {
				color_id =5;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_pink")) {
				color_id =6;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_gray")) {
				color_id =7;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_lightgray")) {
				color_id =8;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_cyan")) {
				color_id =9;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_purple")) {
				color_id =10;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_blue")) {
				color_id =11;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_brown")) {
				color_id =12;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_green")) {
				color_id =13;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_red")) {
				color_id =14;
			}
			else if (selected_capsule.equalsIgnoreCase("glass_black")) {
				color_id =15;
			}
			
			 b.getBlock().setType(Material.STAINED_GLASS);
			 b.getBlock().setData((byte) color_id);
			 d.getBlock().setType(Material.STAINED_GLASS);
			 d.getBlock().setData((byte) color_id);
			 f.getBlock().setType(Material.STAINED_GLASS);
			 f.getBlock().setData((byte) color_id);
			 h.getBlock().setType(Material.STAINED_GLASS);
			 h.getBlock().setData((byte) color_id);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) color_id);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) color_id);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) color_id);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) color_id);
			 w.getBlock().setType(Material.STAINED_GLASS);
			 w.getBlock().setData((byte) color_id);
		} else if (selected_capsule.equalsIgnoreCase("goldblock")) {
			a.getBlock().setType(Material.STAINED_GLASS_PANE);
			a.getBlock().setData((byte) 4);
			b.getBlock().setType(Material.STAINED_GLASS_PANE);
			b.getBlock().setData((byte) 4);
			c.getBlock().setType(Material.STAINED_GLASS_PANE);
			c.getBlock().setData((byte) 4);
			d.getBlock().setType(Material.STAINED_GLASS_PANE);
			d.getBlock().setData((byte) 4);
			f.getBlock().setType(Material.STAINED_GLASS_PANE);
			f.getBlock().setData((byte) 4);
			g.getBlock().setType(Material.STAINED_GLASS_PANE);
			g.getBlock().setData((byte) 4);
			h.getBlock().setType(Material.STAINED_GLASS_PANE);
			h.getBlock().setData((byte) 4);
			i.getBlock().setType(Material.STAINED_GLASS_PANE);
			i.getBlock().setData((byte) 4);
			j.getBlock().setType(Material.STAINED_GLASS_PANE);
			j.getBlock().setData((byte) 4);
			k.getBlock().setType(Material.STAINED_GLASS_PANE);
			k.getBlock().setData((byte) 4);
			l.getBlock().setType(Material.STAINED_GLASS_PANE);
			l.getBlock().setData((byte) 4);
			m.getBlock().setType(Material.STAINED_GLASS_PANE);
			m.getBlock().setData((byte) 4);
			o.getBlock().setType(Material.STAINED_GLASS_PANE);
			o.getBlock().setData((byte) 4);
			p.getBlock().setType(Material.STAINED_GLASS_PANE);
			p.getBlock().setData((byte) 4);
			q.getBlock().setType(Material.STAINED_GLASS_PANE);
			q.getBlock().setData((byte) 4);
			r.getBlock().setType(Material.STAINED_GLASS_PANE);
			r.getBlock().setData((byte) 4);
			s.getBlock().setType(Material.STAINED_GLASS_PANE);
			s.getBlock().setData((byte) 4);
			t.getBlock().setType(Material.STAINED_GLASS_PANE);
			t.getBlock().setData((byte) 4);
			u.getBlock().setType(Material.STAINED_GLASS_PANE);
			u.getBlock().setData((byte) 4);
			v.getBlock().setType(Material.STAINED_GLASS_PANE);
			v.getBlock().setData((byte) 4);
			w.getBlock().setType(Material.GOLD_BLOCK);
			x.getBlock().setType(Material.STAINED_GLASS_PANE);
			x.getBlock().setData((byte) 4);
			y.getBlock().setType(Material.STAINED_GLASS_PANE);
			y.getBlock().setData((byte) 4);
			z.getBlock().setType(Material.STAINED_GLASS_PANE);
			z.getBlock().setData((byte) 4);
			aa.getBlock().setType(Material.STAINED_GLASS_PANE);
			aa.getBlock().setData((byte) 4);
		} else if (selected_capsule.equalsIgnoreCase("lapisblock")) {
			a.getBlock().setType(Material.STAINED_GLASS_PANE);
			a.getBlock().setData((byte) 11);
			b.getBlock().setType(Material.STAINED_GLASS_PANE);
			b.getBlock().setData((byte) 11);
			c.getBlock().setType(Material.STAINED_GLASS_PANE);
			c.getBlock().setData((byte) 11);
			d.getBlock().setType(Material.STAINED_GLASS_PANE);
			d.getBlock().setData((byte) 11);
			f.getBlock().setType(Material.STAINED_GLASS_PANE);
			f.getBlock().setData((byte) 11);
			g.getBlock().setType(Material.STAINED_GLASS_PANE);
			g.getBlock().setData((byte) 11);
			h.getBlock().setType(Material.STAINED_GLASS_PANE);
			h.getBlock().setData((byte) 11);
			i.getBlock().setType(Material.STAINED_GLASS_PANE);
			i.getBlock().setData((byte) 11);
			j.getBlock().setType(Material.STAINED_GLASS_PANE);
			j.getBlock().setData((byte) 11);
			k.getBlock().setType(Material.STAINED_GLASS_PANE);
			k.getBlock().setData((byte) 11);
			l.getBlock().setType(Material.STAINED_GLASS_PANE);
			l.getBlock().setData((byte) 11);
			m.getBlock().setType(Material.STAINED_GLASS_PANE);
			m.getBlock().setData((byte) 11);
			o.getBlock().setType(Material.STAINED_GLASS_PANE);
			o.getBlock().setData((byte) 11);
			p.getBlock().setType(Material.STAINED_GLASS_PANE);
			p.getBlock().setData((byte) 11);
			q.getBlock().setType(Material.STAINED_GLASS_PANE);
			q.getBlock().setData((byte) 11);
			r.getBlock().setType(Material.STAINED_GLASS_PANE);
			r.getBlock().setData((byte) 11);
			s.getBlock().setType(Material.STAINED_GLASS_PANE);
			s.getBlock().setData((byte) 11);
			t.getBlock().setType(Material.STAINED_GLASS_PANE);
			t.getBlock().setData((byte) 11);
			u.getBlock().setType(Material.STAINED_GLASS_PANE);
			u.getBlock().setData((byte) 11);
			v.getBlock().setType(Material.STAINED_GLASS_PANE);
			v.getBlock().setData((byte) 11);
			w.getBlock().setType(Material.LAPIS_BLOCK);
			x.getBlock().setType(Material.STAINED_GLASS_PANE);
			x.getBlock().setData((byte) 11);
			y.getBlock().setType(Material.STAINED_GLASS_PANE);
			y.getBlock().setData((byte) 11);
			z.getBlock().setType(Material.STAINED_GLASS_PANE);
			z.getBlock().setData((byte) 11);
			aa.getBlock().setType(Material.STAINED_GLASS_PANE);
			aa.getBlock().setData((byte) 11);
		}else if (selected_capsule.equalsIgnoreCase("redstoneblock")) {
			a.getBlock().setType(Material.STAINED_GLASS_PANE);
			a.getBlock().setData((byte) 14);
			b.getBlock().setType(Material.STAINED_GLASS_PANE);
			b.getBlock().setData((byte) 14);
			c.getBlock().setType(Material.STAINED_GLASS_PANE);
			c.getBlock().setData((byte) 14);
			d.getBlock().setType(Material.STAINED_GLASS_PANE);
			d.getBlock().setData((byte) 14);
			f.getBlock().setType(Material.STAINED_GLASS_PANE);
			f.getBlock().setData((byte) 14);
			g.getBlock().setType(Material.STAINED_GLASS_PANE);
			g.getBlock().setData((byte) 14);
			h.getBlock().setType(Material.STAINED_GLASS_PANE);
			h.getBlock().setData((byte) 14);
			i.getBlock().setType(Material.STAINED_GLASS_PANE);
			i.getBlock().setData((byte) 14);
			j.getBlock().setType(Material.STAINED_GLASS_PANE);
			j.getBlock().setData((byte) 14);
			k.getBlock().setType(Material.STAINED_GLASS_PANE);
			k.getBlock().setData((byte) 14);
			l.getBlock().setType(Material.STAINED_GLASS_PANE);
			l.getBlock().setData((byte) 14);
			m.getBlock().setType(Material.STAINED_GLASS_PANE);
			m.getBlock().setData((byte) 14);
			o.getBlock().setType(Material.STAINED_GLASS_PANE);
			o.getBlock().setData((byte) 14);
			p.getBlock().setType(Material.STAINED_GLASS_PANE);
			p.getBlock().setData((byte) 14);
			q.getBlock().setType(Material.STAINED_GLASS_PANE);
			q.getBlock().setData((byte) 14);
			r.getBlock().setType(Material.STAINED_GLASS_PANE);
			r.getBlock().setData((byte) 14);
			s.getBlock().setType(Material.STAINED_GLASS_PANE);
			s.getBlock().setData((byte) 14);
			t.getBlock().setType(Material.STAINED_GLASS_PANE);
			t.getBlock().setData((byte) 14);
			u.getBlock().setType(Material.STAINED_GLASS_PANE);
			u.getBlock().setData((byte) 14);
			v.getBlock().setType(Material.STAINED_GLASS_PANE);
			v.getBlock().setData((byte) 14);
			w.getBlock().setType(Material.REDSTONE_BLOCK);
			x.getBlock().setType(Material.STAINED_GLASS_PANE);
			x.getBlock().setData((byte) 14);
			y.getBlock().setType(Material.STAINED_GLASS_PANE);
			y.getBlock().setData((byte) 14);
			z.getBlock().setType(Material.STAINED_GLASS_PANE);
			z.getBlock().setData((byte) 14);
			aa.getBlock().setType(Material.STAINED_GLASS_PANE);
			aa.getBlock().setData((byte) 14);
		} else if (selected_capsule.equalsIgnoreCase("snow")) {
			a.getBlock().setType(Material.STAINED_GLASS_PANE);
			a.getBlock().setData((byte) 0);
			b.getBlock().setType(Material.STAINED_GLASS_PANE);
			b.getBlock().setData((byte) 0);
			c.getBlock().setType(Material.STAINED_GLASS_PANE);
			c.getBlock().setData((byte) 0);
			d.getBlock().setType(Material.STAINED_GLASS_PANE);
			d.getBlock().setData((byte) 0);
			f.getBlock().setType(Material.STAINED_GLASS_PANE);
			f.getBlock().setData((byte) 0);
			g.getBlock().setType(Material.STAINED_GLASS_PANE);
			g.getBlock().setData((byte) 0);
			h.getBlock().setType(Material.STAINED_GLASS_PANE);
			h.getBlock().setData((byte) 0);
			i.getBlock().setType(Material.STAINED_GLASS_PANE);
			i.getBlock().setData((byte) 0);
			j.getBlock().setType(Material.STAINED_GLASS_PANE);
			j.getBlock().setData((byte) 0);
			k.getBlock().setType(Material.STAINED_GLASS_PANE);
			k.getBlock().setData((byte) 0);
			l.getBlock().setType(Material.STAINED_GLASS_PANE);
			l.getBlock().setData((byte) 0);
			m.getBlock().setType(Material.STAINED_GLASS_PANE);
			m.getBlock().setData((byte) 0);
			o.getBlock().setType(Material.STAINED_GLASS_PANE);
			o.getBlock().setData((byte) 0);
			p.getBlock().setType(Material.STAINED_GLASS_PANE);
			p.getBlock().setData((byte) 0);
			q.getBlock().setType(Material.STAINED_GLASS_PANE);
			q.getBlock().setData((byte) 0);
			r.getBlock().setType(Material.STAINED_GLASS_PANE);
			r.getBlock().setData((byte) 0);
			s.getBlock().setType(Material.STAINED_GLASS_PANE);
			s.getBlock().setData((byte) 0);
			t.getBlock().setType(Material.STAINED_GLASS_PANE);
			t.getBlock().setData((byte) 0);
			u.getBlock().setType(Material.STAINED_GLASS_PANE);
			u.getBlock().setData((byte) 0);
			v.getBlock().setType(Material.STAINED_GLASS_PANE);
			v.getBlock().setData((byte) 0);
			w.getBlock().setType(Material.SNOW_BLOCK);
			x.getBlock().setType(Material.STAINED_GLASS_PANE);
			x.getBlock().setData((byte) 0);
			y.getBlock().setType(Material.STAINED_GLASS_PANE);
			y.getBlock().setData((byte) 0);
			z.getBlock().setType(Material.STAINED_GLASS_PANE);
			z.getBlock().setData((byte) 0);
			aa.getBlock().setType(Material.STAINED_GLASS_PANE);
			aa.getBlock().setData((byte) 0);
		}  else if (selected_capsule.equalsIgnoreCase("diamondblock")) {
			a.getBlock().setType(Material.STAINED_GLASS_PANE);
			a.getBlock().setData((byte) 3);
			b.getBlock().setType(Material.STAINED_GLASS_PANE);
			b.getBlock().setData((byte) 9);
			c.getBlock().setType(Material.STAINED_GLASS_PANE);
			c.getBlock().setData((byte) 3);
			d.getBlock().setType(Material.STAINED_GLASS_PANE);
			d.getBlock().setData((byte) 9);
			f.getBlock().setType(Material.STAINED_GLASS_PANE);
			f.getBlock().setData((byte) 3);
			g.getBlock().setType(Material.STAINED_GLASS_PANE);
			g.getBlock().setData((byte) 9);
			h.getBlock().setType(Material.STAINED_GLASS_PANE);
			h.getBlock().setData((byte) 3);
			i.getBlock().setType(Material.STAINED_GLASS_PANE);
			i.getBlock().setData((byte) 9);
			j.getBlock().setType(Material.STAINED_GLASS_PANE);
			j.getBlock().setData((byte) 9);
			k.getBlock().setType(Material.STAINED_GLASS_PANE);
			k.getBlock().setData((byte) 3);
			l.getBlock().setType(Material.STAINED_GLASS_PANE);
			l.getBlock().setData((byte) 9);
			m.getBlock().setType(Material.STAINED_GLASS_PANE);
			m.getBlock().setData((byte) 3);
			o.getBlock().setType(Material.STAINED_GLASS_PANE);
			o.getBlock().setData((byte) 9);
			p.getBlock().setType(Material.STAINED_GLASS_PANE);
			p.getBlock().setData((byte) 3);
			q.getBlock().setType(Material.STAINED_GLASS_PANE);
			q.getBlock().setData((byte) 9);
			r.getBlock().setType(Material.STAINED_GLASS_PANE);
			r.getBlock().setData((byte) 3);
			s.getBlock().setType(Material.STAINED_GLASS_PANE);
			s.getBlock().setData((byte) 3);
			t.getBlock().setType(Material.STAINED_GLASS_PANE);
			t.getBlock().setData((byte) 9);
			u.getBlock().setType(Material.STAINED_GLASS_PANE);
			u.getBlock().setData((byte) 3);
			v.getBlock().setType(Material.STAINED_GLASS_PANE);
			v.getBlock().setData((byte) 9);
			w.getBlock().setType(Material.DIAMOND_BLOCK);
			x.getBlock().setType(Material.STAINED_GLASS_PANE);
			x.getBlock().setData((byte) 3);
			y.getBlock().setType(Material.STAINED_GLASS_PANE);
			y.getBlock().setData((byte) 9);
			z.getBlock().setType(Material.STAINED_GLASS_PANE);
			z.getBlock().setData((byte) 3);
			aa.getBlock().setType(Material.STAINED_GLASS_PANE);
			aa.getBlock().setData((byte) 9);
		}  else if (selected_capsule.equalsIgnoreCase("emeraldblock")) {
			a.getBlock().setType(Material.STAINED_GLASS_PANE);
			a.getBlock().setData((byte) 5);
			b.getBlock().setType(Material.STAINED_GLASS_PANE);
			b.getBlock().setData((byte) 13);
			c.getBlock().setType(Material.STAINED_GLASS_PANE);
			c.getBlock().setData((byte) 5);
			d.getBlock().setType(Material.STAINED_GLASS_PANE);
			d.getBlock().setData((byte) 13);
			f.getBlock().setType(Material.STAINED_GLASS_PANE);
			f.getBlock().setData((byte) 5);
			g.getBlock().setType(Material.STAINED_GLASS_PANE);
			g.getBlock().setData((byte) 13);
			h.getBlock().setType(Material.STAINED_GLASS_PANE);
			h.getBlock().setData((byte) 5);
			i.getBlock().setType(Material.STAINED_GLASS_PANE);
			i.getBlock().setData((byte) 13);
			j.getBlock().setType(Material.STAINED_GLASS_PANE);
			j.getBlock().setData((byte) 13);
			k.getBlock().setType(Material.STAINED_GLASS_PANE);
			k.getBlock().setData((byte) 5);
			l.getBlock().setType(Material.STAINED_GLASS_PANE);
			l.getBlock().setData((byte) 13);
			m.getBlock().setType(Material.STAINED_GLASS_PANE);
			m.getBlock().setData((byte) 5);
			o.getBlock().setType(Material.STAINED_GLASS_PANE);
			o.getBlock().setData((byte) 13);
			p.getBlock().setType(Material.STAINED_GLASS_PANE);
			p.getBlock().setData((byte) 5);
			q.getBlock().setType(Material.STAINED_GLASS_PANE);
			q.getBlock().setData((byte) 13);
			r.getBlock().setType(Material.STAINED_GLASS_PANE);
			r.getBlock().setData((byte) 5);
			s.getBlock().setType(Material.STAINED_GLASS_PANE);
			s.getBlock().setData((byte) 5);
			t.getBlock().setType(Material.STAINED_GLASS_PANE);
			t.getBlock().setData((byte) 13);
			u.getBlock().setType(Material.STAINED_GLASS_PANE);
			u.getBlock().setData((byte) 5);
			v.getBlock().setType(Material.STAINED_GLASS_PANE);
			v.getBlock().setData((byte) 13);
			w.getBlock().setType(Material.DIAMOND_BLOCK);
			x.getBlock().setType(Material.STAINED_GLASS_PANE);
			x.getBlock().setData((byte) 5);
			y.getBlock().setType(Material.STAINED_GLASS_PANE);
			y.getBlock().setData((byte) 13);
			z.getBlock().setType(Material.STAINED_GLASS_PANE);
			z.getBlock().setData((byte) 5);
			aa.getBlock().setType(Material.STAINED_GLASS_PANE);
			aa.getBlock().setData((byte) 13);
		}  else if (selected_capsule.equalsIgnoreCase("fence")) {
			a.getBlock().setType(Material.FENCE);
			b.getBlock().setType(Material.FENCE);
			c.getBlock().setType(Material.FENCE);
			d.getBlock().setType(Material.FENCE);
			f.getBlock().setType(Material.FENCE);
			g.getBlock().setType(Material.FENCE);
			h.getBlock().setType(Material.FENCE);
			i.getBlock().setType(Material.FENCE);
			w.getBlock().setType(Material.BARRIER);
		} else if (selected_capsule.equalsIgnoreCase("slab")) {
			 b.getBlock().setType(Material.STEP);
			 d.getBlock().setType(Material.STEP);
			 f.getBlock().setType(Material.STEP);
			 h.getBlock().setType(Material.STEP);
			 k.getBlock().setType(Material.STEP);
			 m.getBlock().setType(Material.STEP);
			 o.getBlock().setType(Material.STEP);
			 q.getBlock().setType(Material.STEP);
		} else if (selected_capsule.equalsIgnoreCase("tree")) {
			 b.getBlock().setType(Material.WOOD);
			 d.getBlock().setType(Material.WOOD);
			 f.getBlock().setType(Material.WOOD);
			 h.getBlock().setType(Material.WOOD);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 12);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 12);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 12);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 12);
			 w.getBlock().setType(Material.LEAVES);
		}   else if (selected_capsule.equalsIgnoreCase("leaves")) {
			 b.getBlock().setType(Material.LEAVES);
			 d.getBlock().setType(Material.LEAVES);
			 f.getBlock().setType(Material.LEAVES);
			 h.getBlock().setType(Material.LEAVES);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 13);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 13);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 13);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 13);
			 w.getBlock().setType(Material.LEAVES);
		}   else if (selected_capsule.equalsIgnoreCase("cobblewall")) {
			a.getBlock().setType(Material.COBBLE_WALL);
		    b.getBlock().setType(Material.COBBLE_WALL);
		    c.getBlock().setType(Material.COBBLE_WALL);
		    d.getBlock().setType(Material.COBBLE_WALL);
		    f.getBlock().setType(Material.COBBLE_WALL);
		    g.getBlock().setType(Material.COBBLE_WALL);
		    h.getBlock().setType(Material.COBBLE_WALL);
		    i.getBlock().setType(Material.COBBLE_WALL);
		    j.getBlock().setType(Material.COBBLE_WALL);
		    l.getBlock().setType(Material.COBBLE_WALL);
		    p.getBlock().setType(Material.COBBLE_WALL);
		    r.getBlock().setType(Material.COBBLE_WALL);
		    s.getBlock().setType(Material.COBBLE_WALL);
		    t.getBlock().setType(Material.COBBLE_WALL);
		    u.getBlock().setType(Material.COBBLE_WALL);
		    v.getBlock().setType(Material.COBBLE_WALL);
		    w.getBlock().setType(Material.COBBLE_WALL);
		    x.getBlock().setType(Material.COBBLE_WALL);
		    y.getBlock().setType(Material.COBBLE_WALL);
		    z.getBlock().setType(Material.COBBLE_WALL);
		    aa.getBlock().setType(Material.COBBLE_WALL);
		} else if (selected_capsule.equalsIgnoreCase("diorite")) {
			 b.getBlock().setType(Material.STONE);
			 b.getBlock().setData((byte)4);
			 d.getBlock().setType(Material.STONE);
			 d.getBlock().setData((byte)4);
			 f.getBlock().setType(Material.STONE);
			 f.getBlock().setData((byte)4);
			 h.getBlock().setType(Material.STONE);
			 h.getBlock().setData((byte)4);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 0);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 0);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 0);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 0);
			 w.getBlock().setType(Material.STONE);
			 w.getBlock().setData((byte)4);
		}   else if (selected_capsule.equalsIgnoreCase("diorite")) {
			 b.getBlock().setType(Material.STONE);
			 b.getBlock().setData((byte)6);
			 d.getBlock().setType(Material.STONE);
			 d.getBlock().setData((byte)6);
			 f.getBlock().setType(Material.STONE);
			 f.getBlock().setData((byte)6);
			 h.getBlock().setType(Material.STONE);
			 h.getBlock().setData((byte)6);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 8);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 8);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 8);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 8);
			 w.getBlock().setType(Material.STONE);
			 w.getBlock().setData((byte)6);
		}    else if (selected_capsule.equalsIgnoreCase("granite")) {
			 b.getBlock().setType(Material.STONE);
			 b.getBlock().setData((byte)2);
			 d.getBlock().setType(Material.STONE);
			 d.getBlock().setData((byte)2);
			 f.getBlock().setType(Material.STONE);
			 f.getBlock().setData((byte)2);
			 h.getBlock().setType(Material.STONE);
			 h.getBlock().setData((byte)2);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 1);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 1);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 1);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 1);
			 w.getBlock().setType(Material.STONE);
			 w.getBlock().setData((byte)2);
		}   else if (selected_capsule.equalsIgnoreCase("libraries")) {
			 b.getBlock().setType(Material.BOOKSHELF);
			 d.getBlock().setType(Material.BOOKSHELF);
			 f.getBlock().setType(Material.BOOKSHELF);
			 h.getBlock().setType(Material.BOOKSHELF);
			 k.getBlock().setType(Material.STAINED_GLASS_PANE);
			 k.getBlock().setData((byte) 12);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 12);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 12);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 12);
			 w.getBlock().setType(Material.BOOKSHELF);
		}   else if (selected_capsule.equalsIgnoreCase("ice")) {
			 b.getBlock().setType(Material.ICE);
			 d.getBlock().setType(Material.ICE);
			 f.getBlock().setType(Material.ICE);
			 h.getBlock().setType(Material.ICE);
			 k.getBlock().setType(Material.ICE);
			 m.getBlock().setType(Material.ICE);
			 o.getBlock().setType(Material.ICE);
			 q.getBlock().setType(Material.ICE);
			 w.getBlock().setType(Material.ICE);
		} else if (selected_capsule.equalsIgnoreCase("quartz")) {
			 b.getBlock().setType(Material.QUARTZ_BLOCK);
			 b.getBlock().setData((byte)2);
			 d.getBlock().setType(Material.QUARTZ_BLOCK);
			 d.getBlock().setData((byte)2);
			 f.getBlock().setType(Material.QUARTZ_BLOCK);
			 f.getBlock().setData((byte)2);
			 h.getBlock().setType(Material.QUARTZ_BLOCK);
			 h.getBlock().setData((byte)2);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 0);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 0);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 0);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 0);
			 w.getBlock().setType(Material.QUARTZ_ORE);
		}  else if (selected_capsule.equalsIgnoreCase("jail")) {
			a.getBlock().setType(Material.IRON_FENCE);
			b.getBlock().setType(Material.IRON_FENCE);
			c.getBlock().setType(Material.IRON_FENCE);
			d.getBlock().setType(Material.IRON_FENCE);
			f.getBlock().setType(Material.IRON_FENCE);
			g.getBlock().setType(Material.IRON_FENCE);
			h.getBlock().setType(Material.IRON_FENCE);
			i.getBlock().setType(Material.IRON_FENCE);
			j.getBlock().setType(Material.IRON_FENCE);
			k.getBlock().setType(Material.IRON_FENCE);
			l.getBlock().setType(Material.IRON_FENCE);
			m.getBlock().setType(Material.IRON_FENCE);
			o.getBlock().setType(Material.IRON_FENCE);
			p.getBlock().setType(Material.IRON_FENCE);
			q.getBlock().setType(Material.IRON_FENCE);
			r.getBlock().setType(Material.IRON_FENCE);
			s.getBlock().setType(Material.IRON_FENCE);
			t.getBlock().setType(Material.IRON_FENCE);
			u.getBlock().setType(Material.IRON_FENCE);
			v.getBlock().setType(Material.IRON_FENCE);
			w.getBlock().setType(Material.IRON_BLOCK);
			x.getBlock().setType(Material.IRON_FENCE);
			y.getBlock().setType(Material.IRON_FENCE);
			z.getBlock().setType(Material.IRON_FENCE);
			aa.getBlock().setType(Material.IRON_FENCE);
		}  else if (selected_capsule.equalsIgnoreCase("slabv2")) {
			a.getBlock().setType(Material.PURPUR_SLAB);
			b.getBlock().setType(Material.PURPUR_SLAB);
			c.getBlock().setType(Material.PURPUR_SLAB);
			d.getBlock().setType(Material.PURPUR_SLAB);
			f.getBlock().setType(Material.PURPUR_SLAB);
			g.getBlock().setType(Material.PURPUR_SLAB);
			h.getBlock().setType(Material.PURPUR_SLAB);
			i.getBlock().setType(Material.PURPUR_SLAB);
			j.getBlock().setType(Material.PURPUR_SLAB);
			k.getBlock().setType(Material.PURPUR_SLAB);
			l.getBlock().setType(Material.PURPUR_SLAB);
			m.getBlock().setType(Material.PURPUR_SLAB);
			o.getBlock().setType(Material.PURPUR_SLAB);
			p.getBlock().setType(Material.PURPUR_SLAB);
			q.getBlock().setType(Material.PURPUR_SLAB);
			r.getBlock().setType(Material.PURPUR_SLAB);
			s.getBlock().setType(Material.PURPUR_SLAB);
			t.getBlock().setType(Material.PURPUR_SLAB);
			u.getBlock().setType(Material.PURPUR_SLAB);
			v.getBlock().setType(Material.PURPUR_SLAB);
			w.getBlock().setType(Material.PURPUR_SLAB);
			x.getBlock().setType(Material.PURPUR_SLAB);
			y.getBlock().setType(Material.PURPUR_SLAB);
			z.getBlock().setType(Material.PURPUR_SLAB);
			aa.getBlock().setType(Material.PURPUR_SLAB);
		}  else if (selected_capsule.equalsIgnoreCase("nether_fence")) {
			a.getBlock().setType(Material.NETHER_FENCE);
			b.getBlock().setType(Material.NETHER_FENCE);
			c.getBlock().setType(Material.NETHER_FENCE);
			d.getBlock().setType(Material.NETHER_FENCE);
			f.getBlock().setType(Material.NETHER_FENCE);
			g.getBlock().setType(Material.NETHER_FENCE);
			h.getBlock().setType(Material.NETHER_FENCE);
			i.getBlock().setType(Material.NETHER_FENCE);
			w.getBlock().setType(Material.BARRIER);
		} else if (selected_capsule.equalsIgnoreCase("chess")) {
			a.getBlock().setType(Material.COAL_BLOCK);
			b.getBlock().setType(Material.QUARTZ_BLOCK);
			c.getBlock().setType(Material.COAL_BLOCK);
			d.getBlock().setType(Material.QUARTZ_BLOCK);
			f.getBlock().setType(Material.QUARTZ_BLOCK);
			g.getBlock().setType(Material.COAL_BLOCK);
			h.getBlock().setType(Material.QUARTZ_BLOCK);
			i.getBlock().setType(Material.COAL_BLOCK);
			j.getBlock().setType(Material.STAINED_GLASS_PANE);
			j.getBlock().setData((byte) 15);
			k.getBlock().setType(Material.STAINED_GLASS_PANE);
			k.getBlock().setData((byte) 0);
			l.getBlock().setType(Material.STAINED_GLASS_PANE);
			l.getBlock().setData((byte) 15);
			m.getBlock().setType(Material.STAINED_GLASS_PANE);
			m.getBlock().setData((byte) 0);
			o.getBlock().setType(Material.STAINED_GLASS_PANE);
			o.getBlock().setData((byte) 0);
			p.getBlock().setType(Material.STAINED_GLASS_PANE);
			p.getBlock().setData((byte) 15);
			q.getBlock().setType(Material.STAINED_GLASS_PANE);
			q.getBlock().setData((byte) 0);
			r.getBlock().setType(Material.STAINED_GLASS_PANE);
			r.getBlock().setData((byte) 15);
			s.getBlock().setType(Material.COAL_BLOCK);
			t.getBlock().setType(Material.QUARTZ_BLOCK);
			u.getBlock().setType(Material.COAL_BLOCK);
			v.getBlock().setType(Material.QUARTZ_BLOCK);
			w.getBlock().setType(Material.COAL_BLOCK);
			x.getBlock().setType(Material.QUARTZ_BLOCK);
			y.getBlock().setType(Material.COAL_BLOCK);
			z.getBlock().setType(Material.QUARTZ_BLOCK);
			aa.getBlock().setType(Material.COAL_BLOCK);
		}   else if (selected_capsule.equalsIgnoreCase("mushroom_red")) {
			 b.getBlock().setType(Material.HUGE_MUSHROOM_2);
			 d.getBlock().setType(Material.HUGE_MUSHROOM_2);
			 f.getBlock().setType(Material.HUGE_MUSHROOM_2);
			 h.getBlock().setType(Material.HUGE_MUSHROOM_2);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 14);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 14);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 14);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 14);
			 w.getBlock().setType(Material.HUGE_MUSHROOM_2);
		}    else if (selected_capsule.equalsIgnoreCase("mushroom_brown")) {
			 b.getBlock().setType(Material.HUGE_MUSHROOM_1);
			 d.getBlock().setType(Material.HUGE_MUSHROOM_1);
			 f.getBlock().setType(Material.HUGE_MUSHROOM_1);
			 h.getBlock().setType(Material.HUGE_MUSHROOM_1);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 12);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 12);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 12);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 12);
			 w.getBlock().setType(Material.HUGE_MUSHROOM_1);
		}    else if (selected_capsule.equalsIgnoreCase("slime")) {
			 b.getBlock().setType(Material.SLIME_BLOCK);
			 d.getBlock().setType(Material.SLIME_BLOCK);
			 f.getBlock().setType(Material.SLIME_BLOCK);
			 h.getBlock().setType(Material.SLIME_BLOCK);
			 k.getBlock().setType(Material.SLIME_BLOCK);
			 m.getBlock().setType(Material.SLIME_BLOCK);
			 o.getBlock().setType(Material.SLIME_BLOCK);
			 q.getBlock().setType(Material.SLIME_BLOCK);
			 w.getBlock().setType(Material.SLIME_BLOCK);
		}   else if (selected_capsule.equalsIgnoreCase("prismarine")) {
			 b.getBlock().setType(Material.PRISMARINE);
			 d.getBlock().setType(Material.PRISMARINE);
			 f.getBlock().setType(Material.PRISMARINE);
			 h.getBlock().setType(Material.PRISMARINE);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 9);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 9);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 9);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 9);
			 w.getBlock().setType(Material.SEA_LANTERN);
		}   else if (selected_capsule.equalsIgnoreCase("sandstone")) {
			 b.getBlock().setType(Material.SANDSTONE);
			 b.getBlock().setData((byte)1);
			 d.getBlock().setType(Material.SANDSTONE);
			 b.getBlock().setData((byte)1);
			 f.getBlock().setType(Material.SANDSTONE);
			 b.getBlock().setData((byte)1);
			 h.getBlock().setType(Material.SANDSTONE);
			 b.getBlock().setData((byte)1);
			 
			 k.getBlock().setType(Material.BIRCH_FENCE);
			 m.getBlock().setType(Material.BIRCH_FENCE);
			 o.getBlock().setType(Material.BIRCH_FENCE);
			 q.getBlock().setType(Material.BIRCH_FENCE);
			 
			 w.getBlock().setType(Material.SANDSTONE);
			 w.getBlock().setData((byte)1);
			 t.getBlock().setType(Material.SANDSTONE);
			 t.getBlock().setData((byte)1);
			 v.getBlock().setType(Material.SANDSTONE);
			 v.getBlock().setData((byte)1);
			 x.getBlock().setType(Material.SANDSTONE);
			 x.getBlock().setData((byte)1);
			 z.getBlock().setType(Material.SANDSTONE);
			 z.getBlock().setData((byte)1);
		} else if (selected_capsule.equalsIgnoreCase("redsandstone")) {
			 b.getBlock().setType(Material.RED_SANDSTONE);
			 b.getBlock().setData((byte)1);
			 d.getBlock().setType(Material.RED_SANDSTONE);
			 b.getBlock().setData((byte)1);
			 f.getBlock().setType(Material.RED_SANDSTONE);
			 b.getBlock().setData((byte)1);
			 h.getBlock().setType(Material.RED_SANDSTONE);
			 b.getBlock().setData((byte)1);
			 
			 k.getBlock().setType(Material.ACACIA_FENCE);
			 m.getBlock().setType(Material.ACACIA_FENCE);
			 o.getBlock().setType(Material.ACACIA_FENCE);
			 q.getBlock().setType(Material.ACACIA_FENCE);
			 
			 w.getBlock().setType(Material.RED_SANDSTONE);
			 w.getBlock().setData((byte)1);
			 t.getBlock().setType(Material.RED_SANDSTONE);
			 t.getBlock().setData((byte)1);
			 v.getBlock().setType(Material.RED_SANDSTONE);
			 v.getBlock().setData((byte)1);
			 x.getBlock().setType(Material.RED_SANDSTONE);
			 x.getBlock().setData((byte)1);
			 z.getBlock().setType(Material.RED_SANDSTONE);
			 z.getBlock().setData((byte)1);
		}   else if (selected_capsule.equalsIgnoreCase("tnt")) {
			 b.getBlock().setType(Material.TNT);
			 d.getBlock().setType(Material.TNT);
			 f.getBlock().setType(Material.TNT);
			 h.getBlock().setType(Material.TNT);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 14);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 14);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 14);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 14);
			 w.getBlock().setType(Material.REDSTONE_BLOCK);
		} else if (selected_capsule.equalsIgnoreCase("magma")) {
			 b.getBlock().setType(Material.RED_NETHER_BRICK);
			 d.getBlock().setType(Material.RED_NETHER_BRICK);
			 f.getBlock().setType(Material.RED_NETHER_BRICK);
			 h.getBlock().setType(Material.RED_NETHER_BRICK);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 14);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 14);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 14);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 14);
			 w.getBlock().setType(Material.MAGMA);
		} else if (selected_capsule.equalsIgnoreCase("snowgolem")) {
			 b.getBlock().setType(Material.SNOW_BLOCK);
			 d.getBlock().setType(Material.SNOW_BLOCK);
			 f.getBlock().setType(Material.SNOW_BLOCK);
			 h.getBlock().setType(Material.SNOW_BLOCK);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 0);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 0);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 0);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 0);
			 w.getBlock().setType(Material.PUMPKIN);
		}  else if (selected_capsule.equalsIgnoreCase("cactus")) {
			 b.getBlock().setType(Material.CACTUS);
			 d.getBlock().setType(Material.CACTUS);
			 f.getBlock().setType(Material.CACTUS);
			 h.getBlock().setType(Material.CACTUS);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 13);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 13);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 13);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 13);
			 w.getBlock().setType(Material.CACTUS);
		} else if (selected_capsule.equalsIgnoreCase("portal")) {
			 b.getBlock().setType(Material.OBSIDIAN);
			 d.getBlock().setType(Material.OBSIDIAN);
			 f.getBlock().setType(Material.OBSIDIAN);
			 h.getBlock().setType(Material.OBSIDIAN);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 10);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 10);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 10);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 10);
			 w.getBlock().setType(Material.OBSIDIAN);
		} else if (selected_capsule.equalsIgnoreCase("packedice")) {
			 b.getBlock().setType(Material.PACKED_ICE);
			 d.getBlock().setType(Material.PACKED_ICE);
			 f.getBlock().setType(Material.PACKED_ICE);
			 h.getBlock().setType(Material.PACKED_ICE);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 9);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 9);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 9);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 9);
			 w.getBlock().setType(Material.PACKED_ICE);
		} else if (selected_capsule.equalsIgnoreCase("sponge")) {
			 b.getBlock().setType(Material.SPONGE);
			 d.getBlock().setType(Material.SPONGE);
			 f.getBlock().setType(Material.SPONGE);
			 h.getBlock().setType(Material.SPONGE);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 4);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 4);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 4);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 4);
			 w.getBlock().setType(Material.SPONGE);
		} else if (selected_capsule.equalsIgnoreCase("bedrock")) {
			 b.getBlock().setType(Material.BEDROCK);
			 d.getBlock().setType(Material.BEDROCK);
			 f.getBlock().setType(Material.BEDROCK);
			 h.getBlock().setType(Material.BEDROCK);
			 k.getBlock().setType(Material.STAINED_GLASS);
			 k.getBlock().setData((byte) 15);
			 m.getBlock().setType(Material.STAINED_GLASS);
			 m.getBlock().setData((byte) 15);
			 o.getBlock().setType(Material.STAINED_GLASS);
			 o.getBlock().setData((byte) 15);
			 q.getBlock().setType(Material.STAINED_GLASS);
			 q.getBlock().setData((byte) 15);
			 w.getBlock().setType(Material.BEDROCK);
		} else if (selected_capsule.equalsIgnoreCase("invisible")) {
			 b.getBlock().setType(Material.BARRIER);
			 d.getBlock().setType(Material.BARRIER);
			 f.getBlock().setType(Material.BARRIER);
			 h.getBlock().setType(Material.BARRIER);
			 w.getBlock().setType(Material.BARRIER);
		} else if (selected_capsule.equalsIgnoreCase("beach")) {
			a.getBlock().setType(Material.BARRIER);
			b.getBlock().setType(Material.BARRIER);
			c.getBlock().setType(Material.BARRIER);
			d.getBlock().setType(Material.BIRCH_WOOD_STAIRS);
			f.getBlock().setType(Material.BARRIER);
			g.getBlock().setType(Material.BARRIER);
			h.getBlock().setType(Material.BARRIER);
			i.getBlock().setType(Material.BARRIER);
			j.getBlock().setType(Material.BARRIER);
			k.getBlock().setType(Material.BARRIER);
			l.getBlock().setType(Material.BARRIER);
			m.getBlock().setType(Material.BIRCH_FENCE);
			o.getBlock().setType(Material.BARRIER);
			p.getBlock().setType(Material.BARRIER);
			q.getBlock().setType(Material.BARRIER);
			r.getBlock().setType(Material.BARRIER);
			s.getBlock().setType(Material.CARPET);
			s.getBlock().setData((byte)0);
			t.getBlock().setType(Material.CARPET);
			t.getBlock().setData((byte)0);
			u.getBlock().setType(Material.CARPET);
			u.getBlock().setData((byte)0);
			v.getBlock().setType(Material.STEP);
			v.getBlock().setData((byte)2);
			w.getBlock().setType(Material.STEP);
			w.getBlock().setData((byte)2);
			x.getBlock().setType(Material.CARPET);
			x.getBlock().setData((byte)0);
			y.getBlock().setType(Material.CARPET);
			y.getBlock().setData((byte)0);
			z.getBlock().setType(Material.CARPET);
			z.getBlock().setData((byte)0);
			aa.getBlock().setType(Material.CARPET);
			aa.getBlock().setData((byte)0);
			
			
		} else if (selected_capsule.equalsIgnoreCase("anvil")) {
			 b.getBlock().setType(Material.ANVIL);
			 d.getBlock().setType(Material.ANVIL);
			 f.getBlock().setType(Material.ANVIL);
			 h.getBlock().setType(Material.ANVIL);
			 k.getBlock().setType(Material.ANVIL);
			 m.getBlock().setType(Material.ANVIL);
			 o.getBlock().setType(Material.ANVIL);
			 q.getBlock().setType(Material.ANVIL);
			 w.getBlock().setType(Material.IRON_BLOCK);
		} else if (selected_capsule.equalsIgnoreCase("web")) {
			 b.getBlock().setType(Material.WEB);
			 d.getBlock().setType(Material.WEB);
			 e.getBlock().setType(Material.WEB);
			 f.getBlock().setType(Material.WEB);
			 h.getBlock().setType(Material.WEB);
			 
			 k.getBlock().setType(Material.BARRIER);
			 m.getBlock().setType(Material.BARRIER);
			 n.getBlock().setType(Material.WEB);
			 o.getBlock().setType(Material.BARRIER);
			 q.getBlock().setType(Material.BARRIER);
			 w.getBlock().setType(Material.BARRIER);
		} else if (selected_capsule.equalsIgnoreCase("jukebox")) {
			a.getBlock().setType(Material.WOOD_STEP);
			a.getBlock().setData((byte)1);
			c.getBlock().setType(Material.WOOD_STEP);
			c.getBlock().setData((byte)1);
			g.getBlock().setType(Material.WOOD_STEP);
			g.getBlock().setData((byte)1);
			i.getBlock().setType(Material.WOOD_STEP);
			i.getBlock().setData((byte)1);
			b.getBlock().setType(Material.JUKEBOX);
			d.getBlock().setType(Material.JUKEBOX);
			f.getBlock().setType(Material.JUKEBOX);
			h.getBlock().setType(Material.JUKEBOX);
			j.getBlock().setType(Material.WOOD);
			j.getBlock().setData((byte)3);
			l.getBlock().setType(Material.WOOD);
			l.getBlock().setData((byte)3);
			p.getBlock().setType(Material.WOOD);
			p.getBlock().setData((byte)3);
			r.getBlock().setType(Material.WOOD);
			r.getBlock().setData((byte)3);
			
			k.getBlock().setType(Material.STAINED_GLASS);
			k.getBlock().setData((byte)12);
			m.getBlock().setType(Material.STAINED_GLASS);
			m.getBlock().setData((byte)12);
			o.getBlock().setType(Material.STAINED_GLASS);
			o.getBlock().setData((byte)12);
			q.getBlock().setType(Material.STAINED_GLASS);
			q.getBlock().setData((byte)12);
			
			s.getBlock().setType(Material.WOOD_STEP);
			s.getBlock().setData((byte)1);
			u.getBlock().setType(Material.WOOD_STEP);
			u.getBlock().setData((byte)1);
			y.getBlock().setType(Material.WOOD_STEP);
			y.getBlock().setData((byte)1);
			aa.getBlock().setType(Material.WOOD_STEP);
			aa.getBlock().setData((byte)1);
			
			t.getBlock().setType(Material.JUKEBOX);
			v.getBlock().setType(Material.JUKEBOX);
			x.getBlock().setType(Material.JUKEBOX);
			z.getBlock().setType(Material.JUKEBOX);
			w.getBlock().setType(Material.JUKEBOX);
			
			
			
		} else if (selected_capsule.equalsIgnoreCase("end")) {
			a.getBlock().setType(Material.END_BRICKS);
			c.getBlock().setType(Material.END_BRICKS);
			g.getBlock().setType(Material.END_BRICKS);
			i.getBlock().setType(Material.END_BRICKS);
			
			b.getBlock().setType(Material.END_ROD);
			b.getBlock().setData((byte)4);
			d.getBlock().setType(Material.END_ROD);
			d.getBlock().setData((byte)3);
			f.getBlock().setType(Material.END_ROD);
			f.getBlock().setData((byte)3);
			h.getBlock().setType(Material.END_ROD);
			h.getBlock().setData((byte)4);
			
			j.getBlock().setType(Material.END_BRICKS);
			l.getBlock().setType(Material.END_BRICKS);
			p.getBlock().setType(Material.END_BRICKS);
			r.getBlock().setType(Material.END_BRICKS);
			
			k.getBlock().setType(Material.END_ROD);
			k.getBlock().setData((byte)4);
			m.getBlock().setType(Material.END_ROD);
			m.getBlock().setData((byte)3);
			o.getBlock().setType(Material.END_ROD);
			o.getBlock().setData((byte)3);
			q.getBlock().setType(Material.END_ROD);
			q.getBlock().setData((byte)4);
			w.getBlock().setType(Material.END_BRICKS);
			
			
		} else if (selected_capsule.equalsIgnoreCase("tank")) {
			 b.getBlock().setType(Material.GLASS);
			 d.getBlock().setType(Material.GLASS);
			 f.getBlock().setType(Material.GLASS);
			 h.getBlock().setType(Material.GLASS);
			 e.getBlock().setType(Material.WATER);
			 e.getBlock().setType(Material.WATER);
			 n.getBlock().setType(Material.WATER);
			 k.getBlock().setType(Material.GLASS);
			 m.getBlock().setType(Material.GLASS);
			 o.getBlock().setType(Material.GLASS);
			 q.getBlock().setType(Material.GLASS);
			 
			 w.getBlock().setType(Material.BARRIER);
			 
			 w.getBlock().setType(Material.DAYLIGHT_DETECTOR);
		} else if (selected_capsule.equalsIgnoreCase("beacon")) {
			

			a.getBlock().setType(Material.DIAMOND_BLOCK);
			b.getBlock().setType(Material.DIAMOND_BLOCK);
			c.getBlock().setType(Material.DIAMOND_BLOCK);
			d.getBlock().setType(Material.DIAMOND_BLOCK);
			e.getBlock().setType(Material.DIAMOND_BLOCK);
			f.getBlock().setType(Material.DIAMOND_BLOCK);
			g.getBlock().setType(Material.DIAMOND_BLOCK);
			h.getBlock().setType(Material.DIAMOND_BLOCK);
			i.getBlock().setType(Material.DIAMOND_BLOCK);
			n.getBlock().setType(Material.BEACON);
			w.getBlock().setType(Material.BARRIER);		
			m.getBlock().setType(Material.BARRIER);		
			q.getBlock().setType(Material.BARRIER);		
			o.getBlock().setType(Material.BARRIER);		
			k.getBlock().setType(Material.BARRIER);		
		} else {
			 b.getBlock().setType(Material.GLASS);
			 d.getBlock().setType(Material.GLASS);
			 f.getBlock().setType(Material.GLASS);
			 h.getBlock().setType(Material.GLASS);
			 
			 k.getBlock().setType(Material.GLASS);
			 m.getBlock().setType(Material.GLASS);
			 o.getBlock().setType(Material.GLASS);
			 q.getBlock().setType(Material.GLASS);
			 
			 w.getBlock().setType(Material.GLASS);
		}

	}

}
