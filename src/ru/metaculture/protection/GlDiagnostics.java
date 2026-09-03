/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import java.io.DataOutputStream;
import java.io.IOException;
import org.lwjgl.opengl.GL11;
import ru.metaculture.protection.FnvHasher;

public final class GlDiagnostics {
    private GlDiagnostics() {
    }

    public static int primaryVal() {
        try {
            return GL11.glGetInteger((int)35725);
        }
        catch (Throwable throwable) {
            return -1;
        }
    }

    public static int secondaryVal() {
        try {
            return GL11.glGetInteger((int)34016);
        }
        catch (Throwable throwable) {
            return -1;
        }
    }

    public static int tertiaryVal() {
        try {
            return GL11.glGetInteger((int)32873);
        }
        catch (Throwable throwable) {
            return -1;
        }
    }

    public static int marginVal() {
        try {
            for (int i = 0; i < 4; ++i) {
                int n = GL11.glGetError();
                if (n == 0) continue;
                return n;
            }
        }
        catch (Throwable throwable) {
            return -1;
        }
        return 0;
    }

    static void primaryVal(FnvHasher baseE) {
        if (baseE == null) {
            return;
        }
        baseE.primaryVal(GlDiagnostics.primaryVal());
        baseE.primaryVal(GlDiagnostics.secondaryVal());
        baseE.primaryVal(GlDiagnostics.tertiaryVal());
    }

    static void primaryVal(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(GlDiagnostics.primaryVal());
        dataOutputStream.writeInt(GlDiagnostics.secondaryVal());
        dataOutputStream.writeInt(GlDiagnostics.tertiaryVal());
        dataOutputStream.writeInt(GlDiagnostics.marginVal());
    }

    public static String primaryVal(int n) {
        String object;
        switch (n) {
            case 0: {
                object = "GL_NO_ERROR";
                break;
            }
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
            default: {
                object = "0x" + Integer.toHexString(n);
            }
        }
        return object;
    }
}

