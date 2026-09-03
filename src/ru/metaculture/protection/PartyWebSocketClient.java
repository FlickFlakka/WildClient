/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  org.java_websocket.client.WebSocketClient
 *  org.java_websocket.handshake.ServerHandshake
 *  org.json.JSONObject
 */
package ru.metaculture.protection;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import net.minecraft.class_310;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONArray;
import org.json.JSONObject;

public class PartyWebSocketClient
extends WebSocketClient {
    public static PartyWebSocketClient primaryVal;
    private static volatile boolean marginVal;
    private static volatile Thread weightVal;
    public static final Map<String, WildClient> secondaryVal;
    public static volatile Consumer<JSONObject> tertiaryVal;
    private static volatile List<String> paramVal;
    private static volatile boolean extraVal;
    private static String limitVal;
    private final String speedVal;
    private final String widthVal;

    public PartyWebSocketClient(String string, String string2) {
        super(URI.create(string));
        this.setDaemon(true);
        this.speedVal = string;
        this.widthVal = string2;
        marginVal = false;
        primaryVal = this;
    }

    public static void primaryVal() {
        marginVal = true;
        Thread thread = weightVal;
        weightVal = null;
        if (thread != null) {
            thread.interrupt();
        }
        PartyWebSocketClient cellB = primaryVal;
        primaryVal = null;
        extraVal = false;
        limitVal = "";
        if (cellB != null) {
            try {
                cellB.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    public void onOpen(ServerHandshake serverHandshake) {
        limitVal = "";
    }

    public void onMessage(String string) {
        PartyWebSocketClient.primaryVal(() -> this.secondaryVal(string));
    }

    /*
     * Reconstructed 2026-09-01 from bytecode
     * via Vineflower + javap cross-check. Dispatches incoming party websocket
     * messages (op codes: party_state / member_update / member_left /
     * marker_update / marker_remove / party_closed / kicked / error).
     */
    private void secondaryVal(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            String string2 = jSONObject.has("op") ? jSONObject.getString("op") : "";
            switch (string2) {
                case "party_state": {
                    JSONArray jSONArray = jSONObject.optJSONArray("members");
                    ArrayList<String> arrayList = new ArrayList<String>();
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); ++i) {
                            arrayList.add(jSONArray.getString(i));
                        }
                    }
                    paramVal = List.copyOf(arrayList);
                    secondaryVal.clear();
                    JSONArray jSONArray2 = jSONObject.optJSONArray("markers");
                    if (jSONArray2 != null) {
                        for (int i = 0; i < jSONArray2.length(); ++i) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                            secondaryVal.put(jSONObject2.getString("owner").toLowerCase(), new WildClient(jSONObject2.getString("owner"), jSONObject2.optString("target", ""), jSONObject2.getDouble("x"), jSONObject2.getDouble("y"), jSONObject2.getDouble("z"), jSONObject2.optBoolean("entity", false)));
                        }
                    }
                    extraVal = true;
                    break;
                }
                case "member_update": {
                    JSONArray jSONArray = jSONObject.optJSONArray("members");
                    if (jSONArray == null) break;
                    ArrayList<String> arrayList = new ArrayList<String>();
                    for (int i = 0; i < jSONArray.length(); ++i) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    paramVal = List.copyOf(arrayList);
                    break;
                }
                case "member_left": {
                    String string3 = jSONObject.optString("owner", "");
                    if (!string3.isEmpty()) {
                        paramVal = paramVal.stream().filter(string4 -> !string4.equalsIgnoreCase(string3)).collect(Collectors.toList());
                    }
                    secondaryVal.remove(string3.toLowerCase());
                    break;
                }
                case "marker_update": {
                    String string3 = jSONObject.getString("owner");
                    secondaryVal.put(string3.toLowerCase(), new WildClient(string3, jSONObject.optString("target", ""), jSONObject.getDouble("x"), jSONObject.getDouble("y"), jSONObject.getDouble("z"), jSONObject.optBoolean("entity", false)));
                    break;
                }
                case "marker_remove": {
                    secondaryVal.remove(jSONObject.getString("owner").toLowerCase());
                    break;
                }
                case "party_closed":
                case "kicked": {
                    secondaryVal.clear();
                    break;
                }
                case "error": {
                    System.out.println("[PartyWS] Error: " + jSONObject.optString("msg"));
                }
            }
            Consumer<JSONObject> consumer = tertiaryVal;
            if (consumer != null) {
                try {
                    consumer.accept(jSONObject);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void primaryVal(String string) {
        if (!this.isOpen()) {
            return;
        }
        if (string == null || string.isEmpty()) {
            return;
        }
        if (string.equals(limitVal)) {
            return;
        }
        limitVal = string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("op", (Object)"auth");
            jSONObject.put("user", (Object)this.widthVal);
            jSONObject.put("party_id", (Object)string);
            this.send(jSONObject.toString());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void primaryVal(PartyWebSocketClient cellB, String string, String ... stringArray) {
        if (cellB == null || !cellB.isOpen()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("op", (Object)string);
            jSONObject.put("user", (Object)cellB.widthVal);
            if (stringArray.length >= 1 && stringArray[0] != null) {
                if (!stringArray[0].isEmpty()) {
                    if ("join".equals(string)) {
                        jSONObject.put("code", (Object)stringArray[0]);
                    } else if ("kick".equals(string)) {
                        jSONObject.put("target", (Object)stringArray[0]);
                    }
                }
            }
            cellB.send(jSONObject.toString());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void primaryVal(double d, double d2, double d3, boolean bl, String string) {
        if (!this.isOpen()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("op", (Object)"set_marker");
            jSONObject.put("user", (Object)this.widthVal);
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put("z", d3);
            jSONObject.put("entity", bl);
            jSONObject.put("target", (Object)(string == null ? "" : string));
            this.send(jSONObject.toString());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void secondaryVal() {
        if (!this.isOpen()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("op", (Object)"clear_marker");
            jSONObject.put("user", (Object)this.widthVal);
            this.send(jSONObject.toString());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void tertiaryVal() {
        if (!this.isOpen()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("op", (Object)"ping");
            this.send(jSONObject.toString());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void onClose(int n, String string, boolean bl) {
        if (marginVal) {
            return;
        }
        extraVal = false;
        limitVal = "";
        PartyWebSocketClient cellB = this;
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000L);
                if (marginVal) {
                    return;
                }
                if (primaryVal == cellB && !cellB.isOpen()) {
                    try {
                        cellB.reconnectBlocking();
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    catch (Exception exception) {}
                }
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
            finally {
                if (Thread.currentThread() == weightVal) {
                    weightVal = null;
                }
            }
        }, "PartyWS-Reconnect-Thread");
        thread.setDaemon(true);
        weightVal = thread;
        thread.start();
    }

    public void onError(Exception exception) {
    }

    public boolean marginVal() {
        return extraVal;
    }

    public static void weightVal() {
        limitVal = "";
    }

    public static List<String> paramVal() {
        return paramVal;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void primaryVal(Runnable runnable) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 != null) {
            if (!class_3102.method_18854()) {
                class_3102.execute(runnable);
                return;
            }
        }
        runnable.run();
    }

    private static /* synthetic */ boolean primaryVal(String string, String string2) {
        return !string2.equalsIgnoreCase(string);
    }

    static {
        secondaryVal = new ConcurrentHashMap<String, WildClient>();
        paramVal = new ArrayList<String>();
        limitVal = "";
    }

    public static class WildClient {
        public String primaryVal;
        public String secondaryVal;
        public double tertiaryVal;
        public double marginVal;
        public double weightVal;
        public long paramVal;
        public boolean extraVal;

        public WildClient(String string, String string2, double d, double d2, double d3, boolean bl) {
            this.primaryVal = string;
            this.secondaryVal = string2 == null ? "" : string2;
            this.tertiaryVal = d;
            this.marginVal = d2;
            this.weightVal = d3;
            this.paramVal = System.currentTimeMillis();
            this.extraVal = bl;
        }
    }
}

