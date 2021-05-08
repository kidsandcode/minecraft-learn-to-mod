package com.kidsandcode.moddingone.world.gen;

import com.kidsandcode.moddingone.KidsAndCode;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = KidsAndCode.MODID)
public class ModEntitySpawn
{
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event)
    {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if (!types.contains(BiomeDictionary.Type.NETHER) && !types.contains(BiomeDictionary.Type.END)
                && !types.contains(BiomeDictionary.Type.OCEAN))
        {
            List<MobSpawnInfo.Spawners> base = event.getSpawns().getSpawner(EntityClassification.CREATURE);
            //base.add(new MobSpawnInfo.Spawners(ModEntityTypes.CUSTOM_ENTITY.get(), 30, 2, 5));
        }
    }
}
