/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import org.wild.module.api.Module;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.WorldContextSwapper;
import ru.metaculture.protection.Event;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.AntiAFKModule;
import ru.metaculture.protection.HeadlessBotSession;
import ru.metaculture.protection.ListenerRegistry;
import ru.metaculture.protection.AutoDropModule;

public final class BotModuleRegistry {
    private static final Set<String> primaryVal;
    private final HeadlessBotSession secondaryVal;
    private final ListenerRegistry tertiaryVal = new ListenerRegistry();
    private final Map<String, Module> marginVal = new LinkedHashMap<String, Module>();
    private boolean weightVal;

    public BotModuleRegistry(HeadlessBotSession vUNVNUnuv2) {
        this.secondaryVal = vUNVNUnuv2;
    }

    public void primaryVal() {
        block5: {
            block4: {
                if (this.weightVal) {
                    return;
                }
                if (this.secondaryVal.extraVal() == null) break block4;
                if (this.secondaryVal.limitVal() != null && this.secondaryVal.speedVal() != null && this.secondaryVal.widthVal()) break block5;
            }
            return;
        }
        this.weightVal = true;
        WorldContextSwapper.primaryVal(this.secondaryVal, this::weightVal);
    }

    private void weightVal() {
        block6: {
            block5: {
                if (WildClient.primaryVal == null) break block5;
                if (WildClient.primaryVal.secondaryVal != null) break block6;
            }
            this.primaryVal(AutoDropModule::new);
            this.primaryVal(AntiAFKModule::new);
            return;
        }
        for (Module module : new ArrayList<Module>(WildClient.primaryVal.secondaryVal.primaryVal)) {
            if (module == null || module.category == ModuleCategory.Visuals || primaryVal.contains(module.getClass().getSimpleName())) continue;
            try {
                Constructor<?> constructor = module.getClass().getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
                this.primaryVal((Module)constructor.newInstance(new Object[0]));
            }
            catch (Throwable throwable) {}
        }
    }

    private void primaryVal(Supplier<Module> supplier) {
        try {
            this.primaryVal(supplier.get());
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void primaryVal(Module module) {
        if (module == null) {
            return;
        }
        module.enabled = false;
        this.marginVal.putIfAbsent(module.name.toLowerCase(Locale.ROOT), module);
    }

    public Module primaryVal(String string) {
        this.primaryVal();
        return string == null ? null : this.marginVal.get(string.toLowerCase(Locale.ROOT));
    }

    public List<Module> secondaryVal() {
        this.primaryVal();
        return new ArrayList<Module>(this.marginVal.values());
    }

    public String tertiaryVal() {
        this.primaryVal();
        return String.join((CharSequence)", ", this.marginVal.keySet());
    }

    public boolean secondaryVal(String string) {
        Module module = this.primaryVal(string);
        return module != null && module.enabled;
    }

    public void primaryVal(String string, boolean bl) {
        Module module = this.primaryVal(string);
        if (module == null || module.enabled == bl) {
            return;
        }
        if (bl) {
            this.secondaryVal(module);
        } else {
            this.tertiaryVal(module);
        }
    }

    public void tertiaryVal(String string) {
        Module module = this.primaryVal(string);
        if (module != null) {
            this.primaryVal(string, !module.enabled);
        }
    }

    public void primaryVal(Event vunUNUNVUnv) {
        this.tertiaryVal.primaryVal(vunUNUNVUnv);
    }

    public void marginVal() {
        for (Module module : this.marginVal.values()) {
            if (!module.enabled) continue;
            this.tertiaryVal(module);
        }
    }

    private void secondaryVal(Module module) {
        module.enabled = true;
        try {
            WorldContextSwapper.primaryVal(this.secondaryVal, () -> {
                try {
                    module.onEnable();
                }
                finally {
                    EventManager.unregister(module);
                }
            });
            if (module.enabled) {
                this.tertiaryVal.primaryVal(module);
            }
        }
        catch (Throwable throwable) {
            module.enabled = false;
            this.tertiaryVal.secondaryVal(module);
            EventManager.unregister(module);
            System.err.println("[WildBot] " + this.secondaryVal.primaryVal() + ": failed to enable " + module.name);
            throwable.printStackTrace();
        }
    }

    private void tertiaryVal(Module module) {
        this.tertiaryVal.secondaryVal(module);
        module.enabled = false;
        try {
            WorldContextSwapper.primaryVal(this.secondaryVal, module::onDisable);
        }
        catch (Throwable throwable) {
            System.err.println("[WildBot] " + this.secondaryVal.primaryVal() + ": failed to disable " + module.name);
            throwable.printStackTrace();
        }
        finally {
            EventManager.unregister(module);
        }
    }

    static {
        String[] stringArray = new String[29];
        stringArray[0] = "AutoBuy";
        stringArray[1] = "AutoResell";
        stringArray[2] = "AutoSell";
        stringArray[3] = "AhHelper";
        stringArray[4] = "ItemScroller";
        stringArray[5] = "Removals";
        stringArray[6] = "ServerHelperModule";
        stringArray[7] = "AutoPotionModule";
        stringArray[8] = "ElytraHelper";
        stringArray[9] = "FreeCamera";
        stringArray[10] = "MenuSettingsModule";
        stringArray[11] = "ClientUtilModule";
        stringArray[12] = "UnHook";
        stringArray[13] = "Capes";
        stringArray[14] = "CameraClip";
        stringArray[15] = "FakePlayer";
        stringArray[16] = "ActionRecorder";
        stringArray[17] = "TapeMouse";
        stringArray[18] = "MiddleClick";
        stringArray[19] = "RotationLabModule";
        stringArray[20] = "TestModule";
        stringArray[21] = "Blink";
        stringArray[22] = "BaseFinder";
        stringArray[23] = "FriendManagerModule";
        stringArray[24] = "ServerJoiner";
        stringArray[25] = "ServerDHelper";
        stringArray[26] = "ChatHelper";
        stringArray[27] = "HitSounds";
        stringArray[28] = "TotemVoices";
        primaryVal = Set.of(stringArray);
    }
}

