/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 */
package ru.metaculture.protection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="NoInteract", secondaryVal="Prevents interaction with selected blocks", tertiaryVal=ModuleCategory.Player)
public class NoInteractModule
extends Module {
    public static SettingGroup countVal;

    public NoInteractModule() {
        this.addSettings(countVal);
    }

    public static Set<class_2248> blockRef() {
        HashSet<class_2248> hashSet = new HashSet<class_2248>();
        NoInteractModule.primaryVal(hashSet, 2, class_2246.field_10034, class_2246.field_10380, class_2246.field_16328);
        class_2248[] class_2248Array = new class_2248[21];
        class_2248Array[0] = class_2246.field_10149;
        class_2248Array[1] = class_2246.field_10521;
        class_2248Array[2] = class_2246.field_10352;
        class_2248Array[3] = class_2246.field_10627;
        class_2248Array[4] = class_2246.field_10232;
        class_2248Array[5] = class_2246.field_10403;
        class_2248Array[6] = class_2246.field_37566;
        class_2248Array[7] = class_2246.field_42748;
        class_2248Array[8] = class_2246.field_54729;
        class_2248Array[9] = class_2246.field_40291;
        class_2248Array[10] = class_2246.field_22102;
        class_2248Array[11] = class_2246.field_22103;
        class_2248Array[12] = class_2246.field_9973;
        class_2248Array[13] = class_2246.field_47040;
        class_2248Array[14] = class_2246.field_47041;
        class_2248Array[15] = class_2246.field_47043;
        class_2248Array[16] = class_2246.field_47042;
        class_2248Array[17] = class_2246.field_47044;
        class_2248Array[18] = class_2246.field_47045;
        class_2248Array[19] = class_2246.field_47047;
        class_2248Array[20] = class_2246.field_47046;
        NoInteractModule.primaryVal(hashSet, 3, class_2248Array);
        class_2248[] class_2248Array2 = new class_2248[14];
        class_2248Array2[0] = class_2246.field_10057;
        class_2248Array2[1] = class_2246.field_10066;
        class_2248Array2[2] = class_2246.field_10417;
        class_2248Array2[3] = class_2246.field_10553;
        class_2248Array2[4] = class_2246.field_10278;
        class_2248Array2[5] = class_2246.field_10493;
        class_2248Array2[6] = class_2246.field_37559;
        class_2248Array2[7] = class_2246.field_42743;
        class_2248Array2[8] = class_2246.field_54724;
        class_2248Array2[9] = class_2246.field_40286;
        class_2248Array2[10] = class_2246.field_22100;
        class_2248Array2[11] = class_2246.field_22101;
        class_2248Array2[12] = class_2246.field_10494;
        class_2248Array2[13] = class_2246.field_23864;
        NoInteractModule.primaryVal(hashSet, 4, class_2248Array2);
        NoInteractModule.primaryVal(hashSet, 5, class_2246.field_10312);
        NoInteractModule.primaryVal(hashSet, 6, class_2246.field_10200, class_2246.field_10228);
        NoInteractModule.primaryVal(hashSet, 7, class_2246.field_10179);
        NoInteractModule.primaryVal(hashSet, 8, class_2246.field_9980);
        NoInteractModule.primaryVal(hashSet, 9, class_2246.field_10137, class_2246.field_10323, class_2246.field_10486, class_2246.field_10017, class_2246.field_10608, class_2246.field_10246, class_2246.field_37555, class_2246.field_42740, class_2246.field_54723, class_2246.field_40285, class_2246.field_22094, class_2246.field_22095, class_2246.field_10453, class_2246.field_47048, class_2246.field_47049, class_2246.field_47051, class_2246.field_47050, class_2246.field_47052, class_2246.field_47053, class_2246.field_47063, class_2246.field_47062);
        NoInteractModule.primaryVal(hashSet, 10, class_2246.field_10181, class_2246.field_16333, class_2246.field_16334);
        class_2248[] class_2248Array3 = new class_2248[12];
        class_2248Array3[0] = class_2246.field_10188;
        class_2248Array3[1] = class_2246.field_10291;
        class_2248Array3[2] = class_2246.field_10513;
        class_2248Array3[3] = class_2246.field_10041;
        class_2248Array3[4] = class_2246.field_10457;
        class_2248Array3[5] = class_2246.field_10196;
        class_2248Array3[6] = class_2246.field_37563;
        class_2248Array3[7] = class_2246.field_42745;
        class_2248Array3[8] = class_2246.field_54730;
        class_2248Array3[9] = class_2246.field_40289;
        class_2248Array3[10] = class_2246.field_22096;
        class_2248Array3[11] = class_2246.field_22097;
        NoInteractModule.primaryVal(hashSet, 11, class_2248Array3);
        class_2248[] class_2248Array4 = new class_2248[3];
        class_2248Array4[0] = class_2246.field_10535;
        class_2248Array4[1] = class_2246.field_10105;
        class_2248Array4[2] = class_2246.field_10414;
        NoInteractModule.primaryVal(hashSet, 12, class_2248Array4);
        class_2248[] class_2248Array5 = new class_2248[17];
        class_2248Array5[0] = class_2246.field_10603;
        class_2248Array5[1] = class_2246.field_10199;
        class_2248Array5[2] = class_2246.field_10407;
        class_2248Array5[3] = class_2246.field_10063;
        class_2248Array5[4] = class_2246.field_10203;
        class_2248Array5[5] = class_2246.field_10600;
        class_2248Array5[6] = class_2246.field_10275;
        class_2248Array5[7] = class_2246.field_10051;
        class_2248Array5[8] = class_2246.field_10140;
        class_2248Array5[9] = class_2246.field_10320;
        class_2248Array5[10] = class_2246.field_10532;
        class_2248Array5[11] = class_2246.field_10268;
        class_2248Array5[12] = class_2246.field_10605;
        class_2248Array5[13] = class_2246.field_10373;
        class_2248Array5[14] = class_2246.field_10055;
        class_2248Array5[15] = class_2246.field_10068;
        class_2248Array5[16] = class_2246.field_10371;
        NoInteractModule.primaryVal(hashSet, 13, class_2248Array5);
        NoInteractModule.primaryVal(hashSet, 14, class_2246.field_10443);
        NoInteractModule.primaryVal(hashSet, 15, class_2246.field_10333);
        NoInteractModule.primaryVal(hashSet, 16, class_2246.field_10485);
        class_2248[] class_2248Array6 = new class_2248[1];
        class_2248Array6[0] = class_2246.field_16330;
        NoInteractModule.primaryVal(hashSet, 17, class_2248Array6);
        NoInteractModule.primaryVal(hashSet, 18, class_2246.field_16337, class_2246.field_10083, class_2246.field_16336, class_2246.field_16329, class_2246.field_16335);
        class_2248[] class_2248Array7 = new class_2248[16];
        class_2248Array7[0] = class_2246.field_10120;
        class_2248Array7[1] = class_2246.field_10410;
        class_2248Array7[2] = class_2246.field_10230;
        class_2248Array7[3] = class_2246.field_10621;
        class_2248Array7[4] = class_2246.field_10356;
        class_2248Array7[5] = class_2246.field_10180;
        class_2248Array7[6] = class_2246.field_10610;
        class_2248Array7[7] = class_2246.field_10141;
        class_2248Array7[8] = class_2246.field_10326;
        class_2248Array7[9] = class_2246.field_10109;
        class_2248Array7[10] = class_2246.field_10019;
        class_2248Array7[11] = class_2246.field_10527;
        class_2248Array7[12] = class_2246.field_10288;
        class_2248Array7[13] = class_2246.field_10561;
        class_2248Array7[14] = class_2246.field_10069;
        class_2248Array7[15] = class_2246.field_10461;
        NoInteractModule.primaryVal(hashSet, 19, class_2248Array7);
        class_2248[] class_2248Array8 = new class_2248[16];
        class_2248Array8[0] = class_2246.field_10484;
        class_2248Array8[1] = class_2246.field_10332;
        class_2248Array8[2] = class_2246.field_10592;
        class_2248Array8[3] = class_2246.field_10026;
        class_2248Array8[4] = class_2246.field_10397;
        class_2248Array8[5] = class_2246.field_10470;
        class_2248Array8[6] = class_2246.field_37553;
        class_2248Array8[7] = class_2246.field_42737;
        class_2248Array8[8] = class_2246.field_54720;
        class_2248Array8[9] = class_2246.field_40284;
        class_2248Array8[10] = class_2246.field_22130;
        class_2248Array8[11] = class_2246.field_22131;
        class_2248Array8[12] = class_2246.field_10158;
        class_2248Array8[13] = class_2246.field_23863;
        class_2248Array8[14] = class_2246.field_10224;
        class_2248Array8[15] = class_2246.field_10582;
        NoInteractModule.primaryVal(hashSet, 20, class_2248Array8);
        NoInteractModule.primaryVal(hashSet, 21, class_2246.field_47072, class_2246.field_47073, class_2246.field_47074, class_2246.field_47075, class_2246.field_47076, class_2246.field_47077, class_2246.field_47078, class_2246.field_47079);
        class_2248[] class_2248Array9 = new class_2248[4];
        class_2248Array9[0] = class_2246.field_10450;
        class_2248Array9[1] = class_2246.field_10377;
        class_2248Array9[2] = class_2246.field_10429;
        class_2248Array9[3] = class_2246.field_10363;
        NoInteractModule.primaryVal(hashSet, 22, class_2248Array9);
        NoInteractModule.primaryVal(hashSet, 23, class_2246.field_10223, class_2246.field_16332, class_2246.field_42752, class_2246.field_40276, class_2246.field_23152, class_2246.field_10183, class_2246.field_10495, class_2246.field_17350, class_2246.field_23860);
        return hashSet;
    }

    private static void primaryVal(Set<class_2248> set, int n, class_2248 ... class_2248Array) {
        if (countVal.primaryVal(n - 1)) {
            set.addAll(Arrays.asList(class_2248Array));
        }
    }

    static {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[23];
        vvNnnUNnVvnArray[0] = new BoolSetting("Armor Stands", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Chests", true);
        vvNnnUNnVvnArray[2] = new BoolSetting("Doors", true);
        vvNnnUNnVvnArray[3] = new BoolSetting("Buttons", true);
        vvNnnUNnVvnArray[4] = new BoolSetting("Hoppers", true);
        vvNnnUNnVvnArray[5] = new BoolSetting("Dispensers", true);
        vvNnnUNnVvnArray[6] = new BoolSetting("Note Blocks", true);
        vvNnnUNnVvnArray[7] = new BoolSetting("Crafting Tables", true);
        vvNnnUNnVvnArray[8] = new BoolSetting("Trapdoors", true);
        vvNnnUNnVvnArray[9] = new BoolSetting("Furnaces", true);
        vvNnnUNnVvnArray[10] = new BoolSetting("Fence Gates", true);
        vvNnnUNnVvnArray[11] = new BoolSetting("Anvils", true);
        vvNnnUNnVvnArray[12] = new BoolSetting("Shulker Boxes", true);
        vvNnnUNnVvnArray[13] = new BoolSetting("Ender Chests", true);
        vvNnnUNnVvnArray[14] = new BoolSetting("Brewing Stands", true);
        vvNnnUNnVvnArray[15] = new BoolSetting("Enchanting Tables", true);
        vvNnnUNnVvnArray[16] = new BoolSetting("Lecterns", true);
        vvNnnUNnVvnArray[17] = new BoolSetting("Crafting Tables", true);
        vvNnnUNnVvnArray[18] = new BoolSetting("Beds", false);
        vvNnnUNnVvnArray[19] = new BoolSetting("Pressure Plates", false);
        vvNnnUNnVvnArray[20] = new BoolSetting("Copper Bulbs", false);
        vvNnnUNnVvnArray[21] = new BoolSetting("Redstone", false);
        vvNnnUNnVvnArray[22] = new BoolSetting("Other", false);
        countVal = new SettingGroup("Blocks", vvNnnUNnVvnArray);
    }
}

