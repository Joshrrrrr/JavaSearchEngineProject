package com.test.project;

public class Search {
	String SearchTerm;
	FileProcessor NewFile = new FileProcessor("Sample1.txt");
	String str=NewFile.readFile();
	Search(String SearchTerm){
		setSearchTerm(SearchTerm);
		
	}
	public void FindTerm() {
		
	}
	public String getSearchTerm() {
		return SearchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		SearchTerm = searchTerm;
	}
	public String toString(){
		return "Opened file";
	}

}
