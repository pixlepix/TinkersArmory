package pixlepix.tarmory.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.texture.TextureManager;
import pixlepix.tarmory.TArmory;

/**
 * Created by pixlepix on 11/30/14.
 * Based on code by CaveJohnson212
 */
public class ParticleEffects {
    public static TextureManager textureManager = Minecraft.getMinecraft().renderEngine;
    public static Minecraft minecraft = Minecraft.getMinecraft();


    public static void spawnParticle(String particleName, double posX, double posY, double posZ, double motX, double motY, double motZ) {
        spawnParticle(particleName, posX, posY, posZ, motX, motY, motZ, 0, 0, 0);
    }

    public static void spawnParticle(String particleName, double posX, double posY, double posZ, double motX, double motY, double motZ, double r, double g, double b) {

        if (minecraft != null && minecraft.renderViewEntity != null && minecraft.effectRenderer != null) {
            int var14 = minecraft.gameSettings.particleSetting;
            if (var14 == 1 && minecraft.theWorld.rand.nextInt(3) == 0) {
                var14 = 2;
            }
            double var15 = minecraft.renderViewEntity.posX - posX;
            double var17 = minecraft.renderViewEntity.posY - posY;
            double var19 = minecraft.renderViewEntity.posZ - posZ;
            EntityFX entityfx = null;
            double var22 = 16.0D;
            if (!(var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22)) {
                //Many particles are rendered here to make use of UnlimitedEffectRendererif (p_72726_1_.equals("spell"))
                if (particleName.equals("spell")) {
                    entityfx = new EntitySpellParticleFX(minecraft.theWorld, posX, posY, posZ, (float) motX, (float) motY, (float) motZ);
                }
                if (particleName.equals("happyVillager")) {
                    entityfx = new EntityAuraFX(minecraft.theWorld, posX, posY, posZ, (float) motX, (float) motY, (float) motZ);
                    entityfx.setParticleTextureIndex(82);
                    entityfx.setRBGColorF(1.0F, 1.0F, 1.0F);
                }
                if (particleName.equals("magicCrit")) {
                    entityfx = new EntityCritFX(Minecraft.getMinecraft().theWorld, posX, posY, posZ, (float) motX, (float) motY, (float) motZ);
                    entityfx.setRBGColorF(entityfx.getRedColorF() * 0.3F, entityfx.getGreenColorF() * 0.8F, entityfx.getBlueColorF());
                    entityfx.nextTextureIndexX();
                }
                if (particleName.equals("enchantmenttable")) {
                    entityfx = new EntityEnchantmentTableParticleFX(Minecraft.getMinecraft().theWorld, posX, posY, posZ, (float) motX, (float) motY, (float) motZ);
                    entityfx.nextTextureIndexX();
                }
                if (particleName.equals("crit")) {
                    entityfx = new EntityCritFX(Minecraft.getMinecraft().theWorld, posX, posY, posZ, motX, motY, motZ);
                    if (r != 0 || g != 0 || b != 0) {
                        entityfx.setRBGColorF((float) r, (float) g, (float) b);
                    }
                }
                if (particleName.equals("witchMagic")) {
                    entityfx = new EntitySpellParticleFX(Minecraft.getMinecraft().theWorld, posX, posY, posZ, motX, motY, motZ);
                    ((EntitySpellParticleFX) entityfx).setBaseSpellTextureIndex(144);
                    float f = Minecraft.getMinecraft().theWorld.rand.nextFloat() * 0.5F + 0.35F;
                    entityfx.setRBGColorF((float) r, (float) g, (float) b);
                    entityfx.motionY = -.07;
                }

                TArmory.proxy.addEffectBypassingLimit(entityfx);
            }
        }

    }

}
