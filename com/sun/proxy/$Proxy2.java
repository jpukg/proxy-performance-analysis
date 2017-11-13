/*
 * Decompiled with CFR 0_123.
 */
package com.sun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public final class $Proxy2
extends Proxy
implements Map {
    private static Method m1;
    private static Method m22;
    private static Method m5;
    private static Method m3;
    private static Method m4;
    private static Method m18;
    private static Method m0;
    private static Method m7;
    private static Method m15;
    private static Method m20;
    private static Method m8;
    private static Method m16;
    private static Method m9;
    private static Method m19;
    private static Method m2;
    private static Method m25;
    private static Method m17;
    private static Method m21;
    private static Method m23;
    private static Method m6;
    private static Method m10;
    private static Method m11;
    private static Method m12;
    private static Method m24;
    private static Method m14;
    private static Method m13;

    public $Proxy2(InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m22 = Class.forName("java.util.Map").getMethod("computeIfAbsent", Class.forName("java.lang.Object"), Class.forName("java.util.function.Function"));
            m5 = Class.forName("java.util.Map").getMethod("get", Class.forName("java.lang.Object"));
            m3 = Class.forName("java.util.Map").getMethod("remove", Class.forName("java.lang.Object"));
            m4 = Class.forName("java.util.Map").getMethod("remove", Class.forName("java.lang.Object"), Class.forName("java.lang.Object"));
            m18 = Class.forName("java.util.Map").getMethod("containsValue", Class.forName("java.lang.Object"));
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
            m7 = Class.forName("java.util.Map").getMethod("values", new Class[0]);
            m15 = Class.forName("java.util.Map").getMethod("putAll", Class.forName("java.util.Map"));
            m20 = Class.forName("java.util.Map").getMethod("getOrDefault", Class.forName("java.lang.Object"), Class.forName("java.lang.Object"));
            m8 = Class.forName("java.util.Map").getMethod("clear", new Class[0]);
            m16 = Class.forName("java.util.Map").getMethod("putIfAbsent", Class.forName("java.lang.Object"), Class.forName("java.lang.Object"));
            m9 = Class.forName("java.util.Map").getMethod("isEmpty", new Class[0]);
            m19 = Class.forName("java.util.Map").getMethod("containsKey", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            m25 = Class.forName("java.util.Map").getMethod("merge", Class.forName("java.lang.Object"), Class.forName("java.lang.Object"), Class.forName("java.util.function.BiFunction"));
            m17 = Class.forName("java.util.Map").getMethod("keySet", new Class[0]);
            m21 = Class.forName("java.util.Map").getMethod("forEach", Class.forName("java.util.function.BiConsumer"));
            m23 = Class.forName("java.util.Map").getMethod("computeIfPresent", Class.forName("java.lang.Object"), Class.forName("java.util.function.BiFunction"));
            m6 = Class.forName("java.util.Map").getMethod("put", Class.forName("java.lang.Object"), Class.forName("java.lang.Object"));
            m10 = Class.forName("java.util.Map").getMethod("replace", Class.forName("java.lang.Object"), Class.forName("java.lang.Object"));
            m11 = Class.forName("java.util.Map").getMethod("replace", Class.forName("java.lang.Object"), Class.forName("java.lang.Object"), Class.forName("java.lang.Object"));
            m12 = Class.forName("java.util.Map").getMethod("replaceAll", Class.forName("java.util.function.BiFunction"));
            m24 = Class.forName("java.util.Map").getMethod("compute", Class.forName("java.lang.Object"), Class.forName("java.util.function.BiFunction"));
            m14 = Class.forName("java.util.Map").getMethod("entrySet", new Class[0]);
            m13 = Class.forName("java.util.Map").getMethod("size", new Class[0]);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new NoSuchMethodError(noSuchMethodException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    public final Object remove(Object object) {
        try {
            return this.h.invoke(this, m3, new Object[]{object});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean remove(Object object, Object object2) {
        try {
            return (Boolean)this.h.invoke(this, m4, new Object[]{object, object2});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Object get(Object object) {
        try {
            return this.h.invoke(this, m5, new Object[]{object});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Object put(Object object, Object object2) {
        try {
            return this.h.invoke(this, m6, new Object[]{object, object2});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean equals(Object object) {
        try {
            return (Boolean)this.h.invoke(this, m1, new Object[]{object});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final String toString() {
        try {
            return (String)this.h.invoke(this, m2, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Collection values() {
        try {
            return (Collection)this.h.invoke(this, m7, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int hashCode() {
        try {
            return (Integer)this.h.invoke(this, m0, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void clear() {
        try {
            this.h.invoke(this, m8, null);
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean isEmpty() {
        try {
            return (Boolean)this.h.invoke(this, m9, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Object replace(Object object, Object object2) {
        try {
            return this.h.invoke(this, m10, new Object[]{object, object2});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean replace(Object object, Object object2, Object object3) {
        try {
            return (Boolean)this.h.invoke(this, m11, new Object[]{object, object2, object3});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void replaceAll(BiFunction biFunction) {
        try {
            this.h.invoke(this, m12, new Object[]{biFunction});
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int size() {
        try {
            return (Integer)this.h.invoke(this, m13, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Set entrySet() {
        try {
            return (Set)this.h.invoke(this, m14, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void putAll(Map map) {
        try {
            this.h.invoke(this, m15, new Object[]{map});
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Object putIfAbsent(Object object, Object object2) {
        try {
            return this.h.invoke(this, m16, new Object[]{object, object2});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Set keySet() {
        try {
            return (Set)this.h.invoke(this, m17, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean containsValue(Object object) {
        try {
            return (Boolean)this.h.invoke(this, m18, new Object[]{object});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean containsKey(Object object) {
        try {
            return (Boolean)this.h.invoke(this, m19, new Object[]{object});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Object getOrDefault(Object object, Object object2) {
        try {
            return this.h.invoke(this, m20, new Object[]{object, object2});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void forEach(BiConsumer biConsumer) {
        try {
            this.h.invoke(this, m21, new Object[]{biConsumer});
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Object computeIfAbsent(Object object, Function function) {
        try {
            return this.h.invoke(this, m22, new Object[]{object, function});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Object computeIfPresent(Object object, BiFunction biFunction) {
        try {
            return this.h.invoke(this, m23, new Object[]{object, biFunction});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Object compute(Object object, BiFunction biFunction) {
        try {
            return this.h.invoke(this, m24, new Object[]{object, biFunction});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Object merge(Object object, Object object2, BiFunction biFunction) {
        try {
            return this.h.invoke(this, m25, new Object[]{object, object2, biFunction});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}
