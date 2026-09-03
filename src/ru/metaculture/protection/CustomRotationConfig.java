/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.annotations.SerializedName
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public final class CustomRotationConfig {
    public static final String[] primaryVal = new String[]{"Multipoint", "Center", "Eyes", "Closest"};
    public static final String[] secondaryVal = new String[]{"Cycle", "Closest", "Random"};
    public static final String[] tertiaryVal = new String[]{"Smooth", "Static", "Locked"};
    public static final String[] marginVal = new String[]{"FunTime", "Spooky", "Holy", "Matrix", "Smooth", "Snap"};
    public static final String weightVal = "Custom";
    public static final int paramVal = 12;
    private static final Gson depthRef = new GsonBuilder().setPrettyPrinting().create();
    private static CustomRotationConfig speedRef;
    @SerializedName(value="name")
    public String extraVal = "FunTime";
    @SerializedName(value="engine")
    public String limitVal = "FunTime";
    @SerializedName(value="preset")
    public String speedVal = "FunTime";
    @SerializedName(value="pointMode")
    public String widthVal = "Multipoint";
    @SerializedName(value="yawSpeedMin")
    public float chunkVal = 35.0f;
    @SerializedName(value="yawSpeedMax")
    public float blockRef = 55.0f;
    @SerializedName(value="pitchSpeedMin")
    public float holderVal = 6.0f;
    @SerializedName(value="pitchSpeedMax")
    public float timerVal = 12.0f;
    @SerializedName(value="attackYawSpeed")
    public float anchorVal = 65.0f;
    @SerializedName(value="attackPitchSpeed")
    public float weightRef = 22.0f;
    @SerializedName(value="yawRandom")
    public float bufferVal = 4.0f;
    @SerializedName(value="pitchRandom")
    public float countVal = 3.0f;
    @SerializedName(value="oscillateX")
    public float depthVal = 0.2f;
    @SerializedName(value="oscillateY")
    public float descRef = 0.12f;
    @SerializedName(value="oscillateSpeed")
    public float activeVal = 1.0f;
    @SerializedName(value="sidePointOffset")
    public float radiusVal = 0.0f;
    @SerializedName(value="returnSpeed")
    public float factorVal = 30.0f;
    @SerializedName(value="moveHead")
    public boolean sourceVal = false;
    @SerializedName(value="multipointMode")
    public String extraRef = "Cycle";
    @SerializedName(value="pointDwell")
    public float phaseVal = 0.9f;
    @SerializedName(value="pitchFollow")
    public String limitRef = "Smooth";
    @SerializedName(value="yawOffset")
    public float paramRef = 0.0f;
    @SerializedName(value="pitchOffset")
    public float groupVal = 0.0f;
    @SerializedName(value="pitchMin")
    public float layerVal = -90.0f;
    @SerializedName(value="pitchMax")
    public float slotVal = 90.0f;
    @SerializedName(value="headLead")
    public float themeVal = 0.0f;
    @SerializedName(value="overlayLerp")
    public float stageVal = 0.35f;
    @SerializedName(value="overlayAimSpeed")
    public float widthRef = 1.0f;
    @SerializedName(value="pointSwitchSpeed")
    public float trackVal = 1.0f;
    @SerializedName(value="lookAway")
    public boolean modeRef = false;
    @SerializedName(value="lookAwayAngle")
    public float angleVal = 80.0f;
    @SerializedName(value="lookAwayInterval")
    public float heightRef = 5.0f;
    @SerializedName(value="points")
    public List<RotationPoint> levelVal = new ArrayList<RotationPoint>();
    public static final String UuNnnVnuNNV = "WILD-ROT:";

    private CustomRotationConfig() {
    }

    public static synchronized CustomRotationConfig primaryVal() {
        if (speedRef == null) {
            speedRef = CustomRotationConfig.widthVal();
        }
        speedRef.secondaryVal();
        return speedRef;
    }

    public synchronized void secondaryVal() {
        block11: {
            block10: {
                this.extraVal();
                if (this.widthVal == null || !CustomRotationConfig.primaryVal(primaryVal, this.widthVal)) {
                    this.widthVal = "Multipoint";
                }
                if (this.extraRef == null || !CustomRotationConfig.primaryVal(secondaryVal, this.extraRef)) {
                    this.extraRef = "Cycle";
                }
                if (this.limitRef == null) break block10;
                if (CustomRotationConfig.primaryVal(tertiaryVal, this.limitRef)) break block11;
            }
            this.limitRef = "Smooth";
        }
        if (this.levelVal == null) {
            this.levelVal = new ArrayList<RotationPoint>();
        }
        while (this.levelVal.size() > 12) {
            this.levelVal.remove(this.levelVal.size() - 1);
        }
        for (RotationPoint modeVal : this.levelVal) {
            modeVal.primaryVal = CustomRotationConfig.primaryVal(modeVal.primaryVal, -0.5f, 0.5f);
            modeVal.secondaryVal = CustomRotationConfig.primaryVal(modeVal.secondaryVal, 0.0f, 1.0f);
        }
        this.chunkVal = CustomRotationConfig.primaryVal(this.chunkVal, 0.0f, 200.0f);
        this.blockRef = CustomRotationConfig.primaryVal(this.blockRef, 0.0f, 200.0f);
        if (this.blockRef < this.chunkVal) {
            this.blockRef = this.chunkVal;
        }
        this.holderVal = CustomRotationConfig.primaryVal(this.holderVal, 0.0f, 200.0f);
        this.timerVal = CustomRotationConfig.primaryVal(this.timerVal, 0.0f, 200.0f);
        if (this.timerVal < this.holderVal) {
            this.timerVal = this.holderVal;
        }
        this.anchorVal = CustomRotationConfig.primaryVal(this.anchorVal, 0.0f, 240.0f);
        this.weightRef = CustomRotationConfig.primaryVal(this.weightRef, 0.0f, 240.0f);
        this.bufferVal = CustomRotationConfig.primaryVal(this.bufferVal, 0.0f, 20.0f);
        this.countVal = CustomRotationConfig.primaryVal(this.countVal, 0.0f, 20.0f);
        this.depthVal = CustomRotationConfig.primaryVal(this.depthVal, 0.0f, 1.0f);
        this.descRef = CustomRotationConfig.primaryVal(this.descRef, 0.0f, 1.0f);
        this.activeVal = CustomRotationConfig.primaryVal(this.activeVal, 0.2f, 3.0f);
        this.radiusVal = CustomRotationConfig.primaryVal(this.radiusVal, 0.0f, 0.6f);
        this.factorVal = CustomRotationConfig.primaryVal(this.factorVal, 5.0f, 120.0f);
        this.phaseVal = CustomRotationConfig.primaryVal(this.phaseVal, 0.1f, 3.0f);
        this.paramRef = CustomRotationConfig.primaryVal(this.paramRef, -30.0f, 30.0f);
        this.groupVal = CustomRotationConfig.primaryVal(this.groupVal, -30.0f, 30.0f);
        this.layerVal = CustomRotationConfig.primaryVal(this.layerVal, -90.0f, 0.0f);
        this.slotVal = CustomRotationConfig.primaryVal(this.slotVal, 0.0f, 90.0f);
        this.themeVal = CustomRotationConfig.primaryVal(this.themeVal, 0.0f, 0.6f);
        this.stageVal = CustomRotationConfig.primaryVal(this.stageVal, 0.05f, 1.0f);
        this.widthRef = CustomRotationConfig.primaryVal(this.widthRef, 0.2f, 3.0f);
        this.trackVal = CustomRotationConfig.primaryVal(this.trackVal, 0.1f, 3.0f);
        this.angleVal = CustomRotationConfig.primaryVal(this.angleVal, 0.0f, 90.0f);
        this.heightRef = CustomRotationConfig.primaryVal(this.heightRef, 1.5f, 15.0f);
    }

    public synchronized void primaryVal(float f, float f2) {
        if (this.levelVal.size() >= 12) {
            return;
        }
        this.levelVal.add(new RotationPoint(CustomRotationConfig.primaryVal(f, -0.5f, 0.5f), CustomRotationConfig.primaryVal(f2, 0.0f, 1.0f)));
        CustomRotationConfig.paramVal();
    }

    public synchronized void tertiaryVal() {
        this.levelVal.clear();
        CustomRotationConfig.paramVal();
    }

    public synchronized void primaryVal(RotationPoint modeVal) {
        this.levelVal.remove(modeVal);
        CustomRotationConfig.paramVal();
    }

    private static boolean primaryVal(String[] stringArray, String string) {
        for (String string2 : stringArray) {
            if (!string2.equals(string)) continue;
            return true;
        }
        return false;
    }

    public synchronized void primaryVal(String string) {
        switch (string) {
            case "FunTime": {
                this.widthVal = "Multipoint";
                this.chunkVal = 35.0f;
                this.blockRef = 55.0f;
                this.holderVal = 5.0f;
                this.timerVal = 10.0f;
                this.anchorVal = 65.0f;
                this.weightRef = 22.0f;
                this.bufferVal = 4.3f;
                this.countVal = 3.6f;
                this.depthVal = 0.2f;
                this.descRef = 0.13f;
                this.activeVal = 1.0f;
                this.radiusVal = 0.0f;
                this.factorVal = 30.0f;
                break;
            }
            case "Spooky": {
                this.widthVal = "Multipoint";
                this.chunkVal = 40.0f;
                this.blockRef = 60.0f;
                this.holderVal = 10.0f;
                this.timerVal = 21.0f;
                this.anchorVal = 60.0f;
                this.weightRef = 25.0f;
                this.bufferVal = 3.0f;
                this.countVal = 6.0f;
                this.depthVal = 0.12f;
                this.descRef = 0.05f;
                this.activeVal = 1.2f;
                this.radiusVal = 0.0f;
                this.factorVal = 30.0f;
                break;
            }
            case "Holy": {
                this.widthVal = "Center";
                this.chunkVal = 50.0f;
                this.blockRef = 70.0f;
                this.holderVal = 10.0f;
                this.timerVal = 20.0f;
                this.anchorVal = 70.0f;
                this.weightRef = 24.0f;
                this.bufferVal = 2.0f;
                this.countVal = 2.0f;
                this.depthVal = 0.2f;
                this.descRef = 0.3f;
                this.activeVal = 0.7f;
                this.radiusVal = 0.0f;
                this.factorVal = 30.0f;
                break;
            }
            case "Matrix": {
                this.widthVal = "Eyes";
                this.chunkVal = 38.0f;
                this.blockRef = 43.0f;
                this.holderVal = 3.0f;
                this.timerVal = 5.0f;
                this.anchorVal = 43.0f;
                this.weightRef = 6.0f;
                this.bufferVal = 3.0f;
                this.countVal = 4.0f;
                this.depthVal = 0.4f;
                this.descRef = 0.02f;
                this.activeVal = 1.4f;
                this.radiusVal = 0.0f;
                this.factorVal = 30.0f;
                break;
            }
            case "Smooth": {
                this.widthVal = "Center";
                this.chunkVal = 18.0f;
                this.blockRef = 26.0f;
                this.holderVal = 4.0f;
                this.timerVal = 8.0f;
                this.anchorVal = 30.0f;
                this.weightRef = 12.0f;
                this.bufferVal = 0.5f;
                this.countVal = 0.5f;
                this.depthVal = 0.0f;
                this.descRef = 0.0f;
                this.activeVal = 1.0f;
                this.radiusVal = 0.0f;
                this.factorVal = 20.0f;
                break;
            }
            case "Snap": {
                this.widthVal = "Closest";
                this.chunkVal = 120.0f;
                this.blockRef = 180.0f;
                this.holderVal = 80.0f;
                this.timerVal = 120.0f;
                this.anchorVal = 200.0f;
                this.weightRef = 160.0f;
                this.bufferVal = 1.0f;
                this.countVal = 1.0f;
                this.depthVal = 0.0f;
                this.descRef = 0.0f;
                this.activeVal = 1.0f;
                this.radiusVal = 0.0f;
                this.factorVal = 40.0f;
                break;
            }
            case "Custom": {
                break;
            }
        }
        this.extraVal = string;
        if (weightVal.equals(string)) {
            this.limitVal = weightVal;
            this.speedVal = weightVal;
        } else if (CustomRotationConfig.primaryVal(marginVal, string)) {
            this.limitVal = string;
            this.speedVal = string;
        } else {
            this.limitVal = weightVal;
            this.speedVal = weightVal;
        }
        this.secondaryVal();
        CustomRotationConfig.paramVal();
    }

    private synchronized void extraVal() {
        block11: {
            block10: {
                String string = CustomRotationConfig.marginVal(this.speedVal);
                if (string == null) {
                    string = CustomRotationConfig.marginVal(this.extraVal);
                }
                if (string == null) {
                    string = CustomRotationConfig.marginVal(this.limitVal);
                }
                if (string != null) {
                    this.speedVal = string;
                    this.extraVal = string;
                    this.limitVal = string;
                    return;
                }
                if (this.limitVal()) {
                    this.extraVal = weightVal;
                    this.limitVal = weightVal;
                    this.speedVal = weightVal;
                    return;
                }
                if (this.limitVal == null || this.limitVal.isBlank()) {
                    this.limitVal = weightVal;
                }
                if (!weightVal.equals(this.limitVal) && !CustomRotationConfig.primaryVal(marginVal, this.limitVal)) {
                    this.limitVal = weightVal;
                }
                if (this.extraVal == null || this.extraVal.isBlank()) {
                    this.extraVal = this.limitVal;
                }
                if (this.speedVal == null) break block10;
                if (!this.speedVal.isBlank()) break block11;
            }
            this.speedVal = weightVal.equals(this.limitVal) ? weightVal : this.limitVal;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean limitVal() {
        if (weightVal.equalsIgnoreCase(CustomRotationConfig.tertiaryVal(this.speedVal))) return true;
        if (weightVal.equalsIgnoreCase(CustomRotationConfig.tertiaryVal(this.extraVal))) return true;
        if (!"custom".equalsIgnoreCase(CustomRotationConfig.tertiaryVal(this.extraVal))) return false;
        return true;
    }

    private static String tertiaryVal(String string) {
        return string == null ? "" : string.trim();
    }

    private static String marginVal(String string) {
        if (string == null || string.isBlank()) {
            return null;
        }
        String string2 = string.trim();
        if (weightVal.equalsIgnoreCase(string2) || "custom".equalsIgnoreCase(string2)) {
            return null;
        }
        for (String string3 : marginVal) {
            if (!string3.equalsIgnoreCase(string2)) continue;
            return string3;
        }
        return null;
    }

    public synchronized void marginVal() {
        this.primaryVal("FunTime");
        this.levelVal.clear();
        this.extraRef = "Cycle";
        this.phaseVal = 0.9f;
        this.trackVal = 1.0f;
        this.sourceVal = false;
        this.speedVal();
        this.secondaryVal();
        CustomRotationConfig.paramVal();
    }

    private synchronized void speedVal() {
        this.limitRef = "Smooth";
        this.paramRef = 0.0f;
        this.groupVal = 0.0f;
        this.layerVal = -90.0f;
        this.slotVal = 90.0f;
        this.themeVal = 0.0f;
        this.stageVal = 0.35f;
        this.widthRef = 1.0f;
        this.modeRef = false;
        this.angleVal = 80.0f;
        this.heightRef = 5.0f;
    }

    public synchronized String weightVal() {
        this.secondaryVal();
        String string = depthRef.toJson((Object)this);
        String string2 = Base64.getUrlEncoder().withoutPadding().encodeToString(string.getBytes(StandardCharsets.UTF_8));
        return UuNnnVnuNNV + string2;
    }

    public static synchronized boolean secondaryVal(String string) {
        if (string == null) {
            return false;
        }
        String string2 = string.trim();
        if (string2.startsWith(UuNnnVnuNNV)) {
            string2 = string2.substring(UuNnnVnuNNV.length());
        }
        if ((string2 = string2.trim()).isEmpty()) {
            return false;
        }
        try {
            byte[] byArray = Base64.getUrlDecoder().decode(string2);
            String string3 = new String(byArray, StandardCharsets.UTF_8);
            CustomRotationConfig partH = (CustomRotationConfig)depthRef.fromJson(string3, CustomRotationConfig.class);
            if (partH == null) {
                return false;
            }
            CustomRotationConfig silkB = CustomRotationConfig.primaryVal();
            silkB.primaryVal(partH);
            silkB.secondaryVal();
            CustomRotationConfig.paramVal();
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private synchronized void primaryVal(CustomRotationConfig partH) {
        this.extraVal = partH.extraVal;
        this.limitVal = partH.limitVal;
        this.speedVal = partH.speedVal;
        this.widthVal = partH.widthVal;
        this.chunkVal = partH.chunkVal;
        this.blockRef = partH.blockRef;
        this.holderVal = partH.holderVal;
        this.timerVal = partH.timerVal;
        this.anchorVal = partH.anchorVal;
        this.weightRef = partH.weightRef;
        this.bufferVal = partH.bufferVal;
        this.countVal = partH.countVal;
        this.depthVal = partH.depthVal;
        this.descRef = partH.descRef;
        this.activeVal = partH.activeVal;
        this.radiusVal = partH.radiusVal;
        this.factorVal = partH.factorVal;
        this.sourceVal = partH.sourceVal;
        this.extraRef = partH.extraRef;
        this.phaseVal = partH.phaseVal;
        this.limitRef = partH.limitRef;
        this.paramRef = partH.paramRef;
        this.groupVal = partH.groupVal;
        this.layerVal = partH.layerVal;
        this.slotVal = partH.slotVal;
        this.themeVal = partH.themeVal;
        this.stageVal = partH.stageVal;
        this.widthRef = partH.widthRef;
        this.trackVal = partH.trackVal;
        this.modeRef = partH.modeRef;
        this.angleVal = partH.angleVal;
        this.heightRef = partH.heightRef;
        this.levelVal = new ArrayList<RotationPoint>();
        if (partH.levelVal != null) {
            for (RotationPoint modeVal : partH.levelVal) {
                if (modeVal == null) continue;
                this.levelVal.add(new RotationPoint(modeVal.primaryVal, modeVal.secondaryVal));
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static synchronized void paramVal() {
        if (speedRef == null) {
            return;
        }
        File file = CustomRotationConfig.chunkVal();
        if (file == null) {
            return;
        }
        File file2 = file.getParentFile();
        if (file2 != null && !file2.exists()) {
            file2.mkdirs();
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            depthRef.toJson((Object)speedRef, (Appendable)fileWriter);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static CustomRotationConfig widthVal() {
        File file = CustomRotationConfig.chunkVal();
        if (file == null || !file.exists()) {
            CustomRotationConfig partH = new CustomRotationConfig();
            partH.secondaryVal();
            return partH;
        }
        try (FileReader fileReader = new FileReader(file);){
            CustomRotationConfig partH = (CustomRotationConfig)depthRef.fromJson((Reader)fileReader, CustomRotationConfig.class);
            if (partH == null) return new CustomRotationConfig();
            CustomRotationConfig silkB = partH;
            return silkB;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return new CustomRotationConfig();
    }

    private static File chunkVal() {
        if (ru.metaculture.protection.WildClient.primaryVal == null || ru.metaculture.protection.WildClient.primaryVal.paramVal == null) {
            return null;
        }
        return new File(ru.metaculture.protection.WildClient.primaryVal.paramVal, "custom-rotation.json");
    }

    private static float primaryVal(float f, float f2, float f3) {
        if (!Float.isFinite(f)) {
            return f2;
        }
        return Math.max(f2, Math.min(f3, f));
    }

    public static final class RotationPoint {
        @SerializedName(value="x")
        public float primaryVal;
        @SerializedName(value="y")
        public float secondaryVal;

        public RotationPoint() {
        }

        public RotationPoint(float f, float f2) {
            this.primaryVal = f;
            this.secondaryVal = f2;
        }
    }
}

