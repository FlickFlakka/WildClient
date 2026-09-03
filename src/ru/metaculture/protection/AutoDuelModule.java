/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_476
 *  net.minecraft.class_7439
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import net.minecraft.class_1657;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_476;
import net.minecraft.class_7439;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AutoDuel", tertiaryVal=ModuleCategory.Player, secondaryVal="Handles duels for you on ReallyWorld")
public class AutoDuelModule
extends Module {
    public final SettingGroup countVal;
    private final List<String> depthVal;
    private long descRef;
    private long activeVal;
    private long radiusVal;
    private static final Pattern factorVal = Pattern.compile("^\\w{3,16}$");
    private static final String[] sourceVal;

    public AutoDuelModule() {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[9];
        vvNnnUNnVvnArray[0] = new BoolSetting("Shields", false);
        vvNnnUNnVvnArray[1] = new BoolSetting("Thorns 3", false);
        vvNnnUNnVvnArray[2] = new BoolSetting("Bow", false);
        vvNnnUNnVvnArray[3] = new BoolSetting("Totems", false);
        vvNnnUNnVvnArray[4] = new BoolSetting("NoDebuff", false);
        vvNnnUNnVvnArray[5] = new BoolSetting("Orbs", true);
        vvNnnUNnVvnArray[6] = new BoolSetting("Classic", false);
        vvNnnUNnVvnArray[7] = new BoolSetting("Cheater's Paradise", false);
        vvNnnUNnVvnArray[8] = new BoolSetting("Without Ender Pearl", false);
        this.countVal = new SettingGroup("Mode: ", vvNnnUNnVvnArray);
        this.depthVal = new ArrayList<String>();
        this.descRef = 0L;
        this.activeVal = 0L;
        this.radiusVal = 0L;
        this.addSettings(this.countVal);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.depthVal.clear();
        this.descRef = 0L;
        this.activeVal = System.currentTimeMillis();
        this.radiusVal = 0L;
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (AutoDuelModule.mc.field_1724 == null || mc.method_1562() == null) {
            return;
        }
        this.holderVal();
        List<String> list = this.blockRef();
        long l = System.currentTimeMillis();
        if (l - this.activeVal > 800L * (long)Math.max(list.size(), 1)) {
            this.depthVal.clear();
            this.activeVal = l;
        }
        if (l - this.descRef > 1000L) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String string = iterator.next();
                if (this.depthVal.contains(string)) continue;
                if (string.equals(AutoDuelModule.mc.field_1724.method_7334().getName())) continue;
                mc.method_1562().method_45730("duel " + string);
                this.depthVal.add(string);
                this.descRef = l;
                break;
            }
        }
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        block2: {
            block4: {
                Object object;
                block3: {
                    object = uvUUuvnunU2.marginVal();
                    if (!(object instanceof class_7439)) break block2;
                    class_7439 class_74392 = (class_7439)object;
                    if (!((String)(object = class_74392.comp_763().getString().toLowerCase())).contains("start") || !((String)object).contains("in")) break block3;
                    if (((String)object).contains("seconds")) break block4;
                }
                if (((String)object).contains("duel » commands are forbidden during a duel")) break block4;
                if (!((String)object).contains("duel")) break block2;
                if (!((String)object).contains("during") || !((String)object).contains("forbidden")) break block2;
            }
            this.toggle();
        }
    }

    private List<String> blockRef() {
        return mc.method_1562().method_2880().stream().map(class_6402 -> class_6402.method_2966().getName()).filter(string -> factorVal.matcher((CharSequence)string).matches()).collect(Collectors.toList());
    }

    private void holderVal() {
        Object object = AutoDuelModule.mc.field_1755;
        if (!(object instanceof class_476)) {
            return;
        }
        class_476 class_4762 = (class_476)object;
        object = class_4762.method_25440().getString();
        long l = System.currentTimeMillis();
        if (((String)object).contains("Kit selection") || ((String)object).contains("Kit selection")) {
            if (l - this.radiusVal > 90L) {
                int n;
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                for (n = 0; n < sourceVal.length; ++n) {
                    if (!this.countVal.secondaryVal(sourceVal[n])) continue;
                    arrayList.add(n);
                }
                if (!arrayList.isEmpty()) {
                    Collections.shuffle(arrayList);
                    n = (Integer)arrayList.get(0);
                    AutoDuelModule.mc.field_1761.method_2906(((class_1707)class_4762.method_17577()).field_7763, n, 0, class_1713.field_7794, (class_1657)AutoDuelModule.mc.field_1724);
                    this.radiusVal = l;
                }
            }
        } else if ((((String)object).contains("Duel setup") || ((String)object).contains("Duel setup")) && l - this.radiusVal > 90L) {
            AutoDuelModule.mc.field_1761.method_2906(((class_1707)class_4762.method_17577()).field_7763, 0, 0, class_1713.field_7794, (class_1657)AutoDuelModule.mc.field_1724);
            this.radiusVal = l;
        }
    }

    static {
        String[] stringArray = new String[9];
        stringArray[0] = "Shields";
        stringArray[1] = "Thorns 3";
        stringArray[2] = "Bow";
        stringArray[3] = "Totems";
        stringArray[4] = "NoDebuff";
        stringArray[5] = "Orbs";
        stringArray[6] = "Classic";
        stringArray[7] = "Cheater's Paradise";
        stringArray[8] = "Without Ender Pearl";
        sourceVal = stringArray;
    }
}

