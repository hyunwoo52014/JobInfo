package view.subContainer;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import works.model.sub.SortFlagList;

public class OptionalItem extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6024738260871321790L;
	private JTextField start;
	private JTextField count;
	public JComboBox<String> sort;

	
	public OptionalItem() {
		SpringLayout sl = new SpringLayout();
		setLayout(sl);
		setPreferredSize(new Dimension(700, 60));
		
		JPanel optionList = addOptionlist();
		
		add(optionList);
		
	}
	
	private JPanel addOptionlist() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		JLabel[] jl = {
				new JLabel("정렬 / 페이지 / 보여줄 개수"),
				new JLabel("sort : "),
				new JLabel("start : "),
				new JLabel("count : "),
				new JLabel("(max/default : 110)")
		};

		this.sort = new JComboBox<String>();
		this.start = new JTextField(10);
		this.count = new JTextField(10);
		
		for(SortFlagList sfl : SortFlagList.values()) {
			this.sort.addItem(sfl.getNameTag());
		}
		
		jp.setLayout(sl);
		jp.setPreferredSize(new Dimension(700, 50));

		for(int i = 0 ; i < jl.length; i++) {
			jp.add(jl[i]);
		}
		
		jp.add(this.sort);
		jp.add(this.start);
		jp.add(this.count);
		

		sl.putConstraint(SpringLayout.NORTH, jl[1], 8, SpringLayout.SOUTH, jl[0]);
		
		sl.putConstraint(SpringLayout.NORTH, this.sort, 5, SpringLayout.SOUTH, jl[0]);
		sl.putConstraint(SpringLayout.WEST, this.sort, 7, SpringLayout.EAST, jl[1]);
		
		sl.putConstraint(SpringLayout.NORTH, jl[2], 8, SpringLayout.SOUTH, jl[0]);
		sl.putConstraint(SpringLayout.WEST, jl[2], 7, SpringLayout.EAST, this.sort);
		
		sl.putConstraint(SpringLayout.NORTH, this.start, 5, SpringLayout.SOUTH, jl[0]);
		sl.putConstraint(SpringLayout.WEST, this.start, 7, SpringLayout.EAST, jl[2]);
		
		sl.putConstraint(SpringLayout.NORTH, jl[3], 8, SpringLayout.SOUTH, jl[0]);
		sl.putConstraint(SpringLayout.WEST, jl[3], 7, SpringLayout.EAST, this.start);

		sl.putConstraint(SpringLayout.NORTH, this.count, 5, SpringLayout.SOUTH, jl[0]);
		sl.putConstraint(SpringLayout.WEST, this.count, 7, SpringLayout.EAST, jl[3]);
		
		sl.putConstraint(SpringLayout.NORTH, jl[4], 5, SpringLayout.SOUTH, jl[0]);
		sl.putConstraint(SpringLayout.WEST, jl[4], 2, SpringLayout.EAST, this.count);
		
		return jp;
	}
	
	public void setOptionList_currentPosVal(String text) {
		this.start.setText(text);;
	}
	
	public void setOptionList_totalVal(String text) {
		this.count.setText(text);
	}
	
	public String getSortOptionNameTag() {
		String result = null;

		switch(this.sort.getSelectedIndex()) {
		
		case 1:	result = SortFlagList.newly.getFlagTag(); break;
		case 2:	result = SortFlagList.PostedDate.getFlagTag(); break;
		case 3:	result = SortFlagList.LatelyUpdated.getFlagTag(); break;
		case 4:	result = SortFlagList.UpdatedDate.getFlagTag(); break;
		case 5:	result = SortFlagList.DeadlineDate.getFlagTag(); break;
		case 6:	result = SortFlagList.ReverseDeadlineDate.getFlagTag(); break;
		case 7:	result = SortFlagList.ViewCount.getFlagTag(); break;
		case 8:	result = SortFlagList.ApplicantCount.getFlagTag(); break;
		case 9:	result = SortFlagList.ReplyCount.getFlagTag(); break;
		default : break;
		
		}

		return result;
	}
	
	public Integer getStart() {
		Integer result = null;
		
		try {
			result = Integer.valueOf(this.start.getText());
			
		} catch(Exception e) {
			result = new Integer(0);
		}
		
		return result;
	}
	
	public Integer getCount() {
		Integer result = null;
		
		try {
			result = Integer.valueOf(this.count.getText());
		} catch(Exception e) {
			result = new Integer(110);
		}
		
		return result;
	}
}
