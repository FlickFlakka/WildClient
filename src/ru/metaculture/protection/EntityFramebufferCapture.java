/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_10017
 *  net.minecraft.class_10042
 *  net.minecraft.class_1041
 *  net.minecraft.class_10868
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1921
 *  net.minecraft.class_1944
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3887
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4720
 *  net.minecraft.class_6367
 *  net.minecraft.class_761
 *  net.minecraft.class_765
 *  net.minecraft.class_898
 *  net.minecraft.class_9779
 *  net.minecraft.class_9799
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.joml.Matrix3fc
 *  org.joml.Matrix4fc
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL30
 *  org.lwjgl.system.MemoryStack
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.SequencedMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import net.minecraft.class_10017;
import net.minecraft.class_10042;
import net.minecraft.class_1041;
import net.minecraft.class_10868;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1921;
import net.minecraft.class_1944;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3887;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4720;
import net.minecraft.class_6367;
import net.minecraft.class_761;
import net.minecraft.class_765;
import net.minecraft.class_898;
import net.minecraft.class_9779;
import net.minecraft.class_9799;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joml.Matrix3fc;
import org.joml.Matrix4fc;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryStack;
import org.wild.mixin.acceser.EntityRenderDispatcherAccessor;
import ru.metaculture.protection.NnuVnuNVV;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.EntityRenderStateAccessor;

public final class EntityFramebufferCapture {
    private static final int primaryVal = 0x100000;
    private static final Logger secondaryVal = LogManager.getLogger((String)"EntityFramebufferCapture");
    private static final EntityFramebufferCapture tertiaryVal = new EntityFramebufferCapture();
    private static final Predicate<class_1297> marginVal = class_12972 -> true;
    private volatile class_6367 weightVal;
    private volatile class_6367 paramVal;
    private final Map<String, Predicate<class_1297>> extraVal = new ConcurrentHashMap<String, Predicate<class_1297>>();
    private final Map<String, Predicate<class_1297>> limitVal = new ConcurrentHashMap<String, Predicate<class_1297>>();
    private volatile boolean speedVal;
    private volatile boolean widthVal;
    private volatile boolean chunkVal;
    private volatile boolean blockRef;
    private volatile boolean holderVal;
    private volatile boolean timerVal;
    private volatile int anchorVal = -1;
    private volatile int weightRef = -1;
    private volatile int bufferVal;
    private volatile int countVal;
    private volatile int depthVal = Integer.MIN_VALUE;
    private int descRef;
    private WildClient activeVal;
    private final class_9799 radiusVal = new class_9799(0x100000);
    private final SequencedMap<class_1921, class_9799> factorVal = new LinkedHashMap<class_1921, class_9799>();

    private EntityFramebufferCapture() {
    }

    public static EntityFramebufferCapture primaryVal() {
        return tertiaryVal;
    }

    public void primaryVal(boolean bl) {
        if (this.speedVal == bl) {
            return;
        }
        this.speedVal = bl;
        this.activeVal();
    }

    public void primaryVal(String string, boolean bl, Predicate<class_1297> predicate) {
        block6: {
            block5: {
                if (string == null) break block5;
                if (!string.isBlank()) break block6;
            }
            throw new IllegalArgumentException("owner");
        }
        if (!bl) {
            this.primaryVal(string);
            return;
        }
        Predicate<class_1297> predicate2 = predicate == null ? marginVal : predicate;
        if (this.extraVal.get(string) == predicate2) {
            return;
        }
        this.extraVal.put(string, predicate2);
    }

    public void primaryVal(String string) {
        if (string == null || string.isBlank()) {
            return;
        }
        this.extraVal.remove(string);
        this.activeVal();
    }

    public void secondaryVal(String string, boolean bl, Predicate<class_1297> predicate) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("owner");
        }
        if (!bl || predicate == null) {
            this.secondaryVal(string);
            return;
        }
        if (this.limitVal.get(string) == predicate) {
            return;
        }
        this.limitVal.put(string, predicate);
    }

    public void secondaryVal(String string) {
        if (string == null || string.isBlank()) {
            return;
        }
        this.limitVal.remove(string);
        if (this.limitVal.isEmpty()) {
            this.chunkVal = false;
        }
    }

    private boolean countVal() {
        return !this.limitVal.isEmpty();
    }

    private boolean primaryVal(class_1297 class_12972) {
        if (this.limitVal.isEmpty()) {
            return false;
        }
        Iterator<Predicate<class_1297>> iterator = this.limitVal.values().iterator();
        while (iterator.hasNext()) {
            Predicate<class_1297> predicate = iterator.next();
            try {
                if (!predicate.test(class_12972)) continue;
                return true;
            }
            catch (RuntimeException runtimeException) {
                secondaryVal.warn("Entity tag filter failed for {}", (Object)class_12972.method_5477().getString(), (Object)runtimeException);
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean secondaryVal() {
        if (this.speedVal) return true;
        if (this.extraVal.isEmpty()) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean tertiaryVal() {
        if (!this.secondaryVal()) return false;
        if (!this.widthVal) return false;
        if (this.anchorVal <= 0) return false;
        if (this.weightRef <= 0) return false;
        if (!EntityFramebufferCapture.tertiaryVal((class_276)this.weightVal)) return false;
        return true;
    }

    public int marginVal() {
        return this.tertiaryVal() ? EntityFramebufferCapture.marginVal((class_276)this.weightVal) : 0;
    }

    public int weightVal() {
        return this.tertiaryVal() ? EntityFramebufferCapture.weightVal((class_276)this.weightVal) : 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean paramVal() {
        if (!this.secondaryVal()) return false;
        if (!this.countVal()) return false;
        if (!this.chunkVal) return false;
        if (!EntityFramebufferCapture.tertiaryVal((class_276)this.paramVal)) return false;
        return true;
    }

    public int extraVal() {
        return this.paramVal() ? EntityFramebufferCapture.marginVal((class_276)this.paramVal) : 0;
    }

    public int limitVal() {
        return this.paramVal() ? EntityFramebufferCapture.weightVal((class_276)this.paramVal) : 0;
    }

    public boolean speedVal() {
        return this.blockRef || this.holderVal;
    }

    public boolean widthVal() {
        return this.blockRef;
    }

    public void primaryVal(class_761 class_7612, class_9779 class_97792, class_4184 class_41842) {
        int n;
        if (!this.secondaryVal()) {
            this.radiusVal();
            return;
        }
        Objects.requireNonNull(class_7612, "worldRenderer");
        Objects.requireNonNull(class_97792, "tickCounter");
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1687 == null || class_3102.field_1773 == null) {
            this.radiusVal();
            return;
        }
        if (class_3102.field_1773.method_35765() || class_41842 == null) {
            this.radiusVal();
            return;
        }
        class_276 class_2762 = class_3102.method_1522();
        if (class_2762 == null) {
            this.radiusVal();
            return;
        }
        class_1041 class_10412 = class_3102.method_22683();
        int n2 = class_10412 != null ? class_10412.method_4489() : class_2762.field_1482;
        int n3 = n = class_10412 != null ? class_10412.method_4506() : class_2762.field_1481;
        if (n2 <= 0 || n <= 0) {
            this.radiusVal();
            this.descRef();
            this.anchorVal = -1;
            this.weightRef = -1;
            return;
        }
        if (!this.tertiaryVal(n2, n)) {
            this.radiusVal();
            return;
        }
        class_6367 class_63672 = this.weightVal;
        if (class_63672 == null) {
            this.radiusVal();
            return;
        }
        GpuTextureView gpuTextureView = class_63672.method_71639();
        if (gpuTextureView == null || gpuTextureView.isClosed()) {
            this.radiusVal();
            return;
        }
        GpuTextureView gpuTextureView2 = class_63672.method_71640();
        if (!this.primaryVal((class_276)class_63672)) {
            CommandEncoder commandEncoder = RenderSystem.getDevice().createCommandEncoder();
            GpuTexture gpuTexture = gpuTextureView.texture();
            if (gpuTextureView2 != null && !gpuTextureView2.isClosed()) {
                commandEncoder.clearColorAndDepthTextures(gpuTexture, 0, gpuTextureView2.texture(), 1.0);
            } else {
                commandEncoder.clearColorTexture(gpuTexture, 0);
            }
        }
        this.factorVal();
        try {
            this.radiusVal.method_60809();
            this.factorVal.values().forEach(class_9799::method_60809);
            this.activeVal = new WildClient(this.radiusVal, this.factorVal);
        }
        catch (RuntimeException runtimeException) {
            secondaryVal.warn("Failed to allocate capture resources", (Throwable)runtimeException);
            this.radiusVal();
            return;
        }
        this.secondaryVal(n2, n);
        this.widthVal = false;
        this.timerVal = true;
        this.bufferVal = 0;
    }

    private void secondaryVal(int n, int n2) {
        this.chunkVal = false;
        if (!this.countVal()) {
            this.depthVal();
            return;
        }
        if (!this.marginVal(n, n2)) {
            return;
        }
        class_6367 class_63672 = this.paramVal;
        if (class_63672 == null) {
            return;
        }
        GpuTextureView gpuTextureView = class_63672.method_71639();
        if (gpuTextureView == null || gpuTextureView.isClosed()) {
            return;
        }
        GpuTextureView gpuTextureView2 = class_63672.method_71640();
        if (!this.primaryVal((class_276)class_63672)) {
            CommandEncoder commandEncoder = RenderSystem.getDevice().createCommandEncoder();
            if (gpuTextureView2 != null && !gpuTextureView2.isClosed()) {
                commandEncoder.clearColorAndDepthTextures(gpuTextureView.texture(), 0, gpuTextureView2.texture(), 1.0);
            } else {
                commandEncoder.clearColorTexture(gpuTextureView.texture(), 0);
            }
        }
    }

    public void chunkVal() {
        block8: {
            WildClient modeVal = this.activeVal;
            try {
                if (modeVal == null) break block8;
                try {
                    this.primaryVal(modeVal);
                }
                finally {
                    modeVal.close();
                }
            }
            catch (RuntimeException runtimeException) {
                secondaryVal.warn("Failed to finalize capture frame", (Throwable)runtimeException);
                this.widthVal = false;
            }
            finally {
                this.activeVal = null;
                this.timerVal = false;
                this.countVal = this.bufferVal;
            }
        }
        this.widthVal = this.widthVal && EntityFramebufferCapture.tertiaryVal((class_276)this.weightVal);
        this.chunkVal = this.chunkVal && EntityFramebufferCapture.tertiaryVal((class_276)this.paramVal);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(class_1297 class_12972, double d, double d2, double d3, float f, class_4587 class_45872) {
        EntityRenderDispatcherAccessor entityRenderDispatcherAccessor;
        GpuTextureView gpuTextureView;
        class_6367 class_63672;
        WildClient modeVal;
        block27: {
            block26: {
                block25: {
                    block24: {
                        if (!this.secondaryVal()) break block24;
                        if (!this.timerVal || this.blockRef || this.holderVal || NnuVnuNVV.secondaryVal()) break block24;
                        if (class_12972 != null) break block25;
                    }
                    return;
                }
                if (class_12972 instanceof class_1309) {
                    if (this.primaryVal(class_12972)) {
                        this.secondaryVal(class_12972, d, d2, d3, f, class_45872);
                    }
                    return;
                }
                if (!this.secondaryVal(class_12972)) {
                    return;
                }
                Objects.requireNonNull(class_45872, "matrices");
                modeVal = this.activeVal;
                class_63672 = this.weightVal;
                if (modeVal == null || class_63672 == null || this.anchorVal <= 0 || this.weightRef <= 0) {
                    return;
                }
                gpuTextureView = class_63672.method_71639();
                if (gpuTextureView == null) break block26;
                if (!gpuTextureView.isClosed()) break block27;
            }
            return;
        }
        GpuTextureView gpuTextureView2 = class_63672.method_71640();
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1687 == null) {
            return;
        }
        class_898 class_8982 = class_3102.method_1561();
        if (class_8982 == null) {
            return;
        }
        class_4587 class_45873 = modeVal.primaryVal(class_45872);
        if (class_45873 == null) {
            return;
        }
        class_243 class_2432 = class_12972.method_30950(f);
        double d4 = class_2432.field_1352 - d;
        double d5 = class_2432.field_1351 - d2;
        double d6 = class_2432.field_1350 - d3;
        class_2338 class_23382 = class_2338.method_49638((class_2374)class_2432);
        int n = class_3102.field_1687.method_8314(class_1944.field_9282, class_23382);
        int n2 = class_3102.field_1687.method_8314(class_1944.field_9284, class_23382);
        int n3 = class_765.method_23687((int)n2, (int)n);
        GpuTextureView gpuTextureView3 = RenderSystem.outputColorTextureOverride;
        GpuTextureView gpuTextureView4 = RenderSystem.outputDepthTextureOverride;
        RenderSystem.outputColorTextureOverride = gpuTextureView;
        RenderSystem.outputDepthTextureOverride = gpuTextureView2;
        EntityRenderDispatcherAccessor entityRenderDispatcherAccessor2 = class_8982 instanceof EntityRenderDispatcherAccessor ? (entityRenderDispatcherAccessor = (EntityRenderDispatcherAccessor)class_8982) : null;
        boolean bl = entityRenderDispatcherAccessor2 != null;
        boolean bl2 = false;
        if (entityRenderDispatcherAccessor2 != null) {
            bl2 = entityRenderDispatcherAccessor2.night$getRenderShadows();
            entityRenderDispatcherAccessor2.night$setRenderShadows(false);
        }
        this.blockRef = true;
        try {
            try {
                class_8982.method_62424(class_12972, d4, d5, d6, f, class_45873, modeVal.primaryVal(), n3);
                modeVal.secondaryVal();
                ++this.bufferVal;
                this.widthVal = true;
            }
            finally {
                modeVal.tertiaryVal();
            }
        }
        catch (RuntimeException runtimeException) {
            secondaryVal.warn("Failed to visuals entity {} into capture framebuffer", (Object)class_12972.method_5477().getString(), (Object)runtimeException);
            this.widthVal = false;
        }
        finally {
            this.blockRef = false;
            if (bl) {
                entityRenderDispatcherAccessor2.night$setRenderShadows(bl2);
            }
            RenderSystem.outputColorTextureOverride = gpuTextureView3;
            RenderSystem.outputDepthTextureOverride = gpuTextureView4;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void secondaryVal(class_1297 class_12972, double d, double d2, double d3, float f, class_4587 class_45872) {
        EntityRenderDispatcherAccessor entityRenderDispatcherAccessor;
        GpuTextureView gpuTextureView;
        class_6367 class_63672;
        WildClient modeVal;
        block19: {
            block18: {
                modeVal = this.activeVal;
                class_63672 = this.paramVal;
                if (modeVal == null || class_63672 == null || !EntityFramebufferCapture.tertiaryVal((class_276)class_63672) || class_45872 == null) {
                    return;
                }
                gpuTextureView = class_63672.method_71639();
                if (gpuTextureView == null) break block18;
                if (!gpuTextureView.isClosed()) break block19;
            }
            return;
        }
        GpuTextureView gpuTextureView2 = class_63672.method_71640();
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1687 == null) {
            return;
        }
        class_898 class_8982 = class_3102.method_1561();
        if (class_8982 == null) {
            return;
        }
        class_4587 class_45873 = modeVal.primaryVal(class_45872);
        if (class_45873 == null) {
            return;
        }
        double d4 = class_3532.method_16436((double)f, (double)class_12972.field_6038, (double)class_12972.method_23317());
        double d5 = class_3532.method_16436((double)f, (double)class_12972.field_5971, (double)class_12972.method_23318());
        double d6 = class_3532.method_16436((double)f, (double)class_12972.field_5989, (double)class_12972.method_23321());
        double d7 = d4 - d;
        double d8 = d5 - d2;
        double d9 = d6 - d3;
        class_2338 class_23382 = class_2338.method_49637((double)d4, (double)d5, (double)d6);
        int n = class_3102.field_1687.method_8314(class_1944.field_9282, class_23382);
        int n2 = class_3102.field_1687.method_8314(class_1944.field_9284, class_23382);
        int n3 = class_765.method_23687((int)n2, (int)n);
        GpuTextureView gpuTextureView3 = RenderSystem.outputColorTextureOverride;
        GpuTextureView gpuTextureView4 = RenderSystem.outputDepthTextureOverride;
        RenderSystem.outputColorTextureOverride = gpuTextureView;
        RenderSystem.outputDepthTextureOverride = gpuTextureView2;
        EntityRenderDispatcherAccessor entityRenderDispatcherAccessor2 = class_8982 instanceof EntityRenderDispatcherAccessor ? (entityRenderDispatcherAccessor = (EntityRenderDispatcherAccessor)class_8982) : null;
        boolean bl = false;
        if (entityRenderDispatcherAccessor2 != null) {
            bl = entityRenderDispatcherAccessor2.night$getRenderShadows();
            entityRenderDispatcherAccessor2.night$setRenderShadows(false);
        }
        this.holderVal = true;
        try {
            try {
                class_8982.method_62424(class_12972, d7, d8, d9, f, class_45873, modeVal.primaryVal(), n3);
                modeVal.secondaryVal();
                this.chunkVal = true;
            }
            finally {
                modeVal.tertiaryVal();
            }
        }
        catch (RuntimeException runtimeException) {
            secondaryVal.warn("Failed to render tagged entity {} into capture framebuffer", (Object)class_12972.method_5477().getString(), (Object)runtimeException);
            this.chunkVal = false;
        }
        finally {
            this.holderVal = false;
            if (entityRenderDispatcherAccessor2 != null) {
                entityRenderDispatcherAccessor2.night$setRenderShadows(bl);
            }
            RenderSystem.outputColorTextureOverride = gpuTextureView3;
            RenderSystem.outputDepthTextureOverride = gpuTextureView4;
        }
    }

    public boolean blockRef() {
        return this.secondaryVal() && this.timerVal && this.anchorVal > 0 && this.weightRef > 0 && EntityFramebufferCapture.tertiaryVal((class_276)this.weightVal);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public class_4588 primaryVal(class_4588 class_45882, class_1921 class_19212, class_10042 class_100422) {
        class_4588 class_45883;
        block11: {
            block10: {
                if (class_45882 == null || class_19212 == null || !this.secondaryVal() || !this.timerVal || this.blockRef) break block10;
                if (!this.holderVal && !NnuVnuNVV.secondaryVal()) break block11;
            }
            return class_45882;
        }
        class_1309 class_13092 = this.secondaryVal(class_100422);
        WildClient modeVal = this.activeVal;
        class_6367 class_63672 = this.weightVal;
        if (class_13092 == null || modeVal == null || class_63672 == null) {
            return class_45882;
        }
        GpuTextureView gpuTextureView = class_63672.method_71639();
        if (gpuTextureView == null || gpuTextureView.isClosed()) {
            return class_45882;
        }
        GpuTextureView gpuTextureView2 = RenderSystem.outputColorTextureOverride;
        GpuTextureView gpuTextureView3 = RenderSystem.outputDepthTextureOverride;
        RenderSystem.outputColorTextureOverride = gpuTextureView;
        RenderSystem.outputDepthTextureOverride = class_63672.method_71640();
        try {
            class_4588 class_45884 = modeVal.primaryVal(class_19212);
            modeVal.secondaryVal();
            this.depthVal = class_13092.method_5628();
            class_45883 = class_4720.method_24037((class_4588)class_45882, (class_4588)class_45884);
        }
        catch (RuntimeException runtimeException) {
            secondaryVal.warn("Failed to prepare living layer {} for {}", (Object)class_19212, (Object)class_13092.method_5477().getString(), (Object)runtimeException);
            class_4588 class_45885 = class_45882;
            return class_45885;
        }
        finally {
            RenderSystem.outputColorTextureOverride = gpuTextureView2;
            RenderSystem.outputDepthTextureOverride = gpuTextureView3;
        }
        RenderSystem.outputColorTextureOverride = gpuTextureView2;
        RenderSystem.outputDepthTextureOverride = gpuTextureView3;
        return class_45883;
    }

    public void primaryVal(class_3887 class_38872, class_4587 class_45872, class_4597 class_45972, int n, class_10042 class_100422, float f, float f2) {
        class_1309 class_13092 = this.secondaryVal(class_100422);
        if (!this.secondaryVal() || !this.timerVal || this.blockRef || this.holderVal || NnuVnuNVV.secondaryVal() || class_13092 == null) {
            class_38872.method_4199(class_45872, class_45972, n, (class_10017)class_100422, f, f2);
            return;
        }
        class_4597 class_45973 = class_19212 -> this.primaryVal(class_45972.getBuffer(class_19212), class_19212, class_100422);
        class_38872.method_4199(class_45872, class_45973, n, (class_10017)class_100422, f, f2);
    }

    public void primaryVal(class_10042 class_100422) {
        class_1309 class_13092;
        block9: {
            block8: {
                if (this.holderVal) {
                    return;
                }
                if (NnuVnuNVV.secondaryVal()) {
                    this.depthVal = Integer.MIN_VALUE;
                    return;
                }
                class_13092 = this.secondaryVal(class_100422);
                if (class_13092 == null) break block8;
                if (this.depthVal == class_13092.method_5628()) break block9;
            }
            return;
        }
        WildClient modeVal = this.activeVal;
        this.depthVal = Integer.MIN_VALUE;
        if (modeVal == null) {
            return;
        }
        try {
            this.primaryVal(modeVal);
            ++this.bufferVal;
            this.widthVal = true;
        }
        catch (RuntimeException runtimeException) {
            secondaryVal.warn("Failed to finish living capture for {}", (Object)class_13092.method_5477().getString(), (Object)runtimeException);
            this.widthVal = false;
        }
    }

    public int holderVal() {
        return this.bufferVal;
    }

    public int timerVal() {
        return this.countVal;
    }

    public int anchorVal() {
        return this.factorVal.size();
    }

    public int weightRef() {
        return this.anchorVal;
    }

    public int bufferVal() {
        return this.weightRef;
    }

    public void primaryVal(Renderer2D heightVal, int n, int n2) {
        block6: {
            block5: {
                if (heightVal == null) break block5;
                if (n <= 0) break block5;
                if (n2 > 0) break block6;
            }
            return;
        }
        if (!this.tertiaryVal()) {
            return;
        }
        int n3 = EntityFramebufferCapture.marginVal((class_276)this.weightVal);
        if (n3 <= 0) {
            return;
        }
        heightVal.secondaryVal(n3, 0.0f, 0.0f, (float)n, (float)n2);
    }

    public void primaryVal(int n, int n2) {
        this.radiusVal();
        this.widthVal = false;
        if (n <= 0 || n2 <= 0 || n != this.anchorVal || n2 != this.weightRef) {
            this.descRef();
            this.depthVal();
            this.anchorVal = -1;
            this.weightRef = -1;
        }
    }

    private boolean tertiaryVal(int n, int n2) {
        if (n <= 0 || n2 <= 0) {
            this.descRef();
            this.anchorVal = -1;
            this.weightRef = -1;
            return false;
        }
        class_6367 class_63672 = this.weightVal;
        if (class_63672 != null && !EntityFramebufferCapture.tertiaryVal((class_276)class_63672)) {
            this.descRef();
            this.anchorVal = -1;
            this.weightRef = -1;
            class_63672 = null;
        }
        if (class_63672 == null) {
            try {
                this.weightVal = class_63672 = new class_6367("night_entity_capture", n, n2, true);
                this.anchorVal = n;
                this.weightRef = n2;
            }
            catch (RuntimeException runtimeException) {
                secondaryVal.warn("Failed to create capture framebuffer {}x{}", (Object)n, (Object)n2, (Object)runtimeException);
                this.weightVal = null;
                this.anchorVal = -1;
                this.weightRef = -1;
                return false;
            }
        }
        if (this.anchorVal != n || this.weightRef != n2) {
            try {
                class_63672.method_1234(n, n2);
                this.anchorVal = n;
                this.weightRef = n2;
            }
            catch (RuntimeException runtimeException) {
                secondaryVal.warn("Failed to resize capture framebuffer to {}x{}", (Object)n, (Object)n2, (Object)runtimeException);
                this.descRef();
                this.anchorVal = -1;
                this.weightRef = -1;
                return false;
            }
        }
        return EntityFramebufferCapture.tertiaryVal((class_276)class_63672);
    }

    private boolean marginVal(int n, int n2) {
        class_6367 class_63672;
        block11: {
            block10: {
                if (n <= 0 || n2 <= 0) {
                    this.depthVal();
                    return false;
                }
                class_63672 = this.paramVal;
                if (class_63672 != null && !EntityFramebufferCapture.tertiaryVal((class_276)class_63672)) {
                    this.depthVal();
                    class_63672 = null;
                }
                if (class_63672 == null) {
                    try {
                        this.paramVal = class_63672 = new class_6367("wild_tagged_capture", n, n2, true);
                    }
                    catch (RuntimeException runtimeException) {
                        secondaryVal.warn("Failed to create tagged capture framebuffer {}x{}", (Object)n, (Object)n2, (Object)runtimeException);
                        this.paramVal = null;
                        return false;
                    }
                }
                if (class_63672.field_1482 != n) break block10;
                if (class_63672.field_1481 == n2) break block11;
            }
            try {
                class_63672.method_1234(n, n2);
            }
            catch (RuntimeException runtimeException) {
                secondaryVal.warn("Failed to resize tagged capture framebuffer to {}x{}", (Object)n, (Object)n2, (Object)runtimeException);
                this.depthVal();
                return false;
            }
        }
        return EntityFramebufferCapture.tertiaryVal((class_276)class_63672);
    }

    private void depthVal() {
        class_6367 class_63672 = this.paramVal;
        if (class_63672 == null) {
            return;
        }
        if (!RenderSystem.isOnRenderThread()) {
            this.paramVal = null;
            return;
        }
        try {
            class_63672.method_1238();
        }
        catch (RuntimeException runtimeException) {
            secondaryVal.warn("Failed to delete tagged capture framebuffer", (Throwable)runtimeException);
        }
        this.paramVal = null;
    }

    private void descRef() {
        class_6367 class_63672 = this.weightVal;
        if (class_63672 == null && this.descRef == 0) {
            return;
        }
        if (!RenderSystem.isOnRenderThread()) {
            this.weightVal = null;
            this.descRef = 0;
            return;
        }
        if (class_63672 != null) {
            try {
                class_63672.method_1238();
            }
            catch (RuntimeException runtimeException) {
                secondaryVal.warn("Failed to delete capture framebuffer", (Throwable)runtimeException);
            }
            this.weightVal = null;
        }
        if (this.descRef != 0) {
            GL30.glDeleteFramebuffers((int)this.descRef);
            this.descRef = 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean primaryVal(class_276 class_2762) {
        int n;
        MemoryStack memoryStack;
        GpuTexture gpuTexture = class_2762.method_30277();
        if (!(gpuTexture instanceof class_10868)) {
            return false;
        }
        class_10868 class_108682 = (class_10868)gpuTexture;
        int n2 = class_108682.method_68427();
        GpuTexture gpuTexture2 = class_2762.method_30278();
        if (gpuTexture2 instanceof class_10868) {
            class_10868 class_108683 = (class_10868)gpuTexture2;
            n = class_108683.method_68427();
        } else {
            n = 0;
        }
        if (n2 <= 0) {
            return false;
        }
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            boolean bl;
            block22: {
                block20: {
                    boolean bl2;
                    block21: {
                        memoryStack = MemoryStack.stackPush();
                        try {
                            if (this.descRef == 0) {
                                this.descRef = GL30.glGenFramebuffers();
                            }
                            GL30.glBindFramebuffer((int)36160, (int)this.descRef);
                            GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n2, (int)0);
                            GL30.glFramebufferTexture2D((int)36160, (int)36096, (int)3553, (int)n, (int)0);
                            GL11.glDrawBuffer((int)36064);
                            if (GL30.glCheckFramebufferStatus((int)36160) == 36053) break block20;
                            bl2 = false;
                            if (memoryStack == null) break block21;
                        }
                        catch (Throwable throwable) {
                            try {
                                if (memoryStack != null) {
                                    try {
                                        memoryStack.close();
                                    }
                                    catch (Throwable throwable2) {
                                        throwable.addSuppressed(throwable2);
                                    }
                                }
                                throw throwable;
                            }
                            catch (RuntimeException runtimeException) {
                                secondaryVal.warn("Failed to clear capture framebuffer directly", (Throwable)runtimeException);
                                boolean bl3 = false;
                                return bl3;
                            }
                        }
                        memoryStack.close();
                    }
                    return bl2;
                }
                GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
                GL11.glDepthMask((boolean)true);
                FloatBuffer floatBuffer = memoryStack.floats(0.0f, 0.0f, 0.0f, 0.0f);
                GL30.glClearBufferfv((int)6144, (int)0, (FloatBuffer)floatBuffer);
                if (n > 0) {
                    FloatBuffer floatBuffer2 = memoryStack.floats(1.0f);
                    GL30.glClearBufferfv((int)6145, (int)0, (FloatBuffer)floatBuffer2);
                }
                bl = true;
                if (memoryStack == null) break block22;
                memoryStack.close();
            }
            return bl;
        }
        finally {
            if (this.descRef != 0) {
                GL30.glBindFramebuffer((int)36160, (int)this.descRef);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
                GL30.glFramebufferTexture2D((int)36160, (int)36096, (int)3553, (int)0, (int)0);
            }
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    private boolean secondaryVal(class_1297 class_12972) {
        if (this.speedVal) {
            return true;
        }
        for (Predicate<class_1297> predicate : this.extraVal.values()) {
            try {
                if (!predicate.test(class_12972)) continue;
                return true;
            }
            catch (RuntimeException runtimeException) {
                secondaryVal.warn("Entity capture filter failed for {}", (Object)class_12972.method_5477().getString(), (Object)runtimeException);
            }
        }
        return false;
    }

    private class_1309 secondaryVal(class_10042 class_100422) {
        class_1309 class_13092;
        if (class_100422 == null) {
            return null;
        }
        int n = ((EntityRenderStateAccessor)class_100422).wild$getEntityId();
        class_310 class_3102 = class_310.method_1551();
        class_1297 class_12972 = class_3102 != null && class_3102.field_1687 != null && n != Integer.MIN_VALUE ? class_3102.field_1687.method_8469(n) : null;
        return class_12972 instanceof class_1309 && this.secondaryVal((class_1297)(class_13092 = (class_1309)class_12972)) ? class_13092 : null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(WildClient modeVal) {
        class_6367 class_63672 = this.weightVal;
        if (modeVal == null || class_63672 == null) {
            return;
        }
        GpuTextureView gpuTextureView = class_63672.method_71639();
        if (gpuTextureView == null || gpuTextureView.isClosed()) {
            return;
        }
        GpuTextureView gpuTextureView2 = RenderSystem.outputColorTextureOverride;
        GpuTextureView gpuTextureView3 = RenderSystem.outputDepthTextureOverride;
        RenderSystem.outputColorTextureOverride = gpuTextureView;
        RenderSystem.outputDepthTextureOverride = class_63672.method_71640();
        this.blockRef = true;
        try {
            modeVal.tertiaryVal();
        }
        catch (Throwable throwable) {
            this.blockRef = false;
            RenderSystem.outputColorTextureOverride = gpuTextureView2;
            RenderSystem.outputDepthTextureOverride = gpuTextureView3;
            throw throwable;
        }
        this.blockRef = false;
        RenderSystem.outputColorTextureOverride = gpuTextureView2;
        RenderSystem.outputDepthTextureOverride = gpuTextureView3;
    }

    private void activeVal() {
        if (this.secondaryVal()) {
            return;
        }
        this.widthVal = false;
        this.chunkVal = false;
        this.blockRef = false;
        this.holderVal = false;
        this.timerVal = false;
        this.anchorVal = -1;
        this.weightRef = -1;
        this.bufferVal = 0;
        this.countVal = 0;
        this.depthVal = Integer.MIN_VALUE;
        this.factorVal();
        this.sourceVal();
        this.descRef();
        this.depthVal();
    }

    private void radiusVal() {
        this.widthVal = false;
        this.chunkVal = false;
        this.timerVal = false;
        this.bufferVal = 0;
        this.depthVal = Integer.MIN_VALUE;
        this.factorVal();
    }

    private void factorVal() {
        WildClient modeVal = this.activeVal;
        if (modeVal == null) {
            return;
        }
        try {
            try {
                modeVal.tertiaryVal();
            }
            catch (RuntimeException runtimeException) {
                secondaryVal.warn("Failed to flush capture resources during reset", (Throwable)runtimeException);
            }
            modeVal.close();
        }
        catch (RuntimeException runtimeException) {
            secondaryVal.warn("Failed to release capture resources", (Throwable)runtimeException);
        }
        this.activeVal = null;
    }

    private void sourceVal() {
        Iterator iterator = this.factorVal.values().iterator();
        while (iterator.hasNext()) {
            class_9799 class_97992 = (class_9799)iterator.next();
            try {
                class_97992.close();
            }
            catch (RuntimeException runtimeException) {
                secondaryVal.warn("Failed to close capture layer allocator", (Throwable)runtimeException);
            }
        }
        this.factorVal.clear();
    }

    private static boolean secondaryVal(class_276 class_2762) {
        if (class_2762 == null) {
            return false;
        }
        GpuTexture gpuTexture = class_2762.method_30277();
        if (!(gpuTexture instanceof class_10868)) {
            return false;
        }
        class_10868 class_108682 = (class_10868)gpuTexture;
        return class_108682.method_68427() > 0;
    }

    private static boolean tertiaryVal(class_276 class_2762) {
        if (!EntityFramebufferCapture.secondaryVal(class_2762)) {
            return false;
        }
        if (class_2762 instanceof class_6367) {
            class_6367 class_63672 = (class_6367)class_2762;
            GpuTextureView gpuTextureView = class_63672.method_71639();
            if (gpuTextureView == null || gpuTextureView.isClosed()) {
                return false;
            }
            GpuTextureView gpuTextureView2 = class_63672.method_71640();
            return gpuTextureView2 == null || !gpuTextureView2.isClosed();
        }
        return true;
    }

    private static int marginVal(class_276 class_2762) {
        if (class_2762 == null) {
            return 0;
        }
        GpuTexture gpuTexture = class_2762.method_30277();
        if (gpuTexture instanceof class_10868) {
            class_10868 class_108682 = (class_10868)gpuTexture;
            return class_108682.method_68427();
        }
        return 0;
    }

    private static int weightVal(class_276 class_2762) {
        if (class_2762 == null) {
            return 0;
        }
        GpuTexture gpuTexture = class_2762.method_30278();
        if (gpuTexture instanceof class_10868) {
            class_10868 class_108682 = (class_10868)gpuTexture;
            return class_108682.method_68427();
        }
        return 0;
    }

    static final class WildClient
    implements AutoCloseable {
        private final class_9799 primaryVal;
        private final SequencedMap<class_1921, class_9799> secondaryVal;
        private final class_4597.class_4598 tertiaryVal;
        private final class_4597 marginVal;
        private boolean weightVal;

        WildClient(class_9799 class_97992, SequencedMap<class_1921, class_9799> sequencedMap) {
            this.primaryVal = class_97992;
            this.secondaryVal = sequencedMap;
            this.tertiaryVal = class_4597.method_22992(sequencedMap, (class_9799)class_97992);
            this.marginVal = this::primaryVal;
        }

        class_4597 primaryVal() {
            return this.marginVal;
        }

        class_4588 primaryVal(class_1921 class_19213) {
            this.secondaryVal.computeIfAbsent(class_19213, class_19212 -> new class_9799(Math.max(4096, Math.min(class_19212.method_22722(), 262144))));
            this.weightVal = false;
            return this.tertiaryVal.getBuffer(class_19213);
        }

        class_4587 primaryVal(class_4587 class_45872) {
            if (class_45872 == null) {
                return null;
            }
            class_4587 class_45873 = new class_4587();
            class_4587.class_4665 class_46652 = class_45872.method_23760();
            class_4587.class_4665 class_46653 = class_45873.method_23760();
            class_46653.method_23761().set((Matrix4fc)class_46652.method_23761());
            class_46653.method_23762().set((Matrix3fc)class_46652.method_23762());
            return class_45873;
        }

        void secondaryVal() {
            this.weightVal = false;
        }

        void tertiaryVal() {
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

