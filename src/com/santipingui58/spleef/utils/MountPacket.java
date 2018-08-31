package com.santipingui58.spleef.utils;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.santipingui58.spleef.Main;

import net.minecraft.server.v1_11_R1.PacketPlayOutMount;

public class MountPacket extends MountPacketClass
{
  public void start()
  {
    this.task = new BukkitRunnable()
    {
      @SuppressWarnings("deprecation")
	public void run()
      {
        @SuppressWarnings("rawtypes")
		Iterator localIterator2;
        for (@SuppressWarnings("rawtypes")
		Iterator localIterator1 = Bukkit.getOnlinePlayers().iterator(); localIterator1.hasNext(); 
          localIterator2.hasNext())
        {
          Player p = (Player)localIterator1.next();
          localIterator2 = Bukkit.getOnlinePlayers().iterator(); 
          Player host = (Player)localIterator2.next();

          if (host.getPassenger() != null)
          {
            PacketPlayOutMount pPOM = new PacketPlayOutMount(((CraftEntity)host).getHandle());
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket(pPOM);
          }
        }
      }
    }
    .runTaskTimer(Main.get(), 0L, 1L);
  }

  public void stop()
  {
    this.task.cancel();
  }
}