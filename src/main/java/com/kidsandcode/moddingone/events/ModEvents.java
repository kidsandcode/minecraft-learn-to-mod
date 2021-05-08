package com.kidsandcode.moddingone.events;

import com.kidsandcode.moddingone.items.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;

import java.util.Collection;

public class ModEvents {

    @SubscribeEvent
    public void onArrowHit(ProjectileImpactEvent event) {
        if (!(event.getEntity() instanceof AbstractArrowEntity)) {
            return;
        }
        Vector3d hitResult = event.getRayTraceResult().getHitVec();
        World worldIn = event.getEntity().getEntityWorld();
        Entity entity = event.getEntity();
        Double x = hitResult.x;
        Double y = hitResult.y;
        Double z = hitResult.z;
        worldIn.createExplosion(entity, x, y, z, 4, Explosion.Mode.DESTROY);
    }

    // Hover over attack entity event, and go back to event instances and edit the source. Click Ctrl+H to view all events

    @SubscribeEvent
    public void onLollipopHit(AttackEntityEvent event) {
        if(event.getPlayer().getHeldItemMainhand().getItem() == ModItems.CUSTOM_FOOD.get()) {
            if(event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity)event.getTarget();
                PlayerEntity player = event.getPlayer();

                // "delete" one of the held items
                player.getHeldItemMainhand().shrink(1);

                target.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 300));
                target.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 300));
                target.addPotionEffect(new EffectInstance(Effects.WITHER, 300));

                if(player.world.isRemote()) {
                    String msg = TextFormatting.YELLOW + "This is the lollipop of doom";
                    player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                }

            }
        }
    }

    @SubscribeEvent
    public void onLollipopDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntityLiving();

        //if(entity instanceof SheepEntity) {
        World worldIn = entity.getEntityWorld();
        Collection<ItemEntity> drops = event.getDrops();

        LogManager.getLogger().debug(entity.getActivePotionEffects());

        if(entity.isPotionActive(Effects.WITHER)) {
            drops.add(new ItemEntity(worldIn, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                    new ItemStack(ModItems.CUSTOM_FOOD.get())));
            drops.add(new ItemEntity(worldIn, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                    new ItemStack(Items.DIAMOND_AXE, 2)));
        }
    }

    @SubscribeEvent
    public void giveZombiesArmor(LivingSpawnEvent event) {
        if(!(event.getEntity() instanceof ZombieEntity)) {
            return;
        }

        ZombieEntity zombieEntity = (ZombieEntity) event.getEntity();

        zombieEntity.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.DIAMOND_HELMET));
        zombieEntity.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
        zombieEntity.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
        zombieEntity.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(Items.DIAMOND_BOOTS));
    }

    @SubscribeEvent
    public void spawnReinforcements(LivingDeathEvent event) {
        if(!(event.getEntity() instanceof SkeletonEntity)) {
            return;
        }

        SkeletonEntity skeletonEntity = (SkeletonEntity) event.getEntity();
        World worldIn = skeletonEntity.getEntityWorld();

        for(int i = 0; i < 3; i++) {
            SkeletonEntity skeleton = new SkeletonEntity(EntityType.SKELETON, worldIn);
            skeleton.setPosition(event.getEntity().getPosX(), event.getEntity().getPosY(), event.getEntity().getPosZ());

            if(!worldIn.isRemote) {
                worldIn.addEntity(skeleton);
            }
        }
    }

    @SubscribeEvent
    public void noFallDamage(LivingFallEvent event) {
        if (!(event.getEntity() instanceof PlayerEntity)) {
            return;
        }

        PlayerEntity playerEntity = (PlayerEntity) event.getEntity();

        event.setCanceled(true);
    }

    @SubscribeEvent
    public void verticalSheep(LivingEvent.LivingUpdateEvent event) {
        if (!(event.getEntity() instanceof SheepEntity)) {
            return;
        }

        if (!(event.getEntity().collidedHorizontally)) {
            return;
        }

        ((SheepEntity) event.getEntity()).setMoveVertical(5f);
    }

}
