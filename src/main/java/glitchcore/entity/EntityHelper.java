/*******************************************************************************
 * Copyright 2014-2017, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package glitchcore.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityHelper
{
    public static void registerEntity(ResourceLocation location, Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
    {
        EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
    }


    public static void registerEgg(ResourceLocation location, int primary, int secondary)
    {
        Class<? extends Entity> entityClass = EntityList.NAME_TO_CLASS.get(location.getResourceDomain() + "." + location.getResourcePath());
        EntityRegistry.registerEgg(entityClass, primary, secondary);
    }
}
