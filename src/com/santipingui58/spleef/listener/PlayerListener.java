package com.santipingui58.spleef.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BlockIterator;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.commands.AfkCommand;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.managers.PartyManager;
import com.santipingui58.spleef.menu.esp.OptionsMenu;
import com.santipingui58.spleef.menu.esp.RankedMenu;
import com.santipingui58.spleef.menu.esp.UnrankedMenu;

import net.apcat.simplesit.SimpleSitPlayer;
import net.apcat.simplesit.events.PlayerSitEvent;
import net.apcat.simplesit.events.PlayerStopSittingEvent;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_11_R1.PacketPlayOutMount;




@SuppressWarnings("deprecation")
public class PlayerListener implements Listener {

	public static HashMap<Player, Location> location = new HashMap<Player,Location>();
	public static HashMap<Player, HashMap<Player, List<Integer>>> ffalocation = new HashMap<Player,HashMap<Player, List<Integer>>>();
	public static HashMap<Player,Integer> afkqueue = new HashMap<Player, Integer>();
	public static HashMap<Player,Integer> antiAfkFFA = new HashMap<Player, Integer>();
	
	public static List<Player> antiSpam = new ArrayList<Player>();
	
	
	
	
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public static void onInteract(final PlayerInteractEvent e) {
		
		if (e.getPlayer().getGameMode().equals(GameMode.SPECTATOR)) {
			e.setCancelled(true);
		}
		
		if (GameManager.getManager().isSpectating(e.getPlayer())) {
			e.setCancelled(true);
		}
		
		   if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		    {
		      if ((e.getPlayer().getGameMode() != GameMode.CREATIVE) && (
		        (e.getClickedBlock().getType().equals(Material.TRAP_DOOR)) || 
		        (e.getClickedBlock().getType().equals(Material.ENCHANTMENT_TABLE)) || 
		        (e.getClickedBlock().getType().equals(Material.ANVIL)) || 
		        (e.getClickedBlock().getType().equals(Material.WORKBENCH)) || 
		        (e.getClickedBlock().getType().equals(Material.FENCE)) || 
		        (e.getClickedBlock().getType().equals(Material.CHEST)) || 
		        (e.getClickedBlock().getType().equals(Material.ACACIA_DOOR)) || 
		        (e.getClickedBlock().getType().equals(Material.BIRCH_DOOR)) || 
		        (e.getClickedBlock().getType().equals(Material.DARK_OAK_DOOR)) || 
		        (e.getClickedBlock().getType().equals(Material.JUNGLE_DOOR)) || 
		        (e.getClickedBlock().getType().equals(Material.SPRUCE_DOOR)) || 
		        (e.getClickedBlock().getType().equals(Material.WOOD_DOOR)) || 
		        (e.getClickedBlock().getType().equals(Material.CHEST)) || 
		        (e.getClickedBlock().getType().equals(Material.ENDER_CHEST)) || 
		        (e.getClickedBlock().getType().equals(Material.FENCE_GATE)) || 
		        (e.getClickedBlock().getType().equals(Material.ACACIA_FENCE_GATE)) || 
		        (e.getClickedBlock().getType().equals(Material.SPRUCE_FENCE_GATE)) || 
		        (e.getClickedBlock().getType().equals(Material.BIRCH_FENCE_GATE)) || 
		        (e.getClickedBlock().getType().equals(Material.JUNGLE_FENCE_GATE)) || 
		        (e.getClickedBlock().getType().equals(Material.DARK_OAK_FENCE_GATE))))
		      {
		        e.setCancelled(true);
		      }
		    }
		
		   if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			   Block b = e.getClickedBlock();
			   if (b.getType() == Material.SIGN_POST || b.getType() == Material.WALL_SIGN) {
				  Sign sign = (Sign) b.getState();
				  if (sign.getLine(1).equalsIgnoreCase("§4§lINFO")) {
				  if (sign.getLine(2).equalsIgnoreCase("§2§l[Staff]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lStaff§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§7El Staff es un grupo de personas encargadas de mantener el Server así como "
						  		+ "de cuidar la comunidad de esta. Son aquellos que hacen que se respeten las reglas, y"
						  		+ "tambien de traer novedades al Server. Puedes ver los Staffs actuales detrás tuyo. "
						  		+ "Si tienes un problema o una consulta, no dudes en contactar a uno, siempre tratamos"
						  		+ "de brindar la mejor atención a los Usuarios!");
						  		e.getPlayer().sendMessage("§7Si estás interesado en ser Staff, puedes hacer tu "
						  				+ "solicitud aquí: §bhttps://goo.gl/paGdwZ");
						  	e.getPlayer().sendMessage("§7Los diferentes rangos del Staff son: §9[Helper] §2[Moderator] "
						  			+ "§c[Admin] §4[CoOwner] §7 y §4[Owner]");
					  }
					  
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lStaff§c]-=-=-=-");
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[Contact]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lContact§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
					  e.getPlayer().sendMessage("§7Si necesitas contactar a un miembro del Staff por cualquier razón, "
					  		+ "puedes intentar mandarle un mensaje aquí en el Server de Minecraft, pero de no haber "
					  		+ "ninguno conectado, puedes intentar mandarle un mensaje en el foro (§ahttp://www.splindux.com/§7) o también"
					  		+ "por el Server de Discord (§ahttps://discord.gg/JkbCaxf§7). Este ultimo será el más eficiente.");
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lContact§c]-=-=-=-");
					  }
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[Rules]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lRules§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§71 - Respetar al resto de usuarios la comunidad.");
						  e.getPlayer().sendMessage("§72 - El uso de hacks y/o mods ilegales está completamente prohibido.");
						  e.getPlayer().sendMessage("§73 - Prohibido aprovecharse de bugs o glitches.");
						  e.getPlayer().sendMessage("§74 - Esta prohibido cualquier tipo de contenido que no sea apto para todo publico.");
						  e.getPlayer().sendMessage("§75 - Está prohibido hacer publicidad o Spam de otros Servers o cualquier cosa no relacionada con Splindux");
						  e.getPlayer().sendMessage("§76 - Prohibido aprovecharse de bugs o glitches.");
						  e.getPlayer().sendMessage("§77 - El Spam y Flood están prohibidos.");
						  e.getPlayer().sendMessage("§7Para ver las reglas completas, visita el Server de Discord y ve el canal de reglas: §ahttps://discord.gg/JkbCaxf§7");
					  }
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lRules§c]-=-=-=-");
				  }  else if (sign.getLine(2).equalsIgnoreCase("§2§l[Commands]")) {
					  
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lCommands§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
					  e.getPlayer().sendMessage("§5Relacionados con Spleef");
					  e.getPlayer().sendMessage("§a/duel §7- Retar a otros jugadores a una partida de Spleef");
					  e.getPlayer().sendMessage("§a/reset §7- Reiniciar Arena de Spleef");
					  e.getPlayer().sendMessage("§a/crumble §7- Crumblear la arena de Spleef");
					  e.getPlayer().sendMessage("§a/endgame §7- Solicitar terminar la partida de Spleef");
					  e.getPlayer().sendMessage("§a/playto §7- Poner el máximo de puntos para ganar una partida (Default:5)");
					  e.getPlayer().sendMessage("§a/spect §7- Espectar la partida de otro jugador");
					  e.getPlayer().sendMessage("§a/stats §7- Ver tus estadísticas");
					  e.getPlayer().sendMessage("§a/stats  top <ffaspleef|spleef> §7- Ver el TOP de cada modalidad");
					  e.getPlayer().sendMessage("§a/stats §7- Ver tus estadísticas");
					  e.getPlayer().sendMessage("§a/ranking §7- Ver el Ranking ASP");
					  e.getPlayer().sendMessage("§a/ranking <pais> §7- Ver el Ranking ASP por país");
					  e.getPlayer().sendMessage("§5Generales");
					  e.getPlayer().sendMessage("§a/msg <jugador> <mensaje> §7- Mandar un mensaje privado a un jugador");
					  e.getPlayer().sendMessage("§a/r§7- Contestar al último mensaje que te hayan enviado");
					  e.getPlayer().sendMessage("§a/leave §7- Salir de todas las colas o partidas");
					  e.getPlayer().sendMessage("§a/ping §7- Ver tu conexión al Server en milisegundos");
					  e.getPlayer().sendMessage("§a/ping all §7- Ver la conexión de todos los jugadores conectados");
					  e.getPlayer().sendMessage("§a/skin §7- Ponerte la Skin de otra persona");
					  e.getPlayer().sendMessage("§a/afk §7-  Avisar que estarás AFK §6(Donadores)");
					  e.getPlayer().sendMessage("§a/fly §7-  Volar en el Lobby §6(Donadores)");
					  e.getPlayer().sendMessage("§a/head §7-  Usar la cabeza de cualquier jugador §6(Donadores)");
					  e.getPlayer().sendMessage("§a/sit §7- Sentarse en el suelo §6(Donadores)");
					  e.getPlayer().sendMessage("§a/ride §7- Montar a un jugador §6(Donadores)");
					  e.getPlayer().sendMessage("§a/d §7- Disfrazarte de un Mob en el Lobby §6(Donadores)");
					  
					  } 
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lCommands§c]-=-=-=-");
					  
				  }  else if (sign.getLine(2).equalsIgnoreCase("§2§l[Report]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lReport§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
					  e.getPlayer().sendMessage("§7Si has visto a un usuario haciendo algo indebido o quieres quejarte de "
					  		+ "algo que ocurrió en el server? En ese caso lo mejor que puedes hacer es hacer una denuncia y/o "
					  		+ "queja en el foro (§ahttps://splindux.enjin.com/forum§7) con PRUEBAS, ya sean fotos o videos. "
					  		+ "También puedes mandarle las pruebas directamente a un Staff y hablarlo en privado.");
				  } else if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ENG")) {
					  
				  }
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lReport§c]-=-=-=-");
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[Rankeds]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lRankeds§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§7Las partidas Rankeds son partidas de Spleef en las que cuenta "
						  		+ "el sistema de ELO. Por cada partida que ganes o pierdas, tu ELO variará. Los usuarios "
						  		+ "normales pueden jugar hasta 10 partidas Rankeds por día, los §aVips §715, los §9Epic §7 20 "
						  		+ "y los §5Extreme §7 30. Las partidas Rankeds son válidas para el TOP y también para el Ranking ASP.");
					  }
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lRankeds§c]-=-=-=-");
					  
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[Spleef]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lSpleef§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§7Spleef es un juego competitivo que consiste en destruir los "
						  		+ "bloques para hacer que tu(s) oponente(s)  se caiga. La única regla, es que está "
						  		+ "prohibido campear, véase, encerrarse a propósito sin la posibilidad de que "
						  		+ "tu oponente te tire. Hay varios modos, el más tradicional es el Snow Spleef, que "
						  		+ "consta de una pala y una arena hecha de bloques de nieve. También existe BowSpleef, "
						  		+ "en la que se le da a los jugadores arcos encantados con Llama, para que activen TNTs "
						  		+ "que se encuentren en la arena para hacerlas caer. Se pueden jugar de a 1vs1, 2vs2, FFA (Todos contra todos), etc.");
					  }
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lSpleef§c]-=-=-=-");
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[Coins]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lCoins§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§7Hay dos tipos de monedas en el Servidor, las §6Coins §7 y las §3SplinduxCoins ($C)§7. "
						  		+ "Las primeras son las monedas más comunes, sirven para comprar cosméticos y Gadgets, y se consiguen "
						  		+ "jugando y ganando partidas de Spleef en cualquier modalidad. Las SplinduxCoins, son más raras, se pueden "
						  		+ "ganar en eventos y torneos, o también comprarlas en la tienda (§ahttp://splinduxstore.buycraft.net/§7). Estas "
						  		+ "sirven para comprar comandos de rangos donadores, cosméticos, gadgets, y hasta rangos. Su gran ventaja es que "
						  		+ "se precio en la tienda es de apenas $0,12 por cada moneda, por lo que se pueden comprar, por ejemplo, con crédito "
						  		+ "de celular. En un futuro también se podrán canjear por tarjetas prepagas de PayPal.");
					  }
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lCoins§c]-=-=-=-");
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[ELO]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lELO§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§7El ELO es un sistema de puntuación y rankeo que se encuentra en las "
						  		+ "partidas Rankeds. Al entrar por primera vez al Server, tendrás un ELO de 1000. Si ganas "
						  		+ "una partida Ranked, este aumentará, y si pierdes, este descenderá. La variación está relacionada "
						  		+ "con el ELO de tu oponente, por ejemplo, si tienes 1000 de ELO y le ganas a alguien de 1500 de ELO, "
						  		+ "ganarás más ELO que si al oponente que le ganaste tenía 700 de ELO. También la diferencia de resultado "
						  		+ "será otra variable. El ELO se reinicia cada Season.");
					  }
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lELO§c]-=-=-=-");
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[Party]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lParty§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§7Las Parties sirven por si quieres jugar con tus amigos "
						  		+ "de una forma más cómoda, podiendo tener un chat privado con ellos y jugar a las "
						  		+ "mismas modalidades. Las Parties están todavía en desarrollo, en un futuro se podrán "
						  		+ "desafiar a otras Parties a una partida de Spleef.");
					  }
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lParty§c]-=-=-=-");
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[Ranking]")) {
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§c-=-=-=-[§2§lRanking§c]-=-=-=-");
						  e.getPlayer().sendMessage("§7El Ranking ASP es el Top más importante del Server. Este se actualiza "
						  		+ "el primer día de cada mes, y tiene una actualización mayor en el inicio de cada Season. Este "
						  		+ "Ranking se basa en el desempeño de los jugadores tanto en torneos, como en partidas Rankeds y "
						  		+ "el nivel de SpleefRank que tiene cada uno. En la actualización mensual se agregan los puntos obtenidos "
						  		+ "por torneos, mientras que cuando una Season termina, los puntos de ELO y el 33% de puntos de la temporada "
						  		+ "anterior se suman. El Ranking se puede ver con el comando /ranking.");
						  e.getPlayer().sendMessage("§c-=-=-=-[§2§lRanking§c]-=-=-=-");
					  }
					  
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[Seasons]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lSeasons§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§7Las Seasons son periodos de 3 meses, en los cuales al final de cada una, "
						  		+ "los mejores jugadores de Top de ELO recibirán los premios que se pactaron al inicio de una Season. "
						  		+ " Si quieres ver en que temporada el Server se encuentra, puedes verlo en el Item de §6Torneos§7. Al final "
						  		+ "de cada Season, también se darán los puntos por Top de ELO para el Ranking ASP. ");
					  }
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lSeasons§c]-=-=-=-");
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[Tourneys]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lTourneys§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§7En Splindux tratamos de ofrecer una experiencia competitiva, por lo tanto "
						  		+ "los torneos son algo frecuente. Generalmente cada semana por lo menos habrá un torneo. Hay 2 "
						  		+ "tipos de torneos, los oficiales y los no oficiales. Los oficiales están divididos en MiniTorneos "
						  		+ "y Torneos principales, los primeros son aquellos que se realizan en un corto lapso, por ejemplo, 1 día. "
						  		+ "Un ejemplo son los torneos semanales, que ocurren todas las semanas en Viernes, Sábado o Domingo. "
						  		+ "Los torneos principales son torneos con más cantidad de gente y con mayor organización, estos suelen "
						  		+ "durar aproximadamente un mes, y a diferencia de los semanales, a estos tiene que inscribirte en el Foro. "
						  		+ "Los torneos no oficiales son torneos espontáneos con el único objetivo de entretener, ya que no "
						  		+ "cuentan por puntos ASP ni como torneo ganado. Si quieres estar atento a cuando serán los siguientes "
						  		+ "torneos, lo mejor es que estés atento al Discord (§ahttps://discord.gg/JkbCaxf§7), ya que ahí se"
						  		+ "anuncian todos los torneos próximos.");
						  
					  }
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lTourneys§c]-=-=-=-");
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[Ranks]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lRanks§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§7Los rangos donadores tienen diferentes beneficios, tanto decorativos, "
						  		+ "como InGame, como pueden ser la posibilidad de tener más Rankeds por día. Los donadores ayudan "
						  		+ "a mantener el Servidor funcionando y pudiendo brindar un mejor servicio, así como aumentar los premios "
						  		+ "por Season. Para ver más información de los rangos, visita la tienda (§ahttp://splinduxstore.buycraft.net/§f)");
					  }
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lRanks§c]-=-=-=-");
				  } else if (sign.getLine(2).equalsIgnoreCase("§2§l[SpleefRank]")) {
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lSpleefRank§c]-=-=-=-");
					  if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						  e.getPlayer().sendMessage("§7Si notaste tu prefijo en el Chat cuando hablas, ese es tu rango de Spleef. "
						  		+ "Este es un sistema de nivelación que te premia por jugar más tiempo en el Server, no por habilidad. "
						  		+ "Por cada vez que juegues o ganes una partida, ganarás experiencia, que te ayudará a subir de nivel. "
						  		+ "Tu nivel está indicado en la barra de experiencia, ásí como el progreso para pasar al próximo nivel. "
						  		+ "Hay algunos cosméticos que solo pueden comprarse habiendo alcanzado cierto nivel, y también sirven para "
						  		+ "calcular el Ranking ASP.");
					  }
					  e.getPlayer().sendMessage("§c-=-=-=-[§2§lSpleefRank§c]-=-=-=-");
				  }
				  

				  
				  }
			   }
		    }
			
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			
			
			if (!antiSpam.contains(e.getPlayer())) {
				antiSpam.add(e.getPlayer());

				
				new BukkitRunnable() {
					@Override
					public void run() {
						antiSpam.remove(e.getPlayer());
					}
				}.runTaskLater(Main.get(), 10L);	
					
	
			if(e.getPlayer().getItemInHand().equals(Game.rankeditemesp)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				if (DataManager.getRankeds(e.getPlayer()) >= 1) {
				new RankedMenu(e.getPlayer()).o(e.getPlayer()); 
				} else {
					if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						e.getPlayer().sendMessage("§cNo tienes más Rankeds para jugar.");
						e.getPlayer().sendMessage("§bVota para conseguir más Rankeds: /votar");
					} else if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ENG")) {
						e.getPlayer().sendMessage("§cYou do not have rankeds left to play.");
						e.getPlayer().sendMessage("§bVote to win more rankeds: /vote");
					}
				}
			} 
			if(e.getPlayer().getItemInHand().equals(Game.rankeditemeng)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				if (DataManager.getRankeds(e.getPlayer()) >= 1) {
				new com.santipingui58.spleef.menu.eng.RankedMenu(e.getPlayer()).o(e.getPlayer()); 
				} else {
					if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ESP")) {
						e.getPlayer().sendMessage("§cNo tienes más Rankeds para jugar.");
						e.getPlayer().sendMessage("§bVota para conseguir más Rankeds: /votar");
					} else if (DataManager.getLang(e.getPlayer()).equalsIgnoreCase("ENG")) {
						e.getPlayer().sendMessage("§cYou do not have rankeds left to play.");
						e.getPlayer().sendMessage("§bVote to win more rankeds: /vote");
					}
				}
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.unrankeditemesp)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				new UnrankedMenu(e.getPlayer()).o(e.getPlayer());
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.unrankeditemeng)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				new com.santipingui58.spleef.menu.eng.UnrankedMenu(e.getPlayer()).o(e.getPlayer());
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.giftsesp)) {
				e.getPlayer().sendMessage("§cProximamente...");
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.giftseng)) {
				e.getPlayer().sendMessage("§cComing soon...");
			} 
		
			if(e.getPlayer().getItemInHand().equals(Game.opcionesesp)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				new OptionsMenu(e.getPlayer()).o(e.getPlayer());
				return;
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.opcioneseng)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				new com.santipingui58.spleef.menu.eng.OptionsMenu(e.getPlayer()).o(e.getPlayer());
				return;
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.partiesesp)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				if (PartyManager.getManager().isInParty(e.getPlayer())) {
					new com.santipingui58.spleef.menu.eng.PartyMenu(e.getPlayer()).o(e.getPlayer());
				} else {
						e.getPlayer().sendMessage("§cNecesitas estar en una Party para usar este Item. Crea una invitando jugadores con "
								+ "§3/party invite <Jugador>");
				}
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.partieseng)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				if (PartyManager.getManager().isInParty(e.getPlayer())) {
					new com.santipingui58.spleef.menu.eng.PartyMenu(e.getPlayer()).o(e.getPlayer());
				} else {
						e.getPlayer().sendMessage("§cYou need to be in a Party to use this Item. Create one inviting players with "
								+ "§3/party invite <Player>");
					
				}
			} 
			
			
			if(e.getPlayer().getItemInHand().equals(Game.leavequeueeng)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				GameManager.getManager().leaveQueue(e.getPlayer(),true,true);
				return;
			} 
			
			if(e.getPlayer().getItemInHand().equals(Game.leavequeueesp)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				GameManager.getManager().leaveQueue(e.getPlayer(),true,true);
				return;
			} 
			
			
			if(e.getPlayer().getItemInHand().equals(Game.gadgetseng)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				new com.santipingui58.spleef.menu.eng.GadgetsMenu(e.getPlayer()).o(e.getPlayer());
				return;
			} 
			if(e.getPlayer().getItemInHand().equals(Game.gadgetsesp)) {
				for (Entity en : e.getPlayer().getPassengers()) {
					if (en instanceof Player) {
						e.getPlayer().eject();
						en.eject();
		 			PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer)e.getPlayer()).getHandle());
		            ((CraftPlayer)e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
				}
				}
				new com.santipingui58.spleef.menu.esp.GadgetsMenu(e.getPlayer()).o(e.getPlayer());
				return;
			} 
			
		} else {
			
		}
			
			}
	}
	
	

	@EventHandler
	  public void onProjectileHit(ProjectileHitEvent e)  {
	    Player p = (Player)e.getEntity().getShooter();
	    if (GameManager.getManager().isInGame(p)) {
	    	if (GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("BuildSpleefPvP")) {
				return;
			}
	    	
	    	if (GameManager.getManager().getArenabyPlayer(p).getCanPlay()) {
	    BlockIterator iterator = new BlockIterator(e.getEntity().getWorld(), e.getEntity().getLocation().toVector(), e.getEntity().getVelocity().normalize(), 0.0D, 4);
	    Block hitblock = null;
	    while (iterator.hasNext()) {
	      hitblock = iterator.next();

	      if (hitblock.getTypeId() != 0)
	      {
	        break;
	      }
	    }
	    if (hitblock.getType() == Material.SNOW_BLOCK)
	    {
	      p.playSound(hitblock.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.5F, 2.0F);
	      hitblock.setType(Material.AIR);
	    } else if (hitblock.getType()== Material.TNT) {

	    	 new BukkitRunnable() {
					@Override
					public void run() {
						e.getEntity().remove();
					}
				}.runTaskLater(Main.get(), 5L);	
	    	
	    }
	    
	    	}
	  } 
	    }
	
	
	public void onBow(EntityShootBowEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (GameManager.getManager().isInGame(p)) {
				Game g = GameManager.getManager().getArenabyPlayer(p);
				if (g.getType().equalsIgnoreCase("bowspleef")) {
					if (!g.getCanPlay()) {
						e.setCancelled(true);
					}
				}
			}
		}
	}
	  
	  @EventHandler 
	  public void onExitSeat(VehicleExitEvent e) {
		  Player p = (Player) e.getExited();
		  SimpleSitPlayer player = new SimpleSitPlayer(p);
		  if (player.isSitting()) {
			  player.setSitting(false);
		  }
		  if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			  p.sendMessage("§cTe has parado");
		  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			  p.sendMessage("§cYou have stood up");
		  }
		  
	  }
	  
	  
	  @EventHandler
	  public void onSit(PlayerSitEvent e) {
		  Player p = e.getPlayer();
		  if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			  e.setMessage("§aTe has sentado");
		  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			  e.setMessage("§aYou have sat");
		  }
	  }
	  
	  
	  @EventHandler
	  public void onExitSit(PlayerStopSittingEvent e) {
		  Player p = e.getPlayer();
		  if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			  e.setMessage("§cTe has levantado");
		  } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			  e.setMessage("§cYou have stood up");
		  }
	  }
	  
	
	
	@EventHandler
	public static void onCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		afkqueue.remove(p);
		
		 String msg = e.getMessage();
		    String[] args = msg.split(" ");
		    if ((args.length >= 1) && 
		      (args[0].startsWith("/"))) {

		    	
		    	if (args[0].equalsIgnoreCase("/plugins") || args[0].equalsIgnoreCase("/pl")) {
			        	 e.getPlayer().sendMessage("§fPlugins(2): §aSplinduxSpleef§f, §aSlenderSeLaCome");
					        e.setCancelled(true);
			        
			      }
   	
		    	if (args[0].equalsIgnoreCase("/lay")) {
				        e.setCancelled(true);
		      }
		    	
		    	if (args[0].equalsIgnoreCase("/d") || args[0].equalsIgnoreCase("/disguise")) {
		    		if (GameManager.getManager().isInGame(p)) {
		    			e.setCancelled(true);
		    			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cNo puedes ejecutar este comando dentro de una partida.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cYou can't execute this command while playing a match.");
						}
		    		}
		    	}
		    	   if (args[0].equalsIgnoreCase("/sit")) {
		    		   e.setCancelled(true);
		    		   
				       if (e.getPlayer().hasPermission("splindux.sit")) {
				    	   if (!GameManager.getManager().isInGame(p)) {
				    	   SimpleSitPlayer player = new SimpleSitPlayer(p);
				    	    if (player.isSitting()) {
				    	      player.setSitting(false);
				    	    }
				    	    else if (player.getBukkitPlayer().isOnGround())
				    	      player.setSitting(true);
				    	   } else {
				    		   if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
									p.sendMessage("§cNo puedes ejecutar este comando dentro de una partida.");
								} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
									p.sendMessage("§cYou can't execute this command while playing a match.");
								}
				    	   }
				       } else {
				  	 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNo tienes permiso para ejecutar este comando.");
					p.sendMessage("§aNecesitass un rango "
							+ "§5§l[Extreme]§a para poder usar esto, visita la tienda para más información: §bhttp://splinduxstore.buycraft.net/");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou don't have permission to execute this command.");
					p.sendMessage("§aYou need a rank "
							+ "§5§l[Extreme] §ato use this, visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
						
								} 
				       }
				      }
		    	
		      if (args[0].equalsIgnoreCase("/we") || args[0].equalsIgnoreCase("/worledit")) {
		        if (!e.getPlayer().hasPermission("splindux.admin")) {
		        	 e.getPlayer().sendMessage("§fUnknown command. Type ”/help” for help.");
				        e.setCancelled(true);
		        }
		      } 
		      
		      if (args[0].equalsIgnoreCase("/buycraft")) {
			        if (!e.getPlayer().hasPermission("splindux.admin")) {
			        	 e.getPlayer().sendMessage("§fUnknown command. Type ”/help” for help.");
					        e.setCancelled(true);
			        }
			      }
		      if (args[0].equalsIgnoreCase("/citizens") || args[0].equalsIgnoreCase("/npc")) {
			        if (!e.getPlayer().hasPermission("splindux.admin")) {
			        	 e.getPlayer().sendMessage("§fUnknown command. Type ”/help” for help.");
					        e.setCancelled(true);
			        }
			      }
		      
		      if (args[0].equalsIgnoreCase("/hd")) {
			        if (!e.getPlayer().hasPermission("splindux.admin")) {
			        	 e.getPlayer().sendMessage("§fUnknown command. Type ”/help” for help.");
					        e.setCancelled(true);
			        }
			      }
		      
		      if (args[0].equalsIgnoreCase("/pex")) {
			        if (!e.getPlayer().hasPermission("splindux.admin")) {
			        	 e.getPlayer().sendMessage("§fUnknown command. Type ”/help” for help.");
					        e.setCancelled(true);
			        }
			      }
		      
		      if (args[0].equalsIgnoreCase("/viaversion")) {
			        if (!e.getPlayer().hasPermission("splindux.admin")) {
			        	 e.getPlayer().sendMessage("§fUnknown command. Type ”/help” for help.");
					        e.setCancelled(true);
			        }
			      }
		      
		      if (args[0].equalsIgnoreCase("/nametagedit") || args[0].equalsIgnoreCase("/nte")) {
			        if (!e.getPlayer().hasPermission("splindux.admin")) {
			        	 e.getPlayer().sendMessage("§fUnknown command. Type ”/help” for help.");
					        e.setCancelled(true);
			        }
			      } 
		      
		      if (args[0].equalsIgnoreCase("/nametagedit") || args[0].equalsIgnoreCase("/nte") || args[0].equalsIgnoreCase("/ne")) {
			        if (!e.getPlayer().hasPermission("splindux.admin")) {
			        	 e.getPlayer().sendMessage("§fUnknown command. Type ”/help” for help.");
					        e.setCancelled(true);
			        }
			      } 
		      
		      if (args[0].equalsIgnoreCase("/plugman")) {
			        if (!e.getPlayer().hasPermission("splindux.admin")) {
			        	 e.getPlayer().sendMessage("§fUnknown command. Type ”/help” for help.");
					        e.setCancelled(true);
			        }
			      }
		      
		      if (args[0].equalsIgnoreCase("/plugman")) {
			        if (!e.getPlayer().hasPermission("splindux.admin")) {
			        	 e.getPlayer().sendMessage("§fUnknown command. Type ”/help” for help.");
					        e.setCancelled(true);
			        }
			      }
		      
		    }
	}
	
	
	
	@EventHandler
	public static void onBreak (BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (GameManager.getManager().isInGame(p)) {
			Game g = GameManager.getManager().getArenabyPlayer(p);
			if (g.getCanPlay() == false ) {
				e.setCancelled(true);
		}
			
			if (g.getType().equalsIgnoreCase("spleef")|| 
					g.getType().equalsIgnoreCase("spleef2v2") ||
					g.getType().equalsIgnoreCase("BuildSpleefPvP") ||
					g.getType().equalsIgnoreCase("FFASpleef")) {
			if (!e.getBlock().getType().equals(Material.SNOW_BLOCK)) {
				if (!p.hasPermission("splindux.admin")) {
					e.setCancelled(true);
				}
			}
			} else if (g.getType().equalsIgnoreCase("bowspleef")) {
					if (!p.hasPermission("splindux.admin")) {
						e.setCancelled(true);
					} else {
						if (e.getBlock().getType().equals(Material.TNT)) {
							e.setCancelled(true);
						}
					}
			}
		} else {
			if (p.hasPermission("splindux.admin")) {
				if (p.getGameMode().equals(GameMode.CREATIVE))
					return;
				} else {
					e.setCancelled(true);
				}
		}
		 
	
	

			
	}
	
	@EventHandler
	public static void onPlace (BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if (GameManager.getManager().isInGame(p)) {
			if (GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("BuildSpleefPvP")) {
				return;
			}
			if (!e.getBlock().getType().equals(Material.SNOW_BLOCK)) {
				e.setCancelled(true);
			}
		}
		
		if (GameManager.getManager().isInQueue(p)) {
			e.setCancelled(true);
		}
		
		if (p.getItemInHand().equals(Game.opcionesesp) ||
				p.getItemInHand().equals(Game.opcioneseng) || 
				p.getItemInHand().equals(Game.leavequeueeng) ||
				p.getItemInHand().equals(Game.leavequeueesp) ||
				p.getItemInHand().equals(Game.gadgetsesp) ||
				p.getItemInHand().equals(Game.gadgetseng)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public static void onDeath (EntityDamageByEntityEvent e) {
		e.setDamage(-1);
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
		if (GameManager.getManager().isInGame(p)) {
			if (GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("BuildSpleefPvP")) {
				if (e.getDamager() instanceof Snowball) {
					e.setDamage(2.0);
					p.setHealth(20);
				}
				if (e.getCause().equals(DamageCause.CONTACT) || e.getCause().equals(DamageCause.ENTITY_ATTACK)
						|| e.getCause().equals(DamageCause.PROJECTILE)) {
				return;
				}
			}
		}
		}
		e.setCancelled(true);
	}
	
	@EventHandler
	public static void onHurt (EntityDamageEvent e) {
		e.setDamage(-1);
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
		if (GameManager.getManager().isInGame(p)) {
			if (GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("BuildSpleefPvP")) {
			
				
				if (e.getCause().equals(DamageCause.CONTACT) || e.getCause().equals(DamageCause.ENTITY_ATTACK)
						|| e.getCause().equals(DamageCause.PROJECTILE)) {
				return;
				}
			}
		}
				e.setCancelled(true);
	}
	}
	
	
	
	
	@EventHandler
	public static void onHunger (FoodLevelChangeEvent e) {
		e.setCancelled(true);
	} 

	@EventHandler
	public void onTeleport (PlayerTeleportEvent e) {
		Player p = e.getPlayer();	
		for (Game g : GameManager.getManager().getArenasList())
		if (g.getSpectators().contains(p)) {
			if (e.getCause().equals(TeleportCause.SPECTATE)) {
				e.setCancelled(true);
			}
		}
	}
	
	
	@EventHandler
	  public void onFire(EntityCombustEvent e)
	  {
	    if ((e.getEntity() instanceof Player))
	      e.setCancelled(true);
	  }
	
	@EventHandler
	  public void onDrop (PlayerDropItemEvent e) {
		  e.setCancelled(true);
	  }
	
	@EventHandler
	public void onHand (PlayerSwapHandItemsEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onInv (InventoryClickEvent e) {
		if (e.getSlot() == 40) {
			e.setCancelled(true);
		}
		if (GameManager.getManager().isInGame((Player)e.getWhoClicked())) {
			if (e.getSlot()==39) {
				e.setCancelled(true);
			}
		}
		
	}
	
	@EventHandler
	public void onSign(SignChangeEvent e) {
		for (int i = 0; i < 4; i++) {
            String line = e.getLine(i);
            if (line != null && !line.equals("")) {
                e.setLine(i, ChatColor.translateAlternateColorCodes('&', line));
            }
        }
	}
	
	
	
	public static void onMove (Player p) {
		
		if (GameManager.getManager().isInFFAQueue(p)) {
		if (ffalocation.containsKey(p)) {
			
			Game g = GameManager.getManager().getFFAQueue(p);

			if (ffalocation.get(p).get(p).get(0).equals(g.getSpect().getBlockX()) && 
					ffalocation.get(p).get(p).get(1).equals(g.getSpect().getBlockY()) &&
							ffalocation.get(p).get(p).get(2).equals(g.getSpect().getBlockZ())) { 
				
				int X = p.getLocation().getBlockX();
				int Y = p.getLocation().getBlockY();
				int Z = p.getLocation().getBlockZ();
				
				List<Integer> list = new ArrayList<Integer>();
				list.add(X);
				list.add(Y);
				list.add(Z);
				
				 HashMap<Player, List<Integer>> hashmap = new HashMap<Player,List<Integer>>();
				 hashmap.put(p, list);
				 
				ffalocation.put(p, hashmap);
						
		if (antiAfkFFA.containsKey(p)) {
			int time = antiAfkFFA.get(p);
			time++;
			antiAfkFFA.put(p, time);
			if (time >= 20) {
				ffalocation.remove(p);
				antiAfkFFA.remove(p);
					
						if (!g.getPlayers().isEmpty()) {
						GameManager.getManager().leaveQueue(p,false,true);
						
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§3[FFASpleef] §cAparentemente te encuentras AFK, por lo que has sido removido del juego.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§3[FFASpleef] §cAparently you are AFK, so you have been removed from the game.");
						}
					
						}		
			} 
		} else {
			antiAfkFFA.put(p, 1);
		}
		
		}  else {
			ffalocation.remove(p);
			antiAfkFFA.remove(p);
			
		}
			
		} else {
			
			int X = p.getLocation().getBlockX();
			int Y = p.getLocation().getBlockY();
			int Z = p.getLocation().getBlockZ();
			
			List<Integer> list = new ArrayList<Integer>();
			list.add(X);
			list.add(Y);
			list.add(Z);
			 HashMap<Player, List<Integer>> hashmap = new HashMap<Player,List<Integer>>();
			 hashmap.put(p, list);
			ffalocation.put(p, hashmap);
		}
		
		}
		
		if (location.containsKey(p)) {
			if (location.get(p).equals(p.getLocation())) {			
				if (p.hasPermission("splindux.afk")) {
				if (afkqueue.containsKey(p)) {
					int time = afkqueue.get(p);
					time++;
					afkqueue.put(p, time);
					if (time >= 1250) {
						location.remove(p);
						afkqueue.remove(p);
						if (!AfkCommand.isAfk(p)) {
						AfkCommand.addAfk(p);		
						}
					} 
				} else {
					afkqueue.put(p, 1);
				}
				}
			} else {
				if (AfkCommand.isAfk(p)) {
				AfkCommand.removeAfk(p);
				}
				location.remove(p);
			}
		} else {
			location.put(p, p.getLocation());
		}
		
		if (p.getWorld().getName().equalsIgnoreCase("splindux")) {
			if (p.getLocation().getBlockY() <= 0) {
				 p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
			}
			
			if (Main.getLoc(Main.arena.get("lobby"), true).distance(p.getLocation()) >= 100) {
				 p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
			}		
		}

		for (Game g : GameManager.getManager().getArenasList()) {
			try {
				if (g.getInGameSpect().contains(p)) {
					Player p1 = g.getPlayer1().get(0);
					Player p2 = g.getPlayer2().get(0);
					Player p3 = g.getPlayer1().get(1);
					Player p4 = g.getPlayer2().get(1);
					
					if (p == p1.getWorld()) {
						if (p.getLocation().distance(p1.getLocation()) > 50) {
							p.teleport(p1);
						}
					}
					
					if (p == p2.getWorld()) {
						if (p.getLocation().distance(p1.getLocation()) > 50) {
							p.teleport(p2);
						}
					}
					if (p == p3.getWorld()) {
						if (p.getLocation().distance(p1.getLocation()) > 50) {
							p.teleport(p3);
						}
					}
					if (p == p4.getWorld()) {
						if (p.getLocation().distance(p1.getLocation()) > 50) {
							p.teleport(p4);
						}
					}
				}
				
				
			if (g.getSpectators().contains(p)) {
				Player p1 = g.getPlayer1().get(0);
				Player p2 = g.getPlayer2().get(0);
				if (p.getWorld() == p1.getWorld()) {
					if (p.getLocation().distance(p1.getLocation()) > 50) {
						p.teleport(p1);
					}
					} 
				
				if (p.getWorld() == p2.getWorld()) {
					if (p.getLocation().distance(p2.getLocation()) > 50) {
						p.teleport(p2);
					}
					}
				
			}
			} catch (Exception e) {}
		}
	
	}



	
}
