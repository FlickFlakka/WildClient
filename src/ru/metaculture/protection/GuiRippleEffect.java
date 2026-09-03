/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_437;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.DepthRenderTarget;
import ru.metaculture.protection.MouseClickEvent;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.ClickGuiScreen;
import ru.metaculture.protection.ModernClickGuiScreen;
import ru.metaculture.protection.GlCapabilityDetector;
import ru.metaculture.protection.AutoBuyScreen;
import ru.metaculture.protection.WildScreenMarker;
import ru.metaculture.protection.ShaderProgram;
import ru.metaculture.protection.Renderer2DBackend;
import ru.metaculture.protection.Subscribe;

public final class GuiRippleEffect {
    private static final GuiRippleEffect primaryVal = new GuiRippleEffect();
    private static final int secondaryVal = 5;
    private static final long tertiaryVal = 760000000L;
    private static final long marginVal = 1860000000L;
    private final RippleSlot[] weightVal = new RippleSlot[5];
    private final float[] paramVal = new float[10];
    private final float[] extraVal = new float[5];
    private final float[] limitVal = new float[5];
    private final float[] speedVal = new float[5];
    private final float[] widthVal = new float[15];
    private final float[] chunkVal = new float[15];
    private final float[] blockRef = new float[15];
    private final float[] holderVal = new float[15];
    private final float[] timerVal = new float[4];
    private final float[] anchorVal = new float[4];
    private final float[] weightRef = new float[2];
    private final DepthRenderTarget bufferVal = new DepthRenderTarget();
    private boolean countVal;
    private CapturedFramebuffer depthVal;
    private ShaderProgram descRef;
    private int activeVal = -1;
    private int radiusVal = -1;
    private int factorVal = -1;
    private int sourceVal = -1;
    private int extraRef = -1;
    private int phaseVal = -1;
    private int limitRef = -1;
    private int paramRef = -1;
    private int groupVal = -1;
    private int layerVal = -1;
    private int slotVal = -1;
    private int themeVal = -1;
    private int stageVal = -1;
    private int widthRef = -1;

    private GuiRippleEffect() {
        for (int i = 0; i < this.weightVal.length; ++i) {
            this.weightVal[i] = new RippleSlot();
        }
    }

    public static GuiRippleEffect primaryVal() {
        return primaryVal;
    }

    public void secondaryVal() {
        if (this.countVal) {
            return;
        }
        this.countVal = true;
        EventManager.register(this);
    }

    @Subscribe
    public void primaryVal(MouseClickEvent spanI) {
        int n;
        int n2;
        int n3;
        int n4;
        block16: {
            block15: {
                class_1041 class_10412;
                block14: {
                    block13: {
                        class_310 class_3102;
                        block12: {
                            block11: {
                                if (!spanI.widthVal()) {
                                    return;
                                }
                                if (!MenuModule.primaryVal(MenuModule.groupVal)) {
                                    return;
                                }
                                class_3102 = class_310.method_1551();
                                if (class_3102 == null) break block11;
                                if (class_3102.field_1755 != null) break block12;
                            }
                            return;
                        }
                        class_10412 = class_3102.method_22683();
                        if (class_10412 == null) break block13;
                        if (!class_10412.method_65966()) break block14;
                    }
                    return;
                }
                n4 = class_10412.method_4489();
                n3 = class_10412.method_4506();
                n2 = class_10412.method_4480();
                n = class_10412.method_4507();
                if (n4 <= 0 || n3 <= 0 || n2 <= 0) break block15;
                if (n > 0) break block16;
            }
            return;
        }
        float f = GuiRippleEffect.primaryVal((float)(spanI.extraVal() * (double)n4 / (double)n2), 0.0f, Math.max(0.0f, (float)n4 - 1.0f));
        float f2 = GuiRippleEffect.primaryVal((float)(spanI.limitVal() * (double)n3 / (double)n), 0.0f, Math.max(0.0f, (float)n3 - 1.0f));
        this.primaryVal(f, f2, this.primaryVal(spanI.marginVal()), -1, -2232577, 0.0f, 760000000L);
    }

    public void primaryVal(float f, float f2, int n, int n2) {
        this.primaryVal(f, f2, n, n2, n, n2);
    }

    public void primaryVal(float f, float f2, int n, int n2, int n3, int n4) {
        this.primaryVal(f, f2, 1.24f, n, n2, n3, n4, 1.0f, 1860000000L);
    }

    public void primaryVal(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.timerVal[0] = Math.max(0.0f, f);
        this.timerVal[1] = Math.max(0.0f, f2);
        this.timerVal[2] = Math.max(0.0f, f3);
        this.timerVal[3] = Math.max(0.0f, f4);
        this.anchorVal[0] = Math.max(0.0f, f6);
        this.anchorVal[1] = Math.max(0.0f, f7);
        this.anchorVal[2] = Math.max(0.0f, f8);
        this.anchorVal[3] = Math.max(0.0f, f9);
        this.weightRef[0] = Math.max(0.0f, f5);
        this.weightRef[1] = Math.max(0.0f, f10);
    }

    public boolean primaryVal(class_437 class_4372) {
        this.secondaryVal(System.nanoTime());
        return class_4372 != null && !this.secondaryVal(class_4372) && this.limitVal();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(Object object) {
        this.secondaryVal(System.nanoTime());
        if (object == null) return false;
        if (!this.secondaryVal(object)) return false;
        if (!this.limitVal()) return false;
        return true;
    }

    public boolean primaryVal(int n, int n2) {
        this.secondaryVal(System.nanoTime());
        if (this.depthVal != null || n <= 0 || n2 <= 0 || !this.limitVal()) {
            return false;
        }
        this.tertiaryVal(n, n2);
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        this.depthVal = new CapturedFramebuffer(modeVal, n, n2);
        GL30.glBindFramebuffer((int)36160, (int)this.bufferVal.primaryVal);
        GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
        GL11.glDisable((int)3089);
        GL11.glDisable((int)36281);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
        GL11.glDepthMask((boolean)true);
        GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
        GL11.glClear((int)16640);
        return true;
    }

    public void tertiaryVal() {
        CapturedFramebuffer modeVal = this.depthVal;
        if (modeVal == null) {
            return;
        }
        this.depthVal = null;
        GLStateSnapshot.tertiaryVal(modeVal.snapshot());
        GLStateSnapshot.Snapshot nodeC = GLStateSnapshot.primaryVal();
        try {
            this.marginVal(modeVal.width(), modeVal.height());
        }
        finally {
            GLStateSnapshot.tertiaryVal(nodeC);
        }
    }

    public void marginVal() {
        block11: {
            block10: {
                block9: {
                    block8: {
                        long l = System.nanoTime();
                        this.secondaryVal(l);
                        if (this.depthVal != null) break block8;
                        if (this.limitVal()) break block9;
                    }
                    return;
                }
                class_310 class_3102 = class_310.method_1551();
                if (class_3102 == null) break block10;
                if (class_3102.method_22683() == null) break block10;
                if (!class_3102.method_22683().method_65966()) break block11;
            }
            return;
        }
        Renderer2DBackend vnuUvuuNVNUU2 = ru.metaculture.protection.WildClient.tertiaryVal();
        if (vnuUvuuNVNUU2 == null) {
            return;
        }
        this.paramVal();
        Renderer2DBackend.WildClient modeVal = vnuUvuuNVNUU2.marginVal();
        if (modeVal.colorTexture() <= 0 || modeVal.width() <= 0 || modeVal.height() <= 0) {
            return;
        }
        this.primaryVal(modeVal.colorTexture(), modeVal.width(), modeVal.height(), false);
    }

    public void secondaryVal(int n, int n2) {
        block5: {
            block4: {
                this.depthVal = null;
                if (n <= 0 || n2 <= 0) {
                    this.bufferVal.primaryVal();
                    this.speedVal();
                    return;
                }
                if (this.bufferVal.marginVal != n) break block4;
                if (this.bufferVal.weightVal == n2) break block5;
            }
            this.bufferVal.primaryVal();
            this.speedVal();
        }
    }

    public void primaryVal(boolean bl) {
        if (!bl) {
            this.depthVal = null;
            this.speedVal();
        }
    }

    public void weightVal() {
        this.depthVal = null;
        this.speedVal();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean secondaryVal(Object object) {
        if (object instanceof ModernClickGuiScreen) return true;
        if (object instanceof ClickGuiScreen) return true;
        if (object instanceof AutoBuyScreen) return true;
        if (!(object instanceof WildScreenMarker)) return false;
        return true;
    }

    private void tertiaryVal(int n, int n2) {
        this.bufferVal.primaryVal(n, n2);
        this.paramVal();
    }

    private void paramVal() {
        if (this.descRef != null) {
            return;
        }
        this.descRef = ShaderProgram.primaryVal("assets/wild/shaders/blur/blur_fullscreen.vert", "assets/wild/shaders/postfx/gui_ripple.frag");
        this.activeVal = this.descRef.primaryVal("uSource");
        this.radiusVal = this.descRef.primaryVal("uResolution");
        this.factorVal = this.descRef.primaryVal("uRippleCount");
        this.sourceVal = this.descRef.primaryVal("uRippleCenter[0]");
        this.extraRef = this.descRef.primaryVal("uRippleAge[0]");
        this.phaseVal = this.descRef.primaryVal("uRipplePower[0]");
        this.limitRef = this.descRef.primaryVal("uRippleKind[0]");
        this.paramRef = this.descRef.primaryVal("uRipplePreviousColorTop[0]");
        this.groupVal = this.descRef.primaryVal("uRipplePreviousColorBottom[0]");
        this.layerVal = this.descRef.primaryVal("uRippleColorTop[0]");
        this.slotVal = this.descRef.primaryVal("uRippleColorBottom[0]");
        this.themeVal = this.descRef.primaryVal("uThemeGuiRect");
        this.stageVal = this.descRef.primaryVal("uThemePanelRect");
        this.widthRef = this.descRef.primaryVal("uThemeRadii");
    }

    private void marginVal(int n, int n2) {
        this.primaryVal(this.bufferVal.secondaryVal, n, n2, true);
    }

    private void primaryVal(int n, int n2, int n3, boolean bl) {
        long l = System.nanoTime();
        int n4 = this.primaryVal(l);
        Renderer2DBackend vnuUvuuNVNUU2 = ru.metaculture.protection.WildClient.tertiaryVal();
        if (vnuUvuuNVNUU2 == null) {
            return;
        }
        vnuUvuuNVNUU2.primaryVal(n, n2, n3, this.descRef, () -> {
            if (this.activeVal >= 0) {
                GL20.glUniform1i((int)this.activeVal, (int)0);
            }
            if (this.radiusVal >= 0) {
                GL20.glUniform2f((int)this.radiusVal, (float)n2, (float)n3);
            }
            if (this.factorVal >= 0) {
                GL20.glUniform1i((int)this.factorVal, (int)n4);
            }
            this.extraVal();
        }, bl);
    }

    private int primaryVal(long l) {
        int n;
        int n2 = 0;
        for (n = 0; n < 5; ++n) {
            RippleSlot panelVal = this.weightVal[n];
            if (!panelVal.primaryVal) continue;
            float f = (float)(l - panelVal.secondaryVal) / (float)panelVal.chunkVal;
            if (f >= 1.0f) {
                panelVal.primaryVal = false;
                continue;
            }
            this.paramVal[n2 * 2] = panelVal.tertiaryVal;
            this.paramVal[n2 * 2 + 1] = panelVal.marginVal;
            this.extraVal[n2] = GuiRippleEffect.primaryVal(f, 0.0f, 1.0f);
            this.limitVal[n2] = panelVal.weightVal;
            this.speedVal[n2] = panelVal.paramVal;
            GuiRippleEffect.primaryVal(panelVal.extraVal, this.widthVal, n2 * 3);
            GuiRippleEffect.primaryVal(panelVal.limitVal, this.chunkVal, n2 * 3);
            GuiRippleEffect.primaryVal(panelVal.speedVal, this.blockRef, n2 * 3);
            GuiRippleEffect.primaryVal(panelVal.widthVal, this.holderVal, n2 * 3);
            ++n2;
        }
        for (n = n2; n < 5; ++n) {
            this.paramVal[n * 2] = 0.0f;
            this.paramVal[n * 2 + 1] = 0.0f;
            this.extraVal[n] = 1.0f;
            this.limitVal[n] = 0.0f;
            this.speedVal[n] = 0.0f;
            GuiRippleEffect.primaryVal(-1, this.widthVal, n * 3);
            GuiRippleEffect.primaryVal(-2232577, this.chunkVal, n * 3);
            GuiRippleEffect.primaryVal(-1, this.blockRef, n * 3);
            GuiRippleEffect.primaryVal(-2232577, this.holderVal, n * 3);
        }
        return n2;
    }

    private void extraVal() {
        if (this.sourceVal >= 0) {
            GL20.glUniform2fv((int)this.sourceVal, (float[])this.paramVal);
        }
        if (this.extraRef >= 0) {
            GL20.glUniform1fv((int)this.extraRef, (float[])this.extraVal);
        }
        if (this.phaseVal >= 0) {
            GL20.glUniform1fv((int)this.phaseVal, (float[])this.limitVal);
        }
        if (this.limitRef >= 0) {
            GL20.glUniform1fv((int)this.limitRef, (float[])this.speedVal);
        }
        if (this.paramRef >= 0) {
            GL20.glUniform3fv((int)this.paramRef, (float[])this.widthVal);
        }
        if (this.groupVal >= 0) {
            GL20.glUniform3fv((int)this.groupVal, (float[])this.chunkVal);
        }
        if (this.layerVal >= 0) {
            GL20.glUniform3fv((int)this.layerVal, (float[])this.blockRef);
        }
        if (this.slotVal >= 0) {
            GL20.glUniform3fv((int)this.slotVal, (float[])this.holderVal);
        }
        if (this.themeVal >= 0) {
            GL20.glUniform4fv((int)this.themeVal, (float[])this.timerVal);
        }
        if (this.stageVal >= 0) {
            GL20.glUniform4fv((int)this.stageVal, (float[])this.anchorVal);
        }
        if (this.widthRef >= 0) {
            GL20.glUniform2fv((int)this.widthRef, (float[])this.weightRef);
        }
    }

    private void primaryVal(float f, float f2, float f3, int n, int n2, float f4, long l) {
        this.primaryVal(f, f2, f3, n, n2, n, n2, f4, l);
    }

    private void primaryVal(float f, float f2, float f3, int n, int n2, int n3, int n4, float f4, long l) {
        if (GlCapabilityDetector.secondaryVal()) {
            return;
        }
        long l2 = System.nanoTime();
        RippleSlot panelVal = null;
        RippleSlot nvnNNunvv3 = this.weightVal[0];
        for (RippleSlot nvnNNunvv4 : this.weightVal) {
            if (!nvnNNunvv4.primaryVal) {
                panelVal = nvnNNunvv4;
                break;
            }
            if (nvnNNunvv4.secondaryVal >= nvnNNunvv3.secondaryVal) continue;
            nvnNNunvv3 = nvnNNunvv4;
        }
        if (panelVal == null) {
            panelVal = nvnNNunvv3;
        }
        panelVal.primaryVal = true;
        panelVal.tertiaryVal = f;
        panelVal.marginVal = f2;
        panelVal.weightVal = f3;
        panelVal.paramVal = f4;
        panelVal.extraVal = n;
        panelVal.limitVal = n2;
        panelVal.speedVal = n3;
        panelVal.widthVal = n4;
        panelVal.chunkVal = Math.max(1L, l);
        panelVal.secondaryVal = l2;
    }

    private void secondaryVal(long l) {
        for (RippleSlot panelVal : this.weightVal) {
            if (!panelVal.primaryVal || l - panelVal.secondaryVal < panelVal.chunkVal) continue;
            panelVal.primaryVal = false;
        }
    }

    private boolean limitVal() {
        RippleSlot[] nvnNNunvvArray = this.weightVal;
        int n = nvnNNunvvArray.length;
        for (int i = 0; i < n; ++i) {
            RippleSlot panelVal = nvnNNunvvArray[i];
            if (!panelVal.primaryVal) continue;
            return true;
        }
        return false;
    }

    private void speedVal() {
        for (RippleSlot panelVal : this.weightVal) {
            panelVal.primaryVal = false;
            panelVal.secondaryVal = 0L;
            panelVal.tertiaryVal = 0.0f;
            panelVal.marginVal = 0.0f;
            panelVal.weightVal = 0.0f;
            panelVal.paramVal = 0.0f;
            panelVal.extraVal = -1;
            panelVal.limitVal = -2232577;
            panelVal.speedVal = -1;
            panelVal.widthVal = -2232577;
            panelVal.chunkVal = 760000000L;
        }
    }

    private float primaryVal(int n) {
        return switch (n) {
            case 0 -> 0.9f;
            case 1 -> 0.84f;
            case 2 -> 0.96f;
            default -> 0.86f;
        };
    }

    private static float primaryVal(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static void primaryVal(int n, float[] fArray, int n2) {
        fArray[n2] = (float)(n >>> 16 & 0xFF) / 255.0f;
        fArray[n2 + 1] = (float)(n >>> 8 & 0xFF) / 255.0f;
        fArray[n2 + 2] = (float)(n & 0xFF) / 255.0f;
    }

    static final class RippleSlot {
        boolean primaryVal;
        long secondaryVal;
        float tertiaryVal;
        float marginVal;
        float weightVal;
        float paramVal;
        int extraVal = -1;
        int limitVal = -2232577;
        int speedVal = -1;
        int widthVal = -2232577;
        long chunkVal = 760000000L;

        RippleSlot() {
        }
    }

    record CapturedFramebuffer(GLStateSnapshot.Snapshot snapshot, int width, int height) {
    }
}

