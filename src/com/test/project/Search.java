/*
 Creates FileProccesor Class passes the file and receives the returned string
 */

package com.test.project;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

public class Search {
	String SearchTerm;
	String fileString = null;
	int numMatches=0;
	ArrayList<File> fileQ=new ArrayList<File>();
	ArrayList<Boolean> resultBool=new ArrayList<Boolean>();
	boolean CaseSens =false;
	boolean PhraseMatch =false;

	String utf8EncodedString = null;
	String finalString = null;
	//String filename = "Sample2.txt";
	File filename;
	FileProcessor NewFile = new FileProcessor();
	
	Search(){
		
	}
	public void searchRead(){
		fileString=NewFile.readFile(getFilename()); //Calls FIleProcessor object to get file as string 
		
		byte[] bytes = fileString.getBytes(StandardCharsets.UTF_8);

		setUtf8EncodedString(new String(bytes, StandardCharsets.UTF_8));
		finalString = utf8EncodedString.replace("\n", "");	//Removes garbage from string with UTF
		System.out.println(finalString); //Prints the contents of file to console
	}
	
	public boolean checkAll(int i){		//The method that is called by GUI
		System.out.println(getFileQ().get(i));	//Prints current file path to console
		setFilename(getFileQ().get(i));
		this.searchRead();	//Calls it's own seachRead method to convert the current file to string
		setResultBool(checkContents());	//Mostly unused code that was tested
		if(getResultBool().equals(true)){
			return true;
		}else
			return false;
	}
	
	public boolean checkContents(){	//Uses common lang method to count occurrences and creates dialog boxes with the count and file info for the user
		if(PhraseMatch == true){	//With phrase match on it matches all the input to the file string	
			if(getLines().contains(getSearchTerm())){
				setNumMatches(StringUtils.countMatches(getLines(), getSearchTerm()));
				JOptionPane.showMessageDialog(null,"\""+getSearchTerm()+"\" appeared "+ StringUtils.countMatches(getLines(),getSearchTerm())+" times "+" in "+getFilename());
				return true;
			}else
				JOptionPane.showMessageDialog(null,"No match for search term \""+getSearchTerm()+"\" in the files "+getFilename());
				return false;
		}else{	//With it off I split the input string into words where there is a space and matches those in a for loop to the file string
			if(CaseSens == false){ //case sensitive
				if(getLines().toLowerCase().contains(getSearchTerm().toLowerCase())){
					String[] splitString = getSearchTerm().split(",");
					for(int i=0;i<splitString.length;i++){
						setNumMatches(StringUtils.countMatches(getLines().toLowerCase(), splitString[i]));
						JOptionPane.showMessageDialog(null,"\""+splitString[i]+"\" appeared "+ StringUtils.countMatches(getLines().toLowerCase(), splitString[i])+" times "+" in "+getFilename());
					}
					
					return true;
				}else
					JOptionPane.showMessageDialog(null,"No match for search term \""+getSearchTerm()+"\" in the files "+getFilename());
					return false;
			} //no case sensitive
			else{
				if(getLines().contains(getSearchTerm())){
					setNumMatches(StringUtils.countMatches(getLines(), getSearchTerm()));
					JOptionPane.showMessageDialog(null,"\""+getSearchTerm()+"\" appeared "+ StringUtils.countMatches(getLines(),getSearchTerm())+" times "+" in "+getFilename());
					return true;
				}else
					JOptionPane.showMessageDialog(null,"No match for search term \""+getSearchTerm()+"\" in the files "+getFilename());
					return false;
			}
			
		}
	}	//Getters and setters
	public ArrayList<Boolean> getResultBool() {
		return resultBool;
	}
	public void setResultBool(boolean bool) {
		resultBool.add(bool);
	}
	public String getLines() {
		return finalString;
	}
	public void setUtf8EncodedString(String utf8EncodedString) {
		this.utf8EncodedString = utf8EncodedString;
	}

	public String getSearchTerm() {
		return this.SearchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.SearchTerm = searchTerm;
	}
	public String toString(){
		return "";
	}
	
	public File getFilename() {
		return filename;
	}

	public void setFilename(File filenamer) {
		filename= new File(filenamer.toString());;
	}
	public boolean isCaseSens() {
		return CaseSens;
	}

	public void setCaseSens(boolean caseSens) {
		this.CaseSens = caseSens;
	}
	public int getNumMatches() {
		return numMatches;
	}

	public void setNumMatches(int numMatches) {
		this.numMatches = numMatches;
	}
	public void addMatch(int numMatches) {
		this.numMatches += numMatches;
	}
	public boolean isPhraseMatch() {
		return PhraseMatch;
	}

	public void setPhraseMatch(boolean phraseMatch) {
		PhraseMatch = phraseMatch;
	}
	public ArrayList<File> getFileQ() {
		return fileQ;
	}
	public void setFileQ(File fileQueue) {
		fileQ.add(fileQueue);
	}

}
