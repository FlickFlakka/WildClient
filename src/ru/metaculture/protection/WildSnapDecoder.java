/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Locale;
import ru.metaculture.protection.NvvuunnVUV;
import ru.metaculture.protection.GlDiagnosticCode;
import ru.metaculture.protection.GlDiagnostics;

public final class WildSnapDecoder {
    private WildSnapDecoder() {
    }

    public static void main(String[] stringArray) throws Exception {
        if (stringArray.length < 2) {
            System.out.println("usage: WildSnapDecoder <x25519-private-der-b64-or-file> <snapshot.wildsnap>");
            return;
        }
        byte[] byArray = WildSnapDecoder.primaryVal(stringArray[0]);
        byte[] byArray2 = Files.readAllBytes(Path.of(stringArray[1], new String[0]));
        byte[] byArray3 = NvvuunnVUV.primaryVal(byArray2, byArray);
        try (DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(byArray3));){
            int n = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            System.out.println("# WildSnap Report");
            System.out.println();
            System.out.println("- magic: 0x" + Integer.toHexString(n));
            System.out.println("- version: " + n2);
            while (dataInputStream.available() > 0) {
                int n3 = Short.toUnsignedInt(dataInputStream.readShort());
                int n4 = dataInputStream.readInt();
                byte[] byArray4 = dataInputStream.readNBytes(n4);
                WildSnapDecoder.primaryVal(n3, byArray4);
            }
        }
    }

    private static byte[] primaryVal(String string) throws Exception {
        Path path = Path.of(string, new String[0]);
        String string2 = Files.exists(path, new LinkOption[0]) ? Files.readString(path) : string;
        return Base64.getDecoder().decode(string2.replace("\n", "").replace("\r", "").trim());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void primaryVal(int n, byte[] byArray) throws Exception {
        try (DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(byArray));){
            switch (n) {
                case 1: {
                    WildSnapDecoder.primaryVal(dataInputStream);
                    return;
                }
                case 2: {
                    WildSnapDecoder.secondaryVal(dataInputStream);
                    return;
                }
                case 3: {
                    WildSnapDecoder.tertiaryVal(dataInputStream);
                    return;
                }
                case 4: {
                    WildSnapDecoder.marginVal(dataInputStream);
                    return;
                }
                case 5: {
                    WildSnapDecoder.weightVal(dataInputStream);
                    return;
                }
                case 6: {
                    WildSnapDecoder.paramVal(dataInputStream);
                    return;
                }
                case 7: {
                    WildSnapDecoder.extraVal(dataInputStream);
                    return;
                }
                default: {
                    System.out.println("- record[" + n + "]: " + WildSnapDecoder.primaryVal(byArray, Math.min(byArray.length, 96)));
                    return;
                }
            }
        }
    }

    private static void primaryVal(DataInputStream dataInputStream) throws Exception {
        System.out.println();
        System.out.println("## Build");
        System.out.println("- id: " + dataInputStream.readUTF());
        System.out.println("- version: " + dataInputStream.readUTF());
        System.out.println("- channel: " + dataInputStream.readUTF());
    }

    private static void secondaryVal(DataInputStream dataInputStream) throws Exception {
        int n = dataInputStream.readInt();
        int n2 = dataInputStream.readInt();
        int n3 = dataInputStream.readInt();
        long l = dataInputStream.readLong();
        long l2 = dataInputStream.readLong();
        int n4 = dataInputStream.readInt();
        System.out.println();
        System.out.println("## Core");
        System.out.println("- tracker: " + WildSnapDecoder.primaryVal(n));
        System.out.println("- code: " + GlDiagnosticCode.primaryVal(n2));
        System.out.println("- detail: 0x" + Integer.toHexString(n3));
        System.out.println("- cfi: 0x" + Long.toUnsignedString(l, 16));
        System.out.println("- frame: " + l2);
        System.out.println("- anomalyTotal: " + n4);
    }

    private static void tertiaryVal(DataInputStream dataInputStream) throws Exception {
        int n = dataInputStream.readInt();
        int n2 = dataInputStream.readInt();
        int n3 = dataInputStream.readInt();
        int n4 = dataInputStream.readInt();
        System.out.println();
        System.out.println("## GL");
        System.out.println("- currentProgram: " + n);
        System.out.println("- activeTexture: " + n2);
        System.out.println("- texture2D: " + n3);
        System.out.println("- error: " + GlDiagnostics.primaryVal(n4));
    }

    private static void marginVal(DataInputStream dataInputStream) throws Exception {
        long l = dataInputStream.readLong();
        boolean bl = dataInputStream.readBoolean();
        System.out.println();
        System.out.println("## Matrix");
        System.out.println("- hash: 0x" + Long.toUnsignedString(l, 16));
        System.out.println("- finite: " + bl);
        System.out.print("- modelView: [");
        for (int i = 0; i < 16; ++i) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(dataInputStream.readFloat());
        }
        System.out.println("]");
    }

    private static void weightVal(DataInputStream dataInputStream) throws Exception {
        int n = dataInputStream.readInt();
        System.out.println();
        System.out.println("## Anomalies");
        System.out.println("- count: " + n);
        for (int i = 0; i < n; ++i) {
            long l = dataInputStream.readLong();
            int n2 = dataInputStream.readInt();
            int n3 = dataInputStream.readInt();
            int n4 = dataInputStream.readInt();
            long l2 = dataInputStream.readLong();
            System.out.println("- " + WildSnapDecoder.primaryVal(n2) + " code=" + GlDiagnosticCode.primaryVal(n3) + " detail=0x" + Integer.toHexString(n4) + " nanos=" + l + " cfi=0x" + Long.toUnsignedString(l2, 16));
        }
    }

    private static void paramVal(DataInputStream dataInputStream) throws Exception {
        System.out.println();
        System.out.println("## Environment");
        System.out.println("- os.name: " + dataInputStream.readUTF());
        System.out.println("- os.arch: " + dataInputStream.readUTF());
        System.out.println("- java.version: " + dataInputStream.readUTF());
        System.out.println("- java.vm.name: " + dataInputStream.readUTF());
    }

    private static void extraVal(DataInputStream dataInputStream) throws Exception {
        System.out.println();
        System.out.println("## Mixin Audit");
        System.out.println("- policy: " + dataInputStream.readUTF());
        System.out.println("- locals: " + dataInputStream.readUTF());
    }

    private static String primaryVal(int n) {
        String string = Integer.toUnsignedString(n, 16).toUpperCase(Locale.ROOT);
        if (string.length() >= 8) {
            return "WS-" + string.substring(string.length() - 8);
        }
        return "WS-" + "00000000".substring(string.length()) + string;
    }

    private static String primaryVal(byte[] byArray, int n) {
        StringBuilder stringBuilder = new StringBuilder(n * 2);
        for (int i = 0; i < n; ++i) {
            int n2 = byArray[i] & 0xFF;
            if (n2 < 16) {
                stringBuilder.append('0');
            }
            stringBuilder.append(Integer.toHexString(n2));
        }
        return stringBuilder.toString();
    }
}

