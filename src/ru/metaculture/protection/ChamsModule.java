/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10042
 *  net.minecraft.class_10055
 */
package ru.metaculture.protection;

import java.awt.Color;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_10042;
import net.minecraft.class_10055;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.PrismaticChamsShaderRegistry;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.EntityRenderStateAccessor;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Chams", secondaryVal="Beautiful shader fill for entity models behind walls.", tertiaryVal=ModuleCategory.Visuals)
public final class ChamsModule
extends Module {
    public static final String countVal = "Crystal";
    public static final String depthVal = "Void";
    public static final String descRef = "Phantom";
    public static final String activeVal = "Hybrid";
    public static final String radiusVal = "By scene";
    public static final String factorVal = "Through walls";
    public final SettingGroup sourceVal;
    public final ModeSetting extraRef;
    public final ModeSetting phaseVal;
    public final BoolSetting limitRef;
    public final BoolSetting paramRef;
    public final FloatSetting groupVal;
    public final ColorSetting layerVal;
    public final ColorSetting slotVal;
    public final FloatSetting themeVal;
    public final FloatSetting stageVal;
    public final FloatSetting widthRef;
    private final Map<Integer, WildClient> trackVal;

    public ChamsModule() {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[4];
        vvNnnUNnVvnArray[0] = new BoolSetting("Players", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Mobs", true);
        vvNnnUNnVvnArray[2] = new BoolSetting("Self", false);
        vvNnnUNnVvnArray[3] = new BoolSetting("Invisible", true);
        this.sourceVal = new SettingGroup("Targets", vvNnnUNnVvnArray);
        String[] stringArray = new String[3];
        stringArray[0] = countVal;
        stringArray[1] = depthVal;
        stringArray[2] = descRef;
        this.extraRef = new ModeSetting("Mode", countVal, stringArray);
        String[] stringArray2 = new String[3];
        stringArray2[0] = activeVal;
        stringArray2[1] = radiusVal;
        stringArray2[2] = factorVal;
        this.phaseVal = new ModeSetting("Depth", activeVal, stringArray2);
        this.limitRef = new BoolSetting("Hide armor and items", true);
        this.paramRef = new BoolSetting("Hide vanilla shadow", true);
        this.groupVal = new FloatSetting("Distance", 96.0f, 8.0f, 256.0f, 1.0f, false);
        this.layerVal = new ColorSetting("Top accent", 58.0f, 0.72f, 1.0f, 1.0f);
        this.slotVal = new ColorSetting("Bottom accent", 76.0f, 0.82f, 1.0f, 1.0f);
        this.themeVal = new FloatSetting("Intensity", 1.35f, 0.35f, 3.0f, 0.05f, false);
        this.stageVal = new FloatSetting("Transparency", 1.0f, 0.25f, 1.0f, 0.01f, true);
        this.widthRef = new FloatSetting("Refraction", 0.72f, 0.35f, 1.15f, 0.01f, false);
        this.trackVal = new ConcurrentHashMap<Integer, WildClient>();
        PrismaticChamsShaderRegistry.primaryVal();
        this.extraRef.paramVal = "Screen-space chams shader: Crystal, Void, or Phantom";
        this.phaseVal.paramVal = "Hybrid draws a hidden pass through walls and a main pass via the depth buffer";
        this.limitRef.marginVal = "Disables armor, held items, and other feature layers on the highlighted entity";
        this.paramRef.marginVal = "Removes the standard round Minecraft shadow under the highlighted entity";
        Setting[] nvUuvVvuuNArray = new Setting[11];
        nvUuvVvuuNArray[0] = this.sourceVal;
        nvUuvVvuuNArray[1] = this.extraRef;
        nvUuvVvuuNArray[2] = this.phaseVal;
        nvUuvVvuuNArray[3] = this.limitRef;
        nvUuvVvuuNArray[4] = this.paramRef;
        nvUuvVvuuNArray[5] = this.groupVal;
        nvUuvVvuuNArray[6] = this.layerVal;
        nvUuvVvuuNArray[7] = this.slotVal;
        nvUuvVvuuNArray[8] = this.themeVal;
        nvUuvVvuuNArray[9] = this.stageVal;
        nvUuvVvuuNArray[10] = this.widthRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    public boolean primaryVal(class_10042 class_100422) {
        return this.marginVal(class_100422) > 0.001f;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean secondaryVal(class_10042 class_100422) {
        if (!this.limitRef.tertiaryVal()) return false;
        if (!(this.marginVal(class_100422) > 0.001f)) return false;
        return true;
    }

    public boolean tertiaryVal(class_10042 class_100422) {
        return this.paramRef.tertiaryVal() && this.marginVal(class_100422) > 0.001f;
    }

    public float marginVal(class_10042 class_100422) {
        if (class_100422 == null) {
            return 0.0f;
        }
        int n = ChamsModule.paramVal(class_100422);
        boolean bl = this.weightVal(class_100422);
        WildClient modeVal = this.trackVal.get(n);
        if (modeVal == null && !bl) {
            return 0.0f;
        }
        if (modeVal == null) {
            modeVal = new WildClient();
            this.trackVal.put(n, modeVal);
        }
        long l = System.nanoTime();
        float f = modeVal.tertiaryVal == 0L ? 0.0f : Math.min((float)(l - modeVal.tertiaryVal) / 1.0E9f, 0.05f);
        modeVal.tertiaryVal = l;
        float f2 = bl ? 1.0f : 0.0f;
        float f3 = f2 - modeVal.primaryVal;
        modeVal.secondaryVal += f3 * 42.0f * f;
        modeVal.secondaryVal *= (float)Math.exp(-13.0f * f);
        modeVal.primaryVal += modeVal.secondaryVal * f;
        if (modeVal.primaryVal < 0.0f) {
            modeVal.primaryVal = 0.0f;
            modeVal.secondaryVal = 0.0f;
        } else if (modeVal.primaryVal > 1.12f) {
            modeVal.primaryVal = 1.12f;
            modeVal.secondaryVal *= -0.22f;
        }
        if (!bl && modeVal.primaryVal <= 0.001f) {
            this.trackVal.remove(n);
            return 0.0f;
        }
        return modeVal.primaryVal;
    }

    public boolean blockRef() {
        Iterator<Map.Entry<Integer, WildClient>> iterator = this.trackVal.entrySet().iterator();
        while (iterator.hasNext()) {
            WildClient modeVal = iterator.next().getValue();
            if (modeVal.primaryVal <= 0.001f && modeVal.secondaryVal <= 0.001f) {
                iterator.remove();
                continue;
            }
            return true;
        }
        return false;
    }

    public int holderVal() {
        if (this.extraRef.secondaryVal(depthVal)) {
            return 1;
        }
        if (this.extraRef.secondaryVal(descRef)) {
            return 2;
        }
        return 0;
    }

    public boolean timerVal() {
        return this.phaseVal.secondaryVal(activeVal);
    }

    public boolean anchorVal() {
        return this.phaseVal.secondaryVal(radiusVal);
    }

    private boolean weightVal(class_10042 class_100422) {
        block11: {
            block10: {
                if (!this.enabled) {
                    return false;
                }
                if (class_100422 == null || ChamsModule.mc.field_1724 == null) break block10;
                if (ChamsModule.mc.field_1687 != null) break block11;
            }
            return false;
        }
        if (class_100422.field_53333 && !this.sourceVal.secondaryVal("Invisible")) {
            return false;
        }
        float f = Math.max(1.0f, this.groupVal.tertiaryVal());
        if (class_100422.field_53332 > (double)(f * f)) {
            return false;
        }
        if (class_100422 instanceof class_10055) {
            class_10055 class_100552 = (class_10055)class_100422;
            if (ChamsModule.mc.field_1724 != null) {
                if (class_100552.field_53529 != null) {
                    if (class_100552.field_53529.equals(ChamsModule.mc.field_1724.method_5477().getString())) {
                        return this.sourceVal.secondaryVal("Self");
                    }
                }
            }
            return this.sourceVal.secondaryVal("Players");
        }
        return this.sourceVal.secondaryVal("Mobs");
    }

    public float[] weightRef() {
        return ChamsModule.primaryVal(this.layerVal.tertiaryVal());
    }

    public float[] bufferVal() {
        return ChamsModule.primaryVal(this.slotVal.tertiaryVal());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ChamsModule countVal() {
        ChamsModule unitA = ChamsModule.depthVal();
        if (unitA == null) return null;
        if (!unitA.enabled) {
            if (!unitA.blockRef()) return null;
        }
        ChamsModule kelpA = unitA;
        return kelpA;
    }

    public static ChamsModule depthVal() {
        block3: {
            block2: {
                if (ru.metaculture.protection.WildClient.primaryVal == null) break block2;
                if (ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null) break block3;
            }
            return null;
        }
        return ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(ChamsModule.class);
    }

    private static int paramVal(class_10042 class_100422) {
        int n = ((EntityRenderStateAccessor)class_100422).wild$getEntityId();
        if (n != Integer.MIN_VALUE) {
            return n;
        }
        int n2 = class_100422.field_58171 == null ? 0 : class_100422.field_58171.hashCode();
        int n3 = Math.round((float)class_100422.field_53325 * 8.0f);
        int n4 = Math.round((float)class_100422.field_53326 * 8.0f);
        int n5 = Math.round((float)class_100422.field_53327 * 8.0f);
        int n6 = n2;
        n6 = n6 * 31 + n3;
        n6 = n6 * 31 + n4;
        n6 = n6 * 31 + n5;
        return n6;
    }

    private static float[] primaryVal(Color color) {
        float[] fArray = new float[4];
        fArray[0] = (float)color.getRed() / 255.0f;
        fArray[1] = (float)color.getGreen() / 255.0f;
        fArray[2] = (float)color.getBlue() / 255.0f;
        fArray[3] = (float)color.getAlpha() / 255.0f;
        return fArray;
    }

    static final class WildClient {
        float primaryVal;
        float secondaryVal;
        long tertiaryVal;

        WildClient() {
        }
    }
}

