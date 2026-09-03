/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;
import ru.metaculture.protection.RotationLabSession;
import ru.metaculture.protection.MinecraftAccessor;

public final class RotationLabStorage
implements MinecraftAccessor {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final List<WildClient> secondaryVal = new ArrayList<WildClient>();
    private long tertiaryVal;
    private int marginVal = -1;
    private long weightVal = -1L;

    public RotationLabSession.Dataset primaryVal(float f, float f2, boolean bl) {
        this.primaryVal(false);
        if (this.secondaryVal.isEmpty()) {
            return null;
        }
        float f3 = (float)Math.hypot(Math.abs(f), Math.abs(f2));
        float f4 = f3 <= 0.001f ? 1.0f : Math.abs(f) / f3;
        String string = RotationLabStorage.secondaryVal(f3, f4, bl);
        return this.secondaryVal.stream().min(Comparator.comparingDouble(modeVal -> this.primaryVal(modeVal.pattern, f3, f4, string))).map(modeVal -> modeVal.pattern).orElse(null);
    }

    public int primaryVal() {
        this.primaryVal(false);
        return this.secondaryVal.size();
    }

    public String secondaryVal() {
        this.primaryVal(false);
        return this.secondaryVal.isEmpty() ? "Neuro: no assets" : "Neuro: " + this.secondaryVal.size() + " patterns";
    }

    public void tertiaryVal() {
        this.primaryVal(true);
    }

    public static Path marginVal() {
        if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.paramVal != null) {
            return ru.metaculture.protection.WildClient.primaryVal.paramVal.toPath().resolve("rotation_assets");
        }
        return RotationLabStorage.a_.field_1697.toPath().resolve("Wild").resolve("rotation_assets");
    }

    public static Path primaryVal(String string) {
        String string2 = RotationLabStorage.secondaryVal(string);
        return RotationLabStorage.marginVal().resolve(string2 + ".json");
    }

    public static RotationLabSession primaryVal(Path path) {
        if (!Files.isRegularFile(path, new LinkOption[0])) {
            return null;
        }
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            RotationLabSession vaseI = (RotationLabSession)gson.fromJson((Reader)bufferedReader, RotationLabSession.class);
            RotationLabStorage.primaryVal(vaseI, RotationLabStorage.tertiaryVal(path.getFileName().toString()));
            return vaseI;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static void primaryVal(Path path, RotationLabSession coreD) {
        try {
            Files.createDirectories(path.getParent(), new FileAttribute[0]);
            RotationLabStorage.primaryVal(coreD, RotationLabStorage.tertiaryVal(path.getFileName().toString()));
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, new OpenOption[0]);){
                gson.toJson((Object)coreD, (Appendable)bufferedWriter);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static String secondaryVal(String string) {
        String string2;
        block6: {
            block5: {
                string2 = string == null || string.isBlank() ? "rotation_lab" : string.trim();
                string2 = string2.replace('\\', '/');
                int n = string2.lastIndexOf(47);
                if (n >= 0) {
                    string2 = string2.substring(n + 1);
                }
                if (string2.endsWith(".json")) {
                    string2 = string2.substring(0, string2.length() - 5);
                }
                if ((string2 = string2.replaceAll("[^a-zA-Z0-9._-]", "_")).isBlank()) break block5;
                if (!string2.equals(".") && !string2.equals("..")) break block6;
            }
            string2 = "rotation_lab";
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void primaryVal(boolean bl) {
        Stream<Path> stream;
        long l;
        int n;
        Path path2;
        block17: {
            long l2 = System.currentTimeMillis();
            if (!bl) {
                if (l2 - this.tertiaryVal < 1500L) {
                    return;
                }
            }
            this.tertiaryVal = l2;
            path2 = RotationLabStorage.marginVal();
            n = 0;
            l = 0L;
            try {
                if (!Files.isDirectory(path2, new LinkOption[0])) break block17;
                stream = Files.list(path2);
                try {
                    List<Path> list = stream.filter(path -> Files.isRegularFile(path, new LinkOption[0]) && path.getFileName().toString().endsWith(".json")).toList();
                    n = list.size();
                    Iterator<Path> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        Path path3 = iterator.next();
                        l += Files.getLastModifiedTime(path3, new LinkOption[0]).toMillis();
                    }
                    if (stream == null) break block17;
                }
                catch (Throwable throwable) {
                    if (stream == null) throw throwable;
                    try {
                        stream.close();
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        throwable.addSuppressed(throwable2);
                    }
                    throw throwable;
                }
                stream.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (!bl && n == this.marginVal && l == this.weightVal) {
            return;
        }
        this.marginVal = n;
        this.weightVal = l;
        this.secondaryVal.clear();
        if (n == 0) {
            return;
        }
        try {
            stream = Files.list(path2);
            try {
                stream.filter(path -> Files.isRegularFile(path, new LinkOption[0]) && path.getFileName().toString().endsWith(".json")).forEach(this::secondaryVal);
                if (stream == null) return;
            }
            catch (Throwable throwable) {
                if (stream == null) throw throwable;
                try {
                    stream.close();
                    throw throwable;
                }
                catch (Throwable throwable3) {
                    throwable.addSuppressed(throwable3);
                }
                throw throwable;
            }
            stream.close();
            return;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void secondaryVal(Path path) {
        RotationLabSession coreD = RotationLabStorage.primaryVal(path);
        if (coreD == null || coreD.paramVal == null) {
            return;
        }
        for (RotationLabSession.Dataset modeVal : coreD.paramVal) {
            if (!RotationLabStorage.VUuUNUnN(modeVal)) continue;
            this.secondaryVal.add(new WildClient(path.getFileName().toString(), modeVal));
        }
    }

    private static void primaryVal(RotationLabSession coreD, String string) {
        if (coreD == null) {
            return;
        }
        coreD.primaryVal = 1;
        if (coreD.marginVal == null || coreD.marginVal.isBlank()) {
            coreD.marginVal = string;
        }
        if (coreD.paramVal == null) {
            coreD.paramVal = new ArrayList<RotationLabSession.Dataset>();
        }
        coreD.paramVal.removeIf(modeVal -> !RotationLabStorage.VUuUNUnN(modeVal));
        for (RotationLabSession.Dataset nodeC : coreD.paramVal) {
            if (nodeC.primaryVal == null || nodeC.primaryVal.isBlank()) {
                nodeC.primaryVal = "Mixed";
            }
            nodeC.blockRef.sort(Comparator.comparingInt(panelVal -> panelVal.primaryVal));
            nodeC.speedVal = Math.max(nodeC.speedVal, nodeC.blockRef.get((int)(nodeC.blockRef.size() - 1)).primaryVal + 1);
            RotationLabSession.RotationSample nvnNNunvv3 = nodeC.blockRef.get(nodeC.blockRef.size() - 1);
            nodeC.weightVal = Math.abs(nodeC.weightVal) > 0.001f ? nodeC.weightVal : nvnNNunvv3.secondaryVal;
            nodeC.paramVal = Math.abs(nodeC.paramVal) > 0.001f ? nodeC.paramVal : nvnNNunvv3.tertiaryVal;
            nodeC.chunkVal = Math.max(0.0f, Math.min(1.0f, nodeC.chunkVal));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean VUuUNUnN(RotationLabSession.Dataset modeVal) {
        if (modeVal == null) return false;
        if (modeVal.blockRef == null) return false;
        if (modeVal.blockRef.size() < 2) return false;
        return true;
    }

    private double primaryVal(RotationLabSession.Dataset modeVal, float f, float f2, String string) {
        float f3 = Math.max(0.001f, modeVal.primaryVal());
        float f4 = Math.abs(modeVal.weightVal) / f3;
        double d = (double)Math.abs(f3 - f) * 0.85;
        double d2 = (double)Math.abs(f4 - f2) * 12.0;
        double d3 = RotationLabStorage.primaryVal(modeVal.primaryVal, string);
        double d4 = (1.0 - (double)modeVal.chunkVal) * 5.0;
        double d5 = ThreadLocalRandom.current().nextDouble(0.0, 1.35);
        return d + d2 + d3 + d4 + d5;
    }

    private static double primaryVal(String string, String string2) {
        block6: {
            block5: {
                String string3;
                String string4 = string == null ? "" : string.toLowerCase(Locale.ROOT);
                String string5 = string3 = string2 == null ? "" : string2.toLowerCase(Locale.ROOT);
                if (string4.equals(string3) || string4.equals("mixed")) {
                    return 0.0;
                }
                if (string3.equals("mixed")) {
                    return 1.0;
                }
                if (string4.contains(string3)) break block5;
                if (!string3.contains(string4)) break block6;
            }
            return 0.75;
        }
        return 3.0;
    }

    private static String secondaryVal(float f, float f2, boolean bl) {
        if (bl) {
            return "Attack";
        }
        if (f < 6.0f) {
            return "Micro";
        }
        if (f2 < 0.35f) {
            return "Vertical";
        }
        if (f > 28.0f) {
            return "Flick";
        }
        return "Tracking";
    }

    /*
     * Enabled aggressive block sorting
     */
    private static String tertiaryVal(String string) {
        String string2;
        if (string != null) {
            if (string.endsWith(".json")) {
                string2 = string.substring(0, string.length() - 5);
                return string2;
            }
        }
        string2 = string;
        return string2;
    }

    static final class WildClient
     {
        private final String file;
        final RotationLabSession.Dataset pattern;

        WildClient(String string, RotationLabSession.Dataset modeVal) {
            this.file = string;
            this.pattern = modeVal;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "file=" + this.file + ", " + "pattern=" + this.pattern + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.file, this.pattern);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.file, that.file) && java.util.Objects.equals(this.pattern, that.pattern);}

        public String file() {
            return this.file;
        }

        public RotationLabSession.Dataset pattern() {
            return this.pattern;
        }
    }
}

