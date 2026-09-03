/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import ru.metaculture.protection.CancellableEvent;
import ru.metaculture.protection.Event;
import ru.metaculture.protection.EventPriority;
import ru.metaculture.protection.Subscribe;

public class EventManager {
    private static final Map<Class<? extends Event>, Listener[]> listenersByEventType = new ConcurrentHashMap<Class<? extends Event>, Listener[]>();
    private static boolean cleared = false;
    private static int reservedUnused = 0;

    public static void register(Object object) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (EventManager.isNotHandler(method)) continue;
            EventManager.register(method, object);
        }
    }

    public static void unregister(Object object) {
        for (Map.Entry<Class<? extends Event>, Listener[]> entry : listenersByEventType.entrySet()) {
            Listener[] listeners = entry.getValue();
            int n = 0;
            for (int i = 0; i < listeners.length; ++i) {
                if (listeners[i].owner().equals(object)) continue;
                ++n;
            }
            if (n == listeners.length) continue;
            if (n == 0) {
                listenersByEventType.remove(entry.getKey(), listeners);
                continue;
            }
            Listener[] remaining = new Listener[n];
            int n2 = 0;
            for (int i = 0; i < listeners.length; ++i) {
                if (listeners[i].owner().equals(object)) continue;
                remaining[n2++] = listeners[i];
            }
            listenersByEventType.put(entry.getKey(), remaining);
        }
        EventManager.clearIfEmpty(true);
    }

    private static void register(Method method, Object object) {
        try {
            Listener[] existing;
            Class<? extends Event> clazz = (Class<? extends Event>)method.getParameterTypes()[0];
            Listener listener = new Listener(object, method, method.getAnnotation(Subscribe.class).priority());
            if (!listener.method().isAccessible()) {
                listener.method().setAccessible(true);
            }
            if ((existing = listenersByEventType.get(clazz)) != null) {
                for (int i = 0; i < existing.length; ++i) {
                    if (!existing[i].equals(listener)) continue;
                    return;
                }
                Listener[] expanded = new Listener[existing.length + 1];
                System.arraycopy(existing, 0, expanded, 0, existing.length);
                expanded[existing.length] = listener;
                listenersByEventType.put(clazz, EventManager.sortByPriority(expanded));
            } else {
                listenersByEventType.put(clazz, new Listener[]{listener});
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void clearIfEmpty(boolean bl) {
        if (!bl) {
            listenersByEventType.clear();
            return;
        }
        for (Map.Entry<Class<? extends Event>, Listener[]> entry : listenersByEventType.entrySet()) {
            Listener[] listeners = entry.getValue();
            if (listeners != null && listeners.length != 0) continue;
            listenersByEventType.remove(entry.getKey(), listeners);
        }
    }

    private static boolean isNotHandler(Method method) {
        return method.getParameterTypes().length != 1 || !method.isAnnotationPresent(Subscribe.class);
    }

    public static void init() {
    }

    public static Event post(Event event) {
        block5: {
            Listener[] listeners = listenersByEventType.get(event.getClass());
            if (listeners == null || listeners.length <= 0) break block5;
            if (event instanceof CancellableEvent) {
                CancellableEvent cancellableEvent = (CancellableEvent)event;
                for (int i = 0; i < listeners.length; ++i) {
                    EventManager.invoke(listeners[i], event);
                    if (!cancellableEvent.marginVal()) {
                        continue;
                    }
                    break;
                }
            } else {
                for (int i = 0; i < listeners.length; ++i) {
                    EventManager.invoke(listeners[i], event);
                }
            }
        }
        return event;
    }

    private static Listener[] sortByPriority(Listener[] listeners) {
        Arrays.sort(listeners, (a, b) -> Integer.compare(EventManager.priorityIndex(a.priority()), EventManager.priorityIndex(b.priority())));
        return listeners;
    }

    private static int priorityIndex(byte priority) {
        for (int i = 0; i < EventPriority.ORDER.length; ++i) {
            if (EventPriority.ORDER[i] != priority) continue;
            return i;
        }
        return EventPriority.ORDER.length;
    }

    private static void invoke(Listener listener, Event event) {
        block3: {
            try {
                listener.method().invoke(listener.owner(), event);
            }
            catch (IllegalAccessException | IllegalArgumentException exception) {
                System.err.println("[EventManager] Failed to invoke " + listener.method().getName() + " on " + listener.owner().getClass().getSimpleName() + ": " + exception.getMessage());
            }
            catch (InvocationTargetException invocationTargetException) {
                Throwable throwable = invocationTargetException.getCause();
                System.err.println("[EventManager] Exception in handler " + listener.method().getName() + " on " + listener.owner().getClass().getSimpleName() + ": " + (throwable != null ? throwable.getMessage() : invocationTargetException.getMessage()));
                if (throwable == null) break block3;
                throwable.printStackTrace();
            }
        }
    }

    static final class Listener {
        private final Object owner;
        private final Method method;
        private final byte priority;

        public Listener(Object owner, Method method, byte priority) {
            this.owner = owner;
            this.method = method;
            this.priority = priority;
        }

        public Object owner() {
            return this.owner;
        }

        public Method method() {
            return this.method;
        }

        public byte priority() {
            return this.priority;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            Listener other = (Listener)object;
            return this.priority == other.priority && this.owner.equals(other.owner) && this.method.equals(other.method);
        }

        public int hashCode() {
            Object[] objectArray = new Object[3];
            objectArray[0] = this.owner;
            objectArray[1] = this.method;
            objectArray[2] = this.priority;
            return Objects.hash(objectArray);
        }
    }
}
