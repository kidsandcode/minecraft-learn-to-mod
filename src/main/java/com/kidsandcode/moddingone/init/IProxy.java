package com.kidsandcode.moddingone.init;

import net.minecraft.world.World;

public interface IProxy {

    void init();

    World getClientWorld();
}
