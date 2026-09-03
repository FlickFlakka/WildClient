/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderSystem;
import java.nio.ByteBuffer;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import ru.metaculture.protection.ShaderCompileResult;
import ru.metaculture.protection.UvnUNnnVnu;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.FullscreenQuad;
import ru.metaculture.protection.ThemeShaderManager;
import ru.metaculture.protection.CoreDiagnosticsManager;
import ru.metaculture.protection.ShaderProgram;

public final class ThemeShaderProgramCache {
    private static final ThemeShaderProgramCache primaryVal = new ThemeShaderProgramCache();
    private static final String secondaryVal = "assets/wild/shaders/mainmenu/menu_quad.vert";
    private final Map<SurfaceTarget, WildClient> tertiaryVal = new EnumMap<SurfaceTarget, WildClient>(SurfaceTarget.class);
    private final Map<String, WildClient> marginVal = new HashMap<String, WildClient>();
    private FullscreenQuad weightVal;
    private String paramVal;
    private long extraVal;
    private int limitVal;

    private ThemeShaderProgramCache() {
    }

    public static ThemeShaderProgramCache primaryVal() {
        return primaryVal;
    }

    public FullscreenQuad secondaryVal() {
        if (this.weightVal == null) {
            this.weightVal = new FullscreenQuad();
        }
        return this.weightVal;
    }

    public float tertiaryVal() {
        if (this.extraVal == 0L) {
            this.extraVal = System.nanoTime();
            return 0.0f;
        }
        return (float)(System.nanoTime() - this.extraVal) / 1.0E9f % 720.0f;
    }

    public synchronized ShaderProgram primaryVal(SurfaceTarget vnuVUNUv, ShaderCompileResult twigE) {
        if (vnuVUNUv == null || twigE == null || twigE.fragmentSource() == null) {
            return null;
        }
        WildClient modeVal = this.tertiaryVal.get((Object)vnuVUNUv);
        String string = twigE.hash();
        if (modeVal != null) {
            if (modeVal.primaryVal != null && modeVal.secondaryVal.equals(string)) {
                return modeVal.primaryVal;
            }
        }
        if (modeVal != null && modeVal.primaryVal != null) {
            modeVal.primaryVal.secondaryVal();
            modeVal.primaryVal = null;
        }
        if (modeVal == null) {
            modeVal = new WildClient();
            this.tertiaryVal.put(vnuVUNUv, modeVal);
        }
        try {
            String string2 = this.paramVal();
            modeVal.primaryVal = new ShaderProgram(string2, twigE.fragmentSource());
            modeVal.secondaryVal = string;
            modeVal.tertiaryVal = twigE.error();
            return modeVal.primaryVal;
        }
        catch (Throwable throwable) {
            modeVal.tertiaryVal = throwable.getMessage() == null ? throwable.getClass().getSimpleName() : throwable.getMessage();
            modeVal.primaryVal = null;
            modeVal.secondaryVal = "";
            CoreDiagnosticsManager.primaryVal().secondaryVal("ThemeShaderProgramCache.acquire:" + vnuVUNUv.primaryVal(), throwable);
            throw new IllegalStateException("unreachable shader failure", throwable);
        }
    }

    public synchronized ShaderProgram primaryVal(String string, ShaderCompileResult twigE) {
        String string2;
        block9: {
            block8: {
                string2 = ThemeShaderManager.widthVal(string);
                if (string2.isBlank()) break block8;
                if (twigE != null && twigE.fragmentSource() != null) break block9;
            }
            return null;
        }
        WildClient modeVal = this.marginVal.get(string2);
        String string3 = twigE.hash();
        if (modeVal != null && modeVal.primaryVal != null && modeVal.secondaryVal.equals(string3)) {
            return modeVal.primaryVal;
        }
        if (modeVal != null && modeVal.primaryVal != null) {
            modeVal.primaryVal.secondaryVal();
            modeVal.primaryVal = null;
        }
        if (modeVal == null) {
            modeVal = new WildClient();
            this.marginVal.put(string2, modeVal);
        }
        try {
            String string4 = this.paramVal();
            modeVal.primaryVal = new ShaderProgram(string4, twigE.fragmentSource());
            modeVal.secondaryVal = string3;
            modeVal.tertiaryVal = twigE.error();
            return modeVal.primaryVal;
        }
        catch (Throwable throwable) {
            modeVal.tertiaryVal = throwable.getMessage() == null ? throwable.getClass().getSimpleName() : throwable.getMessage();
            modeVal.primaryVal = null;
            modeVal.secondaryVal = "";
            CoreDiagnosticsManager.primaryVal().secondaryVal("ThemeShaderProgramCache.acquire:" + string2, throwable);
            throw new IllegalStateException("unreachable shader failure", throwable);
        }
    }

    public synchronized String primaryVal(SurfaceTarget vnuVUNUv) {
        WildClient modeVal = this.tertiaryVal.get((Object)vnuVUNUv);
        return modeVal == null || modeVal.tertiaryVal == null ? "" : modeVal.tertiaryVal;
    }

    public synchronized String primaryVal(String string) {
        WildClient modeVal = this.marginVal.get(ThemeShaderManager.widthVal(string));
        return modeVal == null || modeVal.tertiaryVal == null ? "" : modeVal.tertiaryVal;
    }

    public synchronized String secondaryVal(SurfaceTarget vnuVUNUv) {
        WildClient modeVal = this.tertiaryVal.get((Object)vnuVUNUv);
        return modeVal == null ? "" : modeVal.secondaryVal;
    }

    public synchronized String secondaryVal(String string) {
        WildClient modeVal = this.marginVal.get(ThemeShaderManager.widthVal(string));
        return modeVal == null ? "" : modeVal.secondaryVal;
    }

    public synchronized void tertiaryVal(SurfaceTarget vnuVUNUv) {
        WildClient modeVal = this.tertiaryVal.remove((Object)vnuVUNUv);
        if (modeVal != null && modeVal.primaryVal != null && ThemeShaderProgramCache.extraVal()) {
            modeVal.primaryVal.secondaryVal();
            modeVal.primaryVal = null;
        }
    }

    public synchronized void tertiaryVal(String string) {
        WildClient modeVal = this.marginVal.remove(ThemeShaderManager.widthVal(string));
        if (modeVal != null && modeVal.primaryVal != null && ThemeShaderProgramCache.extraVal()) {
            modeVal.primaryVal.secondaryVal();
            modeVal.primaryVal = null;
        }
    }

    public synchronized void marginVal() {
        boolean bl = ThemeShaderProgramCache.extraVal();
        Iterator<WildClient> iterator = this.tertiaryVal.values().iterator();
        while (iterator.hasNext()) {
            WildClient modeVal = iterator.next();
            if (modeVal.primaryVal != null && bl) {
                modeVal.primaryVal.secondaryVal();
            }
            modeVal.primaryVal = null;
        }
        for (WildClient modeVal : this.marginVal.values()) {
            if (modeVal.primaryVal != null && bl) {
                modeVal.primaryVal.secondaryVal();
            }
            modeVal.primaryVal = null;
        }
        this.tertiaryVal.clear();
        this.marginVal.clear();
        if (this.weightVal != null && bl) {
            this.weightVal.close();
        }
        this.weightVal = null;
        if (this.limitVal > 0 && bl) {
            GL11.glDeleteTextures((int)this.limitVal);
        }
        this.limitVal = 0;
        this.extraVal = 0L;
        this.paramVal = null;
    }

    public synchronized int weightVal() {
        if (this.limitVal > 0) {
            return this.limitVal;
        }
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer((int)4);
        byteBuffer.put((byte)-1).put((byte)-1).put((byte)-1).put((byte)-1).flip();
        this.limitVal = GL11.glGenTextures();
        GL11.glBindTexture((int)3553, (int)this.limitVal);
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
        GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
        GL11.glTexImage2D((int)3553, (int)0, (int)32856, (int)1, (int)1, (int)0, (int)6408, (int)5121, (ByteBuffer)byteBuffer);
        GL11.glBindTexture((int)3553, (int)0);
        return this.limitVal;
    }

    private String paramVal() {
        if (this.paramVal == null) {
            this.paramVal = UvnUNnnVnu.primaryVal(secondaryVal);
        }
        return this.paramVal;
    }

    private static boolean extraVal() {
        return RenderSystem.isOnRenderThread() && GLFW.glfwGetCurrentContext() != 0L;
    }

    static final class WildClient {
        ShaderProgram primaryVal;
        String secondaryVal = "";
        String tertiaryVal = "";

        WildClient() {
        }
    }
}

