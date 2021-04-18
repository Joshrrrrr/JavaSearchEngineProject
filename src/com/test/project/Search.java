package com.test.project;

import java.nio.charset.StandardCharsets;

public class Search {
	String SearchTerm;
	String lines = null;
	int numMatches=0;

	boolean CaseSens =false;
	boolean PhraseMatch =false;

	String utf8EncodedString = null;
	String finalString = null;
	String filename = "Sample2.txt";
	FileProcessor NewFile = new FileProcessor(filename);
	
	Search(){
		lines=NewFile.readFile();
		
		byte[] bytes = lines.getBytes(StandardCharsets.UTF_8);

		setUtf8EncodedString(new String(bytes, StandardCharsets.UTF_8));
		finalString = utf8EncodedString.replace("\n", "");
		System.out.println(finalString);
	}
	
	public boolean checkContents(){
		if(PhraseMatch == true){
			if(CaseSens == false){
				if(getLines().toLowerCase().contains(getSearchTerm().toLowerCase())){
					addMatch(1);
					return true;
				}else
					return false;
			}
			else{
				if(getLines().contains(getSearchTerm())){
					addMatch(1);
					return true;
				}else
					return false;
			}
		}else{
			
			
		}
		return false;
		
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
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
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

}
