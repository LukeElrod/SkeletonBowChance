package com.lukeelrod.bowchance;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.ModContainer;

@EventBusSubscriber(modid = SkeletonBowChance.MODID)
@Mod(SkeletonBowChance.MODID)
public class SkeletonBowChance {
    public static final String MODID = "skeletonbowchance";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SkeletonBowChance(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @SubscribeEvent
    public static void onLivingSpawn(EntityJoinLevelEvent event){
        if (event.getEntity() instanceof LivingEntity livingEntity) {
            if (livingEntity.getType().toString().equals("entity.minecraft.skeleton") && Math.random() > Config.BOW_CHANCE.get() / 100.0) {
                //LOGGER.debug("Removing bow from skeleton");
                livingEntity.setItemSlot(EquipmentSlot.MAINHAND, Items.AIR.getDefaultInstance());
            }
        }
    }

}
