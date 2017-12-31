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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHelper
{
    public static GFNonNullList<ItemStack> getSubItems(CreativeTabs tab, Item item)
    {
        GFNonNullList<ItemStack> list = GFNonNullList.create();
        item.getSubItems(item, tab, list);
        return list;
    }
}
