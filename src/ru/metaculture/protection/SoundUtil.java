/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import ru.metaculture.protection.WildClient;

public class SoundUtil {
    private static final int primaryVal = 16;
    private static final ExecutorService secondaryVal = Executors.newFixedThreadPool(2, runnable -> {
        Thread thread = new Thread(runnable, "Wild-Audio");
        thread.setDaemon(true);
        return thread;
    });
    private static final List<Clip> tertiaryVal = Collections.synchronizedList(new ArrayList());
    private static volatile Clip marginVal = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal() {
        try {
            synchronized (tertiaryVal) {
                Iterator<Clip> iterator = tertiaryVal.iterator();
                while (iterator.hasNext()) {
                    Clip clip = iterator.next();
                    try {
                        if (clip == null) continue;
                        if (clip.isRunning()) {
                            clip.stop();
                        }
                        if (!clip.isOpen()) continue;
                        clip.close();
                    }
                    catch (Throwable throwable) {}
                }
                tertiaryVal.clear();
            }
            Clip clip2 = marginVal;
            if (clip2 != null) {
                try {
                    if (clip2.isRunning()) {
                        clip2.stop();
                    }
                    if (clip2.isOpen()) {
                        clip2.close();
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            marginVal = null;
            secondaryVal.shutdownNow();
            secondaryVal.awaitTermination(500L, TimeUnit.MILLISECONDS);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static void primaryVal(String string, float f, boolean bl) {
        Clip clip3 = marginVal;
        if (clip3 != null) {
            try {
                if (clip3.isRunning()) {
                    clip3.stop();
                }
                if (clip3.isOpen()) {
                    clip3.close();
                }
            }
            catch (Throwable throwable) {
            }
        }
        String string2 = "/assets/" + WildClient.primaryVal.limitVal + "/sound/mp3/" + string;
        secondaryVal.submit(() -> {
            try (InputStream inputStream = WildClient.class.getResourceAsStream(string2);
                 BufferedInputStream bufferedInputStream = inputStream != null ? new BufferedInputStream(inputStream) : null;){
                AudioInputStream audioInputStream = bufferedInputStream != null ? AudioSystem.getAudioInputStream(bufferedInputStream) : null;
                try {
                    if (audioInputStream == null) {
                        System.err.println("[SoundUtil] mp3 not found: " + string2);
                        return;
                    }
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    marginVal = clip;
                    try {
                        FloatControl floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                        float f2 = floatControl.getMinimum();
                        float f3 = floatControl.getMaximum();
                        float f4 = (float)((double)f2 * (1.0 - (double)f / 100.0) + (double)f3 * ((double)f / 100.0));
                        floatControl.setValue(f4);
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                    if (bl) {
                        clip.addLineListener(lineEvent -> {
                            if (lineEvent.getType() == LineEvent.Type.STOP) {
                                if (clip == marginVal) {
                                    try {
                                        clip.setFramePosition(0);
                                        clip.start();
                                    }
                                    catch (Throwable throwable) {
                                    }
                                } else {
                                    try {
                                        if (clip.isOpen()) {
                                            clip.close();
                                        }
                                    }
                                    catch (Throwable throwable) {
                                        // empty catch block
                                    }
                                }
                            }
                        });
                    } else {
                        clip.addLineListener(lineEvent -> {
                            if (lineEvent.getType() == LineEvent.Type.STOP) {
                                try {
                                    if (clip.isOpen()) {
                                        clip.close();
                                    }
                                }
                                catch (Throwable throwable) {
                                    // empty catch block
                                }
                                if (clip == marginVal) {
                                    marginVal = null;
                                }
                            }
                        });
                    }
                    clip.start();
                }
                finally {
                    if (audioInputStream != null) {
                        audioInputStream.close();
                    }
                }
            }
            catch (Throwable throwable) {
                System.err.println("[SoundUtil] mp3 error: " + String.valueOf(throwable));
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(String string, float f) {
        Object object = tertiaryVal;
        synchronized (object) {
            for (int i = tertiaryVal.size() - 1; i >= 0; --i) {
                Clip clip = tertiaryVal.get(i);
                if (clip == null) {
                    tertiaryVal.remove(i);
                    continue;
                }
                if (clip.isRunning()) continue;
                try {
                    if (clip.isOpen()) {
                        clip.close();
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                tertiaryVal.remove(i);
            }
        }
        Objects.requireNonNull(WildClient.primaryVal);
        String object2 = "/assets/" + "wild" + "/sound/wav/" + string + ".wav";
        float f2 = f;
        secondaryVal.submit(() -> SoundUtil.secondaryVal(object2, f2));
    }

    /*
     * Reconstructed 2026-09-01 from bytecode
     * via javap + Vineflower cross-check. WAV variant: silently returns when the
     * wrapped resource / AudioInputStream is unavailable (no "not found" line).
     */
    private static /* synthetic */ void secondaryVal(String string, float f) {
        try (InputStream inputStream = SoundUtil.class.getResourceAsStream(string);
             BufferedInputStream bufferedInputStream = inputStream != null ? new BufferedInputStream(inputStream) : null;
             AudioInputStream audioInputStream = bufferedInputStream != null ? AudioSystem.getAudioInputStream(bufferedInputStream) : null) {
            if (audioInputStream != null) {
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                float f2 = f < 0.0f ? 0.0f : Math.min(1.0f, f);
                try {
                    FloatControl floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                    double d = f2 <= 0.0f ? -80.0 : Math.log(f2) / Math.log(10.0) * 20.0;
                    floatControl.setValue((float)d);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                clip.addLineListener(lineEvent -> SoundUtil.primaryVal(clip, lineEvent));
                synchronized (tertiaryVal) {
                    while (tertiaryVal.size() >= 16) {
                        Clip clip2 = tertiaryVal.remove(0);
                        try {
                            if (clip2.isRunning()) {
                                clip2.stop();
                            }
                            if (clip2.isOpen()) {
                                clip2.close();
                            }
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    tertiaryVal.add(clip);
                }
                clip.start();
            }
        }
        catch (Throwable throwable) {
            System.err.println("[SoundUtil] wav error: " + String.valueOf(throwable));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static /* synthetic */ void primaryVal(Clip clip, LineEvent lineEvent) {
        if (lineEvent.getType() == LineEvent.Type.STOP) {
            try {
                if (clip.isOpen()) {
                    clip.close();
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            List<Clip> list = tertiaryVal;
            synchronized (list) {
                tertiaryVal.remove(clip);
            }
        }
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(SoundUtil::primaryVal, "Wild-SoundUtil-Shutdown"));
    }
}

