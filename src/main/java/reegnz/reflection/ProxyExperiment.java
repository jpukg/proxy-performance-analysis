package reegnz.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class ProxyExperiment {

	private final Exporter exporter;

	ProxyExperiment(Exporter exporter) {
		this.exporter = exporter;
	}

	void doExperiment(String interfaceName) {
		try {
			process(Class.forName(interfaceName));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private void process(Class<?> clazz) {
		Class<?> proxy = createProxyClass(clazz);
		exporter.export(proxy);
	}

	private Class<?> createProxyClass(Class<?> clazz) {
		ClassLoader cl = NoopInvocationHandler.class.getClassLoader();
		Class[] ifc = new Class[] { clazz };
		InvocationHandler ih = new NoopInvocationHandler();
		Object proxy = Proxy.newProxyInstance(cl, ifc, ih);
		return proxy.getClass();
	}

	private static class NoopInvocationHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) {
			return null;
		}
	}
}
