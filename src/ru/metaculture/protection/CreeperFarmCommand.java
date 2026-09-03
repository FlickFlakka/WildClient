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
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.CreeperFarmModule;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class CreeperFarmCommand
extends ChatCommand {
    private final Gson primaryVal = new GsonBuilder().setPrettyPrinting().create();
    private final File secondaryVal;

    public CreeperFarmCommand() {
        super("cf", "Manage creeper farm boundaries", ".cf <pos1/pos2/clear/info>");
        this.secondaryVal = new File(ru.metaculture.protection.WildClient.primaryVal.paramVal, "creeperfarm.cfg");
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
            case "info": {
                this.extraVal();
                break;
            }
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
            default: {
                ChatLogger.primaryVal("§cUnknown subcommand.");
            }
        }
    }

    @Compile
    private void marginVal() {
        if (CreeperFarmCommand.a_.field_1724 == null) {
            ChatLogger.primaryVal("§cYou must be in-game!");
            return;
        }
        class_2338 class_23382 = CreeperFarmCommand.a_.field_1724.method_24515();
        CreeperFarmModule.primaryVal(class_23382);
        this.speedVal();
        ChatLogger.primaryVal("§aPosition 1 set: §f" + this.primaryVal(class_23382));
    }

    @Compile
    private void weightVal() {
        if (CreeperFarmCommand.a_.field_1724 == null) {
            ChatLogger.primaryVal("§cYou must be in-game!");
            return;
        }
        class_2338 class_23382 = CreeperFarmCommand.a_.field_1724.method_24515();
        CreeperFarmModule.secondaryVal(class_23382);
        this.speedVal();
        ChatLogger.primaryVal("§aPosition 2 set: §f" + this.primaryVal(class_23382));
    }

    @Compile
    private void paramVal() {
        CreeperFarmModule.blockRef();
        this.speedVal();
        ChatLogger.primaryVal("§cCreeper farm coordinates cleared.");
    }

    @Compile
    private void extraVal() {
        class_2338 class_23382 = CreeperFarmModule.holderVal();
        class_2338 class_23383 = CreeperFarmModule.timerVal();
        if (class_23382 == null) {
            if (class_23383 == null) {
                ChatLogger.primaryVal("§7Farm coordinates are not set.");
                return;
            }
            ChatLogger.primaryVal("§fCreeper farm information:");
            ChatLogger.primaryVal(" §7Position 1: §cnot set");
            ChatLogger.primaryVal(" §7Position 2: §f" + this.primaryVal(class_23383));
            return;
        }
        ChatLogger.primaryVal("§fCreeper farm information:");
        ChatLogger.primaryVal(" §7Position 1: §f" + this.primaryVal(class_23382));
        if (class_23383 == null) {
            ChatLogger.primaryVal(" §7Position 2: §cnot set");
            return;
        }
        ChatLogger.primaryVal(" §7Position 2: §f" + this.primaryVal(class_23383));
        int n = Math.abs(class_23383.method_10263() - class_23382.method_10263()) + 1;
        int n2 = Math.abs(class_23383.method_10264() - class_23382.method_10264()) + 1;
        int n3 = Math.abs(class_23383.method_10260() - class_23382.method_10260()) + 1;
        ChatLogger.primaryVal(" §7Area size: §f" + n + "x" + n2 + "x" + n3);
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
            FarmConfig modeVal = (FarmConfig)this.primaryVal.fromJson((Reader)fileReader, FarmConfig.class);
            if (modeVal != null) {
                if (modeVal.primaryVal != null) {
                    CreeperFarmModule.primaryVal(new class_2338(modeVal.primaryVal.primaryVal, modeVal.primaryVal.secondaryVal, modeVal.primaryVal.tertiaryVal));
                }
                if (modeVal.secondaryVal != null) {
                    CreeperFarmModule.secondaryVal(new class_2338(modeVal.secondaryVal.primaryVal, modeVal.secondaryVal.secondaryVal, modeVal.secondaryVal.tertiaryVal));
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
            FarmConfig modeVal = new FarmConfig();
            class_2338 class_23382 = CreeperFarmModule.holderVal();
            class_2338 class_23383 = CreeperFarmModule.timerVal();
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

    static class FarmConfig {
        cursorVal primaryVal;
        cursorVal secondaryVal;

        FarmConfig() {
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

