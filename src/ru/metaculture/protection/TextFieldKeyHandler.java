/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.ClickGuiState;

public final class TextFieldKeyHandler {
    public boolean primaryVal(ClickGuiState chunkRef, int n) {
        if (chunkRef.NUUVUvvuNNVU() != null) {
            chunkRef.secondaryVal(n);
            return true;
        }
        if (chunkRef.VUNvNUuNVnn() != null) {
            chunkRef.tertiaryVal(n);
            return true;
        }
        if (chunkRef.UNNunNuUNVuU() != null) {
            chunkRef.marginVal(n);
            return true;
        }
        if (chunkRef.vnUUvvnUVUu() != null) {
            this.weightVal(chunkRef, n);
            return true;
        }
        if (chunkRef.UvnnnuuNvUvv() != null) {
            this.paramVal(chunkRef, n);
            return true;
        }
        if (chunkRef.itemE() != null) {
            this.secondaryVal(chunkRef, n);
            return true;
        }
        if (chunkRef.UnUUVuVunvVu()) {
            this.marginVal(chunkRef, n);
            return true;
        }
        if (chunkRef.o0Ooc0COOoc()) {
            this.tertiaryVal(chunkRef, n);
            return true;
        }
        return false;
    }

    public boolean primaryVal(ClickGuiState chunkRef, char c) {
        if (chunkRef.vnUUvvnUVUu() != null) {
            this.secondaryVal(chunkRef, c);
            return true;
        }
        if (chunkRef.UvnnnuuNvUvv() != null) {
            this.tertiaryVal(chunkRef, c);
            return true;
        }
        if (chunkRef.itemE() != null) {
            if (!Character.isISOControl(c)) {
                chunkRef.itemE().weightVal = chunkRef.itemE().weightVal + c;
                chunkRef.depthRef();
            }
            return true;
        }
        if (chunkRef.UnUUVuVunvVu()) {
            if (!Character.isISOControl(c)) {
                chunkRef.secondaryVal(c);
            }
            return true;
        }
        if (chunkRef.o0Ooc0COOoc()) {
            if (!Character.isISOControl(c)) {
                chunkRef.primaryVal(c);
            }
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void secondaryVal(ClickGuiState chunkRef, int n) {
        if (n != 256) {
            if (n != 257) {
                if (n != 259) return;
                if (chunkRef.itemE().weightVal.isEmpty()) return;
                String string = chunkRef.itemE().weightVal;
                chunkRef.itemE().weightVal = string.substring(0, string.length() - 1);
                chunkRef.depthRef();
                return;
            }
        }
        chunkRef.primaryVal((StringFilterSetting)null);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void tertiaryVal(ClickGuiState chunkRef, int n) {
        if (n != 256 && n != 257) {
            if (n != 259) return;
            chunkRef.radiusVal();
            return;
        }
        chunkRef.speedVal(false);
    }

    private void marginVal(ClickGuiState chunkRef, int n) {
        if (n == 256) {
            chunkRef.sourceVal();
            chunkRef.widthVal(false);
        } else if (n == 257) {
            chunkRef.widthVal(false);
        } else if (n == 259) {
            chunkRef.extraRef();
        }
    }

    private void weightVal(ClickGuiState chunkRef, int n) {
        String string;
        ColorSetting nodeG = chunkRef.vnUUvvnUVUu();
        if (nodeG == null) {
            return;
        }
        if (n == 256) {
            chunkRef.weightVal((ColorSetting)null);
            chunkRef.paramVal("");
            return;
        }
        if (n == 257 || n == 258) {
            this.primaryVal(chunkRef, nodeG);
            chunkRef.weightVal((ColorSetting)null);
            chunkRef.paramVal("");
            return;
        }
        if (n == 259 && (string = chunkRef.linkB()) != null && !string.isEmpty()) {
            chunkRef.paramVal(string.substring(0, string.length() - 1));
        }
    }

    private void secondaryVal(ClickGuiState chunkRef, char c) {
        if (!TextFieldKeyHandler.primaryVal(c)) {
            return;
        }
        String string = chunkRef.linkB();
        if (string == null) {
            string = "";
        }
        if (string.length() >= 8) {
            return;
        }
        chunkRef.paramVal(string + Character.toUpperCase(c));
    }

    private void paramVal(ClickGuiState chunkRef, int n) {
        String string;
        ColorSetting nodeG = chunkRef.UvnnnuuNvUvv();
        if (nodeG == null) {
            return;
        }
        if (n == 256) {
            chunkRef.paramVal((ColorSetting)null);
            chunkRef.extraVal("");
            return;
        }
        if (n == 257 || n == 258) {
            this.secondaryVal(chunkRef, nodeG);
            chunkRef.paramVal((ColorSetting)null);
            chunkRef.extraVal("");
            return;
        }
        if (n == 259 && (string = chunkRef.uVUUnuunuv()) != null && !string.isEmpty()) {
            chunkRef.extraVal(string.substring(0, string.length() - 1));
        }
    }

    private void tertiaryVal(ClickGuiState chunkRef, char c) {
        if (c < '0' || c > '9') {
            return;
        }
        String string = chunkRef.uVUUnuunuv();
        if (string == null) {
            string = "";
        }
        if (string.length() >= 3) {
            return;
        }
        chunkRef.extraVal(string + c);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void primaryVal(ClickGuiState chunkRef, ColorSetting nodeG) {
        String string = chunkRef.linkB();
        if (string == null) {
            return;
        }
        String string2 = string.trim();
        if (string2.startsWith("#")) {
            string2 = string2.substring(1);
        }
        if (string2.isEmpty()) {
            return;
        }
        try {
            int n;
            long l = Long.parseUnsignedLong(string2, 16);
            switch (string2.length()) {
                case 3: {
                    int n2 = ((int)(l >> 8) & 0xF) * 17;
                    int n3 = ((int)(l >> 4) & 0xF) * 17;
                    int n4 = ((int)l & 0xF) * 17;
                    int n5 = Math.round(nodeG.anchorVal * 255.0f) & 0xFF;
                    n = n5 << 24 | n2 << 16 | n3 << 8 | n4;
                    break;
                }
                case 4: {
                    int n6 = ((int)(l >> 12) & 0xF) * 17;
                    int n7 = ((int)(l >> 8) & 0xF) * 17;
                    int n8 = ((int)(l >> 4) & 0xF) * 17;
                    int n9 = ((int)l & 0xF) * 17;
                    n = n9 << 24 | n6 << 16 | n7 << 8 | n8;
                    break;
                }
                case 6: {
                    int n10 = (int)l & 0xFFFFFF;
                    int n11 = Math.round(nodeG.anchorVal * 255.0f) & 0xFF;
                    n = n11 << 24 | n10;
                    break;
                }
                case 8: {
                    n = (int)l;
                    break;
                }
                default: {
                    return;
                }
            }
            nodeG.primaryVal(n);
            chunkRef.depthRef();
            return;
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    private void secondaryVal(ClickGuiState chunkRef, ColorSetting nodeG) {
        String string = chunkRef.uVUUnuunuv();
        if (string == null || string.isEmpty()) {
            return;
        }
        try {
            int n = Integer.parseUnsignedInt(string);
            if (n < 0) {
                n = 0;
            }
            if (n > 100) {
                n = 100;
            }
            nodeG.secondaryVal((float)n / 100.0f);
            chunkRef.depthRef();
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(char c) {
        if (c >= '0') {
            if (c <= '9') return true;
        }
        if (c >= 'a') {
            if (c <= 'f') return true;
        }
        if (c < 'A') return false;
        if (c > 'F') return false;
        return true;
    }
}

