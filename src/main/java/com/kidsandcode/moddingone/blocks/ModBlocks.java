package com.kidsandcode.moddingone.blocks;

import com.kidsandcode.moddingone.KidsAndCode;
import com.kidsandcode.moddingone.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, KidsAndCode.MODID);

    public static final RegistryObject<Block> CUSTOM_BLOCK =
            register("my_block", CustomBlock::new);

    public static final RegistryObject<Block> CUSTOM_ORE =
            register("my_ore", CustomOre::new);

    public static final RegistryObject<Block> LUCKY_BLOCK =
            register("lucky_block", LuckyBlock::new);


    // Registers blocks as BlockItem and adds to ItemGroup tab
    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(KidsAndCode.COURSE_TAB)));
        return toReturn;
    }

}
