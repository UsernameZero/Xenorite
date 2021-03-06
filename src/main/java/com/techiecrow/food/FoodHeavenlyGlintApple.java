package com.techiecrow.food;

import com.techiecrow.crativetab.CreativeTabItems;
import com.techiecrow.handler.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class FoodHeavenlyGlintApple extends ItemFood
{

	public static double rand;

	public FoodHeavenlyGlintApple()
	{
		super(ConfigurationHandler.appleHeavenlyGlintHungerAmount, ConfigurationHandler.appleHeavenlyGlintSaturationAmount, ConfigurationHandler.appleHeavenlyGlintWolvesFavoriteFood);
		this.setMaxStackSize(100);
		this.setTextureName("xenorite:appleHeavenlyGlint");
		this.setUnlocalizedName("appleHeavenlyGlint");
		this.setCreativeTab(CreativeTabItems.Xenoriteitems);
	}

	@Override
	protected void onFoodEaten(ItemStack item, World world, EntityPlayer player)
	{
		if (!world.isRemote && world.isDaytime())
		{

			rand = Math.random();
			{
				if (rand < 0.5)
					player.addPotionEffect(new PotionEffect(ConfigurationHandler.appleHeavenlyGlintEffect1, ConfigurationHandler.appleHeavenlyGlintEffectTime1, 0));
				else
					player.addPotionEffect(new PotionEffect(ConfigurationHandler.appleHeavenlyGlintEffect2, ConfigurationHandler.appleHeavenlyGlintEffectTime2, 0));
			}
		}
		else
		{
			super.onFoodEaten(item, world, player);
		}
	}
}