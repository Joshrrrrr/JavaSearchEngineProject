/*
 Generic FileProcessor Class I made in earlier weeks
 */

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
	
	/*public void writeToFile(String writethisline){
		try {
			PrintWriter myWriter = new PrintWriter(getFilename());
			myWriter.println(writethisline);
			myWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public String readFile(File filename){
		FileReader reader=null;
		try {
			reader = new FileReader(filename);	//Uses FIleReader java class to read contents of file to string
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String strLine = "";
		
		
		try {
			//System.out.println(reader.ready());
			int i;
		    while ((i=reader.read()) != -1)
		      strLine+=(char)i; //write to string while contents of file remaining
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return strLine; //returns string to Search java calls
    }
	
}
