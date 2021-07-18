package view;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import view.subContainer.JobTypeNEducation;
import view.subContainer.LocalIndustryJobCategoryCodelist;
import view.subContainer.OptionalItem;
import view.subContainer.SaraminRecruitmentOption;
import view.subContainer.SearchWindows;
import works.BackGroundTaskCollection;

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
		setResizable(false);
		setSize(660, 700);
		
		SearchWindows sw = BackGroundTaskCollection.getInstance().SearchWindows;
		SaraminRecruitmentOption sro = BackGroundTaskCollection.getInstance().SaraminRecruitmentOption;
		JobTypeNEducation jtne = BackGroundTaskCollection.getInstance().JobTypeNEducation;
		LocalIndustryJobCategoryCodelist lijccl = BackGroundTaskCollection.getInstance().LocalIndustryJobCategoryCodelist;
		OptionalItem oi = BackGroundTaskCollection.getInstance().OptionalItem;
		
		add(sw);
		add(sro);
		add(jtne);
		add(lijccl);
		add(oi);
		
		this.sl.putConstraint(SpringLayout.WEST, sro, 5, SpringLayout.WEST, this);
		this.sl.putConstraint(SpringLayout.NORTH, sro, 0, SpringLayout.SOUTH, sw);
		
		this.sl.putConstraint(SpringLayout.WEST, jtne, 5, SpringLayout.WEST, this);
		this.sl.putConstraint(SpringLayout.NORTH, jtne, 0, SpringLayout.SOUTH, sro);
		
		this.sl.putConstraint(SpringLayout.WEST, lijccl, 5, SpringLayout.WEST, this);
		this.sl.putConstraint(SpringLayout.NORTH, lijccl, 0, SpringLayout.SOUTH, jtne);
		
		this.sl.putConstraint(SpringLayout.WEST, oi, 5, SpringLayout.WEST, this);
		this.sl.putConstraint(SpringLayout.NORTH, oi, 0, SpringLayout.SOUTH, lijccl);
		
	}
	
	public void setThisWindowVisible(boolean b) {
		if(b == true) {
			setVisible(true);
		} else {
			setVisible(false);
		}
	}
	
	
}
