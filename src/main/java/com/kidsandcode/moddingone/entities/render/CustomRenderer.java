package com.kidsandcode.moddingone.entities.render;

import com.kidsandcode.moddingone.KidsAndCode;
import com.kidsandcode.moddingone.entities.CustomEntity;
import com.kidsandcode.moddingone.entities.model.CustomModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CustomRenderer extends MobRenderer<CustomEntity, CustomModel<CustomEntity>>
{
    protected static final ResourceLocation TEXTURE = new ResourceLocation(KidsAndCode.MODID,
            "textures/entity/my_mob.png");

    public CustomRenderer(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn, new CustomModel<>(), 0.9f);
    }

    @Override
    public ResourceLocation getEntityTexture(CustomEntity entity)
    {
        return TEXTURE;
    }
}
