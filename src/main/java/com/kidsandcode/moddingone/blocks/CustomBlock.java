package com.kidsandcode.moddingone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;


public class CustomBlock extends Block {

    public CustomBlock() {
        super(Properties.create(Material.IRON)
                .harvestLevel(4)
                .hardnessAndResistance(4f, 10f)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.METAL));
    }

    /* ON LEFT CLICK */
    @SuppressWarnings("deprecation")
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        BlockState block = worldIn.getBlockState(pos.add(0, -1, 0));
        worldIn.setBlockState(pos, block);
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }




    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
    {
        if(worldIn.isRemote)
        {
            String msg = TextFormatting.YELLOW + "Boing Boing Boing Boing";
            entityIn.sendMessage(new StringTextComponent(msg), entityIn.getUniqueID());
        }
        super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
    }
}
