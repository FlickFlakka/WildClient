/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.reflect.TypeToken
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.lwjgl.glfw.GLFW;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.UuNVnuUvunN;
import ru.metaculture.protection.VnVvnNNuVuUu;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class MacroCommand
extends ChatCommand {
    private static final List<String> secondaryVal;
    private static final List<String> tertiaryVal;
    private static final String marginVal = "\\|";
    private static final int weightVal = -100;
    private static final char paramVal = '\ufffd';
    private final Gson extraVal = new GsonBuilder().setPrettyPrinting().create();
    private final File limitVal;
    public static final List<Macro> primaryVal;

    public MacroCommand() {
        super("macro", "Macro management", ".macro add <name> <button> <text> | .macro list");
        this.limitVal = new File(ru.metaculture.protection.WildClient.primaryVal.paramVal, "macros.cfg");
        this.primaryVal(true);
    }

    @Override
    public List<String> primaryVal(String[] stringArray) {
        block6: {
            block8: {
                String string;
                block7: {
                    if (stringArray.length == 2) {
                        String string3 = stringArray[1].toLowerCase(Locale.ROOT);
                        return secondaryVal.stream().filter(string2 -> string2.startsWith(string3)).toList();
                    }
                    if (stringArray.length != 3) break block6;
                    String string4 = stringArray[1].toLowerCase(Locale.ROOT);
                    string = stringArray[2].toLowerCase(Locale.ROOT);
                    if (this.tertiaryVal(string4) || string4.equals("run")) break block7;
                    if (!string4.equals("exec")) break block8;
                }
                return this.limitVal().stream().filter(string2 -> string2.toLowerCase(Locale.ROOT).startsWith(string)).toList();
            }
            return List.of();
        }
        if (stringArray.length == 4) {
            if (this.secondaryVal(stringArray[1].toLowerCase(Locale.ROOT))) {
                String string = stringArray[3].toLowerCase(Locale.ROOT);
                return tertiaryVal.stream().filter(string2 -> string2.toLowerCase(Locale.ROOT).startsWith(string)).toList();
            }
        }
        return List.of();
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        if (stringArray.length == 0) {
            this.extraVal();
            return;
        }
        String string = stringArray[0].toLowerCase(Locale.ROOT);
        if (this.secondaryVal(string)) {
            this.tertiaryVal(stringArray);
            return;
        }
        if (this.tertiaryVal(string)) {
            this.marginVal(stringArray);
            return;
        }
        switch (string) {
            case "run": 
            case "exec": {
                this.weightVal(stringArray);
                break;
            }
            case "list": 
            case "ls": {
                this.marginVal();
                break;
            }
            case "clear": {
                this.weightVal();
                break;
            }
            case "save": {
                this.paramVal();
                ChatLogger.primaryVal("§aMacros saved: §f" + primaryVal.size());
                break;
            }
            case "load": 
            case "reload": {
                this.primaryVal(false);
                break;
            }
            case "help": 
            case "?": {
                this.extraVal();
                break;
            }
            default: {
                ChatLogger.primaryVal("§cUnknown subcommand: §f" + stringArray[0]);
                this.extraVal();
            }
        }
    }

    @Subscribe
    public void primaryVal(MouseButtonEvent spanD) {
        if (spanD.paramVal() != 1) {
            return;
        }
        this.primaryVal(spanD.marginVal());
    }

    @Compile
    private void primaryVal(int n) {
        if (primaryVal.isEmpty() || !this.secondaryVal(n)) {
            return;
        }
        if (MacroCommand.a_.field_1724 == null || MacroCommand.a_.field_1724.field_3944 == null || MacroCommand.a_.field_1755 != null) {
            return;
        }
        for (Macro modeVal : primaryVal) {
            if (modeVal == null || modeVal.tertiaryVal != n) continue;
            this.primaryVal(modeVal);
        }
    }

    @Compile
    private void primaryVal(Macro modeVal) {
        if (modeVal == null || modeVal.secondaryVal == null) {
            return;
        }
        if (MacroCommand.a_.field_1724 == null || MacroCommand.a_.field_1724.field_3944 == null) {
            return;
        }
        if (ru.metaculture.protection.WildClient.primaryVal == null || ru.metaculture.protection.WildClient.primaryVal.paramRef() == null) {
            return;
        }
        for (String string : modeVal.secondaryVal.split(marginVal)) {
            String string2 = string.trim();
            if (string2.isEmpty()) continue;
            if (string2.startsWith("/")) {
                String string3 = string2.substring(1).trim();
                if (string3.isEmpty()) continue;
                MacroCommand.a_.field_1724.field_3944.method_45730(string3);
                continue;
            }
            if (!string2.isEmpty() && string2.startsWith(".")) {
                if (ru.metaculture.protection.WildClient.primaryVal == null || ru.metaculture.protection.WildClient.primaryVal.phaseVal() == null) continue;
                ru.metaculture.protection.WildClient.primaryVal.phaseVal().primaryVal(string2);
                continue;
            }
            MacroCommand.a_.field_1724.field_3944.method_45729(string2);
        }
    }

    @Compile
    private void tertiaryVal(String[] stringArray) {
        boolean bl;
        int n;
        int n2;
        if (stringArray.length < 4) {
            ChatLogger.primaryVal("§cUsage: §f.macro add <name> <button> <text>");
            ChatLogger.primaryVal("§7Example: §f.macro add spawn G /spawn");
            return;
        }
        String string = stringArray[1];
        Integer n3 = this.marginVal(stringArray[2]);
        if (n3 != null) {
            n2 = 3;
            n = stringArray.length;
        } else {
            n3 = this.marginVal(stringArray[stringArray.length - 1]);
            if (n3 == null) {
                ChatLogger.primaryVal("§cUnknown button: §f" + stringArray[2] + " §7(and §f" + stringArray[stringArray.length - 1] + "\u00a77)");
                ChatLogger.primaryVal("§7Format: §f.macro add <name> <button> <text>");
                return;
            }
            n2 = 2;
            n = stringArray.length - 1;
        }
        String string2 = this.primaryVal(stringArray, n2, n);
        if (string2.isEmpty()) {
            ChatLogger.primaryVal("§cEmpty macro text.");
            return;
        }
        Macro modeVal = this.primaryVal(string);
        boolean bl2 = bl = modeVal != null;
        if (bl) {
            primaryVal.remove(modeVal);
        }
        Macro nodeC = new Macro(string, n3, string2);
        primaryVal.add(nodeC);
        this.paramVal();
        String string3 = VnVvnNNuVuUu.primaryVal().primaryVal(n3);
        if (bl) {
            ChatLogger.primaryVal("§eMacro §f" + string + " §eoverwritten: §b" + string2 + " \u00a78[\u00a7e" + string3 + "\u00a78]");
        } else {
            ChatLogger.primaryVal("§aMacro §f" + string + " §aon §e" + string3 + "\u00a7a: \u00a7b" + string2);
        }
        long l = 0L;
        for (Macro partE : primaryVal) {
            if (partE.tertiaryVal != nodeC.tertiaryVal) continue;
            ++l;
        }
        if (l > 1L) {
            ChatLogger.primaryVal("§7This button already has §f" + l + " §7macros, all will trigger.");
        }
    }

    @Compile
    private void marginVal(String[] stringArray) {
        if (stringArray.length < 2) {
            ChatLogger.primaryVal("§cUsage: §f.macro remove <name>");
            return;
        }
        Macro modeVal = this.primaryVal(stringArray[1]);
        if (modeVal == null) {
            ChatLogger.primaryVal("§cMacro not found: §f" + stringArray[1]);
            return;
        }
        primaryVal.remove(modeVal);
        this.paramVal();
        ChatLogger.primaryVal("§aMacro §f" + modeVal.primaryVal + " §adeleted.");
    }

    @Compile
    private void weightVal(String[] stringArray) {
        if (stringArray.length < 2) {
            ChatLogger.primaryVal("§cUsage: §f.macro run <name>");
            return;
        }
        Macro modeVal = this.primaryVal(stringArray[1]);
        if (modeVal == null) {
            ChatLogger.primaryVal("§cMacro not found: §f" + stringArray[1]);
            return;
        }
        if (MacroCommand.a_.field_1724 == null || MacroCommand.a_.field_1724.field_3944 == null) {
            ChatLogger.primaryVal("§cYou need to be on the server.");
            return;
        }
        this.primaryVal(modeVal);
    }

    @Compile
    private void marginVal() {
        if (primaryVal.isEmpty()) {
            ChatLogger.primaryVal("§7Macro list is empty. §f.macro add <name> <button> <text>");
            return;
        }
        ChatLogger.primaryVal("§fMacros (§7" + primaryVal.size() + "\u00a7f):");
        for (Macro modeVal : primaryVal) {
            String string = VnVvnNNuVuUu.primaryVal().primaryVal(modeVal.tertiaryVal);
            ChatLogger.primaryVal("\u00a77- \u00a7f" + modeVal.primaryVal + " \u00a78[\u00a7e" + string + "\u00a78] \u00a77\u00bb \u00a7b" + modeVal.secondaryVal);
        }
    }

    @Compile
    private void weightVal() {
        int n = primaryVal.size();
        primaryVal.clear();
        this.paramVal();
        ChatLogger.primaryVal("§cMacros deleted: §f" + n);
    }

    @Compile
    public void primaryVal(boolean bl) {
        if (!this.limitVal.exists()) {
            if (!bl) {
                ChatLogger.primaryVal("§7Macro file not found, list is empty.");
            }
            return;
        }
        try {
            List<Macro> list = this.primaryVal(StandardCharsets.UTF_8);
            if (list == null) {
                list = this.primaryVal(Charset.defaultCharset());
            }
            if (list == null) {
                return;
            }
            ArrayList<Macro> arrayList = new ArrayList<Macro>();
            for (Macro modeVal : list) {
                if (modeVal == null || modeVal.primaryVal == null || modeVal.primaryVal.isBlank() || modeVal.secondaryVal == null || modeVal.secondaryVal.isBlank() || !this.secondaryVal(modeVal.tertiaryVal)) continue;
                arrayList.add(modeVal);
            }
            primaryVal.clear();
            primaryVal.addAll(arrayList);
            if (!bl) {
                ChatLogger.primaryVal("§aMacros loaded: §f" + primaryVal.size());
            }
        }
        catch (Exception exception) {
            ChatLogger.primaryVal("§cFailed to read macros.cfg.");
        }
    }

    @Compile
    private List<Macro> primaryVal(Charset charset) throws IOException {
        byte[] byArray = Files.readAllBytes(this.limitVal.toPath());
        String string = new String(byArray, charset);
        if (StandardCharsets.UTF_8.equals(charset) && string.indexOf(65533) >= 0) {
            return null;
        }
        Type type = new TypeToken<List<Macro>>(){}.getType();
        return (List)this.extraVal.fromJson(string, type);
    }

    @Compile
    private void paramVal() {
        try {
            File file = this.limitVal.getParentFile();
            if (file != null && !file.exists()) {
                file.mkdirs();
            }
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)new FileOutputStream(this.limitVal), StandardCharsets.UTF_8);){
                this.extraVal.toJson(new ArrayList<Macro>(primaryVal), (Appendable)outputStreamWriter);
            }
        }
        catch (Exception exception) {
            ChatLogger.primaryVal("§cFailed to save macros: §f" + exception.getMessage());
        }
    }

    private void extraVal() {
        ChatLogger.primaryVal("§f.macro add <name> <button> <text> §7- create or overwrite");
        ChatLogger.primaryVal("§f.macro remove <name> §7| §f.macro list §7| §f.macro run <name> §7| §f.macro clear §7| §f.macro load");
        ChatLogger.primaryVal("§7Text starting with §f/ §7is sent as a command to the server, with §f" + (ru.metaculture.protection.WildClient.primaryVal == null ? "." : ru.metaculture.protection.WildClient.primaryVal.paramRef()) + " §7- as a client command.");
        ChatLogger.primaryVal("§7Multiple actions: §f.macro add kit G /kit tools | /home base");
    }

    private Macro primaryVal(String string) {
        if (string == null) {
            return null;
        }
        for (Macro modeVal : primaryVal) {
            if (modeVal == null || modeVal.primaryVal == null || !modeVal.primaryVal.equalsIgnoreCase(string)) continue;
            return modeVal;
        }
        return null;
    }

    private List<String> limitVal() {
        return primaryVal.stream().filter(modeVal -> modeVal != null && modeVal.primaryVal != null).map(modeVal -> modeVal.primaryVal).toList();
    }

    private String primaryVal(String[] stringArray, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < n2; ++i) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(stringArray[i]);
        }
        return stringBuilder.toString().trim();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean secondaryVal(String string) {
        if (string.equals("add")) return true;
        if (string.equals("set")) return true;
        if (!string.equals("create")) return false;
        return true;
    }

    private boolean tertiaryVal(String string) {
        return string.equals("remove") || string.equals("del") || string.equals("delete") || string.equals("rem");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean secondaryVal(int n) {
        if (n > 0) return true;
        if (n > -100) return false;
        return true;
    }

    private Integer marginVal(String string) {
        int n;
        String string2;
        block15: {
            block14: {
                if (string == null || string.isBlank()) {
                    return null;
                }
                string2 = string.trim().toUpperCase(Locale.ROOT).replace('-', '_').replace(' ', '_');
                if (string2.startsWith("GLFW_KEY_")) {
                    string2 = string2.substring("GLFW_KEY_".length());
                } else if (string2.startsWith("KEY_")) {
                    string2 = string2.substring("KEY_".length());
                }
                if (string2.equals("LMB")) break block14;
                if (!string2.equals("MOUSELEFT") && !string2.equals("MOUSE_LEFT")) break block15;
            }
            return -100;
        }
        if (string2.equals("RMB") || string2.equals("MOUSERIGHT") || string2.equals("MOUSE_RIGHT")) {
            return -101;
        }
        if (string2.equals("MMB") || string2.equals("MOUSEMIDDLE") || string2.equals("MOUSE_MIDDLE")) {
            return -102;
        }
        if (string2.matches("MOUSE_?\\d+") && (n = Integer.parseInt(string2.replace("MOUSE", "").replace("_", ""))) >= 1 && n <= 16) {
            return -100 - (n - 1);
        }
        n = UuNVnuUvunN.primaryVal(string2.replace("_", ""));
        if (n != -1) {
            return n;
        }
        n = UuNVnuUvunN.primaryVal(string2);
        if (n != -1) {
            return n;
        }
        try {
            Field field = GLFW.class.getField("GLFW_KEY_" + string2);
            int n2 = field.getInt(null);
            return n2 > 0 ? Integer.valueOf(n2) : null;
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            return null;
        }
    }

    private static /* synthetic */ boolean primaryVal(Macro modeVal, Macro nodeC) {
        return nodeC.tertiaryVal == modeVal.tertiaryVal;
    }

    static {
        Loader.initialize();
        secondaryVal = List.of("add", "remove", "list", "run", "clear", "save", "load");
        String[] stringArray = new String[70];
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
        stringArray[51] = "INSERT";
        stringArray[52] = "DELETE";
        stringArray[53] = "HOME";
        stringArray[54] = "END";
        stringArray[55] = "PAGEUP";
        stringArray[56] = "PAGEDOWN";
        stringArray[57] = "LEFT";
        stringArray[58] = "RIGHT";
        stringArray[59] = "UP";
        stringArray[60] = "DOWN";
        stringArray[61] = "LSHIFT";
        stringArray[62] = "RSHIFT";
        stringArray[63] = "LCONTROL";
        stringArray[64] = "RCONTROL";
        stringArray[65] = "LALT";
        stringArray[66] = "RALT";
        stringArray[67] = "MOUSE3";
        stringArray[68] = "MOUSE4";
        stringArray[69] = "MOUSE5";
        tertiaryVal = List.of(stringArray);
        primaryVal = new CopyOnWriteArrayList<Macro>();
    }

    public static class Macro {
        public String primaryVal;
        public String secondaryVal;
        public int tertiaryVal;

        public Macro(String string, int n, String string2) {
            this.primaryVal = string;
            this.tertiaryVal = n;
            this.secondaryVal = string2;
        }
    }
}

