/*
 Creates the Search class object, passes and receives file information to it and displays it in the GUI
 */


package com.test.project;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchGUI extends JFrame implements ActionListener { //GUI class implements action listener and is composed of JFrame classes
	ArrayList<File> fileQ=new ArrayList<File>();	//fileQ keeps files in a list to be used all at once in Search.java
	int MatchRating=0;	//Rating score that updates inside text action listener
	//ArrayList<String> RatedString= new ArrayList<String>();
	String[] RatedString={"","","",""};	//Rated string allows 4 files to be compared
	JPanel panel;		//GUI elements declared
	JPanel panel2;
	JPanel panel3;
	JButton button;
	JTextField text;
	String searchInput;
	JCheckBox checkbox;
	JCheckBox checkbox2;
	JFileChooser fileChooser;
	JTextArea TextArea2= new JTextArea("File match strength:\n");
	Search TestSearch = new Search();
	SearchGUI (){	//Constructor
		//super(content);
		setSize(1600,1600);		//GUI elements instantiated
		setLayout(new FlowLayout());
		panel=new JPanel(new FlowLayout());
		panel2=new JPanel(new FlowLayout());
		panel3=new JPanel(new FlowLayout());
		JTextArea TextArea=new JTextArea("Unselect match phrase and put a single comma between "
				+ "words to search multiple words at once\nOpen multiple files to search across all"); // Program instruction to user
		text=new JTextField("Enter your search");
		text.setColumns(9);
		text.addActionListener(new ActionListener(){	//Text input box listener
			public void actionPerformed(ActionEvent e) {
				setSearchInput(text.getText());
				TestSearch.setSearchTerm(getSearchInput());
				for(int i=0;i<getFileQ().size();i++){	//Runs all the files in the queue
					TestSearch.checkAll(i);	//The current file and fileQ index is passed to Search.java 
					int j=0;
					if(TestSearch.getNumMatches()>=getMatchRating()){ //If more matches in this file than rating place at current index
						setRatedString(("\n"+getFile()+" appeared "+TestSearch.getNumMatches()).toString(),j);;
						setMatchRating(TestSearch.getNumMatches());
						j++;
					}else	//else place at next index
						setRatedString(("\n"+getFile()+" appeared "+TestSearch.getNumMatches()).toString(),j+1);
						j++;
						TestSearch.setNumMatches(0);
					
				}
				setTextArea2(Arrays.toString(getRatedString()));  //Displays the ordered rated string array
			}
		});
		checkbox=new JCheckBox("Match case");
		checkbox.addActionListener(new ActionListener() {		//Match case box listener
		    public void actionPerformed(ActionEvent event) {
		        if (checkbox.isSelected()) {
		            TestSearch.setCaseSens(true);	//Search class method called
		        } else {
		        	TestSearch.setCaseSens(false);
		        }
		    }
		});
		checkbox2=new JCheckBox("Match phrase");
		checkbox2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {	//Match phrase box listener 
		        if (checkbox2.isSelected()) {
		            TestSearch.setPhraseMatch(true);
		        } else {
		        	TestSearch.setPhraseMatch(false);
		        }
		    }
		});
		
		fileChooser = new JFileChooser();	//I used JFileChooser for user file input
		javax.swing.filechooser.FileFilter textFilefilter = new javax.swing.filechooser.FileFilter() 
		{
		      //Override accept method
		      public boolean accept(File file) {
		              
		             //if the file extension is .txt return true, else false
		             if (file.getName().endsWith(".txt")) {
		                return true;
		             }
		             return false;
		      }
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		fileChooser.setFileFilter(textFilefilter);	//Add my created file filter to the chooser
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	// open file listener
				TestSearch.setFilename(fileChooser.getSelectedFile());;	//Sets all chosen file information and reads chosen file
				setFile(fileChooser.getSelectedFile());
				TestSearch.searchRead();
				setFileQ(fileChooser.getSelectedFile());
				TestSearch.setFileQ(fileChooser.getSelectedFile());
			}
		});
		button = new JButton("Open files");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	//Open more files button listener
				fileChooser.showOpenDialog(panel);
			}
		});
		fileChooser.showOpenDialog(panel);
		//panel.add(fileChooser);
		panel.add(text);		//Add frames to panels
		panel.add(TextArea);
		panel.add(checkbox);
		panel.add(checkbox2);
		panel.add(button);
		add(panel);
		panel2.add(TextArea);
		add(panel2);
		panel3.add(TextArea2);
		add(panel3);
		setVisible(true);
		//System.out.println(getFileQ());
	}
	public String[] getRatedString() {		//Getters and setters
		return RatedString;
	}
	public void setRatedString(String ratedStrings, int i) {
		RatedString[i] = ratedStrings;
	}
	public int getMatchRating() {
		return MatchRating;
	}

	public void setMatchRating(int matchRating) {
		MatchRating = matchRating;
	}
	public String getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(String searchTerm) {
		this.searchInput = searchTerm;
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	File file;
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	public JTextArea getTextArea2() {
		return TextArea2;
	}

	public void setTextArea2(String textArea2) {
		TextArea2.append(textArea2);
	}
	public List<File> getFileQ() {
		return fileQ;
	}

	public void setFileQ(File fileQueue) {
		fileQ.add(fileQueue);
	}
}
