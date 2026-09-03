/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.lwjgl.glfw.GLFW;
import org.wild.module.api.Module;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.UuNVnuUvunN;
import ru.metaculture.protection.VnVvnNNuVuUu;
import ru.metaculture.protection.ModuleManager;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.KeybindMode;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class VvuuvuNVvvU
extends ChatCommand {
    private static final List<String> primaryVal;
    private static final List<String> secondaryVal;

    public VvuuvuNVvvU() {
        super("bind", "Module keybind management", ".bind <module> <key> | .bind list | .bind del <module> | .bind clear");
    }

    @Override
    public List<String> primaryVal(String[] stringArray) {
        if (stringArray.length == 2) {
            String string = stringArray[1].toLowerCase(Locale.ROOT);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            primaryVal.stream().filter(string2 -> string2.startsWith(string)).forEach(linkedHashSet::add);
            Stream<String> stream = this.paramVal().stream().filter(string2 -> string2.toLowerCase(Locale.ROOT).startsWith(string));
            LinkedHashSet linkedHashSet2 = linkedHashSet;
            Objects.requireNonNull(linkedHashSet2);
            stream.forEach(linkedHashSet2::add);
            return new ArrayList<String>(linkedHashSet);
        }
        if (stringArray.length == 3) {
            String string = stringArray[1].toLowerCase(Locale.ROOT);
            String string3 = stringArray[2].toLowerCase(Locale.ROOT);
            if (this.marginVal(string)) {
                return this.paramVal().stream().filter(string2 -> string2.toLowerCase(Locale.ROOT).startsWith(string3)).toList();
            }
            if (!primaryVal.contains(string)) {
                return secondaryVal.stream().filter(string2 -> string2.toLowerCase(Locale.ROOT).startsWith(string3)).toList();
            }
        }
        return List.of();
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        ModuleManager uVvnVvvUVUv2 = WildClient.primaryVal.secondaryVal;
        if (uVvnVvvUVUv2 == null) {
            ChatLogger.primaryVal("§cModule manager is not initialized.");
            return;
        }
        if (stringArray.length == 0) {
            ChatLogger.primaryVal("§cUsage: " + this.primaryVal());
            return;
        }
        switch (stringArray[0].toLowerCase(Locale.ROOT)) {
            case "list": {
                this.weightVal();
                break;
            }
            case "clear": {
                this.marginVal();
                break;
            }
            case "del": 
            case "delete": 
            case "remove": 
            case "unbind": {
                this.marginVal(stringArray);
                break;
            }
            default: {
                this.tertiaryVal(stringArray);
            }
        }
    }

    @Compile
    private void tertiaryVal(String[] stringArray) {
        if (stringArray.length < 2) {
            ChatLogger.primaryVal("§cUsage: .bind <module> <key>");
            return;
        }
        Module module = this.primaryVal(stringArray[0]);
        if (module == null) {
            this.secondaryVal(stringArray[0]);
            return;
        }
        Integer n = this.tertiaryVal(stringArray[1]);
        if (n == null) {
            ChatLogger.primaryVal("§cUnknown key: §f" + stringArray[1]);
            return;
        }
        VnVvnNNuVuUu sackE = VnVvnNNuVuUu.primaryVal();
        int n2 = n;
        KeybindMode vvVUVuVvnnVN2 = KeybindMode.TOGGLE;
        if (sackE != null) {
            sackE.primaryVal(module, n2, vvVUVuVvnnVN2);
        }
        this.extraVal();
        ChatLogger.primaryVal("§aKeybind set: §f" + module.name + " \u00a77-> \u00a7f" + this.primaryVal(n));
    }

    @Compile
    private void marginVal(String[] stringArray) {
        if (stringArray.length < 2) {
            ChatLogger.primaryVal("§cUsage: .bind del <module>");
            return;
        }
        Module module = this.primaryVal(stringArray[1]);
        if (module == null) {
            this.secondaryVal(stringArray[1]);
            return;
        }
        VnVvnNNuVuUu sackE = VnVvnNNuVuUu.primaryVal();
        KeybindMode vvVUVuVvnnVN2 = KeybindMode.TOGGLE;
        sackE.primaryVal(module, -1, vvVUVuVvnnVN2);
        this.extraVal();
        ChatLogger.primaryVal("§aKeybind removed: §f" + module.name);
    }

    @Compile
    private void marginVal() {
        Iterator<Module> iterator;
        ArrayList<Module> arrayList;
        int n = 0;
        ModuleManager uVvnVvvUVUv2 = WildClient.primaryVal.secondaryVal;
        if (uVvnVvvUVUv2 != null && (arrayList = uVvnVvvUVUv2.secondaryVal()) != null && (iterator = arrayList.iterator()) != null) {
            while (iterator.hasNext()) {
                Module module = iterator.next();
                if (module.keyIndex == -1) continue;
                module.keyIndex = -1;
                ++n;
            }
        }
        this.extraVal();
        ChatLogger.primaryVal("§aModule keybinds cleared: §f" + n);
    }

    @Compile
    private void weightVal() {
        List<Module> list;
        ModuleManager uVvnVvvUVUv2 = WildClient.primaryVal.secondaryVal;
        ArrayList<Module> arrayList = uVvnVvvUVUv2 == null ? null : uVvnVvvUVUv2.secondaryVal();
        Stream stream = arrayList == null ? null : arrayList.stream();
        Predicate<Module> predicate = module -> module.keyIndex != -1;
        Stream<Module> stream2 = stream == null ? null : stream.filter(predicate);
        Function<Module, String> function = module -> module.name.toLowerCase(Locale.ROOT);
        Comparator<Module> comparator = Comparator.comparing(function);
        Stream<Module> stream3 = stream2 == null ? null : stream2.sorted(comparator);
        List<Module> list2 = list = stream3 == null ? null : stream3.toList();
        if (list != null && list.isEmpty()) {
            ChatLogger.primaryVal("§7No module keybinds.");
            return;
        }
        int n = list == null ? 0 : list.size();
        ChatLogger.primaryVal("§fModule keybinds (§7" + n + "\u00a7f):");
        if (list == null) {
            return;
        }
        for (Module module2 : list) {
            String string = module2.name;
            int n2 = module2.keyIndex;
            String string2 = this.primaryVal(n2);
            ChatLogger.primaryVal("\u00a77- \u00a7f" + string + " \u00a78[\u00a7e" + string2 + "\u00a78]");
        }
    }

    private Module primaryVal(String string) {
        String string2 = this.weightVal(string);
        ArrayList<Module> arrayList = new ArrayList<Module>();
        Iterator<Module> iterator = WildClient.primaryVal.secondaryVal.secondaryVal().iterator();
        while (iterator.hasNext()) {
            Module module = iterator.next();
            if (string2.equals(this.weightVal(module.name)) || string2.equals(this.weightVal(module.getDisplayName())) || string2.equals(this.weightVal(module.getClass().getSimpleName()))) {
                return module;
            }
            if (!this.weightVal(module.name).contains(string2) && !this.weightVal(module.getDisplayName()).contains(string2) && !this.weightVal(module.getClass().getSimpleName()).contains(string2)) continue;
            arrayList.add(module);
        }
        return arrayList.size() == 1 ? (Module)arrayList.get(0) : null;
    }

    private void secondaryVal(String string) {
        List<String> list = this.paramVal().stream().filter(string2 -> this.weightVal((String)string2).contains(this.weightVal(string))).limit(8L).toList();
        if (list.isEmpty()) {
            ChatLogger.primaryVal("§cModule not found: §f" + string);
        } else {
            ChatLogger.primaryVal("§cAmbiguous module: §f" + string + " \u00a77(" + String.join((CharSequence)", ", list) + ")");
        }
    }

    private List<String> paramVal() {
        if (WildClient.primaryVal.secondaryVal == null) {
            return List.of();
        }
        return WildClient.primaryVal.secondaryVal.secondaryVal().stream().map(module -> module.name).sorted(String.CASE_INSENSITIVE_ORDER).toList();
    }

    private Integer tertiaryVal(String string) {
        int n;
        String string2;
        block15: {
            block14: {
                string2 = string.trim().toUpperCase(Locale.ROOT).replace("-", "_").replace(" ", "_");
                if (string2.equals("NONE")) break block14;
                if (!string2.equals("NULL") && !string2.equals("UNBOUND") && !string2.equals("CLEAR")) break block15;
            }
            return -1;
        }
        if (string2.equals("WHEELUP") || string2.equals("WHEEL_UP") || string2.equals("MWHEELUP")) {
            return -200;
        }
        if (string2.equals("WHEELDOWN") || string2.equals("WHEEL_DOWN") || string2.equals("MWHEELDOWN")) {
            return -201;
        }
        if (string2.equals("LMB") || string2.equals("MOUSELEFT") || string2.equals("MOUSE_LEFT")) {
            return -100;
        }
        if (string2.equals("RMB") || string2.equals("MOUSERIGHT") || string2.equals("MOUSE_RIGHT")) {
            return -101;
        }
        if (string2.equals("MMB") || string2.equals("MOUSEMIDDLE") || string2.equals("MOUSE_MIDDLE")) {
            return -102;
        }
        if (string2.matches("MOUSE_?\\d+")) {
            n = Integer.parseInt(string2.replace("MOUSE", "").replace("_", ""));
            if (n >= 1 && n <= 16) {
                return -100 - (n - 1);
            }
        }
        if ((n = UuNVnuUvunN.primaryVal(string2.replace("_", ""))) != -1) {
            return n;
        }
        n = UuNVnuUvunN.primaryVal(string2);
        if (n != -1) {
            return n;
        }
        try {
            Field field = GLFW.class.getField("GLFW_KEY_" + string2);
            return field.getInt(null);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            return null;
        }
    }

    private String primaryVal(int n) {
        return VnVvnNNuVuUu.primaryVal().primaryVal(n);
    }

    private boolean marginVal(String string) {
        return string.equals("del") || string.equals("delete") || string.equals("remove") || string.equals("unbind");
    }

    private String weightVal(String string) {
        return string == null ? "" : string.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9\u0430-\u044f\u0451]", "");
    }

    private void extraVal() {
        if (WildClient.primaryVal.holderVal != null) {
            WildClient.primaryVal.holderVal.tertiaryVal();
        }
    }

    static {
        Loader.initialize();
        primaryVal = List.of("list", "clear", "del", "delete", "remove", "unbind");
        String[] stringArray = new String[77];
        stringArray[0] = "A";
        stringArray[1] = "B";
        stringArray[2] = "C";
        stringArray[3] = "D";
        stringArray[4] = "E";
        stringArray[5] = "F";
        stringArray[6] = "G";
        stringArray[7] = "H";
        stringArray[8] = "I";
        stringArray[9] = "J";
        stringArray[10] = "K";
        stringArray[11] = "L";
        stringArray[12] = "M";
        stringArray[13] = "N";
        stringArray[14] = "O";
        stringArray[15] = "P";
        stringArray[16] = "Q";
        stringArray[17] = "R";
        stringArray[18] = "S";
        stringArray[19] = "T";
        stringArray[20] = "U";
        stringArray[21] = "V";
        stringArray[22] = "W";
        stringArray[23] = "X";
        stringArray[24] = "Y";
        stringArray[25] = "Z";
        stringArray[26] = "0";
        stringArray[27] = "1";
        stringArray[28] = "2";
        stringArray[29] = "3";
        stringArray[30] = "4";
        stringArray[31] = "5";
        stringArray[32] = "6";
        stringArray[33] = "7";
        stringArray[34] = "8";
        stringArray[35] = "9";
        stringArray[36] = "F1";
        stringArray[37] = "F2";
        stringArray[38] = "F3";
        stringArray[39] = "F4";
        stringArray[40] = "F5";
        stringArray[41] = "F6";
        stringArray[42] = "F7";
        stringArray[43] = "F8";
        stringArray[44] = "F9";
        stringArray[45] = "F10";
        stringArray[46] = "F11";
        stringArray[47] = "F12";
        stringArray[48] = "SPACE";
        stringArray[49] = "ENTER";
        stringArray[50] = "TAB";
        stringArray[51] = "ESCAPE";
        stringArray[52] = "BACKSPACE";
        stringArray[53] = "DELETE";
        stringArray[54] = "INSERT";
        stringArray[55] = "HOME";
        stringArray[56] = "END";
        stringArray[57] = "PAGEUP";
        stringArray[58] = "PAGEDOWN";
        stringArray[59] = "LEFT";
        stringArray[60] = "RIGHT";
        stringArray[61] = "UP";
        stringArray[62] = "DOWN";
        stringArray[63] = "LSHIFT";
        stringArray[64] = "RSHIFT";
        stringArray[65] = "LCONTROL";
        stringArray[66] = "RCONTROL";
        stringArray[67] = "LALT";
        stringArray[68] = "RALT";
        stringArray[69] = "MOUSE1";
        stringArray[70] = "MOUSE2";
        stringArray[71] = "MOUSE3";
        stringArray[72] = "MOUSE4";
        stringArray[73] = "MOUSE5";
        stringArray[74] = "WHEEL_UP";
        stringArray[75] = "WHEEL_DOWN";
        stringArray[76] = "NONE";
        secondaryVal = List.of(stringArray);
    }
}

