/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.ShaderCompileResult;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.NodeGraphCompiler;
import ru.metaculture.protection.ThemeShaderManager;
import ru.metaculture.protection.ThemeShaderRenderer;
import ru.metaculture.protection.ThemeShaderProgramCache;

public final class ShaderCompileSession
implements AutoCloseable {
    private final NodeGraphCompiler primaryVal;
    private SurfaceTarget secondaryVal = SurfaceTarget.PREVIEW_ONLY;
    private String tertiaryVal = "";
    private String marginVal = "";

    public ShaderCompileSession(NodeGraphCompiler coreE) {
        this.primaryVal = coreE;
        ThemeShaderManager.primaryVal().primaryVal(coreE);
    }

    public SurfaceTarget primaryVal() {
        return this.secondaryVal;
    }

    public void primaryVal(SurfaceTarget vnuVUNUv) {
        if (vnuVUNUv != null) {
            this.secondaryVal = vnuVUNUv;
        }
    }

    public void primaryVal(NodeGraph nuVVnvn2) {
        if (nuVVnvn2 == null || this.primaryVal == null) {
            return;
        }
        ShaderCompileResult twigE = this.primaryVal.primaryVal(nuVVnvn2);
        this.tertiaryVal = twigE.hash();
        this.marginVal = twigE.error() == null ? "" : twigE.error();
        ThemeShaderManager.primaryVal().primaryVal(this.secondaryVal, nuVVnvn2, twigE);
        ThemeShaderProgramCache.primaryVal().primaryVal(this.secondaryVal, twigE);
    }

    public ShaderCompileResult secondaryVal(NodeGraph nuVVnvn2) {
        block3: {
            block2: {
                if (nuVVnvn2 == null) break block2;
                if (this.primaryVal != null) break block3;
            }
            return null;
        }
        ShaderCompileResult twigE = this.primaryVal.primaryVal(nuVVnvn2);
        this.tertiaryVal = twigE.hash();
        this.marginVal = twigE.error() == null ? "" : twigE.error();
        return twigE;
    }

    public boolean primaryVal(String string, NodeGraph nuVVnvn2) {
        if (nuVVnvn2 == null || this.primaryVal == null) {
            return false;
        }
        String string2 = ThemeShaderManager.widthVal(string);
        if (string2.isBlank()) {
            this.marginVal = "Shader name is empty";
            return false;
        }
        ShaderCompileResult twigE = this.primaryVal.primaryVal(nuVVnvn2);
        this.tertiaryVal = twigE.hash();
        String string3 = this.marginVal = twigE.error() == null ? "" : twigE.error();
        if (!this.marginVal.isBlank()) {
            return false;
        }
        ThemeShaderManager.primaryVal().primaryVal(string2, nuVVnvn2, twigE);
        ThemeShaderProgramCache.primaryVal().primaryVal(string2, twigE);
        return true;
    }

    public void primaryVal(NodeGraph nuVVnvn2, float f, float f2, float f3, float f4, int n, int n2, float f5, float f6, ThemePalette configVal, float f7) {
        if (nuVVnvn2 == null || configVal == null) {
            return;
        }
        this.primaryVal(nuVVnvn2);
        ThemeShaderRenderer.primaryVal(this.secondaryVal, f, f2, f3, f4, n, n2, f5, f6, configVal, f7);
    }

    public String secondaryVal() {
        if (!this.marginVal.isBlank()) {
            return this.marginVal;
        }
        return ThemeShaderProgramCache.primaryVal().primaryVal(this.secondaryVal);
    }

    public String tertiaryVal() {
        return this.tertiaryVal == null ? "" : this.tertiaryVal;
    }

    @Override
    public void close() {
        this.tertiaryVal = "";
        this.marginVal = "";
    }
}

