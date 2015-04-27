package io;

import java.io.File;
import java.io.IOException;
import java.sql.Time;

public class FileTest {

	public static void main(String[] args) throws IOException {
		File file = new File("b.mp4");
		System.out.println(file.getAbsoluteFile().getPath());
		System.out.println(file.lastModified());
		System.out.println(new Time(file.lastModified()));
		System.out.println(file.length());
		File tempFile = File.createTempFile("linux", ".tmp", new File("."));
		tempFile.deleteOnExit();
		file = new File(".");
		String[] fileList = file.list();
		for (String string : fileList) {
			System.out.println(string);
			
		}
		System.out.println("=====================");
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			System.out.println(file2.getAbsolutePath());
		}
	}

}
