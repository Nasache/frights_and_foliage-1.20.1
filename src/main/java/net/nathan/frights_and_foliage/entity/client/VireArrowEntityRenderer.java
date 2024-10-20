package net.nathan.frights_and_foliage.entity.client;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.entity.custom.VireArrowEntity;

@Environment(EnvType.CLIENT)
public class VireArrowEntityRenderer extends ProjectileEntityRenderer<VireArrowEntity> {
    public static final Identifier TEXTURE = new Identifier(FrightsAndFoliage.MOD_ID, "textures/entity/arrow/vire_feather_arrow.png");

    public VireArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public Identifier getTexture(VireArrowEntity arrowEntity) {
        return TEXTURE;
    }
}
