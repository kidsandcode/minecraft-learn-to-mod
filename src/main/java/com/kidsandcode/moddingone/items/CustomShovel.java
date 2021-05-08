package com.kidsandcode.moddingone.items;

import com.kidsandcode.moddingone.KidsAndCode;
import com.kidsandcode.moddingone.util.ModItemTier;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.common.ToolType;

public class CustomShovel extends ShovelItem{

    public CustomShovel(){
        super(ModItemTier.DOOM, 4, 6,
                new Properties()
                .defaultMaxDamage(200)
                .addToolType(ToolType.SHOVEL, 4)
                .group(KidsAndCode.COURSE_TAB));
    }
}
