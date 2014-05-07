package org.t244.minecraft;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

@Mod(modid = OreMod.modid, name = "OreMod", version = "1.0", dependencies = "after:t244_newitemmod")
public class OreMod implements IWorldGenerator {
	public static final String modid = "t244_oremod";

	public static Block taconite;

	@EventHandler
	public void load(FMLInitializationEvent event) {
		// create block for low-grade iron ore
		OreMod.taconite = new Taconite();
		GameRegistry.registerBlock(taconite, "Taconite");

		GameRegistry.registerWorldGenerator(this,1);
		OreDictionary.registerOre("Taconite", taconite);

		// register smelting recipe
		//TODO: use block metadata to indicate number of nuggets produced (will it interfere with stacking?)
		//  would require multiple recipes, custom WorldGenMinable to use multiple metadata values
		GameRegistry.addSmelting(taconite, new ItemStack(NewItemMod.ironNugget,2),0);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		int maxVeinSize = 12;
		int minY = 40;
		int maxY = 80;
		int maxVeinsPerChunk = 8;

		WorldGenMinable g = new WorldGenMinable(taconite, maxVeinSize);
		g.generate(world,random,1,1,1);
		for (int v = 0; v<random.nextInt(maxVeinsPerChunk); v++) {
			int x = chunkX*16 + random.nextInt(16);
			int y = minY + random.nextInt(maxY-minY);
			int z = chunkZ*16 + random.nextInt(16);
			g.generate(world, random, x, y, z);
		}
	}
}
