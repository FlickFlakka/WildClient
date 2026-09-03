/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.FoundryStarterPreset;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.NodeDefinitionRegistry;

public final class ShaderTemplateCatalog {
    public static final List<Template> primaryVal = new ArrayList<Template>();

    private static boolean primaryVal(SurfaceTarget vnuVUNUv) {
        for (SurfaceTarget vnuVUNUv2 : SurfaceTarget.timerVal()) {
            if (vnuVUNUv2 != vnuVUNUv) continue;
            return true;
        }
        return false;
    }

    private ShaderTemplateCatalog() {
    }

    public static NodeGraph primaryVal(Template modeVal, NodeDefinitionRegistry nodeI) {
        return modeVal.paramVal.apply(nodeI);
    }

    static {
        Iterator<FoundryStarterPreset.cursorVal> iterator = FoundryStarterPreset.primaryVal.iterator();
        while (iterator.hasNext()) {
            FoundryStarterPreset.cursorVal panelVal = iterator.next();
            if (!ShaderTemplateCatalog.primaryVal(panelVal.target())) continue;
            primaryVal.add(new Template(panelVal.title(), panelVal.description(), panelVal.target(), panelVal.complexity(), panelVal.nodes(), panelVal.builder()));
        }
    }

    public static final class Template {
        public final String primaryVal;
        public final String secondaryVal;
        public final SurfaceTarget tertiaryVal;
        public final String marginVal;
        public final List<String> weightVal;
        final Function<NodeDefinitionRegistry, NodeGraph> paramVal;

        public Template(String string, String string2, SurfaceTarget vnuVUNUv, String string3, List<String> list, Function<NodeDefinitionRegistry, NodeGraph> function) {
            this.primaryVal = string;
            this.secondaryVal = string2;
            this.tertiaryVal = vnuVUNUv;
            this.marginVal = string3 == null || string3.isBlank() ? "Custom" : string3;
            this.weightVal = list == null ? List.of() : List.copyOf(list);
            this.paramVal = function;
        }
    }
}

