package ui;

import java.awt.Choice;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingPanel extends JPanel{

	private JPanel[] jp = null;
	private JLabel[] jl = null;
	private Choice[] ce= null;
	private JButton[] jb = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4619141006909198823L;
	
	public SettingPanel() {
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
		ce[0].add("정규직");ce[0].add("계약직");ce[0].add("병역특례");ce[0].add("인턴직");ce[0].add("아르바이트");
		ce[0].add("파견직");ce[0].add("해외취업");ce[0].add("위촉직");ce[0].add("프리랜서");ce[0].add("계약직 (정규직 전환가능)");
		ce[0].add("인턴직 (정규직 전환가능)");ce[0].add("교육생");ce[0].add("별정직");ce[0].add("파트");ce[0].add("전임");
		ce[0].add("기간제");ce[0].add("무기계약직");ce[0].add("전문계약직");ce[0].add("전문연구요원");ce[0].add("산업기능요원");
		ce[0].add("현역");ce[0].add("	보충역");
		
		ce[1].add("");ce[1].add("");ce[1].add("");ce[1].add("");ce[1].add("");
		ce[1].add("");ce[1].add("");ce[1].add("");ce[1].add("");
	}
}
