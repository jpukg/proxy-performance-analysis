/**
 * Copyright (c) 2017 Zoltán Reegn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
