package org.t244.minecraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;

public class Taconite extends BlockOre {
	public Taconite(int par1) {
		super(par1);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundStoneFootstep);
		this.setUnlocalizedName("Taconite");
		
	}
}
