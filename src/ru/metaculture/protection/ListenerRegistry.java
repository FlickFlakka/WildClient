/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import ru.metaculture.protection.CancellableEvent;
import ru.metaculture.protection.Event;
import ru.metaculture.protection.EventPriority;
import ru.metaculture.protection.Subscribe;

public final class ListenerRegistry {
    private final Map<Class<?>, List<WildClient>> primaryVal = new ConcurrentHashMap();

    public void primaryVal(Object object) {
        Method[] methodArray = object.getClass().getDeclaredMethods();
        int n = methodArray.length;
        for (int i = 0; i < n; ++i) {
            Class<?> clazz2;
            Method method = methodArray[i];
            if (method.getParameterCount() != 1 || !method.isAnnotationPresent(Subscribe.class) || !Event.class.isAssignableFrom(clazz2 = method.getParameterTypes()[0])) continue;
            method.setAccessible(true);
            byte by = method.getAnnotation(Subscribe.class).priority();
            List<WildClient> list = this.primaryVal.computeIfAbsent(clazz2, clazz -> new CopyOnWriteArrayList<WildClient>());
            for (WildClient nodeC : list) {
                if (nodeC.primaryVal != object || !nodeC.secondaryVal.equals(method)) continue;
                return;
            }
            list.add(new WildClient(object, method, by));
            list.sort(Comparator.comparingInt(modeVal -> ListenerRegistry.primaryVal(modeVal.tertiaryVal)));
        }
    }

    public void secondaryVal(Object object) {
        Iterator<Map.Entry<Class<?>, List<WildClient>>> iterator = this.primaryVal.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Class<?>, List<WildClient>> entry = iterator.next();
            List<WildClient> list = entry.getValue();
            list.removeIf(modeVal -> modeVal.primaryVal == object);
            if (!list.isEmpty()) continue;
            this.primaryVal.remove(entry.getKey(), list);
        }
    }

    public Event primaryVal(Event vunUNUNVUnv) {
        List<WildClient> list = this.primaryVal.get(vunUNUNVUnv.getClass());
        if (list == null || list.isEmpty()) {
            return vunUNUNVUnv;
        }
        WildClient[] mossA = list.toArray(new WildClient[0]);
        if (vunUNUNVUnv instanceof CancellableEvent) {
            CancellableEvent unuNvnVUUunn = (CancellableEvent)vunUNUNVUnv;
            WildClient[] vaseG = mossA;
            int n = vaseG.length;
            for (int i = 0; i < n; ++i) {
                WildClient modeVal = vaseG[i];
                modeVal.primaryVal(vunUNUNVUnv);
                if (!unuNvnVUUunn.marginVal()) {
                    continue;
                }
                break;
            }
        } else {
            WildClient[] vaseF = mossA;
            int n = vaseF.length;
            for (int i = 0; i < n; ++i) {
                WildClient modeVal = vaseF[i];
                modeVal.primaryVal(vunUNUNVUnv);
            }
        }
        return vunUNUNVUnv;
    }

    private static int primaryVal(byte by) {
        for (int i = 0; i < EventPriority.ORDER.length; ++i) {
            if (EventPriority.ORDER[i] != by) continue;
            return i;
        }
        return EventPriority.ORDER.length;
    }

    static final class WildClient {
        final Object primaryVal;
        final Method secondaryVal;
        final byte tertiaryVal;

        WildClient(Object object, Method method, byte by) {
            this.primaryVal = object;
            this.secondaryVal = method;
            this.tertiaryVal = by;
        }

        void primaryVal(Event vunUNUNVUnv) {
            try {
                Object[] objectArray = new Object[1];
                objectArray[0] = vunUNUNVUnv;
                this.secondaryVal.invoke(this.primaryVal, objectArray);
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}

