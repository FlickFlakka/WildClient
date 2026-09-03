/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.lwjgl.opengl.GL11;
import ru.metaculture.protection.ShaderCompileResult;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.NodePort;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.NodeInstance;
import ru.metaculture.protection.ShaderCompileSession;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.VvNNUnNNVn;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.NodeDefinitionRegistry;
import ru.metaculture.protection.NodeGraphCompiler;
import ru.metaculture.protection.ThemeShaderRenderer;
import ru.metaculture.protection.NodeDefinition;
import ru.metaculture.protection.FontRegistry;

public final class NodePreviewCache
implements AutoCloseable {
    private final NodeDefinitionRegistry primaryVal;
    private final NodeGraphCompiler secondaryVal;
    private final VvNNUnNNVn tertiaryVal = new VvNNUnNNVn();
    private final Map<String, WildClient> marginVal = new HashMap<String, WildClient>();

    public NodePreviewCache(NodeDefinitionRegistry nodeI, NodeGraphCompiler coreE) {
        this.primaryVal = nodeI;
        this.secondaryVal = coreE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(NodeGraph nuVVnvn2, String string, ShaderCompileSession kelpB, Renderer2D heightVal, float f, float f2, float f3, float f4, int n, int n2, ThemePalette configVal, float f5) {
        Object object;
        Object object2;
        if (nuVVnvn2 == null || string == null || heightVal == null || f3 <= 2.0f || f4 <= 2.0f || f5 <= 0.001f) {
            return;
        }
        NodeInstance queueVal = nuVVnvn2.tertiaryVal(string);
        NodeDefinition spanJ = queueVal == null ? null : this.primaryVal.primaryVal(queueVal.secondaryVal());
        NodePort cellA = NodePreviewCache.primaryVal(spanJ);
        if (cellA == null) {
            return;
        }
        String string2 = "__node_preview_" + string;
        WildClient modeVal = this.marginVal.get(string2);
        int n3 = nuVVnvn2.weightVal();
        if (modeVal == null || modeVal.version != n3 || !cellA.id().equals(modeVal.pinId)) {
            object2 = nuVVnvn2.weightVal(string);
            ((NodeGraph)object2).primaryVal(SurfaceTarget.PREVIEW_ONLY.primaryVal());
            object = this.secondaryVal.primaryVal((NodeGraph)object2, string, cellA.id(), cellA.type());
            modeVal = new WildClient(n3, cellA.id(), object == null ? "" : ((ShaderCompileResult)object).hash(), (ShaderCompileResult)object);
            this.marginVal.put(string2, modeVal);
        }
        if ((object2 = modeVal.compilation) == null || !((ShaderCompileResult)object2).ok()) {
            NodePreviewCache.primaryVal(heightVal, f, f2, f3, f4, configVal, f5);
            return;
        }
        heightVal.tertiaryVal();
        object = GLStateSnapshot.primaryVal();
        try {
            int n4 = Math.max(32, Math.min(512, (int)Math.ceil(f3)));
            int n5 = Math.max(32, Math.min(384, (int)Math.ceil(f4)));
            this.tertiaryVal.primaryVal(n4, n5);
            if (!this.tertiaryVal.paramVal()) {
                return;
            }
            this.tertiaryVal.primaryVal();
            GL11.glDisable((int)3089);
            GlStateManager._enableBlend();
            GL11.glEnable((int)3042);
            GL11.glClearColor((float)0.008f, (float)0.01f, (float)0.015f, (float)0.0f);
            GL11.glClear((int)16384);
            ThemeShaderRenderer.primaryVal("__node_preview_" + modeVal.hash, (ShaderCompileResult)object2, 0.0f, 0.0f, (float)n4, (float)n5, n4, n5, f3 * 0.5f, f4 * 0.5f, configVal, f5);
        }
        finally {
            GLStateSnapshot.tertiaryVal((GLStateSnapshot.Snapshot)object);
        }
        heightVal.secondaryVal(this.tertiaryVal.tertiaryVal(), f, f2, f3, f4, ThemePalette.primaryVal(-1, Math.round(255.0f * f5)), true);
    }

    private static NodePort primaryVal(NodeDefinition spanJ) {
        if (spanJ == null || spanJ.paramVal().isEmpty()) {
            return null;
        }
        Iterator<NodePort> iterator = spanJ.paramVal().iterator();
        while (iterator.hasNext()) {
            NodePort cellA = iterator.next();
            if (!"color".equals(cellA.id())) {
                if (!"mask".equals(cellA.id())) {
                    if (!"value".equals(cellA.id())) continue;
                }
            }
            return cellA;
        }
        return spanJ.paramVal().get(0);
    }

    private static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, ThemePalette configVal, float f5) {
        int n = ThemePalette.primaryVal(40, 10, 14, Math.round(132.0f * f5));
        int n2 = ThemePalette.primaryVal(255, 134, 146, Math.round(230.0f * f5));
        heightVal.primaryVal(f, f2, f3, f4, 8.0f, n);
        float f6 = UiRenderUtil.primaryVal(null, FontRegistry.primaryVal, "preview error", 9.0f);
        UiRenderUtil.primaryVal(heightVal, null, FontRegistry.primaryVal, f + (f3 - f6) * 0.5f, f2, f4, 9.0f, "preview error", n2);
    }

    @Override
    public void close() {
        this.tertiaryVal.close();
        this.marginVal.clear();
    }

    static final class WildClient
     {
        final int version;
        final String pinId;
        final String hash;
        final ShaderCompileResult compilation;

        WildClient(int n, String string, String string2, ShaderCompileResult twigE) {
            this.version = n;
            this.pinId = string;
            this.hash = string2;
            this.compilation = twigE;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "version=" + this.version + ", " + "pinId=" + this.pinId + ", " + "hash=" + this.hash + ", " + "compilation=" + this.compilation + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.version, this.pinId, this.hash, this.compilation);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.version, that.version) && java.util.Objects.equals(this.pinId, that.pinId) && java.util.Objects.equals(this.hash, that.hash) && java.util.Objects.equals(this.compilation, that.compilation);}

        public int version() {
            return this.version;
        }

        public String pinId() {
            return this.pinId;
        }

        public String hash() {
            return this.hash;
        }

        public ShaderCompileResult compilation() {
            return this.compilation;
        }
    }
}

