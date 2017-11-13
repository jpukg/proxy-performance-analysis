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
