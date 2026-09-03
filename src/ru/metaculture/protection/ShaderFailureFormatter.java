/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Locale;
import ru.metaculture.protection.GlDiagnostics;

public final class ShaderFailureFormatter {
    public static final int primaryVal = 3;
    public static final int secondaryVal = 14;
    private static final String tertiaryVal = "none";
    private static final String marginVal = "uniform";
    private static final String weightVal = "varying";
    private static final String paramVal = "link";
    private static final String extraVal = "compile";
    private static final String limitVal = "sampler";
    private static final String speedVal = "bind";

    private ShaderFailureFormatter() {
    }

    public static String primaryVal(String string, int n) {
        return "SHADER FAILURE #" + n + " stage=" + ShaderFailureFormatter.tertiaryVal(string, 96);
    }

    public static String primaryVal(int n, Throwable throwable) {
        if (throwable == null) {
            return "cause[" + n + "]=unknown";
        }
        return "cause[" + n + "]=" + throwable.getClass().getName();
    }

    public static String primaryVal(Throwable throwable) {
        if (throwable == null) {
            return "message=no throwable";
        }
        return "message=" + ShaderFailureFormatter.tertiaryVal(throwable.getMessage(), 260);
    }

    public static String secondaryVal(Throwable throwable) {
        String string;
        block8: {
            block7: {
                string = ShaderFailureFormatter.tertiaryVal(throwable).toLowerCase(Locale.ROOT);
                if (string.contains(marginVal)) {
                    return "GLSL DETAIL broken uniform binding/type; check declared name, std140 layout and Java upload type";
                }
                if (string.contains(weightVal)) break block7;
                if (!string.contains("in/out")) break block8;
            }
            return "GLSL DETAIL varying mismatch; check vertex output and fragment input names/types";
        }
        if (string.contains(paramVal)) {
            return "GLSL DETAIL program link failed; inspect attached shader interface and sampler layout";
        }
        if (string.contains(extraVal)) {
            return "GLSL DETAIL shader compile failed; inspect syntax, version and include expansion";
        }
        if (string.contains(limitVal) || string.contains(speedVal)) {
            return "GLSL DETAIL sampler/binding failure; check texture view lifetime and texture unit isolation";
        }
        return tertiaryVal;
    }

    public static String primaryVal(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            return tertiaryVal;
        }
        return "  at " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String secondaryVal(String string, int n) {
        return "OPENGL ERROR stage=" + ShaderFailureFormatter.tertiaryVal(string, 96) + " code=0x" + Integer.toHexString(n).toUpperCase(Locale.ROOT) + " name=" + GlDiagnostics.primaryVal(n);
    }

    public static String primaryVal() {
        return "GL STATE program=" + GlDiagnostics.primaryVal() + " activeTexture=" + GlDiagnostics.secondaryVal() + " texture2D=" + GlDiagnostics.tertiaryVal();
    }

    private static String tertiaryVal(Throwable throwable) {
        String string;
        block5: {
            block4: {
                if (throwable == null) {
                    return tertiaryVal;
                }
                string = throwable.getMessage();
                if (string == null) break block4;
                if (!string.isBlank()) break block5;
            }
            return throwable.getClass().getName();
        }
        return string;
    }

    private static String tertiaryVal(String string, int n) {
        if (string == null || string.isBlank()) {
            return tertiaryVal;
        }
        String string2 = string.replace('\n', ' ').replace('\r', ' ').trim();
        if (string2.length() <= n) {
            return string2;
        }
        return string2.substring(0, Math.max(0, n - 3)) + "...";
    }
}

