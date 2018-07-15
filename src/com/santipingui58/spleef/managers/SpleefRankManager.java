package com.santipingui58.spleef.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.santipingui58.spleef.Main;

public class SpleefRankManager {

	  public static String getSpleefRankChat (Player p) {
		  
		  if (Main.data.getConfig().contains("data." + p.getUniqueId())) {
			  String level = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
			 
			  if (level.equalsIgnoreCase("PrincipianteI")) {
				  return "§7[Prin. I]";	  
			  } else if (level.equalsIgnoreCase("PrincipianteII")) {
				  return "§7[Prin. II]";	  
			  } else if (level.equalsIgnoreCase("PrincipianteIII")) {
				  return "§7[Prin. III]";	  
			  }else if (level.equalsIgnoreCase("PrincipianteIV")) {
				  return "§7[Prin. IV]";	  
			  }else if (level.equalsIgnoreCase("PrincipianteV")) {
				  return "§7[Prin. V]";	  
			  } else if (level.equalsIgnoreCase("AmateurI")) {
				  return "§7[§fAmateur I§7]";	  
			  } else if (level.equalsIgnoreCase("AmateurII")) {
				  return "§7[§fAmateur II§7]";	   
			  } else if (level.equalsIgnoreCase("AmateurIII")) {
				  return "§7[§fAmateur III§7]";	 	  
			  }else if (level.equalsIgnoreCase("AmateurIV")) {
				  return "§7[§fAmateur IV§7]";	 	  
			  } else if (level.equalsIgnoreCase("AmateurV")) {
				  return "§7[§fAmateur V§7]";	 
			  } else if (level.equalsIgnoreCase("IntermedioI")) {
				  return "§7[§aInter. I§7]";	  
			  } else if (level.equalsIgnoreCase("IntermedioII")) {
				  return "§7[§aInter. II§7]";	  
			  } else if (level.equalsIgnoreCase("IntermedioIII")) {
				  return "§7[§aInter. III§7]";	  
			  }else if (level.equalsIgnoreCase("IntermedioIV")) {
				  return "§7[§aInter. IV§7]";	  
			  }else if (level.equalsIgnoreCase("IntermedioV")) {
				  return "§7[§aInter. V§7]";	  
			  } else if (level.equalsIgnoreCase("AvanzadoI")) {
				  return "§7[§2Adv. I§7]";	  
			  } else if (level.equalsIgnoreCase("AvanzadoII")) {
				  return "§7[§2Adv. II§7]";	  
			  } else if (level.equalsIgnoreCase("AvanzadoIII")) {
				  return "§7[§2Adv. III§7]";	  
			  } else if (level.equalsIgnoreCase("AvanzadoIV")) {
				  return "§7[§2Adv. IV§7]";	  
			  }else if (level.equalsIgnoreCase("AvanzadoV")) {
				  return "§7[§2Adv. V§7]";	  
			  } else if (level.equalsIgnoreCase("EliteI")) {
				  return "§7[§eElite I§7]";	  
			  }  else if (level.equalsIgnoreCase("EliteII")) {
				  return "§7[§eElite II§7]";	  
			  } else if (level.equalsIgnoreCase("EliteIII")) {
				  return "§7[§eElite III§7]";	  
			  } else if (level.equalsIgnoreCase("EliteIV")) {
				  return "§7[§eElite IV§7]";	  
			  } else if (level.equalsIgnoreCase("EliteV")) {
				  return "§7[§eElite V§7]";	  
			  } else if (level.equalsIgnoreCase("ExpertoI")) {
				  return "§7[§6Exp. I§7]";	  
			  } else if (level.equalsIgnoreCase("ExpertoII")) {
				  return "§7[§6Exp. II§7]";	  
			  }else if (level.equalsIgnoreCase("ExpertoIII")) {
				  return "§7[§6Exp. III§7]";	  
			  }else if (level.equalsIgnoreCase("ExpertoIV")) {
				  return "§7[§6Exp. IV§7]";	  
			  }else if (level.equalsIgnoreCase("ExpertoV")) {
				  return "§7[§6Exp. V§7]";	  
			  } else if (level.equalsIgnoreCase("MasterI")) {
				  return "§7[§cMaster I§7]";	  
			  } else if (level.equalsIgnoreCase("MasterII")) {
				  return "§7[§cMaster II§7]";	  
			  }else if (level.equalsIgnoreCase("MasterIII")) {
				  return "§7[§cMaster III§7]";	  
			  }else if (level.equalsIgnoreCase("MasterIV")) {
				  return "§7[§cMaster IV§7]";	  
			  }else if (level.equalsIgnoreCase("MasterV")) {
				  return "§7[§cMaster V§7]";	
			  } else if (level.equalsIgnoreCase("LeyendaI")) {
				  return "§7[§4Leyenda I§7]";	  
			  } else if (level.equalsIgnoreCase("LeyendaII")) {
				  return "§7[§4Leyenda II§7]";	  	  
			  }else if (level.equalsIgnoreCase("LeyendaIII")) {
				  return "§7[§4Leyenda III§7]";	   
			  }else if (level.equalsIgnoreCase("LeyendaIV")) {
				  return "§7[§4Leyenda IV§7]";	    
			  }else if (level.equalsIgnoreCase("LeyendaV")) {
				  return "§7[§4Leyenda V§7]";	  
			  } else if (level.equalsIgnoreCase("ChallengerI")) {
				  return "§7[§5Challenger I§7]";	  
			  } else if (level.equalsIgnoreCase("ChallengerII")) {
				  return "§7[§5Challenger II§7]";
			  }else if (level.equalsIgnoreCase("ChallengerIII")) {
				  return "§7[§5Challenger III§7]";
			  }else if (level.equalsIgnoreCase("ChallengerIV")) {
				  return "§7[§5Challenger IV§7]";
			  }else if (level.equalsIgnoreCase("ChallengerV")) {
				  return "§7[§5Challenger V§7]";
			  } else if (level.equalsIgnoreCase("VeteranI")) {
				  return "§7[§0Veteran I§7]";	  
			  } else if (level.equalsIgnoreCase("VeteranII")) {
				  return "§7[§0Veteran II§7]";	  
			  }else if (level.equalsIgnoreCase("VeteranIII")) {
				  return "§7[§0Veteran III§7]";	  
			  }else if (level.equalsIgnoreCase("VeteranIV")) {
				  return "§7[§0Veteran IV§7]";	  
			  }else if (level.equalsIgnoreCase("VeteranV")) {
				  return "§7[§0Veteran V§7]";	  
			  }else if (level.equalsIgnoreCase("VeteranVI")) {
				  return "§7[§0§lVeteran VI§7]";	  
			  } else if (level.equalsIgnoreCase("VeteranVII")) {
				  return "§7[§0§lVeteran VII§7]";	  
			  }else if (level.equalsIgnoreCase("VeteranVIII")) {
				  return "§7[§0§lVeteran VIII§7]";	  
			  }else if (level.equalsIgnoreCase("VeteranIX")) {
				  return "§7[§0§lVeteran IX§7]";	  
			  }else if (level.equalsIgnoreCase("VeteranX")) {
				  return "§a§kii§c§kii§7[§0§lVeteran X§7]§a§kii§c§kii";	  
			  }
		  }
		  return "§7[Prin. I]";
	  }
	
	  
	  public static String getSpleefRankString (int spleefrankint, boolean english) {
		  
		  if (spleefrankint ==1) { 
			  if (english) {return "§7Principiante I §7(Beginner I)";} else {return "§7Principiante I";} 
		  }
		  
		  if (spleefrankint ==2) { 
			  if (english) {return "§7Principiante II §7(Beginner II)";} else {return "§7Principiante II";} 
		  }
		  
		  if (spleefrankint ==3) { 
			  if (english) {return "§7Principiante III §7(Beginner III)";} else {return "§7Principiante III";} 
		  }
		  
		  if (spleefrankint ==4) { 
			  if (english) {return "§7Principiante IV §7(Beginner IV)";} else {return "§7Principiante IV";} 
		  }
		  
		  if (spleefrankint ==5) { 
			  if (english) {return "§7Principiante V §7(Beginner V)";} else {return "§7Principiante V";} 
		  }
		  
		  if (spleefrankint ==6) { 
			 return "§fAmateur I";
		  }
		  if (spleefrankint ==7) { 
				 return "§fAmateur II";
			  }
		  if (spleefrankint ==8) { 
				 return "§fAmateur III";
			  }
		  if (spleefrankint ==9) { 
				 return "§fAmateur IV";
			  }
		  if (spleefrankint ==10) { 
				 return "§fAmateur V";
			  }
		  if (spleefrankint ==11) { 
			  if (english) {return "§aIntermedio I §7(Medium I)";} else {return "§aIntermedio I";} 
		  }
		  if (spleefrankint ==12) { 
			  if (english) {return "§aIntermedio II §7(Medium II)";} else {return "§aIntermedio II";} 
		  }
		  if (spleefrankint ==13) { 
			  if (english) {return "§aIntermedio III §7(Medium III)";} else {return "§aIntermedio III";} 
		  }
		  if (spleefrankint ==14) { 
			  if (english) {return "§aIntermedio IV §7(Medium IV)";} else {return "§aIntermedio IV";} 
		  }
		  if (spleefrankint ==15) { 
			  if (english) {return "§aIntermedio I §7(Medium V)";} else {return "§aIntermedio V";} 
		  }
		  
		  if (spleefrankint ==16) { 
			  if (english) {return "§2Avanzado I §7(Advanced I)";} else {return "§2Avanzado I";} 
		  }
		  if (spleefrankint ==17) { 
			  if (english) {return "§2Avanzado II §7(Advanced II)";} else {return "§2Avanzado II";}
		  }
		  if (spleefrankint ==18) { 
			  if (english) {return "§2Avanzado III §7(Advanced III)";} else {return "§2Avanzado III";}
		  }
		  if (spleefrankint ==19) { 
			  if (english) {return "§2Avanzado IV §7(Advanced IV)";} else {return "§2Avanzado IV";} 
		  }
		  if (spleefrankint ==20) { 
			  if (english) {return "§2Avanzado V §7(Advanced V)";} else {return "§2Avanzado V";}
		  }

		  if (spleefrankint ==21) { 
				 return "§eElite I";
			 }
		  if (spleefrankint ==22) { 
				 return "§eElite II";
			 }
		  if (spleefrankint ==23) { 
				 return "§eElite III";
			 }
		  if (spleefrankint ==24) { 
				 return "§eElite IV";
			 }
		  if (spleefrankint ==25) { 
				 return "§eElite V";
			 }
		  
		  if (spleefrankint ==26) { 
			  if (english) {return "§6Experto I §7(Expert I)";} else {return "§6Experto I";} 
		  }
		  if (spleefrankint ==27) { 
			  if (english) {return "§6Experto II §7(Expert II)";} else {return "§6Experto II";} 
		  }
		  if (spleefrankint ==28) { 
			  if (english) {return "§6Experto III §7(Expert III)";} else {return "§6Experto III";} 
		  }
		  if (spleefrankint ==29) { 
			  if (english) {return "§6Experto IV §7(Expert IV)";} else {return "§6Experto IV";} 
		  }
		  if (spleefrankint ==30) { 
			  if (english) {return "§6Experto V §7(Expert V)";} else {return "§6Experto V";} 
		  }

		  if (spleefrankint ==31) { 
				 return "§cMaster I";
			 }
		  if (spleefrankint ==32) { 
				 return "§cMaster II";
			 }
		  if (spleefrankint ==33) { 
				 return "§cMaster III";
			 }
		  if (spleefrankint ==34) { 
				 return "§cMaster IV";
			 }
		  if (spleefrankint ==35) { 
				 return "§cMaster V";
			 }
		  
		  if (spleefrankint ==36) { 
			  if (english) {return "§4Leyenda I §7(Legend I)";} else {return "§4Legend I";} 
		  }
		  if (spleefrankint ==37) { 
			  if (english) {return "§4Leyenda II §7(Legend II)";} else {return "§4Legend II";} 
		  }
		  if (spleefrankint ==38) { 
			  if (english) {return "§4Leyenda III §7(Legend III)";} else {return "§4Legend III";} 
		  }
		  if (spleefrankint ==39) { 
			  if (english) {return "§4Leyenda IV §7(Legend IV)";} else {return "§4Legend IV";} 
		  }
		  if (spleefrankint ==40) { 
			  if (english) {return "§4Leyenda V §7(Legend V)";} else {return "§4Legend V";} 
		  }
		  
		  if (spleefrankint ==41) { 
				 return "§5Challenger I";
			 }
		  if (spleefrankint ==42) { 
				 return "§5Challenger II";
			 }
		  if (spleefrankint ==43) { 
				 return "§5Challenger III";
			 }
		  if (spleefrankint ==44) { 
				 return "§5Challenger IV";
			 }
		  if (spleefrankint ==45) { 
				 return "§5Challenger V";
			 }
		  
		  if (spleefrankint ==46) { 
			  if (english) {return "§0Veteran I §7(Veteran I)";} else {return "§0Veteran I";} 
		  }
		  if (spleefrankint ==47) { 
			  if (english) {return "§0Veteran II §7(Veteran II)";} else {return "§0Veteran II";} 
		  }
		  if (spleefrankint ==48) { 
			  if (english) {return "§0Veteran III §7(Veteran III)";} else {return "§0Veteran III";} 
		  }
		  if (spleefrankint ==49) { 
			  if (english) {return "§0Veteran IV §7(Veteran IV)";} else {return "§0Veteran IV";} 
		  }
		  if (spleefrankint ==50) { 
			  if (english) {return "§0Veteran V §7(Veteran V)";} else {return "§0Veteran V";} 
		  }
		  if (spleefrankint ==51) { 
			  if (english) {return "§0Veteran VI §7(Veteran VI)";} else {return "§0Veteran VI";} 
		  }
		  if (spleefrankint ==52) { 
			  if (english) {return "§0Veteran VII §7(Veteran VII)";} else {return "§0Veteran VII";} 
		  }
		  if (spleefrankint ==53) { 
			  if (english) {return "§0Veteran VIII §7(Veteran VIII)";} else {return "§0Veteran VIII";} 
		  }
		  if (spleefrankint ==54) { 
			  if (english) {return "§0Veteran IX §7(Veteran IX)";} else {return "§0Veteran IX";} 
		  }
		  if (spleefrankint ==55) { 
			  if (english) {return "§0Veteran X §7(Veteran X)";} else {return "§0Veteran X";} 
		  }
		  return "§7Principiante I";
	  }
	
	  
	  public static void giveExp(Player p, Integer exp) {
		  if (Main.data.getConfig().contains("data." + p.getUniqueId())) {
		  int level = Main.data.getConfig().getInt("data." + p.getUniqueId() + ".level");
		  level = level + exp;
		  Main.data.getConfig().set("data." + p.getUniqueId() + ".level", level);
		  Main.data.save();
		  checkLevel(p);  
		  }
	  }
	  
	  public static int getSpleefRankInt(String spleefrank) {
		  
		  if (spleefrank.equalsIgnoreCase("PrincipianteI")) return 1;
		  if (spleefrank.equalsIgnoreCase("PrincipianteII")) return 2;
		  if (spleefrank.equalsIgnoreCase("PrincipianteIII")) return 3;
		  if (spleefrank.equalsIgnoreCase("PrincipianteIV")) return 4;
		  if (spleefrank.equalsIgnoreCase("PrincipianteV")) return 5;
		  if (spleefrank.equalsIgnoreCase("AmateurI")) return 6;
		  if (spleefrank.equalsIgnoreCase("AmateurII")) return 7;
		  if (spleefrank.equalsIgnoreCase("AmateurIII")) return 8;
		  if (spleefrank.equalsIgnoreCase("AmateurIV")) return 9;
		  if (spleefrank.equalsIgnoreCase("AmateurV")) return 10;
		  if (spleefrank.equalsIgnoreCase("IntermedioI")) return 11;
		  if (spleefrank.equalsIgnoreCase("IntermedioII")) return 12;
		  if (spleefrank.equalsIgnoreCase("IntermedioIII")) return 13;
		  if (spleefrank.equalsIgnoreCase("IntermedioIV")) return 14;
		  if (spleefrank.equalsIgnoreCase("IntermedioV")) return 15;
		  if (spleefrank.equalsIgnoreCase("AvanzadoI")) return 16;
		  if (spleefrank.equalsIgnoreCase("AvanzadoII")) return 17;
		  if (spleefrank.equalsIgnoreCase("AvanzadoIII")) return 18;
		  if (spleefrank.equalsIgnoreCase("AvanzadoIV")) return 19;
		  if (spleefrank.equalsIgnoreCase("AvanzadoV")) return 20;
		  if (spleefrank.equalsIgnoreCase("EliteI")) return 21;
		  if (spleefrank.equalsIgnoreCase("EliteII")) return 22;
		  if (spleefrank.equalsIgnoreCase("EliteIII")) return 23;
		  if (spleefrank.equalsIgnoreCase("EliteIV")) return 24;
		  if (spleefrank.equalsIgnoreCase("EliteV")) return 25;
		  if (spleefrank.equalsIgnoreCase("ExpertoI")) return 26;
		  if (spleefrank.equalsIgnoreCase("ExpertoII")) return 27;
		  if (spleefrank.equalsIgnoreCase("ExpertoIII")) return 28;
		  if (spleefrank.equalsIgnoreCase("ExpertoIV")) return 29;
		  if (spleefrank.equalsIgnoreCase("ExpertoV")) return 30;
		  if (spleefrank.equalsIgnoreCase("MasterI")) return 31;
		  if (spleefrank.equalsIgnoreCase("MasterII")) return 32;
		  if (spleefrank.equalsIgnoreCase("MasterIII")) return 33;
		  if (spleefrank.equalsIgnoreCase("MasterIV")) return 34;
		  if (spleefrank.equalsIgnoreCase("MasterV")) return 35;
		  if (spleefrank.equalsIgnoreCase("LeyendaI")) return 36;
		  if (spleefrank.equalsIgnoreCase("LeyendaII")) return 37;
		  if (spleefrank.equalsIgnoreCase("LeyendaIII")) return 38;
		  if (spleefrank.equalsIgnoreCase("LeyendaIV")) return 39;
		  if (spleefrank.equalsIgnoreCase("LeyendaV")) return 40;
		  if (spleefrank.equalsIgnoreCase("ChallengerI")) return 41;
		  if (spleefrank.equalsIgnoreCase("ChallengerII")) return 42;
		  if (spleefrank.equalsIgnoreCase("ChallengerIII")) return 43;
		  if (spleefrank.equalsIgnoreCase("ChallengerIV")) return 44;
		  if (spleefrank.equalsIgnoreCase("ChallengerV")) return 45;
		  if (spleefrank.equalsIgnoreCase("VeteranI")) return 46;
		  if (spleefrank.equalsIgnoreCase("VeteranII")) return 47;
		  if (spleefrank.equalsIgnoreCase("VeteranIII")) return 48;
		  if (spleefrank.equalsIgnoreCase("VeteranIV")) return 49;
		  if (spleefrank.equalsIgnoreCase("VeteranV")) return 50;
		  if (spleefrank.equalsIgnoreCase("VeteranVI")) return 51;
		  if (spleefrank.equalsIgnoreCase("VeteranVII")) return 52;
		  if (spleefrank.equalsIgnoreCase("VeteranVIII")) return 53;
		  if (spleefrank.equalsIgnoreCase("VeteranIX")) return 54;
		  if (spleefrank.equalsIgnoreCase("VeteranX")) return 55;
		  
		return 1;
		  
	  }
	  
	  
	  
	  public static void checkLevel(Player p) {
		  
		  if (Main.data.getConfig().contains("data." + p.getUniqueId())) {
			  
			  int exp = Main.data.getConfig().getInt("data." + p.getUniqueId() + ".level");
			  String spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
			  
			  
			  if (exp >=500000) {
				  if (getSpleefRankInt(spleefrank) == 54) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranX");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("VeteranX")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranX");
				  Main.data.save();
				  }
				  
			  } else if (exp >=350000) {
				  if (getSpleefRankInt(spleefrank) == 53) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranIX");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("VeteranIX")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranIX");
				  Main.data.save();
				  }
				  
			  } else if (exp >=300000) {
				  if (getSpleefRankInt(spleefrank) == 52) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranVIII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("VeteranVIII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranVIII");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=250000) {
				  if (getSpleefRankInt(spleefrank) == 51) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranVII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("VeteranVII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranVII");
				  Main.data.save();
				  }
				   
			  } else if (exp >=200000) {
				  if (getSpleefRankInt(spleefrank) == 50) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranVI");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("VeteranVI")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranVI");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=180000) {
				  if (getSpleefRankInt(spleefrank) == 49) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("VeteranV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranV");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=160000) {
				  if (getSpleefRankInt(spleefrank) == 48) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranIV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("VeteranIV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranIV");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=140000) {
				  if (getSpleefRankInt(spleefrank) == 47) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranIII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("VeteranIII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranIII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=120000) {
				  if (getSpleefRankInt(spleefrank) == 46) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("VeteranII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=100000) {
				  if (getSpleefRankInt(spleefrank) == 45) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranI");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("VeteranI")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranI");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=90000) {
				  if (getSpleefRankInt(spleefrank) == 44) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("ChallengerV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=80000) {
				  if (getSpleefRankInt(spleefrank) == 43) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerIV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("ChallengerIV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerIV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=70000) {
				  if (getSpleefRankInt(spleefrank) == 42) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerIII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("ChallengerIII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerIII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=60000) {
				  if (getSpleefRankInt(spleefrank) == 41) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("ChallengerII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=60000) {
				  if (getSpleefRankInt(spleefrank) == 41) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("ChallengerII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=50000) {
				  if (getSpleefRankInt(spleefrank) == 40) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerI");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("ChallengerI")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ChallengerI");
				  Main.data.save();
				  }
				  
			  } else if (exp >=40000) {
				  if (getSpleefRankInt(spleefrank) == 39) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "LeyendaV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("LeyendaV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "LeyendaV");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=35000) {
				  if (getSpleefRankInt(spleefrank) == 38) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "LeyendaIV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("LeyendaIV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "LeyendaIV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=30000) {
				  if (getSpleefRankInt(spleefrank) == 37) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "LeyendaIII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("LeyendaIII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "LeyendaIII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=25000) {
				  if (getSpleefRankInt(spleefrank) == 36) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "LeyendaII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("LeyendaII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "LeyendaII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=20000) {
				  if (getSpleefRankInt(spleefrank) == 35) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "LeyendaI");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("LeyendaI")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "LeyendaI");
				  Main.data.save();
				  }
				  
			  } else if (exp >=18000) {
				  if (getSpleefRankInt(spleefrank) == 34) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("MasterV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=16000) {
				  if (getSpleefRankInt(spleefrank) == 33) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterIV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("MasterIV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterIV");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=14000) {
				  if (getSpleefRankInt(spleefrank) == 32) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterIII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("MasterIII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterIII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=12000) {
				  if (getSpleefRankInt(spleefrank) == 31) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("MasterII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterII");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=10000) {
				  if (getSpleefRankInt(spleefrank) == 30) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterI");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("MasterI")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterI");
				  Main.data.save();
				  }
				  
			  } else if (exp >=9000) {
				  if (getSpleefRankInt(spleefrank) == 29) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("ExpertoV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=8000) {
				  if (getSpleefRankInt(spleefrank) == 28) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoIV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("ExpertoIV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoIV");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=7000) {
				  if (getSpleefRankInt(spleefrank) == 27) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoIII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("ExpertoIII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoIII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=6000) {
				  if (getSpleefRankInt(spleefrank) == 26) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("ExpertoII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoII");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=5000) {
				  if (getSpleefRankInt(spleefrank) == 25) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoI");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("ExpertoI")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoI");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=4500) {
				  if (getSpleefRankInt(spleefrank) == 24) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("EliteV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=4000) {
				  if (getSpleefRankInt(spleefrank) == 23) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteIV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("EliteIV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteIV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=3500) {
				  if (getSpleefRankInt(spleefrank) == 22) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteIII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("EliteIII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteIII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=3000) {
				  if (getSpleefRankInt(spleefrank) == 21) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("EliteII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteII");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=2500) {
				  if (getSpleefRankInt(spleefrank) == 20) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteI");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("EliteI")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteI");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=2000) {
				  if (getSpleefRankInt(spleefrank) == 19) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("AvanzadoV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=1750) {
				  if (getSpleefRankInt(spleefrank) == 18) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoIV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("AvanzadoIV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoIV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=1500) {
				  if (getSpleefRankInt(spleefrank) == 17) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoIII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("AvanzadoIII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoIII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=1250) {
				  if (getSpleefRankInt(spleefrank) == 16) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("AvanzadoII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoII");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=1000) {
				  if (getSpleefRankInt(spleefrank) == 15) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoI");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("AvanzadoI")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoI");
				  Main.data.save();
				  }
				  
			  } else if (exp >=750) {
				  if (getSpleefRankInt(spleefrank) == 14) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("IntermedioV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioV");
				  Main.data.save();
				  }
				   
			  }  else if (exp >=650) {
				  if (getSpleefRankInt(spleefrank) == 13) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioIV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("IntermedioIV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioIV");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=550) {
				  if (getSpleefRankInt(spleefrank) == 12) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioIII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("IntermedioIII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioIII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=450) {
				  if (getSpleefRankInt(spleefrank) == 11) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("IntermedioII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=350) {
				  if (getSpleefRankInt(spleefrank) == 10) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioI");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("IntermedioI")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioI");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=300) {
				  if (getSpleefRankInt(spleefrank) == 9) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AmateurV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("AmateurV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AmateurV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=250) {
				  if (getSpleefRankInt(spleefrank) == 8) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AmateurIV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("AmateurIV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AmateurIV");
				  Main.data.save();
				  }
				  
			  }  else if (exp >=200) {
				  if (getSpleefRankInt(spleefrank) == 7) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AmateurIII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("AmateurIII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AmateurIII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=150) {
				  if (getSpleefRankInt(spleefrank) == 6) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AmateurII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("AmateurII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AmateurII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=100) {
				  if (getSpleefRankInt(spleefrank) == 5) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AmateurI");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("AmateurI")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AmateurI");
				  Main.data.save();
				  }
				  
			  } else if (exp >=80) {
				  if (getSpleefRankInt(spleefrank) == 4) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("PrincipianteV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=60) {
				  if (getSpleefRankInt(spleefrank) == 3) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteIV");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("PrincipianteIV")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteIV");
				  Main.data.save();
				  }
				  
			  } else if (exp >=40) {
				  if (getSpleefRankInt(spleefrank) == 2) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteIII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("PrincipianteIII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteIII");
				  Main.data.save();
				  }
				  
			  } else if (exp >=20) {
				  if (getSpleefRankInt(spleefrank) == 1) {
					  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteII");
					  Main.data.save();
					  spleefrank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
					  levelUpBroadcast(p,spleefrank);
				  } 
				  
				  if (!Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank").equalsIgnoreCase("PrincipianteII")) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteII");
				  Main.data.save();
				  }
				  
			  }
			  
			  
			  levelUpProgress(p);
		  }
		  }
	  
	  
	  public static void levelUpBroadcast(Player p, String spleefrank) {
		  
		  if (getSpleefRankInt(spleefrank) >= 26 || getSpleefRankInt(spleefrank) == 5  
				  || getSpleefRankInt(spleefrank) == 6
				  || getSpleefRankInt(spleefrank) == 10
				  || getSpleefRankInt(spleefrank) == 11
				  || getSpleefRankInt(spleefrank) == 15
				  || getSpleefRankInt(spleefrank) == 16
				  || getSpleefRankInt(spleefrank) == 20
				  || getSpleefRankInt(spleefrank) == 21
				  || getSpleefRankInt(spleefrank) == 25
				  ) {
		  for (Player pa : Bukkit.getOnlinePlayers()) {
			  if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
					 pa.sendMessage("§e§lSplin§b§ldux  §aFelicidades a §b"+ p.getName() + 
							 "§a por avanzar a " + getSpleefRankString(getSpleefRankInt(spleefrank), false)+ "§a!");
				 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
					 pa.sendMessage("§e§lSplin§b§ldux  §aCongratulations to §b"+ p.getName() +"§a for level up to " + getSpleefRankString(getSpleefRankInt(spleefrank), false)+ "§a!");
				 }
		  }
		  }
		  
		  
		  new BukkitRunnable() {
				@Override
				public void run() {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					  	p.sendMessage("§d§m-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
					    p.sendMessage("");
					    p.sendMessage("     §aFelicidades! Has avanzado a " + getSpleefRankString(getSpleefRankInt(spleefrank), false) + "§a!");
					    p.sendMessage("");
						p.sendMessage("§d§m-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
					  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§d§m-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
						    p.sendMessage("");
						    p.sendMessage("    §aCongratulations! You have leved up to " + getSpleefRankString(getSpleefRankInt(spleefrank), false) + "§a!");
						    p.sendMessage("");
							p.sendMessage("§d§m-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
					    }  
				}
			}.runTaskLater(Main.get(), 5L);	
			
		  
	  }
	   
	  public static void levelUpProgress(Player p) {
		  
		  p.setExp(0);
		  p.setLevel(0);
		  int current_level = DataManager.getLevel(p);
		  int next_level = 0;
		  int prev_level = 0;
		  
		  String rank = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
		  
		  if (rank.equalsIgnoreCase("PrincipianteI")) {
			  prev_level = 0;
			  next_level = 20;
		  } else  if (rank.equalsIgnoreCase("PrincipianteII")) {
			  prev_level = 20;
			  next_level = 40;
		  }  else if (rank.equalsIgnoreCase("PrincipianteIII")) {
			  prev_level = 40;
			  next_level = 60;
		  }  else if (rank.equalsIgnoreCase("PrincipianteIV")) {
			  prev_level = 60;
			  next_level = 80;
		  }  else if (rank.equalsIgnoreCase("PrincipianteV")) {
			  prev_level = 80;
			  next_level = 100;
		  }  else if (rank.equalsIgnoreCase("AmateurI")) {
			  prev_level = 100;
			  next_level = 150;
		  }  else if (rank.equalsIgnoreCase("AmateurII")) {
			  prev_level = 150;
			  next_level = 200;
		  }  else if (rank.equalsIgnoreCase("AmateurIII")) {
			  prev_level = 200;
			  next_level = 250;
		  }  else if (rank.equalsIgnoreCase("AmateurIV")) {
			  prev_level = 250;
			  next_level = 300;
		  }  else if (rank.equalsIgnoreCase("AmateurV")) {
			  prev_level = 300;
			  next_level = 350;
		  }   else if (rank.equalsIgnoreCase("IntermedioI")) {
			  prev_level = 350;
			  next_level = 450;
		  }  else if (rank.equalsIgnoreCase("IntermedioII")) {
			  prev_level = 450;
			  next_level = 550;
		  }  else if (rank.equalsIgnoreCase("IntermedioIII")) {
			  prev_level = 550;
			  next_level = 650;
		  }  else if (rank.equalsIgnoreCase("IntermedioIV")) {
			  prev_level = 650;
			  next_level = 750;
		  }  else if (rank.equalsIgnoreCase("IntermedioV")) {
			  prev_level = 750;
			  next_level = 1000;
		  } else if (rank.equalsIgnoreCase("AvanzadoI")) {
			  prev_level = 1000;
			  next_level = 1250;
		  } else if (rank.equalsIgnoreCase("AvanzadoII")) {
			  prev_level = 1250;
			  next_level = 1500;
		  } else if (rank.equalsIgnoreCase("AvanzadoIII")) {
			  prev_level = 1500;
			  next_level = 1750;
		  } else if (rank.equalsIgnoreCase("AvanzadoIV")) {
			  prev_level = 1750;
			  next_level = 2000;
		  } else if (rank.equalsIgnoreCase("AvanzadoV")) {
			  prev_level = 2000;
			  next_level = 2500;
		  }  else if (rank.equalsIgnoreCase("EliteI")) {
			  prev_level = 2500;
			  next_level = 3000;
		  } else if (rank.equalsIgnoreCase("EliteII")) {
			  prev_level = 3000;
			  next_level = 3500;
		  } else if (rank.equalsIgnoreCase("EliteIII")) {
			  prev_level = 3500;
			  next_level = 4000;
		  } else if (rank.equalsIgnoreCase("EliteIV")) {
			  prev_level = 4000;
			  next_level = 4500;
		  } else if (rank.equalsIgnoreCase("EliteV")) {
			  prev_level = 4500;
			  next_level = 5000;
		  } else if (rank.equalsIgnoreCase("ExpertoI")) {
			  prev_level = 5000;
			  next_level = 6000;
		  } else if (rank.equalsIgnoreCase("ExpertoII")) {
			  prev_level = 6000;
			  next_level = 7000;
		  } else if (rank.equalsIgnoreCase("ExpertoIII")) {
			  prev_level = 7000;
			  next_level = 8000;
		  } else if (rank.equalsIgnoreCase("ExpertoIV")) {
			  prev_level = 8000;
			  next_level = 9000;
		  } else if (rank.equalsIgnoreCase("ExpertoV")) {
			  prev_level = 9000;
			  next_level = 10000;
		  } else if (rank.equalsIgnoreCase("MasterI")) {
			  prev_level = 10000;
			  next_level = 12000;
		  } else if (rank.equalsIgnoreCase("MasterII")) {
			  prev_level = 12000;
			  next_level = 14000;
		  } else if (rank.equalsIgnoreCase("MasterIII")) {
			  prev_level = 14000;
			  next_level = 16000;
		  } else if (rank.equalsIgnoreCase("MasterIV")) {
			  prev_level = 16000;
			  next_level = 18000;
		  } else if (rank.equalsIgnoreCase("MasterV")) {
			  prev_level = 18000;
			  next_level = 20000;
		  } else if (rank.equalsIgnoreCase("LeyendaI")) {
			  prev_level = 20000;
			  next_level = 25000;
		  }  else if (rank.equalsIgnoreCase("LeyendaII")) {
			  prev_level = 25000;
			  next_level = 30000;
		  }  else if (rank.equalsIgnoreCase("LeyendaIII")) {
			  prev_level = 30000;
			  next_level = 35000;
		  }  else if (rank.equalsIgnoreCase("LeyendaIV")) {
			  prev_level = 35000;
			  next_level = 40000;
		  }  else if (rank.equalsIgnoreCase("LeyendaV")) {
			  prev_level = 40000;
			  next_level = 50000;
		  }   else if (rank.equalsIgnoreCase("ChallengerI")) {
			  prev_level = 50000;
			  next_level = 60000;
		  }  else if (rank.equalsIgnoreCase("ChallengerII")) {
			  prev_level = 60000;
			  next_level = 70000;
		  }  else if (rank.equalsIgnoreCase("ChallengerIII")) {
			  prev_level = 70000;
			  next_level = 80000;
		  }  else if (rank.equalsIgnoreCase("ChallengerIV")) {
			  prev_level = 80000;
			  next_level = 90000;
		  }  else if (rank.equalsIgnoreCase("ChallengerV")) {
			  prev_level = 90000;
			  next_level = 100000;
		  } else if (rank.equalsIgnoreCase("VeteranI")) {
			  prev_level = 100000;
			  next_level = 120000;
		  }  else if (rank.equalsIgnoreCase("VeteranII")) {
			  prev_level = 120000;
			  next_level = 140000;
		  }  else if (rank.equalsIgnoreCase("VeteranIII")) {
			  prev_level = 140000;
			  next_level = 160000;
		  }  else if (rank.equalsIgnoreCase("VeteranIV")) {
			  prev_level = 160000;
			  next_level = 180000;
		  } else if (rank.equalsIgnoreCase("VeteranV")) {
			  prev_level = 180000;
			  next_level = 200000;
		  }  else if (rank.equalsIgnoreCase("VeteranVI")) {
			  prev_level = 200000;
			  next_level = 250000;
		  }  else if (rank.equalsIgnoreCase("VeteranVII")) {
			  prev_level = 250000;
			  next_level = 300000;
		  }  else if (rank.equalsIgnoreCase("VeteranVIII")) {
			  prev_level = 300000;
			  next_level = 350000;
		  }   else if (rank.equalsIgnoreCase("VeteranIX")) {
			  prev_level = 350000;
			  next_level = 500000;
		  }  
		   
		  
		  
		  int piso = current_level - prev_level;
		  int max = next_level - prev_level;
		  
		  
		  double resultado = (double) piso/ (double) max;
		  
		  if (resultado >= 1 || resultado <= 0) {
			  resultado = 0;
		  }
		  
		  p.setExp((float) resultado);
		  p.setLevel(getSpleefRankInt(rank));
		  
		  
	  }
	  
	  
	
}
