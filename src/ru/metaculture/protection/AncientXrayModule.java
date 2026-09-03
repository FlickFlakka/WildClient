/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10799
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2626
 *  net.minecraft.class_2637
 *  net.minecraft.class_2664
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_10799;
import net.minecraft.class_1921;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2664;
import net.minecraft.class_2846;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ShapeRendererUtil;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="AncientXray", tertiaryVal=ModuleCategory.Visuals, secondaryVal="Search for debris after TNT explosion", marginVal={ModuleBadge.VIP})
public class AncientXrayModule
extends Module {
    private final Set<class_2338> countVal = ConcurrentHashMap.newKeySet();
    private final Set<class_2338> depthVal = ConcurrentHashMap.newKeySet();
    private final List<WildClient> descRef = new ArrayList<WildClient>();
    private static final int activeVal = 28;
    private static final int[] radiusVal;
    private long factorVal = 0L;
    private static final int sourceVal = 4096;
    private static final RenderPipeline extraRef;
    private static final class_1921 phaseVal;

    @Override
    public void onEnable() {
        super.onEnable();
        this.countVal.clear();
        this.depthVal.clear();
        this.descRef.clear();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (AncientXrayModule.mc.field_1724 == null || AncientXrayModule.mc.field_1687 == null) {
            return;
        }
        this.blockRef();
    }

    public void blockRef() {
        if (AncientXrayModule.mc.field_1724 == null || AncientXrayModule.mc.field_1687 == null) {
            return;
        }
        Iterator<WildClient> iterator = this.descRef.iterator();
        while (iterator.hasNext()) {
            WildClient object = iterator.next();
            --object.secondaryVal;
            if (object.secondaryVal > 0) continue;
            this.secondaryVal(object.primaryVal, 28);
            iterator.remove();
        }
        if (System.currentTimeMillis() - this.factorVal > 50L) {
            Iterator<class_2338> iterator2 = this.countVal.iterator();
            while (iterator2.hasNext()) {
                class_2338 class_23382 = iterator2.next();
                if (this.depthVal.contains(class_23382)) continue;
                this.depthVal.add(class_23382);
                this.marginVal(class_23382);
                this.factorVal = System.currentTimeMillis();
                break;
            }
        }
    }

    public void holderVal() {
        this.countVal.clear();
        this.depthVal.clear();
        this.descRef.clear();
    }

    public void primaryVal(class_2338 class_23382, int n) {
        if (class_23382 != null) {
            this.descRef.add(new WildClient(class_23382.method_10062(), n));
        }
    }

    public void primaryVal(class_2338 class_23382, class_2248 class_22482) {
        this.secondaryVal(class_23382, class_22482);
    }

    public List<class_2338> timerVal() {
        return new ArrayList<class_2338>(this.countVal);
    }

    public void primaryVal(class_2338 class_23382) {
        this.countVal.remove(class_23382);
        this.depthVal.remove(class_23382);
    }

    public boolean secondaryVal(class_2338 class_23382) {
        return this.countVal.contains(class_23382);
    }

    public boolean tertiaryVal(class_2338 class_23382) {
        return this.weightVal(class_23382);
    }

    private void marginVal(class_2338 class_23382) {
        if (mc.method_1562() != null) {
            mc.method_1562().method_52787((class_2596)new class_2846(class_2846.class_2847.field_12968, class_23382, class_2350.field_11036));
            mc.method_1562().method_52787((class_2596)new class_2846(class_2846.class_2847.field_12971, class_23382, class_2350.field_11036));
        }
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        if (AncientXrayModule.mc.field_1687 == null) {
            return;
        }
        class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
        if (class_25962 instanceof class_2664) {
            class_2664 class_26642 = (class_2664)class_25962;
            class_2338 class_23383 = class_2338.method_49638((class_2374)class_26642.comp_2883());
            for (int n : radiusVal) {
                this.primaryVal(class_23383, n);
            }
        } else {
            class_25962 = uvUUuvnunU2.marginVal();
            if (class_25962 instanceof class_2626) {
                class_2626 class_26262 = (class_2626)class_25962;
                this.secondaryVal(class_26262.method_11309(), class_26262.method_11308().method_26204());
            } else {
                class_25962 = uvUUuvnunU2.marginVal();
                if (class_25962 instanceof class_2637) {
                    class_2637 class_26372 = (class_2637)class_25962;
                    class_26372.method_30621((class_23382, class_26802) -> this.secondaryVal((class_2338)class_23382, class_26802.method_26204()));
                }
            }
        }
    }

    private void secondaryVal(class_2338 class_23382, class_2248 class_22482) {
        class_2338 class_23383 = class_23382.method_10062();
        if (class_22482 == class_2246.field_22109) {
            if (this.weightVal(class_23383) && this.countVal.add(class_23383)) {
                ChatLogger.primaryVal("§6[AncientXray] §fDebris found §e" + class_23383.method_23854());
            }
        } else {
            this.countVal.remove(class_23383);
            this.depthVal.remove(class_23383);
        }
    }

    private void secondaryVal(class_2338 class_23382, int n) {
        if (AncientXrayModule.mc.field_1687 == null) {
            return;
        }
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    class_2338 class_23383;
                    class_23392.method_10103(class_23382.method_10263() + i, class_23382.method_10264() + j, class_23382.method_10260() + k);
                    if (!this.weightVal((class_2338)class_23392) || !this.countVal.add(class_23383 = class_23392.method_10062())) continue;
                    ChatLogger.primaryVal("§fDebris detected: §e" + class_23383.method_23854());
                }
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean weightVal(class_2338 class_23382) {
        if (AncientXrayModule.mc.field_1687 == null) {
            return false;
        }
        class_2248 class_22482 = AncientXrayModule.mc.field_1687.method_8320(class_23382).method_26204();
        if (class_22482 != class_2246.field_22109) return false;
        if (!this.paramVal(class_23382)) return false;
        if (this.extraVal(class_23382)) return false;
        if (!this.limitVal(class_23382)) return false;
        if (this.speedVal(class_23382)) return false;
        return true;
    }

    private boolean paramVal(class_2338 class_23382) {
        int n = 0;
        for (class_2350 class_23502 : class_2350.values()) {
            class_2248 class_22482 = AncientXrayModule.mc.field_1687.method_8320(class_23382.method_10093(class_23502)).method_26204();
            if (class_22482 != class_2246.field_10124 && class_22482 != class_2246.field_10164 && class_22482 != class_2246.field_10543 || ++n < 2) continue;
            return true;
        }
        return false;
    }

    private boolean extraVal(class_2338 class_23382) {
        int n = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    class_2248 class_22482 = AncientXrayModule.mc.field_1687.method_8320(class_23382.method_10069(i, j, k)).method_26204();
                    if (class_22482 != class_2246.field_10213 && class_22482 != class_2246.field_23077 || ++n < 4) continue;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean limitVal(class_2338 class_23382) {
        int n = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    class_2248 class_22482 = AncientXrayModule.mc.field_1687.method_8320(class_23382.method_10069(i, j, k)).method_26204();
                    if (class_22482 != class_2246.field_10124 && class_22482 != class_2246.field_10164 && class_22482 != class_2246.field_10543) continue;
                    ++n;
                    if (n < 4) continue;
                    return true;
                }
            }
        }
        return n >= 4;
    }

    private boolean speedVal(class_2338 class_23382) {
        int n = 0;
        for (int i = -3; i <= 2; ++i) {
            for (int j = -2; j <= 2; ++j) {
                for (int k = -2; k <= 3; ++k) {
                    if (AncientXrayModule.mc.field_1687.method_8320(class_23382.method_10069(i, j, k)).method_26204() != class_2246.field_22109) continue;
                    ++n;
                    if (n <= 6) continue;
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        if (AncientXrayModule.mc.field_1687 == null || AncientXrayModule.mc.field_1724 == null || this.countVal.isEmpty()) {
            return;
        }
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            class_243 class_2432 = AncientXrayModule.mc.field_1773.method_19418().method_19326();
            Matrix4f matrix4f = vvuuvuVVvvn.tertiaryVal().method_23760().method_23761();
            int n = -2147418368;
            class_4588 class_45882 = class_45982.getBuffer(phaseVal);
            for (class_2338 class_23382 : this.countVal) {
                if (!AncientXrayModule.mc.field_1687.method_8320(class_23382).method_27852(class_2246.field_22109)) {
                    this.countVal.remove(class_23382);
                    continue;
                }
                float f = (float)((double)class_23382.method_10263() - class_2432.field_1352);
                float f2 = (float)((double)class_23382.method_10264() - class_2432.field_1351);
                float f3 = (float)((double)class_23382.method_10260() - class_2432.field_1350);
                float f4 = f + 1.0f;
                float f5 = f2 + 1.0f;
                float f6 = f3 + 1.0f;
                ShapeRendererUtil.WildClient.Box.primaryVal(class_45882, matrix4f, f, f2, f3, f4, f5, f6, n);
            }
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
    }

    static {
        int[] nArray = new int[4];
        nArray[0] = 4;
        nArray[1] = 10;
        nArray[2] = 20;
        nArray[3] = 40;
        radiusVal = nArray;
        RenderPipeline.Snippet[] snippetArray = new RenderPipeline.Snippet[1];
        snippetArray[0] = class_10799.field_56860;
        extraRef = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray).withLocation(class_2960.method_60655((String)"wild", (String)"block_esp_box")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        phaseVal = class_1921.method_24049((String)"block_esp_box", (int)4096, (boolean)false, (boolean)true, (RenderPipeline)extraRef, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
    }

    static class WildClient {
        class_2338 primaryVal;
        int secondaryVal;

        WildClient(class_2338 class_23382, int n) {
            this.primaryVal = class_23382;
            this.secondaryVal = n;
        }
    }
}

