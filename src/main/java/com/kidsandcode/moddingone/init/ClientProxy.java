package com.kidsandcode.moddingone.init;

import com.kidsandcode.moddingone.KidsAndCode;
import com.kidsandcode.moddingone.items.ModSpawnEggItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = KidsAndCode.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements IProxy {

    @Override
    public void init() {
        ModSpawnEggItem.initSpawnEggs();
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
