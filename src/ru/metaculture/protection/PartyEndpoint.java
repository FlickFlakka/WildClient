/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class PartyEndpoint {
    private final String primaryVal;
    private final int secondaryVal;

    private PartyEndpoint(String string, int n) {
        this.primaryVal = string;
        this.secondaryVal = n;
    }

    public static PartyEndpoint primaryVal() {
        return new PartyEndpoint(PartyEndpoint.primaryVal("wild.party.host", "127.0.0.1"), PartyEndpoint.marginVal());
    }

    public static PartyEndpoint primaryVal(String string, int n) {
        block3: {
            block2: {
                if (string == null || string.isBlank() || n < 1) break block2;
                if (n <= 65535) break block3;
            }
            return PartyEndpoint.primaryVal();
        }
        return new PartyEndpoint(string.trim(), n);
    }

    public String secondaryVal() {
        return this.primaryVal;
    }

    public int tertiaryVal() {
        return this.secondaryVal;
    }

    public String toString() {
        return this.primaryVal + ":" + this.secondaryVal;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static String primaryVal(String string, String string2) {
        String string3;
        String string4 = System.getProperty(string);
        if (string4 != null) {
            if (!string4.isBlank()) {
                string3 = string4.trim();
                return string3;
            }
        }
        string3 = string2;
        return string3;
    }

    private static int marginVal() {
        String string = System.getProperty("wild.party.port");
        if (string == null || string.isBlank()) {
            return 7331;
        }
        try {
            int n = Integer.parseInt(string.trim());
            return n < 1 || n > 65535 ? 7331 : n;
        }
        catch (NumberFormatException numberFormatException) {
            return 7331;
        }
    }
}

