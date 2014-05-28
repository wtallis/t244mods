package org.t244.minecraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.entity.EntityList;

/**
 * Created by wtallis on 5/14/14.
 */
@Mod(modid="mobmod", version="1.0")
public class MobMod {

	@Mod.EventHandler
	public void load(FMLInitializationEvent event) {
		EntityList.addMapping(ExampleMob.class,"examplemob",101, 0xFF00FF, 0x00FF00);
	}
}