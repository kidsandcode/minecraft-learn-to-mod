package com.kidsandcode.moddingone.items;

import com.kidsandcode.moddingone.KidsAndCode;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class CustomBalloon extends Item {

    public CustomBalloon() {
        super(new Properties().group(KidsAndCode.COURSE_TAB));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(worldIn.isRemote) {
            playerIn.jump();
        }
        String msg = TextFormatting.YELLOW + "I fly I fly, oh no, I fall";
        playerIn.sendMessage(new StringTextComponent(msg), playerIn.getUniqueID());
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
