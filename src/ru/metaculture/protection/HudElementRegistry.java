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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import ru.metaculture.protection.HudLayoutManager;

public final class HudElementRegistry {
    public static final String primaryVal = "HUD_HotKeys";
    public static final String secondaryVal = "HUD_Inventory";
    public static final String tertiaryVal = "HUD_Potions";
    public static final String marginVal = "HUD_CoolDowns";
    public static final String weightVal = "HUD_Info";
    public static final String paramVal = "HUD_WaterMark";
    public static final String extraVal = "HUD_ArrayList";
    public static final String limitVal = "HUD_TargetHUD";
    public static final String speedVal = "hud_armor";
    public static final String widthVal = "HUD_HotBar";
    public static final String chunkVal = "HUD_Notifications";
    public static final String blockRef = "HUD_AutoBuyInfo";
    public static final String holderVal = "HUD_AIStatus";
    public static final String timerVal = "HUD_MusicPlayer";
    public static final String anchorVal = "HUD_ServerHelper";
    static final String[] weightRef;
    private static final Gson bufferVal;
    private static cursorVal countVal;
    private static boolean depthVal;

    private HudElementRegistry() {
    }

    public static synchronized WildClient primaryVal() {
        return HudElementRegistry.primaryVal(primaryVal);
    }

    public static synchronized WildClient secondaryVal() {
        return HudElementRegistry.primaryVal(secondaryVal);
    }

    public static synchronized WildClient tertiaryVal() {
        return HudElementRegistry.primaryVal(tertiaryVal);
    }

    public static synchronized WildClient primaryVal(String string) {
        HudElementRegistry.paramVal();
        String string2 = HudElementRegistry.tertiaryVal(string);
        WildClient modeVal = HudElementRegistry.countVal.tertiaryVal.get(string2);
        if (modeVal == null) {
            modeVal = WildClient.primaryVal(string2);
            HudElementRegistry.countVal.tertiaryVal.put(string2, modeVal);
        }
        modeVal.secondaryVal();
        return modeVal;
    }

    public static synchronized void marginVal() {
        HudElementRegistry.secondaryVal(primaryVal);
    }

    public static synchronized void secondaryVal(String string) {
        HudElementRegistry.paramVal();
        String string2 = HudElementRegistry.tertiaryVal(string);
        HudElementRegistry.countVal.tertiaryVal.put(string2, WildClient.primaryVal(string2));
        HudLayoutManager.primaryVal().secondaryVal(string2);
        HudElementRegistry.weightVal();
        if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.holderVal != null) {
            ru.metaculture.protection.WildClient.primaryVal.holderVal.tertiaryVal();
        }
    }

    public static synchronized void weightVal() {
        HudElementRegistry.paramVal();
        File file = HudElementRegistry.extraVal();
        if (file == null) {
            return;
        }
        try {
            File file2 = file.getParentFile();
            if (file2 != null) {
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            try (FileWriter fileWriter = new FileWriter(file);){
                bufferVal.toJson((Object)countVal, (Appendable)fileWriter);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static void paramVal() {
        if (depthVal) {
            return;
        }
        depthVal = true;
        countVal = new cursorVal();
        File file = HudElementRegistry.extraVal();
        if (file == null || !file.exists()) {
            countVal.primaryVal();
            return;
        }
        try (FileReader fileReader = new FileReader(file);){
            cursorVal panelVal = (cursorVal)bufferVal.fromJson((Reader)fileReader, cursorVal.class);
            if (panelVal != null) {
                countVal = panelVal;
            }
        }
        catch (Throwable throwable) {
            countVal = new cursorVal();
        }
        countVal.primaryVal();
    }

    private static File extraVal() {
        if (ru.metaculture.protection.WildClient.primaryVal == null || ru.metaculture.protection.WildClient.primaryVal.paramVal == null) {
            return null;
        }
        return new File(ru.metaculture.protection.WildClient.primaryVal.paramVal, "hud-layouts.json");
    }

    static float primaryVal(float f, float f2, float f3) {
        if (!Float.isFinite(f)) {
            return f2;
        }
        return Math.max(f2, Math.min(f3, f));
    }

    private static String tertiaryVal(String string) {
        for (String string2 : weightRef) {
            if (!string2.equals(string)) continue;
            return string2;
        }
        return primaryVal;
    }

    static {
        String[] stringArray = new String[15];
        stringArray[0] = primaryVal;
        stringArray[1] = secondaryVal;
        stringArray[2] = tertiaryVal;
        stringArray[3] = marginVal;
        stringArray[4] = weightVal;
        stringArray[5] = paramVal;
        stringArray[6] = extraVal;
        stringArray[7] = limitVal;
        stringArray[8] = speedVal;
        stringArray[9] = widthVal;
        stringArray[10] = chunkVal;
        stringArray[11] = blockRef;
        stringArray[12] = holderVal;
        stringArray[13] = timerVal;
        stringArray[14] = anchorVal;
        weightRef = stringArray;
        bufferVal = new GsonBuilder().setPrettyPrinting().create();
    }

    public static final class WildClient {
        public float primaryVal = 14.0f;
        public float secondaryVal = 11.0f;
        public float tertiaryVal = 7.0f;
        public float marginVal = 7.0f;
        public float weightVal = 7.0f;
        public float paramVal = 6.0f;
        public float extraVal = 4.0f;
        public float limitVal = 7.0f;
        public float speedVal = 5.0f;
        public float widthVal = 32.0f;
        public float chunkVal = 22.0f;
        public float blockRef = 28.0f;
        public float holderVal = 22.0f;
        public float timerVal = 0.0f;
        public float anchorVal = 2.0f;
        public VvunVVUvUNnv weightRef = new VvunVVUvUNnv(17.0f, 29.0f, false);
        public VvunVVUvUNnv bufferVal = new VvunVVUvUNnv(-34.0f, 29.5f, true);
        public VvunVVUvUNnv countVal = new VvunVVUvUNnv(0.0f, 0.0f, false);
        public VvunVVUvUNnv depthVal = new VvunVVUvUNnv(0.0f, 0.0f, false);

        public static WildClient primaryVal() {
            return WildClient.primaryVal(HudElementRegistry.primaryVal);
        }

        public static WildClient primaryVal(String string) {
            WildClient modeVal;
            block3: {
                block8: {
                    block7: {
                        block6: {
                            block5: {
                                block4: {
                                    block2: {
                                        modeVal = new WildClient();
                                        if (!HudElementRegistry.secondaryVal.equals(string)) break block2;
                                        modeVal.weightRef = new VvunVVUvUNnv(17.0f, 29.0f, false);
                                        modeVal.bufferVal = new VvunVVUvUNnv(-34.0f, 30.0f, true);
                                        modeVal.tertiaryVal = 9.0f;
                                        modeVal.marginVal = 9.0f;
                                        modeVal.blockRef = 26.0f;
                                        modeVal.holderVal = 28.0f;
                                        break block3;
                                    }
                                    if (!HudElementRegistry.tertiaryVal.equals(string)) break block4;
                                    modeVal.weightRef = new VvunVVUvUNnv(17.0f, 29.0f, false);
                                    modeVal.bufferVal = new VvunVVUvUNnv(-34.0f, 28.5f, true);
                                    modeVal.holderVal = 24.0f;
                                    break block3;
                                }
                                if (!HudElementRegistry.paramVal.equals(string)) break block5;
                                modeVal.widthVal = 32.0f;
                                modeVal.chunkVal = 32.0f;
                                modeVal.blockRef = 24.0f;
                                modeVal.holderVal = 26.0f;
                                modeVal.primaryVal = 14.0f;
                                modeVal.limitVal = 7.0f;
                                modeVal.speedVal = 5.0f;
                                break block3;
                            }
                            if (!HudElementRegistry.extraVal.equals(string)) break block6;
                            modeVal.primaryVal = 15.0f;
                            modeVal.secondaryVal = 15.0f;
                            modeVal.tertiaryVal = 15.0f;
                            modeVal.marginVal = 15.0f;
                            modeVal.paramVal = 15.0f;
                            modeVal.limitVal = 4.0f;
                            modeVal.speedVal = 0.0f;
                            modeVal.widthVal = 0.0f;
                            modeVal.chunkVal = 32.0f;
                            break block3;
                        }
                        if (!HudElementRegistry.limitVal.equals(string)) break block7;
                        modeVal.primaryVal = 15.0f;
                        modeVal.secondaryVal = 12.0f;
                        modeVal.tertiaryVal = 10.0f;
                        modeVal.marginVal = 10.0f;
                        modeVal.weightVal = 10.0f;
                        modeVal.chunkVal = 24.0f;
                        modeVal.holderVal = 28.0f;
                        break block3;
                    }
                    if (HudElementRegistry.widthVal.equals(string)) break block8;
                    if (!HudElementRegistry.speedVal.equals(string)) break block3;
                }
                modeVal.primaryVal = 10.0f;
                modeVal.tertiaryVal = 5.0f;
                modeVal.extraVal = 4.0f;
                modeVal.limitVal = 5.0f;
                modeVal.speedVal = 3.0f;
            }
            return modeVal;
        }

        public void secondaryVal() {
            this.primaryVal = HudElementRegistry.primaryVal(this.primaryVal, 0.0f, 32.0f);
            this.secondaryVal = HudElementRegistry.primaryVal(this.secondaryVal, 0.0f, 28.0f);
            this.tertiaryVal = HudElementRegistry.primaryVal(this.tertiaryVal, 0.0f, 24.0f);
            this.marginVal = HudElementRegistry.primaryVal(this.marginVal, 0.0f, 24.0f);
            this.weightVal = HudElementRegistry.primaryVal(this.weightVal, 0.0f, 24.0f);
            this.paramVal = HudElementRegistry.primaryVal(this.paramVal, 0.0f, 22.0f);
            this.extraVal = HudElementRegistry.primaryVal(this.extraVal, 0.0f, 14.0f);
            this.limitVal = HudElementRegistry.primaryVal(this.limitVal, 2.0f, 18.0f);
            this.speedVal = HudElementRegistry.primaryVal(this.speedVal, 0.0f, 18.0f);
            this.widthVal = HudElementRegistry.primaryVal(this.widthVal, 0.0f, 48.0f);
            this.chunkVal = HudElementRegistry.primaryVal(this.chunkVal, 14.0f, 42.0f);
            this.blockRef = HudElementRegistry.primaryVal(this.blockRef, 14.0f, 38.0f);
            this.holderVal = HudElementRegistry.primaryVal(this.holderVal, 12.0f, 38.0f);
            this.timerVal = HudElementRegistry.primaryVal(this.timerVal, -24.0f, 90.0f);
            this.anchorVal = HudElementRegistry.primaryVal(this.anchorVal, 0.0f, 7.0f);
            if (this.weightRef == null) {
                this.weightRef = new VvunVVUvUNnv(17.0f, 29.0f, false);
            }
            if (this.bufferVal == null) {
                this.bufferVal = new VvunVVUvUNnv(-34.0f, 29.5f, true);
            }
            if (this.countVal == null) {
                this.countVal = new VvunVVUvUNnv(0.0f, 0.0f, false);
            }
            if (this.depthVal == null) {
                this.depthVal = new VvunVVUvUNnv(0.0f, 0.0f, false);
            }
            this.weightRef.primaryVal = HudElementRegistry.primaryVal(this.weightRef.primaryVal, -80.0f, 260.0f);
            this.weightRef.secondaryVal = HudElementRegistry.primaryVal(this.weightRef.secondaryVal, -40.0f, 180.0f);
            this.bufferVal.primaryVal = HudElementRegistry.primaryVal(this.bufferVal.primaryVal, -220.0f, 80.0f);
            this.bufferVal.secondaryVal = HudElementRegistry.primaryVal(this.bufferVal.secondaryVal, -40.0f, 180.0f);
            this.countVal.primaryVal = HudElementRegistry.primaryVal(this.countVal.primaryVal, -100.0f, 140.0f);
            this.countVal.secondaryVal = HudElementRegistry.primaryVal(this.countVal.secondaryVal, -60.0f, 140.0f);
            this.depthVal.primaryVal = HudElementRegistry.primaryVal(this.depthVal.primaryVal, -100.0f, 140.0f);
            this.depthVal.secondaryVal = HudElementRegistry.primaryVal(this.depthVal.secondaryVal, -60.0f, 140.0f);
        }
    }

    static final class cursorVal {
        public int primaryVal = 1;
        public WildClient secondaryVal;
        public Map<String, WildClient> tertiaryVal = new HashMap<String, WildClient>();

        cursorVal() {
        }

        void primaryVal() {
            if (this.tertiaryVal == null) {
                this.tertiaryVal = new HashMap<String, WildClient>();
            }
            if (this.secondaryVal != null) {
                this.tertiaryVal.putIfAbsent(HudElementRegistry.primaryVal, this.secondaryVal);
                this.secondaryVal = null;
            }
            String[] stringArray = weightRef;
            int n = stringArray.length;
            for (int i = 0; i < n; ++i) {
                Object object = stringArray[i];
                this.tertiaryVal.putIfAbsent((String)object, WildClient.primaryVal((String)object));
            }
            for (WildClient modeVal : this.tertiaryVal.values()) {
                if (modeVal == null) continue;
                modeVal.secondaryVal();
            }
        }
    }

    public static final class VvunVVUvUNnv {
        public float primaryVal;
        public float secondaryVal;
        public boolean tertiaryVal;

        public VvunVVUvUNnv() {
        }

        public VvunVVUvUNnv(float f, float f2, boolean bl) {
            this.primaryVal = f;
            this.secondaryVal = f2;
            this.tertiaryVal = bl;
        }
    }
}

