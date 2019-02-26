package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import openapi.generator.OpenApiUrlReader;
import xml.Interpreter.XMLInterpreter;

public class ViewPanel extends JPanel implements ActionListener{

	private JTable jtb = null;
	private DefaultTableModel model = null;
	private JScrollPane jsp = null;
	private JLabel[] jl = null;
	private JTextField[] jf = null;
	private JPanel[] jp = null;
	private JButton[] jb = null;
	private String[] header = null;
	private String[][] content = {};
	private OpenApiUrlReader oaur= null;
	private XMLInterpreter xi = null;
	private SettingPanel sp = null;
	private int start, count;
	/**
	 * 
	 */
	private static final long serialVersionUID = -6625582665179918976L;
	
	public ViewPanel(SettingPanel sp) {
		setLayout(new BorderLayout());
		
		this.jp = new JPanel[] {new JPanel(), new JPanel(), new JPanel()};
		this.jl = new JLabel[] {new JLabel("키워드")};
		this.jf = new JTextField[] {new JTextField(20)};
		this.model = new DefaultTableModel(content,header);
		this.jtb = new JTable(this.model);
		this.jb = new JButton[] {new JButton("검색"), new JButton("이전페이지"),new JButton("다음페이지"), new JButton("직접입력"), new JButton("상세"), new JButton("종료")};
		this.header = new String[] {"순서","기업명","공고제목","지역","근무형태","경력","학력","연봉"};
		this.start = 0;
		this.count = 110;

		this.jp[0].add(this.jl[0]);
		this.jp[0].add(this.jf[0]);
		this.jp[0].add(this.jb[0]);
		this.jb[0].addActionListener(this);
		this.jp[0].setSize(getWidth(), 100);
		add(this.jp[0],BorderLayout.NORTH);
		
		this.jtb.getColumnModel().setColumnSelectionAllowed(true);
		this.jtb.setPreferredScrollableViewportSize(new Dimension(1000,500));
		this.jsp = new JScrollPane(this.jtb);
		this.jp[1].add(this.jsp);
		this.jp[1].setSize(getWidth(), 500);
		add(this.jp[1],BorderLayout.CENTER);
		
		
		for(int i=1; i<this.jb.length; i++) {
			this.jp[2].add(this.jb[i]);
			this.jb[i].addActionListener(this);
		}
		
		this.jp[2].setSize(getWidth(),100);
		add(this.jp[2],BorderLayout.SOUTH);
		
		this.oaur = new OpenApiUrlReader();
		this.xi = new XMLInterpreter();
		this.sp = sp;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb[0])) {
			this.start = 0; this.count = 110;
			searchJobNListing(this.start,this.count);
		} else if(e.getSource().equals(jb[1])) {
			if(this.start<=0) {
				JOptionPane.showMessageDialog(null, "맨 첫번째 페이지입니다.");
			} else {
				this.start -= 1;
				searchJobNListing(this.start,this.count);
			}
		} else if(e.getSource().equals(jb[2])) {
			this.start+=1;
			searchJobNListing(this.start,this.count);
		} else if(e.getSource().equals(jb[3])) {
			
		} else if(e.getSource().equals(jb[4])) {
			
		} else if(e.getSource().equals(jb[5])) {
			
		} else {
			
		}
	}
	
	private void searchJobNListing(int start, int count) {
		this.model.setRowCount(0);
		this.model.setDataVector(this.xi.getjobs(this.oaur.generate(this.sp.apiUrlString(start,count))), header);
		this.model.fireTableDataChanged();
	}
}