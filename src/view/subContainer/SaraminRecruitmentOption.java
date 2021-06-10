package view.subContainer;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

public class SaraminRecruitmentOption extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3156815288688023618L;
	private JLabel recruitmentOption = new JLabel("공채구분");
	private JLabel goPublicOption = new JLabel("상장여부");
	private JLabel headHuntingOption = new JLabel("제외/포함 설정");
	private ButtonGroup group = new ButtonGroup();
	private JRadioButton[] radiobuttonList = new JRadioButton[2];
	private JCheckBox[] checkboxList = new JCheckBox[4];
	
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
		
		sl.putConstraint(SpringLayout.WEST, option1, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, option1, 5, SpringLayout.NORTH, this);
		
		sl.putConstraint(SpringLayout.WEST, option2, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, option2, 5, SpringLayout.SOUTH, option1);
		
		sl.putConstraint(SpringLayout.WEST, option3, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, option3, 5, SpringLayout.SOUTH, option2);
	}
	
	private JPanel option1() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		jp.setPreferredSize(new Dimension(500, 50));
		jp.setLayout(sl);
		
		this.radiobuttonList[0] = new JRadioButton("모든 채용 공고");
		this.radiobuttonList[1] = new JRadioButton("사람인 공채속보만 포함");
		
		this.group.add(this.radiobuttonList[0]);
		this.group.add(this.radiobuttonList[1]);
		
		jp.add(this.recruitmentOption);
		jp.add(this.radiobuttonList[0]);
		jp.add(this.radiobuttonList[1]);
		
		sl.putConstraint(SpringLayout.WEST, this.recruitmentOption, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, this.recruitmentOption, 0, SpringLayout.NORTH, this);
		
		sl.putConstraint(SpringLayout.NORTH, this.radiobuttonList[0], 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.NORTH, this.radiobuttonList[0], 0, SpringLayout.SOUTH, this.recruitmentOption);
		
		sl.putConstraint(SpringLayout.NORTH, this.radiobuttonList[1], 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.NORTH, this.radiobuttonList[1], 0, SpringLayout.SOUTH, this.recruitmentOption);
		sl.putConstraint(SpringLayout.WEST, this.radiobuttonList[1], 0, SpringLayout.EAST, this.radiobuttonList[0]);
		
		return jp;
	}
	
	
	private JPanel option2() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		jp.setPreferredSize(new Dimension(500, 50));
		jp.setLayout(sl);

		this.checkboxList[0] = new JCheckBox("유가증권",false);
		this.checkboxList[1] = new JCheckBox("코스닥", false);
		this.checkboxList[2] = new JCheckBox("나스닥", false);
		
		jp.add(this.goPublicOption);
		jp.add(this.checkboxList[0]);
		jp.add(this.checkboxList[1]);
		jp.add(this.checkboxList[2]);
		
		sl.putConstraint(SpringLayout.NORTH, this.goPublicOption, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.WEST, this.goPublicOption, 5, SpringLayout.WEST, this);
		
		sl.putConstraint(SpringLayout.NORTH, this.checkboxList[0], 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.NORTH, this.checkboxList[0], 0, SpringLayout.SOUTH, this.goPublicOption);
		
		sl.putConstraint(SpringLayout.NORTH, this.checkboxList[1], 0, SpringLayout.SOUTH, this.goPublicOption);
		sl.putConstraint(SpringLayout.WEST, this.checkboxList[1], 0, SpringLayout.EAST, this.checkboxList[0]);
		
		sl.putConstraint(SpringLayout.NORTH, this.checkboxList[2], 0, SpringLayout.SOUTH, this.goPublicOption);
		sl.putConstraint(SpringLayout.WEST, this.checkboxList[2], 0, SpringLayout.EAST, this.checkboxList[1]);
		
		
		return jp;
	}
	
	
	private JPanel option3() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		jp.setPreferredSize(new Dimension(500, 50));
		jp.setLayout(sl);
		
		this.checkboxList[3] = new JCheckBox("헤드헌팅/파견업체 공고제외",false);

		jp.add(this.headHuntingOption);
		jp.add(this.checkboxList[3]);
		
		sl.putConstraint(SpringLayout.NORTH, this.headHuntingOption, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.WEST, this.headHuntingOption, 5, SpringLayout.WEST, this);
		
		sl.putConstraint(SpringLayout.WEST, this.headHuntingOption, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, this.checkboxList[3], 0, SpringLayout.SOUTH, this.headHuntingOption);
		
		return jp;
	}
	
	
}
