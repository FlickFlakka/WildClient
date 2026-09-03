/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class GlDiagnosticCode {
    public static final int primaryVal = 4097;
    public static final int secondaryVal = 4098;
    public static final int tertiaryVal = 8193;
    public static final int marginVal = 12289;
    public static final int weightVal = 16385;
    public static final int paramVal = 20481;
    public static final int extraVal = 24577;

    private GlDiagnosticCode() {
    }

    public static String primaryVal(int n) {
        String object;
        switch (n) {
            case 4097: {
                object = "GL_ERROR";
                break;
            }
            case 4098: {
                object = "GL_STATE_LEAK";
                break;
            }
            case 8193: {
                object = "PHASE_ORDER";
                break;
            }
            case 12289: {
                object = "MATRIX_INVALID";
                break;
            }
            case 16385: {
                object = "SNAPSHOT_FAILURE";
                break;
            }
            case 20481: {
                object = "MANUAL_SNAPSHOT";
                break;
            }
            case 24577: {
                object = "SHADER_EXCEPTION";
                break;
            }
            default: {
                object = "0x" + Integer.toHexString(n);
            }
        }
        return object;
    }
}

