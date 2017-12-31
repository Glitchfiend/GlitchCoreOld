/*******************************************************************************
 * Copyright 2014-2017, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package glitchcore.item;

import glitchcore.util.GFNonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IGFItem
{
    // Introduced in 1.12
    default boolean isInCreativeTab(CreativeTabs tab)
    {
        for (CreativeTabs tabEntry : ((Item)this).getCreativeTabs())
        {
            if (tab == tabEntry) return true;
        }

        return false;
    }

    // Introduced in 1.12
    default ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        return new ActionResult(EnumActionResult.PASS, player.getHeldItem(hand));
    }

    // Introduced in 1.12
    @SideOnly(Side.CLIENT)
    default void getSubItems(CreativeTabs tab, GFNonNullList<ItemStack> subItems)
    {
        subItems.add(new ItemStack((Item)this));
    }

    // Introduced in 1.12
    default EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        return EnumActionResult.PASS;
    }
}
