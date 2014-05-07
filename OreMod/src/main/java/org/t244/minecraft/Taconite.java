package org.t244.minecraft;

import net.minecraft.block.BlockOre;

public class Taconite extends BlockOre {
	public Taconite() {
		super();
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeStone);
		this.setBlockName("Taconite");
	}
}
