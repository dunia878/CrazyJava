package io;

import java.io.File;
import java.io.IOException;
<<<<<<< HEAD
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.NEW;
=======
import java.sql.Time;
>>>>>>> refs/remotes/origin/master

public class FileTest {

	public static void main(String[] args) throws IOException {
		File file = new File("b.mp4");
		System.out.println(file.getAbsoluteFile().getPath());
		System.out.println(file.lastModified());
		System.out.println(new Time(file.lastModified()));
		System.out.println(file.length());
<<<<<<< HEAD
		File tempFile = file.createTempFile("linux", ".tmp", new File("."));
=======
		File tempFile = File.createTempFile("linux", ".tmp", new File("."));
>>>>>>> refs/remotes/origin/master
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
