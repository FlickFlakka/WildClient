/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class NuvUnNnV {
    private static final String primaryVal = System.getProperty("wild.ntp.host", "time.windows.com");
    private static final int secondaryVal = Integer.getInteger("wild.ntp.port", 123);
    private static final int tertiaryVal = Integer.getInteger("wild.ntp.timeoutMs", 1200);
    private static final long marginVal = Long.getLong("wild.ntp.cacheTtlMs", 300000L);
    private static final long weightVal = Long.getLong("wild.ntp.failCooldownMs", 60000L);
    private static final long paramVal = 2208988800L;
    private static volatile WildClient extraVal;
    private static volatile long limitVal;

    private NuvUnNnV() {
    }

    public static long primaryVal() {
        WildClient modeVal = extraVal;
        long l = System.nanoTime();
        if (modeVal != null) {
            if (l - modeVal.nanoTime <= marginVal * 1000000L) {
                return modeVal.epochMillis + (l - modeVal.nanoTime) / 1000000L;
            }
        }
        if (l >= limitVal) {
            WildClient nodeC = NuvUnNnV.primaryVal(l);
            if (nodeC != null) {
                extraVal = nodeC;
                return nodeC.epochMillis;
            }
            limitVal = l + weightVal * 1000000L;
        }
        if (modeVal != null) {
            return modeVal.epochMillis + (l - modeVal.nanoTime) / 1000000L;
        }
        return System.currentTimeMillis();
    }

    public static long secondaryVal() {
        WildClient modeVal = extraVal;
        long l = System.nanoTime();
        if (modeVal != null) {
            return modeVal.epochMillis + (l - modeVal.nanoTime) / 1000000L;
        }
        return System.currentTimeMillis();
    }

    public static long tertiaryVal() {
        return NuvUnNnV.primaryVal() / 1000L;
    }

    public static boolean marginVal() {
        WildClient modeVal = extraVal;
        if (modeVal == null) {
            return false;
        }
        return System.nanoTime() - modeVal.nanoTime <= marginVal * 1000000L;
    }

    public static String weightVal() {
        return NuvUnNnV.marginVal() ? "NTP:" + primaryVal : "LOCAL";
    }

    public static void paramVal() {
        long l = System.nanoTime();
        WildClient modeVal = NuvUnNnV.primaryVal(l);
        if (modeVal != null) {
            extraVal = modeVal;
        } else {
            limitVal = l + weightVal * 1000000L;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static WildClient primaryVal(long l) {
        try {
            byte[] byArray = new byte[48];
            byArray[0] = 35;
            InetAddress inetAddress = InetAddress.getByName(primaryVal);
            DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length, inetAddress, secondaryVal);
            try (DatagramSocket datagramSocket = new DatagramSocket();){
                datagramSocket.setSoTimeout(tertiaryVal);
                datagramSocket.send(datagramPacket);
                DatagramPacket datagramPacket2 = new DatagramPacket(byArray, byArray.length);
                datagramSocket.receive(datagramPacket2);
                long l3 = System.nanoTime();
                long l2 = NuvUnNnV.primaryVal(byArray);
                if (l2 <= 0L) {
                    WildClient modeVal = null;
                    return modeVal;
                }
                WildClient modeVal = new WildClient(l2, l3);
                return modeVal;
            }
        }
        catch (Throwable throwable3) {
            return null;
        }
    }

    private static long primaryVal(byte[] byArray) {
        long l = ((long)byArray[40] & 0xFFL) << 24 | ((long)byArray[41] & 0xFFL) << 16 | ((long)byArray[42] & 0xFFL) << 8 | (long)byArray[43] & 0xFFL;
        long l2 = ((long)byArray[44] & 0xFFL) << 24 | ((long)byArray[45] & 0xFFL) << 16 | ((long)byArray[46] & 0xFFL) << 8 | (long)byArray[47] & 0xFFL;
        long l3 = l - 2208988800L;
        long l4 = l3 * 1000L + l2 * 1000L / 0x100000000L;
        return l4 > 0L ? l4 : 0L;
    }

    static final class WildClient
     {
        final long epochMillis;
        final long nanoTime;

        WildClient(long l, long l2) {
            this.epochMillis = l;
            this.nanoTime = l2;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "epochMillis=" + this.epochMillis + ", " + "nanoTime=" + this.nanoTime + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.epochMillis, this.nanoTime);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.epochMillis, that.epochMillis) && java.util.Objects.equals(this.nanoTime, that.nanoTime);}

        public long epochMillis() {
            return this.epochMillis;
        }

        public long nanoTime() {
            return this.nanoTime;
        }
    }
}

