package com.kidsandcode.moddingone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class LuckyBlock extends Block {

    public LuckyBlock() {
        super(Properties.create(Material.IRON)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(4)
                .hardnessAndResistance(2, 3f)
                .sound(SoundType.LILY_PADS));
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        System.out.println(number);

        // 10% chance
        if(number <= 10) {
            for(int i = 0; i < 10; i++) {
                worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(),
                        new ItemStack(Items.DIAMOND)));
            }
        }

        // 15% chance
        else if(number <= 25) {
            Entity entity = new EndermanEntity(EntityType.ENDERMAN, worldIn);
            entity.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
            if(!worldIn.isRemote) {
                worldIn.addEntity(entity);
            }
        }

        // 25% chance
        else if(number <= 50) {
            for(int i = 0; i < 100; i++) {
                Entity entity = new PigEntity(EntityType.PIG, worldIn);
                entity.setPosition(pos.getX(), pos.getY(), pos.getZ());
                if(!worldIn.isRemote) {
                    worldIn.addEntity(entity);
                }
            }
        }

        // 20% chance
        else if(number <= 70) {
            worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(),
                    new ItemStack(Items.CARVED_PUMPKIN)));
        }

        // 28% chance
        else if(number <= 98) {
            worldIn.setBlockState(pos, Blocks.GLASS.getDefaultState());
        }

        // 2% chance
        else if(number <= 100) {
            worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(),
                    new ItemStack(Items.DIAMOND_SWORD)));
        }

        super.onBlockHarvested(worldIn, pos, state, player);
    }
}
