package com.santipingui58.spleef.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Damage1_9 implements Listener { 
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		try {
			Entity p = e.getEntity();
			Entity d = e.getDamager();
	      
			ItemStack weapon = ((Player)d).getItemInHand();
			if (((p instanceof Player)) || ((d instanceof Player))) {
				if (((Player)d).getItemInHand().getType() == Material.DIAMOND_SWORD) {
					if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
						e.setDamage(7.0 + 1.25D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
						e.setDamage(7.0 + 2.5D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
						e.setDamage(7.0 + 3.75D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
						e.setDamage(7.0 + 5.0D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
						e.setDamage(7.0 + 6.25D);
					} else {
						e.setDamage(7.0);
					}
				   
				} else if (((Player)d).getItemInHand().getType() == Material.GOLD_SWORD) {
					if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
						e.setDamage(4.0 + 1.25D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
						e.setDamage(4.0 + 2.5D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
						e.setDamage(4.0 + 3.75D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
			            e.setDamage(4.0 + 5.0D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
						e.setDamage(4.0 + 6.25D);
					} else {
			            e.setDamage(4.0);
					}
				} else if (((Player)d).getItemInHand().getType() == Material.IRON_SWORD) {
					if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
						e.setDamage(6.0 + 1.25D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
						e.setDamage(6.0 + 2.5D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
						e.setDamage(6.0 + 3.75D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
						e.setDamage(6.0 + 5.0D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
						e.setDamage(6.0 + 6.25D);
					} else {
						e.setDamage(6.0);
					}
				} else if (((Player)d).getItemInHand().getType() == Material.STONE_SWORD) {
					if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
						e.setDamage(5.0 + 1.25D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
						e.setDamage(5.0 + 2.5D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
						e.setDamage(5.0 + 3.75D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
						e.setDamage(5.0 + 5.0D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
						e.setDamage(5.0 + 6.25D);
					} else {
						e.setDamage(5.0);
					}
				} else if (((Player)d).getItemInHand().getType() == Material.WOOD_SWORD) {
					if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
						e.setDamage(4.0 + 1.25D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
						e.setDamage(4.0 + 2.5D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
						e.setDamage(4.0 + 3.75D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
						e.setDamage(4.0 + 5.0D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
						e.setDamage(4.0 + 6.25D);
					} else {
						e.setDamage(4.0);
					}
				} else if (((Player)d).getItemInHand().getType() == Material.DIAMOND_AXE) {
					if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
						e.setDamage(6.0 + 1.25D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
						e.setDamage(6.0 + 2.5D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
						e.setDamage(6.0 + 3.75D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
						e.setDamage(6.0 + 5.0D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
						e.setDamage(6.0 + 6.25D);
					} else {
						e.setDamage(6.0);
					}
				} else if (((Player)d).getItemInHand().getType() == Material.GOLD_AXE) {
					if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
						e.setDamage(3.0 + 1.25D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
						e.setDamage(3.0 + 2.5D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
						e.setDamage(3.0 + 3.75D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
						e.setDamage(3.0 + 5.0D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
						e.setDamage(3.0 + 6.25D);
					} else {
						e.setDamage(3.0);
					}
				} else if (((Player)d).getItemInHand().getType() == Material.IRON_AXE) {
					if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
						e.setDamage(5.0 + 1.25D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
						e.setDamage(5.0 + 2.5D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
						e.setDamage(5.0 + 3.75D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
						e.setDamage(5.0 + 5.0D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
						e.setDamage(5.0 + 6.25D);
					} else {
						e.setDamage(5.0);
					}
				} else if (((Player)d).getItemInHand().getType() == Material.STONE_AXE) {
		        	if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
		        		e.setDamage(4.0 + 1.25D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
						e.setDamage(4.0 + 2.5D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
						e.setDamage(4.0 + 3.75D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
						e.setDamage(4.0 + 5.0D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
						e.setDamage(4.0 + 6.25D);
					} else {
						e.setDamage(4.0);
					}
				} else if (((Player)d).getItemInHand().getType() == Material.WOOD_AXE) {
					if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
						e.setDamage(3.0 + 1.25D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
						e.setDamage(3.0 + 2.5D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
						e.setDamage(3.0 + 3.75D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
						e.setDamage(3.0 + 5.0D);
					} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
						e.setDamage(3.0 + 6.25D);
					} else {
						e.setDamage(3.0);
					}
		        } else if (((Player)d).getItemInHand().getType() == Material.DIAMOND_SPADE) {
		        	if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
		        		e.setDamage(4.0 + 1.25D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
		        		e.setDamage(4.0 + 2.5D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
		        		e.setDamage(4.0 + 3.75D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
		        		e.setDamage(4.0 + 5.0D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
		        		e.setDamage(4.0 + 6.25D);
		        	} else {
		        		e.setDamage(4.0);
		        	}
		        } else if (((Player)d).getItemInHand().getType() == Material.GOLD_SPADE) {
		        	if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
		        		e.setDamage(1.0 + 1.25D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
		        		e.setDamage(1.0 + 2.5D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
		        		e.setDamage(1.0 + 3.75D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
		        	  e.setDamage(1.0 + 5.0D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
		        		e.setDamage(1.0 + 6.25D);
		        	} else {
		        		e.setDamage(1.0);
		        	}
		        } else if (((Player)d).getItemInHand().getType() == Material.IRON_SPADE) {
		        	if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
		        		e.setDamage(3.0 + 1.25D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
		        		e.setDamage(3.0 + 2.5D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
		        		e.setDamage(3.0 + 3.75D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
		        		e.setDamage(3.0 + 5.0D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
		        		e.setDamage(3.0 + 6.25D);
		        	} else {
		        		e.setDamage(3.0);
		        	}
		        } else if (((Player)d).getItemInHand().getType() == Material.STONE_SPADE) {
		        	if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
		        		e.setDamage(2.0 + 1.25D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
		        		e.setDamage(2.0 + 2.5D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
		        		e.setDamage(2.0 + 3.75D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
		        		e.setDamage(2.0 + 5.0D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
		        		e.setDamage(2.0 + 6.25D);
		        	} else {
		        		e.setDamage(2.0);
		        	}
		        } else if (((Player)d).getItemInHand().getType() == Material.WOOD_SPADE) {
		        	if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 1) {
		        		e.setDamage(1.0 + 1.25D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 2) {
		        		e.setDamage(1.0 + 2.5D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 3) {
		        		e.setDamage(1.0 + 3.75D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 4) {
		        		e.setDamage(1.0 + 5.0D);
		        	} else if (weapon.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
		        		e.setDamage(1.0 + 6.25D);
		        	} else {
		        		e.setDamage(1.0);
		        	}
		        }
			} else if ((p instanceof ArmorStand)) {
				e.setCancelled(true);
			}
	    } catch (Exception localException) {}
		
	}

}
