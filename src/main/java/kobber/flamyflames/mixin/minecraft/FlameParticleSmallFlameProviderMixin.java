package kobber.flamyflames.mixin.minecraft;

import kobber.flamyflames.client.particle.FlamyFlameParticle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.client.particle.FlameParticle$SmallFlameProvider")
public abstract class FlameParticleSmallFlameProviderMixin {
    @Final
    @Shadow
    private SpriteSet sprite;

    @Inject(method = "createParticle(Lnet/minecraft/core/particles/SimpleParticleType;Lnet/minecraft/client/multiplayer/ClientLevel;DDDDDD)Lnet/minecraft/client/particle/Particle;", at = @At("HEAD"), cancellable = true)
    public void createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, CallbackInfoReturnable<Particle> cir) {
        FlamyFlameParticle flameParticle = new FlamyFlameParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprite, 0.1F);
        flameParticle.scale(0.5F);
        cir.setReturnValue(flameParticle);
    }
}