package org.t244.minecraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = OreMod.modid, name = "OreMod", version = "1.0", dependencies = "after:T244_NewItemMod")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class OreMod implements IWorldGenerator {
	public static final String modid = "T244_OreMod";
	
	public static Block taconite;
	public static int taconiteID;
	
	@PreInit
	public void loadConfig(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		/* TODO:
		 * does load order with NewBlock matter?
		 */
		taconiteID = config.getBlock("Taconite", 500).getInt();
		config.save();
	}

	@Init
	public void load(FMLInitializationEvent event) {
		// create block for low-grade iron ore
		OreMod.taconite = new Taconite(OreMod.taconiteID);
		LanguageRegistry.addName(taconite, "Taconite");
		GameRegistry.registerBlock(taconite, "Taconite");
		
		GameRegistry.registerWorldGenerator(this);
		OreDictionary.registerOre("oreTaconite", taconite);

		// register smelting recipe
		//TODO: use block metadata to indicate number of nuggets produced (will it interfere with stacking?)
		FurnaceRecipes r = FurnaceRecipes.smelting();
		r.addSmelting(taconiteID, new ItemStack(NewItemMod.ironNugget, 2), 0);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		int maxVeinSize = 12;
		int minY = 40;
		int maxY = 80;
		int maxVeinsPerChunk = 8;
		
		WorldGenMinable g = new WorldGenMinable(taconiteID, maxVeinSize);
		g.generate(world,random,1,1,1);
		for (int v = 0; v<random.nextInt(maxVeinsPerChunk); v++) {
			int x = chunkX*16 + random.nextInt(16);
			int y = minY + random.nextInt(maxY-minY);
			int z = chunkZ*16 + random.nextInt(16);
			g.generate(world, random, x, y, z);
		}
	}
}
