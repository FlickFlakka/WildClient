/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import ru.metaculture.protection.VvNUnuUUuN;

public final class AudioDeviceReset {
    private static final int primaryVal = 44100;
    private static final float secondaryVal = 0.42f;
    private static final float tertiaryVal = 0.62f;
    private static final AtomicBoolean marginVal = new AtomicBoolean(false);
    private static volatile Thread weightVal;
    private static volatile boolean paramVal;
    private static volatile long extraVal;

    private AudioDeviceReset() {
    }

    public static void primaryVal() {
        if (!VvNUnuUUuN.weightVal()) {
            AudioDeviceReset.tertiaryVal();
            return;
        }
        long l = VvNUnuUUuN.widthVal();
        if (l != 0L && l != extraVal) {
            if (marginVal.compareAndSet(false, true)) {
                extraVal = l;
                paramVal = false;
                Thread thread = new Thread(AudioDeviceReset::marginVal, "Wild-AudioDeviceReset");
                thread.setDaemon(true);
                thread.setPriority(10);
                weightVal = thread;
                thread.start();
            }
        }
    }

    public static void secondaryVal() {
        AudioDeviceReset.primaryVal();
    }

    public static void tertiaryVal() {
        paramVal = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void marginVal() {
        SourceDataLine dataLine = null;
        try {
            int n;
            VvNUnuUUuN.WildClient modeVal = VvNUnuUUuN.paramVal();
            long l = VvNUnuUUuN.widthVal();
            float f = AudioDeviceReset.primaryVal(modeVal, l);
            byte[] byArray = AudioDeviceReset.primaryVal(modeVal, l, f);
            AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100.0f, 16, 1, 2, 44100.0f, false);
            dataLine = AudioSystem.getSourceDataLine(audioFormat);
            dataLine.open(audioFormat, Math.min(byArray.length, 44100));
            dataLine.start();
            int n2 = 1024;
            for (int i = 0; i < byArray.length && !paramVal; i += n) {
                n = Math.min(n2, byArray.length - i);
                dataLine.write(byArray, i, n);
            }
            dataLine.drain();
        }
        catch (Throwable throwable) {
        }
        finally {
            try {
                if (dataLine != null) {
                    dataLine.stop();
                    dataLine.flush();
                    dataLine.close();
                }
            }
            catch (Throwable throwable) {}
            marginVal.set(false);
            weightVal = null;
        }
    }

    private static byte[] primaryVal(VvNUnuUUuN.WildClient modeVal, long l, float f) {
        int n = Math.max(1, (int)(44100.0f * f));
        ByteBuffer byteBuffer = ByteBuffer.allocate(n * 2).order(ByteOrder.LITTLE_ENDIAN);
        WildClient nodeC = new WildClient(l ^ 0x91E10DA5C79E7B1DL);
        float f2 = 0.0f;
        int n2 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (int i = 0; i < n; ++i) {
            float f5 = (float)i / 44100.0f;
            float f6 = (float)i / (float)Math.max(1, n - 1);
            float f7 = AudioDeviceReset.primaryVal(f6, modeVal);
            if (n2 <= 0) {
                f2 = AudioDeviceReset.primaryVal(modeVal, nodeC, f5, f6);
                n2 = AudioDeviceReset.secondaryVal(modeVal, nodeC, f6);
            } else {
                --n2;
            }
            float f8 = AudioDeviceReset.primaryVal(modeVal, nodeC, f5, f6);
            float f9 = f8 * 0.36f + f2 * 0.64f;
            f9 += AudioDeviceReset.primaryVal(modeVal, f5, f6);
            f9 += AudioDeviceReset.primaryVal(modeVal, nodeC, f6);
            if (modeVal == VvNUnuUUuN.WildClient.VRAM_GARBAGE || modeVal == VvNUnuUUuN.WildClient.BROKEN_PIPELINE) {
                f9 = AudioDeviceReset.marginVal(f9, 7.0f + nodeC.primaryVal() * 11.0f);
            }
            if (AudioDeviceReset.tertiaryVal(modeVal, nodeC, f6)) {
                f9 *= modeVal == VvNUnuUUuN.WildClient.BLACK_PANEL ? 0.015f : 0.1f;
            }
            if (nodeC.primaryVal() < AudioDeviceReset.primaryVal(modeVal, f6)) {
                f9 += (nodeC.primaryVal() * 2.0f - 1.0f) * AudioDeviceReset.secondaryVal(modeVal);
            }
            f3 = f3 * 0.995f + f9 * 0.005f;
            f9 -= f3;
            f9 = f4 * 0.18f + f9 * 0.82f;
            f4 = f9;
            f9 *= f7;
            f9 *= AudioDeviceReset.primaryVal(modeVal);
            f9 = AudioDeviceReset.primaryVal(f9);
            f9 = AudioDeviceReset.primaryVal(f9, -0.62f, 0.62f);
            short s = (short)(f9 * 32767.0f);
            byteBuffer.putShort(s);
        }
        return byteBuffer.array();
    }

    private static float primaryVal(VvNUnuUUuN.WildClient modeVal, WildClient nodeC, float f, float f2) {
        return switch (modeVal) {
            default -> throw new MatchException(null, null);
            case VvNUnuUUuN.WildClient.FRAMEBUFFER_COLLAPSE -> {
                float var4_4 = AudioDeviceReset.primaryVal(52.0f, f) * 0.36f;
                float var5_10 = AudioDeviceReset.secondaryVal(67.0f + 9.0f * AudioDeviceReset.primaryVal(2.2f, f), f) * 0.31f;
                float var6_16 = AudioDeviceReset.tertiaryVal(320.0f + 180.0f * AudioDeviceReset.primaryVal(4.4f, f), f) * 0.16f;
                yield var4_4 + var5_10 + var6_16 + AudioDeviceReset.primaryVal(nodeC) * 0.045f;
            }
            case VvNUnuUUuN.WildClient.VRAM_GARBAGE -> {
                float var4_5 = AudioDeviceReset.primaryVal(71.0f, f) * 0.22f;
                float var5_11 = AudioDeviceReset.secondaryVal(86.0f + 46.0f * nodeC.primaryVal(), f) * 0.34f;
                float var6_17 = AudioDeviceReset.tertiaryVal(520.0f + 960.0f * nodeC.primaryVal(), f) * 0.28f;
                yield var4_5 + var5_11 + var6_17 + AudioDeviceReset.primaryVal(nodeC) * 0.24f;
            }
            case VvNUnuUUuN.WildClient.DESYNC_FAILURE -> {
                float var4_6 = AudioDeviceReset.primaryVal(44.0f + 18.0f * AudioDeviceReset.primaryVal(3.1f, f), f) * 0.3f;
                float var5_12 = AudioDeviceReset.secondaryVal(79.0f + 58.0f * AudioDeviceReset.primaryVal(7.0f, f), f) * 0.38f;
                float var6_18 = AudioDeviceReset.primaryVal(760.0f + 330.0f * AudioDeviceReset.primaryVal(11.0f, f), f) * 0.12f;
                yield var4_6 + var5_12 + var6_18 + AudioDeviceReset.primaryVal(nodeC) * 0.055f;
            }
            case VvNUnuUUuN.WildClient.TERMINAL_DEATH -> {
                float var4_7 = AudioDeviceReset.primaryVal(39.0f, f) * 0.34f;
                float var5_13 = AudioDeviceReset.primaryVal(78.0f, f) * 0.22f;
                float var6_19 = AudioDeviceReset.secondaryVal(58.0f + 5.0f * AudioDeviceReset.primaryVal(1.4f, f), f) * 0.5f;
                float var7_22 = AudioDeviceReset.tertiaryVal(180.0f + 70.0f * AudioDeviceReset.primaryVal(3.2f, f), f) * 0.14f;
                yield var4_7 + var5_13 + var6_19 + var7_22;
            }
            case VvNUnuUUuN.WildClient.BLACK_PANEL -> {
                float var4_8 = AudioDeviceReset.primaryVal(37.0f, f) * 0.46f;
                float var5_14 = AudioDeviceReset.primaryVal(74.0f, f) * 0.22f;
                float var6_20 = AudioDeviceReset.secondaryVal(49.0f, f) * 0.17f;
                yield var4_8 + var5_14 + var6_20 + AudioDeviceReset.primaryVal(nodeC) * 0.035f;
            }
            case VvNUnuUUuN.WildClient.BROKEN_PIPELINE -> {
                float var4_9 = AudioDeviceReset.primaryVal(61.0f + 24.0f * AudioDeviceReset.primaryVal(2.6f, f), f) * 0.28f;
                float var5_15 = AudioDeviceReset.secondaryVal(76.0f + 72.0f * AudioDeviceReset.primaryVal(8.4f, f), f) * 0.42f;
                float var6_21 = AudioDeviceReset.tertiaryVal(630.0f + 1220.0f * nodeC.primaryVal(), f) * 0.31f;
                yield var4_9 + var5_15 + var6_21 + AudioDeviceReset.primaryVal(nodeC) * 0.2f;
            }
        };
    }

    private static float primaryVal(VvNUnuUUuN.WildClient modeVal, float f, float f2) {
        float f3 = AudioDeviceReset.secondaryVal((f2 - 0.52f) / 0.34f);
        return switch (modeVal) {
            case VvNUnuUUuN.WildClient.TERMINAL_DEATH -> AudioDeviceReset.secondaryVal(54.0f + 4.0f * AudioDeviceReset.primaryVal(2.0f, f), f) * 0.42f * f3;
            case VvNUnuUUuN.WildClient.BLACK_PANEL -> AudioDeviceReset.primaryVal(31.0f, f) * 0.34f * f3;
            case VvNUnuUUuN.WildClient.VRAM_GARBAGE -> AudioDeviceReset.secondaryVal(69.0f + 12.0f * AudioDeviceReset.primaryVal(5.0f, f), f) * 0.28f * f3;
            case VvNUnuUUuN.WildClient.BROKEN_PIPELINE -> AudioDeviceReset.secondaryVal(57.0f + 18.0f * AudioDeviceReset.primaryVal(6.0f, f), f) * 0.36f * f3;
            default -> AudioDeviceReset.secondaryVal(56.0f, f) * 0.26f * f3;
        };
    }

    private static float primaryVal(VvNUnuUUuN.WildClient modeVal, WildClient nodeC, float f) {
        float f2 = switch (modeVal) {
            case VvNUnuUUuN.WildClient.VRAM_GARBAGE -> 0.055f + f * 0.035f;
            case VvNUnuUUuN.WildClient.BROKEN_PIPELINE -> 0.06f + f * 0.04f;
            case VvNUnuUUuN.WildClient.TERMINAL_DEATH -> 0.032f + f * 0.02f;
            case VvNUnuUUuN.WildClient.BLACK_PANEL -> 0.012f + f * 0.01f;
            default -> 0.026f + f * 0.02f;
        };
        if (nodeC.primaryVal() > f2) {
            return 0.0f;
        }
        float f3 = nodeC.primaryVal() * 2.0f - 1.0f;
        return f3 * (switch (modeVal) {
            case VvNUnuUUuN.WildClient.VRAM_GARBAGE, VvNUnuUUuN.WildClient.BROKEN_PIPELINE -> 0.36f;
            case VvNUnuUUuN.WildClient.TERMINAL_DEATH -> 0.25f;
            case VvNUnuUUuN.WildClient.BLACK_PANEL -> 0.12f;
            default -> 0.2f;
        });
    }

    private static int secondaryVal(VvNUnuUUuN.WildClient modeVal, WildClient nodeC, float f) {
        int n = switch (modeVal) {
            default -> throw new MatchException(null, null);
            case VvNUnuUUuN.WildClient.TERMINAL_DEATH -> 80;
            case VvNUnuUUuN.WildClient.BLACK_PANEL -> 64;
            case VvNUnuUUuN.WildClient.VRAM_GARBAGE -> 22;
            case VvNUnuUUuN.WildClient.BROKEN_PIPELINE -> 28;
            case VvNUnuUUuN.WildClient.DESYNC_FAILURE -> 36;
            case VvNUnuUUuN.WildClient.FRAMEBUFFER_COLLAPSE -> 44;
        };
        int n2 = (int)((float)n * f * 0.75f);
        return 4 + nodeC.primaryVal(Math.max(5, n + n2));
    }

    private static float primaryVal(VvNUnuUUuN.WildClient modeVal, long l) {
        float f = AudioDeviceReset.secondaryVal(AudioDeviceReset.primaryVal(l ^ 0xC0FFEE22ABL));
        return switch (modeVal) {
            default -> throw new MatchException(null, null);
            case VvNUnuUUuN.WildClient.FRAMEBUFFER_COLLAPSE -> 1.55f + f * 0.55f;
            case VvNUnuUUuN.WildClient.VRAM_GARBAGE -> 1.8f + f * 0.7f;
            case VvNUnuUUuN.WildClient.DESYNC_FAILURE -> 1.45f + f * 0.65f;
            case VvNUnuUUuN.WildClient.TERMINAL_DEATH -> 2.0f + f * 0.8f;
            case VvNUnuUUuN.WildClient.BLACK_PANEL -> 1.25f + f * 0.5f;
            case VvNUnuUUuN.WildClient.BROKEN_PIPELINE -> 1.85f + f * 0.75f;
        };
    }

    private static float primaryVal(VvNUnuUUuN.WildClient modeVal) {
        float f = switch (modeVal) {
            default -> throw new MatchException(null, null);
            case VvNUnuUUuN.WildClient.BLACK_PANEL -> 0.32f;
            case VvNUnuUUuN.WildClient.TERMINAL_DEATH -> 0.42f;
            case VvNUnuUUuN.WildClient.VRAM_GARBAGE -> 0.39f;
            case VvNUnuUUuN.WildClient.BROKEN_PIPELINE -> 0.41f;
            case VvNUnuUUuN.WildClient.DESYNC_FAILURE -> 0.38f;
            case VvNUnuUUuN.WildClient.FRAMEBUFFER_COLLAPSE -> 0.37f;
        };
        return Math.min(f, 0.42f);
    }

    private static float primaryVal(float f, VvNUnuUUuN.WildClient modeVal) {
        float f2 = AudioDeviceReset.secondaryVal(f / 0.006f);
        float f3 = 1.0f - AudioDeviceReset.secondaryVal((f - 0.86f) / 0.14f);
        float f4 = f2 * f3;
        if (modeVal == VvNUnuUUuN.WildClient.TERMINAL_DEATH) {
            f4 *= 0.88f + 0.12f * AudioDeviceReset.secondaryVal(6.0f, f);
        }
        if (modeVal == VvNUnuUUuN.WildClient.BLACK_PANEL) {
            f4 *= 0.82f + 0.18f * (1.0f - AudioDeviceReset.secondaryVal((f - 0.36f) / 0.48f));
        }
        return AudioDeviceReset.primaryVal(f4, 0.0f, 1.0f);
    }

    private static boolean tertiaryVal(VvNUnuUUuN.WildClient modeVal, WildClient nodeC, float f) {
        float f2 = switch (modeVal) {
            default -> throw new MatchException(null, null);
            case VvNUnuUUuN.WildClient.BLACK_PANEL -> 0.045f + f * 0.07f;
            case VvNUnuUUuN.WildClient.TERMINAL_DEATH -> 0.02f + f * 0.04f;
            case VvNUnuUUuN.WildClient.VRAM_GARBAGE -> 0.014f + f * 0.026f;
            case VvNUnuUUuN.WildClient.BROKEN_PIPELINE -> 0.018f + f * 0.03f;
            case VvNUnuUUuN.WildClient.DESYNC_FAILURE -> 0.016f + f * 0.026f;
            case VvNUnuUUuN.WildClient.FRAMEBUFFER_COLLAPSE -> 0.014f + f * 0.024f;
        };
        return nodeC.primaryVal() < f2;
    }

    private static float primaryVal(VvNUnuUUuN.WildClient modeVal, float f) {
        return switch (modeVal) {
            default -> throw new MatchException(null, null);
            case VvNUnuUUuN.WildClient.VRAM_GARBAGE -> 0.015f + f * 0.03f;
            case VvNUnuUUuN.WildClient.BROKEN_PIPELINE -> 0.018f + f * 0.032f;
            case VvNUnuUUuN.WildClient.TERMINAL_DEATH -> 0.008f + f * 0.016f;
            case VvNUnuUUuN.WildClient.BLACK_PANEL -> 0.004f + f * 0.006f;
            case VvNUnuUUuN.WildClient.DESYNC_FAILURE -> 0.01f + f * 0.018f;
            case VvNUnuUUuN.WildClient.FRAMEBUFFER_COLLAPSE -> 0.008f + f * 0.014f;
        };
    }

    private static float secondaryVal(VvNUnuUUuN.WildClient modeVal) {
        return switch (modeVal) {
            default -> throw new MatchException(null, null);
            case VvNUnuUUuN.WildClient.VRAM_GARBAGE -> 0.5f;
            case VvNUnuUUuN.WildClient.BROKEN_PIPELINE -> 0.54f;
            case VvNUnuUUuN.WildClient.TERMINAL_DEATH -> 0.4f;
            case VvNUnuUUuN.WildClient.BLACK_PANEL -> 0.2f;
            case VvNUnuUUuN.WildClient.DESYNC_FAILURE -> 0.34f;
            case VvNUnuUUuN.WildClient.FRAMEBUFFER_COLLAPSE -> 0.32f;
        };
    }

    private static float primaryVal(float f, float f2) {
        return (float)Math.sin(Math.PI * 2 * (double)f * (double)f2);
    }

    private static float secondaryVal(float f, float f2) {
        return AudioDeviceReset.primaryVal(f, f2) >= 0.0f ? 1.0f : -1.0f;
    }

    private static float tertiaryVal(float f, float f2) {
        float f3 = f2 * f;
        return 2.0f * (f3 - (float)Math.floor(f3 + 0.5f));
    }

    private static float primaryVal(WildClient modeVal) {
        return modeVal.primaryVal() * 2.0f - 1.0f;
    }

    private static float marginVal(float f, float f2) {
        float f3 = Math.max(2.0f, f2);
        return (float)Math.round(f * f3) / f3;
    }

    private static float primaryVal(float f) {
        return (float)Math.tanh(f * 1.45f);
    }

    private static float secondaryVal(float f) {
        float f2 = AudioDeviceReset.primaryVal(f, 0.0f, 1.0f);
        return f2 * f2 * (3.0f - 2.0f * f2);
    }

    private static float primaryVal(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        if (f > f3) {
            return f3;
        }
        return f;
    }

    private static long primaryVal(long l) {
        l ^= l >>> 33;
        l *= -49064778989728563L;
        l ^= l >>> 33;
        l *= -4265267296055464877L;
        l ^= l >>> 33;
        return l;
    }

    private static float secondaryVal(long l) {
        return (float)(l >>> 40 & 0xFFFFFFL) / 1.6777215E7f;
    }

    static final class WildClient {
        private long primaryVal;

        WildClient(long l) {
            this.primaryVal = l == 0L ? -7046029254386353131L : l;
        }

        float primaryVal() {
            this.primaryVal ^= this.primaryVal << 13;
            this.primaryVal ^= this.primaryVal >>> 7;
            this.primaryVal ^= this.primaryVal << 17;
            return (float)(this.primaryVal >>> 40 & 0xFFFFFFL) / 1.6777215E7f;
        }

        int primaryVal(int n) {
            if (n <= 1) {
                return 0;
            }
            return (int)(this.primaryVal() * (float)n);
        }
    }
}

