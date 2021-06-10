package view.subContainer;

import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class OptionalItem extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6024738260871321790L;
	JCheckBox[] checkBox;
	JComboBox<String> sort;
	JTextField start;
	JTextField end;
	
	public OptionalItem() {
		SpringLayout sl = new SpringLayout();
		setLayout(sl);
		setPreferredSize(new Dimension(700, 120));
		
		JPanel optionList1 = addOptionlist1();
		JPanel optionList2 = addOptionlist2();
		
		add(optionList1);
		add(optionList2);
		
		sl.putConstraint(SpringLayout.WEST, optionList1, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, optionList1, 5, SpringLayout.NORTH, this);
		
		sl.putConstraint(SpringLayout.WEST, optionList2, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, optionList2, 5, SpringLayout.SOUTH, optionList1);
		
	}
	
	private JPanel addOptionlist1() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		JLabel jl = new JLabel("부가 항목(선택적)");
		this.checkBox = new JCheckBox[4];
		this.checkBox[0] = new JCheckBox("날짜/시간 형식의 게시일");
		this.checkBox[1] = new JCheckBox("날짜/시간 형식의 마감일시");
		this.checkBox[2] = new JCheckBox("업직종 키워드(상세분류)");
		this.checkBox[3] = new JCheckBox("코드 조회수/지원자수/댓글수");
		   
		jp.setLayout(sl);
		jp.setPreferredSize(new Dimension(700, 40));
		jp.add(jl);
		
		for(int i = 0 ; i < this.checkBox.length; i++) {
			jp.add(checkBox[i]);
		}
		
		sl.putConstraint(SpringLayout.NORTH, jl, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.WEST, jl, 5, SpringLayout.WEST, this);
		
		sl.putConstraint(SpringLayout.NORTH, this.checkBox[0], 0, SpringLayout.SOUTH, jl);
		sl.putConstraint(SpringLayout.NORTH, this.checkBox[0], 0, SpringLayout.SOUTH, jl);
		
		sl.putConstraint(SpringLayout.NORTH, this.checkBox[1], 0, SpringLayout.SOUTH, jl);
		sl.putConstraint(SpringLayout.WEST, this.checkBox[1], 0, SpringLayout.EAST, this.checkBox[0]);

		
		sl.putConstraint(SpringLayout.NORTH, this.checkBox[2], 0, SpringLayout.SOUTH, jl);
		sl.putConstraint(SpringLayout.WEST, this.checkBox[2], 0, SpringLayout.EAST, this.checkBox[1]);
		
		sl.putConstraint(SpringLayout.NORTH, this.checkBox[3], 0, SpringLayout.SOUTH, jl);
		sl.putConstraint(SpringLayout.WEST, this.checkBox[3], 0, SpringLayout.EAST, this.checkBox[2]);
		
		return jp;
	}
	
	private JPanel addOptionlist2() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		JLabel[] jl = {
				new JLabel("sort/start/count"),
				new JLabel("sort : "),
				new JLabel("/ start : "),
				new JLabel("/ end : ")
		};
		String[] param = {
				"최근게시일순(기본값)", "최근게시일순", "게시일순", "최근수정일순", "수정일순",
				"마감일순", "마감일순(역순)", "조회수", "지원자수", "댓글순"
		};
		
		this.sort = new JComboBox<String>(param);
		this.start = new JTextField(10);
		this.end = new JTextField(10);
		
		jp.setLayout(sl);
		jp.setPreferredSize(new Dimension(600, 50));

		for(int i = 0 ; i < jl.length; i++) {
			jp.add(jl[i]);
		}
		
		jp.add(this.sort);
		jp.add(this.start);
		jp.add(this.end);
	
		sl.putConstraint(SpringLayout.NORTH, jl[0], 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.WEST, jl[0], 5, SpringLayout.WEST, this);
		
		sl.putConstraint(SpringLayout.WEST, jl[1], 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, jl[1], 5, SpringLayout.SOUTH, jl[0]);
		
		sl.putConstraint(SpringLayout.WEST, this.sort, 5, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, this.sort, 5, SpringLayout.SOUTH, jl[0]);
		sl.putConstraint(SpringLayout.WEST, this.sort, 5, SpringLayout.EAST, jl[1]);
		
		sl.putConstraint(SpringLayout.NORTH, jl[2], 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.NORTH, jl[2], 5, SpringLayout.SOUTH, jl[0]);
		sl.putConstraint(SpringLayout.WEST, jl[2], 5, SpringLayout.EAST, this.sort);
		
		sl.putConstraint(SpringLayout.WEST, this.start, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, this.start, 5, SpringLayout.SOUTH, jl[0]);
		sl.putConstraint(SpringLayout.WEST, this.start, 5, SpringLayout.EAST, jl[2]);
		
		sl.putConstraint(SpringLayout.WEST, jl[3], 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, jl[3], 5, SpringLayout.SOUTH, jl[0]);
		sl.putConstraint(SpringLayout.WEST, jl[3], 5, SpringLayout.EAST, this.start);

		sl.putConstraint(SpringLayout.WEST, this.end, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.NORTH, this.end, 5, SpringLayout.SOUTH, jl[0]);
		sl.putConstraint(SpringLayout.WEST, this.end, 5, SpringLayout.EAST, jl[3]);
		
		return jp;
	}
}
