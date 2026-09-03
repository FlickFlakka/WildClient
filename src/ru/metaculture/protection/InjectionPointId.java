/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class InjectionPointId {
    public static final int primaryVal = 257;
    public static final int secondaryVal = 258;
    public static final int tertiaryVal = 513;
    public static final int marginVal = 514;
    public static final int weightVal = 769;
    public static final int paramVal = 770;
    public static final int extraVal = 1025;
    public static final int limitVal = 1026;
    public static final int speedVal = 1281;
    public static final int widthVal = 1282;

    private InjectionPointId() {
    }

    public static String primaryVal(int n) {
        String object;
        switch (n) {
            case 257: {
                object = "CLIENT_TICK_HEAD";
                break;
            }
            case 258: {
                object = "CLIENT_TICK_TAIL";
                break;
            }
            case 513: {
                object = "GAME_RENDER_HEAD";
                break;
            }
            case 514: {
                object = "GAME_RENDER_TAIL";
                break;
            }
            case 769: {
                object = "SCREEN_RENDER_HEAD";
                break;
            }
            case 770: {
                object = "SCREEN_RENDER_TAIL";
                break;
            }
            case 1025: {
                object = "GUI_RENDER_BEGIN";
                break;
            }
            case 1026: {
                object = "GUI_RENDER_END";
                break;
            }
            case 1281: {
                object = "SHADER_DRAW_BEGIN";
                break;
            }
            case 1282: {
                object = "SHADER_DRAW_END";
                break;
            }
            default: {
                object = "UNKNOWN_" + Integer.toHexString(n);
            }
        }
        return object;
    }
}

