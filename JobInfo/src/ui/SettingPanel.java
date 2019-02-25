package ui;

import java.awt.Choice;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingPanel extends JPanel{

	private DictionaryForInfo dic = null;
	private String[] arguments = null;
	private JPanel[] jp = null;
	private JLabel[] jl = null;
	private Choice[] ce= null;
	private JButton[] jb = null;
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -4619141006909198823L;
	
	public SettingPanel() {
		this.dic = new DictionaryForInfo();
		this.arguments = new String[] {"?jobtype=","&edu_lv=","&loc_cd=","&ind_cd=","&job_category=","&start=0","&count=110"};
		this.jp = new JPanel[] {new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel()};
		this.jl = new JLabel[] {new JLabel("근무형태"), new JLabel("학력"), new JLabel("근무지"), new JLabel("산업/업종"), new JLabel("직업/직종")};
		this.ce = new Choice[] {new Choice(), new Choice(), new Choice(), new Choice(), new Choice(), new Choice()};
		this.jb = new JButton[] {};
		this.setLayout(new GridLayout(0,1));
		for(int i=0; i<jp.length; i++) {
			this.jp[i].add(jl[i]);
			this.jp[i].add(ce[i]);
			this.add(jp[i]);
		}
		
		for(int i=1; i<=22; i++) {
			ce[0].add(this.dic.getJobTypeValue(i));
		}
		
		for(int i=0; i<=9; i++) {
			ce[1].add(this.dic.getEduLvValue(i));
		}
		
		for(int i=101000; i<=102000; i+=1000) {
			ce[2].add(this.dic.getLocCdValue(i));
		}
		
		for(int i=301; i<=314; i++) {
			if(i == 303 || i == 309 || i ==310 || i ==311 || i ==312) {
				continue;
			}
			ce[3].add(this.dic.getIndCdValue(i));
		}
		
		for(int i=401; i<=417; i++) {
			ce[4].add(this.dic.getJobCategoryValue(i));
		}
		
	}
	
	public String[] getArguments() {
		//"?jobtype=","&edu_lv=","&loc_cd=","&ind_cd=","&job_category="
		this.arguments[0] += this.dic.getJobTypeKey(ce[0].getSelectedItem());
		this.arguments[1] += this.dic.getEduLvKey(ce[1].getSelectedItem());
		this.arguments[2] += this.dic.getLocCdKey(ce[2].getSelectedItem());
		this.arguments[3] += this.dic.getIndCdKey(ce[3].getSelectedItem());
		this.arguments[4] += this.dic.getJobCategoryKey(ce[4].getSelectedItem());
		return this.arguments;
	}
}
