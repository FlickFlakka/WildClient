/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Locale;
import java.util.Map;
import ru.metaculture.protection.NodePort;
import ru.metaculture.protection.NodeInstance;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.NodeConnection;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.NodeDefinitionRegistry;
import ru.metaculture.protection.NodeDefinition;

public final class NuuUuvvuVV {
    private final NodeGraph primaryVal;
    private final NodeDefinitionRegistry secondaryVal;
    private final Map<String, String> tertiaryVal;
    private final Map<String, String> marginVal;
    private final SurfaceTarget weightVal;

    NuuUuvvuVV(NodeGraph nuVVnvn2, NodeDefinitionRegistry nodeI, Map<String, String> map, Map<String, String> map2, SurfaceTarget vnuVUNUv) {
        this.primaryVal = nuVVnvn2;
        this.secondaryVal = nodeI;
        this.tertiaryVal = map;
        this.marginVal = map2;
        this.weightVal = vnuVUNUv == null ? SurfaceTarget.PREVIEW_ONLY : vnuVUNUv.marginVal();
    }

    public String primaryVal(NodeInstance queueVal, String string) {
        NodePort cellA;
        String string2;
        NodeConnection unitJ = this.primaryVal.secondaryVal(queueVal.primaryVal(), string);
        if (unitJ != null && (string2 = this.tertiaryVal.get(unitJ.weightVal())) != null) {
            return string2;
        }
        NodeDefinition object = this.secondaryVal.primaryVal(queueVal.secondaryVal());
        if (object != null && (cellA = object.primaryVal(string)) != null && cellA.defaultExpression() != null && !cellA.defaultExpression().isBlank()) {
            return cellA.defaultExpression();
        }
        return "0.0";
    }

    public String primaryVal(float f) {
        if (!Float.isFinite(f)) {
            return "0.0";
        }
        String object = String.format(Locale.ROOT, "%.6f", Float.valueOf(f));
        while (object.contains(".") && object.endsWith("0")) {
            object = object.substring(0, object.length() - 1);
        }
        if (object.endsWith(".")) {
            object = object + "0";
        }
        return object;
    }

    public String secondaryVal(NodeInstance queueVal, String string) {
        return "n_" + NuuUuvvuVV.primaryVal(queueVal.primaryVal()) + "_" + NuuUuvvuVV.primaryVal(string);
    }

    public String primaryVal(NodeInstance queueVal) {
        if (queueVal == null) {
            return "u_Value";
        }
        return this.marginVal.getOrDefault(queueVal.primaryVal(), "u_" + NuuUuvvuVV.primaryVal(queueVal.primaryVal("name", "Value")));
    }

    public SurfaceTarget primaryVal() {
        return this.weightVal;
    }

    public boolean secondaryVal() {
        return this.weightVal == SurfaceTarget.HUD;
    }

    private static String primaryVal(String string) {
        if (string == null || string.isBlank()) {
            return "x";
        }
        String string2 = string.replaceAll("[^A-Za-z0-9_]", "_");
        if (Character.isDigit(string2.charAt(0))) {
            return "_" + string2;
        }
        return string2;
    }
}

