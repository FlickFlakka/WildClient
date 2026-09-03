/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_156
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2663
 */
package ru.metaculture.protection;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import net.minecraft.class_1297;
import net.minecraft.class_2596;
import net.minecraft.class_156;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2663;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.UserSoundPlayer;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.ButtonSetting;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Totem Voices", secondaryVal="Replaces the totem sound with a custom one", tertiaryVal=ModuleCategory.Misc)
public class TotemVoicesModule
extends Module {
    private final FloatSetting countVal = new FloatSetting("Volume", 50.0f, 0.0f, 100.0f, 1.0f, false);
    private final ModeSetting depthVal = new ModeSetting("Sound", "Hmm", "Hmm", "This is sad(", "What the hell is this", "67!");
    private final BoolSetting descRef = new BoolSetting("Custom sounds", false);
    private final ButtonSetting activeVal = new ButtonSetting("Open folder", 0).primaryVal(() -> TotemVoicesModule.secondaryVal("totem"));

    public TotemVoicesModule() {
        this.holderVal();
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000L);
                    this.holderVal();
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                }
                catch (Throwable throwable) {}
            }
        }, "Wild-TotemVoices-FolderWatcher");
        thread.setDaemon(true);
        thread.start();
        Setting[] nvUuvVvuuNArray = new Setting[4];
        nvUuvVvuuNArray[0] = this.descRef;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.activeVal;
        nvUuvVvuuNArray[3] = this.countVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        class_2663 class_26632;
        this.holderVal();
        if (TotemVoicesModule.mc.field_1724 == null || TotemVoicesModule.mc.field_1687 == null) {
            return;
        }
        class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
        if (class_25962 instanceof class_2663 && (class_26632 = (class_2663)class_25962).method_11470() == 35) {
            class_1297 class_12972 = class_26632.method_11469((class_1937)TotemVoicesModule.mc.field_1687);
            if (class_12972 != null && class_12972.method_5628() == TotemVoicesModule.mc.field_1724.method_5628()) {
                uvUUuvnunU2.secondaryVal();
                this.blockRef();
                mc.execute(() -> {
                    TotemVoicesModule.mc.field_1713.method_3051(class_12972, (class_2394)class_2398.field_11220, 30);
                    TotemVoicesModule.mc.field_1773.method_3189(new class_1799((class_1935)class_1802.field_8288));
                });
            }
        }
    }

    private void blockRef() {
        if (this.descRef.tertiaryVal() && !TotemVoicesModule.primaryVal(this.depthVal.tertiaryVal())) {
            File file = new File(new File(WildClient.secondaryVal(), "sounds/totem"), new File(this.depthVal.tertiaryVal()).getName());
            UserSoundPlayer.primaryVal(file, this.countVal.tertiaryVal() / 100.0f);
            return;
        }
        String string = this.depthVal.secondaryVal("Hmm") ? "hm_pon.wav" : (this.depthVal.secondaryVal("This is sad(") ? "tusky_etopechalno.wav" : (this.depthVal.secondaryVal("67!") ? "pampimpoms.wav" : "ebat_eto_cho.wav"));
        String string2 = "/assets/" + WildClient.primaryVal.limitVal + "/tusky/" + string;
        Thread thread = new Thread(() -> {
            try {
                InputStream inputStream = TotemVoicesModule.class.getResourceAsStream(string2);
                if (inputStream == null) {
                    ChatLogger.primaryVal("Sound not found at path: " + string2);
                    return;
                }
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                FloatControl floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                float f = this.countVal.tertiaryVal();
                if (f <= 0.0f) {
                    floatControl.setValue(floatControl.getMinimum());
                } else {
                    float f2 = (float)(Math.log10((double)f / 100.0) * 20.0);
                    floatControl.setValue(Math.max(floatControl.getMinimum(), Math.min(floatControl.getMaximum(), f2)));
                }
                clip.start();
            }
            catch (Exception exception) {
                exception.printStackTrace();
                ChatLogger.primaryVal("Playback error: " + exception.getMessage());
            }
        }, "Wild-TotemVoice");
        thread.setDaemon(true);
        thread.start();
    }

    private void holderVal() {
        File file2 = new File(WildClient.secondaryVal(), "sounds/totem");
        file2.mkdirs();
        String[] stringArray = new String[4];
        stringArray[0] = "Hmm";
        stringArray[1] = "This is sad(";
        stringArray[2] = "What the hell is this";
        stringArray[3] = "67!";
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
        File[] fileArray = file2.listFiles(file -> {
            if (!file.isFile()) return false;
            if (!TotemVoicesModule.primaryVal(file)) return false;
            return true;
        });
        if (fileArray != null) {
            Arrays.sort(fileArray, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));
            for (File file3 : fileArray) {
                arrayList.add(file3.getName());
            }
        }
        this.depthVal.primaryVal((List<String>)arrayList);
    }

    private static boolean primaryVal(String string) {
        return "Hmm".equals(string) || "This is sad(".equals(string) || "What the hell is this".equals(string) || "67!".equals(string);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(File file) {
        String string = file.getName().toLowerCase(Locale.ROOT);
        if (string.endsWith(".mp3")) return true;
        if (string.endsWith(".wav")) return true;
        if (string.endsWith(".aiff")) return true;
        if (!string.endsWith(".au")) return false;
        return true;
    }

    private static void secondaryVal(String string) {
        File file = new File(WildClient.secondaryVal(), "sounds/" + string);
        file.mkdirs();
        try {
            class_156.method_668().method_672(file);
        }
        catch (Throwable throwable) {
            System.err.println("[Wild] Cannot open sound folder: " + throwable.getMessage());
        }
    }
}

