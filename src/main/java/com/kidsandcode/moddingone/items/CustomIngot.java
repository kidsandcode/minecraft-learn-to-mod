package com.kidsandcode.moddingone.items;

import com.kidsandcode.moddingone.KidsAndCode;
import net.minecraft.item.Item;

public class CustomIngot extends Item {

    public CustomIngot() {
        super(new Properties().group(KidsAndCode.COURSE_TAB));
        //super(new Properties().group(ItemGroup.MATERIALS));
    }
}
