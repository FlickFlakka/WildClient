/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;

public final class UserSoundPlayer {
    private static final ExecutorService primaryVal = Executors.newCachedThreadPool(runnable -> {
        Thread thread = new Thread(runnable, "Wild-UserSound");
        thread.setDaemon(true);
        return thread;
    });

    private UserSoundPlayer() {
    }

    public static void primaryVal(File file, float f) {
        block3: {
            block2: {
                if (file == null) break block2;
                if (file.isFile() && file.canRead()) break block3;
            }
            return;
        }
        primaryVal.execute(() -> {
            try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);){
                AudioFormat audioFormat = audioInputStream.getFormat();
                AudioFormat audioFormat2 = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, audioFormat.getSampleRate(), 16, audioFormat.getChannels(), audioFormat.getChannels() * 2, audioFormat.getSampleRate(), false);
                try (AudioInputStream audioInputStream2 = AudioSystem.getAudioInputStream(audioFormat2, audioInputStream);){
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream2);
                    UserSoundPlayer.primaryVal(clip, f);
                    clip.addLineListener(lineEvent -> {
                        if (lineEvent.getType() == LineEvent.Type.STOP) {
                            if (clip.isOpen()) {
                                clip.close();
                            }
                        }
                    });
                    clip.start();
                    if (audioInputStream2 == null) return;
                }
                return;
            }
            catch (Throwable throwable) {
                System.err.println("[Wild] User sound playback failed: " + file.getAbsolutePath() + " (" + throwable.getClass().getSimpleName() + ": " + throwable.getMessage() + ")");
                throwable.printStackTrace();
            }
        });
    }

    private static void primaryVal(Clip clip, float f) {
        try {
            FloatControl floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            float f2 = Math.max(0.0f, Math.min(1.0f, f));
            float f3 = f2 <= 0.0f ? floatControl.getMinimum() : (float)(20.0 * Math.log10(f2));
            floatControl.setValue(Math.max(floatControl.getMinimum(), Math.min(floatControl.getMaximum(), f3)));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

