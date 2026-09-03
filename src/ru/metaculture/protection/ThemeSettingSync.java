/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.wild.module.api.Module;
import ru.metaculture.protection.UnUvnuVNNN;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ThemeShaderManager;
import ru.metaculture.protection.ThemeTargetProvider;
import ru.metaculture.protection.SettingHolder;
import ru.metaculture.protection.ThemeShaderFacade;

public final class ThemeSettingSync {
    private static final ThemeSettingSync primaryVal = new ThemeSettingSync();
    private final List<Registration> secondaryVal = new CopyOnWriteArrayList<Registration>();

    private ThemeSettingSync() {
        ThemeShaderManager.primaryVal().primaryVal(this::primaryVal);
        ThemeShaderManager.primaryVal().secondaryVal(this::primaryVal);
    }

    public static ThemeSettingSync primaryVal() {
        return primaryVal;
    }

    public synchronized void primaryVal(Module module, ThemeTargetProvider uvVVuUNNunn2) {
        this.primaryVal((Object)module, uvVVuUNNunn2);
    }

    public synchronized void primaryVal(SettingHolder vVvnUVnUvv2, ThemeTargetProvider uvVVuUNNunn2) {
        this.primaryVal((Object)vVvnUVnUvv2, uvVVuUNNunn2);
    }

    private void primaryVal(Object object, ThemeTargetProvider uvVVuUNNunn2) {
        block3: {
            block2: {
                if (object == null) break block2;
                if (uvVVuUNNunn2 != null) break block3;
            }
            return;
        }
        this.tertiaryVal(object);
        Registration modeVal = new Registration(object, uvVVuUNNunn2);
        this.secondaryVal.add(modeVal);
        this.primaryVal(modeVal);
    }

    public synchronized void primaryVal(Module module) {
        this.primaryVal((Object)module);
    }

    public synchronized void primaryVal(SettingHolder vVvnUVnUvv2) {
        this.primaryVal((Object)vVvnUVnUvv2);
    }

    private void primaryVal(Object object) {
        if (object == null) {
            return;
        }
        this.tertiaryVal(object);
        ThemeSettingSync.secondaryVal();
    }

    public void secondaryVal(Module module, ThemeTargetProvider uvVVuUNNunn2) {
        this.secondaryVal((Object)module, uvVVuUNNunn2);
    }

    public void secondaryVal(SettingHolder vVvnUVnUvv2, ThemeTargetProvider uvVVuUNNunn2) {
        this.secondaryVal((Object)vVvnUVnUvv2, uvVVuUNNunn2);
    }

    private void secondaryVal(Object object, ThemeTargetProvider uvVVuUNNunn2) {
        if (object == null || uvVVuUNNunn2 == null) {
            return;
        }
        Registration modeVal = this.secondaryVal(object);
        if (modeVal != null) {
            this.primaryVal(modeVal);
        }
        ArrayList<Setting> arrayList = new ArrayList<Setting>();
        Iterator<Setting> object2 = ThemeSettingSync.marginVal(object).iterator();
        while (object2.hasNext()) {
            Setting nodeA = object2.next();
            if (nodeA == null || !nodeA.tertiaryVal) continue;
            arrayList.add(nodeA);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (uvVVuUNNunn2.weightVal()) {
            String string = uvVVuUNNunn2.marginVal();
            if (string != null && !string.isBlank() && !"None".equalsIgnoreCase(string)) {
                ThemeShaderFacade.primaryVal(string, arrayList);
            }
        } else {
            SurfaceTarget surfaceTarget = uvVVuUNNunn2.tertiaryVal();
            if (surfaceTarget != null) {
                ThemeShaderFacade.primaryVal(surfaceTarget, arrayList);
            }
        }
    }

    private Registration secondaryVal(Object object) {
        for (Registration modeVal : this.secondaryVal) {
            Object t = modeVal.primaryVal.get();
            if (t != object) continue;
            return modeVal;
        }
        return null;
    }

    private void primaryVal(SurfaceTarget vnuVUNUv) {
        if (vnuVUNUv == null) {
            return;
        }
        for (Registration modeVal : this.secondaryVal) {
            ThemeTargetProvider uvVVuUNNunn2 = modeVal.secondaryVal;
            if (uvVVuUNNunn2 == null || uvVVuUNNunn2.weightVal() || uvVVuUNNunn2.tertiaryVal() != vnuVUNUv) continue;
            this.primaryVal(modeVal);
        }
    }

    private void primaryVal(String string) {
        if (string == null) {
            return;
        }
        String string2 = ThemeShaderManager.widthVal(string);
        for (Registration modeVal : this.secondaryVal) {
            ThemeTargetProvider uvVVuUNNunn2 = modeVal.secondaryVal;
            if (uvVVuUNNunn2 == null) continue;
            if (!uvVVuUNNunn2.weightVal()) {
                continue;
            }
            String string3 = uvVVuUNNunn2.marginVal();
            if (string3 == null || !string2.equals(ThemeShaderManager.widthVal(string3))) continue;
            this.primaryVal(modeVal);
        }
    }

    private synchronized void tertiaryVal(Object object) {
        Iterator<Registration> iterator = this.secondaryVal.iterator();
        while (iterator.hasNext()) {
            Registration modeVal = iterator.next();
            Object t = modeVal.primaryVal.get();
            if (t == null) {
                this.secondaryVal.remove(modeVal);
                continue;
            }
            if (t != object) continue;
            if (!modeVal.tertiaryVal.isEmpty()) {
                ThemeSettingSync.secondaryVal(t, modeVal.tertiaryVal);
            }
            this.secondaryVal.remove(modeVal);
        }
    }

    private synchronized void primaryVal(Registration modeVal) {
        List<Setting> list;
        String string;
        Object t;
        block12: {
            String object2;
            block9: {
                block11: {
                    block10: {
                        t = modeVal.primaryVal.get();
                        if (t == null) {
                            this.secondaryVal.remove(modeVal);
                            return;
                        }
                        if (!modeVal.secondaryVal.weightVal()) break block9;
                        object2 = modeVal.secondaryVal.marginVal();
                        if (object2 == null) break block10;
                        if (!object2.isBlank() && !"None".equalsIgnoreCase(object2)) break block11;
                    }
                    ThemeSettingSync.primaryVal(t, modeVal);
                    modeVal.marginVal = "";
                    modeVal.weightVal = "";
                    return;
                }
                string = ThemeShaderFacade.tertiaryVal(object2);
                list = ThemeShaderFacade.paramVal(object2);
                String object = "name:" + ThemeShaderManager.widthVal(object2);
                if (Objects.equals(modeVal.marginVal, string) && Objects.equals(modeVal.weightVal, object)) {
                    return;
                }
                modeVal.weightVal = object;
                break block12;
            }
            SurfaceTarget target = modeVal.secondaryVal.tertiaryVal();
            if (target == null) {
                ThemeSettingSync.primaryVal(t, modeVal);
                modeVal.marginVal = "";
                modeVal.weightVal = "";
                return;
            }
            string = ThemeShaderFacade.tertiaryVal(target);
            list = ThemeShaderFacade.paramVal(target);
            String string2 = "target:" + target.primaryVal();
            if (Objects.equals(modeVal.marginVal, string) && Objects.equals(modeVal.weightVal, string2)) {
                return;
            }
            modeVal.weightVal = string2;
        }
        modeVal.marginVal = string == null ? "" : string;
        ThemeSettingSync.primaryVal(t, modeVal);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Setting nodeA : list) {
            if (nodeA == null) continue;
            nodeA.tertiaryVal = true;
        }
        modeVal.tertiaryVal.addAll(list);
        ThemeSettingSync.primaryVal(t, list);
        ThemeSettingSync.secondaryVal();
    }

    private static void primaryVal(Object object, Registration modeVal) {
        if (!modeVal.tertiaryVal.isEmpty()) {
            ThemeSettingSync.secondaryVal(object, modeVal.tertiaryVal);
            modeVal.tertiaryVal.clear();
            ThemeSettingSync.secondaryVal();
        }
    }

    private static List<Setting> marginVal(Object object) {
        if (object instanceof Module) {
            Module module = (Module)object;
            return module.getAllSettings();
        }
        if (object instanceof SettingHolder) {
            SettingHolder vVvnUVnUvv2 = (SettingHolder)object;
            return vVvnUVnUvv2.primaryVal();
        }
        return List.of();
    }

    private static void primaryVal(Object object, List<Setting> list) {
        if (object instanceof Module) {
            Module module = (Module)object;
            module.addSettings(list.toArray(new Setting[0]));
        } else if (object instanceof SettingHolder) {
            SettingHolder vVvnUVnUvv2 = (SettingHolder)object;
            vVvnUVnUvv2.primaryVal(list.toArray(new Setting[0]));
        }
    }

    private static void secondaryVal(Object object, List<Setting> list) {
        if (object instanceof Module) {
            Module module = (Module)object;
            module.removeSettings(list);
        } else if (object instanceof SettingHolder) {
            SettingHolder vVvnUVnUvv2 = (SettingHolder)object;
            vVvnUVnUvv2.primaryVal(list);
        }
    }

    private static void secondaryVal() {
        try {
            UnUvnuVNNN unUvnuVNNN;
            if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null && (unUvnuVNNN = ru.metaculture.protection.WildClient.primaryVal.chunkVal.speedVal()) != null) {
                unUvnuVNNN.paramVal();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    static final class Registration {
        final WeakReference<Object> primaryVal;
        final ThemeTargetProvider secondaryVal;
        final List<Setting> tertiaryVal = new ArrayList<Setting>();
        String marginVal = "";
        String weightVal = "";

        Registration(Object object, ThemeTargetProvider uvVVuUNNunn2) {
            this.primaryVal = new WeakReference<Object>(object);
            this.secondaryVal = uvVVuUNNunn2;
        }
    }
}

