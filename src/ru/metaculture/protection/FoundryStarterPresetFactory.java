/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.FoundryStarterPreset;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.NodeDefinitionRegistry;

public final class FoundryStarterPresetFactory {
    private FoundryStarterPresetFactory() {
    }

    public static NodeGraph primaryVal(NodeDefinitionRegistry nodeI) {
        return FoundryStarterPreset.primaryVal(nodeI);
    }
}

