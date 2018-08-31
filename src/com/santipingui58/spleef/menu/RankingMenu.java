package com.santipingui58.spleef.menu;





import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.utils.ItemBuilder;




public class RankingMenu extends MenuBuilder {

	public static HashMap<Player,Integer> page = new HashMap<Player,Integer>();
	
	
	public RankingMenu(Player p) {
		super("§c§lRanking ASP", 6);
		Set<String> players = Main.ranking.getConfig().getConfigurationSection("players").getKeys(false);
		int j = 1;
		int k = 1;
		int columna =1;
		
		for (int i=(18*page.get(p)+1); i<players.size(); i++) { 
			for (String nombre : players) {
				if (Main.ranking.getConfig().getInt("players."+nombre+".position") == i) {
					ItemStack player = new ItemStack(Material.SKULL_ITEM, 1, (short)3);   
					
					 SkullMeta playerMeta = (SkullMeta) player.getItemMeta();
					 playerMeta.setOwner(DataManager.getName(nombre));
						
					 String change = Main.ranking.getConfig().getString("players."+nombre+".change");
					 
					 	if (change.contains("+")) {
					 	   playerMeta.setDisplayName("§6§l#"+i + " §d§l"+ DataManager.getName(nombre) + " §a"+change);
					 	} else if (change.contains("-"))
					 	{
					 		 playerMeta.setDisplayName("§6§l#"+i + " §d§l"+ DataManager.getName(nombre) + " §c"+change);
					 	} else if (change.contains("=")) {
					 		 playerMeta.setDisplayName("§6§l#"+i + " §d§l"+ DataManager.getName(nombre) + " §7"+change);
					 	}
					 		
				     
				        
				      
				       List<String> lore = new ArrayList<String>();
				       for (String s : Main.ranking.getConfig().getStringList("players."+nombre+".records")) {
				       lore.add(ChatColor.translateAlternateColorCodes('&', s)); 
				       }
				       lore.add("§6Score: §c" +  Main.ranking.getConfig().getInt("players."+nombre+".score"));
				       playerMeta.setLore(lore);
				       player.setItemMeta(playerMeta);
				       if (columna<=3) {
				        if (k<=6) {
				        	k++;
				        } else {
				        	k=2;
				        	columna++;
				        	j=1;
				        }
				        if (j<53) {
				        	if (columna == 1) {
				        s(j, player);
				        s(j-1,getCountryHead(Main.ranking.getConfig().getString("players."+nombre+".IP")));
				        if (((j+3)-1) !=17 || ((j+3)-1) !=44)
				        s(j+1, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)10).build());
				        j=j+9;
				        } else if (columna==2) {
							s(j+3, player);
					        s((j+3)-1,getCountryHead(Main.ranking.getConfig().getString("players."+nombre+".IP")));
					        if (((j+3)-1) !=17 || ((j+3)-1) !=44) s((j+3)+1, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)4).build());
					        j=j+9;
					        } else if (columna==3) {
								s(j+6, player);
						        s((j+6)-1,getCountryHead(Main.ranking.getConfig().getString("players."+nombre+".IP")));
						        if (((j+3)-1) !=17 || ((j+3)-1) !=44)
						        s((j+6)+1, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)10).build());
						        j=j+9;
						        }
				        } 
				} else {
					int next = page.get(p)+2;
					if (columna>=3 || j>=53)
					s(44, new ItemBuilder(Material.ARROW).setTitle("§ePágina " + next).build());
					
					return;}
				       
			        } 
				
	
				}
			
			int prext = page.get(p);
			if (page.get(p)>0) 
				s(17, new ItemBuilder(Material.ARROW).setTitle("§ePágina " + prext).build());   
			        } 
		
		} 
			       
				

		
			
	        
  


	
	//ARG http://textures.minecraft.net/texture/f6d033dc5f675ad51bc06c7a1949c35a1d37e48a2e1c2789c2cf7d30ec58f32c
	//MEX http://textures.minecraft.net/texture/ca971bfcf33b439821b4e5f0c86cd61435cd3e0c819e35dd9774ef0399f132b
	//CHILE http://textures.minecraft.net/texture/ed1dddc665614c9f6487ba9c666da7579561589a494ef744aaf8f4f88a16
	// 
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 17) {
			if (page.get(p)>0)  {
			int i = page.get(p);
			page.put(p, i-1);
			new RankingMenu(p).o(p);
			}
		} else if (slot ==44) {
			int next = page.get(p)+2;
			if (stack.equals(new ItemBuilder(Material.ARROW).setTitle("§ePágina " + next).build()));
			int i = page.get(p);
			page.put(p, i+1);
			new RankingMenu(p).o(p);
		}
	}
	
	
	
	static ItemStack getCountryHead(String IP) {
		
		if (IP.equalsIgnoreCase("AR")) {
			ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/f6d033dc5f675ad51bc06c7a1949c35a1d37e48a2e1c2789c2cf7d30ec58f32c");
			ItemMeta meta = head.getItemMeta();
			meta.setDisplayName("§b§lArg§f§lent§b§lina");
			head.setItemMeta(meta);
			return head;
		} else if (IP.equalsIgnoreCase("MX")) {
			ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/ca971bfcf33b439821b4e5f0c86cd61435cd3e0c819e35dd9774ef0399f132b");
			ItemMeta meta = head.getItemMeta();
			meta.setDisplayName("§2§lMe§f§lxi§c§lco");
			head.setItemMeta(meta);
			return head;
		} else if (IP.equalsIgnoreCase("CL")) {
			ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/ed1dddc665614c9f6487ba9c666da7579561589a494ef744aaf8f4f88a16");
			ItemMeta meta = head.getItemMeta();
			meta.setDisplayName("§4§lCh§f§lil§9§le");
			head.setItemMeta(meta);
			return head;
		} else if (IP.equalsIgnoreCase("PE")) {
			ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/24d03bd4410babdc682493b3c2bba26e730e6bc658d3888e79bf712f853");
			ItemMeta meta = head.getItemMeta();
			meta.setDisplayName("§4§lP§f§ler§4§lu");
			head.setItemMeta(meta);
			return head;
		} else if (IP.equalsIgnoreCase("ES")) {
			ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/a9f5799dfb7de65350337e735651d4c831f1c2a827d584b02d8e875ff8eaa2");
			ItemMeta meta = head.getItemMeta();
			meta.setDisplayName("§c§lEs§e§lpa§c§lña");
			head.setItemMeta(meta);
			return head;
		} else if (IP.equalsIgnoreCase("CO")) {
			ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/c72120b9fe77d770b254b39c7be9b1ceccef6adfe7a5cc689ab1fd23e3c");
			ItemMeta meta = head.getItemMeta();
			meta.setDisplayName("§6§lCol§9§lomb§c§lia");
			head.setItemMeta(meta);
			return head;
		} else if (IP.equalsIgnoreCase("UY")) {
			ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/d1737fc2b4c61f2c119db7e146b2258ed8b677434ad277dffb43fc9f8e5127");
			ItemMeta meta = head.getItemMeta();
			meta.setDisplayName("§f§lUru§b§lg§e§lu§f§lay");
			head.setItemMeta(meta);
			return head;
		}  else if (IP.equalsIgnoreCase("US")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/4cac9774da1217248532ce147f7831f67a12fdcca1cf0cb4b3848de6bc94b4");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§9§lUn§4§lit§f§led §9§lSt§4§lat§f§les");
				head.setItemMeta(meta);
				return head;
			}  else if (IP.equalsIgnoreCase("BR")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/9668a1fb6af81b231bbcc4de5f7f95803bbd194f5827da027fa70321cf47c");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§2§lBr§e§laz§2§lil");
				head.setItemMeta(meta);
				return head;
			} else if (IP.equalsIgnoreCase("CA")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/f241a697f6dfb1c57cda327baa6732a7828c398be4ebfdbd166c232bcae2b");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§c§lCa§f§lna§c§lda");
				head.setItemMeta(meta);
				return head;
			}   else if (IP.equalsIgnoreCase("EC")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/41b36925f2fc31480d9f87a4784c44dd9a4779f71ccc5d6da1fb12fabe2e4");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§6§lEcu§9§lad§c§lor");
				head.setItemMeta(meta);
				return head;
			} else if (IP.equalsIgnoreCase("VE")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/86ef4055347aa799352b0e838484bcb6b10777efab6fba0897a67a220c8514c");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§6§lVen§1§lezu§4§lela");
				head.setItemMeta(meta);
				return head;
			} else if (IP.equalsIgnoreCase("GT")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/48444cd62c2254355c51d4db554589b4748e4f4269258f1ddaabe3d375caff");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§b§lGua§f§ltem§b§lala");
				head.setItemMeta(meta);
				return head;
			} else if (IP.equalsIgnoreCase("GB")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/5d263199c737676d72cdf446d73119b58f8fe70a39bd5ab8c82724da6b4744");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§9§lUnited §4§lKingdom");
				head.setItemMeta(meta);
				return head;
				
			}
			else if (IP.equalsIgnoreCase("SV")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/f7771acfbfe451e58590de413ad1b5d41f5da84f974df7db16e2fd79df32e43");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§fE§1§ll §f§lSalv§1§lador");
				head.setItemMeta(meta);
				return head;
				
			}
			else if (IP.equalsIgnoreCase("PY")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/8bff557d6b3bfedd68c5ef2827ac8c7f694e2379dd14150fb22db8371d5e1");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§c§lPar§f§lag§9§luay");
				head.setItemMeta(meta);
				return head;
				
			}
			else if (IP.equalsIgnoreCase("PL")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/921b2af8d2322282fce4a1aa4f257a52b68e27eb334f4a181fd976bae6d8eb");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§f§lPol§c§land");
				head.setItemMeta(meta);
				return head;
				
			}
		
			else if (IP.equalsIgnoreCase("TR")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/6bbeaf52e1c4bfcd8a1f4c6913234b840241aa48829c15abc6ff8fdf92cd89e");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§4§lTur§f§lkey");
				head.setItemMeta(meta);
				return head;
				
			}
			else if (IP.equalsIgnoreCase("AU")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/cf4aa2a244784d48b155ff044b8cf96df5bd4e87e01924a75d62a9242a16cf");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§9§lAus§4§lt§f§lrS9§lalia");
				head.setItemMeta(meta);
				return head;
				
			}
			else if (IP.equalsIgnoreCase("SE")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/e910904bff9c86f6ed47688e9429c26e8d9c5d5743bd3ebb8e6f5040be192998");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("§1§lSw§e§led§1§len");
				head.setItemMeta(meta);
				return head;
				
			}
		
			else if (IP.equalsIgnoreCase("NL")) {
				ItemStack head = Main.getSkull("http://textures.minecraft.net/texture/4c1cdecc8cbf486d1518b1a215312358c894d48b16873629f16ac81d1904d5d");
				ItemMeta meta = head.getItemMeta();
				meta.setDisplayName("Sc§lNet§f§lher§9§llands");
				head.setItemMeta(meta);
				return head;
				
			}
		
		
		
		//Holanda
		//India
		//Australia
		//Suecia
		//Republica Checa
		//Vietnam
		//Ucrania
		
		
		
		ItemStack player = new ItemStack(Material.SKULL_ITEM, 1, (short)3);      
        SkullMeta playerMeta = (SkullMeta) player.getItemMeta();
        playerMeta.setOwner("MHF_Question");
        playerMeta.setDisplayName("§c§l???");
        player.setItemMeta(playerMeta);
		return player;
	}

}
