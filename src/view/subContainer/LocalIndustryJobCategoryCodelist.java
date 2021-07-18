package view.subContainer;

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
	public JComboBox<String> LocalCodesComboBox;
	public JComboBox<String> IndustyCodeComboBox;
	public JComboBox<String> JobCategoryCodeComboBox;

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
		
		sl.putConstraint(SpringLayout.NORTH, industryCodeJP, 0, SpringLayout.SOUTH, localCodeJP);
		
		sl.putConstraint(SpringLayout.NORTH, jobCategoryCodeJP, 0, SpringLayout.SOUTH, industryCodeJP);
	}
	
	private JPanel localCodeList() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		JLabel jl = new JLabel("지역");
		this.LocalCodesComboBox = new JComboBox<String>();
		
		for(LocalCode lc : LocalCode.values()) {
			this.LocalCodesComboBox.addItem(lc.getNameTag());
		}
		
		jp.setLayout(sl);
		jp.setPreferredSize(new Dimension(600, 50));
		jp.add(jl);
		jp.add(this.LocalCodesComboBox);

		sl.putConstraint(SpringLayout.NORTH, this.LocalCodesComboBox, 0, SpringLayout.SOUTH, jl);
		
		return jp;
	}
	
	private JPanel industyCodeList() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		JLabel jl = new JLabel("업종");
		this.IndustyCodeComboBox = new JComboBox<String>();

		for(IndustryCode Ic : IndustryCode.values()) {
			this.IndustyCodeComboBox.addItem(Ic.getNameTag());
		}
		
		jp.setLayout(sl);
		jp.setPreferredSize(new Dimension(600, 50));
		jp.add(jl);
		jp.add(this.IndustyCodeComboBox);
		
		sl.putConstraint(SpringLayout.NORTH, this.IndustyCodeComboBox, 0, SpringLayout.SOUTH, jl);
		
		return jp;
	}
	
	private JPanel jobCategoryCodeList() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		JLabel jl = new JLabel("직종");
		this.JobCategoryCodeComboBox = new JComboBox<String>();
		
		for(JobCategoryCode jcc : JobCategoryCode.values()) {
			this.JobCategoryCodeComboBox.addItem(jcc.getNameTag());
		}
		
		jp.setLayout(sl);
		jp.setPreferredSize(new Dimension(600, 50));
		jp.add(jl);
		jp.add(this.JobCategoryCodeComboBox);
		
		sl.putConstraint(SpringLayout.NORTH, this.JobCategoryCodeComboBox, 0, SpringLayout.SOUTH, jl);
		
		return jp;
	}
	
	public String getLocalCodes() {
		String result = null;
		LocalCode lc = LocalCode.L1;
		String nameTag = (String) this.LocalCodesComboBox.getSelectedItem();

		int temp = lc.returnNumberFromNameTag(nameTag);
		
		if(temp != Integer.MIN_VALUE) {
			result = String.valueOf(temp);
		}
		
		return result;
	}
	
	public String getIndustyCodes() {
		String result = null;
		IndustryCode ic = IndustryCode.ind_cd0;
		String nameTag = (String) this.IndustyCodeComboBox.getSelectedItem();
		
		int temp = ic.returnNumberFromNameTag(nameTag);
		
		if(temp != Integer.MIN_VALUE) {
			
			result = String.valueOf(temp);
		}
		
		return result;
	}
	
	public String getJobCategoryCodes() {
		String result = null;
		JobCategoryCode jcc = JobCategoryCode.JCC1;
		String nameTag = (String) this.JobCategoryCodeComboBox.getSelectedItem();
		
		int temp = jcc.returnNumberFromNameTag(nameTag);
		
		if(temp != Integer.MIN_VALUE) {
		
			result = String.valueOf(temp);
		}
		
		return result;
	}
	
}
