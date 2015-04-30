package net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class LegDdesc {

	public LegDdesc() {
		// TODO Auto-generated constructor stub
	}
	
	static void MakeDesc(){
		try(
				FileReader frFileNames = new FileReader(new File("f:\\filename.txt"));
				BufferedReader br = new BufferedReader(frFileNames);
				){
			String temp;
			while((temp = br.readLine()) != null){
				String[] nameAndDesc = temp.split("gengname");
//				System.out.println(nameAndDesc[0] + "      " + nameAndDesc[1]);
				try(FileWriter fw = new FileWriter(new File("f:\\a\\" + nameAndDesc[0] + "\\" + "___desc.txt"));){
					fw.append(nameAndDesc[1]);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LegDdesc.MakeDesc();
	}

}
