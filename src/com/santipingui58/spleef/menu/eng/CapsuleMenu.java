package com.santipingui58.spleef.menu.eng;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.CapsuleManager;
import com.santipingui58.spleef.managers.EconomyManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;

import ru.tehkode.permissions.bukkit.PermissionsEx;




public class CapsuleMenu extends MenuBuilder {

	public static HashMap<Player,Integer> page = new HashMap<Player,Integer>();
	
	public CapsuleMenu(Player p) {
		super("§a§lCapsules", 6);
		
			if (page.get(p)==1) {
			ItemStack glass_white = new ItemStack(Material.STAINED_GLASS, 1, (short)0);      
	        ItemMeta glass_whiteMeta =  glass_white.getItemMeta();
	        List<String> glass_whiteLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_white")) {
	        	glass_whiteMeta.setDisplayName("§fWhite Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_white")) {
	        		glass_whiteLore.add("§aSelected!");
	        		glass_whiteMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_whiteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_whiteLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_whiteMeta.setDisplayName("§cWhite Colored Capsule");
	        	glass_whiteLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_whiteMeta.setLore(glass_whiteLore);
	        glass_white.setItemMeta(glass_whiteMeta);
		
	        ItemStack glass_orange = new ItemStack(Material.STAINED_GLASS, 1, (short)1);      
	        ItemMeta glass_orangeMeta =  glass_orange.getItemMeta();
	        List<String> glass_orangeLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_orange")) {
	        	glass_orangeMeta.setDisplayName("§6Orange Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_orange")) {
	        		glass_orangeLore.add("§aSelected!");
	        		glass_orangeMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_orangeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_orangeLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_orangeMeta.setDisplayName("§cOrange Colored Capsule");
	        	glass_orangeLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_orangeMeta.setLore(glass_orangeLore);
	        glass_orange.setItemMeta(glass_orangeMeta);
		
		
	        
	        
	        ItemStack glass_magenta = new ItemStack(Material.STAINED_GLASS, 1, (short)2);      
	        ItemMeta glass_magentaMeta =  glass_magenta.getItemMeta();
	        List<String> glass_magentaLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_magenta")) {
	        	glass_magentaMeta.setDisplayName("§dMagenta Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_magenta")) {
	        		glass_magentaLore.add("§aSelected!");
	        		glass_magentaMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_magentaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_magentaLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_magentaMeta.setDisplayName("§cMagenta Colored Capsule");
	        	glass_magentaLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_magentaMeta.setLore(glass_magentaLore);
	        glass_magenta.setItemMeta(glass_magentaMeta);
		
	        
	        ItemStack glass_lightblue = new ItemStack(Material.STAINED_GLASS, 1, (short)3);      
	        ItemMeta glass_lightblueMeta =  glass_lightblue.getItemMeta();
	        List<String> glass_lightblueLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_lightblue")) {
	        	glass_lightblueMeta.setDisplayName("§bLight Blue Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_lightblue")) {
	        		glass_lightblueLore.add("§aSelected!");
	        		glass_lightblueMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_lightblueMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_lightblueLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_lightblueMeta.setDisplayName("§cLight Blue Colored Capsule");
	        	glass_lightblueLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_lightblueMeta.setLore(glass_lightblueLore);
	        glass_lightblue.setItemMeta(glass_lightblueMeta);
	        
	        
	        ItemStack glass_yellow = new ItemStack(Material.STAINED_GLASS, 1, (short)4);      
	        ItemMeta glass_yellowMeta =  glass_yellow.getItemMeta();
	        List<String> glass_yellowLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_yellow")) {
	        	glass_yellowMeta.setDisplayName("§eYellow Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_yellow")) {
	        		glass_yellowLore.add("§aSelected!");
	        		glass_yellowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_yellowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        		
	        	} else {
	        		glass_yellowLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_yellowMeta.setDisplayName("§cYellow Colored Capsule");
	        	glass_yellowLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_yellowMeta.setLore(glass_yellowLore);
	        glass_yellow.setItemMeta(glass_yellowMeta);
	        
	        
	        ItemStack glass_lime = new ItemStack(Material.STAINED_GLASS, 1, (short)5);      
	        ItemMeta glass_limeMeta =  glass_lime.getItemMeta();
	        List<String> glass_limeLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_lime")) {
	        	glass_limeMeta.setDisplayName("§aLime Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_lime")) {
	        		glass_limeLore.add("§aSelected!");
	        		glass_limeMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_limeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_limeLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_limeMeta.setDisplayName("§cLime Colored Capsule");
	        	glass_limeLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_limeMeta.setLore(glass_limeLore);
	        glass_lime.setItemMeta(glass_limeMeta);
	        
	        
	        ItemStack glass_pink = new ItemStack(Material.STAINED_GLASS, 1, (short)6);      
	        ItemMeta glass_pinkMeta =  glass_pink.getItemMeta();
	        List<String> glass_pinkLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_pink")) {
	        	glass_pinkMeta.setDisplayName("§dPink Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_pink")) {
	        		glass_pinkLore.add("§aSelected!");
	        		glass_pinkMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_pinkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_pinkLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_pinkMeta.setDisplayName("§cPink Colored Capsule");
	        	glass_pinkLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_pinkMeta.setLore(glass_pinkLore);
	        glass_pink.setItemMeta(glass_pinkMeta);
	        
	        
	        
	        ItemStack glass_gray = new ItemStack(Material.STAINED_GLASS, 1, (short)7);      
	        ItemMeta glass_grayMeta =  glass_gray.getItemMeta();
	        List<String> glass_grayLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_gray")) {
	        	glass_grayMeta.setDisplayName("§8Gray Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_gray")) {
	        		glass_grayLore.add("§aSelected!");
	        		glass_grayMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_grayMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_grayLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_grayMeta.setDisplayName("§cGray Colored Capsule");
	        	glass_grayLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_grayMeta.setLore(glass_grayLore);
	        glass_gray.setItemMeta(glass_grayMeta);
	        
	        ItemStack glass_lightgray = new ItemStack(Material.STAINED_GLASS, 1, (short)8);      
	        ItemMeta glass_lightgrayMeta =  glass_lightgray.getItemMeta();
	        List<String> glass_lightgrayLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_lightgray")) {
	        	glass_lightgrayMeta.setDisplayName("§7Light Gray Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_lightgray")) {
	        		glass_lightgrayLore.add("§aSelected!");
	        		glass_lightgrayMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_lightgrayMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_lightgrayLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_lightgrayMeta.setDisplayName("§cLight Gray Colored Capsule");
	        	glass_lightgrayLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_lightgrayMeta.setLore(glass_lightgrayLore);
	        glass_lightgray.setItemMeta(glass_lightgrayMeta);
	        
	        
	    
	        
	        ItemStack glass_cyan = new ItemStack(Material.STAINED_GLASS, 1, (short)9);      
	        ItemMeta glass_cyanMeta =  glass_cyan.getItemMeta();
	        List<String> glass_cyanLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_cyan")) {
	        	glass_cyanMeta.setDisplayName("§3Cyan Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_cyan")) {
	        		glass_cyanLore.add("§aSelected!");
	        		glass_cyanMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_cyanMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_cyanLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_cyanMeta.setDisplayName("§cCyan Colored Capsule");
	        	glass_cyanLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_cyanMeta.setLore(glass_cyanLore);
	        glass_cyan.setItemMeta(glass_cyanMeta);
	        
	        
	        ItemStack glass_purple = new ItemStack(Material.STAINED_GLASS, 1, (short)10);      
	        ItemMeta glass_purpleMeta =  glass_purple.getItemMeta();
	        List<String> glass_purpleLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_purple")) {
	        	glass_purpleMeta.setDisplayName("§5Purle Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_purple")) {
	        		glass_purpleLore.add("§aSelected!");
	        		glass_purpleMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_purpleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_purpleLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_purpleMeta.setDisplayName("§cPurle Colored Capsule");
	        	glass_purpleLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_purpleMeta.setLore(glass_purpleLore);
	        glass_purple.setItemMeta(glass_purpleMeta);
	        
	        
	        
	        ItemStack glass_blue = new ItemStack(Material.STAINED_GLASS, 1, (short)11);      
	        ItemMeta glass_blueMeta =  glass_blue.getItemMeta();
	        List<String> glass_blueLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_blue")) {
	        	glass_blueMeta.setDisplayName("§1Blue Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_blue")) {
	        		glass_blueLore.add("§aSelected!");
	        		glass_blueMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_blueMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_blueLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_blueMeta.setDisplayName("§cBlue Colored Capsule");
	        	glass_blueLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_blueMeta.setLore(glass_blueLore);
	        glass_blue.setItemMeta(glass_blueMeta);
	        
	        
	        ItemStack glass_brown = new ItemStack(Material.STAINED_GLASS, 1, (short)12);      
	        ItemMeta glass_brownMeta =  glass_brown.getItemMeta();
	        List<String> glass_brownLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_brown")) {
	        	glass_brownMeta.setDisplayName("§6Brown Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_brown")) {
	        		glass_brownLore.add("§aSelected!");
	        		glass_brownMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_brownMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_brownLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_brownMeta.setDisplayName("§cBrown Colored Capsule");
	        	glass_brownLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_brownMeta.setLore(glass_brownLore);
	        glass_brown.setItemMeta(glass_brownMeta);
	        
	        
	        ItemStack glass_green = new ItemStack(Material.STAINED_GLASS, 1, (short)13);      
	        ItemMeta glass_greenMeta =  glass_green.getItemMeta();
	        List<String> glass_greenLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_green")) {
	        	glass_greenMeta.setDisplayName("§2Green Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_green")) {
	        		glass_greenLore.add("§aSelected!");
	        		glass_greenMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_greenMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_greenLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_greenMeta.setDisplayName("§cGreen Colored Capsule");
	        	glass_greenLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_greenMeta.setLore(glass_greenLore);
	        glass_green.setItemMeta(glass_greenMeta);
	        
	        ItemStack glass_red = new ItemStack(Material.STAINED_GLASS, 1, (short)14);      
	        ItemMeta glass_redMeta =  glass_red.getItemMeta();
	        List<String> glass_redLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_red")) {
	        	glass_redMeta.setDisplayName("§4Red Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_red")) {
	        		glass_redLore.add("§aSelected!");
	        		glass_redMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_redMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_redLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_redMeta.setDisplayName("§cRed Colored Capsule");
	        	glass_redLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_redMeta.setLore(glass_redLore);
	        glass_red.setItemMeta(glass_redMeta);
	        
	        
	        ItemStack glass_black = new ItemStack(Material.STAINED_GLASS, 1, (short)15);      
	        ItemMeta glass_blackMeta =  glass_black.getItemMeta();
	        List<String> glass_blackLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_black")) {
	        	glass_blackMeta.setDisplayName("§8Black Colored Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_black")) {
	        		glass_blackLore.add("§aSelected!");
	        		glass_blackMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_blackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_blackLore.add("§aClick to select!");
	        	}

	        } else {
	        	glass_blackMeta.setDisplayName("§cBlack Colored Capsule");
	        	glass_blackLore.add("§eBuy this capsule for: §62000 Coins");
	        }
	        glass_blackMeta.setLore(glass_blackLore);
	        glass_black.setItemMeta(glass_blackMeta);
	        
	        
	        ItemStack fence = new ItemStack(Material.FENCE); 
	        ItemMeta fenceMeta =  fence.getItemMeta();
	        List<String> fenceLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.fence")) {
	        	fenceMeta.setDisplayName("§eFence Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("fence")) {
	        		fenceLore.add("§aSelected!");
	        		fenceMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		fenceMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        		
	        	} else {
	        		fenceLore.add("§aClick to select!");
	        	}

	        } else {
	        	fenceMeta.setDisplayName("§cFence Capsule");
	        	fenceLore.add("§eBuy this capsule for: §62500 Coins");
	        }
	        fenceMeta.setLore(fenceLore);
	        fence.setItemMeta(fenceMeta);
	        s(25,fence);
	        
	        ItemStack slab = new ItemStack(Material.STEP); 
	        ItemMeta slabMeta =  slab.getItemMeta();
	        List<String> slabLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.slab")) {
	        	slabMeta.setDisplayName("§7Slab Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("slab")) {
	        		slabLore.add("§aSelected!");
	        		slabMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		slabMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		slabLore.add("§aClick to select!");
	        	}

	        } else {
	        	slabMeta.setDisplayName("§cSlab Capsule");
	        	slabLore.add("§eBuy this capsule for: §62500 Coins");
	        }
	        slabMeta.setLore(slabLore);
	        slab.setItemMeta(slabMeta);
	        s(26,slab);
	        
	        
	        ItemStack tree = new ItemStack(Material.SAPLING); 
	        ItemMeta treeMeta =  tree.getItemMeta();
	        List<String> treeLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.tree")) {
	        	treeMeta.setDisplayName("§aTree Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("tree")) {
	        		treeLore.add("§aSelected!");
	        		treeMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		treeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		treeLore.add("§aClick to select!");
	        	}

	        } else {
	        	treeMeta.setDisplayName("§cTree Capsule");
	        	treeLore.add("§eBuy this capsule for: §63000 Coins");
	        }
	        treeMeta.setLore(treeLore);
	        tree.setItemMeta(treeMeta);
	        s(27,tree);
	        
	        ItemStack leaves = new ItemStack(Material.LEAVES); 
	        ItemMeta leavesMeta =  leaves.getItemMeta();
	        List<String> leavesLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.leaves")) {
	        	leavesMeta.setDisplayName("§2Leaves Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("leaves")) {
	        		leavesLore.add("§aSelected!");
	        		leavesMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		leavesMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		leavesLore.add("§aClick to select!");
	        	}

	        } else {
	        	leavesMeta.setDisplayName("§cLeaves Capsule");
	        	leavesLore.add("§eBuy this capsule for: §63500 Coins");
	        }
	        leavesMeta.setLore(leavesLore);
	        leaves.setItemMeta(leavesMeta);
	        s(28,leaves);
	        
	        ItemStack cobblewall = new ItemStack(Material.COBBLE_WALL); 
	        ItemMeta cobblewallMeta =  cobblewall.getItemMeta();
	        List<String> cobblewallLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.cobblewall")) {
	        	cobblewallMeta.setDisplayName("§7Cobble Wall Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("cobblewall")) {
	        		cobblewallLore.add("§aSelected!");
	        		cobblewallMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		cobblewallMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		cobblewallLore.add("§aClick to select!");
	        	}

	        } else {
	        	cobblewallMeta.setDisplayName("§cCobble Wall Capsule");
	        	cobblewallLore.add("§eBuy this capsule for: §63500 Coins");
	        }
	        cobblewallMeta.setLore(cobblewallLore);
	        cobblewall.setItemMeta(cobblewallMeta);
	        s(29,cobblewall);
	        
	        
	        ItemStack diorite = new ItemStack(Material.STONE,1,(short)4); 
	        ItemMeta dioriteMeta =  diorite.getItemMeta();
	        List<String> dioriteLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.diorite")) {
	        	dioriteMeta.setDisplayName("§fDiorite Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("diorite")) {
	        		dioriteLore.add("§aSelected!");
	        		dioriteMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		dioriteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		dioriteLore.add("§aClick to select!");
	        	}

	        } else {
	        	dioriteMeta.setDisplayName("§cDiorite Capsule");
	        	dioriteLore.add("§eBuy this capsule for: §64000 Coins");
	        }
	        dioriteMeta.setLore(dioriteLore);
	        diorite.setItemMeta(dioriteMeta);
	        s(30,diorite);
	        
	        ItemStack andesite = new ItemStack(Material.STONE,1,(short)6); 
	        ItemMeta andesiteMeta =  andesite.getItemMeta();
	        List<String> andesiteLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.andesite")) {
	        	andesiteMeta.setDisplayName("§7Andesite Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("andesite")) {
	        		andesiteLore.add("§aSelected!");
	        		andesiteMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		andesiteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		andesiteLore.add("§aClick to select!");
	        	}

	        } else {
	        	andesiteMeta.setDisplayName("§cAndesite Capsule");
	        	andesiteLore.add("§eBuy this capsule for: §64000 Coins");
	        }
	        andesiteMeta.setLore(andesiteLore);
	        andesite.setItemMeta(andesiteMeta);
	        s(31,andesite);
	        
	        
	        ItemStack granite = new ItemStack(Material.STONE,1,(short)2); 
	        ItemMeta graniteMeta =  granite.getItemMeta();
	        List<String> graniteLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.granite")) {
	        	graniteMeta.setDisplayName("§6Granite Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("granite")) {
	        		graniteLore.add("§aSelected!");
	        		graniteMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		graniteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		graniteLore.add("§aClick to select!");
	        	}

	        } else {
	        	graniteMeta.setDisplayName("§cGranite Capsule");
	        	graniteLore.add("§eBuy this capsule for: §64000 Coins");
	        }
	        graniteMeta.setLore(graniteLore);
	        granite.setItemMeta(graniteMeta);
	        s(32,granite);
	        
	        
	        ItemStack libraries = new ItemStack(Material.BOOKSHELF); 
	        ItemMeta librariesMeta =  libraries.getItemMeta();
	        List<String> librariesLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.libraries")) {
	        	librariesMeta.setDisplayName("§6Libraries Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("libraries")) {
	        		librariesLore.add("§aSelected!");
	        		librariesMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		librariesMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		librariesLore.add("§aClick to select!");
	        	}

	        } else {
	        	librariesMeta.setDisplayName("§cLibreries Capsule");
	        	librariesLore.add("§eBuy this capsule for: §64500 Coins");
	        }
	        librariesMeta.setLore(librariesLore);
	        libraries.setItemMeta(librariesMeta);
	        s(33,libraries);
	        
	        
	        ItemStack ice = new ItemStack(Material.ICE); 
	        ItemMeta iceMeta =  ice.getItemMeta();
	        List<String> iceLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.ice")) {
	        	iceMeta.setDisplayName("§bIce Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("ice")) {
	        		iceLore.add("§aSelected!");
	        		iceMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		iceMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		iceLore.add("§aClick to select!");
	        	}

	        } else {
	        	iceMeta.setDisplayName("§cIce Capsule");
	        	iceLore.add("§eBuy this capsule for: §65000 Coins");
	        }
	        iceMeta.setLore(iceLore);
	        ice.setItemMeta(iceMeta);
	        s(34,ice);
	        

	        ItemStack quartz = new ItemStack(Material.QUARTZ_BLOCK); 
	        ItemMeta quartzMeta =  quartz.getItemMeta();
	        List<String> quartzLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.quartz")) {
	        	quartzMeta.setDisplayName("§fQuartz Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("quartz")) {
	        		quartzLore.add("§aSelected!");
	        		quartzMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		quartzMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		quartzLore.add("§aClick to select!");
	        	}

	        } else {
	        	quartzMeta.setDisplayName("§cQuartz Capsule");
	        	quartzLore.add("§eBuy this capsule for: §65000 Coins");
	        }
	        quartzMeta.setLore(quartzLore);
	        quartz.setItemMeta(quartzMeta);
	        s(35,quartz);
	        
	        ItemStack jail = new ItemStack(Material.IRON_FENCE); 
	        ItemMeta jailMeta =  jail.getItemMeta();
	        List<String> jailLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.jail")) {
	        	jailMeta.setDisplayName("§7Jail Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("jail")) {
	        		jailLore.add("§aSelected!");
	        		jailMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		jailMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		jailLore.add("§aClick to select!");
	        	}

	        } else {
	        	jailMeta.setDisplayName("§cJail Capsule");
	        	jailLore.add("§eBuy this capsule for: §65000 Coins");
	        }
	        jailMeta.setLore(jailLore);
	        jail.setItemMeta(jailMeta);
	        s(36,jail);
	        
	        ItemStack slabv2 = new ItemStack(Material.PURPUR_SLAB); 
	        ItemMeta slabv2Meta =  slabv2.getItemMeta();
	        List<String> slabv2Lore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.slabv2")) {
	        	slabv2Meta.setDisplayName("§7SlabV2 Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("slabv2")) {
	        		slabv2Lore.add("§aSelected!");
	        		slabv2Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		slabv2Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		slabv2Lore.add("§aClick to select!");
	        	}

	        } else {
	        	slabv2Meta.setDisplayName("§cSlabV2 Capsule");
	        	if (p.hasPermission("splindux.vip")) {
	        	slabv2Lore.add("§eBuy this capsule for: §65000 Coins");
	        } else {
	        	slabv2Lore.add("§cYou need to be atleast §a[VIP] §cto buy this capsule.");
	        }
	        	}
	        slabv2Meta.setLore(slabv2Lore);
	        slabv2.setItemMeta(slabv2Meta);
	        s(37,slabv2);
	        
	        
	        
	        ItemStack nether_fence = new ItemStack(Material.NETHER_FENCE); 
	        ItemMeta nether_fenceMeta =  nether_fence.getItemMeta();
	        List<String> nether_fenceLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.nether_fence")) {
	        	nether_fenceMeta.setDisplayName("§4Nether Fence Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("nether_fence")) {
	        		nether_fenceLore.add("§aSelected!");
	        		nether_fenceMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		nether_fenceMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		nether_fenceLore.add("§aClick to select!");
	        	}

	        } else {
	        	nether_fenceMeta.setDisplayName("§cNether Fence Capsule");
	        	if (p.hasPermission("splindux.vip")) {
	        		nether_fenceLore.add("§eBuy this capsule for: §65000 Coins");
		        } else {
		        	nether_fenceLore.add("§cYou need to be atleast §a[VIP] §cto buy this capsule.");
		        }
	        }
	        nether_fenceMeta.setLore(nether_fenceLore);
	        nether_fence.setItemMeta(nether_fenceMeta);
	        s(38,nether_fence);
	        
	        
	        ItemStack chess = Main.getSkull("http://textures.minecraft.net/texture/94094effee4ba2ab1c2fc6c8ed1c4690fba19c86617e9227db1f58d8dd5d");
	        ItemMeta chessMeta =  chess.getItemMeta();
	        List<String> chessLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.chess")) {
	        	chessMeta.setDisplayName("§fC§8h§fe§8s§fs §8C§fa§8p§fs§8u§fl§8e");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("chess")) {
	        		chessLore.add("§aSelected!");
	        		chessMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		chessMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		chessLore.add("§aClick to select!");
	        	}

	        } else {
	        	chessMeta.setDisplayName("§cChess Capsule");
	        	if (p.hasPermission("splindux.vip")) {
	        		chessLore.add("§eBuy this capsule for: §65000 Coins");
		        } else {
		        	chessLore.add("§cYou need to be atleast §a[VIP] §cto buy this capsule.");
		        }
	        }
	        chessMeta.setLore(chessLore);
	        chess.setItemMeta(chessMeta);
	        s(39,chess);
	        
	        ItemStack mushroom_red = new ItemStack(Material.HUGE_MUSHROOM_2); 
	        ItemMeta mushroom_redMeta =  mushroom_red.getItemMeta();
	        List<String> mushroom_redLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.mushroom_red")) {
	        	mushroom_redMeta.setDisplayName("§cRed Mushroom Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("mushroom_red")) {
	        		mushroom_redLore.add("§aSelected!");
	        		mushroom_redMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		mushroom_redMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		mushroom_redLore.add("§aClick to select!");
	        	}

	        } else {
	        	mushroom_redMeta.setDisplayName("§cRed Mushroom Capsule");
	        	mushroom_redLore.add("§eBuy this capsule for: §66000 Coins");
	        }
	        mushroom_redMeta.setLore(mushroom_redLore);
	        mushroom_red.setItemMeta(mushroom_redMeta);
	        s(40,mushroom_red);
	        
	        
	        ItemStack mushroom_brown = new ItemStack(Material.HUGE_MUSHROOM_1); 
	        ItemMeta mushroom_brownMeta =  mushroom_brown.getItemMeta();
	        List<String> mushroom_brownLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.mushroom_brown")) {
	        	mushroom_brownMeta.setDisplayName("§6Brown Mushroom Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("mushroom_brown")) {
	        		mushroom_brownLore.add("§aSelected!");
	        		mushroom_brownMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		mushroom_brownMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		mushroom_brownLore.add("§aClick to select!");
	        	}

	        } else {
	        	mushroom_brownMeta.setDisplayName("§cBrown Mushroom Capsule");
	        	mushroom_brownLore.add("§eBuy this capsule for: §66000 Coins");
	        }
	        mushroom_brownMeta.setLore(mushroom_brownLore);
	        mushroom_brown.setItemMeta(mushroom_brownMeta);
	        s(41,mushroom_brown);
	        
	        
	        
	        
	        
	        ItemStack slimeblock = new ItemStack(Material.SLIME_BLOCK); 
	        ItemMeta slimeblockMeta =  slimeblock.getItemMeta();
	        List<String> slimeblockLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.slimeblock")) {
	        	slimeblockMeta.setDisplayName("§aSlime Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("slimeblock")) {
	        		slimeblockLore.add("§aSelected!");
	        		slimeblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		slimeblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		slimeblockLore.add("§aClick to select!");
	        	}

	        } else {
	        	slimeblockMeta.setDisplayName("§cSlime Capsule");
	        	slimeblockLore.add("§eBuy this capsule for: §66000 Coins");
	        }
	        slimeblockMeta.setLore(slimeblockLore);
	        slimeblock.setItemMeta(slimeblockMeta);
	        s(42,slimeblock);
	        
	        
	        ItemStack glowstone = new ItemStack(Material.GLOWSTONE); 
	        ItemMeta glowstoneMeta =  glowstone.getItemMeta();
	        List<String> glowstoneLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glowstone")) {
	        	glowstoneMeta.setDisplayName("§eGlowstone Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glowstone")) {
	        		glowstoneLore.add("§aSelected!");
	        		glowstoneMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glowstoneMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glowstoneLore.add("§aClick to select!");
	        	}

	        } else {
	        	glowstoneMeta.setDisplayName("§cGlowstone Capsule");
	        	glowstoneLore.add("§eBuy this capsule for: §66000 Coins");
	        }
	        glowstoneMeta.setLore(glowstoneLore);
	        glowstone.setItemMeta(glowstoneMeta);
	        s(43,glowstone);
	        
	        
	        
	        ItemStack oceano = new ItemStack(Material.PRISMARINE); 
	        ItemMeta oceanoMeta =  oceano.getItemMeta();
	        List<String> oceanoLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.prismarine")) {
	        	oceanoMeta.setDisplayName("§bPrismarine Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("prismarine")) {
	        		oceanoLore.add("§aSelected!");
	        		oceanoMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		oceanoMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		oceanoLore.add("§aClick to select!");
	        	}

	        } else {
	        	oceanoMeta.setDisplayName("§cPrismarine Capsule");
	        	oceanoLore.add("§eBuy this capsule for: §66000 Coins");
	        }
	        oceanoMeta.setLore(oceanoLore);
	        oceano.setItemMeta(oceanoMeta);
	        s(44,oceano);
	        
	        
	        ItemStack redsandstone = new ItemStack(Material.RED_SANDSTONE); 
	        ItemMeta redsandstoneMeta =  redsandstone.getItemMeta();
	        List<String> redsandstoneLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.redsandstone")) {
	        	redsandstoneMeta.setDisplayName("§6Red Sandstone Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("redsandstone")) {
	        		redsandstoneLore.add("§aSelected!");
	        		redsandstoneMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		redsandstoneMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		redsandstoneLore.add("§aClick to select!");
	        	}

	        } else {
	        	redsandstoneMeta.setDisplayName("§cRed Sandstone Capsule");
	        	if (p.hasPermission("splindux.vip")) {
	        		redsandstoneLore.add("§eBuy this capsule for: §66000 Coins");
		        } else {
		        	redsandstoneLore.add("§cYou need to be atleast §a[VIP] §cto buy this capsule.");
		        }
	        }
	        
	        redsandstoneMeta.setLore(redsandstoneLore);
	        redsandstone.setItemMeta(redsandstoneMeta);
	        s(45,redsandstone);
	        
	        
	        ItemStack sandstone = new ItemStack(Material.SANDSTONE); 
	        ItemMeta sandstoneMeta =  sandstone.getItemMeta();
	        List<String> sandstoneLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.sandstone")) {
	        	sandstoneMeta.setDisplayName("§eSandstone Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("sandstone")) {
	        		sandstoneLore.add("§aSelected!");
	        		sandstoneMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		sandstoneMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		sandstoneLore.add("§aClick to select!");
	        	}

	        } else {
	        	sandstoneMeta.setDisplayName("§cSandstone Capsule");
	        	if (p.hasPermission("splindux.vip")) {
	        		sandstoneLore.add("§eBuy this capsule for: §66000 Coins");
		        } else {
		        	sandstoneLore.add("§cYou need to be atleast §a[VIP] §cto buy this capsule.");
		        }
	        }
	        
	        sandstoneMeta.setLore(sandstoneLore);
	        sandstone.setItemMeta(sandstoneMeta);
	        s(46,sandstone);
	        
	        
	        ItemStack tnt = new ItemStack(Material.TNT); 
	        ItemMeta tntMeta =  tnt.getItemMeta();
	        List<String> tntLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.tnt")) {
	        	tntMeta.setDisplayName("§cTNT Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("tnt")) {
	        		tntLore.add("§aSelected!");
	        		tntMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		tntMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		tntLore.add("§aClick to select!");
	        	}

	        } else {
	        	tntMeta.setDisplayName("§cTNT Capsule");
	        	tntLore.add("§eBuy this capsule for: §67000 Coins");
	        }
	        
	        tntMeta.setLore(tntLore);
	        tnt.setItemMeta(tntMeta);
	        s(47,tnt);
	        
	        ItemStack nether = new ItemStack(Material.MAGMA); 
	        ItemMeta netherMeta =  nether.getItemMeta();
	        List<String> netherLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.magma")) {
	        	netherMeta.setDisplayName("§4Magma Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("magma")) {
	        		netherLore.add("§aSelected!");
	        		netherMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		netherMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		netherLore.add("§aClick to select!");
	        	}

	        } else {
	        	netherMeta.setDisplayName("§cMagma Capsule");
	        	netherLore.add("§eBuy this capsule for: §67500 Coins");
	        }
	        
	        netherMeta.setLore(netherLore);
	        nether.setItemMeta(netherMeta);
	        s(48,nether);
	        
	        
	        ItemStack snowgolem = new ItemStack(Material.PUMPKIN); 
	        ItemMeta snowgolemMeta =  snowgolem.getItemMeta();
	        List<String> snowgolemLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.snowgolem")) {
	        	snowgolemMeta.setDisplayName("§fSnowGolem Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("snowgolem")) {
	        		snowgolemLore.add("§aSelected!");
	        		snowgolemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		snowgolemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		snowgolemLore.add("§aClick to select!");
	        	}

	        } else {
	        	snowgolemMeta.setDisplayName("§cSnowGolem Capsule");
	        	if (p.hasPermission("splindux.vip")) {
	        		snowgolemLore.add("§eBuy this capsule for: §67500 Coins");
	        } else {
	        	snowgolemLore.add("§cYou need to be atleast §a[VIP] §cto buy this capsule.");
	        }
	        	}
	        
	        snowgolemMeta.setLore(snowgolemLore);
	        snowgolem.setItemMeta(snowgolemMeta);
	        s(49,snowgolem);
	        
	        ItemStack cactus = new ItemStack(Material.CACTUS); 
	        ItemMeta cactusMeta =  cactus.getItemMeta();
	        List<String> cactusLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.cactus")) {
	        	cactusMeta.setDisplayName("§2Cactus Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("cactus")) {
	        		cactusLore.add("§aSelected!");
	        		cactusMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		cactusMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		cactusLore.add("§aClick to select!");
	        	}

	        } else {
	        	cactusMeta.setDisplayName("§cCactus Capsule");
	        	if (p.hasPermission("splindux.vip")) {
	        		cactusLore.add("§eBuy this capsule for: §67500 Coins");
	        } else {
	        	cactusLore.add("§cYou need to be atleast §a[VIP] §cto buy this capsule.");
	        }
	        	}
	        
	        cactusMeta.setLore(cactusLore);
	        cactus.setItemMeta(cactusMeta);
	        s(50,cactus);
	        
	        
	        ItemStack portal = new ItemStack(Material.OBSIDIAN); 
	        ItemMeta portalMeta =  portal.getItemMeta();
	        List<String> portalLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.portal")) {
	        	portalMeta.setDisplayName("§5Portal Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("portal")) {
	        		portalLore.add("§aSelected!");
	        		portalMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		portalMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		portalLore.add("§aClick to select!");
	        	}

	        } else {
	        	portalMeta.setDisplayName("§cPortal Capsule");
	        	portalLore.add("§eBuy this capsule for: §68000 Coins");
	        }
	        
	        portalMeta.setLore(portalLore);
	        portal.setItemMeta(portalMeta);
	        s(51,portal);
	        
	        ItemStack packedice = new ItemStack(Material.PACKED_ICE); 
	        ItemMeta packediceMeta =  packedice.getItemMeta();
	        List<String> packediceLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.packedice")) {
	        	packediceMeta.setDisplayName("§bPacked Ice Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("packedice")) {
	        		packediceLore.add("§aSelected!");
	        		packediceMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		packediceMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		packediceLore.add("§aClick to select!");
	        	}

	        } else {
	        	packediceMeta.setDisplayName("§cPacked Ice Capsule");
	        	packediceLore.add("§eBuy this capsule for: §68000 Coins");
	        }
	        
	        packediceMeta.setLore(packediceLore);
	        packedice.setItemMeta(packediceMeta);
	        s(52,packedice);
	        
	        
	        ItemStack sponge = new ItemStack(Material.SPONGE); 
	        ItemMeta spongeMeta =  sponge.getItemMeta();
	        List<String> spongeLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.sponge")) {
	        	spongeMeta.setDisplayName("§eSponge Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("sponge")) {
	        		spongeLore.add("§aSelected!");
	        		spongeMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		spongeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		spongeLore.add("§aClick to select!");
	        	}

	        } else {
	        	spongeMeta.setDisplayName("§cSponge Capsule");
	        	spongeLore.add("§eBuy this capsule for: §69000 Coins");
	        }
	        
	        spongeMeta.setLore(spongeLore);
	        sponge.setItemMeta(spongeMeta);
	        s(53,sponge);
	        
	       
	        
		s(4, new ItemBuilder(Material.THIN_GLASS).setTitle("§cDefault").
				build());
		
		s(9, glass_white);
		s(10, glass_orange);
		s(11, glass_magenta);
		s(12, glass_lightblue);
		s(13, glass_yellow);
		s(14, glass_lime);
		s(15, glass_pink);
		s(16, glass_gray);
		s(17, glass_lightgray);
		s(18, glass_cyan);
		s(19, glass_purple);
		s(20, glass_blue);
		s(21, glass_brown);
		s(22, glass_green);
		s(23, glass_red);
		s(24, glass_black);
		s(8, new ItemBuilder(Material.ARROW).setTitle("§ePage 2").build());
	} else {
		s(0, new ItemBuilder(Material.ARROW).setTitle("§ePage 1").build());
		s(4, new ItemBuilder(Material.THIN_GLASS).setTitle("§cDefault").
				build());
		
		
		 ItemStack bedrock = new ItemStack(Material.BEDROCK); 
	        ItemMeta bedrockMeta =  bedrock.getItemMeta();
	        List<String> bedrockLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.bedrock")) {
	        	bedrockMeta.setDisplayName("§8Bedrock Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("bedrock")) {
	        		bedrockLore.add("§aSelected!");
	        		bedrockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		bedrockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		bedrockLore.add("§aClick to select!");
	        	}

	        } else {
	        	bedrockMeta.setDisplayName("§cBedrock Capsule");
	        	bedrockLore.add("§eBuy this capsule for: §610000 Coins");
	        }
	        
	        bedrockMeta.setLore(bedrockLore);
	        bedrock.setItemMeta(bedrockMeta);
	        s(9,bedrock);
	        
	        ItemStack invisible = new ItemStack(Material.BARRIER); 
	        ItemMeta invisibleMeta =  invisible.getItemMeta();
	        List<String> invisibleLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.invisible")) {
	        	invisibleMeta.setDisplayName("§7Invisible Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("invisible")) {
	        		invisibleLore.add("§aSelected!");
	        		invisibleMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		invisibleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		invisibleLore.add("§aClick to select!");
	        	}

	        } else {
	        	invisibleMeta.setDisplayName("§cInvisible Capsule");
	        	invisibleLore.add("§eBuy this capsule for: §610000 Coins");
	        }
	        
	        invisibleMeta.setLore(invisibleLore);
	        invisible.setItemMeta(invisibleMeta);
	        s(10,invisible);
	        
		
		
		
		
		ItemStack beach = Main.getSkull("http://textures.minecraft.net/texture/5a5ab05ea254c32e3c48f3fdcf9fd9d77d3cba04e6b5ec2e68b3cbdcfac3fd"); 
        ItemMeta beachMeta =  beach.getItemMeta();
        List<String> beachLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.beach")) {
        	beachMeta.setDisplayName("§eBeach Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("beach")) {
        		beachLore.add("§aSelected!");
        		beachMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		beachMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		beachLore.add("§aClick to select!");
        	}

        } else {
        	beachMeta.setDisplayName("§cBeach Capsule");
        	if (p.hasPermission("splindux.vip")) {
        		beachLore.add("§eBuy this capsule for: §610000 Coins");
        } else {
        	beachLore.add("§cYou need to be atleast §a[VIP] §cto buy this capsule.");
        }
        	}
        
        beachMeta.setLore(beachLore);
        beach.setItemMeta(beachMeta);
        s(11,beach);
		
        
        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta anvilMeta =  anvil.getItemMeta();
        List<String> anvilLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.anvil")) {
        	anvilMeta.setDisplayName("§8Anvil Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("anvil")) {
        		anvilLore.add("§aSelected!");
        		anvilMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		anvilMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		anvilLore.add("§aClick to select!");
        	}

        } else {
        	anvilMeta.setDisplayName("§cAnvil Capsule");
        	if (p.hasPermission("splindux.vip")) {
        		anvilLore.add("§eBuy this capsule for: §610000 Coins");
        } else {
        	anvilLore.add("§cYou need to be atleast §a[VIP] §cto buy this capsule.");
        }
        	}
        
        anvilMeta.setLore(anvilLore);
        anvil.setItemMeta(anvilMeta);
        s(12,anvil);
        
        
        ItemStack web = new ItemStack(Material.WEB);
        ItemMeta webMeta =  web.getItemMeta();
        List<String> webLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.web")) {
        	webMeta.setDisplayName("§fWeb Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("web")) {
        		webLore.add("§aSelected!");
        		webMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		webMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		webLore.add("§aClick to select!");
        	}

        } else {
        	webMeta.setDisplayName("§cWeb Capsule");
        	if (p.hasPermission("splindux.epic")) {
        		webLore.add("§eBuy this capsule for: §610000 Coins");
        } else {
        	webLore.add("§cYou need to be atleast §9[Epic] §cto buy this capsule.");
        }
        	}
        
        webMeta.setLore(webLore);
        web.setItemMeta(webMeta);
        s(13,web);
        
        ItemStack jukebox = new ItemStack(Material.JUKEBOX);
        ItemMeta jukeboxMeta =  jukebox.getItemMeta();
        List<String> jukeboxLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.jukebox")) {
        	jukeboxMeta.setDisplayName("§6Jukebox Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("jukebox")) {
        		jukeboxLore.add("§aSelected!");
        		jukeboxMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		jukeboxMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		jukeboxLore.add("§aClick to select!");
        	}

        } else {
        	jukeboxMeta.setDisplayName("§6Jukebox Capsule");
        	if (p.hasPermission("splindux.epic")) {
        		jukeboxLore.add("§eBuy this capsule for: §610000 Coins");
        } else {
        	jukeboxLore.add("§cYou need to be atleast §9[Epic] §cto buy this capsule.");
        }
        	}
        
        jukeboxMeta.setLore(jukeboxLore);
        jukebox.setItemMeta(jukeboxMeta);
        s(14,jukebox);
        
        ItemStack end = new ItemStack(Material.ENDER_STONE);
        ItemMeta endMeta =  end.getItemMeta();
        List<String> endLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.end")) {
        	endMeta.setDisplayName("§5End §eCapsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("end")) {
        		endLore.add("§aSelected!");
        		endMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		endMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		endLore.add("§aClick to select!");
        	}

        } else {
        	endMeta.setDisplayName("§cEnd Capsule");
        	if (p.hasPermission("splindux.epic")) {
        		endLore.add("§eBuy this capsule for: §612500 Coins");
        } else {
        	endLore.add("§cYou need to be atleast §9[Epic] §cto buy this capsule.");
        }
        	}
        
        endMeta.setLore(endLore);
        end.setItemMeta(endMeta);
        s(15,end);
        
        
        ItemStack tank = new ItemStack(Material.WATER_BUCKET);
        ItemMeta tankMeta =  tank.getItemMeta();
        List<String> tankLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.tank")) {
        	tankMeta.setDisplayName("§fTank §9Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("tank")) {
        		tankLore.add("§aSelected!");
        		tankMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		tankMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		tankLore.add("§aClick to select!");
        	}

        } else {
        	tankMeta.setDisplayName("§cTank Capsule");
        	if (p.hasPermission("splindux.epic")) {
        		tankLore.add("§eBuy this capsule for: §615000 Coins");
        } else {
        	tankLore.add("§cYou need to be atleast §9[Epic] §cto buy this capsule.");
        }
        	}
        
        tankMeta.setLore(tankLore);
        tank.setItemMeta(tankMeta);
        s(16,tank);
        
        ItemStack beacon = new ItemStack(Material.BEACON);
        ItemMeta beaconMeta =  beacon.getItemMeta();
        List<String> beaconLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.beacon")) {
        	beaconMeta.setDisplayName("§bBeacon Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("beacon")) {
        		beaconLore.add("§aSelected!");
        		beaconMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		beaconMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		beaconLore.add("§aClick to select!");
        	}

        } else {
        	beaconMeta.setDisplayName("§cBeacon Capsule");
        	if (p.hasPermission("splindux.extreme")) {
        		beaconLore.add("§eBuy this capsule for: §625000 Coins");
        } else {
        	beaconLore.add("§cYou need to be §5[Extreme] §cto buy this capsule.");
        }
        	}
        
        beaconMeta.setLore(beaconLore);
        beacon.setItemMeta(beaconMeta);
        s(17,beacon);
		
        
        
        ItemStack goldblock = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta goldblockMeta =  goldblock.getItemMeta();
        List<String> goldblockLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.goldblock")) {
        	goldblockMeta.setDisplayName("§e§lGold Block Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("goldblock")) {
        		goldblockLore.add("§aSelected!");
        		goldblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		goldblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		goldblockLore.add("§aClick to select!");
        	}

        } else {
        	goldblockMeta.setDisplayName("§cGold Block Capsule");
        		goldblockLore.add("§eBuy this capsule for: §650000 Coins");
        
        	}
        
        goldblockMeta.setLore(goldblockLore);
        goldblock.setItemMeta(goldblockMeta);
        s(18,goldblock);
        
        ItemStack lapisblock = new ItemStack(Material.LAPIS_BLOCK);
        ItemMeta lapisblockMeta =  lapisblock.getItemMeta();
        List<String> lapisblockLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.lapisblock")) {
        	lapisblockMeta.setDisplayName("§1§lLapis Block Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("lapisblock")) {
        		lapisblockLore.add("§aSelected!");
        		lapisblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		lapisblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		lapisblockLore.add("§aClick to select!");
        	}

        } else {
        	lapisblockMeta.setDisplayName("§cLapis Block Capsule");
        		lapisblockLore.add("§eBuy this capsule for: §650000 Coins");
        
        	}
        
        lapisblockMeta.setLore(lapisblockLore);
        lapisblock.setItemMeta(lapisblockMeta);
        s(19,lapisblock);
        
        ItemStack redstoneblock = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta redstoneblockMeta =  redstoneblock.getItemMeta();
        List<String> redstoneblockLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.redstoneblock")) {
        	redstoneblockMeta.setDisplayName("§c§lRedstone Block Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("redstoneblock")) {
        		redstoneblockLore.add("§aSelected!");
        		redstoneblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		redstoneblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		redstoneblockLore.add("§aClick to select!");
        	}

        } else {
        	redstoneblockMeta.setDisplayName("§cRedstone Block Capsule");
        		redstoneblockLore.add("§eBuy this capsule for: §650000 Coins");
        
        	}
        
        redstoneblockMeta.setLore(redstoneblockLore);
        redstoneblock.setItemMeta(redstoneblockMeta);
        s(20,redstoneblock);
        
        ItemStack diamondblock = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta diamondblockMeta =  diamondblock.getItemMeta();
        List<String> diamondblockLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.diamondblock")) {
        	diamondblockMeta.setDisplayName("§b§lDiamond Block Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("diamondblock")) {
        		diamondblockLore.add("§aSelected!");
        		diamondblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		diamondblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		diamondblockLore.add("§aClick to select!");
        	}

        } else {
        	diamondblockMeta.setDisplayName("§cDiamond Block Capsule");
        		diamondblockLore.add("§eBuy this capsule for: §6100000 Coins");
        		diamondblockLore.add("§7You need §cRedstone Block Capsule§7,");
        		diamondblockLore.add("§1Lapis Block Capsule §7 and §eGold Block Capsule");
        		diamondblockLore.add("§7first to purchase this capsule");
        	}
        
        diamondblockMeta.setLore(diamondblockLore);
        diamondblock.setItemMeta(diamondblockMeta);
        s(21,diamondblock);
        
        ItemStack emeraldblock = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta emeraldblockMeta =  emeraldblock.getItemMeta();
        List<String> emeraldblockLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.emeraldblock")) {
        	emeraldblockMeta.setDisplayName("§a§lEmerald Block Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("emeraldblock")) {
        		emeraldblockLore.add("§aSelected!");
        		emeraldblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		emeraldblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		emeraldblockLore.add("§aClick to select!");
        	}

        } else {
        	emeraldblockMeta.setDisplayName("§cEmerald Block Capsule");
        		emeraldblockLore.add("§eBuy this capsule for: §6200000 Coins");
        		emeraldblockLore.add("§7You need §bDiamond Block Capsule");
        		emeraldblockLore.add("§7first to purchase this capsule");
        	}
        
        emeraldblockMeta.setLore(emeraldblockLore);
        emeraldblock.setItemMeta(emeraldblockMeta);
        s(22,emeraldblock);
        
        ItemStack snow = new ItemStack(Material.SNOW_BLOCK);
        ItemMeta snowMeta =  snow.getItemMeta();
        List<String> snowLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.snow")) {
        	snowMeta.setDisplayName("§f§lSnow Capsule");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("snow")) {
        		snowLore.add("§aSelected!");
        		snowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		snowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		snowLore.add("§aClick to select!");
        	}

        } else {
        	snowMeta.setDisplayName("§cSnow Capsule");
        		snowLore.add("§eBuy this capsule for: §6500000 Coins");
        	}
        
        snowMeta.setLore(snowLore);
        snow.setItemMeta(snowMeta);
        s(23,snow);
        
        
	}
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		
		if (slot==4) {
			new CapsuleMenu(p).o(p);
			CapsuleManager.setSelectedCapsule(p, "default");
			p.sendMessage("§aCapsule set to: §7Default Capsule");
		}
		
		if (slot == 9) {
			if (page.get(p)==1) {
			if (p.hasPermission("splindux.capsules.glass_white")) {
				CapsuleManager.setSelectedCapsule(p, "glass_white");
				new CapsuleMenu(p).o(p);
				p.sendMessage("§aCapsule set to: §fWhite Glass Capsule");
			} else {
				p.closeInventory();
				PlayerManager pm = EconomyManager.getPlayerManager(p);
				if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
					EconomyManager.getManager().removeMysteryDust(pm, 2000);
					CapsuleManager.setSelectedCapsule(p, "glass_white");
					PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_white");
					p.sendMessage("§aYou have bought §fWhite Glass Capsule §afor §62000 Coins§a!");
				} else {
					p.sendMessage("§cYou do not have enough Coins to buy this.");
				}
			}
		} else {
			if (p.hasPermission("splindux.capsules.bedrock")) {
				CapsuleManager.setSelectedCapsule(p, "bedrock");
				p.sendMessage("§aCapsule set to: §8Bedrock Capsule");
				new CapsuleMenu(p).o(p);
			} else {
				p.closeInventory();
				PlayerManager pm = EconomyManager.getPlayerManager(p);
				if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
					EconomyManager.getManager().removeMysteryDust(pm, 10000);
					CapsuleManager.setSelectedCapsule(p, "bedrock");
					PermissionsEx.getUser(p).addPermission("splindux.capsules.bedrock");
					p.sendMessage("§aYou have bought §8Bedrock Capsule §afor §610000 Coins§a!");
				} else {
					p.sendMessage("§cYou do not have enough Coins to buy this.");
				}
			
			}
		}
		}
		
		if (slot == 10) {
			if (page.get(p)==1) {
			if (p.hasPermission("splindux.capsules.glass_orange")) {
				CapsuleManager.setSelectedCapsule(p, "glass_orange");
				p.sendMessage("§aCapsule set to: §6Orange Glass Capsule");
				new CapsuleMenu(p).o(p);
			} else {
				p.closeInventory();
				PlayerManager pm = EconomyManager.getPlayerManager(p);
				if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
					EconomyManager.getManager().removeMysteryDust(pm, 2000);
					CapsuleManager.setSelectedCapsule(p, "glass_orange");
					PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_orange");
					p.sendMessage("§aYou have bought §6Orange Glass Capsule §afor §62000 Coins§a!");
				} else {
					p.sendMessage("§cYou do not have enough Coins to buy this.");
				}
			}
		} else {
			if (p.hasPermission("splindux.capsules.invisible")) {
				CapsuleManager.setSelectedCapsule(p, "invisible");
				p.sendMessage("§aCapsule set to: §7Invisible Capsule");
				new CapsuleMenu(p).o(p);
			} else {
				p.closeInventory();
				PlayerManager pm = EconomyManager.getPlayerManager(p);
				if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
					EconomyManager.getManager().removeMysteryDust(pm, 10000);
					CapsuleManager.setSelectedCapsule(p, "invisible");
					PermissionsEx.getUser(p).addPermission("splindux.capsules.invisible");
					p.sendMessage("§aYou have bought §7Invisible Capsule §afor §610000 Coins§a!");
				} else {
					p.sendMessage("§cYou do not have enough Coins to buy this.");
				}
			}
		}
		}
			if (slot == 11) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_magenta")) {
						CapsuleManager.setSelectedCapsule(p, "glass_magenta");
						p.sendMessage("§aCapsule set to: §dMagenta Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_magenta");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_magenta");
							p.sendMessage("§aYou have bought §dMagenta Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.beach")) {
					CapsuleManager.setSelectedCapsule(p, "beach");
					p.sendMessage("§aCapsule set to: §eBeach Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.vip")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
						EconomyManager.getManager().removeMysteryDust(pm, 10000);
						CapsuleManager.setSelectedCapsule(p, "beach");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.beach");
						p.sendMessage("§aYou have bought §eBeach Capsule §afor §610000 Coins§a!");
					} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
				} else {
					p.sendMessage("§cYou need to be atleast §a§l[VIP] §cto buy this capsule. "
							+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
				}
			
			}
		}
		
			
			if (slot == 12) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_lightblue")) {
						CapsuleManager.setSelectedCapsule(p, "glass_lightblue");
						p.sendMessage("§aCapsule set to: §bLight Blue Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_lightblue");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_lightblue");
							p.sendMessage("§aYou have bought §bLight Blue Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.anvil")) {
					CapsuleManager.setSelectedCapsule(p, "anvil");
					p.sendMessage("§aCapsule set to: §8Anvil Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.vip")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
						EconomyManager.getManager().removeMysteryDust(pm, 10000);
						CapsuleManager.setSelectedCapsule(p, "anvil");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.anvil");
						p.sendMessage("§aYou have bought §8Anvil Capsule §afor §610000 Coins§a!");
					} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
				} else {
					p.sendMessage("§cYou need to be atleast §a§l[VIP] §cto buy this capsule. "
							+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
			}
				
			}
		}
			
		
			if (slot == 13) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_yellow")) {
						CapsuleManager.setSelectedCapsule(p, "glass_yellow");
						p.sendMessage("§aCapsule set to: §eYellow Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_yellow");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_yellow");
							p.sendMessage("§aYou have bought §eYellow Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.house")) {
					CapsuleManager.setSelectedCapsule(p, "web");
					p.sendMessage("§aCapsule set to: §fWeb Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.epic")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
						EconomyManager.getManager().removeMysteryDust(pm, 10000);
						CapsuleManager.setSelectedCapsule(p, "web");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.web");
						p.sendMessage("§aYou have bought §fWeb Capsule §afor §610000 Coins§a!");
					} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
				} else {
					p.sendMessage("§cYou need to be atleast §9§l[Epic] §cto buy this capsule. "
							+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
				}
			}
			}
		
		
			if (slot == 14) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_lime")) {
						CapsuleManager.setSelectedCapsule(p, "glass_lime");
						p.sendMessage("§aCapsule set to: §aLime Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_lime");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_lime");
							p.sendMessage("§aYou have bought §aLime Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.jukebox")) {
					CapsuleManager.setSelectedCapsule(p, "jukebox");
					p.sendMessage("§aCapsule set to: §6Jukebox Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.epic")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
						EconomyManager.getManager().removeMysteryDust(pm, 10000);
						CapsuleManager.setSelectedCapsule(p, "jukebox");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.jukebox");
						p.sendMessage("§aYou have bought §6Jukebox Capsule §afor §610000 Coins§a!");
					} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
				} else {
					p.sendMessage("§cYou need to be atleast §9§l[Epic] §cto buy this capsule. "
							+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
				
				}
			}
		}
			
			
			if (slot == 15) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_pink")) {
						CapsuleManager.setSelectedCapsule(p, "glass_pink");
						p.sendMessage("§aCapsule set to: §dPink Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_pink");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_pink");
							p.sendMessage("§aYou have bought §dPink Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.end")) {
					CapsuleManager.setSelectedCapsule(p, "end");
					p.sendMessage("§aCapsule set to: §5End §fCapsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.epic")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=12500) {
						EconomyManager.getManager().removeMysteryDust(pm, 12500);
						CapsuleManager.setSelectedCapsule(p, "end");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.jukebox");
						p.sendMessage("§aYou have bought §5End §fCapsule §afor §612500 Coins§a!");
					} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
				} else {
					p.sendMessage("§cYou need to be atleast §9§l[Epic] §cto buy this capsule. "
							+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
				}
			}
				
		}
			
			
			if (slot == 16) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_gray")) {
						CapsuleManager.setSelectedCapsule(p, "glass_gray");
						p.sendMessage("§aCapsule set to: §8Gray Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_gray");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_gray");
							p.sendMessage("§aYou have bought §8Gray Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.tank")) {
					CapsuleManager.setSelectedCapsule(p, "tank");
					p.sendMessage("§aCapsule set to: §fTank §9Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.epic")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=15000) {
						EconomyManager.getManager().removeMysteryDust(pm, 15000);
						CapsuleManager.setSelectedCapsule(p, "tank");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.tank");
						p.sendMessage("§aYou have bought §fTank §9Capsule §afor §615000 Coins§a!");
					} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
				} else {
					p.sendMessage("§cYou need to be atleast §9§l[Epic] §cto buy this capsule. "
							+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
			
				}
			}
				
				
		}
			
			
			
			
			if (slot == 17) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_lightgray")) {
						CapsuleManager.setSelectedCapsule(p, "glass_lightgray");
						p.sendMessage("§aCapsule set to: §7Light Gray Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_lightgray");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_lightgray");
							p.sendMessage("§aYou have bought §7Light Gray Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.beacon")) {
					CapsuleManager.setSelectedCapsule(p, "beacon");
					p.sendMessage("§aCapsule set to: §bBeacon Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.extreme")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=25000) {
						EconomyManager.getManager().removeMysteryDust(pm, 25000);
						CapsuleManager.setSelectedCapsule(p, "beacon");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.beacon");
						p.sendMessage("§aYou have bought §bBeacon Capsule §afor §625000 Coins§a!");
					} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
				} else {
					p.sendMessage("§cYou need to be §5§l[Extreme] §cto buy this capsule. "
							+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
				
				}
			}
				
				
		}
			
			
			if (slot == 18) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_cyan")) {
						CapsuleManager.setSelectedCapsule(p, "glass_cyan");
						p.sendMessage("§aCapsule set to: §3Cyan Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_cyan");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_cyan");
							p.sendMessage("§aYou have bought §3Cyan Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.goldblock")) {
					CapsuleManager.setSelectedCapsule(p, "goldblock");
					p.sendMessage("§aCapsule set to: §e§lGold Block Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=50000) {
						EconomyManager.getManager().removeMysteryDust(pm, 50000);
						CapsuleManager.setSelectedCapsule(p, "goldblock");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.goldblock");
						p.sendMessage("§aYou have bought §e§lGold Block Capsule §afor §650000 Coins§a!");
					} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
				
				}
			}
				
				
		}
			
			
			
			
			if (slot == 19) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_purple")) {
						CapsuleManager.setSelectedCapsule(p, "glass_purple");
						p.sendMessage("§aCapsule set to: §5Purple Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_purple");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_purple");
							p.sendMessage("§aYou have bought §5Purple Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.lapisblock")) {
					CapsuleManager.setSelectedCapsule(p, "lapisblock");
					p.sendMessage("§aCapsule set to: §1§lLapis Block Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=50000) {
						EconomyManager.getManager().removeMysteryDust(pm, 50000);
						CapsuleManager.setSelectedCapsule(p, "lapisblock");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.lapisblock");
						p.sendMessage("§aYou have bought §1§lLapis Block Capsule §afor §650000 Coins§a!");
					} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
					
				
				}
			}
				
				
		}
			
			
			if (slot == 20) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_blue")) {
						CapsuleManager.setSelectedCapsule(p, "glass_blue");
						p.sendMessage("§aCapsule set to: §1Blue Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_blue");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_blue");
							p.sendMessage("§aYou have bought §1Blue Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.redstoneblock")) {
					CapsuleManager.setSelectedCapsule(p, "redstoneblock");
					p.sendMessage("§aCapsule set to: §c§lRedstone Block Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=50000) {
						EconomyManager.getManager().removeMysteryDust(pm, 50000);
						CapsuleManager.setSelectedCapsule(p, "redstoneblock");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.redstoneblock");
						p.sendMessage("§aYou have bought §c§lRedstone Block Capsule §afor §650000 Coins§a!");
					} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
					
				
				}
			}
				
				
		}
			
			
			if (slot == 21) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_brown")) {
						CapsuleManager.setSelectedCapsule(p, "glass_brown");
						p.sendMessage("§aCapsule set to: §6Brown Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_brown");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_brown");
							p.sendMessage("§aYou have bought §6Brown Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.diamondblock")) {
					CapsuleManager.setSelectedCapsule(p, "diamondblock");
					p.sendMessage("§aCapsule set to: §b§lDiamond Block Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (p.hasPermission("splindux.capsules.redstoneblock") &&
							p.hasPermission("splindux.capsules.lapisblock")&&
							p.hasPermission("splindux.capsule.goldblock")) {
					if (EconomyManager.getManager().getMysteryDust(pm) >=50000) {
						EconomyManager.getManager().removeMysteryDust(pm, 50000);
						CapsuleManager.setSelectedCapsule(p, "diamondblock");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.diamondblock");
						p.sendMessage("§aYou have bought §b§lDiamond Block Capsule §afor §6100000 Coins§a!");
					}  else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
					} else {
						p.sendMessage("§cYou need to buy §eGold Block Capsule§c, §cRedstone Block Capsule §cand §1Lapis Block Capsule §cfirst to buy this capsule.");
					}
				
				}
			}
				
				
		}
			
			
			if (slot == 22) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_green")) {
						CapsuleManager.setSelectedCapsule(p, "glass_green");
						p.sendMessage("§aCapsule set to: §2Green Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_green");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_green");
							p.sendMessage("§aYou have bought §2Green Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.emeraldblock")) {
					CapsuleManager.setSelectedCapsule(p, "emeraldblock");
					p.sendMessage("§aCapsule set to: §a§lEmerald Block Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=50000) {
						if (p.hasPermission("splindux.capsules.diamondblock")) {
						EconomyManager.getManager().removeMysteryDust(pm, 50000);
						CapsuleManager.setSelectedCapsule(p, "emeraldblock");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.emeraldblock");
						p.sendMessage("§aYou have bought §a§lEmerald Block Capsule §afor §6200000 Coins§a!");
						} else {
							p.sendMessage("§cYou need to buy §bDiamond Block Capsule §cfirst to get this capsule.");
						}
						} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
				}
			}	
		}
			
			
			if (slot == 23) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_red")) {
						CapsuleManager.setSelectedCapsule(p, "glass_red");
						p.sendMessage("§aCapsule set to: §4Red Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_red");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_red");
							p.sendMessage("§aYou have bought §4Red Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.snow")) {
					CapsuleManager.setSelectedCapsule(p, "snow");
					p.sendMessage("§aCapsule set to: §f§lSnow Capsule");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=50000) {
						EconomyManager.getManager().removeMysteryDust(pm, 50000);
						CapsuleManager.setSelectedCapsule(p, "snow");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.snow");
						p.sendMessage("§aYou have bought §f§lSnow Capsule §afor §6500000 Coins§a!");
					} else {
						p.sendMessage("§cYou do not have enough Coins to buy this.");
					}
				}
			}	
		}
			
			
			if (slot == 24) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_black")) {
						CapsuleManager.setSelectedCapsule(p, "glass_black");
						p.sendMessage("§aCapsule set to: §8Black Glass Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_black");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_black");
							p.sendMessage("§aYou have bought §8Black Glass Capsule §afor §62000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			
			
			if (slot == 25) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.fence")) {
						CapsuleManager.setSelectedCapsule(p, "fence");
						p.sendMessage("§aCapsule set to: §eFence Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2500) {
							EconomyManager.getManager().removeMysteryDust(pm, 2500);
							CapsuleManager.setSelectedCapsule(p, "fence");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.fence");
							p.sendMessage("§aYou have bought §eFence Capsule §afor §62500 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			if (slot == 26) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.slab")) {
						CapsuleManager.setSelectedCapsule(p, "slab");
						p.sendMessage("§aCapsule set to: §7Slab Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2500) {
							EconomyManager.getManager().removeMysteryDust(pm, 2500);
							CapsuleManager.setSelectedCapsule(p, "slab");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.slab");
							p.sendMessage("§aYou have bought §7Slab Capsule §afor §62500 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			if (slot == 27) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.tree")) {
						CapsuleManager.setSelectedCapsule(p, "tree");
						p.sendMessage("§aCapsule set to: §aTree Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=3000) {
							EconomyManager.getManager().removeMysteryDust(pm, 3000);
							CapsuleManager.setSelectedCapsule(p, "tree");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.tree");
							p.sendMessage("§aYou have bought §aTree Capsule §afor §63000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			if (slot == 28) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.leaves")) {
						CapsuleManager.setSelectedCapsule(p, "leaves");
						p.sendMessage("§aCapsule set to: §2Leaves Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=3500) {
							EconomyManager.getManager().removeMysteryDust(pm, 3500);
							CapsuleManager.setSelectedCapsule(p, "leaves");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.leaves");
							p.sendMessage("§aYou have bought §2Leaves Capsule §afor §63500 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			if (slot == 29) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.cobblewall")) {
						CapsuleManager.setSelectedCapsule(p, "cobblewall");
						p.sendMessage("§aCapsule set to: §7Cobble Wall Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=3500) {
							EconomyManager.getManager().removeMysteryDust(pm, 3500);
							CapsuleManager.setSelectedCapsule(p, "cobblewall");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.cobblewall");
							p.sendMessage("§aYou have bought §7Cobble Wall Capsule §afor §63500 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			if (slot == 30) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.diorite")) {
						CapsuleManager.setSelectedCapsule(p, "diorite");
						p.sendMessage("§aCapsule set to: §fDiorite Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=4000) {
							EconomyManager.getManager().removeMysteryDust(pm, 4000);
							CapsuleManager.setSelectedCapsule(p, "diorite");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.diorite");
							p.sendMessage("§aYou have bought §fDiorite Capsule §afor §64000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			if (slot == 31) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.andesite")) {
						CapsuleManager.setSelectedCapsule(p, "andesite");
						p.sendMessage("§aCapsule set to: §7Andesite Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=4000) {
							EconomyManager.getManager().removeMysteryDust(pm, 4000);
							CapsuleManager.setSelectedCapsule(p, "andesite");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.andesite");
							p.sendMessage("§aYou have bought §7Andesite Capsule §afor §64000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			if (slot == 32) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.granite")) {
						CapsuleManager.setSelectedCapsule(p, "granite");
						p.sendMessage("§aCapsule set to: §6Granite Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=4000) {
							EconomyManager.getManager().removeMysteryDust(pm, 4000);
							CapsuleManager.setSelectedCapsule(p, "granite");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.granite");
							p.sendMessage("§aYou have bought §6Granite Capsule §afor §64000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			
			if (slot == 33) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.libraries")) {
						CapsuleManager.setSelectedCapsule(p, "libraries");
						p.sendMessage("§aCapsule set to: §6Libraries Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=4500) {
							EconomyManager.getManager().removeMysteryDust(pm, 4500);
							CapsuleManager.setSelectedCapsule(p, "libraries");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.libraries");
							p.sendMessage("§aYou have bought §6Libraries Capsule §afor §64500 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			if (slot == 34) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.ice")) {
						CapsuleManager.setSelectedCapsule(p, "ice");
						p.sendMessage("§aCapsule set to: §bIce Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "ice");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.ice");
							p.sendMessage("§aYou have bought §bIce Capsule §afor §65000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			if (slot == 35) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.quartz")) {
						CapsuleManager.setSelectedCapsule(p, "quartz");
						p.sendMessage("§aCapsule set to: §fQuartz Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "quartz");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.quartz");
							p.sendMessage("§aYou have bought §fQuartz Capsule §afor §65000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			if (slot == 36) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.jail")) {
						CapsuleManager.setSelectedCapsule(p, "jail");
						p.sendMessage("§aCapsule set to: §7Jail Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "jail");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.jail");
							p.sendMessage("§aYou have bought §7Jail Capsule §afor §65000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					}
			} else {}	
		}
			
			if (slot == 37) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.slabv2")) {
						CapsuleManager.setSelectedCapsule(p, "slabv2");
						p.sendMessage("§aCapsule set to: §7Slab V2 Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						if (p.hasPermission("splindux.vip")) {
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "slabv2");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.slabv2");
							p.sendMessage("§aYou have bought §7Slab V2 Capsule §afor §65000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					} else {
							p.sendMessage("§cYou need to be atleast §a§l[VIP] §cto buy this capsule. "
									+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
							
					}
					}
			} else {}	
		}
			
			if (slot == 38) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.nether_fence")) {
						CapsuleManager.setSelectedCapsule(p, "nether_fence");
						p.sendMessage("§aCapsule set to: §4Nether Fence Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						if (p.hasPermission("splindux.vip")) {
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "nether_fence");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.nether_fence");
							p.sendMessage("§aYou have bought §4Nether Fence Capsule §afor §65000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					} else {
							p.sendMessage("§cYou need to be atleast §a§l[VIP] §cto buy this capsule. "
									+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
							
					}
					}
			} else {}	
		}
			
			if (slot == 39) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.chess")) {
						CapsuleManager.setSelectedCapsule(p, "chess");
						p.sendMessage("§aCapsule set to: §fC§8h§fe§8s§fs §8C§fa§8p§fs§8u§fl§8e");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						if (p.hasPermission("splindux.vip")) {
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "chess");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.chess");
							p.sendMessage("§aYou have bought §fC§8h§fe§8s§fs §8C§fa§8p§fs§8u§fl§8e §afor §65000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					} else {
							p.sendMessage("§cYou need to be atleast §a§l[VIP] §cto buy this capsule. "
									+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
							
					}
					}
			} else {}	
		}
			
			if (slot == 40) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.mushroom_red")) {
						CapsuleManager.setSelectedCapsule(p, "mushroom_red");
						p.sendMessage("§aCapsule set to: §cRed Mushroom Capsule");
						new CapsuleMenu(p).o(p);
						} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "mushroom_red");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.mushroom_red");
							p.sendMessage("§aYou have bought §cRed Mushroom Capsule §afor §66000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					
					}
			} else {}	
		}
			
			if (slot == 41) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.mushroom_brown")) {
						CapsuleManager.setSelectedCapsule(p, "mushroom_brown");
						p.sendMessage("§aCapsule set to: §6Brown Mushroom Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "mushroom_brown");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.mushroom_brown");
							p.sendMessage("§aYou have bought §6Brown Mushroom Capsule §afor §66000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					
					}
			} else {}	
		}
			
			if (slot == 42) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.slimeblock")) {
						CapsuleManager.setSelectedCapsule(p, "slimeblock");
						p.sendMessage("§aCapsule set to: §aSlime Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "slimeblock");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.slimeblock");
							p.sendMessage("§aYou have bought §aSlime Capsule §afor §66000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					
					}
			} else {}	
		}
		
			
			if (slot == 43) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glowstone")) {
						CapsuleManager.setSelectedCapsule(p, "glowstone");
						p.sendMessage("§aCapsule set to: §eGlowstone Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "glowstone");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glowstone");
							p.sendMessage("§aYou have bought §eGlowstone Capsule §afor §66000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					
					}
			} else {}	
		}
			
			if (slot == 44) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.prismarine")) {
						CapsuleManager.setSelectedCapsule(p, "prismarine");
						p.sendMessage("§aCapsule set to: §bPrismarine Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "prismarine");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.prismarine");
							p.sendMessage("§aYou have bought §bPrismarine Capsule §afor §66000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					
					}
			} else {}	
		}
			if (slot == 45) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.redsandstone")) {
						CapsuleManager.setSelectedCapsule(p, "redsandstone");
						p.sendMessage("§aCapsule set to: §6Red Sandstone Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						if (p.hasPermission("splindux.vip")) {
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "redsandstone");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.redsandstone");
							p.sendMessage("§aYou have bought §6Red Sandstone Capsule §afor §66000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
						} else {
									p.sendMessage("§cYou need to be atleast §a§l[VIP] §cto buy this capsule. "
											+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
						}
					}
			} else {}	
		}
			
			if (slot == 46) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.sandstone")) {
						CapsuleManager.setSelectedCapsule(p, "sandstone");
						p.sendMessage("§aCapsule set to: §eSandstone Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						if (p.hasPermission("splindux.vip")) {
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "sandstone");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.sandstone");
							p.sendMessage("§aYou have bought §eSandstone Capsule §afor §66000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
						} else {
									p.sendMessage("§cYou need to be atleast §a§l[VIP] §cto buy this capsule. "
											+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
						}
					}
			} else {}	
		}
			
			if (slot == 47) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.tnt")) {
						CapsuleManager.setSelectedCapsule(p, "tnt");
						p.sendMessage("§aCapsule set to: §cTNT Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=7000) {
							EconomyManager.getManager().removeMysteryDust(pm, 7000);
							CapsuleManager.setSelectedCapsule(p, "tnt");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.tnt");
							p.sendMessage("§aYou have bought §cTNT Capsule §afor §67000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					
					}
			} else {}	
		}
			
			if (slot == 48) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.magma")) {
						CapsuleManager.setSelectedCapsule(p, "magma");
						p.sendMessage("§aCapsule set to: §4Magma Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=7500) {
							EconomyManager.getManager().removeMysteryDust(pm, 7500);
							CapsuleManager.setSelectedCapsule(p, "magma");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.magma");
							p.sendMessage("§aYou have bought §4Magma Capsule §afor §67500 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					
					}
			} else {}	
		}
			
			if (slot == 49) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.snowgolem")) {
						CapsuleManager.setSelectedCapsule(p, "snowgolem");
						p.sendMessage("§aCapsule set to: §fSnow Golem Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						if (p.hasPermission("splindux.vip")) {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=7500) {
							EconomyManager.getManager().removeMysteryDust(pm, 7500);
							CapsuleManager.setSelectedCapsule(p, "snowgolem");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.snowgolem");
							p.sendMessage("§aYou have bought §fSnow Golem Capsule §afor §67500 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					
					} else {
						p.sendMessage("§cYou need to be atleast §a§l[VIP] §cto buy this capsule. "
								+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
					}
					}
			} else {}	
		}
			
			if (slot == 50) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.cactus")) {
						CapsuleManager.setSelectedCapsule(p, "cactus");
						p.sendMessage("§aCapsule set to: §2Cactus Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						if (p.hasPermission("splindux.vip")) {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=7500) {
							EconomyManager.getManager().removeMysteryDust(pm, 7500);
							CapsuleManager.setSelectedCapsule(p, "cactus");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.cactus");
							p.sendMessage("§aYou have bought §2Cactus Capsule §afor §67500 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					
					} else {
						p.sendMessage("§cYou need to be atleast §a§l[VIP] §cto buy this capsule. "
								+ "Visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
					}
					}
			} else {}	
		}
			
			if (slot == 51) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.portal")) {
						CapsuleManager.setSelectedCapsule(p, "portal");
						p.sendMessage("§aCapsule set to: §5Portal Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=8000) {
							EconomyManager.getManager().removeMysteryDust(pm, 8000);
							CapsuleManager.setSelectedCapsule(p, "portal");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.portal");
							p.sendMessage("§aYou have bought §5Portal Capsule §afor §68000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}				
					} 				
			} else {}	
		}
			
			if (slot == 52) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.packedice")) {
						CapsuleManager.setSelectedCapsule(p, "packedice");
						p.sendMessage("§aCapsule set to: §bPacked Ice Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=8000) {
							EconomyManager.getManager().removeMysteryDust(pm, 8000);
							CapsuleManager.setSelectedCapsule(p, "packedice");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.packedice");
							p.sendMessage("§aYou have bought §bPacked Ice Capsule §afor §68000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}				
					} 				
			} else {}	
		}
			
			if (slot == 53) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.sponge")) {
						CapsuleManager.setSelectedCapsule(p, "sponge");
						p.sendMessage("§aCapsule set to: §eSponge Capsule");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=9000) {
							EconomyManager.getManager().removeMysteryDust(pm, 9000);
							CapsuleManager.setSelectedCapsule(p, "sponge");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.sponge");
							p.sendMessage("§aYou have bought §eSponge Capsule §afor §69000 Coins§a!");
						} else {
							p.sendMessage("§cYou do not have enough Coins to buy this.");
						}
					 
					}			
			} else {}	
		}
			
		if (slot == 8) {
			if (page.get(p)==1) {
				page.put(p, 2);
				new CapsuleMenu(p).o(p);
			} 
				
			 
		} else if (slot == 0) {
			if (page.get(p)==2) {
				page.put(p, 1);
				new CapsuleMenu(p).o(p);
			} 
		}
	}
	

}
