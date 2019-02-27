package ui;

import java.awt.Choice;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingPanel extends JPanel{

	private DictionaryForInfo dic = null;
	private String[] arguments = null;
	private JPanel[] jp = null;
	private JLabel[] jl = null;
	private Choice[] ce= null;
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -4619141006909198823L;
	
	public SettingPanel() {
		this.dic = new DictionaryForInfo();
		this.jp = new JPanel[] {new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel()};
		this.jl = new JLabel[] {new JLabel("근무형태"), new JLabel("학력"), new JLabel("근무지"), new JLabel("산업/업종"), new JLabel("직업/직종")};
		this.ce = new Choice[] {new Choice(), new Choice(), new Choice(), new Choice(), new Choice()};
		this.setLayout(new GridLayout(0,1));
		for(int i=0; i<jp.length; i++) {
			this.jp[i].add(jl[i]);
			this.jp[i].add(ce[i]);
			this.add(jp[i]);
		}
		
		for(int i=0; i< ce.length; i++) {
			ce[i].add("선택없음");
		}
		
		for(int i=1; i<=22; i++) {
			ce[0].add(this.dic.getValue(0,String.valueOf(i)));
		}
		
		for(int i=0; i<=9; i++) {
			ce[1].add(this.dic.getValue(1,String.valueOf(i)));
		}
		
		for(int i=101000; i<=102000; i+=1000) {
			ce[2].add(this.dic.getValue(2,String.valueOf(i)));
		}
		
		for(int i=301; i<=314; i++) {
			if(i == 303 || i == 309 || i ==310 || i ==311 || i ==312) {
				continue;
			}
			ce[3].add(this.dic.getValue(3,String.valueOf(i)));
		}
		
		for(int i=401; i<=417; i++) {
			ce[4].add(this.dic.getValue(4,String.valueOf(i)));
		}
		
	}
	
	public String apiUrlString(int start,int count) {
		String temp = "http://api.saramin.co.kr/job-search";
		this.arguments = new String[] {"jobtype=","edu_lv=","loc_cd=","ind_cd=","job_category=","start=","count="};
		//"?jobtype=","&edu_lv=","&loc_cd=","&ind_cd=","&job_category=","&start=","&count="
		for(int i=0; i<this.arguments.length-2; i++) {
			if(ce[i].getSelectedItem() == "선택없음") {
				this.arguments[i] = "";
			} else {
				this.arguments[i] += this.dic.getKey(i, ce[i].getSelectedItem());
			}
		}
		this.arguments[5] += start;
		this.arguments[6] += count;

		for(int i=0; i<this.arguments.length; i++) {
			if(i==0) {
				temp+="?";
			} else {
				temp+="&";
			}
			temp += this.arguments[i];
		}
		System.out.println(temp);
		return temp;
	}
}
