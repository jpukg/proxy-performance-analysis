package reegnz.reflection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.ClassFileLocator.AgentBased;
import net.bytebuddy.dynamic.ClassFileLocator.Resolution;

import org.benf.cfr.reader.Main;

public class Exporter {

	
	private final File exportDir;

	private final File decompileDir;
	
	Exporter(File exportDir, File decompileDir) {
		this.exportDir = exportDir;
		this.decompileDir = decompileDir;
	}

	public void export(Class<?> clazz) {
		File classFile = saveByteCode(clazz);
		decompileByteCode(classFile);
	}

	private File saveByteCode(Class<?> clazz) {
		byte[] bytes = getByteCode(clazz);
		File file = getClassFile(clazz);
		writeToFile(bytes, file);
		return file;
	}

	private byte[] getByteCode(Class<?> clazz) {
		try {
			String className = clazz.getName();
			ClassLoader classLoader = clazz.getClassLoader();
			ClassFileLocator locator = ClassFileLocator.AgentBased.fromInstalledAgent(classLoader);
			Resolution resolution = locator.locate(className);
			return resolution.resolve();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private File getClassFile(Class<?> clazz) {
		return new File(exportDir, clazz.getSimpleName() + ".class");
	}

	private void writeToFile(byte[] bytes, File file) {
		try (OutputStream os = new FileOutputStream(file)) {
			os.write(bytes);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void decompileByteCode(File fileName) {
		Main.main(new String[] {
			fileName.toString(),
			"--outputpath", decompileDir.toString(),
			"--clobber", "true"
		});
	}
}
