/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_10868
 *  net.minecraft.class_1268
 *  net.minecraft.class_1921
 *  net.minecraft.class_276
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4720
 *  net.minecraft.class_6367
 *  net.minecraft.class_9799
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;
import net.minecraft.class_10868;
import net.minecraft.class_1268;
import net.minecraft.class_1921;
import net.minecraft.class_276;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4720;
import net.minecraft.class_6367;
import net.minecraft.class_9799;
import ru.metaculture.protection.NnuVnuNVV;

public final class HandFramebufferCapture {
    private static final int primaryVal = 262144;
    private static final HandFramebufferCapture secondaryVal = new HandFramebufferCapture();
    private final Map<class_1268, VvunVVUvUNnv> tertiaryVal = new EnumMap<class_1268, VvunVVUvUNnv>(class_1268.class);
    private boolean marginVal;
    private int weightVal = -1;
    private int paramVal = -1;

    private HandFramebufferCapture() {
        this.tertiaryVal.put(class_1268.field_5808, new VvunVVUvUNnv("wild_hands_main"));
        this.tertiaryVal.put(class_1268.field_5810, new VvunVVUvUNnv("wild_hands_off"));
    }

    public static HandFramebufferCapture primaryVal() {
        return secondaryVal;
    }

    public void primaryVal(boolean bl, boolean bl2, int n, int n2) {
        this.marginVal = false;
        this.tertiaryVal.values().forEach(VvunVVUvUNnv::secondaryVal);
        if (!bl && !bl2 || n <= 0 || n2 <= 0 || NnuVnuNVV.secondaryVal()) {
            return;
        }
        this.weightVal = n;
        this.paramVal = n2;
        VvunVVUvUNnv vvunVVUvUNnv = this.tertiaryVal.get(class_1268.field_5808);
        VvunVVUvUNnv vvunVVUvUNnv2 = this.tertiaryVal.get(class_1268.field_5810);
        try {
            if (bl) {
                if (vvunVVUvUNnv.primaryVal(n, n2)) {
                    vvunVVUvUNnv.primaryVal();
                    this.marginVal = true;
                }
            }
            if (bl2 && vvunVVUvUNnv2.primaryVal(n, n2)) {
                vvunVVUvUNnv2.primaryVal();
                this.marginVal = true;
            }
        }
        catch (RuntimeException runtimeException) {
            this.marginVal = false;
            this.tertiaryVal.values().forEach(VvunVVUvUNnv::secondaryVal);
        }
    }

    public class_4597 primaryVal(class_1268 class_12682, class_4597 class_45972) {
        VvunVVUvUNnv vvunVVUvUNnv;
        block3: {
            block2: {
                vvunVVUvUNnv = this.tertiaryVal.get(class_12682);
                if (!this.marginVal) break block2;
                if (vvunVVUvUNnv != null && vvunVVUvUNnv.tertiaryVal && class_45972 != null && !NnuVnuNVV.secondaryVal()) break block3;
            }
            return class_45972;
        }
        return class_19212 -> class_4720.method_24037((class_4588)class_45972.getBuffer(class_19212), (class_4588)vvunVVUvUNnv.primaryVal.weightVal.primaryVal(class_19212));
    }

    public class_4597 secondaryVal(class_1268 class_12682, class_4597 class_45972) {
        VvunVVUvUNnv vvunVVUvUNnv;
        block3: {
            block2: {
                vvunVVUvUNnv = this.tertiaryVal.get(class_12682);
                if (!this.marginVal || vvunVVUvUNnv == null || !vvunVVUvUNnv.tertiaryVal || class_45972 == null) break block2;
                if (!NnuVnuNVV.secondaryVal()) break block3;
            }
            return class_45972;
        }
        return class_19212 -> class_4720.method_24037((class_4588)class_45972.getBuffer(class_19212), (class_4588)vvunVVUvUNnv.secondaryVal.weightVal.primaryVal(class_19212));
    }

    public void primaryVal(class_1268 class_12682) {
        VvunVVUvUNnv vvunVVUvUNnv = this.tertiaryVal.get(class_12682);
        if (!this.marginVal || vvunVVUvUNnv == null || !vvunVVUvUNnv.tertiaryVal) {
            return;
        }
        vvunVVUvUNnv.primaryVal.secondaryVal();
        vvunVVUvUNnv.secondaryVal.secondaryVal();
    }

    public boolean secondaryVal(class_1268 class_12682) {
        VvunVVUvUNnv vvunVVUvUNnv = this.tertiaryVal.get(class_12682);
        return vvunVVUvUNnv != null && vvunVVUvUNnv.primaryVal.limitVal;
    }

    public int tertiaryVal(class_1268 class_12682) {
        VvunVVUvUNnv vvunVVUvUNnv = this.tertiaryVal.get(class_12682);
        return vvunVVUvUNnv == null || !vvunVVUvUNnv.primaryVal.limitVal ? 0 : HandFramebufferCapture.primaryVal((class_276)vvunVVUvUNnv.primaryVal.marginVal, false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int marginVal(class_1268 class_12682) {
        VvunVVUvUNnv vvunVVUvUNnv = this.tertiaryVal.get(class_12682);
        if (vvunVVUvUNnv == null) return 0;
        if (!vvunVVUvUNnv.primaryVal.limitVal) {
            return 0;
        }
        int n = HandFramebufferCapture.primaryVal((class_276)vvunVVUvUNnv.primaryVal.marginVal, true);
        return n;
    }

    public int weightVal(class_1268 class_12682) {
        VvunVVUvUNnv vvunVVUvUNnv = this.tertiaryVal.get(class_12682);
        return vvunVVUvUNnv == null || !vvunVVUvUNnv.secondaryVal.limitVal ? 0 : HandFramebufferCapture.primaryVal((class_276)vvunVVUvUNnv.secondaryVal.marginVal, false);
    }

    public void secondaryVal() {
        this.marginVal = false;
        this.weightVal = -1;
        this.paramVal = -1;
        this.tertiaryVal.values().forEach(VvunVVUvUNnv::tertiaryVal);
    }

    private static int primaryVal(class_276 class_2762, boolean bl) {
        int n;
        GpuTexture gpuTexture;
        if (class_2762 == null) {
            return 0;
        }
        GpuTexture gpuTexture2 = gpuTexture = bl ? class_2762.method_30278() : class_2762.method_30277();
        if (gpuTexture instanceof class_10868) {
            class_10868 class_108682 = (class_10868)gpuTexture;
            n = class_108682.method_68427();
        } else {
            n = 0;
        }
        return n;
    }

    static final class VvunVVUvUNnv {
        final WildClient primaryVal;
        final WildClient secondaryVal;
        boolean tertiaryVal;

        VvunVVUvUNnv(String string) {
            this.primaryVal = new WildClient(string + "_mask");
            this.secondaryVal = new WildClient(string + "_item");
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        boolean primaryVal(int n, int n2) {
            if (!this.primaryVal.primaryVal(n, n2)) return false;
            if (!this.secondaryVal.primaryVal(n, n2)) return false;
            return true;
        }

        void primaryVal() {
            this.primaryVal.primaryVal();
            this.secondaryVal.primaryVal();
            this.tertiaryVal = true;
        }

        private void secondaryVal() {
            this.tertiaryVal = false;
            this.primaryVal.marginVal();
            this.secondaryVal.marginVal();
        }

        private void tertiaryVal() {
            this.tertiaryVal = false;
            this.primaryVal.weightVal();
            this.secondaryVal.weightVal();
        }
    }

    static final class WildClient {
        private final String primaryVal;
        private final class_9799 secondaryVal = new class_9799(262144);
        private final SequencedMap<class_1921, class_9799> tertiaryVal = new LinkedHashMap<class_1921, class_9799>();
        class_6367 marginVal;
        cursorVal weightVal;
        private int paramVal = -1;
        private int extraVal = -1;
        boolean limitVal;

        WildClient(String string) {
            this.primaryVal = string;
        }

        boolean primaryVal(int n, int n2) {
            if (this.marginVal == null) {
                this.marginVal = new class_6367(this.primaryVal, n, n2, true);
                this.paramVal = n;
                this.extraVal = n2;
            } else if (this.paramVal != n || this.extraVal != n2) {
                this.marginVal.method_1234(n, n2);
                this.paramVal = n;
                this.extraVal = n2;
            }
            GpuTextureView gpuTextureView = this.marginVal.method_71639();
            GpuTextureView gpuTextureView2 = this.marginVal.method_71640();
            return gpuTextureView != null && !gpuTextureView.isClosed() && (gpuTextureView2 == null || !gpuTextureView2.isClosed());
        }

        void primaryVal() {
            this.marginVal();
            this.tertiaryVal();
            this.secondaryVal.method_60809();
            this.tertiaryVal.values().forEach(class_9799::method_60809);
            this.weightVal = new cursorVal(this.secondaryVal, this.tertiaryVal);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void secondaryVal() {
            GpuTextureView gpuTextureView;
            cursorVal panelVal;
            block9: {
                block8: {
                    panelVal = this.weightVal;
                    if (panelVal == null || !panelVal.marginVal || this.marginVal == null) {
                        return;
                    }
                    gpuTextureView = this.marginVal.method_71639();
                    if (gpuTextureView == null) break block8;
                    if (!gpuTextureView.isClosed()) break block9;
                }
                return;
            }
            GpuTextureView gpuTextureView2 = RenderSystem.outputColorTextureOverride;
            GpuTextureView gpuTextureView3 = RenderSystem.outputDepthTextureOverride;
            RenderSystem.outputColorTextureOverride = gpuTextureView;
            RenderSystem.outputDepthTextureOverride = this.marginVal.method_71640();
            try {
                panelVal.primaryVal();
                this.limitVal = true;
            }
            finally {
                RenderSystem.outputColorTextureOverride = gpuTextureView2;
                RenderSystem.outputDepthTextureOverride = gpuTextureView3;
            }
        }

        private void tertiaryVal() {
            if (this.marginVal == null) {
                return;
            }
            GpuTextureView gpuTextureView = this.marginVal.method_71639();
            GpuTextureView gpuTextureView2 = this.marginVal.method_71640();
            if (gpuTextureView == null || gpuTextureView.isClosed()) {
                return;
            }
            CommandEncoder commandEncoder = RenderSystem.getDevice().createCommandEncoder();
            if (gpuTextureView2 != null && !gpuTextureView2.isClosed()) {
                commandEncoder.clearColorAndDepthTextures(gpuTextureView.texture(), 0, gpuTextureView2.texture(), 1.0);
            } else {
                commandEncoder.clearColorTexture(gpuTextureView.texture(), 0);
            }
        }

        void marginVal() {
            this.limitVal = false;
            cursorVal panelVal = this.weightVal;
            this.weightVal = null;
            if (panelVal != null) {
                panelVal.close();
            }
        }

        void weightVal() {
            this.marginVal();
            Iterator iterator = this.tertiaryVal.values().iterator();
            while (iterator.hasNext()) {
                class_9799 class_97992 = (class_9799)iterator.next();
                class_97992.method_60809();
            }
            this.secondaryVal.method_60809();
            if (this.marginVal != null) {
                this.marginVal.method_1238();
                this.marginVal = null;
            }
            this.paramVal = -1;
            this.extraVal = -1;
        }
    }

    static final class cursorVal
    implements AutoCloseable {
        private final class_9799 primaryVal;
        private final SequencedMap<class_1921, class_9799> secondaryVal;
        private final class_4597.class_4598 tertiaryVal;
        boolean marginVal;
        private boolean weightVal;

        cursorVal(class_9799 class_97992, SequencedMap<class_1921, class_9799> sequencedMap) {
            this.primaryVal = class_97992;
            this.secondaryVal = sequencedMap;
            this.tertiaryVal = class_4597.method_22992(sequencedMap, (class_9799)class_97992);
        }

        class_4588 primaryVal(class_1921 class_19213) {
            this.secondaryVal.computeIfAbsent(class_19213, class_19212 -> new class_9799(Math.max(4096, Math.min(class_19212.method_22722(), 262144))));
            this.marginVal = true;
            this.weightVal = false;
            return this.tertiaryVal.getBuffer(class_19213);
        }

        void primaryVal() {
            if (this.weightVal) {
                return;
            }
            this.tertiaryVal.method_22993();
            this.primaryVal.method_60809();
            this.secondaryVal.values().forEach(class_9799::method_60809);
            this.weightVal = true;
        }

        @Override
        public void close() {
            this.primaryVal.method_60809();
            this.secondaryVal.values().forEach(class_9799::method_60809);
        }
    }
}

