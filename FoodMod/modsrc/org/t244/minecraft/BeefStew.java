package org.t244.minecraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class BeefStew extends ItemFood {

	public BeefStew(int id) {
		super(id, 10, 0.6F, false);
		this.setUnlocalizedName("beefStew");
		this.setMaxStackSize(1);
		this.setPotionEffect(Potion.regeneration.id, 10, 0, 0.3F);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister i) {
		this.itemIcon = i.registerIcon("T244_FoodMod:beefStew");
	}
	
	@Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        super.onEaten(itemStack, world, player);
        return new ItemStack(Item.bowlEmpty);
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack i) {
		return 48;
	}
}
