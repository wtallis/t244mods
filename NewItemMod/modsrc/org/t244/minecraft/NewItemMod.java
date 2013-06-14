package org.t244.minecraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = NewItemMod.modid, name = "NewItemMod", version = "1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class NewItemMod {
	public static final String modid = "T244_NewItemMod";
	
	public static IronNugget ironNugget;
	public static int ironNuggetID;

	@PreInit
	public void loadConfig(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		// mod's items are supposed to use IDs above 3840, to leave lower IDs for blocks
		ironNuggetID = config.getItem("ironNugget", 3841).getInt();
		config.save();
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		ironNugget = new IronNugget(ironNuggetID);
		LanguageRegistry.addName(ironNugget, "Iron Nugget");
		GameRegistry.registerItem(ironNugget, "ironNugget");
		
		// register recipe to craft 8 ironNugget into 1 ironIngot
		GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron), 
				ironNugget, ironNugget, ironNugget, ironNugget,	
				ironNugget, ironNugget, ironNugget, ironNugget);
	}
}
