package com.test.project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessor {
	String filename;
	File fileExample;
	FileProcessor(String filename){
		setFilename(filename);
		fileExample = new File(filename);
	}
	public void writeToFile(String writethisline){
		try {
			PrintWriter myWriter = new PrintWriter(fileExample);
			myWriter.println(writethisline);
			myWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String readFile(){
		String read ="";
		try {
			Scanner myScanner = new Scanner(fileExample);
			while(myScanner.hasNextLine()){
				read+=myScanner.nextLine();
			}
			myScanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return read;
	}
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
