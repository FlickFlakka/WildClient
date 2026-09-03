/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_310;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public final class GlDebugLogger {
    private static final DateTimeFormatter primaryVal = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    private static final Set<String> secondaryVal = ConcurrentHashMap.newKeySet();
    private static final Object tertiaryVal = new Object();
    private static final boolean marginVal = Boolean.getBoolean("wild.debug.gl.breadcrumbs");
    private static File weightVal;
    private static boolean paramVal;
    private static boolean extraVal;

    private GlDebugLogger() {
    }

    public static boolean primaryVal() {
        return marginVal;
    }

    public static void primaryVal(String string, String string2) {
        if (!marginVal) {
            return;
        }
        GlDebugLogger.secondaryVal("[" + string + "] " + string2);
    }

    public static void secondaryVal(String string, String string2) {
        GlDebugLogger.secondaryVal("[" + string + "] " + string2);
    }

    public static void primaryVal(String string, String string2, String string3) {
        if (secondaryVal.add(string)) {
            GlDebugLogger.secondaryVal("[" + string2 + "] " + string3);
        }
    }

    public static boolean secondaryVal() {
        try {
            return GLFW.glfwGetCurrentContext() != 0L;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static String primaryVal(String string) {
        StringBuilder stringBuilder = null;
        try {
            int n;
            for (int i = 0; i < 16 && (n = GL11.glGetError()) != 0; ++i) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                } else {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(GlDebugLogger.primaryVal(n));
            }
        }
        catch (Throwable throwable) {
            return null;
        }
        if (stringBuilder == null) {
            return null;
        }
        String string2 = stringBuilder.toString();
        GlDebugLogger.secondaryVal("[gl-error] before " + string + ": " + string2);
        return string2;
    }

    public static String primaryVal(int n) {
        String object;
        switch (n) {
            case 1280: {
                object = "GL_INVALID_ENUM";
                break;
            }
            case 1281: {
                object = "GL_INVALID_VALUE";
                break;
            }
            case 1282: {
                object = "GL_INVALID_OPERATION";
                break;
            }
            case 1285: {
                object = "GL_OUT_OF_MEMORY";
                break;
            }
            case 1283: {
                object = "GL_STACK_OVERFLOW";
                break;
            }
            case 1284: {
                object = "GL_STACK_UNDERFLOW";
                break;
            }
            case 33305: {
                object = "GL_FRAMEBUFFER_UNDEFINED";
                break;
            }
            default: {
                object = "0x" + Integer.toHexString(n);
            }
        }
        return object;
    }

    public static String tertiaryVal() {
        if (!GlDebugLogger.secondaryVal()) {
            return "no current GL context on " + Thread.currentThread().getName();
        }
        try {
            return "vendor=" + GL11.glGetString((int)7936) + " renderer=" + GL11.glGetString((int)7937) + " version=" + GL11.glGetString((int)7938) + " thread=" + Thread.currentThread().getName();
        }
        catch (Throwable throwable) {
            return "context query failed: " + String.valueOf(throwable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void secondaryVal(String string) {
        try {
            Object object = tertiaryVal;
            synchronized (object) {
                File file = GlDebugLogger.marginVal();
                if (file == null) {
                    return;
                }
                try (PrintWriter printWriter = new PrintWriter(new FileWriter(file, true));){
                    if (!extraVal) {
                        extraVal = true;
                        printWriter.println();
                        printWriter.println("=== session " + LocalTime.now().format(primaryVal) + " | " + GlDebugLogger.tertiaryVal() + " ===");
                    }
                    printWriter.println(LocalTime.now().format(primaryVal) + " " + string);
                    printWriter.flush();
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static File marginVal() {
        if (paramVal) {
            return weightVal;
        }
        paramVal = true;
        try {
            class_310 class_3102 = class_310.method_1551();
            File file = class_3102 != null && class_3102.field_1697 != null ? class_3102.field_1697 : new File(".");
            weightVal = new File(file, "wild-gl.log");
        }
        catch (Throwable throwable) {
            weightVal = null;
        }
        return weightVal;
    }
}

