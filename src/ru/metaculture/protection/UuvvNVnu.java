/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocketHandshakeException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import ru.metaculture.protection.ResourceIdSanitizer;

public final class UuvvNVnu {
    private static final String primaryVal = "wss://wildclient.org/api/v1/mc/online";
    private static final long[] secondaryVal;
    private static final long tertiaryVal = 1000L;
    private static final long marginVal = 30000L;
    private static final long weightVal = 120000L;
    private static final long paramVal = 1000L;
    private static final int extraVal = 429;
    private static final UuvvNVnu limitVal;
    private final AtomicBoolean speedVal = new AtomicBoolean();
    private final AtomicBoolean widthVal = new AtomicBoolean();
    private final ScheduledExecutorService chunkVal = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Wild-Online-Beacon");
        thread.setDaemon(true);
        return thread;
    });
    private volatile HttpClient blockRef;
    volatile WebSocket holderVal;
    private volatile boolean timerVal;
    private volatile long anchorVal;
    private volatile String weightRef = "";
    private String bufferVal;
    private int countVal;
    private CompletableFuture<WebSocket> depthVal = CompletableFuture.completedFuture(null);

    private UuvvNVnu() {
    }

    public static void primaryVal() {
        limitVal.tertiaryVal();
    }

    public static void secondaryVal() {
        limitVal.marginVal();
    }

    public static void primaryVal(String string) {
        limitVal.secondaryVal(ResourceIdSanitizer.primaryVal(string));
    }

    private void tertiaryVal() {
        if (!this.speedVal.compareAndSet(false, true)) {
            return;
        }
        this.blockRef = HttpClient.newBuilder().executor(this.chunkVal).connectTimeout(Duration.ofSeconds(10L)).build();
        this.chunkVal.scheduleWithFixedDelay(this::speedVal, 30000L, 30000L, TimeUnit.MILLISECONDS);
        this.extraVal();
    }

    private void marginVal() {
        this.timerVal = true;
        WebSocket webSocket = this.holderVal;
        this.holderVal = null;
        this.chunkVal.shutdownNow();
        if (webSocket == null) {
            return;
        }
        try {
            ((CompletableFuture)webSocket.sendClose(1000, "").orTimeout(1000L, TimeUnit.MILLISECONDS).exceptionally(throwable -> null)).join();
        }
        catch (Throwable throwable2) {
            // empty catch block
        }
        webSocket.abort();
    }

    private void secondaryVal(String string) {
        if (string.equals(this.weightRef)) {
            return;
        }
        this.weightRef = string;
        this.weightVal();
    }

    private void weightVal() {
        if (this.timerVal || this.holderVal == null) {
            return;
        }
        if (!this.widthVal.compareAndSet(false, true)) {
            return;
        }
        this.primaryVal(this::paramVal, 1000L);
    }

    private void paramVal() {
        this.widthVal.set(false);
        WebSocket webSocket = this.holderVal;
        if (this.timerVal || webSocket == null) {
            return;
        }
        String string = this.weightRef;
        if (string.equals(this.bufferVal)) {
            return;
        }
        this.bufferVal = string;
        this.depthVal = ((CompletableFuture)this.depthVal.thenCompose(webSocket2 -> webSocket.sendText(string, true))).exceptionally(throwable -> null);
    }

    private void extraVal() {
        if (this.timerVal) {
            return;
        }
        this.blockRef.newWebSocketBuilder().connectTimeout(Duration.ofSeconds(10L)).buildAsync(UuvvNVnu.blockRef(), new WildClient()).whenComplete((webSocket, throwable) -> {
            if (throwable == null) {
                return;
            }
            if (UuvvNVnu.primaryVal(throwable)) {
                this.countVal = secondaryVal.length - 1;
            }
            this.limitVal();
        });
    }

    private void limitVal() {
        if (this.timerVal) {
            return;
        }
        long l = secondaryVal[Math.min(this.countVal, secondaryVal.length - 1)];
        this.countVal = Math.min(this.countVal + 1, secondaryVal.length - 1);
        this.primaryVal(this::extraVal, l);
    }

    private void primaryVal(Runnable runnable, long l) {
        block5: {
            block4: {
                if (this.timerVal) break block4;
                if (!this.chunkVal.isShutdown()) break block5;
            }
            return;
        }
        try {
            this.chunkVal.schedule(runnable, l, TimeUnit.MILLISECONDS);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void speedVal() {
        WebSocket webSocket = this.holderVal;
        if (this.timerVal || webSocket == null) {
            return;
        }
        if (System.currentTimeMillis() - this.anchorVal < 120000L) {
            return;
        }
        this.holderVal = null;
        webSocket.abort();
        this.limitVal();
    }

    void primaryVal(WebSocket webSocket) {
        this.holderVal = webSocket;
        this.countVal = 0;
        this.bufferVal = null;
        this.depthVal = CompletableFuture.completedFuture(null);
        this.widthVal();
        this.paramVal();
    }

    void widthVal() {
        this.anchorVal = System.currentTimeMillis();
    }

    void chunkVal() {
        this.holderVal = null;
        this.limitVal();
    }

    private static boolean primaryVal(Throwable throwable) {
        for (Throwable throwable2 = throwable; throwable2 != null; throwable2 = throwable2.getCause()) {
            if (!(throwable2 instanceof WebSocketHandshakeException)) continue;
            WebSocketHandshakeException webSocketHandshakeException = (WebSocketHandshakeException)throwable2;
            return webSocketHandshakeException.getResponse().statusCode() == 429;
        }
        return false;
    }

    private static URI blockRef() {
        String string = System.getProperty("wild.online.url");
        return URI.create(string == null || string.isBlank() ? primaryVal : string.trim());
    }

    static {
        long[] lArray = new long[4];
        lArray[0] = 5000L;
        lArray[1] = 10000L;
        lArray[2] = 30000L;
        lArray[3] = 60000L;
        secondaryVal = lArray;
        limitVal = new UuvvNVnu();
    }

    final class WildClient
    implements WebSocket.Listener {
        WildClient() {
        }

        @Override
        public void onOpen(WebSocket webSocket) {
            webSocket.request(1L);
            UuvvNVnu.this.primaryVal(webSocket);
        }

        @Override
        public CompletionStage<?> onText(WebSocket webSocket, CharSequence charSequence, boolean bl) {
            UuvvNVnu.this.widthVal();
            webSocket.request(1L);
            return null;
        }

        @Override
        public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer byteBuffer, boolean bl) {
            UuvvNVnu.this.widthVal();
            webSocket.request(1L);
            return null;
        }

        @Override
        public CompletionStage<?> onPing(WebSocket webSocket, ByteBuffer byteBuffer) {
            UuvvNVnu.this.widthVal();
            webSocket.request(1L);
            return WebSocket.Listener.super.onPing(webSocket, byteBuffer);
        }

        @Override
        public CompletionStage<?> onPong(WebSocket webSocket, ByteBuffer byteBuffer) {
            UuvvNVnu.this.widthVal();
            webSocket.request(1L);
            return null;
        }

        @Override
        public CompletionStage<?> onClose(WebSocket webSocket, int n, String string) {
            if (webSocket == UuvvNVnu.this.holderVal) {
                UuvvNVnu.this.chunkVal();
            }
            return CompletableFuture.completedFuture(null);
        }

        @Override
        public void onError(WebSocket webSocket, Throwable throwable) {
            if (webSocket == UuvvNVnu.this.holderVal) {
                UuvvNVnu.this.chunkVal();
            }
        }
    }
}

