/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.List;
import java.util.Objects;
import ru.metaculture.protection.NodePort;
import ru.metaculture.protection.VnNnvvVUN;

public final class NodeDefinition {
    private final String primaryVal;
    private final String secondaryVal;
    private final String tertiaryVal;
    private final float marginVal;
    private final List<NodePort> weightVal;
    private final List<NodePort> paramVal;
    private final VnNnvvVUN extraVal;
    private final boolean limitVal;

    public NodeDefinition(String string, String string2, String string3, float f, List<NodePort> list, List<NodePort> list2, VnNnvvVUN vnNnvvVUN) {
        this(string, string2, string3, f, list, list2, vnNnvvVUN, NodeDefinition.primaryVal(string3, list2));
    }

    public NodeDefinition(String string, String string2, String string3, float f, List<NodePort> list, List<NodePort> list2, VnNnvvVUN vnNnvvVUN, boolean bl) {
        this.primaryVal = Objects.requireNonNull(string, "id");
        this.secondaryVal = Objects.requireNonNull(string2, "title");
        this.tertiaryVal = Objects.requireNonNull(string3, "category");
        this.marginVal = Math.max(132.0f, f);
        this.weightVal = List.copyOf(list);
        this.paramVal = List.copyOf(list2);
        this.extraVal = Objects.requireNonNull(vnNnvvVUN, "emitter");
        this.limitVal = bl;
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public String secondaryVal() {
        return this.secondaryVal;
    }

    public String tertiaryVal() {
        return this.tertiaryVal;
    }

    public float marginVal() {
        return this.marginVal;
    }

    public List<NodePort> weightVal() {
        return this.weightVal;
    }

    public List<NodePort> paramVal() {
        return this.paramVal;
    }

    public VnNnvvVUN extraVal() {
        return this.extraVal;
    }

    public boolean limitVal() {
        return this.limitVal;
    }

    public NodePort primaryVal(String string) {
        for (NodePort cellA : this.weightVal) {
            if (!cellA.id().equals(string)) continue;
            return cellA;
        }
        return null;
    }

    public NodePort secondaryVal(String string) {
        for (NodePort cellA : this.paramVal) {
            if (!cellA.id().equals(string)) continue;
            return cellA;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(String string, List<NodePort> list) {
        if (list == null) return false;
        if (list.isEmpty()) return false;
        return true;
    }
}

