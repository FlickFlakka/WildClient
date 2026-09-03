/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import org.wild.module.api.Module;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.MouseScrollEvent;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.MouseClickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;
import ru.metaculture.protection.KeybindMode;

public class VnVvnNNuVuUu {
    private static final VnVvnNNuVuUu primaryVal = new VnVvnNNuVuUu();
    private static final class_310 secondaryVal = class_310.method_1551();
    private boolean tertiaryVal = false;
    private boolean marginVal = false;

    public static VnVvnNNuVuUu primaryVal() {
        return primaryVal;
    }

    public void secondaryVal() {
        if (this.tertiaryVal) {
            return;
        }
        EventManager.register(this);
        this.tertiaryVal = true;
    }

    @Subscribe
    public void primaryVal(MouseButtonEvent spanD) {
        if (spanD.primaryVal()) {
            return;
        }
        if (spanD.paramVal() != 1) {
            return;
        }
        if (spanD.marginVal() < 0) {
            return;
        }
        if (WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        Module[] moduleArray = WildClient.primaryVal.secondaryVal.primaryVal(spanD.marginVal());
        if (moduleArray != null) {
            for (Module module : moduleArray) {
                module.toggle();
            }
        }
        this.secondaryVal(spanD.marginVal());
    }

    @Subscribe
    public void primaryVal(MouseClickEvent spanI) {
        if (spanI.primaryVal()) {
            return;
        }
        if (spanI.speedVal()) {
            return;
        }
        if (!spanI.widthVal()) {
            return;
        }
        if (secondaryVal != null && VnVvnNNuVuUu.secondaryVal.field_1755 != null) {
            return;
        }
        if (this.marginVal) {
            return;
        }
        if (WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        int n = -100 - spanI.marginVal();
        Module[] moduleArray = WildClient.primaryVal.secondaryVal.primaryVal(n);
        if (moduleArray != null) {
            Module[] moduleArray2 = moduleArray;
            int n2 = moduleArray2.length;
            for (int i = 0; i < n2; ++i) {
                Module module = moduleArray2[i];
                module.toggle();
            }
        }
        this.secondaryVal(n);
    }

    @Subscribe
    public void primaryVal(MouseScrollEvent uVNVVUunvN) {
        if (uVNVVUunvN.primaryVal()) {
            return;
        }
        if (uVNVVUunvN.limitVal()) {
            return;
        }
        if (secondaryVal != null && VnVvnNNuVuUu.secondaryVal.field_1755 != null) {
            return;
        }
        if (this.marginVal || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        if (Math.abs(uVNVVUunvN.weightVal()) < 1.0E-4) {
            return;
        }
        int n = uVNVVUunvN.weightVal() > 0.0 ? -200 : -201;
        Module[] moduleArray = WildClient.primaryVal.secondaryVal.primaryVal(n);
        if (moduleArray == null) {
            return;
        }
        Module[] moduleArray2 = moduleArray;
        int n2 = moduleArray2.length;
        for (int i = 0; i < n2; ++i) {
            Module module = moduleArray2[i];
            module.toggle();
        }
    }

    private void secondaryVal(int n) {
        for (Module module : WildClient.primaryVal.secondaryVal.primaryVal) {
            for (Setting nodeA : module.getAllSettings()) {
                if (nodeA instanceof BoolSetting) {
                    BoolSetting vvNnnUNnVvn2 = (BoolSetting)nodeA;
                    this.primaryVal(vvNnnUNnVvn2, n);
                    continue;
                }
                if (!(nodeA instanceof SettingGroup)) continue;
                SettingGroup vUVnvvnNN = (SettingGroup)nodeA;
                for (BoolSetting vvNnnUNnVvn3 : vUVnvvnNN.marginVal) {
                    this.primaryVal(vvNnnUNnVvn3, n);
                }
            }
        }
    }

    private void primaryVal(BoolSetting vvNnnUNnVvn2, int n) {
        if (vvNnnUNnVvn2.paramVal == n && !vvNnnUNnVvn2.extraVal) {
            vvNnnUNnVvn2.secondaryVal(!vvNnnUNnVvn2.marginVal());
        }
    }

    public void tertiaryVal() {
    }

    public void primaryVal(String string) {
    }

    public void primaryVal(boolean bl) {
        this.marginVal = bl;
    }

    public boolean marginVal() {
        return this.marginVal;
    }

    public void primaryVal(Module module, int n, KeybindMode vvVUVuVvnnVN2) {
        if (module != null) {
            module.keyIndex = n;
        }
    }

    public void primaryVal(Module module, Setting nodeA, KeybindMode vvVUVuVvnnVN2, int n, Object object) {
    }

    public void primaryVal(String string, String string2) {
    }

    public Object secondaryVal(String string, String string2) {
        return null;
    }

    public String primaryVal(int n) {
        block19: {
            block18: {
                if (n == -200) {
                    return "Wheel Up";
                }
                if (n == -201) {
                    return "Wheel Down";
                }
                if (n <= -100) {
                    return "Mouse " + (Math.abs(n + 100) + 1);
                }
                if (n == -1) {
                    return "None";
                }
                if (n >= 65 && n <= 90) {
                    return String.valueOf((char)(65 + (n - 65)));
                }
                if (n >= 48 && n <= 57) {
                    return String.valueOf((char)(48 + (n - 48)));
                }
                if (n == 32) {
                    return "Space";
                }
                if (n == 257) {
                    return "Enter";
                }
                if (n == 256) {
                    return "Escape";
                }
                if (n == 259) {
                    return "Backspace";
                }
                if (n == 258) {
                    return "Tab";
                }
                if (n == 340) break block18;
                if (n != 344) break block19;
            }
            return "Shift";
        }
        if (n == 341 || n == 345) {
            return "Ctrl";
        }
        if (n == 342 || n == 346) {
            return "Alt";
        }
        if (n >= 290) {
            if (n <= 314) {
                return "F" + (n - 290 + 1);
            }
        }
        return "Key " + n;
    }
}

