package ch18;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {

	public static void main(String[] args) throws IOException {
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器： " + systemLoader);
		
		Enumeration<URL> eml = systemLoader.getResources("");
		while (eml.hasMoreElements()) {
			System.out.println(eml.nextElement());
			
		}
		
		ClassLoader extensionLoader = systemLoader.getParent();
		System.out.println("扩展类加载器： " + extensionLoader);
		System.out.println("扩展类加载器的加载路径是：" + System.getProperty("java.ext.dirs"));
		System.out.println("扩展类加载器的parent是： " + extensionLoader.getParent());
	}

}
