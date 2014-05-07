package org.t244.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author wtallis
 * Mod to add a trivial new block type
 */
@Mod(modid = NewBlockMod.modID, name = "NewBlockMod", version = "1.0")
public class NewBlockMod {
	public static final String modID = "t244_newblockmod";

	public static Block newBlock;

	@EventHandler
	public void load(FMLInitializationEvent event) {
		NewBlockMod.newBlock = new NewBlock(Material.ground);
		GameRegistry.registerBlock(newBlock, NewBlock.name);
	}
}
