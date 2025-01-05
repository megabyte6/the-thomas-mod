package com.github.megabyte6.thomas.entity;

import com.github.megabyte6.thomas.entity.model.ThomasTheTankEngineEntityModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static com.github.megabyte6.thomas.Thomas.idOf;

public class ThomasTheTankEngineEntityRenderer extends MobEntityRenderer<ThomasTheTankEngineEntity, LivingEntityRenderState, ThomasTheTankEngineEntityModel> {
    private static final Identifier TEXTURE = idOf("textures/entity/thomasthetankengine/thomas_the_tank_engine.png");

    public ThomasTheTankEngineEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ThomasTheTankEngineEntityModel(context.getPart(ThomasTheTankEngineEntityModel.MAIN_LAYER)), 0.75f);
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    public void render(LivingEntityRenderState livingEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntityRenderState.baby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }
}
