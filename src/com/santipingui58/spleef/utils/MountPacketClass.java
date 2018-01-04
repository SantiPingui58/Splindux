package com.santipingui58.spleef.utils;

import org.bukkit.scheduler.BukkitTask;

public abstract class MountPacketClass
{
  BukkitTask task = null;

  final int iter = 1;

  public abstract void start();

  public abstract void stop();
}