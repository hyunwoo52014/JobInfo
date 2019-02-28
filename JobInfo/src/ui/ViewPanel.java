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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import openapi.generator.OpenApiUrlReader;
import xml.Interpreter.XMLInterpreter;

public class ViewPanel extends JPanel implements ActionListener{

	private JTable jtb = null;
	private DefaultTableModel model = null;
	private JScrollPane jsp = null;
	private JLabel[] jl = null;
	private JTextField[] jf = null;
	private JSpinner[] jspin = null;
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
		setSize(this.getWidth(), this.getHeight());
		this.jp = new JPanel[] {new JPanel(), new JPanel(), new JPanel()};
		this.jl = new JLabel[] {new JLabel("키워드"),new JLabel("페이지 번호"), new JLabel("리스트 개수")};
		this.jf = new JTextField[] {new JTextField(20)};
		this.jspin = new JSpinner [] {new JSpinner(new SpinnerNumberModel(0,0,1000,1)), new JSpinner(new SpinnerNumberModel(0,0,110,1))};
		this.model = new DefaultTableModel(content,header);
		this.jtb = new JTable(this.model);
		this.jb = new JButton[] {new JButton("검색"), new JButton("이전페이지"),new JButton("다음페이지"), new JButton("직접입력"), new JButton("공고상세"), new JButton("기업정보상세")};
		this.header = new String[] {"순서","기업명","공고제목","지역","근무형태","경력","학력","연봉"};
		this.start = 0;
		this.count = 110;

		this.jp[0].add(this.jl[0]);
		this.jp[0].add(this.jf[0]);
		this.jp[0].add(this.jl[1]);
		this.jp[0].add(this.jspin[0]);
		this.jp[0].add(this.jl[2]);
		this.jp[0].add(this.jspin[1]);
		this.jp[0].add(this.jb[0]);
		this.jb[0].addActionListener(this);
		add(this.jp[0],BorderLayout.NORTH);

		this.jtb.setRowSelectionAllowed(true);
		this.jtb.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.jsp = new JScrollPane(this.jtb);
		this.jsp.setSize(this.jp[1].getHeight(),this.jp[1].getWidth());
		this.jp[1].add(this.jsp);
		add(this.jp[1],BorderLayout.CENTER);
		
		for(int i=1; i<this.jb.length; i++) {
			this.jp[2].add(this.jb[i]);
			this.jb[i].addActionListener(this);
		}
		add(this.jp[2],BorderLayout.SOUTH);
		
		this.oaur = new OpenApiUrlReader();
		this.xi = new XMLInterpreter();
		this.sp = sp;
		
		System.out.println(super.getSize());
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
			System.exit(0);
		} else {
			
		}
	}
	
	private void searchJobNListing(int start, int count) {
		this.model.setRowCount(0);
		this.xi.getjobs(this.oaur.generate(this.sp.apiUrlString(start,count)));
		this.model.setDataVector(this.xi.getTabledata(), header);
		this.model.fireTableDataChanged();
	}
}