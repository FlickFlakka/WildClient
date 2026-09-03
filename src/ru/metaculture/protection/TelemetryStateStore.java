/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HexFormat;
import java.util.List;
import java.util.UUID;
import ru.metaculture.protection.TelemetryPayload;

public final class TelemetryStateStore {
    private static final Gson primaryVal = new Gson();
    private static volatile boolean secondaryVal;

    private TelemetryStateStore() {
    }

    public static TelemetryPayload primaryVal() {
        secondaryVal = false;
        TelemetryPayload spanB = null;
        boolean bl = false;
        boolean bl2 = false;
        for (Path path : TelemetryStateStore.tertiaryVal()) {
            if (!Files.exists(path, new LinkOption[0])) continue;
            bl = true;
            try {
                String string = Files.readString(path, StandardCharsets.UTF_8);
                LoadResult modeVal = TelemetryStateStore.primaryVal(string);
                if (modeVal == null || modeVal.state == null) {
                    bl2 = true;
                    continue;
                }
                TelemetryPayload peakF = TelemetryStateStore.primaryVal(modeVal.state, modeVal.legacy);
                if (spanB != null) {
                    if (TelemetryStateStore.secondaryVal(peakF) <= TelemetryStateStore.secondaryVal(spanB)) continue;
                }
                spanB = peakF;
            }
            catch (Throwable throwable) {
                bl2 = true;
            }
        }
        if (spanB == null) {
            secondaryVal = bl && bl2;
            spanB = TelemetryPayload.primaryVal();
            TelemetryStateStore.primaryVal(spanB);
        } else {
            TelemetryStateStore.primaryVal(spanB);
        }
        return TelemetryStateStore.primaryVal(spanB, false);
    }

    public static void primaryVal(TelemetryPayload spanB) {
        TelemetryStateStore.primaryVal(spanB, false);
        String string = TelemetryStateStore.tertiaryVal(spanB);
        for (Path path : TelemetryStateStore.marginVal()) {
            try {
                Files.createDirectories(path.getParent(), new FileAttribute[0]);
                Path path2 = path.resolveSibling(String.valueOf(path.getFileName()) + "." + ProcessHandle.current().pid() + "." + Thread.currentThread().getId() + "." + System.nanoTime() + ".tmp");
                Files.writeString(path2, (CharSequence)string, StandardCharsets.UTF_8, new OpenOption[0]);
                try {
                    Files.move(path2, path, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
                }
                catch (IOException iOException) {
                    Files.move(path2, path, StandardCopyOption.REPLACE_EXISTING);
                }
            }
            catch (IOException iOException) {}
        }
    }

    public static boolean secondaryVal() {
        return secondaryVal;
    }

    private static long secondaryVal(TelemetryPayload spanB) {
        long l = spanB.marginVal ? Math.max(spanB.weightVal, 1L) : 0L;
        return Math.max(spanB.tertiaryVal, l);
    }

    private static String tertiaryVal(TelemetryPayload spanB) {
        String string = primaryVal.toJson((Object)spanB);
        String string2 = Base64.getUrlEncoder().withoutPadding().encodeToString(string.getBytes(StandardCharsets.UTF_8));
        String string3 = TelemetryStateStore.secondaryVal(string2 + "|" + TelemetryStateStore.weightVal() + "|" + TelemetryStateStore.primaryVal(2));
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("v", (Number)2);
        jsonObject.addProperty("data", string2);
        jsonObject.addProperty("sum", string3);
        return primaryVal.toJson((JsonElement)jsonObject);
    }

    private static LoadResult primaryVal(String string) {
        String string2;
        JsonObject jsonObject = JsonParser.parseString((String)string).getAsJsonObject();
        String string3 = jsonObject.get("data").getAsString();
        String string4 = jsonObject.get("sum").getAsString();
        byte[] byArray = Base64.getUrlDecoder().decode(string3);
        TelemetryPayload spanB = (TelemetryPayload)primaryVal.fromJson(new String(byArray, StandardCharsets.UTF_8), TelemetryPayload.class);
        String string5 = TelemetryStateStore.secondaryVal(string3 + "|" + TelemetryStateStore.weightVal() + "|" + TelemetryStateStore.primaryVal(2));
        if (TelemetryStateStore.primaryVal(string4, string5)) {
            return new LoadResult(spanB, false);
        }
        String string6 = TelemetryStateStore.secondaryVal(string3 + "|" + TelemetryStateStore.paramVal() + "|" + TelemetryStateStore.primaryVal(2));
        if (TelemetryStateStore.primaryVal(string4, string6)) {
            return new LoadResult(spanB, false);
        }
        String string7 = TelemetryStateStore.secondaryVal(string3 + "|" + TelemetryStateStore.extraVal() + "|" + TelemetryStateStore.primaryVal(2));
        if (TelemetryStateStore.primaryVal(string4, string7)) {
            return new LoadResult(spanB, false);
        }
        String string8 = string2 = spanB == null ? "" : String.valueOf(spanB.secondaryVal);
        if (!string2.isBlank()) {
            String string9 = TelemetryStateStore.secondaryVal(string3 + "|" + string2 + "|" + TelemetryStateStore.primaryVal(1));
            if (TelemetryStateStore.primaryVal(string4, string9)) {
                return new LoadResult(spanB, true);
            }
        }
        return null;
    }

    private static List<Path> tertiaryVal() {
        ArrayList<Path> arrayList = new ArrayList<Path>();
        arrayList.addAll(TelemetryStateStore.marginVal());
        String string = System.getenv("APPDATA");
        String string2 = System.getenv("LOCALAPPDATA");
        String string3 = System.getProperty("user.home", ".");
        if (string != null && !string.isBlank()) {
            arrayList.add(Path.of(string, "LoadResult", "state.dat"));
        }
        if (string2 != null && !string2.isBlank()) {
            arrayList.add(Path.of(string2, "LoadResult", "cache.dat"));
        }
        arrayList.add(Path.of(string3, ".wildclient", "state.dat"));
        String[] stringArray = new String[3];
        stringArray[0] = ".minecraft";
        stringArray[1] = "wildclient";
        stringArray[2] = "state.dat";
        arrayList.add(Path.of(string3, stringArray));
        return arrayList;
    }

    private static List<Path> marginVal() {
        return List.of(ru.metaculture.protection.WildClient.secondaryVal().toPath().resolve("auth").resolve("state.dat"));
    }

    private static String secondaryVal(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            return HexFormat.of().formatHex(messageDigest.digest(string.getBytes(StandardCharsets.UTF_8)));
        }
        catch (Throwable throwable) {
            throw new IllegalStateException(throwable);
        }
    }

    private static boolean primaryVal(String string, String string2) {
        if (string == null || string2 == null) {
            return false;
        }
        byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
        byte[] byArray2 = string2.getBytes(StandardCharsets.UTF_8);
        if (byArray.length != byArray2.length) {
            return false;
        }
        int n = 0;
        for (int i = 0; i < byArray.length; ++i) {
            n |= byArray[i] ^ byArray2[i];
        }
        return n == 0;
    }

    private static TelemetryPayload primaryVal(TelemetryPayload spanB, boolean bl) {
        String string;
        block8: {
            block7: {
                if (spanB == null) {
                    spanB = TelemetryPayload.primaryVal();
                }
                if (spanB.primaryVal == null) break block7;
                if (!spanB.primaryVal.isBlank()) break block8;
            }
            spanB.primaryVal = UUID.randomUUID().toString();
        }
        String string2 = string = spanB.secondaryVal == null ? "" : spanB.secondaryVal;
        if (!string.isBlank() && !string.equals("wild-1.21.8-1787661348375")) {
            spanB.marginVal = false;
            spanB.weightVal = 0L;
            spanB.paramVal = 0;
            spanB.extraVal = 0;
            spanB.limitVal = "";
        }
        if (bl && !string.isBlank() && !string.equals("wild-1.21.8-1787661348375") && TelemetryStateStore.primaryVal(spanB, "E4", string)) {
            spanB.marginVal = false;
            spanB.weightVal = 0L;
            spanB.paramVal = 0;
            spanB.extraVal = 0;
            spanB.limitVal = "";
        }
        spanB.secondaryVal = "wild-1.21.8-1787661348375";
        spanB.tertiaryVal = Math.max(0L, spanB.tertiaryVal);
        spanB.weightVal = Math.max(0L, spanB.weightVal);
        spanB.paramVal = Math.max(0, spanB.paramVal);
        spanB.extraVal = Math.max(0, spanB.extraVal);
        if (spanB.limitVal == null) {
            spanB.limitVal = "";
        }
        return spanB;
    }

    private static boolean primaryVal(TelemetryPayload spanB, String string, String string2) {
        String string3 = TelemetryStateStore.secondaryVal(string2 + "|" + string + "|wild-fuse-v1");
        return TelemetryStateStore.primaryVal(String.valueOf(spanB.limitVal), string3);
    }

    private static String weightVal() {
        return TelemetryStateStore.secondaryVal("wild|state|seal|2");
    }

    private static String paramVal() {
        String string = "-----BEGIN PUBLIC KEY-----\nMCowBQYDK2VwAyEAgqu9hOrz4JQKl2izQlnpj+d8jkT988LVfYfXPvKyt2Y=\n-----END PUBLIC KEY-----\n".replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s+", "");
        return TelemetryStateStore.secondaryVal(string + "|state|2");
    }

    private static String extraVal() {
        String string = "-----BEGIN PUBLIC KEY-----\nMCowBQYDK2VwAyEAgqu9hOrz4JQKl2izQlnpj+d8jkT988LVfYfXPvKyt2Y=\n-----END PUBLIC KEY-----\n".replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s+", "");
        return TelemetryStateStore.secondaryVal(string + "|state|1.21.8");
    }

    private static String primaryVal(int n) {
        return "wild-state-v" + n;
    }

    static final class LoadResult
     {
        final TelemetryPayload state;
        final boolean legacy;

        LoadResult(TelemetryPayload spanB, boolean bl) {
            this.state = spanB;
            this.legacy = bl;
        }

        @Override
        public final String toString() {
            return "LoadResult[" + "state=" + this.state + ", " + "legacy=" + this.legacy + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.state, this.legacy);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            LoadResult that = (LoadResult)object;
            return java.util.Objects.equals(this.state, that.state) && java.util.Objects.equals(this.legacy, that.legacy);}

        public TelemetryPayload state() {
            return this.state;
        }

        public boolean legacy() {
            return this.legacy;
        }
    }
}

