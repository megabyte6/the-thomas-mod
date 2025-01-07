package com.github.megabyte6.thomas;

import com.github.megabyte6.thomas.entity.ModEntityType;
import com.github.megabyte6.thomas.entity.ThomasTheTankEngineEntityRenderer;
import com.github.megabyte6.thomas.entity.model.ThomasTheTankEngineEntityModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ThomasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.

        EntityModelLayerRegistry.registerModelLayer(ThomasTheTankEngineEntityModel.MAIN_LAYER, ThomasTheTankEngineEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntityType.THOMAS_THE_TANK_ENGINE, ThomasTheTankEngineEntityRenderer::new);
    }
}
