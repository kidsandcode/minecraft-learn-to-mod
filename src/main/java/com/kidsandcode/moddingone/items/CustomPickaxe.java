package com.kidsandcode.moddingone.items;

import com.kidsandcode.moddingone.KidsAndCode;
import com.kidsandcode.moddingone.util.ModItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;

public class CustomPickaxe extends PickaxeItem {

    public CustomPickaxe() {
        super(ModItemTier.DOOM, 4, 4,
                new Properties()
                .defaultMaxDamage(400)
                .addToolType(ToolType.PICKAXE, 4)
                .group(KidsAndCode.COURSE_TAB));
    }
}
