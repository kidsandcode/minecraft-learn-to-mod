package com.kidsandcode.moddingone.items;

import com.kidsandcode.moddingone.KidsAndCode;
import com.kidsandcode.moddingone.util.ModItemTier;
import net.minecraft.item.SwordItem;

public class CustomSword extends SwordItem {

    CustomSword() {
        super(ModItemTier.DOOM, 4, 4,
        // super(ItemTier.DIAMOND, 4, 4,
                new Properties()
                        .defaultMaxDamage(300)
                        .group(KidsAndCode.COURSE_TAB));
    }
}
