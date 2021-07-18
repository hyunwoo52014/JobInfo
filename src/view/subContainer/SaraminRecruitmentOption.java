package view.subContainer;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

import works.model.sub.PublishedStockOption;
import works.model.sub.RecruitmentList;

public class SaraminRecruitmentOption extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3156815288688023618L;
	private JLabel recruitmentOption = new JLabel("공채구분");
	private JLabel goPublicOption = new JLabel("상장여부");
	private JLabel headHuntingOption = new JLabel("제외/포함 설정");
	private ButtonGroup group = new ButtonGroup();
	public JRadioButton[] RecruitMentList = new JRadioButton[2];
	public JCheckBox[] GoPublicCheckboxList = new JCheckBox[3];
	public JCheckBox HheadHuntingCheckBox;
	
	public SaraminRecruitmentOption() {
		SpringLayout sl = new SpringLayout();
		setLayout(sl);
		setPreferredSize(new Dimension(500, 160));
		
		JPanel option1 = this.option1();
		JPanel option2 = this.option2();
		JPanel option3 = this.option3();
		
		add(option1);
		add(option2);
		add(option3);
		
		sl.putConstraint(SpringLayout.NORTH, option2, 5, SpringLayout.SOUTH, option1);
		
		sl.putConstraint(SpringLayout.NORTH, option3, 5, SpringLayout.SOUTH, option2);
	}
	
	private JPanel option1() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		jp.setPreferredSize(new Dimension(500, 50));
		jp.setLayout(sl);
		
		this.RecruitMentList[0] = new JRadioButton("모든 채용 공고");
		this.RecruitMentList[1] = new JRadioButton("사람인 공채속보만 포함");
		
		this.group.add(this.RecruitMentList[0]);
		this.group.add(this.RecruitMentList[1]);
		
		jp.add(this.recruitmentOption);
		jp.add(this.RecruitMentList[0]);
		jp.add(this.RecruitMentList[1]);
		
		sl.putConstraint(SpringLayout.NORTH, this.RecruitMentList[0], 0, SpringLayout.SOUTH, this.recruitmentOption);
		
		sl.putConstraint(SpringLayout.NORTH, this.RecruitMentList[1], 0, SpringLayout.SOUTH, this.recruitmentOption);
		sl.putConstraint(SpringLayout.WEST, this.RecruitMentList[1], 0, SpringLayout.EAST, this.RecruitMentList[0]);
		
		return jp;
	}
	
	
	private JPanel option2() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		jp.setPreferredSize(new Dimension(500, 50));
		jp.setLayout(sl);

		this.GoPublicCheckboxList[0] = new JCheckBox("유가증권",false);
		this.GoPublicCheckboxList[1] = new JCheckBox("코스닥", false);
		this.GoPublicCheckboxList[2] = new JCheckBox("나스닥", false);
		
		jp.add(this.goPublicOption);
		jp.add(this.GoPublicCheckboxList[0]);
		jp.add(this.GoPublicCheckboxList[1]);
		jp.add(this.GoPublicCheckboxList[2]);
		
		sl.putConstraint(SpringLayout.NORTH, this.GoPublicCheckboxList[0], 0, SpringLayout.SOUTH, this.goPublicOption);
		
		sl.putConstraint(SpringLayout.NORTH, this.GoPublicCheckboxList[1], 0, SpringLayout.SOUTH, this.goPublicOption);
		sl.putConstraint(SpringLayout.WEST, this.GoPublicCheckboxList[1], 0, SpringLayout.EAST, this.GoPublicCheckboxList[0]);
		
		sl.putConstraint(SpringLayout.NORTH, this.GoPublicCheckboxList[2], 0, SpringLayout.SOUTH, this.goPublicOption);
		sl.putConstraint(SpringLayout.WEST, this.GoPublicCheckboxList[2], 0, SpringLayout.EAST, this.GoPublicCheckboxList[1]);
		
		
		return jp;
	}
	
	
	private JPanel option3() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		jp.setPreferredSize(new Dimension(500, 50));
		jp.setLayout(sl);
		
		this.HheadHuntingCheckBox = new JCheckBox("헤드헌팅/파견업체 공고제외",false);

		jp.add(this.headHuntingOption);
		jp.add(this.HheadHuntingCheckBox);

		sl.putConstraint(SpringLayout.NORTH, this.HheadHuntingCheckBox, 0, SpringLayout.SOUTH, this.headHuntingOption);
		
		return jp;
	}
	
	public String getRecruitmentOptionValue() {
		String result = null;
		
		if(this.RecruitMentList[0].isSelected()) {
			result = RecruitmentList.All.getNumberToString();
		}
		
		if(this.RecruitMentList[1].isSelected()) {
			result = RecruitmentList.InSaramin.getNumberToString();
		}
		
		return result;
	}
	
	public String getPublicOptionValue() {
		String result = null;
		boolean chain = false;
		PublishedStockOption pso = PublishedStockOption.KOSPI;
		
		for(int i = 0; i < this.GoPublicCheckboxList.length; i++) {
			if(this.GoPublicCheckboxList[i].isSelected()) {
				if(chain) {
					result += "+"+pso.returnNameTagFromNumber(i);
				} else {
					result = "";
					result += pso.returnNameTagFromNumber(i);
					chain = true;
				}				
			}
		}
		
		return result;
	}
	
	public String getHeadHuntingValue() {
		String result = null;
		
		if(this.HheadHuntingCheckBox.isSelected()) {
			result = "";
			result += "directhire";
		}
		
		return result;
	}
	
}