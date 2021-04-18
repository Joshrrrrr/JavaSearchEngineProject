package com.test.project;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchGUI extends JFrame implements ActionListener {
	JPanel panel;
	JTextField text;
	String searchInput;
	JCheckBox checkbox;
	JCheckBox checkbox2;
	Search TestSearch = new Search();
	SearchGUI (/*String content*/){
		//super(content);
		setSize(600,600);
		setLayout(new FlowLayout());
		panel=new JPanel(new FlowLayout());
		JTextArea TextArea=new JTextArea();
		//TextArea.append(content);
		text=new JTextField("Enter your search");
		text.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setSearchInput(text.getText());
				TestSearch.setSearchTerm(getSearchInput());
				if(TestSearch.checkContents()){
					JOptionPane.showMessageDialog(text,"\""+getSearchInput()+"\" appeared "+ TestSearch.getNumMatches()+" times in the files "+TestSearch.getFilename());
					TestSearch.setNumMatches(0);
				}else
					JOptionPane.showMessageDialog(text,"No match for search term \""+getSearchInput()+"\" in the files "+TestSearch.getFilename());
			}
		});
		checkbox=new JCheckBox("Match case");
		checkbox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        if (checkbox.isSelected()) {
		            TestSearch.setCaseSens(true);
		        } else {
		        	TestSearch.setCaseSens(false);
		        }
		    }
		});
		checkbox2=new JCheckBox("Match phrase");
		checkbox2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        if (checkbox2.isSelected()) {
		            TestSearch.setPhraseMatch(true);
		        } else {
		        	TestSearch.setPhraseMatch(false);
		        }
		    }
		});
		panel.add(text);
		panel.add(TextArea);
		panel.add(checkbox);
		panel.add(checkbox2);
		add(panel);
		setVisible(true);
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
}
