package org.t244.minecraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid=LightningAspectMod.modid, name="LightningAspectMod", version="1.0")
public class LightningAspectMod {
	public static final String modid = "t244_lightningaspectmod";
	
	/* we need to keep the Configuration object around past the PreInit phase,
	 * because we'll have to update and save the configuration after successfully 
	 * acquiring an enchantment ID in the Init phase
	 */
	public static Configuration config;
	public static int EnchantmentID;
	public static LightningAspect instance;
	private static final int defaultID = 64; // last built-in ID is 62, so we'll treat 0-63 as reserved
	
	
	@EventHandler
	public void loadConfig(FMLPreInitializationEvent e) {
		config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		
		if (config.hasKey("enchantment", "LightningAspect")) {
			/* note: this should never actually default to 256, 
			 * since we just made sure that the key actually exists
			 * (and it should have been initialized properly) 
			 */ 
			EnchantmentID = config.get("enchantment", "LightningAspect", 256).getInt();
		} else {
			EnchantmentID = -1; // signal that we don't have an ID that is expected to be valid and usable
		}
	}
	
	@EventHandler
	public void load(FMLInitializationEvent e) {
		if (EnchantmentID != -1) {
			instance = new LightningAspect(EnchantmentID,1);
			return;
		}
		
		// search for a usable ID (should only happen on first run of mod)
		// TODO: try to get a low ID as a last resort
		for (int id=defaultID; id<256; id++) {
			try {
				instance = new LightningAspect(id, 1);
			} catch (IllegalArgumentException ex) {
				instance = null;
				continue;
			}
			EnchantmentID = id;
			/* we're calling get() when we know the key doesn't exist,
			 * so it will get initialized to the default, and then we can save it. 
			 */
			EnchantmentID = config.get("enchantment", "LightningAspect", id).getInt();
			config.save();
			break;
		}

		if (instance == null) {
			throw new RuntimeException("Could not get a free enchantment ID");
		}
	}
	
	@EventHandler
	public void registerHandler(FMLPostInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(instance);
	}
	
	

}
