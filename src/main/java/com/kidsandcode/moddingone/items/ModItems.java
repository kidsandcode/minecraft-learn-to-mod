package com.kidsandcode.moddingone.items;

import com.kidsandcode.moddingone.KidsAndCode;
import com.kidsandcode.moddingone.util.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KidsAndCode.MODID);

    public static final RegistryObject<Item> CUSTOM_INGOT =
            ITEMS.register("my_ingot", CustomIngot::new);

    public static final RegistryObject<Item> CUSTOM_BALLOON =
            ITEMS.register("my_balloon", CustomBalloon::new);

    public static final RegistryObject<Item> CUSTOM_SWORD =
            ITEMS.register("my_sword", CustomSword::new);

    public static final RegistryObject<Item> CUSTOM_SHOVEL =
            ITEMS.register("my_shovel", CustomShovel::new);

    public static final RegistryObject<Item> CUSTOM_PICKAXE =
            ITEMS.register("my_pickaxe", CustomPickaxe::new);

    public static final RegistryObject<Item> CUSTOM_AXE =
            ITEMS.register("my_axe", CustomAxe::new);

    public static final RegistryObject<Item> CUSTOM_FOOD =
            ITEMS.register("my_food", CustomFood::new);

    public static final RegistryObject<Item> CUSTOM_HELMET =
            ITEMS.register("my_helmet", CustomHelmet::new);

    // Another way of creating items
    public static final RegistryObject<Item> CUSTOM_CHESTPLATE =
            ITEMS.register("my_chestplate",
                    () -> new ArmorItem(ModArmorMaterial.DOOM_ARMOR, EquipmentSlotType.CHEST,
                            new Item.Properties().group(KidsAndCode.COURSE_TAB)));

    public static final RegistryObject<Item> CUSTOM_LEGGINGS =
            ITEMS.register("my_leggings",
                    () -> new ArmorItem(ModArmorMaterial.DOOM_ARMOR, EquipmentSlotType.LEGS,
                            new Item.Properties().group(KidsAndCode.COURSE_TAB)));

    public static final RegistryObject<Item> CUSTOM_BOOTS =
            ITEMS.register("my_boots",
                    () -> new ArmorItem(ModArmorMaterial.DOOM_ARMOR, EquipmentSlotType.FEET,
                            new Item.Properties().group(KidsAndCode.COURSE_TAB)));





}
