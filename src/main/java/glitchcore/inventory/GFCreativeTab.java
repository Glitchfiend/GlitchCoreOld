/*******************************************************************************
 * Copyright 2014-2017, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package glitchcore.inventory;

import glitchcore.util.GFNonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public abstract class GFCreativeTab extends CreativeTabs
{
    public GFCreativeTab(String label)
    {
        super(label);
    }
    public GFCreativeTab(int index, String label) { super(index, label); }

    @Override
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems(List<ItemStack> list)
    {
        GFNonNullList<ItemStack> itemList = GFNonNullList.create();
        itemList.addAll(list);
        this.displayAllRelevantItems(itemList);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return this.getIconItemStack().getItem();
    }

    // Introduced in 1.12
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems(GFNonNullList<ItemStack> itemList)
    {
        for (Item item : Item.REGISTRY)
        {
            if (item == null)
            {
                continue;
            }

            for (CreativeTabs tab : item.getCreativeTabs())
            {
                if (tab == this)
                {
                    item.getSubItems(item, this, itemList);
                }
            }
        }

        if (this.getRelevantEnchantmentTypes() != null)
        {
            this.addEnchantmentBooksToList(itemList, this.getRelevantEnchantmentTypes());
        }
    }
}
