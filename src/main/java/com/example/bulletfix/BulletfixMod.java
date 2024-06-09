package com.example.bulletfix;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod("bulletfix")
public class BulletfixMod {
  private static final Logger LOGGER = LogUtils.getLogger();
  public static final String MOD_ID = "bulletfix";

  public BulletfixMod() {
    MinecraftForge.EVENT_BUS.register(this);
  }

  public static void warn(String s) {
    LOGGER.warn(s);
  }

  public static void warn(String s, Object args) {
    LOGGER.warn(s, args);
  }

  public static void warn(String s, Object... args) {
    LOGGER.warn(s, args);
  }

  public static ResourceLocation asResource(String path) {
    return new ResourceLocation("bulletfix", path);
  }
}
