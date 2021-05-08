package com.kidsandcode.moddingone.items;

import com.kidsandcode.moddingone.KidsAndCode;
import com.kidsandcode.moddingone.util.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class CustomHelmet extends ArmorItem {

    public CustomHelmet() {
        super(ModArmorMaterial.DOOM_ARMOR, EquipmentSlotType.HEAD,
                new Properties().group(KidsAndCode.COURSE_TAB));
    }
}
