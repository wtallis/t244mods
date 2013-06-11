package org.t244.minecraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NewBlock extends Block {

	public static final int[] allowableDrops = { 38, 39};
	
	public NewBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister i) {
		this.blockIcon = i.registerIcon("T244_NewBlockMod:" + this.getUnlocalizedName2());
	}
	
	@Override
	public int idDropped(int metadata, Random r, int fortune) {
		return allowableDrops[r.nextInt(allowableDrops.length)];
	}
}
