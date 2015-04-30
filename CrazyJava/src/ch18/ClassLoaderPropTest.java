package ch18;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {

	public static void main(String[] args) throws IOException {
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("ϵͳ��������� " + systemLoader);
		
		Enumeration<URL> eml = systemLoader.getResources("");
		while (eml.hasMoreElements()) {
			System.out.println(eml.nextElement());
			
		}
		
		ClassLoader extensionLoader = systemLoader.getParent();
		System.out.println("��չ��������� " + extensionLoader);
		System.out.println("��չ��������ļ���·���ǣ�" + System.getProperty("java.ext.dirs"));
		System.out.println("��չ���������parent�ǣ� " + extensionLoader.getParent());
	}

}
