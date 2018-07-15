package com.santipingui58.spleef.menu.esp;



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
		super("§a§lCapsulas", 6);
		
			if (page.get(p)==1) {
			ItemStack glass_white = new ItemStack(Material.STAINED_GLASS, 1, (short)0);      
	        ItemMeta glass_whiteMeta =  glass_white.getItemMeta();
	        List<String> glass_whiteLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_white")) {
	        	glass_whiteMeta.setDisplayName("§fCapsula Color Blanco");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_white")) {
	        		glass_whiteLore.add("§aSeleccionado!");
	        		glass_whiteMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_whiteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_whiteLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_whiteMeta.setDisplayName("§cCapsula Color Blanco");
	        	glass_whiteLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_whiteMeta.setLore(glass_whiteLore);
	        glass_white.setItemMeta(glass_whiteMeta);
		
	        ItemStack glass_orange = new ItemStack(Material.STAINED_GLASS, 1, (short)1);      
	        ItemMeta glass_orangeMeta =  glass_orange.getItemMeta();
	        List<String> glass_orangeLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_orange")) {
	        	glass_orangeMeta.setDisplayName("§6Capsula Color Naranja");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_orange")) {
	        		glass_orangeLore.add("§aSeleccionado!");
	        		glass_orangeMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_orangeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_orangeLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_orangeMeta.setDisplayName("§cCapsula Color Naranja");
	        	glass_orangeLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_orangeMeta.setLore(glass_orangeLore);
	        glass_orange.setItemMeta(glass_orangeMeta);
		
		
	        
	        
	        ItemStack glass_magenta = new ItemStack(Material.STAINED_GLASS, 1, (short)2);      
	        ItemMeta glass_magentaMeta =  glass_magenta.getItemMeta();
	        List<String> glass_magentaLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_magenta")) {
	        	glass_magentaMeta.setDisplayName("§dCapsula Color Magenta");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_magenta")) {
	        		glass_magentaLore.add("§aSeleccionado!");
	        		glass_magentaMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_magentaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_magentaLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_magentaMeta.setDisplayName("§cCapsula Color Magenta");
	        	glass_magentaLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_magentaMeta.setLore(glass_magentaLore);
	        glass_magenta.setItemMeta(glass_magentaMeta);
		
	        
	        ItemStack glass_lightblue = new ItemStack(Material.STAINED_GLASS, 1, (short)3);      
	        ItemMeta glass_lightblueMeta =  glass_lightblue.getItemMeta();
	        List<String> glass_lightblueLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_lightblue")) {
	        	glass_lightblueMeta.setDisplayName("§bCapsula Color Celeste");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_lightblue")) {
	        		glass_lightblueLore.add("§aSeleccionado!");
	        		glass_lightblueMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_lightblueMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_lightblueLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_lightblueMeta.setDisplayName("§cCapsula Color Celeste");
	        	glass_lightblueLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_lightblueMeta.setLore(glass_lightblueLore);
	        glass_lightblue.setItemMeta(glass_lightblueMeta);
	        
	        
	        ItemStack glass_yellow = new ItemStack(Material.STAINED_GLASS, 1, (short)4);      
	        ItemMeta glass_yellowMeta =  glass_yellow.getItemMeta();
	        List<String> glass_yellowLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_yellow")) {
	        	glass_yellowMeta.setDisplayName("§eCapsula Color Amarillo");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_yellow")) {
	        		glass_yellowLore.add("§aSeleccionado!");
	        		glass_yellowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_yellowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        		
	        	} else {
	        		glass_yellowLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_yellowMeta.setDisplayName("§cCapsula Color Amarillo");
	        	glass_yellowLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_yellowMeta.setLore(glass_yellowLore);
	        glass_yellow.setItemMeta(glass_yellowMeta);
	        
	        
	        ItemStack glass_lime = new ItemStack(Material.STAINED_GLASS, 1, (short)5);      
	        ItemMeta glass_limeMeta =  glass_lime.getItemMeta();
	        List<String> glass_limeLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_lime")) {
	        	glass_limeMeta.setDisplayName("§aCapsula Color Lima");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_lime")) {
	        		glass_limeLore.add("§aSeleccionado!");
	        		glass_limeMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_limeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_limeLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_limeMeta.setDisplayName("§cCapsula Color Lima");
	        	glass_limeLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_limeMeta.setLore(glass_limeLore);
	        glass_lime.setItemMeta(glass_limeMeta);
	        
	        
	        ItemStack glass_pink = new ItemStack(Material.STAINED_GLASS, 1, (short)6);      
	        ItemMeta glass_pinkMeta =  glass_pink.getItemMeta();
	        List<String> glass_pinkLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_pink")) {
	        	glass_pinkMeta.setDisplayName("§dCapsula Color Rosa");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_pink")) {
	        		glass_pinkLore.add("§aSeleccionado!");
	        		glass_pinkMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_pinkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_pinkLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_pinkMeta.setDisplayName("§cCapsula Color Rosa");
	        	glass_pinkLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_pinkMeta.setLore(glass_pinkLore);
	        glass_pink.setItemMeta(glass_pinkMeta);
	        
	        
	        
	        ItemStack glass_gray = new ItemStack(Material.STAINED_GLASS, 1, (short)7);      
	        ItemMeta glass_grayMeta =  glass_gray.getItemMeta();
	        List<String> glass_grayLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_gray")) {
	        	glass_grayMeta.setDisplayName("§8Capsula Color Gris");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_gray")) {
	        		glass_grayLore.add("§aSeleccionado!");
	        		glass_grayMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_grayMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_grayLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_grayMeta.setDisplayName("§cCapsula Color Gris");
	        	glass_grayLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_grayMeta.setLore(glass_grayLore);
	        glass_gray.setItemMeta(glass_grayMeta);
	        
	        ItemStack glass_lightgray = new ItemStack(Material.STAINED_GLASS, 1, (short)8);      
	        ItemMeta glass_lightgrayMeta =  glass_lightgray.getItemMeta();
	        List<String> glass_lightgrayLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_lightgray")) {
	        	glass_lightgrayMeta.setDisplayName("§7Capsula Color Gris Claro");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_lightgray")) {
	        		glass_lightgrayLore.add("§aSeleccionado!");
	        		glass_lightgrayMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_lightgrayMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_lightgrayLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_lightgrayMeta.setDisplayName("§cCapsula Color Gris Claro");
	        	glass_lightgrayLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_lightgrayMeta.setLore(glass_lightgrayLore);
	        glass_lightgray.setItemMeta(glass_lightgrayMeta);
	        
	        
	    
	        
	        ItemStack glass_cyan = new ItemStack(Material.STAINED_GLASS, 1, (short)9);      
	        ItemMeta glass_cyanMeta =  glass_cyan.getItemMeta();
	        List<String> glass_cyanLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_cyan")) {
	        	glass_cyanMeta.setDisplayName("§3Capsula Color Cian");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_cyan")) {
	        		glass_cyanLore.add("§aSeleccionado!");
	        		glass_cyanMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_cyanMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_cyanLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_cyanMeta.setDisplayName("§cCapsula Color Cian");
	        	glass_cyanLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_cyanMeta.setLore(glass_cyanLore);
	        glass_cyan.setItemMeta(glass_cyanMeta);
	        
	        
	        ItemStack glass_purple = new ItemStack(Material.STAINED_GLASS, 1, (short)10);      
	        ItemMeta glass_purpleMeta =  glass_purple.getItemMeta();
	        List<String> glass_purpleLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_purple")) {
	        	glass_purpleMeta.setDisplayName("§5Capsula Color Violeta");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_purple")) {
	        		glass_purpleLore.add("§aSeleccionado!");
	        		glass_purpleMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_purpleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_purpleLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_purpleMeta.setDisplayName("§cCapsula Color Violeta");
	        	glass_purpleLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_purpleMeta.setLore(glass_purpleLore);
	        glass_purple.setItemMeta(glass_purpleMeta);
	        
	        
	        
	        ItemStack glass_blue = new ItemStack(Material.STAINED_GLASS, 1, (short)11);      
	        ItemMeta glass_blueMeta =  glass_blue.getItemMeta();
	        List<String> glass_blueLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_blue")) {
	        	glass_blueMeta.setDisplayName("§1Capsula Color Azul");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_blue")) {
	        		glass_blueLore.add("§aSeleccionado!");
	        		glass_blueMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_blueMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_blueLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_blueMeta.setDisplayName("§cCapsula Color Azul");
	        	glass_blueLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_blueMeta.setLore(glass_blueLore);
	        glass_blue.setItemMeta(glass_blueMeta);
	        
	        
	        ItemStack glass_brown = new ItemStack(Material.STAINED_GLASS, 1, (short)12);      
	        ItemMeta glass_brownMeta =  glass_brown.getItemMeta();
	        List<String> glass_brownLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_brown")) {
	        	glass_brownMeta.setDisplayName("§6Capsula Color Marron");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_brown")) {
	        		glass_brownLore.add("§aSeleccionado!");
	        		glass_brownMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_brownMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_brownLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_brownMeta.setDisplayName("§cCapsula Color Marron");
	        	glass_brownLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_brownMeta.setLore(glass_brownLore);
	        glass_brown.setItemMeta(glass_brownMeta);
	        
	        
	        ItemStack glass_green = new ItemStack(Material.STAINED_GLASS, 1, (short)13);      
	        ItemMeta glass_greenMeta =  glass_green.getItemMeta();
	        List<String> glass_greenLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_green")) {
	        	glass_greenMeta.setDisplayName("§2Capsula Color Verde");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_green")) {
	        		glass_greenLore.add("§aSeleccionado!");
	        		glass_greenMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_greenMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_greenLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_greenMeta.setDisplayName("§cCapsula Color Verde");
	        	glass_greenLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_greenMeta.setLore(glass_greenLore);
	        glass_green.setItemMeta(glass_greenMeta);
	        
	        ItemStack glass_red = new ItemStack(Material.STAINED_GLASS, 1, (short)14);      
	        ItemMeta glass_redMeta =  glass_red.getItemMeta();
	        List<String> glass_redLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_red")) {
	        	glass_redMeta.setDisplayName("§4Capsula Color Rojo");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_red")) {
	        		glass_redLore.add("§aSeleccionado!");
	        		glass_redMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_redMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_redLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_redMeta.setDisplayName("§cCapsula Color Rojo");
	        	glass_redLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_redMeta.setLore(glass_redLore);
	        glass_red.setItemMeta(glass_redMeta);
	        
	        
	        ItemStack glass_black = new ItemStack(Material.STAINED_GLASS, 1, (short)15);      
	        ItemMeta glass_blackMeta =  glass_black.getItemMeta();
	        List<String> glass_blackLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glass_black")) {
	        	glass_blackMeta.setDisplayName("§8Capsula Color Negro");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glass_black")) {
	        		glass_blackLore.add("§aSeleccionado!");
	        		glass_blackMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glass_blackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glass_blackLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glass_blackMeta.setDisplayName("§cCapsula Color Negro");
	        	glass_blackLore.add("§eCompra esta capsula por: §62000 Coins");
	        }
	        glass_blackMeta.setLore(glass_blackLore);
	        glass_black.setItemMeta(glass_blackMeta);
	        
	        
	        ItemStack fence = new ItemStack(Material.FENCE); 
	        ItemMeta fenceMeta =  fence.getItemMeta();
	        List<String> fenceLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.fence")) {
	        	fenceMeta.setDisplayName("§eCapsula Valla");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("fence")) {
	        		fenceLore.add("§aSeleccionado!");
	        		fenceMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		fenceMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        		
	        	} else {
	        		fenceLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	fenceMeta.setDisplayName("§cCapsula Valla");
	        	fenceLore.add("§eCompra esta capsula por: §62500 Coins");
	        }
	        fenceMeta.setLore(fenceLore);
	        fence.setItemMeta(fenceMeta);
	        s(25,fence);
	        
	        ItemStack slab = new ItemStack(Material.STEP); 
	        ItemMeta slabMeta =  slab.getItemMeta();
	        List<String> slabLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.slab")) {
	        	slabMeta.setDisplayName("§7Capsula Slab");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("slab")) {
	        		slabLore.add("§aSeleccionado!");
	        		slabMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		slabMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		slabLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	slabMeta.setDisplayName("§cCapsula Slab");
	        	slabLore.add("§eCompra esta capsula por: §62500 Coins");
	        }
	        slabMeta.setLore(slabLore);
	        slab.setItemMeta(slabMeta);
	        s(26,slab);
	        
	        
	        ItemStack tree = new ItemStack(Material.SAPLING); 
	        ItemMeta treeMeta =  tree.getItemMeta();
	        List<String> treeLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.tree")) {
	        	treeMeta.setDisplayName("§aCapsula Arbol");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("tree")) {
	        		treeLore.add("§aSeleccionado!");
	        		treeMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		treeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		treeLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	treeMeta.setDisplayName("§cCapsula Arbol");
	        	treeLore.add("§eCompra esta capsula por: §63000 Coins");
	        }
	        treeMeta.setLore(treeLore);
	        tree.setItemMeta(treeMeta);
	        s(27,tree);
	        
	        ItemStack leaves = new ItemStack(Material.LEAVES); 
	        ItemMeta leavesMeta =  leaves.getItemMeta();
	        List<String> leavesLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.leaves")) {
	        	leavesMeta.setDisplayName("§2Capsula Hojas");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("leaves")) {
	        		leavesLore.add("§aSeleccionado!");
	        		leavesMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		leavesMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		leavesLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	leavesMeta.setDisplayName("§cCapsula Hojas");
	        	leavesLore.add("§eCompra esta capsula por: §63500 Coins");
	        }
	        leavesMeta.setLore(leavesLore);
	        leaves.setItemMeta(leavesMeta);
	        s(28,leaves);
	        
	        ItemStack cobblewall = new ItemStack(Material.COBBLE_WALL); 
	        ItemMeta cobblewallMeta =  cobblewall.getItemMeta();
	        List<String> cobblewallLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.cobblewall")) {
	        	cobblewallMeta.setDisplayName("§7Capsula Pared de Cobble");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("cobblewall")) {
	        		cobblewallLore.add("§aSeleccionado!");
	        		cobblewallMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		cobblewallMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		cobblewallLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	cobblewallMeta.setDisplayName("§cCapsula Pared de Cobble");
	        	cobblewallLore.add("§eCompra esta capsula por: §63500 Coins");
	        }
	        cobblewallMeta.setLore(cobblewallLore);
	        cobblewall.setItemMeta(cobblewallMeta);
	        s(29,cobblewall);
	        
	        
	        ItemStack diorite = new ItemStack(Material.STONE,1,(short)4); 
	        ItemMeta dioriteMeta =  diorite.getItemMeta();
	        List<String> dioriteLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.diorite")) {
	        	dioriteMeta.setDisplayName("§fCapsula Diorita");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("diorite")) {
	        		dioriteLore.add("§aSeleccionado!");
	        		dioriteMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		dioriteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		dioriteLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	dioriteMeta.setDisplayName("§cCapsula Diorita");
	        	dioriteLore.add("§eCompra esta capsula por: §64000 Coins");
	        }
	        dioriteMeta.setLore(dioriteLore);
	        diorite.setItemMeta(dioriteMeta);
	        s(30,diorite);
	        
	        ItemStack andesite = new ItemStack(Material.STONE,1,(short)6); 
	        ItemMeta andesiteMeta =  andesite.getItemMeta();
	        List<String> andesiteLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.andesite")) {
	        	andesiteMeta.setDisplayName("§7Capsula Andesita");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("andesite")) {
	        		andesiteLore.add("§aSeleccionado!");
	        		andesiteMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		andesiteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		andesiteLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	andesiteMeta.setDisplayName("§cCapsula Andesita");
	        	andesiteLore.add("§eCompra esta capsula por: §64000 Coins");
	        }
	        andesiteMeta.setLore(andesiteLore);
	        andesite.setItemMeta(andesiteMeta);
	        s(31,andesite);
	        
	        
	        ItemStack granite = new ItemStack(Material.STONE,1,(short)2); 
	        ItemMeta graniteMeta =  granite.getItemMeta();
	        List<String> graniteLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.granite")) {
	        	graniteMeta.setDisplayName("§6Capsula Granito");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("granite")) {
	        		graniteLore.add("§aSeleccionado!");
	        		graniteMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		graniteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		graniteLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	graniteMeta.setDisplayName("§cCapsula Granito");
	        	graniteLore.add("§eCompra esta capsula por: §64000 Coins");
	        }
	        graniteMeta.setLore(graniteLore);
	        granite.setItemMeta(graniteMeta);
	        s(32,granite);
	        
	        
	        ItemStack libraries = new ItemStack(Material.BOOKSHELF); 
	        ItemMeta librariesMeta =  libraries.getItemMeta();
	        List<String> librariesLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.libraries")) {
	        	librariesMeta.setDisplayName("§6Capsula Librerias");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("libraries")) {
	        		librariesLore.add("§aSeleccionado!");
	        		librariesMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		librariesMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		librariesLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	librariesMeta.setDisplayName("§cCapsula Librerias");
	        	librariesLore.add("§eCompra esta capsula por: §64500 Coins");
	        }
	        librariesMeta.setLore(librariesLore);
	        libraries.setItemMeta(librariesMeta);
	        s(33,libraries);
	        
	        
	        ItemStack ice = new ItemStack(Material.ICE); 
	        ItemMeta iceMeta =  ice.getItemMeta();
	        List<String> iceLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.ice")) {
	        	iceMeta.setDisplayName("§bCapsula de Hielo");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("ice")) {
	        		iceLore.add("§aSeleccionado!");
	        		iceMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		iceMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		iceLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	iceMeta.setDisplayName("§cCapsula de Hielo");
	        	iceLore.add("§eCompra esta capsula por: §65000 Coins");
	        }
	        iceMeta.setLore(iceLore);
	        ice.setItemMeta(iceMeta);
	        s(34,ice);
	        

	        ItemStack quartz = new ItemStack(Material.QUARTZ_BLOCK); 
	        ItemMeta quartzMeta =  quartz.getItemMeta();
	        List<String> quartzLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.quartz")) {
	        	quartzMeta.setDisplayName("§fCapsula de Cuarzo");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("quartz")) {
	        		quartzLore.add("§aSeleccionado!");
	        		quartzMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		quartzMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		quartzLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	quartzMeta.setDisplayName("§cCapsula de Cuarzo");
	        	quartzLore.add("§eCompra esta capsula por: §65000 Coins");
	        }
	        quartzMeta.setLore(quartzLore);
	        quartz.setItemMeta(quartzMeta);
	        s(35,quartz);
	        
	        ItemStack jail = new ItemStack(Material.IRON_FENCE); 
	        ItemMeta jailMeta =  jail.getItemMeta();
	        List<String> jailLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.jail")) {
	        	jailMeta.setDisplayName("§7Capsula Carcel");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("jail")) {
	        		jailLore.add("§aSeleccionado!");
	        		jailMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		jailMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		jailLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	jailMeta.setDisplayName("§cCapsula Carcel");
	        	jailLore.add("§eCompra esta capsula por: §65000 Coins");
	        }
	        jailMeta.setLore(jailLore);
	        jail.setItemMeta(jailMeta);
	        s(36,jail);
	        
	        ItemStack slabv2 = new ItemStack(Material.PURPUR_SLAB); 
	        ItemMeta slabv2Meta =  slabv2.getItemMeta();
	        List<String> slabv2Lore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.slabv2")) {
	        	slabv2Meta.setDisplayName("§7Capsula Slab v2");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("slabv2")) {
	        		slabv2Lore.add("§aSeleccionado!");
	        		slabv2Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		slabv2Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		slabv2Lore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	slabv2Meta.setDisplayName("§cCapsula Slab v2");
	        	if (p.hasPermission("splindux.vip")) {
	        	slabv2Lore.add("§eCompra esta capsula por: §65000 Coins");
	        } else {
	        	slabv2Lore.add("§cYou need to be atleast §a[VIP] §cto Compra esta capsula.");
	        }
	        	}
	        slabv2Meta.setLore(slabv2Lore);
	        slabv2.setItemMeta(slabv2Meta);
	        s(37,slabv2);
	        
	        
	        
	        ItemStack nether_fence = new ItemStack(Material.NETHER_FENCE); 
	        ItemMeta nether_fenceMeta =  nether_fence.getItemMeta();
	        List<String> nether_fenceLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.nether_fence")) {
	        	nether_fenceMeta.setDisplayName("§4Capsula Valla del Nether");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("nether_fence")) {
	        		nether_fenceLore.add("§aSeleccionado!");
	        		nether_fenceMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		nether_fenceMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		nether_fenceLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	nether_fenceMeta.setDisplayName("§cCapsula Valla del Nether");
	        	if (p.hasPermission("splindux.vip")) {
	        		nether_fenceLore.add("§eCompra esta capsula por: §65000 Coins");
		        } else {
		        	nether_fenceLore.add("§cYou need to be atleast §a[VIP] §cto Compra esta capsula.");
		        }
	        }
	        nether_fenceMeta.setLore(nether_fenceLore);
	        nether_fence.setItemMeta(nether_fenceMeta);
	        s(38,nether_fence);
	        
	        
	        ItemStack chess = Main.getSkull("http://textures.minecraft.net/texture/94094effee4ba2ab1c2fc6c8ed1c4690fba19c86617e9227db1f58d8dd5d");
	        ItemMeta chessMeta =  chess.getItemMeta();
	        List<String> chessLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.chess")) {
	        	chessMeta.setDisplayName("§fC§8a§fp§8s§fu§8l§fa §8A§fj§8e§fd§8r§fe§8z");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("chess")) {
	        		chessLore.add("§aSeleccionado!");
	        		chessMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		chessMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		chessLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	chessMeta.setDisplayName("§cCapsula Ajedrez");
	        	if (p.hasPermission("splindux.vip")) {
	        		chessLore.add("§eCompra esta capsula por: §65000 Coins");
		        } else {
		        	chessLore.add("§cYou need to be atleast §a[VIP] §cto Compra esta capsula.");
		        }
	        }
	        chessMeta.setLore(chessLore);
	        chess.setItemMeta(chessMeta);
	        s(39,chess);
	        
	        ItemStack mushroom_red = new ItemStack(Material.HUGE_MUSHROOM_2); 
	        ItemMeta mushroom_redMeta =  mushroom_red.getItemMeta();
	        List<String> mushroom_redLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.mushroom_red")) {
	        	mushroom_redMeta.setDisplayName("§cCapsula Hongo Rojo");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("mushroom_red")) {
	        		mushroom_redLore.add("§aSeleccionado!");
	        		mushroom_redMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		mushroom_redMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		mushroom_redLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	mushroom_redMeta.setDisplayName("§cCapsula Hongo Rojo");
	        	mushroom_redLore.add("§eCompra esta capsula por: §66000 Coins");
	        }
	        mushroom_redMeta.setLore(mushroom_redLore);
	        mushroom_red.setItemMeta(mushroom_redMeta);
	        s(40,mushroom_red);
	        
	        
	        ItemStack mushroom_brown = new ItemStack(Material.HUGE_MUSHROOM_1); 
	        ItemMeta mushroom_brownMeta =  mushroom_brown.getItemMeta();
	        List<String> mushroom_brownLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.mushroom_brown")) {
	        	mushroom_brownMeta.setDisplayName("§6Capsula Hongo Marron");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("mushroom_brown")) {
	        		mushroom_brownLore.add("§aSeleccionado!");
	        		mushroom_brownMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		mushroom_brownMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		mushroom_brownLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	mushroom_brownMeta.setDisplayName("§cCapsula Hongo Marron");
	        	mushroom_brownLore.add("§eCompra esta capsula por: §66000 Coins");
	        }
	        mushroom_brownMeta.setLore(mushroom_brownLore);
	        mushroom_brown.setItemMeta(mushroom_brownMeta);
	        s(41,mushroom_brown);
	        
	        
	        
	        
	        
	        ItemStack slimeblock = new ItemStack(Material.SLIME_BLOCK); 
	        ItemMeta slimeblockMeta =  slimeblock.getItemMeta();
	        List<String> slimeblockLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.slimeblock")) {
	        	slimeblockMeta.setDisplayName("§aCapsula Slime");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("slimeblock")) {
	        		slimeblockLore.add("§aSeleccionado!");
	        		slimeblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		slimeblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		slimeblockLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	slimeblockMeta.setDisplayName("§cCapsula Slime");
	        	slimeblockLore.add("§eCompra esta capsula por: §66000 Coins");
	        }
	        slimeblockMeta.setLore(slimeblockLore);
	        slimeblock.setItemMeta(slimeblockMeta);
	        s(42,slimeblock);
	        
	        
	        ItemStack glowstone = new ItemStack(Material.GLOWSTONE); 
	        ItemMeta glowstoneMeta =  glowstone.getItemMeta();
	        List<String> glowstoneLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.glowstone")) {
	        	glowstoneMeta.setDisplayName("§eCapsula Glowstone");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("glowstone")) {
	        		glowstoneLore.add("§aSeleccionado!");
	        		glowstoneMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		glowstoneMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		glowstoneLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	glowstoneMeta.setDisplayName("§cCapsula Glowstone");
	        	glowstoneLore.add("§eCompra esta capsula por: §66000 Coins");
	        }
	        glowstoneMeta.setLore(glowstoneLore);
	        glowstone.setItemMeta(glowstoneMeta);
	        s(43,glowstone);
	        
	        
	        
	        ItemStack oceano = new ItemStack(Material.PRISMARINE); 
	        ItemMeta oceanoMeta =  oceano.getItemMeta();
	        List<String> oceanoLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.prismarine")) {
	        	oceanoMeta.setDisplayName("§bCapsula Prismarina");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("prismarine")) {
	        		oceanoLore.add("§aSeleccionado!");
	        		oceanoMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		oceanoMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		oceanoLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	oceanoMeta.setDisplayName("§cCapsula Prismarina");
	        	oceanoLore.add("§eCompra esta capsula por: §66000 Coins");
	        }
	        oceanoMeta.setLore(oceanoLore);
	        oceano.setItemMeta(oceanoMeta);
	        s(44,oceano);
	        
	        
	        ItemStack redsandstone = new ItemStack(Material.RED_SANDSTONE); 
	        ItemMeta redsandstoneMeta =  redsandstone.getItemMeta();
	        List<String> redsandstoneLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.redsandstone")) {
	        	redsandstoneMeta.setDisplayName("§6Capsula Sandstone Roja");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("redsandstone")) {
	        		redsandstoneLore.add("§aSeleccionado!");
	        		redsandstoneMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		redsandstoneMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		redsandstoneLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	redsandstoneMeta.setDisplayName("§cCapsula Sandstone Roja");
	        	if (p.hasPermission("splindux.vip")) {
	        		redsandstoneLore.add("§eCompra esta capsula por: §66000 Coins");
		        } else {
		        	redsandstoneLore.add("§cYou need to be atleast §a[VIP] §cto Compra esta capsula.");
		        }
	        }
	        
	        redsandstoneMeta.setLore(redsandstoneLore);
	        redsandstone.setItemMeta(redsandstoneMeta);
	        s(45,redsandstone);
	        
	        
	        ItemStack sandstone = new ItemStack(Material.SANDSTONE); 
	        ItemMeta sandstoneMeta =  sandstone.getItemMeta();
	        List<String> sandstoneLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.sandstone")) {
	        	sandstoneMeta.setDisplayName("§eCapsula Sandstone");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("sandstone")) {
	        		sandstoneLore.add("§aSeleccionado!");
	        		sandstoneMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		sandstoneMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		sandstoneLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	sandstoneMeta.setDisplayName("§cCapsula Sandstone");
	        	if (p.hasPermission("splindux.vip")) {
	        		sandstoneLore.add("§eCompra esta capsula por: §66000 Coins");
		        } else {
		        	sandstoneLore.add("§cYou need to be atleast §a[VIP] §cto Compra esta capsula.");
		        }
	        }
	        
	        sandstoneMeta.setLore(sandstoneLore);
	        sandstone.setItemMeta(sandstoneMeta);
	        s(46,sandstone);
	        
	        
	        ItemStack tnt = new ItemStack(Material.TNT); 
	        ItemMeta tntMeta =  tnt.getItemMeta();
	        List<String> tntLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.tnt")) {
	        	tntMeta.setDisplayName("§cCapsula TNT");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("tnt")) {
	        		tntLore.add("§aSeleccionado!");
	        		tntMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		tntMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		tntLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	tntMeta.setDisplayName("§cCapsula TNT");
	        	tntLore.add("§eCompra esta capsula por: §67000 Coins");
	        }
	        
	        tntMeta.setLore(tntLore);
	        tnt.setItemMeta(tntMeta);
	        s(47,tnt);
	        
	        ItemStack nether = new ItemStack(Material.MAGMA); 
	        ItemMeta netherMeta =  nether.getItemMeta();
	        List<String> netherLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.magma")) {
	        	netherMeta.setDisplayName("§4Capsula Magma");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("magma")) {
	        		netherLore.add("§aSeleccionado!");
	        		netherMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		netherMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		netherLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	netherMeta.setDisplayName("§cCapsula Magma");
	        	netherLore.add("§eCompra esta capsula por: §67500 Coins");
	        }
	        
	        netherMeta.setLore(netherLore);
	        nether.setItemMeta(netherMeta);
	        s(48,nether);
	        
	        
	        ItemStack snowgolem = new ItemStack(Material.PUMPKIN); 
	        ItemMeta snowgolemMeta =  snowgolem.getItemMeta();
	        List<String> snowgolemLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.snowgolem")) {
	        	snowgolemMeta.setDisplayName("§fCapsula Golem de Nieve");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("snowgolem")) {
	        		snowgolemLore.add("§aSeleccionado!");
	        		snowgolemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		snowgolemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		snowgolemLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	snowgolemMeta.setDisplayName("§cCapsula Golem de Nieve");
	        	if (p.hasPermission("splindux.vip")) {
	        		snowgolemLore.add("§eCompra esta capsula por: §67500 Coins");
	        } else {
	        	snowgolemLore.add("§cYou need to be atleast §a[VIP] §cto Compra esta capsula.");
	        }
	        	}
	        
	        snowgolemMeta.setLore(snowgolemLore);
	        snowgolem.setItemMeta(snowgolemMeta);
	        s(49,snowgolem);
	        
	        ItemStack cactus = new ItemStack(Material.CACTUS); 
	        ItemMeta cactusMeta =  cactus.getItemMeta();
	        List<String> cactusLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.cactus")) {
	        	cactusMeta.setDisplayName("§2Capsula Cactus");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("cactus")) {
	        		cactusLore.add("§aSeleccionado!");
	        		cactusMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		cactusMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		cactusLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	cactusMeta.setDisplayName("§cCapsula Cactus");
	        	if (p.hasPermission("splindux.vip")) {
	        		cactusLore.add("§eCompra esta capsula por: §67500 Coins");
	        } else {
	        	cactusLore.add("§cYou need to be atleast §a[VIP] §cto Compra esta capsula.");
	        }
	        	}
	        
	        cactusMeta.setLore(cactusLore);
	        cactus.setItemMeta(cactusMeta);
	        s(50,cactus);
	        
	        
	        ItemStack portal = new ItemStack(Material.OBSIDIAN); 
	        ItemMeta portalMeta =  portal.getItemMeta();
	        List<String> portalLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.portal")) {
	        	portalMeta.setDisplayName("§5Capsula Portal");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("portal")) {
	        		portalLore.add("§aSeleccionado!");
	        		portalMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		portalMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		portalLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	portalMeta.setDisplayName("§cCapsula Portal");
	        	portalLore.add("§eCompra esta capsula por: §68000 Coins");
	        }
	        
	        portalMeta.setLore(portalLore);
	        portal.setItemMeta(portalMeta);
	        s(51,portal);
	        
	        ItemStack packedice = new ItemStack(Material.PACKED_ICE); 
	        ItemMeta packediceMeta =  packedice.getItemMeta();
	        List<String> packediceLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.packedice")) {
	        	packediceMeta.setDisplayName("§bCapsula Hielo Compacto");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("packedice")) {
	        		packediceLore.add("§aSeleccionado!");
	        		packediceMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		packediceMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		packediceLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	packediceMeta.setDisplayName("§cCapsula Hielo Compacto");
	        	packediceLore.add("§eCompra esta capsula por: §68000 Coins");
	        }
	        
	        packediceMeta.setLore(packediceLore);
	        packedice.setItemMeta(packediceMeta);
	        s(52,packedice);
	        
	        
	        ItemStack sponge = new ItemStack(Material.SPONGE); 
	        ItemMeta spongeMeta =  sponge.getItemMeta();
	        List<String> spongeLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.sponge")) {
	        	spongeMeta.setDisplayName("§eCapsula Esponja");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("sponge")) {
	        		spongeLore.add("§aSeleccionado!");
	        		spongeMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		spongeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		spongeLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	spongeMeta.setDisplayName("§cCapsula Esponja");
	        	spongeLore.add("§eCompra esta capsula por: §69000 Coins");
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
	        	bedrockMeta.setDisplayName("§8Capsula Bedrock");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("bedrock")) {
	        		bedrockLore.add("§aSeleccionado!");
	        		bedrockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		bedrockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		bedrockLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	bedrockMeta.setDisplayName("§cCapsula Bedrock");
	        	bedrockLore.add("§eCompra esta capsula por: §610000 Coins");
	        }
	        
	        bedrockMeta.setLore(bedrockLore);
	        bedrock.setItemMeta(bedrockMeta);
	        s(9,bedrock);
	        
	        ItemStack invisible = new ItemStack(Material.BARRIER); 
	        ItemMeta invisibleMeta =  invisible.getItemMeta();
	        List<String> invisibleLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.invisible")) {
	        	invisibleMeta.setDisplayName("§7Capsula Invicible");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("invisible")) {
	        		invisibleLore.add("§aSeleccionado!");
	        		invisibleMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		invisibleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		invisibleLore.add("§aHas click para seleccionar!");
	        	}

	        } else {
	        	invisibleMeta.setDisplayName("§cCapsula Invicible");
	        	invisibleLore.add("§eCompra esta capsula por: §610000 Coins");
	        }
	        
	        invisibleMeta.setLore(invisibleLore);
	        invisible.setItemMeta(invisibleMeta);
	        s(10,invisible);
	        
		
		
		
		
		ItemStack beach = Main.getSkull("http://textures.minecraft.net/texture/5a5ab05ea254c32e3c48f3fdcf9fd9d77d3cba04e6b5ec2e68b3cbdcfac3fd"); 
        ItemMeta beachMeta =  beach.getItemMeta();
        List<String> beachLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.beach")) {
        	beachMeta.setDisplayName("§eCapsula Playa");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("beach")) {
        		beachLore.add("§aSeleccionado!");
        		beachMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		beachMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		beachLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	beachMeta.setDisplayName("§cCapsula Playa");
        	if (p.hasPermission("splindux.vip")) {
        		beachLore.add("§eCompra esta capsula por: §610000 Coins");
        } else {
        	beachLore.add("§cYou need to be atleast §a[VIP] §cto Compra esta capsula.");
        }
        	}
        
        beachMeta.setLore(beachLore);
        beach.setItemMeta(beachMeta);
        s(11,beach);
		
        
        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta anvilMeta =  anvil.getItemMeta();
        List<String> anvilLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.anvil")) {
        	anvilMeta.setDisplayName("§8Capsula Yunque");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("anvil")) {
        		anvilLore.add("§aSeleccionado!");
        		anvilMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		anvilMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		anvilLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	anvilMeta.setDisplayName("§cCapsula Yunque");
        	if (p.hasPermission("splindux.vip")) {
        		anvilLore.add("§eCompra esta capsula por: §610000 Coins");
        } else {
        	anvilLore.add("§cYou need to be atleast §a[VIP] §cto Compra esta capsula.");
        }
        	}
        
        anvilMeta.setLore(anvilLore);
        anvil.setItemMeta(anvilMeta);
        s(12,anvil);
        
        
        ItemStack web = new ItemStack(Material.WEB);
        ItemMeta webMeta =  web.getItemMeta();
        List<String> webLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.web")) {
        	webMeta.setDisplayName("§fCapsula Tela de Araña");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("web")) {
        		webLore.add("§aSeleccionado!");
        		webMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		webMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		webLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	webMeta.setDisplayName("§cCapsula Tela de Araña");
        	if (p.hasPermission("splindux.epic")) {
        		webLore.add("§eCompra esta capsula por: §610000 Coins");
        } else {
        	webLore.add("§cNecesitas ser por lo menos §9[Epic] §cpara comprar esta capsula.");
        }
        	}
        
        webMeta.setLore(webLore);
        web.setItemMeta(webMeta);
        s(13,web);
        
        ItemStack jukebox = new ItemStack(Material.JUKEBOX);
        ItemMeta jukeboxMeta =  jukebox.getItemMeta();
        List<String> jukeboxLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.jukebox")) {
        	jukeboxMeta.setDisplayName("§6Capsula Jukebox");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("jukebox")) {
        		jukeboxLore.add("§aSeleccionado!");
        		jukeboxMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		jukeboxMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		jukeboxLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	jukeboxMeta.setDisplayName("§6Capsula Jukebox");
        	if (p.hasPermission("splindux.epic")) {
        		jukeboxLore.add("§eCompra esta capsula por: §610000 Coins");
        } else {
        	jukeboxLore.add("§cNecesitas ser por lo menos §9[Epic] §cpara comprar esta capsula.");
        }
        	}
        
        jukeboxMeta.setLore(jukeboxLore);
        jukebox.setItemMeta(jukeboxMeta);
        s(14,jukebox);
        
        ItemStack end = new ItemStack(Material.ENDER_STONE);
        ItemMeta endMeta =  end.getItemMeta();
        List<String> endLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.end")) {
        	endMeta.setDisplayName("§5Capsula §eEnd");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("end")) {
        		endLore.add("§aSeleccionado!");
        		endMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		endMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		endLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	endMeta.setDisplayName("§cCapsula End");
        	if (p.hasPermission("splindux.epic")) {
        		endLore.add("§eCompra esta capsula por: §612500 Coins");
        } else {
        	endLore.add("§cNecesitas ser por lo menos §9[Epic] §cpara comprar esta capsula.");
        }
        	}
        
        endMeta.setLore(endLore);
        end.setItemMeta(endMeta);
        s(15,end);
        
        
        ItemStack tank = new ItemStack(Material.WATER_BUCKET);
        ItemMeta tankMeta =  tank.getItemMeta();
        List<String> tankLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.tank")) {
        	tankMeta.setDisplayName("§fCapsula §9Tanque");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("tank")) {
        		tankLore.add("§aSeleccionado!");
        		tankMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		tankMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		tankLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	tankMeta.setDisplayName("§cCapsula Tanque");
        	if (p.hasPermission("splindux.epic")) {
        		tankLore.add("§eCompra esta capsula por: §615000 Coins");
        } else {
        	tankLore.add("§cNecesitas ser por lo menos §9[Epic] §cpara comprar esta capsula.");
        }
        	}
        
        tankMeta.setLore(tankLore);
        tank.setItemMeta(tankMeta);
        s(16,tank);
        
        ItemStack beacon = new ItemStack(Material.BEACON);
        ItemMeta beaconMeta =  beacon.getItemMeta();
        List<String> beaconLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.beacon")) {
        	beaconMeta.setDisplayName("§bCapsula Beacon");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("beacon")) {
        		beaconLore.add("§aSeleccionado!");
        		beaconMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		beaconMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		beaconLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	beaconMeta.setDisplayName("§cCapsula Beacon");
        	if (p.hasPermission("splindux.extreme")) {
        		beaconLore.add("§eCompra esta capsula por: §625000 Coins");
        } else {
        	beaconLore.add("§cNecesitas ser §5[Extreme] §cpara comprar esta capsula.");
        }
        	}
        
        beaconMeta.setLore(beaconLore);
        beacon.setItemMeta(beaconMeta);
        s(17,beacon);
		
        
        
        ItemStack goldblock = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta goldblockMeta =  goldblock.getItemMeta();
        List<String> goldblockLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.goldblock")) {
        	goldblockMeta.setDisplayName("§e§lCapsula de Oro");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("goldblock")) {
        		goldblockLore.add("§aSeleccionado!");
        		goldblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		goldblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		goldblockLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	goldblockMeta.setDisplayName("§cCapsula de Oro");
        		goldblockLore.add("§eCompra esta capsula por: §650000 Coins");
        
        	}
        
        goldblockMeta.setLore(goldblockLore);
        goldblock.setItemMeta(goldblockMeta);
        s(18,goldblock);
        
        ItemStack lapisblock = new ItemStack(Material.LAPIS_BLOCK);
        ItemMeta lapisblockMeta =  lapisblock.getItemMeta();
        List<String> lapisblockLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.lapisblock")) {
        	lapisblockMeta.setDisplayName("§1§lCapsula de Lapislazuli");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("lapisblock")) {
        		lapisblockLore.add("§aSeleccionado!");
        		lapisblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		lapisblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		lapisblockLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	lapisblockMeta.setDisplayName("§cCapsula de Lapislazuli");
        		lapisblockLore.add("§eCompra esta capsula por: §650000 Coins");
        
        	}
        
        lapisblockMeta.setLore(lapisblockLore);
        lapisblock.setItemMeta(lapisblockMeta);
        s(19,lapisblock);
        
        ItemStack redstoneblock = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta redstoneblockMeta =  redstoneblock.getItemMeta();
        List<String> redstoneblockLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.redstoneblock")) {
        	redstoneblockMeta.setDisplayName("§c§lCapsula de Redstone");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("redstoneblock")) {
        		redstoneblockLore.add("§aSeleccionado!");
        		redstoneblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		redstoneblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		redstoneblockLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	redstoneblockMeta.setDisplayName("§cCapsula de Restone");
        		redstoneblockLore.add("§eCompra esta capsula por: §650000 Coins");
        
        	}
        
        redstoneblockMeta.setLore(redstoneblockLore);
        redstoneblock.setItemMeta(redstoneblockMeta);
        s(20,redstoneblock);
        
        ItemStack diamondblock = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta diamondblockMeta =  diamondblock.getItemMeta();
        List<String> diamondblockLore = new ArrayList<String>();
        if (p.hasPermission("splindux.capsules.diamondblock")) {
        	diamondblockMeta.setDisplayName("§b§lCapsula de Diamante");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("diamondblock")) {
        		diamondblockLore.add("§aSeleccionado!");
        		diamondblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		diamondblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		diamondblockLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	diamondblockMeta.setDisplayName("§cCapsula de Diamante");
        		diamondblockLore.add("§eCompra esta capsula por: §6100000 Coins");
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
        	emeraldblockMeta.setDisplayName("§a§lCapsula de Esmeralda");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("emeraldblock")) {
        		emeraldblockLore.add("§aSeleccionado!");
        		emeraldblockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		emeraldblockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		emeraldblockLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	emeraldblockMeta.setDisplayName("§cCapsula de Esmeralda");
        		emeraldblockLore.add("§eCompra esta capsula por: §6200000 Coins");
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
        	snowMeta.setDisplayName("§f§lCapsula de Nieve");
        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
        			.equalsIgnoreCase("snow")) {
        		snowLore.add("§aSeleccionado!");
        		snowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        		snowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	} else {
        		snowLore.add("§aHas click para seleccionar!");
        	}

        } else {
        	snowMeta.setDisplayName("§cCapsula de Nieve");
        		snowLore.add("§eCompra esta capsula por: §6500000 Coins");
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
			p.sendMessage("§aCapsula seleccionada: §7Default Capsule");
		}
		
		if (slot == 9) {
			if (page.get(p)==1) {
			if (p.hasPermission("splindux.capsules.glass_white")) {
				CapsuleManager.setSelectedCapsule(p, "glass_white");
				new CapsuleMenu(p).o(p);
				p.sendMessage("§aCapsula seleccionada: §fCapsula Color Blanco");
			} else {
				p.closeInventory();
				PlayerManager pm = EconomyManager.getPlayerManager(p);
				if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
					EconomyManager.getManager().removeMysteryDust(pm, 2000);
					CapsuleManager.setSelectedCapsule(p, "glass_white");
					PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_white");
					p.sendMessage("§aHas comprado §fCapsula Color Blanco §apor §62000 Coins§a!");
				} else {
					p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
				}
			}
		} else {
			if (p.hasPermission("splindux.capsules.bedrock")) {
				CapsuleManager.setSelectedCapsule(p, "bedrock");
				p.sendMessage("§aCapsula seleccionada: §8Capsula Bedrock");
				new CapsuleMenu(p).o(p);
			} else {
				p.closeInventory();
				PlayerManager pm = EconomyManager.getPlayerManager(p);
				if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
					EconomyManager.getManager().removeMysteryDust(pm, 10000);
					CapsuleManager.setSelectedCapsule(p, "bedrock");
					PermissionsEx.getUser(p).addPermission("splindux.capsules.bedrock");
					p.sendMessage("§aHas comprado §8Capsula Bedrock §apor §610000 Coins§a!");
				} else {
					p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
				}
			
			}
		}
		}
		
		if (slot == 10) {
			if (page.get(p)==1) {
			if (p.hasPermission("splindux.capsules.glass_orange")) {
				CapsuleManager.setSelectedCapsule(p, "Capsula Color Naranja");
				p.sendMessage("§aCapsula seleccionada: §6Orange Glass Capsule");
				new CapsuleMenu(p).o(p);
			} else {
				p.closeInventory();
				PlayerManager pm = EconomyManager.getPlayerManager(p);
				if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
					EconomyManager.getManager().removeMysteryDust(pm, 2000);
					CapsuleManager.setSelectedCapsule(p, "glass_orange");
					PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_orange");
					p.sendMessage("§aHas comprado §6Capsula Color Naranja Capsule §apor §62000 Coins§a!");
				} else {
					p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
				}
			}
		} else {
			if (p.hasPermission("splindux.capsules.invisible")) {
				CapsuleManager.setSelectedCapsule(p, "invisible");
				p.sendMessage("§aCapsula seleccionada: §7Capsula Invicible");
				new CapsuleMenu(p).o(p);
			} else {
				p.closeInventory();
				PlayerManager pm = EconomyManager.getPlayerManager(p);
				if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
					EconomyManager.getManager().removeMysteryDust(pm, 10000);
					CapsuleManager.setSelectedCapsule(p, "invisible");
					PermissionsEx.getUser(p).addPermission("splindux.capsules.invisible");
					p.sendMessage("§aHas comprado §7Capsula Invicible §apor §610000 Coins§a!");
				} else {
					p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
				}
			}
		}
		}
			if (slot == 11) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_magenta")) {
						CapsuleManager.setSelectedCapsule(p, "glass_magenta");
						p.sendMessage("§aCapsula seleccionada: §dCapsula Color Magenta");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_magenta");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_magenta");
							p.sendMessage("§aHas comprado §dCapsula Color Magenta §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.beach")) {
					CapsuleManager.setSelectedCapsule(p, "beach");
					p.sendMessage("§aCapsula seleccionada: §eCapsula Playa");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.vip")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
						EconomyManager.getManager().removeMysteryDust(pm, 10000);
						CapsuleManager.setSelectedCapsule(p, "beach");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.beach");
						p.sendMessage("§aHas comprado §eCapsula Playa §apor §610000 Coins§a!");
					} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
				} else {
					p.sendMessage("§cNecesitas ser por lo menos §a§l[VIP] §cpara comprar esta capsula."
							+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
				}
			
			}
		}
		
			
			if (slot == 12) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_lightblue")) {
						CapsuleManager.setSelectedCapsule(p, "glass_lightblue");
						p.sendMessage("§aCapsula seleccionada: §bCapsula Color Celeste");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_lightblue");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_lightblue");
							p.sendMessage("§aHas comprado §bCapsula COlor Celeste §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.anvil")) {
					CapsuleManager.setSelectedCapsule(p, "anvil");
					p.sendMessage("§aCapsula seleccionada: §8Capsula Yunques");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.vip")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
						EconomyManager.getManager().removeMysteryDust(pm, 10000);
						CapsuleManager.setSelectedCapsule(p, "anvil");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.anvil");
						p.sendMessage("§aHas comprado §8Capsula Yunques §apor §610000 Coins§a!");
					} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
				} else {
					p.sendMessage("§cNecesitas ser por lo menos §a§l[VIP] §cpara comprar esta capsula."
							+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
			}
				
			}
		}
			
		
			if (slot == 13) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_yellow")) {
						CapsuleManager.setSelectedCapsule(p, "glass_yellow");
						p.sendMessage("§aCapsula seleccionada: §eCapsula Color Amarillo");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_yellow");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_yellow");
							p.sendMessage("§aHas comprado §eCapsula Color Amarillo §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.house")) {
					CapsuleManager.setSelectedCapsule(p, "web");
					p.sendMessage("§aCapsula seleccionada: §fCapsula Tela de Araña");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.epic")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
						EconomyManager.getManager().removeMysteryDust(pm, 10000);
						CapsuleManager.setSelectedCapsule(p, "web");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.web");
						p.sendMessage("§aHas comprado §fCapsula Tela de Araña §apor §610000 Coins§a!");
					} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
				} else {
					p.sendMessage("§cYou need to be atleast §9§l[Epic] §cto Compra esta capsula. "
							+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
				}
			}
			}
		
		
			if (slot == 14) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_lime")) {
						CapsuleManager.setSelectedCapsule(p, "glass_lime");
						p.sendMessage("§aCapsula seleccionada: §aCapsula Color Lima");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_lime");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_lime");
							p.sendMessage("§aHas comprado §aCapsula Color Lima §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.jukebox")) {
					CapsuleManager.setSelectedCapsule(p, "jukebox");
					p.sendMessage("§aCapsula seleccionada: §6Capsula Jukebox");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.epic")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=10000) {
						EconomyManager.getManager().removeMysteryDust(pm, 10000);
						CapsuleManager.setSelectedCapsule(p, "jukebox");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.jukebox");
						p.sendMessage("§aHas comprado §6Capsula Jukebox §apor §610000 Coins§a!");
					} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
				} else {
					p.sendMessage("§cYou need to be atleast §9§l[Epic] §cto Compra esta capsula. "
							+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
				
				}
			}
		}
			
			
			if (slot == 15) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_pink")) {
						CapsuleManager.setSelectedCapsule(p, "glass_pink");
						p.sendMessage("§aCapsula seleccionada: §dCapsula Color Rosa");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_pink");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_pink");
							p.sendMessage("§aHas comprado §dCapsula Color Rosa §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.end")) {
					CapsuleManager.setSelectedCapsule(p, "end");
					p.sendMessage("§aCapsula seleccionada: §5Capsula §fEnd");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.epic")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=12500) {
						EconomyManager.getManager().removeMysteryDust(pm, 12500);
						CapsuleManager.setSelectedCapsule(p, "end");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.jukebox");
						p.sendMessage("§aHas comprado §5Capsula §fEnd §apor §612500 Coins§a!");
					} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
				} else {
					p.sendMessage("§cYou need to be atleast §9§l[Epic] §cto Compra esta capsula. "
							+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
				}
			}
				
		}
			
			
			if (slot == 16) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_gray")) {
						CapsuleManager.setSelectedCapsule(p, "glass_gray");
						p.sendMessage("§aCapsula seleccionada: §8Capsula Color Gris");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_gray");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_gray");
							p.sendMessage("§aHas comprado §8Capsula Color Gris §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.tank")) {
					CapsuleManager.setSelectedCapsule(p, "tank");
					p.sendMessage("§aCapsula seleccionada: §fCapsula §9Tanque");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.epic")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=15000) {
						EconomyManager.getManager().removeMysteryDust(pm, 15000);
						CapsuleManager.setSelectedCapsule(p, "tank");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.tank");
						p.sendMessage("§aHas comprado §fTanque §9Tanque §apor §615000 Coins§a!");
					} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
				} else {
					p.sendMessage("§cYou need to be atleast §9§l[Epic] §cto Compra esta capsula. "
							+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
			
				}
			}
				
				
		}
			
			
			
			
			if (slot == 17) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_lightgray")) {
						CapsuleManager.setSelectedCapsule(p, "glass_lightgray");
						p.sendMessage("§aCapsula seleccionada: §7Capsula Color Gris Claro");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_lightgray");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_lightgray");
							p.sendMessage("§aHas comprado §7Capsula Color Gris Claro §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.beacon")) {
					CapsuleManager.setSelectedCapsule(p, "beacon");
					p.sendMessage("§aCapsula seleccionada: §bCapsula Beacon");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					if (p.hasPermission("splindux.extreme")) {
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=25000) {
						EconomyManager.getManager().removeMysteryDust(pm, 25000);
						CapsuleManager.setSelectedCapsule(p, "beacon");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.beacon");
						p.sendMessage("§aHas comprado §bCapsula Beacon §apor §625000 Coins§a!");
					} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
				} else {
					p.sendMessage("§cYou need to be §5§l[Extreme] §cto Compra esta capsula. "
							+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
					
				}
				
				}
			}
				
				
		}
			
			
			if (slot == 18) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_cyan")) {
						CapsuleManager.setSelectedCapsule(p, "glass_cyan");
						p.sendMessage("§aCapsula seleccionada: §3Capsula Color Cian");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_cyan");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_cyan");
							p.sendMessage("§aHas comprado §3Capsula Color Cian §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.goldblock")) {
					CapsuleManager.setSelectedCapsule(p, "goldblock");
					p.sendMessage("§aCapsula seleccionada: §e§lCapsula de Oro");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=50000) {
						EconomyManager.getManager().removeMysteryDust(pm, 50000);
						CapsuleManager.setSelectedCapsule(p, "goldblock");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.goldblock");
						p.sendMessage("§aHas comprado §e§lCapsula de Oro §apor §650000 Coins§a!");
					} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
				
				}
			}
				
				
		}
			
			
			
			
			if (slot == 19) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_purple")) {
						CapsuleManager.setSelectedCapsule(p, "glass_purple");
						p.sendMessage("§aCapsula seleccionada: §5Capsula Color Violeta");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_purple");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_purple");
							p.sendMessage("§aHas comprado §5Capsula Color Violeta §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.lapisblock")) {
					CapsuleManager.setSelectedCapsule(p, "lapisblock");
					p.sendMessage("§aCapsula seleccionada: §1§lCapsula de Lapislazuli");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=50000) {
						EconomyManager.getManager().removeMysteryDust(pm, 50000);
						CapsuleManager.setSelectedCapsule(p, "lapisblock");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.lapisblock");
						p.sendMessage("§aHas comprado §1§lCapsula de Lapislazuli §apor §650000 Coins§a!");
					} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
					
				
				}
			}
				
				
		}
			
			
			if (slot == 20) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_blue")) {
						CapsuleManager.setSelectedCapsule(p, "glass_blue");
						p.sendMessage("§aCapsula seleccionada: §1Capsula Color Azul");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_blue");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_blue");
							p.sendMessage("§aHas comprado §1Capsula Color Azul §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.redstoneblock")) {
					CapsuleManager.setSelectedCapsule(p, "redstoneblock");
					p.sendMessage("§aCapsula seleccionada: §c§lCapsula de Redstone");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=50000) {
						EconomyManager.getManager().removeMysteryDust(pm, 50000);
						CapsuleManager.setSelectedCapsule(p, "redstoneblock");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.redstoneblock");
						p.sendMessage("§aHas comprado §c§lCapsula de Redstone §apor §650000 Coins§a!");
					} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
					
				
				}
			}
				
				
		}
			
			
			if (slot == 21) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_brown")) {
						CapsuleManager.setSelectedCapsule(p, "glass_brown");
						p.sendMessage("§aCapsula seleccionada: §6Capsula Color Marrón");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_brown");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_brown");
							p.sendMessage("§aHas comprado §6Capsula Color Marrón §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.diamondblock")) {
					CapsuleManager.setSelectedCapsule(p, "diamondblock");
					p.sendMessage("§aCapsula seleccionada: §b§lCapsula de Diamante");
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
						p.sendMessage("§aHas comprado §b§lCapsula de Diamante §apor §6100000 Coins§a!");
					}  else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
					} else {
						p.sendMessage("§cNecesitas comprar §eCapsula de Oro§c, §cCapsula de Redstone §cy §1Capsula de Lapislazuli §cprimero para comprar esta capsula.");
					}
				
				}
			}
				
				
		}
			
			
			if (slot == 22) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_green")) {
						CapsuleManager.setSelectedCapsule(p, "glass_green");
						p.sendMessage("§aCapsula seleccionada: §2Capsula Color Verde");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_green");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_green");
							p.sendMessage("§aHas comprado §2Capsula Color Verde §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.emeraldblock")) {
					CapsuleManager.setSelectedCapsule(p, "emeraldblock");
					p.sendMessage("§aCapsula seleccionada: §a§lCapsula de Esmeralda");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=50000) {
						if (p.hasPermission("splindux.capsules.diamondblock")) {
						EconomyManager.getManager().removeMysteryDust(pm, 50000);
						CapsuleManager.setSelectedCapsule(p, "emeraldblock");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.emeraldblock");
						p.sendMessage("§aHas comprado §a§lEmerald Block Capsule §apor §6200000 Coins§a!");
						} else {
							p.sendMessage("§cNecesitas comprar §bCapsula de Diamante §cprimero para comprar esta capsula.");
						}
						} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
				}
			}	
		}
			
			
			if (slot == 23) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_red")) {
						CapsuleManager.setSelectedCapsule(p, "glass_red");
						p.sendMessage("§aCapsula seleccionada: §4Capsula Color Rojo");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_red");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_red");
							p.sendMessage("§aHas comprado §4Capsula Color Rojo §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {
				if (p.hasPermission("splindux.capsules.snow")) {
					CapsuleManager.setSelectedCapsule(p, "snow");
					p.sendMessage("§aCapsula seleccionada: §f§lCapsula de Nieve");
					new CapsuleMenu(p).o(p);
				} else {
					p.closeInventory();
					PlayerManager pm = EconomyManager.getPlayerManager(p);
					if (EconomyManager.getManager().getMysteryDust(pm) >=50000) {
						EconomyManager.getManager().removeMysteryDust(pm, 50000);
						CapsuleManager.setSelectedCapsule(p, "snow");
						PermissionsEx.getUser(p).addPermission("splindux.capsules.snow");
						p.sendMessage("§aHas comprado §f§lCapsula de Nieve §apor §6500000 Coins§a!");
					} else {
						p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
					}
				}
			}	
		}
			
			
			if (slot == 24) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glass_black")) {
						CapsuleManager.setSelectedCapsule(p, "glass_black");
						p.sendMessage("§aCapsula seleccionada: §8Capsula Color Negro");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2000) {
							EconomyManager.getManager().removeMysteryDust(pm, 2000);
							CapsuleManager.setSelectedCapsule(p, "glass_black");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glass_black");
							p.sendMessage("§aHas comprado §8Capsula Color Negro §apor §62000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			
			
			if (slot == 25) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.fence")) {
						CapsuleManager.setSelectedCapsule(p, "fence");
						p.sendMessage("§aCapsula seleccionada: §eCapsula Valla");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2500) {
							EconomyManager.getManager().removeMysteryDust(pm, 2500);
							CapsuleManager.setSelectedCapsule(p, "fence");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.fence");
							p.sendMessage("§aHas comprado §eCapsula Valla §apor §62500 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			if (slot == 26) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.slab")) {
						CapsuleManager.setSelectedCapsule(p, "slab");
						p.sendMessage("§aCapsula seleccionada: §7Capsula Slab");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=2500) {
							EconomyManager.getManager().removeMysteryDust(pm, 2500);
							CapsuleManager.setSelectedCapsule(p, "slab");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.slab");
							p.sendMessage("§aHas comprado §7Capsula Slab §apor §62500 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			if (slot == 27) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.tree")) {
						CapsuleManager.setSelectedCapsule(p, "tree");
						p.sendMessage("§aCapsula seleccionada: §aCapsula Arbol");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=3000) {
							EconomyManager.getManager().removeMysteryDust(pm, 3000);
							CapsuleManager.setSelectedCapsule(p, "tree");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.tree");
							p.sendMessage("§aHas comprado §aCapsula Arbol §apor §63000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			if (slot == 28) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.leaves")) {
						CapsuleManager.setSelectedCapsule(p, "leaves");
						p.sendMessage("§aCapsula seleccionada: §2Capsula Hojas");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=3500) {
							EconomyManager.getManager().removeMysteryDust(pm, 3500);
							CapsuleManager.setSelectedCapsule(p, "leaves");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.leaves");
							p.sendMessage("§aHas comprado §2Capsula Hojas §apor §63500 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			if (slot == 29) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.cobblewall")) {
						CapsuleManager.setSelectedCapsule(p, "cobblewall");
						p.sendMessage("§aCapsula seleccionada: §7Capsula CobbleWall");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=3500) {
							EconomyManager.getManager().removeMysteryDust(pm, 3500);
							CapsuleManager.setSelectedCapsule(p, "cobblewall");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.cobblewall");
							p.sendMessage("§aHas comprado §7Capsula CobbleWall §apor §63500 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			if (slot == 30) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.diorite")) {
						CapsuleManager.setSelectedCapsule(p, "diorite");
						p.sendMessage("§aCapsula seleccionada: §fCapsula Diorita");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=4000) {
							EconomyManager.getManager().removeMysteryDust(pm, 4000);
							CapsuleManager.setSelectedCapsule(p, "diorite");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.diorite");
							p.sendMessage("§aHas comprado §fCapsula Diorita §apor §64000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			if (slot == 31) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.andesite")) {
						CapsuleManager.setSelectedCapsule(p, "andesite");
						p.sendMessage("§aCapsula seleccionada: §7Capsula Andesita");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=4000) {
							EconomyManager.getManager().removeMysteryDust(pm, 4000);
							CapsuleManager.setSelectedCapsule(p, "andesite");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.andesite");
							p.sendMessage("§aHas comprado §7Capsula Andesita §apor §64000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			if (slot == 32) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.granite")) {
						CapsuleManager.setSelectedCapsule(p, "granite");
						p.sendMessage("§aCapsula seleccionada: §6Capsula Granito");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=4000) {
							EconomyManager.getManager().removeMysteryDust(pm, 4000);
							CapsuleManager.setSelectedCapsule(p, "granite");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.granite");
							p.sendMessage("§aHas comprado §6Capsula Granito §apor §64000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			
			if (slot == 33) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.libraries")) {
						CapsuleManager.setSelectedCapsule(p, "libraries");
						p.sendMessage("§aCapsula seleccionada: §6Capsula Biblioteca");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=4500) {
							EconomyManager.getManager().removeMysteryDust(pm, 4500);
							CapsuleManager.setSelectedCapsule(p, "libraries");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.libraries");
							p.sendMessage("§aHas comprado §6Capsula Biblioteca §apor §64500 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			if (slot == 34) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.ice")) {
						CapsuleManager.setSelectedCapsule(p, "ice");
						p.sendMessage("§aCapsula seleccionada: §bCapsula Hielo");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "ice");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.ice");
							p.sendMessage("§aHas comprado §bCapsula Hielo §apor §65000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			if (slot == 35) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.quartz")) {
						CapsuleManager.setSelectedCapsule(p, "quartz");
						p.sendMessage("§aCapsula seleccionada: §fCapsula Cuerzo");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "quartz");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.quartz");
							p.sendMessage("§aHas comprado §fCapsula Cuerzo §apor §65000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			if (slot == 36) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.jail")) {
						CapsuleManager.setSelectedCapsule(p, "jail");
						p.sendMessage("§aCapsula seleccionada: §7Capsula Carcel");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "jail");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.jail");
							p.sendMessage("§aHas comprado §7Capsula Carcel §apor §65000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					}
			} else {}	
		}
			
			if (slot == 37) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.slabv2")) {
						CapsuleManager.setSelectedCapsule(p, "slabv2");
						p.sendMessage("§aCapsula seleccionada: §7Capsula Slab V2");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						if (p.hasPermission("splindux.vip")) {
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "slabv2");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.slabv2");
							p.sendMessage("§aHas comprado §7Capsula Slab V2 §apor §65000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					} else {
							p.sendMessage("§cNecesitas ser por lo menos §a§l[VIP] §cpara comprar esta capsula."
									+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
							
					}
					}
			} else {}	
		}
			
			if (slot == 38) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.nether_fence")) {
						CapsuleManager.setSelectedCapsule(p, "nether_fence");
						p.sendMessage("§aCapsula seleccionada: §4Capsula Valla del Nether");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						if (p.hasPermission("splindux.vip")) {
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "nether_fence");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.nether_fence");
							p.sendMessage("§aHas comprado §4Capsula Valla del Nether §apor §65000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					} else {
							p.sendMessage("§cNecesitas ser por lo menos §a§l[VIP] §cpara comprar esta capsula."
									+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
							
					}
					}
			} else {}	
		}
			
			if (slot == 39) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.chess")) {
						CapsuleManager.setSelectedCapsule(p, "chess");
						p.sendMessage("§aCapsula seleccionada: §fC§8a§fp§8s§fu§8l§fa §8A§fj§8e§fd§8r§fe§8z");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						if (p.hasPermission("splindux.vip")) {
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=5000) {
							EconomyManager.getManager().removeMysteryDust(pm, 5000);
							CapsuleManager.setSelectedCapsule(p, "chess");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.chess");
							p.sendMessage("§aHas comprado §fC§8a§fp§8s§fu§8l§fa §8A§fj§8e§fd§8r§fe§8z §apor §65000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					} else {
							p.sendMessage("§cNecesitas ser por lo menos §a§l[VIP] §cpara comprar esta capsula."
									+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
							
					}
					}
			} else {}	
		}
			
			if (slot == 40) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.mushroom_red")) {
						CapsuleManager.setSelectedCapsule(p, "mushroom_red");
						p.sendMessage("§aCapsula seleccionada: §cCapssula Hongo Rojo");
						new CapsuleMenu(p).o(p);
						} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "mushroom_red");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.mushroom_red");
							p.sendMessage("§aHas comprado §cCapsula Hongo Rojo §apor §66000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					
					}
			} else {}	
		}
			
			if (slot == 41) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.mushroom_brown")) {
						CapsuleManager.setSelectedCapsule(p, "mushroom_brown");
						p.sendMessage("§aCapsula seleccionada: §6Capsula Hongo Marrón");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "mushroom_brown");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.mushroom_brown");
							p.sendMessage("§aHas comprado §6Capsula Hongo Marrón §apor §66000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					
					}
			} else {}	
		}
			
			if (slot == 42) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.slimeblock")) {
						CapsuleManager.setSelectedCapsule(p, "slimeblock");
						p.sendMessage("§aCapsula seleccionada: §aCapsula Slime");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "slimeblock");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.slimeblock");
							p.sendMessage("§aHas comprado §aCapsula Slime §apor §66000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					
					}
			} else {}	
		}
		
			
			if (slot == 43) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.glowstone")) {
						CapsuleManager.setSelectedCapsule(p, "glowstone");
						p.sendMessage("§aCapsula seleccionada: §eCapsula Glowstone");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "glowstone");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.glowstone");
							p.sendMessage("§aHas comprado §eGlowstone Capsule §apor §66000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					
					}
			} else {}	
		}
			
			if (slot == 44) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.prismarine")) {
						CapsuleManager.setSelectedCapsule(p, "prismarine");
						p.sendMessage("§aCapsula seleccionada: §bCapsula Prismarina");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "prismarine");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.prismarine");
							p.sendMessage("§aHas comprado §bCapsula Prismarina §apor §66000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					
					}
			} else {}	
		}
			if (slot == 45) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.redsandstone")) {
						CapsuleManager.setSelectedCapsule(p, "redsandstone");
						p.sendMessage("§aCapsula seleccionada: §6Capsula Sandstone Roja");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						if (p.hasPermission("splindux.vip")) {
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "redsandstone");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.redsandstone");
							p.sendMessage("§aHas comprado §6Capsula Sandstone Roja §apor §66000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
						} else {
									p.sendMessage("§cNecesitas ser por lo menos §a§l[VIP] §cpara comprar esta capsula."
											+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
						}
					}
			} else {}	
		}
			
			if (slot == 46) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.sandstone")) {
						CapsuleManager.setSelectedCapsule(p, "sandstone");
						p.sendMessage("§aCapsula seleccionada: §eCapsula Sandstone");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						if (p.hasPermission("splindux.vip")) {
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=6000) {
							EconomyManager.getManager().removeMysteryDust(pm, 6000);
							CapsuleManager.setSelectedCapsule(p, "sandstone");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.sandstone");
							p.sendMessage("§aHas comprado §eCapsula Sandstone §apor §66000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
						} else {
									p.sendMessage("§cNecesitas ser por lo menos §a§l[VIP] §cpara comprar esta capsula."
											+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
						}
					}
			} else {}	
		}
			
			if (slot == 47) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.tnt")) {
						CapsuleManager.setSelectedCapsule(p, "tnt");
						p.sendMessage("§aCapsula seleccionada: §cCapsula TNT");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=7000) {
							EconomyManager.getManager().removeMysteryDust(pm, 7000);
							CapsuleManager.setSelectedCapsule(p, "tnt");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.tnt");
							p.sendMessage("§aHas comprado §cCapsula TNT §apor §67000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					
					}
			} else {}	
		}
			
			if (slot == 48) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.magma")) {
						CapsuleManager.setSelectedCapsule(p, "magma");
					p.sendMessage("§aCapsula seleccionada: §4Capsula Magma");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=7500) {
							EconomyManager.getManager().removeMysteryDust(pm, 7500);
							CapsuleManager.setSelectedCapsule(p, "magma");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.magma");
							p.sendMessage("§aHas comprado §4Capsula Magma §apor §67500 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					
					}
			} else {}	
		}
			
			if (slot == 49) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.snowgolem")) {
						CapsuleManager.setSelectedCapsule(p, "snowgolem");
						p.sendMessage("§aCapsula seleccionada: §fCapsula Golem de Nieve");
						new CapsuleMenu(p).o(p);
					} else {
						if (p.hasPermission("splindux.vip")) {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=7500) {
							EconomyManager.getManager().removeMysteryDust(pm, 7500);
							CapsuleManager.setSelectedCapsule(p, "snowgolem");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.snowgolem");
							p.sendMessage("§aHas comprado §fCapsula Golem de Nieve §apor §67500 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					
					} else {
						p.sendMessage("§cNecesitas ser por lo menos §a§l[VIP] §cpara comprar esta capsula."
								+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
					}
					}
			} else {}	
		}
			
			if (slot == 50) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.cactus")) {
						CapsuleManager.setSelectedCapsule(p, "cactus");
						p.sendMessage("§aCapsula seleccionada: §2Capsula Cactus");
						new CapsuleMenu(p).o(p);
					} else {
						if (p.hasPermission("splindux.vip")) {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=7500) {
							EconomyManager.getManager().removeMysteryDust(pm, 7500);
							CapsuleManager.setSelectedCapsule(p, "cactus");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.cactus");
							p.sendMessage("§aHas comprado §2Capsula Cactus §apor §67500 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}
					
					} else {
						p.sendMessage("§cNecesitas ser por lo menos §a§l[VIP] §cpara comprar esta capsula."
								+ "Visit the store por more info: §bhttp://splinduxstore.buycraft.net/");
					}
					}
			} else {}	
		}
			
			if (slot == 51) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.portal")) {
						CapsuleManager.setSelectedCapsule(p, "portal");
						p.sendMessage("§aCapsula seleccionada: §5Capsula Portal");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=8000) {
							EconomyManager.getManager().removeMysteryDust(pm, 8000);
							CapsuleManager.setSelectedCapsule(p, "portal");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.portal");
							p.sendMessage("§aHas comprado §5Capsula Portal §apor §68000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}				
					} 				
			} else {}	
		}
			
			if (slot == 52) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.packedice")) {
						CapsuleManager.setSelectedCapsule(p, "packedice");
						p.sendMessage("§aCapsula seleccionada: §bCapsula Hielo Compacto");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=8000) {
							EconomyManager.getManager().removeMysteryDust(pm, 8000);
							CapsuleManager.setSelectedCapsule(p, "packedice");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.packedice");
							p.sendMessage("§aHas comprado §bCapsula Hielo Compacto §apor §68000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
						}				
					} 				
			} else {}	
		}
			
			if (slot == 53) {
				if (page.get(p)==1) {
					if (p.hasPermission("splindux.capsules.sponge")) {
						CapsuleManager.setSelectedCapsule(p, "sponge");
						p.sendMessage("§aCapsula seleccionada: §eCapsula Esponja");
						new CapsuleMenu(p).o(p);
					} else {
						p.closeInventory();
						PlayerManager pm = EconomyManager.getPlayerManager(p);
						if (EconomyManager.getManager().getMysteryDust(pm) >=9000) {
							EconomyManager.getManager().removeMysteryDust(pm, 9000);
							CapsuleManager.setSelectedCapsule(p, "sponge");
							PermissionsEx.getUser(p).addPermission("splindux.capsules.sponge");
							p.sendMessage("§aHas comprado §eCapsula Esponja §apor §69000 Coins§a!");
						} else {
							p.sendMessage("§cNo tienes suficientes Coins para comprar esto.");
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
