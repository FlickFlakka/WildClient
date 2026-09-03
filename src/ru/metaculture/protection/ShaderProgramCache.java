/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL20
 */
package ru.metaculture.protection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.lwjgl.opengl.GL20;
import ru.metaculture.protection.GlDebugLogger;
import ru.metaculture.protection.ShaderProgram;

public final class ShaderProgramCache
implements AutoCloseable {
    private final Map<String, CompiledShader> primaryVal = new LinkedHashMap<String, CompiledShader>();
    private final Map<String, String> secondaryVal = new HashMap<String, String>();

    public CompiledShader primaryVal(String string, String string2, String string3) {
        CompiledShader modeVal = this.primaryVal.get(string);
        if (modeVal != null) {
            return modeVal;
        }
        String string4 = this.secondaryVal.get(string);
        if (string4 != null) {
            throw new IllegalStateException("Shader '" + string + "' previously failed: " + string4);
        }
        try {
            CompiledShader nodeC = new CompiledShader(ShaderProgram.primaryVal(string2, string3));
            this.primaryVal.put(string, nodeC);
            return nodeC;
        }
        catch (Throwable throwable) {
            RuntimeException runtimeException;
            this.secondaryVal.put(string, String.valueOf(throwable.getMessage()));
            GlDebugLogger.secondaryVal("shader-manager", "cached failure for '" + string + "', no further GL attempts: " + String.valueOf(throwable));
            if (throwable instanceof RuntimeException) {
                RuntimeException runtimeException2 = (RuntimeException)throwable;
                runtimeException = runtimeException2;
            } else {
                runtimeException = new IllegalStateException("Shader '" + string + "' failed", throwable);
            }
            throw runtimeException;
        }
    }

    public CompiledShader secondaryVal(String string, String string2, String string3) {
        CompiledShader modeVal = this.primaryVal.get(string);
        if (modeVal != null) {
            return modeVal;
        }
        if (this.secondaryVal.containsKey(string)) {
            return null;
        }
        try {
            return this.primaryVal(string, string2, string3);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    @Override
    public void close() {
        Iterator<CompiledShader> iterator = this.primaryVal.values().iterator();
        while (iterator.hasNext()) {
            CompiledShader modeVal = iterator.next();
            modeVal.close();
        }
        this.primaryVal.clear();
        this.secondaryVal.clear();
    }

    public void primaryVal() {
    }

    public static final class CompiledShader
    implements AutoCloseable {
        private final ShaderProgram primaryVal;
        private final Map<String, UniformCacheEntry> secondaryVal = new HashMap<String, UniformCacheEntry>();

        CompiledShader(ShaderProgram vVvUNNUVVnNn2) {
            this.primaryVal = vVvUNNUVVnNn2;
        }

        public void primaryVal() {
            GL20.glUseProgram((int)this.primaryVal.tertiaryVal());
        }

        public void primaryVal(String string, int n) {
            UniformCacheEntry panelVal = this.primaryVal(string);
            if (panelVal.primaryVal >= 0) {
                if (panelVal.primaryVal(0, n, 0.0f, 0.0f, 0.0f, 0.0f)) {
                    GL20.glUniform1i((int)panelVal.primaryVal, (int)n);
                }
            }
        }

        public void primaryVal(String string, float f) {
            UniformCacheEntry panelVal = this.primaryVal(string);
            if (panelVal.primaryVal >= 0) {
                if (panelVal.primaryVal(1, 0, f, 0.0f, 0.0f, 0.0f)) {
                    GL20.glUniform1f((int)panelVal.primaryVal, (float)f);
                }
            }
        }

        public void primaryVal(String string, float f, float f2) {
            UniformCacheEntry panelVal = this.primaryVal(string);
            if (panelVal.primaryVal >= 0 && panelVal.primaryVal(2, 0, f, f2, 0.0f, 0.0f)) {
                GL20.glUniform2f((int)panelVal.primaryVal, (float)f, (float)f2);
            }
        }

        public void primaryVal(String string, float f, float f2, float f3) {
            UniformCacheEntry panelVal = this.primaryVal(string);
            if (panelVal.primaryVal >= 0) {
                if (panelVal.primaryVal(3, 0, f, f2, f3, 0.0f)) {
                    GL20.glUniform3f((int)panelVal.primaryVal, (float)f, (float)f2, (float)f3);
                }
            }
        }

        public void primaryVal(String string, float f, float f2, float f3, float f4) {
            UniformCacheEntry panelVal = this.primaryVal(string);
            if (panelVal.primaryVal >= 0 && panelVal.primaryVal(4, 0, f, f2, f3, f4)) {
                GL20.glUniform4f((int)panelVal.primaryVal, (float)f, (float)f2, (float)f3, (float)f4);
            }
        }

        private UniformCacheEntry primaryVal(String string) {
            UniformCacheEntry panelVal = this.secondaryVal.get(string);
            if (panelVal == null) {
                panelVal = new UniformCacheEntry(this.primaryVal.primaryVal(string));
                this.secondaryVal.put(string, panelVal);
            }
            return panelVal;
        }

        @Override
        public void close() {
            this.primaryVal.secondaryVal();
            this.secondaryVal.clear();
        }
    }

    static final class UniformCacheEntry {
        final int primaryVal;
        private int secondaryVal = -1;
        private int tertiaryVal;
        private float marginVal;
        private float weightVal;
        private float paramVal;
        private float extraVal;

        UniformCacheEntry(int n) {
            this.primaryVal = n;
        }

        boolean primaryVal(int n, int n2, float f, float f2, float f3, float f4) {
            if (this.secondaryVal == n) {
                if (this.tertiaryVal == n2 && Float.floatToIntBits(this.marginVal) == Float.floatToIntBits(f) && Float.floatToIntBits(this.weightVal) == Float.floatToIntBits(f2) && Float.floatToIntBits(this.paramVal) == Float.floatToIntBits(f3) && Float.floatToIntBits(this.extraVal) == Float.floatToIntBits(f4)) {
                    return false;
                }
            }
            this.secondaryVal = n;
            this.tertiaryVal = n2;
            this.marginVal = f;
            this.weightVal = f2;
            this.paramVal = f3;
            this.extraVal = f4;
            return true;
        }
    }
}

