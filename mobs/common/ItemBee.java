package Reactioncraft.mobs.common;

import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeInterface;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IChromosome;
import Reactioncraft.base.common.RCB;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBee extends Item implements IBeeInterface
{
	public ItemBee(int i)
	{
		super(i);
		this.setCreativeTab(RCB.Reactioncraft);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Items.png";
	}

	@Override
	public boolean isBee(ItemStack stack) 
	{
		return true;
	}

	@Override
	public boolean isDrone(ItemStack stack) 
	{
		return false;
	}

	@Override
	public boolean isMated(ItemStack stack) 
	{
		return true;
	}

	@Override
	public IBee getBee(ItemStack stack) 
	{
		return null;
	}

	@Override
	public IBee getBee(World world, IBeeGenome genome) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBee getBee(World world, IBeeGenome genome, IBee mate) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getBeeStack(IBee bee, EnumBeeType type) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IChromosome[] templateAsChromosomes(IAllele[] template) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IChromosome[] templateAsChromosomes(IAllele[] templateActive, IAllele[] templateInactive) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBeeGenome templateAsGenome(IAllele[] template) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBeeGenome templateAsGenome(IAllele[] templateActive, IAllele[] templateInactive) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
