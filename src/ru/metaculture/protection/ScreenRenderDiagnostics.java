/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.logging.LogUtils
 *  net.minecraft.class_437
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL30
 *  org.slf4j.Logger
 */
package ru.metaculture.protection;

import com.mojang.logging.LogUtils;
import net.minecraft.class_437;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.slf4j.Logger;
import ru.metaculture.protection.WildScreenMarker;

public final class ScreenRenderDiagnostics {
    private static final Logger primaryVal = LogUtils.getLogger();
    private static final boolean secondaryVal = Boolean.parseBoolean(System.getProperty("wild.debug.screenRender.enable", "false"));
    private static final long tertiaryVal = 2000000000L;
    private static volatile String marginVal = "unknown";
    private static volatile boolean weightVal;
    private static long paramVal;
    private static long extraVal;

    private ScreenRenderDiagnostics() {
    }

    public static boolean primaryVal() {
        return secondaryVal;
    }

    public static void primaryVal(class_437 class_4372, class_437 class_4373) {
        extraVal = 0L;
        paramVal = 0L;
        ScreenRenderDiagnostics.tertiaryVal();
        primaryVal.info("[ScreenRender] screen={} kind={} from={} gpu={}", new Object[]{ScreenRenderDiagnostics.primaryVal(class_4373), ScreenRenderDiagnostics.secondaryVal(class_4373), ScreenRenderDiagnostics.primaryVal(class_4372), marginVal});
    }

    public static void primaryVal(Object object, String string) {
        ScreenRenderDiagnostics.primaryVal(object, string, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void primaryVal(Object object, String string, String string2) {
        boolean bl;
        if (!secondaryVal) {
            return;
        }
        ++extraVal;
        long l = System.nanoTime();
        boolean bl2 = bl = l - paramVal >= 2000000000L;
        if (!secondaryVal && !bl) {
            return;
        }
        paramVal = l;
        WildClient modeVal = ScreenRenderDiagnostics.secondaryVal();
        if (string2 != null) {
            if (!string2.isBlank()) {
                Object[] objectArray = new Object[6];
                objectArray[0] = string;
                objectArray[1] = ScreenRenderDiagnostics.primaryVal(object);
                objectArray[2] = ScreenRenderDiagnostics.secondaryVal(object);
                objectArray[3] = extraVal;
                objectArray[4] = string2;
                objectArray[5] = modeVal;
                primaryVal.info("[ScreenRender] phase={} screen={} kind={} frame={} detail={} gl={}", objectArray);
                return;
            }
        }
        primaryVal.info("[ScreenRender] phase={} screen={} kind={} frame={} gl={}", new Object[]{string, ScreenRenderDiagnostics.primaryVal(object), ScreenRenderDiagnostics.secondaryVal(object), extraVal, modeVal});
    }

    public static void primaryVal(Object object, String string, boolean bl, String string2) {
        if (bl && !secondaryVal) {
            return;
        }
        Object[] objectArray = new Object[6];
        objectArray[0] = string;
        objectArray[1] = bl;
        objectArray[2] = ScreenRenderDiagnostics.primaryVal(object);
        objectArray[3] = ScreenRenderDiagnostics.secondaryVal(object);
        objectArray[4] = string2 == null ? "" : string2;
        objectArray[5] = ScreenRenderDiagnostics.secondaryVal();
        primaryVal.info("[ScreenRender] backdrop={} success={} screen={} kind={} detail={} gl={}", objectArray);
    }

    public static void primaryVal(Object object, String string, boolean bl, String string2, Throwable throwable) {
        if (bl && !secondaryVal) {
            return;
        }
        if (throwable != null) {
            Object[] objectArray = new Object[7];
            objectArray[0] = string;
            objectArray[1] = false;
            objectArray[2] = ScreenRenderDiagnostics.primaryVal(object);
            objectArray[3] = ScreenRenderDiagnostics.secondaryVal(object);
            objectArray[4] = string2 == null ? "" : string2;
            objectArray[5] = ScreenRenderDiagnostics.secondaryVal();
            objectArray[6] = throwable;
            primaryVal.warn("[ScreenRender] postRender={} success={} screen={} kind={} detail={} gl={}", objectArray);
            return;
        }
        primaryVal.info("[ScreenRender] postRender={} success={} screen={} kind={} detail={} gl={}", new Object[]{string, bl, ScreenRenderDiagnostics.primaryVal(object), ScreenRenderDiagnostics.secondaryVal(object), string2 == null ? "" : string2, ScreenRenderDiagnostics.secondaryVal()});
    }

    public static void primaryVal(String string, Object object, String string2, Throwable throwable) {
        if (throwable != null) {
            Object[] objectArray = new Object[6];
            objectArray[0] = string;
            objectArray[1] = ScreenRenderDiagnostics.primaryVal(object);
            objectArray[2] = ScreenRenderDiagnostics.secondaryVal(object);
            objectArray[3] = string2;
            objectArray[4] = ScreenRenderDiagnostics.secondaryVal();
            objectArray[5] = throwable;
            primaryVal.warn("[ScreenRender] failure={} screen={} kind={} reason={} gl={}", objectArray);
            return;
        }
        Object[] objectArray = new Object[5];
        objectArray[0] = string;
        objectArray[1] = ScreenRenderDiagnostics.primaryVal(object);
        objectArray[2] = ScreenRenderDiagnostics.secondaryVal(object);
        objectArray[3] = string2;
        objectArray[4] = ScreenRenderDiagnostics.secondaryVal();
        primaryVal.warn("[ScreenRender] failure={} screen={} kind={} reason={} gl={}", objectArray);
    }

    public static WildClient secondaryVal() {
        try {
            int n = GL11.glGetInteger((int)36006);
            int n2 = GL11.glGetInteger((int)36010);
            int n3 = GL11.glGetInteger((int)35725);
            int[] nArray = new int[4];
            GL11.glGetIntegerv((int)2978, (int[])nArray);
            int n4 = n == 0 ? 36053 : GL30.glCheckFramebufferStatus((int)36009);
            boolean bl = GL11.glGetBoolean((int)3107);
            boolean bl2 = GL11.glGetBoolean((int)3042);
            boolean bl3 = GL11.glGetBoolean((int)2929);
            boolean bl4 = GL11.glGetBoolean((int)3089);
            return new WildClient(n, n2, n3, nArray, n4, bl, bl2, bl3, bl4);
        }
        catch (Throwable throwable) {
            return new WildClient(-1, -1, -1, new int[4], -1, false, false, false, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void tertiaryVal() {
        if (weightVal) {
            return;
        }
        Class<ScreenRenderDiagnostics> clazz = ScreenRenderDiagnostics.class;
        synchronized (ScreenRenderDiagnostics.class) {
            if (weightVal) {
                // ** MonitorExit[var0] (shouldn't be in output)
                return;
            }
            try {
                String string = GL11.glGetString((int)7936);
                String string2 = GL11.glGetString((int)7937);
                String string3 = GL11.glGetString((int)7938);
                marginVal = "vendor=" + ScreenRenderDiagnostics.primaryVal(string) + " renderer=" + ScreenRenderDiagnostics.primaryVal(string2) + " version=" + ScreenRenderDiagnostics.primaryVal(string3);
            }
            catch (Throwable throwable) {
                marginVal = "unavailable";
            }
            weightVal = true;
            // ** MonitorExit[var0] (shouldn't be in output)
            return;
        }
    }

    private static String primaryVal(Object object) {
        return object == null ? "<none>" : object.getClass().getSimpleName();
    }

    private static String secondaryVal(Object object) {
        if (object == null) {
            return "none";
        }
        if (object instanceof WildScreenMarker) {
            return "raw-overlay";
        }
        if (object instanceof class_437) {
            String string = object.getClass().getName();
            if (string.startsWith("org.wild.")) {
                return "wild-custom";
            }
            if (string.startsWith("net.minecraft.")) {
                return "vanilla";
            }
            return "external";
        }
        return "external";
    }

    private static String primaryVal(String string) {
        return string == null ? "?" : string.replace('\n', ' ').trim();
    }

    public record WildClient(int drawFbo, int readFbo, int program, int[] viewport, int drawFramebufferStatus, boolean colorMask, boolean blend, boolean depthTest, boolean scissor) {
        @Override
        public String toString() {
            return "drawFbo=" + this.drawFbo + " readFbo=" + this.readFbo + " program=" + this.program + " viewport=" + this.viewport[0] + "x" + this.viewport[1] + "+" + this.viewport[2] + "x" + this.viewport[3] + " fbStatus=0x" + Integer.toHexString(this.drawFramebufferStatus) + " colorMask=" + this.colorMask + " blend=" + this.blend + " depth=" + this.depthTest + " scissor=" + this.scissor;
        }
    }
}

