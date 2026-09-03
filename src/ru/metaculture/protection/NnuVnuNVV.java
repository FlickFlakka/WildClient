/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.reflect.Method;
import ru.metaculture.protection.UuvNnuv;

public final class NnuVnuNVV {
    private static final boolean primaryVal;
    private static final Object secondaryVal;
    private static final Method tertiaryVal;
    private static final Method marginVal;

    private NnuVnuNVV() {
    }

    public static boolean primaryVal() {
        return NnuVnuNVV.tertiaryVal() == UuvNnuv.TRUE;
    }

    public static boolean secondaryVal() {
        return NnuVnuNVV.marginVal() == UuvNnuv.TRUE;
    }

    public static UuvNnuv tertiaryVal() {
        return NnuVnuNVV.primaryVal(tertiaryVal);
    }

    public static UuvNnuv marginVal() {
        return NnuVnuNVV.primaryVal(marginVal);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean weightVal() {
        if (!NnuVnuNVV.tertiaryVal().primaryVal()) return false;
        if (!NnuVnuNVV.marginVal().primaryVal()) return false;
        return true;
    }

    private static UuvNnuv primaryVal(Method method) {
        if (!primaryVal) {
            return UuvNnuv.FALSE;
        }
        if (secondaryVal == null || method == null) {
            return UuvNnuv.UNKNOWN;
        }
        try {
            Boolean bl;
            Object object = method.invoke(secondaryVal, new Object[0]);
            return UuvNnuv.primaryVal(true, true, object instanceof Boolean ? (bl = (Boolean)object) : null);
        }
        catch (LinkageError | ReflectiveOperationException | RuntimeException throwable) {
            return UuvNnuv.UNKNOWN;
        }
    }

    static {
        boolean bl = false;
        Object object = null;
        Method method = null;
        Method method2 = null;
        try {
            Class<?> clazz = Class.forName("net.irisshaders.iris.api.v0.IrisApi");
            bl = true;
            object = clazz.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            method = clazz.getMethod("isShaderPackInUse", new Class[0]);
            method2 = clazz.getMethod("isRenderingShadowPass", new Class[0]);
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (LinkageError | ReflectiveOperationException | RuntimeException throwable) {
            bl = true;
        }
        primaryVal = bl;
        secondaryVal = object;
        tertiaryVal = method;
        marginVal = method2;
    }
}

