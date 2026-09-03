/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  net.minecraft.class_2338
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.List;
import net.minecraft.class_2338;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.ChorusFarmModule;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class ChorusFarmCommand
extends ChatCommand {
    private final Gson primaryVal = new GsonBuilder().setPrettyPrinting().create();
    private final File secondaryVal;

    public ChorusFarmCommand() {
        super("chorus", "Manage chorus farm area", ".chorus <pos1/pos2/clear/info>");
        this.secondaryVal = new File(ru.metaculture.protection.WildClient.primaryVal.paramVal, "chorusfarm.cfg");
        this.primaryVal("pos1", List::of);
        this.primaryVal("pos2", List::of);
        this.primaryVal("clear", List::of);
        this.primaryVal("info", List::of);
        this.limitVal();
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        if (stringArray.length == 0) {
            ChatLogger.primaryVal("§cUsage: " + this.tertiaryVal());
            return;
        }
        switch (stringArray[0].toLowerCase()) {
            case "pos1": {
                this.marginVal();
                break;
            }
            case "pos2": {
                this.weightVal();
                break;
            }
            case "clear": {
                this.paramVal();
                break;
            }
            case "info": {
                this.extraVal();
                break;
            }
            default: {
                ChatLogger.primaryVal("§cUnknown subcommand.");
            }
        }
    }

    @Compile
    private void marginVal() {
        if (ChorusFarmCommand.a_.field_1724 == null) {
            ChatLogger.primaryVal("§cYou must be in-game!");
            return;
        }
        class_2338 class_23382 = ChorusFarmCommand.a_.field_1724.method_24515();
        ChorusFarmModule.primaryVal(class_23382);
        this.speedVal();
        ChatLogger.primaryVal("§dPosition 1 set: §f" + this.primaryVal(class_23382));
    }

    @Compile
    private void weightVal() {
        if (ChorusFarmCommand.a_.field_1724 == null) {
            ChatLogger.primaryVal("§cYou must be in-game!");
            return;
        }
        class_2338 class_23382 = ChorusFarmCommand.a_.field_1724.method_24515();
        ChorusFarmModule.secondaryVal(class_23382);
        this.speedVal();
        ChatLogger.primaryVal("§dPosition 2 set: §f" + this.primaryVal(class_23382));
    }

    @Compile
    private void paramVal() {
        ChorusFarmModule.blockRef();
        this.speedVal();
        ChatLogger.primaryVal("§cChorus farm area cleared.");
    }

    @Compile
    private void extraVal() {
        class_2338 class_23382 = ChorusFarmModule.holderVal();
        class_2338 class_23383 = ChorusFarmModule.timerVal();
        if (class_23382 == null) {
            if (class_23383 == null) {
                ChatLogger.primaryVal("§7Farm area not set.");
                return;
            }
            ChatLogger.primaryVal("§fChorus farm information:");
            ChatLogger.primaryVal(" §7Position 1: §cnot set");
            ChatLogger.primaryVal(" §7Position 2: §f" + this.primaryVal(class_23383));
            return;
        }
        ChatLogger.primaryVal("§fChorus farm information:");
        ChatLogger.primaryVal(" §7Position 1: §f" + this.primaryVal(class_23382));
        if (class_23383 == null) {
            ChatLogger.primaryVal(" §7Position 2: §cnot set");
            return;
        }
        ChatLogger.primaryVal(" §7Position 2: §f" + this.primaryVal(class_23383));
        ChatLogger.primaryVal(" §7Area (excluding Y): §f" + (Math.abs(class_23382.method_10263() - class_23383.method_10263()) + 1) + "x" + (Math.abs(class_23382.method_10260() - class_23383.method_10260()) + 1));
    }

    @Compile
    private String primaryVal(class_2338 class_23382) {
        return class_23382.method_10263() + ", " + class_23382.method_10264() + ", " + class_23382.method_10260();
    }

    @Compile
    private void limitVal() {
        if (!this.secondaryVal.exists()) {
            return;
        }
        try (FileReader fileReader = new FileReader(this.secondaryVal);){
            ChorusFarmConfig modeVal = (ChorusFarmConfig)this.primaryVal.fromJson((Reader)fileReader, ChorusFarmConfig.class);
            if (modeVal != null) {
                if (modeVal.primaryVal != null) {
                    ChorusFarmModule.primaryVal(new class_2338(modeVal.primaryVal.primaryVal, modeVal.primaryVal.secondaryVal, modeVal.primaryVal.tertiaryVal));
                }
                if (modeVal.secondaryVal != null) {
                    ChorusFarmModule.secondaryVal(new class_2338(modeVal.secondaryVal.primaryVal, modeVal.secondaryVal.secondaryVal, modeVal.secondaryVal.tertiaryVal));
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Compile
    private void speedVal() {
        try {
            if (!this.secondaryVal.getParentFile().exists()) {
                this.secondaryVal.getParentFile().mkdirs();
            }
            ChorusFarmConfig modeVal = new ChorusFarmConfig();
            class_2338 class_23382 = ChorusFarmModule.holderVal();
            class_2338 class_23383 = ChorusFarmModule.timerVal();
            if (class_23382 != null) {
                modeVal.primaryVal = new cursorVal(class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260());
            }
            if (class_23383 != null) {
                modeVal.secondaryVal = new cursorVal(class_23383.method_10263(), class_23383.method_10264(), class_23383.method_10260());
            }
            try (FileWriter fileWriter = new FileWriter(this.secondaryVal);){
                this.primaryVal.toJson((Object)modeVal, (Appendable)fileWriter);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static {
        Loader.initialize();
    }

    static class ChorusFarmConfig {
        cursorVal primaryVal;
        cursorVal secondaryVal;

        ChorusFarmConfig() {
        }
    }

    static class cursorVal {
        int primaryVal;
        int secondaryVal;
        int tertiaryVal;

        cursorVal(int n, int n2, int n3) {
            this.primaryVal = n;
            this.secondaryVal = n2;
            this.tertiaryVal = n3;
        }
    }
}

