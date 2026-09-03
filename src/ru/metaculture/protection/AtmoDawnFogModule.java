/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1041
 *  net.minecraft.class_10868
 *  net.minecraft.class_243
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector4f
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.nio.FloatBuffer;
import net.minecraft.class_1041;
import net.minecraft.class_10868;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.PresetColorSetting;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.FrameStatsTracker;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.GlTextureUpload;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RenderWorldLastEvent;
import ru.metaculture.protection.ShaderProgram;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AtmoDawnFog", secondaryVal="Cinematic atmosphere: fog, light rays, dawn", tertiaryVal=ModuleCategory.Visuals)
public class AtmoDawnFogModule
extends Module {
    private static final String limitRef = "assets/wild/shaders/world/world_volume.vert";
    private static final String paramRef = "assets/wild/shaders/dawnfog/world_fog_fresnel.frag";
    private static final String groupVal = "Dawn";
    private static final String layerVal = "Twilight";
    private static final String slotVal = "Theme";
    private static final float themeVal = 18.0f;
    private static final float stageVal = 1.0E-4f;
    private static final int widthRef = 13203624;
    private static final int trackVal = 8230143;
    public final ModeSetting countVal = new ModeSetting("Mode", "Dawn", "Dawn", "Twilight", "Theme");
    public final FloatSetting depthVal = new FloatSetting("Density", 0.35f, 0.05f, 0.8f, 0.01f, false);
    public final FloatSetting descRef = new FloatSetting("Scatter height", 76.0f, 60.0f, 120.0f, 1.0f, false);
    public final FloatSetting activeVal = new FloatSetting("Light Rays", 0.75f, 0.0f, 1.0f, 0.01f, true);
    public final FloatSetting radiusVal = new FloatSetting("Softness", 0.6f, 0.0f, 1.0f, 0.01f, true);
    public final BoolSetting factorVal = new BoolSetting("Rainbow", true);
    public final FloatSetting sourceVal = new FloatSetting("Rainbow brightness", 0.55f, 0.1f, 1.0f, 0.01f, true).primaryVal(() -> !this.factorVal.tertiaryVal());
    public final FloatSetting extraRef = new FloatSetting("Rainbow size", 54.0f, 46.0f, 60.0f, 0.5f, false).primaryVal(() -> !this.factorVal.tertiaryVal());
    public final PresetColorSetting phaseVal = new PresetColorSetting("Dawn color", new Color(255, 173, 122)).primaryVal(() -> !this.countVal.secondaryVal(groupVal));
    private final Matrix4f modeRef = new Matrix4f();
    private final Matrix4f angleVal = new Matrix4f();
    private final Matrix4f heightRef = new Matrix4f();
    private final Matrix4f levelVal = new Matrix4f();
    private final Vector4f UuNnnVnuNNV = new Vector4f();
    private final FloatBuffer depthRef = BufferUtils.createFloatBuffer((int)16);
    private ShaderProgram speedRef;
    private int countRef = -1;
    private int entryVal = -1;
    private int guardVal = -1;
    private int VUuuVUnun = -1;
    private int vVVuuVVv = -1;
    private int VuunNUUUvu = -1;
    private int NNUUNUuVNNVn = -1;
    private int VvVvnNUnvuvV = -1;
    private int tokenVal = -1;
    private int NUVvUUVuVNVv = -1;
    private int nodeB = -1;
    private int UNvvunVVn = -1;
    private int UnvuVuVnNuvu = -1;
    private int UvNNVUVNVuvV = -1;
    private int NnunUUnU = -1;
    private int nvuVvuNnNUnv = -1;
    private int nodeF = -1;
    private int nodeH = -1;
    private int OCOocoOoOO = -1;
    private int o0Ooc0COOoc = -1;
    private int twigB = -1;
    private int UnUUVuVunvVu = -1;
    private int twigC = -1;
    private int UVnuVUUVnnU = -1;
    private int VunnVNvNV;
    private int twigD;
    private int nodeD;
    private int NnuUnUNnu;
    private int UnnnvvU;
    private int VUUnuVvVu;
    private int VvVuvUvvNNVv;
    private int UnnNNvuvvUU;
    private boolean twigA;
    private boolean itemC;
    private float itemB = 0.5f;
    private float VvuUUUNNNv = 0.5f;
    private float uuuVnuvnnNnU;
    private float nodeJ;
    private float twigH = -0.39f;
    private final float[] vuvvuVuVv = new float[18];

    public AtmoDawnFogModule() {
        Setting[] nvUuvVvuuNArray = new Setting[9];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        nvUuvVvuuNArray[7] = this.extraRef;
        nvUuvVvuuNArray[8] = this.phaseVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    public static boolean blockRef() {
        block3: {
            block2: {
                if (WildClient.primaryVal == null) break block2;
                if (WildClient.primaryVal.secondaryVal != null) break block3;
            }
            return false;
        }
        AtmoDawnFogModule vvnNVnuvvUu2 = WildClient.primaryVal.secondaryVal.primaryVal(AtmoDawnFogModule.class);
        return vvnNVnuvvUu2 != null && vvnNVnuvvUu2.enabled && !vvnNVnuvvUu2.itemC;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.weightRef();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe(priority=1)
    public void primaryVal(RenderWorldLastEvent partI) {
        class_310 class_3102;
        block24: {
            block23: {
                if (!this.enabled || this.itemC || partI == null) {
                    return;
                }
                if (!RenderSystem.isOnRenderThread()) {
                    return;
                }
                class_3102 = partI.tertiaryVal();
                if (class_3102 == null || class_3102.field_1687 == null || class_3102.field_1724 == null) break block23;
                if (partI.weightVal() != null) break block24;
            }
            return;
        }
        class_4184 class_41842 = partI.weightVal().primaryVal();
        if (class_41842 == null) {
            return;
        }
        class_1041 class_10412 = class_3102.method_22683();
        if (class_10412 == null || class_10412.method_65966()) {
            return;
        }
        int n = class_10412.method_4489();
        int n2 = class_10412.method_4506();
        if (n <= 1 || n2 <= 1) {
            return;
        }
        class_276 class_2762 = class_3102.method_1522();
        if (class_2762 == null) {
            return;
        }
        int n3 = AtmoDawnFogModule.primaryVal(class_2762.method_30277());
        int n4 = AtmoDawnFogModule.primaryVal(class_2762.method_30278());
        if (n3 <= 0 || n4 <= 0) {
            return;
        }
        if (this.depthVal.tertiaryVal() <= 1.0E-4f) {
            return;
        }
        float f = partI.speedVal();
        float f2 = ((float)(class_3102.field_1687.method_8510() % 100000L) + f) * 0.05f;
        float f3 = class_3102.field_1687.method_8442(f);
        float f4 = -((float)Math.sin(f3));
        int n5 = this.holderVal();
        float f5 = this.primaryVal(n5);
        float f6 = f4 >= 0.0f ? 1.0f : -1.0f;
        float f7 = f6 * (float)Math.cos(f5);
        float f8 = (float)Math.sin(f5);
        float f9 = 0.3f;
        this.nodeJ = -f6 * (float)Math.cos(f9);
        this.twigH = -((float)Math.sin(f9));
        int n6 = this.secondaryVal(n5);
        float f10 = 192.0f;
        if (class_3102.field_1690 != null) {
            f10 = (float)((Integer)class_3102.field_1690.method_42503().method_41753()).intValue() * 16.0f;
        }
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            this.anchorVal();
            if (this.itemC || !this.secondaryVal(n, n2)) {
                return;
            }
            if (!this.primaryVal(n3, n, n2)) {
                return;
            }
            class_243 class_2432 = class_41842.method_19326();
            this.heightRef.set((Matrix4fc)partI.extraVal());
            this.levelVal.set((Matrix4fc)partI.limitVal());
            this.primaryVal(f7, f8);
            this.modeRef.set((Matrix4fc)this.levelVal).invert();
            this.angleVal.set((Matrix4fc)this.heightRef).invert();
            this.angleVal.m30((float)class_2432.field_1352);
            this.angleVal.m31((float)class_2432.field_1351);
            this.angleVal.m32((float)class_2432.field_1350);
            this.primaryVal(n3, n4, n, n2, class_2432, f2, f7, f8, n5, n6, f10);
        }
        catch (Throwable throwable) {
            this.itemC = true;
            System.err.println("[AtmoDawnFog] renderer disabled: " + throwable.getMessage());
            throwable.printStackTrace();
        }
        finally {
            if (this.VUUnuVvVu != 0) {
                GL30.glBindFramebuffer((int)36160, (int)this.VUUnuVvVu);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
            }
            GL13.glActiveTexture((int)33985);
            GL11.glBindTexture((int)3553, (int)0);
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    private void primaryVal(int n, int n2, int n3, int n4, class_243 class_2432, float f, float f2, float f3, int n5, int n6, float f4) {
        GL30.glBindFramebuffer((int)36160, (int)this.VUUnuVvVu);
        GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n, (int)0);
        GL11.glDrawBuffer((int)36064);
        if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
            return;
        }
        GL11.glViewport((int)0, (int)0, (int)n3, (int)n4);
        GL11.glDisable((int)3089);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)36281);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
        GL11.glDepthMask((boolean)false);
        this.speedRef.primaryVal();
        float f5 = this.descRef.tertiaryVal();
        float f6 = f5 - 18.0f;
        this.primaryVal(n5, n6);
        if (this.countRef >= 0) {
            GL20.glUniform1i((int)this.countRef, (int)0);
        }
        if (this.entryVal >= 0) {
            GL20.glUniform1i((int)this.entryVal, (int)1);
        }
        if (this.guardVal >= 0) {
            GL20.glUniform2f((int)this.guardVal, (float)n3, (float)n4);
        }
        if (this.VUuuVUnun >= 0) {
            GL20.glUniform1f((int)this.VUuuVUnun, (float)f);
        }
        if (this.vVVuuVVv >= 0) {
            GL20.glUniform3f((int)this.vVVuuVVv, (float)((float)class_2432.field_1352), (float)((float)class_2432.field_1351), (float)((float)class_2432.field_1350));
        }
        if (this.VuunNUUUvu >= 0) {
            this.primaryVal(this.VuunNUUUvu, this.modeRef);
        }
        if (this.NNUUNUuVNNVn >= 0) {
            this.primaryVal(this.NNUUNUuVNNVn, this.angleVal);
        }
        if (this.VvVvnNUnvuvV >= 0) {
            GL20.glUniform3f((int)this.VvVvnNUnvuvV, (float)f2, (float)f3, (float)0.0f);
        }
        if (this.tokenVal >= 0) {
            GL20.glUniform3f((int)this.tokenVal, (float)this.itemB, (float)this.VvuUUUNNNv, (float)this.uuuVnuvnnNnU);
        }
        if (this.NUVvUUVuVNVv >= 0) {
            GL20.glUniform1f((int)this.NUVvUUVuVNVv, (float)AtmoDawnFogModule.primaryVal(this.depthVal.tertiaryVal(), 0.05f, 0.8f));
        }
        if (this.nodeB >= 0) {
            GL20.glUniform1f((int)this.nodeB, (float)f6);
        }
        if (this.UNvvunVVn >= 0) {
            GL20.glUniform1f((int)this.UNvvunVVn, (float)f5);
        }
        if (this.UnvuVuVnNuvu >= 0) {
            GL20.glUniform1f((int)this.UnvuVuVnNuvu, (float)f4);
        }
        if (this.UvNNVUVNVuvV >= 0) {
            GL20.glUniform3f((int)this.UvNNVUVNVuvV, (float)this.vuvvuVuVv[0], (float)this.vuvvuVuVv[1], (float)this.vuvvuVuVv[2]);
        }
        if (this.NnunUUnU >= 0) {
            GL20.glUniform3f((int)this.NnunUUnU, (float)this.vuvvuVuVv[3], (float)this.vuvvuVuVv[4], (float)this.vuvvuVuVv[5]);
        }
        if (this.nvuVvuNnNUnv >= 0) {
            GL20.glUniform3f((int)this.nvuVvuNnNUnv, (float)this.vuvvuVuVv[6], (float)this.vuvvuVuVv[7], (float)this.vuvvuVuVv[8]);
        }
        if (this.nodeF >= 0) {
            GL20.glUniform3f((int)this.nodeF, (float)this.vuvvuVuVv[9], (float)this.vuvvuVuVv[10], (float)this.vuvvuVuVv[11]);
        }
        if (this.nodeH >= 0) {
            GL20.glUniform3f((int)this.nodeH, (float)this.vuvvuVuVv[12], (float)this.vuvvuVuVv[13], (float)this.vuvvuVuVv[14]);
        }
        if (this.OCOocoOoOO >= 0) {
            GL20.glUniform3f((int)this.OCOocoOoOO, (float)this.vuvvuVuVv[15], (float)this.vuvvuVuVv[16], (float)this.vuvvuVuVv[17]);
        }
        if (this.o0Ooc0COOoc >= 0) {
            GL20.glUniform1f((int)this.o0Ooc0COOoc, (float)(this.factorVal.tertiaryVal() ? AtmoDawnFogModule.primaryVal(this.sourceVal.tertiaryVal(), 0.0f, 1.0f) : 0.0f));
        }
        if (this.twigB >= 0) {
            GL20.glUniform3f((int)this.twigB, (float)this.nodeJ, (float)this.twigH, (float)0.0f);
        }
        if (this.UnUUVuVunvVu >= 0) {
            GL20.glUniform1f((int)this.UnUUVuVunvVu, (float)AtmoDawnFogModule.primaryVal(this.extraRef.tertiaryVal(), 40.0f, 64.0f));
        }
        if (this.twigC >= 0) {
            GL20.glUniform1f((int)this.twigC, (float)AtmoDawnFogModule.primaryVal(this.activeVal.tertiaryVal(), 0.0f, 1.0f));
        }
        if (this.UVnuVUUVnnU >= 0) {
            GL20.glUniform1f((int)this.UVnuVUUVnnU, (float)AtmoDawnFogModule.primaryVal(this.radiusVal.tertiaryVal(), 0.0f, 1.0f));
        }
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)this.twigD);
        GL13.glActiveTexture((int)33985);
        GL11.glBindTexture((int)3553, (int)n2);
        GL13.glActiveTexture((int)33984);
        GL30.glBindVertexArray((int)this.VvVuvUvvNNVv);
        FrameStatsTracker.primaryVal().primaryVal(2);
        GL11.glDrawArrays((int)4, (int)0, (int)6);
        GL30.glBindVertexArray((int)0);
    }

    private void primaryVal(float f, float f2) {
        this.itemB = 0.5f;
        this.VvuUUUNNNv = 0.5f;
        this.uuuVnuvnnNnU = 0.0f;
        this.UuNnnVnuNNV.set(f, f2, 0.0f, 0.0f);
        this.heightRef.transform(this.UuNnnVnuNNV);
        float f3 = this.UuNnnVnuNNV.x;
        float f4 = this.UuNnnVnuNNV.y;
        float f5 = this.UuNnnVnuNNV.z;
        float f6 = -f5;
        if (f6 <= 1.0E-4f) {
            return;
        }
        this.UuNnnVnuNNV.set(f3 * 1000.0f, f4 * 1000.0f, f5 * 1000.0f, 1.0f);
        this.levelVal.transform(this.UuNnnVnuNNV);
        if (this.UuNnnVnuNNV.w <= 1.0E-4f) {
            return;
        }
        this.itemB = this.UuNnnVnuNNV.x / this.UuNnnVnuNNV.w * 0.5f + 0.5f;
        this.VvuUUUNNNv = this.UuNnnVnuNNV.y / this.UuNnnVnuNNV.w * 0.5f + 0.5f;
        this.uuuVnuvnnNnU = AtmoDawnFogModule.primaryVal(f6 * 4.0f, 0.0f, 1.0f);
    }

    private void primaryVal(int n, int n2) {
        Color color = this.phaseVal.tertiaryVal();
        float f = (float)color.getRed() / 255.0f;
        float f2 = (float)color.getGreen() / 255.0f;
        float f3 = (float)color.getBlue() / 255.0f;
        float f4 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n2 & 0xFF) / 255.0f;
        if (n == 1) {
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 0, 0.135f, 0.125f, 0.3f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 3, 0.89f, 0.46f, 0.55f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 6, 0.38f, 0.35f, 0.56f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 9, 0.8f, 0.52f, 0.62f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 12, 0.47f, 0.44f, 0.64f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 15, 0.92f, 0.56f, 0.72f);
        } else if (n == 2) {
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 0, 0.085f, 0.1f, 0.2f, f4, f5, f6, 0.3f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 3, f4, f5, f6, 1.0f, 0.93f, 0.82f, 0.35f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 6, 0.52f, 0.58f, 0.74f, f4, f5, f6, 0.28f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 9, f4, f5, f6, 0.97f, 0.93f, 0.88f, 0.45f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 12, 0.58f, 0.63f, 0.76f, f4, f5, f6, 0.35f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 15, f4, f5, f6, 1.0f, 0.96f, 0.88f, 0.3f);
        } else {
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 0, 0.16f, 0.19f, 0.38f, f, f2, f3, 0.14f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 3, AtmoDawnFogModule.primaryVal(f * 1.12f, 0.0f, 1.0f), AtmoDawnFogModule.primaryVal(f2 * 0.88f, 0.0f, 1.0f), AtmoDawnFogModule.primaryVal(f3 * 0.62f, 0.0f, 1.0f));
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 6, 0.56f, 0.62f, 0.8f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 9, f, f2, f3, 0.95f, 0.55f, 0.63f, 0.42f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 12, 0.6f, 0.67f, 0.82f);
            AtmoDawnFogModule.primaryVal(this.vuvvuVuVv, 15, AtmoDawnFogModule.primaryVal(f * 1.08f, 0.0f, 1.0f), AtmoDawnFogModule.primaryVal(f2 * 0.94f, 0.0f, 1.0f), AtmoDawnFogModule.primaryVal(f3 * 0.72f, 0.0f, 1.0f));
        }
    }

    private static void primaryVal(float[] fArray, int n, float f, float f2, float f3) {
        fArray[n] = f;
        fArray[n + 1] = f2;
        fArray[n + 2] = f3;
    }

    private static void primaryVal(float[] fArray, int n, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = AtmoDawnFogModule.primaryVal(f7, 0.0f, 1.0f);
        float f9 = AtmoDawnFogModule.primaryVal(f);
        float f10 = AtmoDawnFogModule.primaryVal(f2);
        float f11 = AtmoDawnFogModule.primaryVal(f3);
        float f12 = AtmoDawnFogModule.primaryVal(f4);
        float f13 = AtmoDawnFogModule.primaryVal(f5);
        float f14 = AtmoDawnFogModule.primaryVal(f6);
        float f15 = (float)Math.cbrt(0.41222146f * f9 + 0.53633255f * f10 + 0.051445995f * f11);
        float f16 = (float)Math.cbrt(0.2119035f * f9 + 0.6806995f * f10 + 0.10739696f * f11);
        float f17 = (float)Math.cbrt(0.08830246f * f9 + 0.28171885f * f10 + 0.6299787f * f11);
        float f18 = (float)Math.cbrt(0.41222146f * f12 + 0.53633255f * f13 + 0.051445995f * f14);
        float f19 = (float)Math.cbrt(0.2119035f * f12 + 0.6806995f * f13 + 0.10739696f * f14);
        float f20 = (float)Math.cbrt(0.08830246f * f12 + 0.28171885f * f13 + 0.6299787f * f14);
        float f21 = f15 + (f18 - f15) * f8;
        float f22 = f16 + (f19 - f16) * f8;
        float f23 = f17 + (f20 - f17) * f8;
        float f24 = f21 * f21 * f21;
        float f25 = f22 * f22 * f22;
        float f26 = f23 * f23 * f23;
        float f27 = 4.0767417f * f24 - 3.3077116f * f25 + 0.23096994f * f26;
        float f28 = -1.268438f * f24 + 2.6097574f * f25 - 0.34131938f * f26;
        float f29 = -0.0041960864f * f24 - 0.7034186f * f25 + 1.7076147f * f26;
        fArray[n] = AtmoDawnFogModule.secondaryVal(f27);
        fArray[n + 1] = AtmoDawnFogModule.secondaryVal(f28);
        fArray[n + 2] = AtmoDawnFogModule.secondaryVal(f29);
    }

    private static float primaryVal(float f) {
        return f <= 0.04045f ? f / 12.92f : (float)Math.pow((f + 0.055f) / 1.055f, 2.4);
    }

    private static float secondaryVal(float f) {
        f = AtmoDawnFogModule.primaryVal(f, 0.0f, 1.0f);
        return f <= 0.0031308f ? f * 12.92f : (float)(1.055 * Math.pow(f, 0.4166666666666667) - 0.055);
    }

    private int holderVal() {
        if (this.countVal.secondaryVal(layerVal)) {
            return 1;
        }
        if (this.countVal.secondaryVal(slotVal)) {
            return 2;
        }
        return 0;
    }

    private float primaryVal(int n) {
        if (n == 1) {
            return -0.045f;
        }
        if (n == 2) {
            return 0.13f;
        }
        return 0.11f;
    }

    private int secondaryVal(int n) {
        if (n == 1) {
            return 13203624;
        }
        if (n == 2) {
            block6: {
                NvVNvUvunNNu nvVNvUvunNNu;
                block7: {
                    if (WildClient.primaryVal == null || WildClient.primaryVal.chunkVal == null) break block6;
                    nvVNvUvunNNu = WildClient.primaryVal.chunkVal.secondaryVal();
                    if (nvVNvUvunNNu != NvVNvUvunNNu.CUSTOM || WildClient.primaryVal.chunkVal.secondaryVal == null) break block7;
                    return WildClient.primaryVal.chunkVal.secondaryVal.limitVal() & 0xFFFFFF;
                }
                try {
                    if (nvVNvUvunNNu != null && nvVNvUvunNNu.primaryVal() != null) {
                        return nvVNvUvunNNu.primaryVal().getRGB() & 0xFFFFFF;
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            return 8230143;
        }
        return this.phaseVal.limitVal() & 0xFFFFFF;
    }

    private boolean primaryVal(int n, int n2, int n3) {
        block6: {
            block5: {
                if (n <= 0) break block5;
                if (this.VunnVNvNV != 0) break block6;
            }
            return false;
        }
        if (this.UnnnvvU == 0) {
            this.UnnnvvU = GL30.glGenFramebuffers();
        }
        GL11.glDisable((int)3089);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)36281);
        GL30.glBindFramebuffer((int)36008, (int)this.UnnnvvU);
        GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)n, (int)0);
        if (GL30.glCheckFramebufferStatus((int)36008) != 36053) {
            GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)0, (int)0);
            return false;
        }
        GL30.glBindFramebuffer((int)36009, (int)this.VunnVNvNV);
        GL11.glReadBuffer((int)36064);
        GL11.glDrawBuffer((int)36064);
        GL30.glBlitFramebuffer((int)0, (int)0, (int)n2, (int)n3, (int)0, (int)0, (int)n2, (int)n3, (int)16384, (int)9728);
        GL30.glBindFramebuffer((int)36008, (int)this.UnnnvvU);
        GL30.glFramebufferTexture2D((int)36008, (int)36064, (int)3553, (int)0, (int)0);
        return true;
    }

    private boolean secondaryVal(int n, int n2) {
        if (n <= 0 || n2 <= 0) {
            return false;
        }
        if (this.twigD != 0 && (this.nodeD != n || this.NnuUnUNnu != n2 || this.VunnVNvNV == 0)) {
            this.timerVal();
        }
        if (this.twigD == 0) {
            this.twigD = GL11.glGenTextures();
            GL11.glBindTexture((int)3553, (int)this.twigD);
            GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
            GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
            GlTextureUpload.primaryVal(32856, n, n2, 6408, 5121);
            this.VunnVNvNV = GL30.glGenFramebuffers();
            GL30.glBindFramebuffer((int)36160, (int)this.VunnVNvNV);
            GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)this.twigD, (int)0);
            GL11.glDrawBuffer((int)36064);
            if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
                this.timerVal();
                return false;
            }
        }
        this.nodeD = n;
        this.NnuUnUNnu = n2;
        return true;
    }

    private void timerVal() {
        if (this.VunnVNvNV != 0) {
            GL30.glDeleteFramebuffers((int)this.VunnVNvNV);
            this.VunnVNvNV = 0;
        }
        if (this.twigD != 0) {
            GL11.glDeleteTextures((int)this.twigD);
            this.twigD = 0;
        }
        this.nodeD = 0;
        this.NnuUnUNnu = 0;
    }

    private void anchorVal() {
        if (this.twigA) {
            return;
        }
        this.speedRef = ShaderProgram.primaryVal(limitRef, paramRef);
        this.VvVuvUvvNNVv = GL30.glGenVertexArrays();
        this.UnnNNvuvvUU = GL15.glGenBuffers();
        GL30.glBindVertexArray((int)this.VvVuvUvvNNVv);
        GL15.glBindBuffer((int)34962, (int)this.UnnNNvuvvUU);
        float[] fArray = new float[24];
        fArray[0] = -1.0f;
        fArray[1] = -1.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = 1.0f;
        fArray[5] = -1.0f;
        fArray[6] = 1.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        fArray[9] = 1.0f;
        fArray[10] = 1.0f;
        fArray[11] = 1.0f;
        fArray[12] = -1.0f;
        fArray[13] = -1.0f;
        fArray[14] = 0.0f;
        fArray[15] = 0.0f;
        fArray[16] = 1.0f;
        fArray[17] = 1.0f;
        fArray[18] = 1.0f;
        fArray[19] = 1.0f;
        fArray[20] = -1.0f;
        fArray[21] = 1.0f;
        fArray[22] = 0.0f;
        fArray[23] = 1.0f;
        float[] fArray2 = fArray;
        GL15.glBufferData((int)34962, (float[])fArray2, (int)35044);
        int n = 16;
        GL20.glEnableVertexAttribArray((int)0);
        GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)n, (long)0L);
        GL20.glEnableVertexAttribArray((int)1);
        GL20.glVertexAttribPointer((int)1, (int)2, (int)5126, (boolean)false, (int)n, (long)8L);
        GL15.glBindBuffer((int)34962, (int)0);
        GL30.glBindVertexArray((int)0);
        if (this.VUUnuVvVu == 0) {
            this.VUUnuVvVu = GL30.glGenFramebuffers();
        }
        this.countRef = this.speedRef.primaryVal("u_ScreenTexture");
        this.entryVal = this.speedRef.primaryVal("u_DepthTexture");
        this.guardVal = this.speedRef.primaryVal("u_Resolution");
        this.VUuuVUnun = this.speedRef.primaryVal("u_Time");
        this.vVVuuVVv = this.speedRef.primaryVal("u_CameraPos");
        this.VuunNUUUvu = this.speedRef.primaryVal("u_InverseProjectionMatrix");
        this.NNUUNUuVNNVn = this.speedRef.primaryVal("u_InverseViewMatrix");
        this.VvVvnNUnvuvV = this.speedRef.primaryVal("u_SunDirection");
        this.tokenVal = this.speedRef.primaryVal("u_SunScreen");
        this.NUVvUUVuVNVv = this.speedRef.primaryVal("u_FogDensity");
        this.nodeB = this.speedRef.primaryVal("u_FogMinHeight");
        this.UNvvunVVn = this.speedRef.primaryVal("u_FogMaxHeight");
        this.UnvuVuVnNuvu = this.speedRef.primaryVal("u_ViewDistance");
        this.UvNNVUVNVuvV = this.speedRef.primaryVal("u_PaletteZenith");
        this.NnunUUnU = this.speedRef.primaryVal("u_PaletteHorizonWarm");
        this.nvuVvuNnNUnv = this.speedRef.primaryVal("u_PaletteHorizonCool");
        this.nodeF = this.speedRef.primaryVal("u_PaletteFogWarm");
        this.nodeH = this.speedRef.primaryVal("u_PaletteFogCool");
        this.OCOocoOoOO = this.speedRef.primaryVal("u_PaletteRay");
        this.o0Ooc0COOoc = this.speedRef.primaryVal("u_Rainbow");
        this.twigB = this.speedRef.primaryVal("u_RainbowDir");
        this.UnUUVuVunvVu = this.speedRef.primaryVal("u_RainbowSize");
        this.twigC = this.speedRef.primaryVal("u_GodRays");
        this.UVnuVUUVnnU = this.speedRef.primaryVal("u_Softness");
        this.twigA = true;
    }

    private void weightRef() {
        if (!RenderSystem.isOnRenderThread()) {
            return;
        }
        this.timerVal();
        if (this.UnnnvvU != 0) {
            GL30.glDeleteFramebuffers((int)this.UnnnvvU);
            this.UnnnvvU = 0;
        }
        if (this.VUUnuVvVu != 0) {
            GL30.glDeleteFramebuffers((int)this.VUUnuVvVu);
            this.VUUnuVvVu = 0;
        }
        if (this.VvVuvUvvNNVv != 0) {
            GL30.glDeleteVertexArrays((int)this.VvVuvUvvNNVv);
            this.VvVuvUvvNNVv = 0;
        }
        if (this.UnnNNvuvvUU != 0) {
            GL15.glDeleteBuffers((int)this.UnnNNvuvvUU);
            this.UnnNNvuvvUU = 0;
        }
        if (this.speedRef != null) {
            this.speedRef.secondaryVal();
            this.speedRef = null;
        }
        this.twigA = false;
        this.itemC = false;
    }

    private void primaryVal(int n, Matrix4f matrix4f) {
        this.depthRef.clear();
        matrix4f.get(this.depthRef);
        GL20.glUniformMatrix4fv((int)n, (boolean)false, (FloatBuffer)this.depthRef);
    }

    private static int primaryVal(Object object) {
        if (object instanceof class_10868) {
            class_10868 class_108682 = (class_10868)object;
            return class_108682.method_68427();
        }
        return 0;
    }

    private static float primaryVal(float f, float f2, float f3) {
        if (!Float.isFinite(f)) {
            return f2;
        }
        return Math.max(f2, Math.min(f3, f));
    }
}

