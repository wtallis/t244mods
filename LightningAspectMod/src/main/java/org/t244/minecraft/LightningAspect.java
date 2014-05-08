package org.t244.minecraft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class LightningAspect extends Enchantment {

	public LightningAspect(int par1, int par2) {
		super(par1, par2, EnumEnchantmentType.weapon);
		this.setName("lightning");
	}

	@Override
	public int getMinEnchantability(int level) {
		return 10 + 20*(level-1);
	}

	@Override
	public int getMaxEnchantability(int level) {
		return super.getMinEnchantability(level)+50;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}
	
	@SubscribeEvent
	public void attackEntityHandler(AttackEntityEvent e) {
		EntityPlayer player = e.entityPlayer;
		Entity target = e.target;

		ItemStack i = player.getHeldItem();

		if (EnchantmentHelper.getEnchantmentLevel(effectId, i) > 0 && target.isEntityAlive()) {
			EntityLightningBolt b = new EntityLightningBolt(target.worldObj,
					target.posX,target.posY,target.posZ);
			target.worldObj.spawnEntityInWorld(b);
		}
	}
}

