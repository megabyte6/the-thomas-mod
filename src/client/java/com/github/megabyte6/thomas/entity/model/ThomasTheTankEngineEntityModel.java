package com.github.megabyte6.thomas.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;

import static com.github.megabyte6.thomas.Thomas.idOf;

public class ThomasTheTankEngineEntityModel extends EntityModel<LivingEntityRenderState> {
    public static final EntityModelLayer MAIN_LAYER = new EntityModelLayer(idOf("thomas_the_tank_engine"), "main");

    public ThomasTheTankEngineEntityModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bb_main = modelPartData.addChild("bb_main",
                ModelPartBuilder.create().uv(0, 28).cuboid(-5.0F, -5.5F, -8.5F, 2.0F, 5.0F, 5.0F, new Dilation(0.0F))
                        .uv(27, 23).cuboid(3.0F, -5.5F, -8.5F, 2.0F, 5.0F, 5.0F, new Dilation(0.0F)).uv(32, 7)
                        .cuboid(3.0F, -3.5F, 4.5F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)).uv(14, 28)
                        .cuboid(-5.0F, -3.5F, 4.5F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)).uv(24, 0)
                        .cuboid(-2.0F, -12.5F, 3.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F)).uv(1, 40)
                        .cuboid(-3.0F, -8.0F, 10.0F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F)).uv(19, 36)
                        .cuboid(-3.0F, -12.5F, -10.0F, 6.0F, 3.0F, 10.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        bb_main.addChild("Body_r1",
                ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -10.0F, -9.0F, 8.0F, 20.0F, 8.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, -10.0F, 0.0F, -1.5708F, 0.0F, 3.1416F));
        return TexturedModelData.of(modelData, 64, 64);
    }
}
