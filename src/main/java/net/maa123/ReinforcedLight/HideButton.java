package net.maa123.ReinforcedLight;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class HideButton extends BlockButton{

	@SideOnly(Side.CLIENT)
	protected boolean isHide = false;

	@SideOnly(Side.CLIENT)
	private IIcon InvIcon;

	private double zero = 0.0;

	protected HideButton(){
		super(false);
		setBlockName("blockHideButton");
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister){
    	this.InvIcon = par1IconRegister.registerIcon("reinforcedlight:air");
    }

    @SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess worldIn, int x, int y, int z, int side){
    	if(isHide){
			return InvIcon;
		}
		return Blocks.portal.getBlockTextureFromSide(1);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		//Minecraft.getMinecraft().thePlayer.sendChatMessage("meta:"+meta);
		return Blocks.portal.getBlockTextureFromSide(1);
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random){

		ItemStack itemstack = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem();

		if(itemstack != null && itemstack.getItem() != null && Block.getBlockFromItem(itemstack.getItem()).equals(this)){
			this.show(world,x,y,z);
		}else{
			this.hide(world,x,y,z);
		}

	}

	@SideOnly(Side.CLIENT)
	private void hide (World world, int x, int y, int z){
		if(!this.isHide){
			this.isHide = true;
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			Minecraft.getMinecraft().renderGlobal.markBlockForUpdate(x, y, z);
			setHardness(-1);
		}
	}
	
	@SideOnly(Side.CLIENT)
	private void show (World world, int x, int y, int z){
		if(this.isHide){
			this.isHide = false;
			this.setBlockBoundsBasedOnState((IBlockAccess)world,x,y,z);
			Minecraft.getMinecraft().renderGlobal.markBlockForUpdate(x, y, z);
			setHardness(0);
		}
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World World, int x, int y, int z){
		if(isHide){
			return AxisAlignedBB.getBoundingBox(zero, zero, zero, zero, zero, zero);
		}
		return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		if(isHide){
			return null;
		}
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ){
		if(this.isHide){
			return false;
		}
		super.onBlockActivated(worldIn,x,y,z,player,side,subX,subY,subZ);
		return true;
	}
}
