package reegnz.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NoopInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		return null;
	}
}
