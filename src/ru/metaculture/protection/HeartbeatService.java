/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 */
package ru.metaculture.protection;

import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.FatalErrorHandler;
import ru.metaculture.protection.FingerprintCrypto;
import ru.metaculture.protection.HwidUtils;
import ru.metaculture.protection.AccessGuardException;

public final class HeartbeatService {
    public static final String primaryVal = "http://peer-to-peercdn.com/ping";
    private static final Duration secondaryVal = Duration.ofSeconds(10L);
    private static final Duration tertiaryVal = Duration.ofSeconds(15L);
    private static final long marginVal = 1L;
    private static final AtomicInteger weightVal = new AtomicInteger();
    private static final ScheduledExecutorService paramVal = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Wild-Heartbeat-" + weightVal.incrementAndGet());
        thread.setDaemon(true);
        return thread;
    });
    private static final HttpClient extraVal = HttpClient.newBuilder().connectTimeout(secondaryVal).followRedirects(HttpClient.Redirect.NORMAL).build();
    private static volatile String limitVal = null;

    private HeartbeatService() {
    }

    public static void primaryVal() {
        FatalErrorHandler.primaryVal();
        paramVal.execute(() -> {
            limitVal = HwidUtils.primaryVal();
            FingerprintCrypto.primaryVal();
        });
        paramVal.scheduleAtFixedRate(HeartbeatService::tertiaryVal, 1L, 1L, TimeUnit.MINUTES);
    }

    public static void secondaryVal() {
        paramVal.shutdownNow();
    }

    private static void tertiaryVal() {
        FatalErrorHandler.primaryVal();
        try {
            String string = limitVal;
            if (string == null) {
                limitVal = string = HwidUtils.primaryVal();
            }
            FingerprintCrypto.WildClient modeVal = FingerprintCrypto.primaryVal(string);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("v", (Number)modeVal.v());
            jsonObject.addProperty("kid", "ping-1");
            jsonObject.addProperty("encryptedPayload", modeVal.encryptedPayload());
            jsonObject.addProperty("timestamp", (Number)modeVal.timestamp());
            jsonObject.addProperty("requestId", modeVal.requestId());
            String string2 = HeartbeatService.marginVal();
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(primaryVal)).timeout(tertiaryVal).header("Content-Type", "application/json").header("User-Agent", "WildClient/" + string2).POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString(), StandardCharsets.UTF_8)).build();
            extraVal.sendAsync(httpRequest, HttpResponse.BodyHandlers.discarding()).exceptionally(throwable -> null);
        }
        catch (AccessGuardException itemD) {
            throw FatalErrorHandler.primaryVal(itemD);
        }
        catch (FingerprintCrypto.VvunVVUvUNnv vvunVVUvUNnv) {
            paramVal.shutdownNow();
        }
        catch (Throwable throwable2) {
            // empty catch block
        }
    }

    private static String marginVal() {
        if (WildClient.primaryVal == null) {
            return "unknown";
        }
        return WildClient.primaryVal.timerVal() + "-" + WildClient.primaryVal.anchorVal();
    }
}

