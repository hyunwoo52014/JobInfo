package view;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import view.subContainer.JobTypeNEducation;
import view.subContainer.LocalIndustryJobCategoryCodelist;
import view.subContainer.OptionalItem;
import view.subContainer.SaraminRecruitmentOption;
import view.subContainer.SearchWindows;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpringLayout sl = new SpringLayout();
	
	public MainWindow() {
		setLayout(sl);
		setTitle("Saramin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 1000);
		
		SearchWindows sw = new SearchWindows();
		SaraminRecruitmentOption sro = new SaraminRecruitmentOption();
		JobTypeNEducation jtne = new JobTypeNEducation();
		LocalIndustryJobCategoryCodelist lijccl = new LocalIndustryJobCategoryCodelist();
		OptionalItem oi = new OptionalItem();
		
		add(sw);
		add(sro);
		add(jtne);
		add(lijccl);
		add(oi);
		
		this.sl.putConstraint(SpringLayout.WEST, sw, 5, SpringLayout.WEST, this.getContentPane());
		this.sl.putConstraint(SpringLayout.NORTH, sw, 5, SpringLayout.NORTH, this.getContentPane());
		
		this.sl.putConstraint(SpringLayout.NORTH, sro, 5, SpringLayout.NORTH, this.getContentPane());
		this.sl.putConstraint(SpringLayout.NORTH, sro, 5, SpringLayout.SOUTH, sw);
		
		this.sl.putConstraint(SpringLayout.NORTH, jtne, 5, SpringLayout.NORTH, this.getContentPane());
		this.sl.putConstraint(SpringLayout.NORTH, jtne, 5, SpringLayout.SOUTH, sro);
		
		this.sl.putConstraint(SpringLayout.NORTH, lijccl, 5, SpringLayout.NORTH, this.getContentPane());
		this.sl.putConstraint(SpringLayout.NORTH, lijccl, 5, SpringLayout.SOUTH, jtne);
		
		this.sl.putConstraint(SpringLayout.NORTH, oi, 5, SpringLayout.NORTH, this.getContentPane());
		this.sl.putConstraint(SpringLayout.NORTH, oi, 5, SpringLayout.SOUTH, lijccl);
		
	}
	
	public void setThisWindowVisible(boolean b) {
		if(b == true) {
			setVisible(true);
		} else {
			setVisible(false);
		}
	}
	
	
}
