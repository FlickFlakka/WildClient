/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1306
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_7833
 *  org.joml.Quaternionfc
 */
package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_1306;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_7833;
import org.joml.Quaternionfc;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.HeldItemRenderEvent;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.HandSwingEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Swing Animation", secondaryVal="Hand animation customization", tertiaryVal=ModuleCategory.Visuals)
public class SwingAnimationModule
extends Module {
    public static ModeSetting countVal;
    public static FloatSetting depthVal;
    public static FloatSetting descRef;
    public static FloatSetting activeVal;
    public static FloatSetting radiusVal;
    public static BoolSetting factorVal;
    public static BoolSetting sourceVal;
    public static BoolSetting extraRef;
    public static FloatSetting phaseVal;
    public static FloatSetting limitRef;
    public static FloatSetting paramRef;
    public static FloatSetting groupVal;
    public static FloatSetting layerVal;
    public static FloatSetting slotVal;
    public static FloatSetting themeVal;
    public static FloatSetting stageVal;
    public static FloatSetting widthRef;

    public SwingAnimationModule() {
        Setting[] nvUuvVvuuNArray = new Setting[17];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = activeVal;
        nvUuvVvuuNArray[3] = radiusVal;
        nvUuvVvuuNArray[4] = descRef;
        nvUuvVvuuNArray[5] = factorVal;
        nvUuvVvuuNArray[6] = sourceVal;
        nvUuvVvuuNArray[7] = extraRef;
        nvUuvVvuuNArray[8] = phaseVal;
        nvUuvVvuuNArray[9] = limitRef;
        nvUuvVvuuNArray[10] = paramRef;
        nvUuvVvuuNArray[11] = groupVal;
        nvUuvVvuuNArray[12] = layerVal;
        nvUuvVvuuNArray[13] = slotVal;
        nvUuvVvuuNArray[14] = themeVal;
        nvUuvVvuuNArray[15] = stageVal;
        nvUuvVvuuNArray[16] = widthRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(HeldItemRenderEvent sackI) {
        if (!this.enabled || countVal.secondaryVal("Off")) {
            return;
        }
        if (!SwingAnimationModule.blockRef() || !sackI.marginVal().equals((Object)class_1268.field_5808)) {
            return;
        }
        String string = countVal.tertiaryVal();
        if (string.equals("Off")) {
            return;
        }
        if (sackI.marginVal().equals((Object)class_1268.field_5808)) {
            class_4587 class_45872 = sackI.tertiaryVal();
            float f = sackI.weightVal();
            int n = SwingAnimationModule.mc.field_1724.method_6068().equals((Object)class_1306.field_6183) ? 1 : -1;
            float f2 = (float)Math.sin((double)f * 1.5707963267948966 * 2.0);
            float f3 = (float)Math.sin((double)f * 1.5707963267948966 * 2.0);
            float f4 = (float)(Math.sin((double)f * Math.PI) * 0.5);
            float f5 = class_3532.method_15374((float)(f * f * (float)Math.PI));
            float f6 = class_3532.method_15374((float)(class_3532.method_15355((float)f) * (float)Math.PI));
            switch (countVal.tertiaryVal()) {
                case "Swipe": {
                    class_45872.method_46416((float)n * 0.67f, -0.32f, -1.0f);
                    class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((float)(90 * n)));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees((float)(-60 * n)));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f2 * -descRef.tertiaryVal() * 10.0f));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-90.0f));
                    break;
                }
                case "Swipe back": {
                    class_45872.method_46416((float)n * 0.67f, -0.32f, -1.0f);
                    class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((float)(90 * n)));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees((float)(-60 * n)));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f2 * descRef.tertiaryVal() * 10.0f));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-90.0f));
                    break;
                }
                case "SwipeD": {
                    class_45872.method_46416((float)n * 0.67f, -0.32f, -1.0f);
                    class_45872.method_46416(f6 * -descRef.tertiaryVal() / 35.0f, 0.0f, f6 * -descRef.tertiaryVal() / 35.0f);
                    class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(25.0f));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f6 * -descRef.tertiaryVal() * 5.0f));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(30.0f));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-90.0f));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(50.0f));
                    break;
                }
                case "Down": {
                    class_45872.method_46416((float)n * 0.67f, -0.32f, -1.0f);
                    class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((float)(80 * n)));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees((float)(-30 * n)));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f2 * -descRef.tertiaryVal() * 10.0f));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-100.0f));
                    break;
                }
                case "Spin": {
                    class_45872.method_46416((float)n * 0.56f, -0.42f, -0.72f);
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(0.0f + f * 360.0f));
                    class_45872.method_22904(0.0, -0.1, 0.0);
                    break;
                }
                case "Smooth": {
                    class_45872.method_46416((float)n * 0.56f, -0.42f, -0.72f);
                    class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((float)n * (45.0f + f2 * -descRef.tertiaryVal() * 3.0f)));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees((float)n * f3 * -descRef.tertiaryVal() * 2.0f));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f3 * -descRef.tertiaryVal() * 10.0f));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((float)n * -45.0f));
                    class_45872.method_22904(0.0, -0.1, 0.0);
                }
            }
            sackI.secondaryVal();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean blockRef() {
        if (!factorVal.tertiaryVal()) {
            return true;
        }
        AttackAuraModule coreB = (AttackAuraModule)WildClient.primaryVal.secondaryVal.secondaryVal(AttackAuraModule.class);
        if (coreB == null) return false;
        if (!coreB.enabled) return false;
        if (AttackAuraModule.tokenVal == null) return false;
        return true;
    }

    public static float primaryVal(class_1268 class_12682) {
        block5: {
            block4: {
                if (class_12682 == null || WildClient.primaryVal == null) break block4;
                if (WildClient.primaryVal.secondaryVal != null && SwingAnimationModule.mc.field_1724 != null) break block5;
            }
            return 1.0f;
        }
        SwingAnimationModule uuVUNuuuU = WildClient.primaryVal.secondaryVal.primaryVal(SwingAnimationModule.class);
        if (uuVUNuuuU == null || !uuVUNuuuU.enabled) {
            return 1.0f;
        }
        class_1306 class_13062 = class_12682 == class_1268.field_5808 ? SwingAnimationModule.mc.field_1724.method_6068() : (SwingAnimationModule.mc.field_1724.method_6068() == class_1306.field_6183 ? class_1306.field_6182 : class_1306.field_6183);
        return class_13062 == class_1306.field_6183 ? activeVal.tertiaryVal() : radiusVal.tertiaryVal();
    }

    @Subscribe
    public void primaryVal(HandSwingEvent vNUuUNVun2) {
        boolean bl = vNUuUNVun2.weightVal();
        class_4587 class_45872 = vNUuUNVun2.tertiaryVal();
        if (sourceVal.tertiaryVal() && extraRef.tertiaryVal()) {
            if (bl) {
                class_45872.method_46416(phaseVal.tertiaryVal(), limitRef.tertiaryVal(), paramRef.tertiaryVal());
            } else {
                class_45872.method_46416(-phaseVal.tertiaryVal(), limitRef.tertiaryVal(), paramRef.tertiaryVal());
            }
        }
        if (sourceVal.tertiaryVal()) {
            if (!extraRef.tertiaryVal()) {
                if (bl) {
                    class_45872.method_46416(groupVal.tertiaryVal(), layerVal.tertiaryVal(), slotVal.tertiaryVal());
                } else {
                    class_45872.method_46416(themeVal.tertiaryVal(), stageVal.tertiaryVal(), widthRef.tertiaryVal());
                }
            }
        }
    }

    static {
        String[] stringArray = new String[7];
        stringArray[0] = "Smooth";
        stringArray[1] = "Swipe";
        stringArray[2] = "Swipe back";
        stringArray[3] = "SwipeD";
        stringArray[4] = "Down";
        stringArray[5] = "Spin";
        stringArray[6] = "Off";
        countVal = new ModeSetting("Animation", "Smooth", stringArray);
        depthVal = new FloatSetting("Animation speed", 1.0f, 0.1f, 3.0f, 0.1f, false);
        descRef = new FloatSetting("Animation size", 3.7f, 1.0f, 10.0f, 0.1f, false).primaryVal(() -> countVal.secondaryVal("Off"));
        activeVal = new FloatSetting("Right item size", 1.0f, 0.2f, 2.5f, 0.05f, false);
        radiusVal = new FloatSetting("Left item size", 1.0f, 0.2f, 2.5f, 0.05f, false);
        factorVal = new BoolSetting("Aura only", false);
        sourceVal = new BoolSetting("Hand model", false);
        extraRef = new BoolSetting("Change both hands", false).primaryVal(() -> !sourceVal.tertiaryVal());
        phaseVal = new FloatSetting("X", 0.0f, -2.0f, 2.0f, 0.01f, false).primaryVal(() -> {
            boolean bl;
            if (sourceVal.tertiaryVal() && extraRef.tertiaryVal()) {
                bl = false;
                return bl;
            }
            bl = true;
            return bl;
        });
        limitRef = new FloatSetting("Y", 0.0f, -2.0f, 2.0f, 0.01f, false).primaryVal(() -> !sourceVal.tertiaryVal() || !extraRef.tertiaryVal());
        paramRef = new FloatSetting("Z", 0.0f, -2.0f, 2.0f, 0.01f, false).primaryVal(() -> !sourceVal.tertiaryVal() || !extraRef.tertiaryVal());
        groupVal = new FloatSetting("X right", 0.0f, -2.0f, 2.0f, 0.01f, false).primaryVal(() -> {
            boolean bl;
            if (sourceVal.tertiaryVal()) {
                if (!extraRef.tertiaryVal()) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
        layerVal = new FloatSetting("Y right", 0.0f, -2.0f, 2.0f, 0.01f, false).primaryVal(() -> {
            boolean bl;
            if (sourceVal.tertiaryVal()) {
                if (!extraRef.tertiaryVal()) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
        slotVal = new FloatSetting("Z right", 0.0f, -2.0f, 2.0f, 0.01f, false).primaryVal(() -> {
            boolean bl;
            if (sourceVal.tertiaryVal() && !extraRef.tertiaryVal()) {
                bl = false;
                return bl;
            }
            bl = true;
            return bl;
        });
        themeVal = new FloatSetting("X left", 0.0f, -2.0f, 2.0f, 0.01f, false).primaryVal(() -> {
            boolean bl;
            if (sourceVal.tertiaryVal()) {
                if (!extraRef.tertiaryVal()) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
        stageVal = new FloatSetting("Y left", 0.0f, -2.0f, 2.0f, 0.01f, false).primaryVal(() -> {
            boolean bl;
            if (sourceVal.tertiaryVal()) {
                if (!extraRef.tertiaryVal()) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
        widthRef = new FloatSetting("Z left", 0.0f, -2.0f, 2.0f, 0.01f, false).primaryVal(() -> {
            boolean bl;
            if (sourceVal.tertiaryVal()) {
                if (!extraRef.tertiaryVal()) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
    }
}

