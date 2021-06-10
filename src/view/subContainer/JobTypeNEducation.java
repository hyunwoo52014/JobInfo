package view.subContainer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

import keywords.EducationName;
import keywords.JobTypeName;

public class JobTypeNEducation extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8640253159178390263L;
	private ButtonGroup bgjobtype;
	private ButtonGroup edubg;
	private JRadioButton[] jobtypebuttons;
	private ArrayList<JRadioButton> edubuttons;
	
	public JobTypeNEducation() {
		SpringLayout sl = new SpringLayout();
		setLayout(sl);
		setPreferredSize(new Dimension(600, 160));
		
		JLabel label = new JLabel("근무 형태");
		add(label);
		
		JPanel jobtype = addJopType();
		add(jobtype);
		
		JLabel label2 = new JLabel("학력");
		add(label2);
		
		JPanel education = addEducation();
		add(education);
		
		sl.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, this);
		
		sl.putConstraint(SpringLayout.NORTH, jobtype, 0, SpringLayout.SOUTH, label);
		sl.putConstraint(SpringLayout.WEST, jobtype, 5, SpringLayout.WEST, this);
		
		sl.putConstraint(SpringLayout.NORTH, label2, 5, SpringLayout.SOUTH, jobtype);
		sl.putConstraint(SpringLayout.WEST, label2, 10, SpringLayout.WEST, this);
		
		sl.putConstraint(SpringLayout.NORTH, education, 0, SpringLayout.SOUTH, label2);
		sl.putConstraint(SpringLayout.WEST, education, 5, SpringLayout.WEST, this);
	}
	
	private JPanel addJopType() {
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5, 5));
		jp.setPreferredSize(new Dimension(600,100));
		
		JobTypeName n = JobTypeName.JobTypeName1;
		bgjobtype = new ButtonGroup();
		jobtypebuttons = new JRadioButton[n.returnLength()+1];
		
		JRadioButton first = new JRadioButton("전체");
		bgjobtype.add(first);
		jp.add(first);
		
		for(int i = 1 ; i <= n.returnLength(); i++) {
			jobtypebuttons[i] = new JRadioButton(n.returnString(i));
			bgjobtype.add(jobtypebuttons[i]);
			jp.add(jobtypebuttons[i]);
		}
		
		return jp;
	}
	
	private JPanel addEducation() {
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2, 4));
		jp.setPreferredSize(new Dimension(500, 50));
		
		edubg = new ButtonGroup();
		edubuttons = new ArrayList<JRadioButton>();
		
		JRadioButton first = new JRadioButton("전체");
		edubg.add(first);
		jp.add(first);
		
		for(EducationName en : EducationName.values()) {
			edubuttons.add(new JRadioButton(en.getName()));
		}
		
		for(int i = 0; i < edubuttons.size(); i++) {
			edubg.add(this.edubuttons.get(i));
			jp.add(this.edubuttons.get(i));
		}
		
		return jp;
	}
}
