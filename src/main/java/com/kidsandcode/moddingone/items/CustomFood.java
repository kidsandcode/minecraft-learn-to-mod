package com.kidsandcode.moddingone.items;

import com.kidsandcode.moddingone.KidsAndCode;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class CustomFood extends Item {

    public CustomFood() {
        super(new Properties().group(KidsAndCode.COURSE_TAB)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(1.5f)
                        .effect(() -> new EffectInstance(Effects.GLOWING, 300, 4), 0.5f)
                        .effect(() -> new EffectInstance(Effects.LUCK, 300, 4), 1f)
                                                .build()));
    }
    /*
    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if(KeyboardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("Turns sheep into copper ingots"));
        } else {
            tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " SHIFT " + "\u00A77" + "for more information!"));
        }

        super.addInformation(stack, world, tooltip, flag);
    }*/
}
