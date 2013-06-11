/**
 * 
 */
package org.t244.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * @author wtallis
 * Mod to add a trivial new block type
 */
@Mod(modid = NewBlockMod.modid, name = "NewBlockMod", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class NewBlockMod {
	public static final String modid = "T244_NewBlockMod";
	
	public static Block newBlock;
	public static int NewBlockID;
	
	@PreInit
	public void loadConfig(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		NewBlockMod.NewBlockID = config.getBlock("NewBlock", 500).getInt();
		config.save();
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		NewBlockMod.newBlock = new NewBlock(NewBlockMod.NewBlockID, Material.ground);
		NewBlockMod.newBlock.setUnlocalizedName("NewBlock");
		LanguageRegistry.addName(newBlock, "New Block");
		GameRegistry.registerBlock(newBlock, "newBlock");
		
		
	}
}
