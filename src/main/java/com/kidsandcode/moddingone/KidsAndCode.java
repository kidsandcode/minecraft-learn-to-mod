package com.kidsandcode.moddingone;

import com.kidsandcode.moddingone.blocks.ModBlocks;
import com.kidsandcode.moddingone.entities.ModEntityTypes;
import com.kidsandcode.moddingone.events.ModEvents;
import com.kidsandcode.moddingone.init.ClientProxy;
import com.kidsandcode.moddingone.init.Config;
import com.kidsandcode.moddingone.init.IProxy;
import com.kidsandcode.moddingone.init.ServerProxy;
import com.kidsandcode.moddingone.items.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(KidsAndCode.MODID)
public class KidsAndCode {

    // Change the name of your mod
    public static final String MODID = "moddingone";

    // Custom Item Group (Minecraft Tab) for blocks and items
    public static final ItemGroup COURSE_TAB = new ItemGroup("course_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CUSTOM_INGOT.get());
            //return null;
        }
    };


    public static IProxy proxy;

    private static final Logger LOGGER = LogManager.getLogger();

    public KidsAndCode() {

        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);

        registerModAdditions(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        registerConfigs();
        proxy.init();
        loadConfigs();

        DeferredWorkQueue.runLater(() -> {
            //GlobalEntityTypeAttributes.put(ModEntityTypes.CUSTOM_MOB.get(), CustomEntity.setCustomAttribute().create());
        });
    }


    private void registerConfigs() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
    }

    private void loadConfigs() {
        String tomlClient = MODID + "-client.toml";
        String tomlServer = MODID + "-server.toml";
        Config.loadConfigFile(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve(tomlClient).toString());
        Config.loadConfigFile(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve(tomlServer).toString());
    }

    private void registerModAdditions(IEventBus eventBus) {
        ModItems.ITEMS.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);
        ModEntityTypes.ENTITY_TYPES.register(eventBus);

        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }


}



