package com.santipingui58.spleef.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;

public class SpleefRankManager {

	  public static String getSpleefRank (Player p) {
		  
		  if (Main.data.getConfig().contains("data." + p.getUniqueId())) {
			  String level = Main.data.getConfig().getString("data." + p.getUniqueId() + ".spleefrank");
			  
			  if (level.equalsIgnoreCase("PrincipianteI")) {
				  return "�7[Prin. I]";	  
			  } else if (level.equalsIgnoreCase("PrincipianteII")) {
				  return "�7[Prin. II]";	  
			  } else if (level.equalsIgnoreCase("PrincipianteIII")) {
				  return "�7[Prin. III]";	  
			  }else if (level.equalsIgnoreCase("PrincipianteIV")) {
				  return "�7[Prin. IV]";	  
			  }else if (level.equalsIgnoreCase("PrincipianteV")) {
				  return "�7[Prin. V]";	  
			  } else if (level.equalsIgnoreCase("IntermedioI")) {
				  return "�7[�fInter. I�7]";	  
			  } else if (level.equalsIgnoreCase("IntermedioII")) {
				  return "�7[�fInter. II�7]";	  
			  } else if (level.equalsIgnoreCase("IntermedioIII")) {
				  return "�7[�fInter. III�7]";	  
			  }else if (level.equalsIgnoreCase("IntermedioIV")) {
				  return "�7[�fInter. IV�7]";	  
			  }else if (level.equalsIgnoreCase("IntermedioV")) {
				  return "�7[�fInter. V�7]";	  
			  } else if (level.equalsIgnoreCase("AvanzadoI")) {
				  return "�7[�eAdv. I�7]";	  
			  } else if (level.equalsIgnoreCase("AvanzadoII")) {
				  return "�7[�eAdv. II�7]";	  
			  } else if (level.equalsIgnoreCase("AvanzadoIII")) {
				  return "�7[�eAdv. III�7]";	  
			  } else if (level.equalsIgnoreCase("AvanzadoIV")) {
				  return "�7[�eAdv. IV�7]";	  
			  }else if (level.equalsIgnoreCase("AvanzadoV")) {
				  return "�7[�eAdv. V�7]";	  
			  } else if (level.equalsIgnoreCase("EliteI")) {
				  return "�7[�6Elite I�7]";	  
			  }  else if (level.equalsIgnoreCase("EliteII")) {
				  return "�7[�6Elite II�7]";	  
			  } else if (level.equalsIgnoreCase("EliteIII")) {
				  return "�7[�6Elite III�7]";	  
			  } else if (level.equalsIgnoreCase("EliteIV")) {
				  return "�7[�6Elite IV�7]";	  
			  } else if (level.equalsIgnoreCase("EliteV")) {
				  return "�7[�6Elite V�7]";	  
			  } else if (level.equalsIgnoreCase("ExpertoI")) {
				  return "�7[�cExp I�7]";	  
			  } else if (level.equalsIgnoreCase("ExpertoII")) {
				  return "�7[�cExp II�7]";	  
			  }else if (level.equalsIgnoreCase("ExpertoIII")) {
				  return "�7[�cExp III�7]";	  
			  }else if (level.equalsIgnoreCase("ExpertoIV")) {
				  return "�7[�cExp IV�7]";	  
			  }else if (level.equalsIgnoreCase("ExpertoV")) {
				  return "�7[�cExp V�7]";	  
			  } else if (level.equalsIgnoreCase("MasterI")) {
				  return "�7[�4Master I�7]";	  
			  } else if (level.equalsIgnoreCase("MasterII")) {
				  return "�7[�4Master II�7]";	  
			  }else if (level.equalsIgnoreCase("MasterIII")) {
				  return "�7[�4Master III�7]";	  
			  }else if (level.equalsIgnoreCase("MasterIV")) {
				  return "�7[�4Master IV�7]";	  
			  }else if (level.equalsIgnoreCase("MasterV")) {
				  return "�7[�4Master V�7]";	  
			  } else if (level.equalsIgnoreCase("VeteranI")) {
				  return "�7[�0Veteran I�7]";	  
			  } else if (level.equalsIgnoreCase("VeteranII")) {
				  return "�7[�0Veteran II�7]";	  
			  }else if (level.equalsIgnoreCase("VeteranIII")) {
				  return "�7[�0Veteran III�7]";	  
			  }else if (level.equalsIgnoreCase("VeteranIV")) {
				  return "�7[�0Veteran IV�7]";	  
			  }else if (level.equalsIgnoreCase("VeteranV")) {
				  return "�7[�0Veteran V�7]";	  
			  }else if (level.equalsIgnoreCase("VeteranVI")) {
				  return "�7[�0�lVeteran VI�7]";	  
			  } else if (level.equalsIgnoreCase("VeteranVII")) {
				  return "�7[�0�lVeteran VII�7]";	  
			  }else if (level.equalsIgnoreCase("VeteranVIII")) {
				  return "�7[�0�lVeteran VIII�7]";	  
			  }else if (level.equalsIgnoreCase("VeteranIX")) {
				  return "�7[�0�lVeteran IX�7]";	  
			  }else if (level.equalsIgnoreCase("VeteranX")) {
				  return "�a�kii�c�kii�7[�0�lVeteran X�7]�a�kii�c�kii";	  
			  }
		  }
		  return "�7[Prin. I]";
	  }
	
	
	  
	
	  
	  public static void levelUp(Player p) {
		  if (Main.data.getConfig().contains("data." + p.getUniqueId())) {
			  
			  int level = Main.data.getConfig().getInt("data." + p.getUniqueId() + ".level");
			  level++;
			  p.setLevel(DataManager.getLevel(p));
			  Main.data.getConfig().set("data." + p.getUniqueId() + ".level", level);
			  Main.data.save();
			  
			  if (level == 5) {
				 Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteII");	
				 Main.data.save();
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �7Principiante II�a!");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �7Principante II�a! �7(Begginer II)");
				}
			  } else if (level == 10) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteIII");	
					 Main.data.save();
					 
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �7Principiante III�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �7Principante III�a! �7(Begginer III)");
						}
					 
			  } else if (level == 20) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteIV");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �7Principiante IV�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �7Principante IV�a! �7(Begginer IV)");
						}
			  } else if (level == 30) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "PrincipianteV");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �7Principiante V�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �7Principante V�a! �7(Begginer V)");
						}
			  } else if (level == 40) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioI");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �fIntermedio I�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �fIntermedio I�a! �7(Medium I)");
						}
			  } else if (level == 50) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioII");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �fIntermedio II�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �fIntermedio II�a! �7(Medium II)");
						}
			  } else if (level == 75) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioIII");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �fIntermedio III�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �fIntermedio III�a! �7(Medium III)");
						}
			  } else if (level == 100) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioIV");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �fIntermedio IV�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �fIntermedio IV�a! �7(Medium IV)");
						}
			  } else if (level == 125) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "IntermedioV");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a  �fIntermedio V�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �fIntermedio V�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �fIntermedio V�a! �7(Medium V)");
					 }
					 } 
					 
			  } else if (level == 150) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoI");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �eAvanzado I�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �eAvanzado I�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �eAvanzado I�a! �7(Advanced I)");
					 }
					 } 
			  } else if (level == 175) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoII");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �eAvanzado II�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �eAvanzado II�a! �7(Advanced II)");
						}
			  }  else if (level == 200) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoIII");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �eAvanzado III�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �eAvanzado III�a! �7(Advanced III)");
						}
			  }  else if (level == 250) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoIV");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �eAvanzado IV�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �eAvanzado IV�a! �7(Advanced IV)");
						}
			  }  else if (level == 300) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "AvanzadoV");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �eAvanzado V�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �eAvanzado V�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �eAvanzado V�a! �7(Advanced V)");
					 }
					 } 
					 
			  }  else if (level == 400) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteI");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �6Elite I�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �6Elite I�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �6Elite I�a!");
					 }
					 } 
			  }  else if (level == 500) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteII");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �6Elite II�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �6Elite II�a!");
						}
			  }  else if (level == 600) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteIII");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �6Elite III�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �6Elite III�a!");
						}
			  }  else if (level == 700) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteIV");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �6Elite IV�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �6Elite IV�a!");
						}
			  }  else if (level == 800) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "EliteV");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �6Elite V�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �6Elite V�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �6Elite V�a!");
					 }
					 }
			  }  else if (level == 1000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoI");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �cExperto I�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �cExperto I�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �cExperto I�a! �7(Expert I)");
					 }
					 }
			  }  else if (level == 1250) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoII");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �cExperto II�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �Experto II�a! �7(Expert II)");
						}
			  }  else if (level == 1500) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoIII");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �cExperto III�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �Experto III�a! �7(Expert III)");
						}
			  }  else if (level == 1750) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoIV");	
					 Main.data.save();
					 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						 p.sendMessage("�e�lSplin�b�ldux  �aFelicidades! Has avanzado a �cExperto IV�a!");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							 p.sendMessage("�e�lSplin�b�ldux  �aCongratulations! You have leved up to �Experto IV�a! �7(Expert IV)");
						}
			  }  else if (level == 2000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "ExpertoV");	
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �cExperto V�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �cExperto V�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �cExperto V�a! �7(Expert V)");
					 }
					 }
					 Main.data.save();
			  }  else if (level == 3000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterI");	
					 Main.data.save();
					 
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �4Master I�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �4Master I�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �4Master I�a!");
					 }
					 }
					 
			  }  else if (level == 3500) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterII");	
					 Main.data.save();
					 
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �4Master II�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �4Master II�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �4Master II�a!");
					 }
					 }
					 
			  }  else if (level == 4000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterIII");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �4Master III�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �4Master III�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �4Master III�a!");
					 }
					 }
					 
			  }  else if (level == 4500) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterIV");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �4Master IV�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �4Master IV�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �4Master IV�a!");
					 }
					 }
			  }  else if (level == 5000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "MasterV");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �4Master V�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �4Master V�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �4Master V�a!");
					 }
					 }
			  }  else if (level == 6000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranI");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran I�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran I�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �0VeteranI�a!");
					 }
					 }
			  } else if (level == 7000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranII");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran II�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran II�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �0Veteran II�a!");
					 }
					 }
			  }  else if (level == 9000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranIII");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �0Veteran III�a!");
					 }
					 }
			  } else if (level == 12000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranIV");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �0Veteran III�a!");
					 }
					 }
			  } else if (level == 16000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranV");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �0Veteran III�a!");
					 }
					 }
			  } else if (level == 20000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranVI");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �0Veteran III�a!");
					 }
					 }
			  } else if (level == 25000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranVII");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �0Veteran III�a!");
					 }
					 }
			  } else if (level == 31000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranVIII");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �0Veteran III�a!");
					 }
					 }
			  } else if (level == 38000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranIX");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran III�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �0Veteran III�a!");
					 }
					 }
			  } else if (level == 50000) {
				  Main.data.getConfig().set("data." + p.getUniqueId() + ".spleefrank", "VeteranX");	
					 Main.data.save();
					 Bukkit.getConsoleSender().sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran X�a!");
					 for (Player pa : Bukkit.getOnlinePlayers()) {
						 if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aFelicidades a �b"+ p.getName() + "�a por avanzar a �0Veteran X�a!");
					 } else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
						 pa.sendMessage("�e�lSplin�b�ldux  �aCongratulations to �b"+ p.getName() +"�a for level up to �0Veteran X�a!");
					 }
					 }
			  } 
			    
			  
		  }
	  }
	
	
	
}