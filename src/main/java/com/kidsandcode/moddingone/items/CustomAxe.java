package com.kidsandcode.moddingone.items;

import com.kidsandcode.moddingone.KidsAndCode;
import com.kidsandcode.moddingone.util.ModItemTier;
import net.minecraft.item.AxeItem;
import net.minecraftforge.common.ToolType;

public class CustomAxe extends AxeItem {

    public CustomAxe() {
        super(ModItemTier.DOOM, 4, 4,
                new Properties()
                .defaultMaxDamage(400)
                .addToolType(ToolType.AXE, 4)
                .group(KidsAndCode.COURSE_TAB));
    }

}
