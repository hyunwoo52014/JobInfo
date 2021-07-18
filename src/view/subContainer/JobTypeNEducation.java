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
	public JRadioButton[] Jobtypebuttons;
	public ArrayList<JRadioButton> Edubuttons;
	
	public JobTypeNEducation() {
		SpringLayout sl = new SpringLayout();
		setLayout(sl);
		setPreferredSize(new Dimension(600, 200));
		
		JLabel label = new JLabel("근무 형태");
		add(label);
		
		JPanel jobtype = addJopType();
		add(jobtype);
		
		JLabel label2 = new JLabel("학력");
		add(label2);
		
		JPanel education = addEducation();
		add(education);

		sl.putConstraint(SpringLayout.NORTH, jobtype, 0, SpringLayout.SOUTH, label);
		
		sl.putConstraint(SpringLayout.NORTH, label2, 0, SpringLayout.SOUTH, jobtype);
		
		sl.putConstraint(SpringLayout.NORTH, education, 0, SpringLayout.SOUTH, label2);
		
	}
	
	private JPanel addJopType() {
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5, 5));
		jp.setPreferredSize(new Dimension(600,100));
		
		JobTypeName n = JobTypeName.JobTypeName1;
		this.bgjobtype = new ButtonGroup();
		this.Jobtypebuttons = new JRadioButton[n.returnLength()];
		
		for(int i = 0 ; i < n.returnLength(); i++) {
			this.Jobtypebuttons[i] = new JRadioButton(n.returnNameTagFromNumber(i));
			this.bgjobtype.add(this.Jobtypebuttons[i]);
			jp.add(this.Jobtypebuttons[i]);
		}
		
		return jp;
	}
	
	private JPanel addEducation() {
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2, 4));
		jp.setPreferredSize(new Dimension(600, 50));
		
		this.edubg = new ButtonGroup();
		this.Edubuttons = new ArrayList<JRadioButton>();
		
		for(EducationName en : EducationName.values()) {
			Edubuttons.add(new JRadioButton(en.getNameTag()));
		}
		
		for(int i = 0; i < Edubuttons.size(); i++) {
			edubg.add(this.Edubuttons.get(i));
			jp.add(this.Edubuttons.get(i));
		}
		
		return jp;
	}
	
	public String getJobTypeCode() {
		String result = null;
		JobTypeName jtn = JobTypeName.JobTypeALL;
		String nameTag = null;
		
		for(int i = 0; i < this.Jobtypebuttons.length; i++) {
			
			if(this.Jobtypebuttons[i].isSelected() && !this.Jobtypebuttons[i].getText().equalsIgnoreCase("전체")) {
				nameTag = this.Jobtypebuttons[i].getText();
				result = "";
				result += String.valueOf(jtn.returnNumberFromNameTag(nameTag));
				break;
			}
			
			if(this.Jobtypebuttons[i].isSelected() && this.Jobtypebuttons[i].getText().equalsIgnoreCase("전체")) {
				break;
			}
		}
		
		return result;
	}
	
	public String getEduCode() {
		String result = null;
		EducationName en = EducationName.EDNALL;
		String nameTag = null;
		
		for(int i = 0; i < this.Edubuttons.size(); i++) {
			
			if(this.Edubuttons.get(i).isSelected() && !this.Edubuttons.get(i).getText().equalsIgnoreCase("전체")) {
				nameTag = this.Edubuttons.get(i).getText();
				result = "";
				result += String.valueOf(en.returnNumberFromNameTag(nameTag));
				break;
			}
			
			if(this.Edubuttons.get(i).isSelected() && this.Edubuttons.get(i).getText().equalsIgnoreCase("전체")) {
				break;
			}
		}
		
		return result;
	}

}