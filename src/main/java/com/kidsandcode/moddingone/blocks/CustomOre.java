package com.kidsandcode.moddingone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class CustomOre extends Block {


    public CustomOre() {
        super(Properties.create(Material.IRON)
                .harvestLevel(6)
                .hardnessAndResistance(7f, 15f)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.NETHER_ORE)
        );
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player)
    {
        worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(),
                new ItemStack(Items.ENDER_EYE)));

        if(worldIn.isRemote)
        {

            String msg = TextFormatting.YELLOW + "Ahhh you clicked on me";
            player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
        }
        super.onBlockClicked(state, worldIn, pos, player);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

        Entity entity = new EndermanEntity(EntityType.ENDERMAN, worldIn);
        entity.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
        worldIn.addEntity(entity);

        super.onBlockHarvested(worldIn, pos, state, player);
    }
}
