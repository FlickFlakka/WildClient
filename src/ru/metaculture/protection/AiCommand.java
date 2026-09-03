/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 */
package ru.metaculture.protection;

import java.util.List;
import java.util.Locale;
import net.minecraft.class_310;
import net.minecraft.class_437;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.AimLabScreen;
import ru.metaculture.protection.VuUvvnuUu;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.BlockBreakEvent;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public final class AiCommand
extends ChatCommand {
    public AiCommand() {
        super("ai", "Recording, training, and playback of AI rotation", ".ai <train|learn|run|stop|log|lab|profile|list>");
        this.primaryVal("train", List::of);
        this.primaryVal("learn", List::of);
        this.primaryVal("stop", List::of);
        this.primaryVal("run", List::of);
        this.primaryVal("log", List::of);
        this.primaryVal("lab", List::of);
        this.primaryVal("profile", List::of);
        this.primaryVal("list", List::of);
    }

    public static void marginVal() {
    }

    @Override
    public List<String> primaryVal(String[] stringArray) {
        block4: {
            block5: {
                if (stringArray.length == 2) {
                    String string = stringArray[1].toLowerCase(Locale.ROOT);
                    return List.of("train", "learn", "run", "stop", "log", "lab", "profile", "list").stream().filter(string2 -> string2.startsWith(string)).toList();
                }
                if (stringArray.length != 3) break block4;
                String string = stringArray[1].toLowerCase(Locale.ROOT);
                if (string.equals("profile")) break block5;
                if (string.equals("run") || string.equals("train")) break block5;
                if (!string.equals("learn")) break block4;
            }
            String string = stringArray[2].toLowerCase(Locale.ROOT);
            return VuUvvnuUu.stageVal().stream().filter(string2 -> string2.toLowerCase(Locale.ROOT).startsWith(string)).toList();
        }
        return List.of();
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        Object object;
        if (stringArray.length == 0) {
            ChatLogger.primaryVal("Usage: " + this.tertiaryVal());
            return;
        }
        switch (stringArray[0].toLowerCase(Locale.ROOT)) {
            case "train": {
                if (stringArray.length >= 2) {
                    VuUvvnuUu.secondaryVal(stringArray[1]);
                }
                object = VuUvvnuUu.primaryVal();
                break;
            }
            case "learn": {
                if (stringArray.length >= 2) {
                    VuUvvnuUu.secondaryVal(stringArray[1]);
                }
                object = VuUvvnuUu.marginVal();
                break;
            }
            case "log": {
                boolean bl = !AttackAuraModule.factorVal.tertiaryVal();
                AttackAuraModule.factorVal.secondaryVal(bl);
                object = "AI logs " + (bl ? "ON" : "OFF") + ". File: " + String.valueOf(VuUvvnuUu.activeVal());
                break;
            }
            case "lab": {
                class_310.method_1551().execute(() -> class_310.method_1551().method_1507((class_437)new AimLabScreen()));
                object = "AI Lab opened.";
                break;
            }
            case "stop": {
                object = VuUvvnuUu.secondaryVal();
                break;
            }
            case "run": {
                if (stringArray.length >= 2) {
                    VuUvvnuUu.secondaryVal(stringArray[1]);
                }
                object = VuUvvnuUu.tertiaryVal();
                if (!VuUvvnuUu.phaseVal()) break;
                this.weightVal();
                break;
            }
            case "profile": {
                object = stringArray.length >= 2 ? VuUvvnuUu.secondaryVal(stringArray[1]) : "Current profile: " + VuUvvnuUu.themeVal() + ". Usage: .ai profile <name>";
                break;
            }
            case "list": {
                object = VuUvvnuUu.widthRef();
                break;
            }
            default: {
                object = "Usage: " + this.tertiaryVal();
            }
        }
        ChatLogger.primaryVal((String)object);
    }

    @Subscribe
    public void primaryVal(BlockBreakEvent coreG) {
        VuUvvnuUu.primaryVal(coreG);
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        VuUvvnuUu.weightVal();
    }

    private void weightVal() {
        block5: {
            block4: {
                if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) break block4;
                if (AttackAuraModule.descRef.marginVal.contains("AI")) break block5;
            }
            ChatLogger.primaryVal("AI mode is unavailable for the current profile.");
            VuUvvnuUu.secondaryVal();
            return;
        }
        AttackAuraModule.descRef.weightVal = "AI";
        AttackAuraModule.descRef.limitVal = AttackAuraModule.descRef.marginVal.indexOf("AI");
        AttackAuraModule coreB = WildClient.primaryVal.secondaryVal.primaryVal(AttackAuraModule.class);
        if (coreB != null && !coreB.enabled) {
            coreB.setEnabled(true);
        }
    }

    static {
        Loader.initialize();
    }
}

