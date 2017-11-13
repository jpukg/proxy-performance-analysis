/*
 * Decompiled with CFR 0_123.
 */
package sun.reflect;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;
import sun.reflect.MethodAccessorImpl;

public class GeneratedMethodAccessor1
extends MethodAccessorImpl {
    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object invoke(Object object, Object[] arrobject) throws InvocationTargetException {
        if (object == null) {
            throw new NullPointerException();
        }
        try {
            if (arrobject.length != 1) {
                throw new IllegalArgumentException();
            }
            ((Iterable)object).forEach((Consumer)arrobject[0]);
            return null;
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            throw new IllegalArgumentException(Object.super.toString());
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}
