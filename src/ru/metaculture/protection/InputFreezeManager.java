/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10185
 *  net.minecraft.class_304
 *  net.minecraft.class_3675
 */
package ru.metaculture.protection;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.class_10185;
import net.minecraft.class_304;
import net.minecraft.class_3675;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.AttackAuraModule;

public class InputFreezeManager
implements MinecraftAccessor {
    private static final InputFreezeManager secondaryVal = new InputFreezeManager();
    public final Set<String> primaryVal = new HashSet<String>();

    private InputFreezeManager() {
    }

    public static InputFreezeManager primaryVal() {
        return secondaryVal;
    }

    public void primaryVal(String string) {
        block6: {
            block5: {
                if (InputFreezeManager.a_.field_1724 == null || !InputFreezeManager.a_.field_1724.method_5805()) break block5;
                if (InputFreezeManager.a_.field_1687 != null) break block6;
            }
            return;
        }
        AttackAuraModule.NUVvUUVuVNVv = true;
        this.primaryVal.add(string);
        this.primaryVal(false);
        if (InputFreezeManager.a_.field_1724.method_5624()) {
            InputFreezeManager.a_.field_1724.method_5728(false);
        }
        if (InputFreezeManager.a_.field_1724.field_3913 != null) {
            InputFreezeManager.a_.field_1724.field_3913.field_54155 = class_10185.field_54098;
        }
    }

    public void secondaryVal(String string) {
        block5: {
            block4: {
                if (InputFreezeManager.a_.field_1724 == null) break block4;
                if (InputFreezeManager.a_.field_1724.method_5805() && InputFreezeManager.a_.field_1687 != null) break block5;
            }
            return;
        }
        this.primaryVal.remove(string);
        if (this.primaryVal.isEmpty() && InputFreezeManager.a_.field_1755 == null) {
            this.primaryVal(true);
            AttackAuraModule.NUVvUUVuVNVv = false;
        }
    }

    private void primaryVal(boolean bl) {
        if (InputFreezeManager.a_.field_1690 == null || a_.method_22683() == null) {
            return;
        }
        class_304[] class_304Array = new class_304[6];
        class_304Array[0] = InputFreezeManager.a_.field_1690.field_1894;
        class_304Array[1] = InputFreezeManager.a_.field_1690.field_1881;
        class_304Array[2] = InputFreezeManager.a_.field_1690.field_1913;
        class_304Array[3] = InputFreezeManager.a_.field_1690.field_1849;
        class_304Array[4] = InputFreezeManager.a_.field_1690.field_1903;
        class_304Array[5] = InputFreezeManager.a_.field_1690.field_1867;
        class_304[] class_304Array2 = class_304Array;
        long l = a_.method_22683().method_4490();
        for (class_304 class_3042 : class_304Array2) {
            boolean bl2 = bl && class_3675.method_15987((long)l, (int)class_3042.method_1429().method_1444());
            class_3042.method_23481(bl2);
        }
    }
}

