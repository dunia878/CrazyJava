package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		File folder = new File("c:\\a b\\");
		try{
			folder.mkdir();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		File file = new File("c:\\a b\\c d.txt");
		
		try (FileWriter fw = new FileWriter(file);) {
			fw.append("abc");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
