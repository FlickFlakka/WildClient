/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import ru.metaculture.protection.NodePort;
import ru.metaculture.protection.NodeGraphMetadata;
import ru.metaculture.protection.NodeInstance;
import ru.metaculture.protection.NodeConnection;
import ru.metaculture.protection.NodeDefinitionRegistry;
import ru.metaculture.protection.NodeDefinition;

public final class NodeGraph {
    private final Map<String, NodeInstance> primaryVal = new LinkedHashMap<String, NodeInstance>();
    private final List<NodeConnection> secondaryVal = new ArrayList<NodeConnection>();
    private final NodeGraphMetadata tertiaryVal = new NodeGraphMetadata();
    private int marginVal;
    private String weightVal = "preview";

    public NodeGraphMetadata primaryVal() {
        return this.tertiaryVal;
    }

    public void primaryVal(NodeGraphMetadata itemH) {
        this.tertiaryVal.primaryVal(itemH);
        ++this.marginVal;
    }

    public String secondaryVal() {
        return this.weightVal;
    }

    public void primaryVal(String string) {
        if (string != null) {
            if (!string.isBlank() && !this.weightVal.equals(string)) {
                this.weightVal = string;
                ++this.marginVal;
            }
        }
    }

    public NodeInstance primaryVal(String string, float f, float f2, NodeDefinitionRegistry nodeI) {
        String string2 = NodeGraph.paramVal(string);
        NodeInstance queueVal = new NodeInstance(string2, string, f, f2);
        NodeDefinition spanJ = nodeI.primaryVal(string);
        if (spanJ != null) {
            queueVal.primaryVal(spanJ.marginVal());
        }
        this.primaryVal.put(string2, queueVal);
        ++this.marginVal;
        return queueVal;
    }

    public void primaryVal(NodeInstance queueVal, NodeDefinitionRegistry nodeI) {
        Objects.requireNonNull(queueVal, "node");
        NodeDefinition spanJ = nodeI.primaryVal(queueVal.secondaryVal());
        if (spanJ != null) {
            queueVal.primaryVal(spanJ.marginVal());
        }
        this.primaryVal.put(queueVal.primaryVal(), queueVal);
        ++this.marginVal;
    }

    public boolean secondaryVal(String string) {
        NodeInstance queueVal = this.primaryVal.remove(string);
        if (queueVal == null) {
            return false;
        }
        this.secondaryVal.removeIf(unitJ -> {
            if (unitJ.primaryVal().equals(string)) return true;
            if (!unitJ.tertiaryVal().equals(string)) return false;
            return true;
        });
        ++this.marginVal;
        return true;
    }

    public boolean primaryVal(String string, String string2, String string3, String string4, NodeDefinitionRegistry nodeI) {
        block7: {
            block6: {
                NodeInstance queueVal = this.primaryVal.get(string);
                NodeInstance wickA = this.primaryVal.get(string3);
                if (queueVal == null || wickA == null || queueVal == wickA) {
                    return false;
                }
                NodeDefinition spanJ = nodeI.primaryVal(queueVal.secondaryVal());
                NodeDefinition peakG = nodeI.primaryVal(wickA.secondaryVal());
                if (spanJ == null || peakG == null) {
                    return false;
                }
                NodePort cellA = spanJ.secondaryVal(string2);
                NodePort vaseH = peakG.primaryVal(string4);
                if (cellA == null || vaseH == null) break block6;
                if (cellA.type() == vaseH.type()) break block7;
            }
            return false;
        }
        if (this.tertiaryVal(string, string3)) {
            return false;
        }
        this.secondaryVal.removeIf(unitJ -> unitJ.tertiaryVal().equals(string3) && unitJ.marginVal().equals(string4));
        this.secondaryVal.add(new NodeConnection(string, string2, string3, string4));
        ++this.marginVal;
        return true;
    }

    public boolean primaryVal(String string, String string2) {
        boolean bl = this.secondaryVal.removeIf(unitJ -> unitJ.tertiaryVal().equals(string) && unitJ.marginVal().equals(string2));
        if (bl) {
            ++this.marginVal;
        }
        return bl;
    }

    public Collection<NodeInstance> tertiaryVal() {
        return this.primaryVal.values();
    }

    public List<NodeConnection> marginVal() {
        return this.secondaryVal;
    }

    public NodeInstance tertiaryVal(String string) {
        return this.primaryVal.get(string);
    }

    public NodeConnection secondaryVal(String string, String string2) {
        Iterator<NodeConnection> iterator = this.secondaryVal.iterator();
        while (iterator.hasNext()) {
            NodeConnection unitJ = iterator.next();
            if (!unitJ.tertiaryVal().equals(string) || !unitJ.marginVal().equals(string2)) continue;
            return unitJ;
        }
        return null;
    }

    public List<NodeConnection> marginVal(String string) {
        ArrayList<NodeConnection> arrayList = new ArrayList<NodeConnection>();
        for (NodeConnection unitJ : this.secondaryVal) {
            if (!unitJ.primaryVal().equals(string)) continue;
            arrayList.add(unitJ);
        }
        return arrayList;
    }

    public NodeGraph weightVal(String string) {
        NodeGraph nuVVnvn2 = new NodeGraph();
        nuVVnvn2.weightVal = this.weightVal;
        nuVVnvn2.tertiaryVal.primaryVal(this.tertiaryVal);
        if (string == null || !this.primaryVal.containsKey(string)) {
            return nuVVnvn2;
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
        arrayDeque.push(string);
        while (!arrayDeque.isEmpty()) {
            String string2 = arrayDeque.pop();
            if (!linkedHashSet.add(string2)) continue;
            for (NodeConnection object3 : this.secondaryVal) {
                if (!object3.tertiaryVal().equals(string2)) continue;
                arrayDeque.push(object3.primaryVal());
            }
        }
        for (String string3 : linkedHashSet) {
            NodeInstance queueVal = this.primaryVal.get(string3);
            if (queueVal == null) continue;
            NodeInstance wickA = new NodeInstance(queueVal.primaryVal(), queueVal.secondaryVal(), queueVal.tertiaryVal(), queueVal.marginVal());
            wickA.primaryVal(queueVal.weightVal());
            wickA.paramVal().putAll(queueVal.paramVal());
            wickA.extraVal().putAll(queueVal.extraVal());
            nuVVnvn2.primaryVal.put(wickA.primaryVal(), wickA);
        }
        for (NodeConnection object : this.secondaryVal) {
            if (!linkedHashSet.contains(object.primaryVal())) continue;
            if (!linkedHashSet.contains(object.tertiaryVal())) continue;
            nuVVnvn2.secondaryVal.add(new NodeConnection(object.primaryVal(), object.secondaryVal(), object.tertiaryVal(), object.marginVal()));
        }
        return nuVVnvn2;
    }

    public int weightVal() {
        return this.marginVal;
    }

    public void paramVal() {
        ++this.marginVal;
    }

    public void extraVal() {
        this.primaryVal.clear();
        this.secondaryVal.clear();
        ++this.marginVal;
    }

    public boolean tertiaryVal(String string, String string2) {
        if (string.equals(string2)) {
            return true;
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
        arrayDeque.push(string2);
        while (!arrayDeque.isEmpty()) {
            String string3 = (String)arrayDeque.pop();
            if (!linkedHashSet.add(string3)) continue;
            if (string3.equals(string)) {
                return true;
            }
            for (NodeConnection unitJ : this.secondaryVal) {
                if (!unitJ.primaryVal().equals(string3)) continue;
                arrayDeque.push(unitJ.tertiaryVal());
            }
        }
        return false;
    }

    private static String paramVal(String string) {
        String string2 = string == null || string.isBlank() ? "node" : string.toLowerCase().replaceAll("[^a-z0-9]+", "_");
        return string2 + "_" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}

