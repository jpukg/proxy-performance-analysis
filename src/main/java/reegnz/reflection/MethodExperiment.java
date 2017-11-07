package reegnz.reflection;

import java.lang.ReflectiveOperationException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.function.Supplier;

class MethodExperiment {

	public static class Invocation {
		final Object instance;
		final Object[] args;
		private Invocation(Object instance, Object... args) {
			this.instance = instance;
			this.args = args;
		}
		public static Invocation create(Object instance, Object... args) {
			return new Invocation(instance, args);
		}
	}

	public static class MethodLookup {
		final Class<?> targetType;
		final String methodName;
		final Class[] argTypes;
		private MethodLookup(Class<?> targetType, String methodName, Class... argTypes) {
			this.targetType = targetType;
			this.methodName = methodName;
			this.argTypes = argTypes;
		}
		public static MethodLookup create(Class<?> targetType, String methodName, Class... argTypes) {
			return new MethodLookup(targetType, methodName, argTypes);
		}
	}

	private final Exporter exporter;

	MethodExperiment(Exporter exporter) {
		this.exporter = exporter;
	}

	void doExperiment(MethodLookup lookup, Supplier<Invocation> invocation) {
		Method method = getMethod(lookup.targetType, lookup.methodName, lookup.argTypes);
		Object delegate = getMethodDelegate(method, invocation);
		exporter.export(delegate.getClass());
	}

	private Object getMethodDelegate(Method method, Supplier<Invocation> invocation) {
		doWork(method, invocation);
		return getDelegate(method);
	}

	private void doWork(Method method, Supplier<Invocation> invocation) {
		for(int i = 0; i < 20; i++) {
			invoke(method, invocation.get());
		}
	}


	private Object invoke(Method method, Invocation invocation) {
		try {
			return method.invoke(invocation.instance, invocation.args);
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}

	private Method getMethod(Class<?> target, String name, Class... argTypes) {
		try {
			return target.getMethod(name, argTypes);
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}

	private Object getDelegate(Method method) {
		Object accessor = getField(method, "methodAccessor");
		return getField(accessor, "delegate");
	}

	private Object getField(Object object, String fieldName) {
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(object);
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}

	}
}
