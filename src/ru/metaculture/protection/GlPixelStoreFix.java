/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL12
 *  org.lwjgl.opengl.GL13
 */
package ru.metaculture.protection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL13;
import ru.metaculture.protection.FontRegistry;

public final class GlPixelStoreFix {
    private static long primaryVal;
    private static long secondaryVal;

    private GlPixelStoreFix() {
    }

    public static void primaryVal() {
        long l = System.nanoTime();
        if (l - primaryVal < 2000000L) {
            return;
        }
        primaryVal = l;
        GlPixelStoreFix.marginVal();
    }

    public static void secondaryVal() {
        GlPixelStoreFix.marginVal();
    }

    private static void marginVal() {
        try {
            GL13.glActiveTexture((int)33984);
            GL11.glPixelStorei((int)3317, (int)4);
            GL12.glPixelStorei((int)3314, (int)0);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static void tertiaryVal() {
        long l = System.nanoTime();
        if (l - secondaryVal < 250000000L) {
            return;
        }
        secondaryVal = l;
        try {
            GL13.glActiveTexture((int)33984);
            GL11.glPixelStorei((int)3317, (int)4);
            GL12.glPixelStorei((int)3314, (int)0);
            FontRegistry.secondaryVal();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

