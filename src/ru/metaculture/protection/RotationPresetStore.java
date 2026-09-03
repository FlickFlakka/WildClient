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
import java.io.File;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import ru.metaculture.protection.CustomRotationConfig;

public final class RotationPresetStore {
    private static final Gson primaryVal = new GsonBuilder().setPrettyPrinting().create();
    private static final RotationPresetStore secondaryVal = new RotationPresetStore();
    private final List<WildClient> tertiaryVal = new ArrayList<WildClient>();
    private boolean marginVal;

    private RotationPresetStore() {
    }

    public static RotationPresetStore primaryVal() {
        return secondaryVal;
    }

    public synchronized List<WildClient> secondaryVal() {
        this.tertiaryVal();
        return List.copyOf(this.tertiaryVal);
    }

    public synchronized WildClient primaryVal(String string, CustomRotationConfig partH) {
        this.tertiaryVal();
        String string2 = RotationPresetStore.marginVal(string);
        if (string2.isEmpty() || partH == null) {
            return null;
        }
        long l = System.currentTimeMillis();
        WildClient modeVal = new WildClient(UUID.randomUUID().toString(), string2, partH.weightVal(), l, l);
        this.tertiaryVal.add(0, modeVal);
        this.marginVal();
        return modeVal;
    }

    public synchronized WildClient primaryVal(String string, String string2, CustomRotationConfig partH) {
        this.tertiaryVal();
        String string3 = RotationPresetStore.marginVal(string2);
        if (string == null || string3.isEmpty() || partH == null) {
            return null;
        }
        for (int i = 0; i < this.tertiaryVal.size(); ++i) {
            WildClient modeVal = this.tertiaryVal.get(i);
            if (!modeVal.id().equals(string)) continue;
            WildClient nodeC = new WildClient(modeVal.id(), string3, partH.weightVal(), modeVal.createdAt(), System.currentTimeMillis());
            this.tertiaryVal.set(i, nodeC);
            this.weightVal();
            this.marginVal();
            return nodeC;
        }
        return null;
    }

    public synchronized boolean primaryVal(String string) {
        WildClient modeVal = this.tertiaryVal(string);
        return modeVal != null && CustomRotationConfig.secondaryVal(modeVal.key());
    }

    public synchronized boolean secondaryVal(String string) {
        this.tertiaryVal();
        boolean bl = this.tertiaryVal.removeIf(modeVal -> modeVal.id().equals(string));
        if (bl) {
            this.marginVal();
        }
        return bl;
    }

    public synchronized WildClient tertiaryVal(String string) {
        this.tertiaryVal();
        if (string == null) {
            return null;
        }
        Iterator<WildClient> iterator = this.tertiaryVal.iterator();
        while (iterator.hasNext()) {
            WildClient modeVal = iterator.next();
            if (!modeVal.id().equals(string)) continue;
            return modeVal;
        }
        return null;
    }

    private void tertiaryVal() {
        if (this.marginVal) {
            return;
        }
        File file = RotationPresetStore.paramVal();
        if (file == null) {
            return;
        }
        this.marginVal = true;
        if (!file.isFile()) {
            return;
        }
        try {
            String string = Files.readString(file.toPath(), StandardCharsets.UTF_8);
            cursorVal panelVal = (cursorVal)primaryVal.fromJson(string, cursorVal.class);
            if (panelVal == null || panelVal.presets == null) {
                return;
            }
            Iterator<WildClient> iterator = panelVal.presets.iterator();
            while (iterator.hasNext()) {
                WildClient modeVal = iterator.next();
                WildClient partE = RotationPresetStore.primaryVal(modeVal);
                if (partE == null) continue;
                if (!this.tertiaryVal.stream().noneMatch(nodeC -> nodeC.id().equals(partE.id()))) continue;
                this.tertiaryVal.add(partE);
            }
            this.weightVal();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void marginVal() {
        File file = RotationPresetStore.paramVal();
        if (file == null) {
            return;
        }
        try {
            File file2 = file.getParentFile();
            if (file2 != null) {
                Files.createDirectories(file2.toPath(), new FileAttribute[0]);
            }
            Files.writeString(file.toPath(), (CharSequence)primaryVal.toJson((Object)new cursorVal(1, this.tertiaryVal)), StandardCharsets.UTF_8, new OpenOption[0]);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void weightVal() {
        this.tertiaryVal.sort(Comparator.comparingLong(WildClient::updatedAt).reversed());
    }

    private static WildClient primaryVal(WildClient modeVal) {
        if (modeVal == null || modeVal.key() == null || modeVal.key().isBlank()) {
            return null;
        }
        String string = RotationPresetStore.marginVal(modeVal.name());
        if (string.isEmpty()) {
            return null;
        }
        String string2 = modeVal.id() == null || modeVal.id().isBlank() ? UUID.randomUUID().toString() : modeVal.id();
        long l = Math.max(0L, modeVal.createdAt());
        long l2 = Math.max(l, modeVal.updatedAt());
        return new WildClient(string2, string, modeVal.key().trim(), l, l2);
    }

    private static String marginVal(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string.replaceAll("\\p{Cntrl}", "").trim().replaceAll("\\s{2,}", " ");
        return string2.length() > 40 ? string2.substring(0, 40).trim() : string2;
    }

    private static File paramVal() {
        if (ru.metaculture.protection.WildClient.primaryVal == null || ru.metaculture.protection.WildClient.primaryVal.paramVal == null) {
            return null;
        }
        return new File(ru.metaculture.protection.WildClient.primaryVal.paramVal, "custom-rotation-presets.json");
    }

    public record WildClient(String id, String name, String key, long createdAt, long updatedAt) {
    }

    static final class cursorVal
     {
        private final int version;
        final List<WildClient> presets;

        cursorVal(int n, List<WildClient> list) {
            this.version = n;
            this.presets = list;
        }

        @Override
        public final String toString() {
            return "nvnNNunvv[" + "version=" + this.version + ", " + "presets=" + this.presets + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.version, this.presets);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            cursorVal that = (cursorVal)object;
            return java.util.Objects.equals(this.version, that.version) && java.util.Objects.equals(this.presets, that.presets);}

        public int version() {
            return this.version;
        }

        public List<WildClient> presets() {
            return this.presets;
        }
    }
}

