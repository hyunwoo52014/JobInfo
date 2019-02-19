package ui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewPanel extends JPanel{

	private JTable jtb = null;
	private JScrollPane sp = null;
	private JPanel[] jp = null;
	private JButton[] jb = null;
	private String[] header = {"순서","회사이름","내용"};
	private String[][] content = {{"1","1","1"},
			{"1","1","1"}};
	/**
	 * 
	 */
	private static final long serialVersionUID = -6625582665179918976L;
	
	public ViewPanel() {
		this.jp = new JPanel[] {new JPanel(), new JPanel()};
		this.jtb = new JTable(content,header);
		this.jtb.getColumnModel().setColumnSelectionAllowed(true);
		this.sp = new JScrollPane(this.jtb);
		this.jp[0].add(this.sp);
		add(this.jp[0],BorderLayout.NORTH);
		
		this.jb = new JButton[] {new JButton("접속"), new JButton("상세"), new JButton("종료")};
		this.jp[1].setLayout(new BoxLayout(this.jp[1],BoxLayout.X_AXIS));
		this.jp[1].add(this.jb[0]);
		this.jp[1].add(this.jb[1]);
		this.jp[1].add(this.jb[2]);
		add(this.jp[1],BorderLayout.SOUTH);
	}
}
