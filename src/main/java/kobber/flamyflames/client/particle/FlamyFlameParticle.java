package kobber.flamyflames.client.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.SpriteSet;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

public class FlamyFlameParticle extends FlameParticle {
    private final SpriteSet sprites;
    private final float quadSize;

    public FlamyFlameParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites, float quadSize) {
        super(level, x, y, z, 0, 0, 0);
        this.sprites = sprites;
        this.quadSize = quadSize;
        this.xd = xSpeed;
        this.yd = ySpeed + Math.max((Math.random() - 0.5) * 0.08F * quadSize, 0);
        this.zd = zSpeed;
        this.x = x + (this.random.nextFloat() - this.random.nextFloat()) * (0.2 * quadSize);
        this.y = y + (this.random.nextFloat() - this.random.nextFloat()) * (0.2 * quadSize);
        this.z = z + (this.random.nextFloat() - this.random.nextFloat()) * (0.2 * quadSize);
        this.setPos(this.x, this.y, this.z);
        this.setSpriteFromAge(sprites);
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(sprites);
    }

    // Fixes Sodium ignoring getFacingCameraMode
    @Override
    public void render(@NotNull VertexConsumer buffer, @NotNull Camera renderInfo, float partialTicks) {
        Quaternionf quaternionf = new Quaternionf();
        this.getFacingCameraMode().setRotation(quaternionf, renderInfo, partialTicks);
        this.renderRotatedQuad(buffer, renderInfo, quaternionf, partialTicks);
    }

    @Override
    public float getQuadSize(float scaleFactor) {
        return quadSize;
    }

    @Override
    public @NotNull FacingCameraMode getFacingCameraMode() {
        return FacingCameraMode.LOOKAT_Y;
    }
}
