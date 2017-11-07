package reegnz.reflection;

import java.io.File;
import java.lang.Iterable;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import net.bytebuddy.agent.ByteBuddyAgent;

import reegnz.reflection.MethodExperiment.Invocation;
import reegnz.reflection.MethodExperiment.MethodLookup;

public class ReflectionInspect {

	private final ProxyExperiment proxyExperiment;
	private final MethodExperiment methodExperiment;

	private ReflectionInspect(ProxyExperiment proxyExperiment, MethodExperiment methodExperiment) {
		this.proxyExperiment = proxyExperiment;
		this.methodExperiment = methodExperiment;
	}

	private void doExperiments() {
		exportProxies();
		exportMethodAccessors();
	}


	public static void main(String... args) {
		ByteBuddyAgent.install();
		File exportDir = new File("exported");
		exportDir.mkdirs();
		File decompileDir = new File("decompiled");
		decompileDir.mkdirs();
		Exporter exporter = new Exporter(exportDir, decompileDir);
		ProxyExperiment proxy = new ProxyExperiment(exporter);
		MethodExperiment method = new MethodExperiment(exporter);
		new ReflectionInspect(proxy, method).doExperiments();
	}

	private void exportProxy(String interfaceName) {
		proxyExperiment.doExperiment(interfaceName);
	}

	private void exportProxies() {
		proxyExperiment.doExperiment("java.lang.Iterable");
		proxyExperiment.doExperiment("java.util.Iterator");
		proxyExperiment.doExperiment("java.util.Map");
	}

	private void exportMethodAccessors() {
		exportForEach();
		exportGetOrDefault();
	}

	private void exportForEach() {
		Object target = Collections.emptyList();
		Consumer consumer = a -> {};
		Supplier<Invocation> invocation = () -> Invocation.create(target, consumer);
		MethodLookup lookup = MethodLookup.create(Iterable.class, "forEach", Consumer.class);
		methodExperiment.doExperiment(lookup, invocation);
	}

	private void exportGetOrDefault() {
		Map<String, Object> target = Collections.emptyMap();
		String key = "a";
		Object def = new Object();
		Supplier<Invocation> invocation = () -> Invocation.create(target, key, def);
		MethodLookup lookup = MethodLookup.create(Map.class, "getOrDefault", Object.class, Object.class);
		methodExperiment.doExperiment(lookup, invocation);
	}
}
