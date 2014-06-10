package org.t244.minecraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by wtallis on 5/14/14.
 */
@Mod(modid="t244_mobmod", version="1.0")
public class MobMod {

	@Mod.EventHandler
	public void load(FMLInitializationEvent event) {
		EntityList.addMapping(ExampleMob.class,"examplemob",101, 0xFF00FF, 0x00FF00);

		EntityRegistry.addSpawn(ExampleMob.class, 1, 1, 1, EnumCreatureType.monster,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsPlus);
	}
}
