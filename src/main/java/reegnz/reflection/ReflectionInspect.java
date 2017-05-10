package reegnz.reflection;

import java.io.File;
import net.bytebuddy.agent.ByteBuddyAgent;

public class ReflectionInspect {

	private final ProxyExperiment proxyExperiment;
	private final MethodExperiment methodExperiment;

	private ReflectionInspect(ProxyExperiment proxyExperiment, MethodExperiment methodExperiment) {
		this.proxyExperiment = proxyExperiment;
		this.methodExperiment = methodExperiment;
	}

	private void doExperiments() {
		proxyExperiment.doExperiments();
		methodExperiment.doExperiments();
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

}
