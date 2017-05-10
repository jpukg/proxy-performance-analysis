package reegnz.reflection;

import java.lang.Iterable;
import java.lang.ReflectiveOperationException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

class MethodExperiment {

	private final Exporter exporter;

	MethodExperiment(Exporter exporter) {
		this.exporter = exporter;
	}

	void doExperiments() {
		Object delegate = getMethodDelegate();
		exporter.export(delegate.getClass());
	}

	private Object getMethodDelegate() {
		Method forEach = getMethod(Iterable.class, "forEach", Consumer.class);
		doWork(forEach);
		return getDelegate(forEach);
	}

	private void doWork(Method forEach) {
		List<Object> list = Collections.emptyList();
		Consumer consumer = a -> {};
		for(int i = 0; i < 20; i++) {
			invoke(forEach, list, consumer); 	
		}
	}

	private Object getDelegate(Method method) {
		Object accessor = getField(method, "methodAccessor");
		return getField(accessor, "delegate");
	}

	private Object invoke(Method method, Object target, Object... args) {
		try {
			return method.invoke(target, args);
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
