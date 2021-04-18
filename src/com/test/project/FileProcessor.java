package com.test.project;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

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
		FileReader reader=null;
		try {
			reader = new FileReader(fileExample);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String strLine = "";
		
		
		try {
			//System.out.println(reader.ready());
			int i;
		    while ((i=reader.read()) != -1)
		      strLine+=(char)i;
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return strLine;
    }
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
