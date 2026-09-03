/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.List;
import ru.metaculture.protection.ShaderUniformParam;

public record ShaderCompileResult(String fragmentSource, String hash, String error, List<ShaderUniformParam> exposedUniforms) {
    public ShaderCompileResult {
        exposedUniforms = exposedUniforms == null ? List.of() : List.copyOf(exposedUniforms);
    }

    public ShaderCompileResult(String string, String string2, String string3) {
        this(string, string2, string3, List.of());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean ok() {
        if (this.error == null) return true;
        if (!this.error.isBlank()) return false;
        return true;
    }
}

