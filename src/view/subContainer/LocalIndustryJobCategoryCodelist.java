package view.subContainer;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import keywords.IndustryCode;
import keywords.JobCategoryCode;
import keywords.LocalCode;

public class LocalIndustryJobCategoryCodelist extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4823515854137605052L;
	private JComboBox<String> localCodes;
	private JComboBox<String> industyCode;
	private JComboBox<String> jobCategoryCode;

	public LocalIndustryJobCategoryCodelist() {
		SpringLayout sl = new SpringLayout();
		setLayout(sl);
		setPreferredSize(new Dimension(400, 160));
		
		JPanel localCodeJP = localCodeList();
		JPanel industryCodeJP = industyCodeList();
		JPanel jobCategoryCodeJP = jobCategoryCodeList();
		
		add(localCodeJP);
		add(industryCodeJP);
		add(jobCategoryCodeJP);
		
		sl.putConstraint(SpringLayout.WEST, localCodeJP, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, localCodeJP, 5, SpringLayout.NORTH, this);
		
		sl.putConstraint(SpringLayout.WEST, industryCodeJP, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, industryCodeJP, 5, SpringLayout.SOUTH, localCodeJP);
		
		sl.putConstraint(SpringLayout.WEST, jobCategoryCodeJP, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, jobCategoryCodeJP, 5, SpringLayout.SOUTH, industryCodeJP);
	}
	
	private JPanel localCodeList() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		JLabel jl = new JLabel("지역");
		this.localCodes = new JComboBox<String>();
		
		for(LocalCode lc : LocalCode.values()) {
			this.localCodes.addItem(lc.getLocalCodeName());
		}
		
		jp.setLayout(sl);
		jp.setPreferredSize(new Dimension(600, 50));
		jp.add(jl);
		jp.add(this.localCodes);

		sl.putConstraint(SpringLayout.WEST, jl, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, jl, 0, SpringLayout.NORTH, this);
		
		sl.putConstraint(SpringLayout.NORTH, this.localCodes, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.WEST, this.localCodes, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, this.localCodes, 0, SpringLayout.SOUTH, jl);
		
		return jp;
	}
	
	private JPanel industyCodeList() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		JLabel jl = new JLabel("업종");
		this.industyCode = new JComboBox<String>();

		for(IndustryCode Ic : IndustryCode.values()) {
			this.industyCode.addItem(Ic.getIndCodeName());
		}
		
		jp.setLayout(sl);
		jp.setPreferredSize(new Dimension(600, 50));
		jp.add(jl);
		jp.add(this.industyCode);
		
		sl.putConstraint(SpringLayout.WEST, jl, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, jl, 0, SpringLayout.NORTH, this);
		
		sl.putConstraint(SpringLayout.NORTH, this.industyCode, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.WEST, this.industyCode, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, this.industyCode, 0, SpringLayout.SOUTH, jl);
		
		return jp;
	}
	
	private JPanel jobCategoryCodeList() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		JLabel jl = new JLabel("직종");
		this.jobCategoryCode = new JComboBox<String>();
		
		for(JobCategoryCode jcc : JobCategoryCode.values()) {
			this.jobCategoryCode.addItem(jcc.getJobTypeName());
		}
		
		jp.setLayout(sl);
		jp.setPreferredSize(new Dimension(600, 50));
		jp.add(jl);
		jp.add(this.jobCategoryCode);
		
		sl.putConstraint(SpringLayout.WEST, jl, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, jl, 0, SpringLayout.NORTH, this);
		
		sl.putConstraint(SpringLayout.NORTH, this.jobCategoryCode, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.WEST, this.jobCategoryCode, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, this.jobCategoryCode, 0, SpringLayout.SOUTH, jl);
		
		return jp;
	}
}
