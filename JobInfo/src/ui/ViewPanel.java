package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
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
import javax.swing.border.Border;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = -6625582665179918976L;
	
	public ViewPanel(SettingPanel sp) {
		setLayout(new BorderLayout(0,1));
		
		this.jp = new JPanel[] {new JPanel(), new JPanel()};
		this.jl = new JLabel[] {new JLabel("키워드"),new JLabel("페이지 번호"), new JLabel("리스트 개수"), new JLabel("Powered by"), new JLabel("전체: 0")};
		this.jf = new JTextField[] {new JTextField(null,20)};
		this.jspin = new JSpinner [] {new JSpinner(new SpinnerNumberModel(0,0,1000,1)), new JSpinner(new SpinnerNumberModel(110,0,110,1))};
		this.model = new DefaultTableModel(content,header);
		this.jtb = new JTable(this.model);
		this.jsp = new JScrollPane(this.jtb);
		this.jb = new JButton[] {new JButton("검색"), new JButton("이전페이지"), new JButton("다음페이지"), new JButton("공고상세"), new JButton("기업정보상세"), new JButton("종료"), new JButton("취업 사람인")};
		this.header = new String[] {"순서","기업명","공고제목","지역","근무형태","경력","학력","연봉"};

		Border blackline = BorderFactory.createLineBorder(Color.black);
		this.jp[0].add(this.jl[0]);
		this.jp[0].add(this.jf[0]);
		this.jp[0].add(this.jl[1]);
		this.jp[0].add(this.jspin[0]);
		this.jp[0].add(this.jl[2]);
		this.jp[0].add(this.jspin[1]);
		this.jp[0].add(this.jb[0]);
		this.jp[0].setBorder(blackline);
		this.jb[0].addActionListener(this);
		add(this.jp[0],BorderLayout.NORTH);

		this.jtb.setRowSelectionAllowed(true);
		this.jtb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.jsp.setBorder(blackline);
		add(this.jsp,BorderLayout.CENTER);
		
		this.jp[1].setLayout(new BorderLayout());
		this.jp[1].setBorder(blackline);
		this.jb[jb.length-1].addActionListener(this);
		//this.jb[jb.length-1].setBorderPainted(false);
		this.jb[jb.length-1].setContentAreaFilled(false);
		this.jb[jb.length-1].setFocusPainted(false);
		JPanel j1 = new JPanel();
		j1.setLayout(new FlowLayout());
		j1.add(this.jl[jl.length-2]);
		j1.add(this.jb[jb.length-1]);
		this.jp[1].add(j1,BorderLayout.WEST);
		
		JPanel j2 = new JPanel();
		j2.setLayout(new FlowLayout());
		for(int i=1; i<this.jb.length-1; i++) {
			j2.add(this.jb[i]);
			this.jb[i].addActionListener(this);
		}
		this.jp[1].add(j2,BorderLayout.CENTER);
		
		JPanel j3 = new JPanel();
		j3.setLayout(new FlowLayout());
		j3.add(this.jl[jl.length-1]);
		this.jp[1].add(j3,BorderLayout.EAST);
		
		add(this.jp[1],BorderLayout.SOUTH);
		
		this.oaur = new OpenApiUrlReader();
		this.xi = new XMLInterpreter();
		this.sp = sp;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(this.jb[0])) {
			searchJobNListing();
		} else if(e.getSource().equals(this.jb[1])) {
			if((int)this.jspin[0].getValue()<=0) {
				JOptionPane.showMessageDialog(null, "맨 첫번째 페이지입니다.");
			} else {
				int num1 = (int)this.jspin[0].getValue()-1;
				this.jspin[0].setValue(num1);
				searchJobNListing();
			}
		} else if(e.getSource().equals(this.jb[2])) {
			int num1 = (int)this.jspin[0].getValue()+1;
			this.jspin[0].setValue(num1);
			searchJobNListing();
		} else if(e.getSource().equals(this.jb[3])) {
			this.openBrowser(this.xi.getJobInfoDatailLink(this.jtb.getSelectedRow()));
		} else if(e.getSource().equals(this.jb[4])) {
			this.openBrowser(this.xi.getCompanyLink(this.jtb.getSelectedRow()));
		} else if(e.getSource().equals(this.jb[5])) {
			System.exit(0);
		} else if(e.getSource().equals(this.jb[6])) {
			this.openBrowser("http://www.saramin.co.kr");
		} else {
			System.out.println("error");
		}
	}
	
	private void searchJobNListing() {
		this.model.setRowCount(0);
		//System.out.println(this.jf[0].getText().equals(""));
		this.xi.getjobs(this.oaur.generate(this.sp.apiUrlString(this.jf[0].getText(),(int)this.jspin[0].getValue(),(int)this.jspin[1].getValue())));
		this.jl[this.jl.length-1].setText("전체: "+this.xi.getTotal());
		this.model.setDataVector(this.xi.getTabledata(), header);
		this.model.fireTableDataChanged();
	}
	
	private void openBrowser(String path) {
		try {
			Desktop.getDesktop().browse(new URI(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}