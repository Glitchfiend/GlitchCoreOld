/*******************************************************************************
 * Copyright 2014-2017, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package glitchcore.item;

import net.minecraft.item.ItemStack;

public class StackHelper
{
    public static boolean isEmpty(ItemStack stack)
    {
        return stack == null || stack.stackSize == 0 | stack.getItem() == null;
    }

    public static void setSize(ItemStack stack, int size)
    {
        stack.stackSize = size;
    }

    public static int getSize(ItemStack stack) { return stack.stackSize; }

    public static void increment(ItemStack stack, int amount)
    {
        stack.stackSize += amount;
    }

    public static void decrement(ItemStack stack, int amount)
    {
        stack.stackSize -= amount;
    }
}
