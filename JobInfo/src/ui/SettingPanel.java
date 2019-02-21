package ui;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingPanel extends JPanel{

	private String arguments = null;
	private JPanel[] jp = null;
	private JLabel[] jl = null;
	private Choice[] ce= null;
	private JButton[] jb = null;
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -4619141006909198823L;
	
	public SettingPanel() {
		this.arguments = new String();
		this.jp = new JPanel[] {new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel()};
		this.jl = new JLabel[] {new JLabel("근무형태"), new JLabel("학력"), new JLabel("연봉"), new JLabel("근무지"), new JLabel("산업/업종"), new JLabel("직업/직종")};
		this.ce = new Choice[] {new Choice(), new Choice(), new Choice(), new Choice(), new Choice(), new Choice()};
		this.jb = new JButton[] {};
		this.setLayout(new GridLayout(0,1));
		for(int i=0; i<jp.length; i++) {
			this.jp[i].add(jl[i]);
			this.jp[i].add(ce[i]);
			this.add(jp[i]);
		}
		ce[0].add(DictionaryForInfo.jobtype1.getName());ce[0].add(DictionaryForInfo.jobtype2.getName());ce[0].add(DictionaryForInfo.jobtype3.getName());ce[0].add(DictionaryForInfo.jobtype4.getName());ce[0].add(DictionaryForInfo.jobtype5.getName());
		ce[0].add(DictionaryForInfo.jobtype6.getName());ce[0].add(DictionaryForInfo.jobtype7.getName());ce[0].add(DictionaryForInfo.jobtype8.getName());ce[0].add(DictionaryForInfo.jobtype9.getName());ce[0].add(DictionaryForInfo.jobtype10.getName());
		ce[0].add(DictionaryForInfo.jobtype11.getName());ce[0].add(DictionaryForInfo.jobtype12.getName());ce[0].add(DictionaryForInfo.jobtype13.getName());ce[0].add(DictionaryForInfo.jobtype14.getName());ce[0].add(DictionaryForInfo.jobtype15.getName());
		ce[0].add(DictionaryForInfo.jobtype16.getName());ce[0].add(DictionaryForInfo.jobtype17.getName());ce[0].add(DictionaryForInfo.jobtype18.getName());ce[0].add(DictionaryForInfo.jobtype19.getName());ce[0].add(DictionaryForInfo.jobtype20.getName());
		ce[0].add(DictionaryForInfo.jobtype21.getName());ce[0].add(DictionaryForInfo.jobtype22.getName());
		
		ce[1].add(DictionaryForInfo.edu_lv0.getName());ce[1].add(DictionaryForInfo.edu_lv1.getName());ce[1].add(DictionaryForInfo.edu_lv2.getName());ce[1].add(DictionaryForInfo.edu_lv3.getName());ce[1].add(DictionaryForInfo.edu_lv4.getName());
		ce[1].add(DictionaryForInfo.edu_lv5.getName());ce[1].add(DictionaryForInfo.edu_lv6.getName());ce[1].add(DictionaryForInfo.edu_lv7.getName());ce[1].add(DictionaryForInfo.edu_lv8.getName());ce[1].add(DictionaryForInfo.edu_lv9.getName());
		
		ce[2].add(DictionaryForInfo.salary0.getName());ce[2].add(DictionaryForInfo.salary3.getName());ce[2].add(DictionaryForInfo.salary4.getName());ce[2].add(DictionaryForInfo.salary5.getName());ce[2].add(DictionaryForInfo.salary6.getName());
		ce[2].add(DictionaryForInfo.salary7.getName());ce[2].add(DictionaryForInfo.salary8.getName());ce[2].add(DictionaryForInfo.salary9.getName());ce[2].add(DictionaryForInfo.salary10.getName());ce[2].add(DictionaryForInfo.salary11.getName());
		ce[2].add(DictionaryForInfo.salary12.getName());ce[2].add(DictionaryForInfo.salary13.getName());ce[2].add(DictionaryForInfo.salary14.getName());ce[2].add(DictionaryForInfo.salary15.getName());ce[2].add(DictionaryForInfo.salary16.getName());
		ce[2].add(DictionaryForInfo.salary17.getName());ce[2].add(DictionaryForInfo.salary18.getName());ce[2].add(DictionaryForInfo.salary19.getName());ce[2].add(DictionaryForInfo.salary20.getName());ce[2].add(DictionaryForInfo.salary21.getName());
		ce[2].add(DictionaryForInfo.salary22.getName());ce[2].add(DictionaryForInfo.salary23.getName());ce[2].add(DictionaryForInfo.salary99.getName());
		
		ce[3].add(DictionaryForInfo.loc_cd101000.getName());ce[3].add(DictionaryForInfo.loc_cd102000.getName());
		
		ce[4].add(DictionaryForInfo.ind_cd301.getName());ce[4].add(DictionaryForInfo.ind_cd302.getName());ce[4].add(DictionaryForInfo.ind_cd304.getName());ce[4].add(DictionaryForInfo.ind_cd305.getName());
		ce[4].add(DictionaryForInfo.ind_cd306.getName());ce[4].add(DictionaryForInfo.ind_cd307.getName());ce[4].add(DictionaryForInfo.ind_cd308.getName());ce[4].add(DictionaryForInfo.ind_cd313.getName());
		ce[4].add(DictionaryForInfo.ind_cd314.getName());
		
		ce[5].add(DictionaryForInfo.job_category401.getName());ce[5].add(DictionaryForInfo.job_category402.getName());ce[5].add(DictionaryForInfo.job_category403.getName());ce[5].add(DictionaryForInfo.job_category404.getName());ce[5].add(DictionaryForInfo.job_category405.getName());
		ce[5].add(DictionaryForInfo.job_category406.getName());ce[5].add(DictionaryForInfo.job_category407.getName());ce[5].add(DictionaryForInfo.job_category408.getName());ce[5].add(DictionaryForInfo.job_category409.getName());ce[5].add(DictionaryForInfo.job_category410.getName());
		ce[5].add(DictionaryForInfo.job_category411.getName());ce[5].add(DictionaryForInfo.job_category412.getName());ce[5].add(DictionaryForInfo.job_category413.getName());ce[5].add(DictionaryForInfo.job_category414.getName());ce[5].add(DictionaryForInfo.job_category415.getName());
		ce[5].add(DictionaryForInfo.job_category416.getName());ce[5].add(DictionaryForInfo.job_category417.getName());
		
	}
	
	public String getArguments() {
		
		return this.arguments;
	}
}
