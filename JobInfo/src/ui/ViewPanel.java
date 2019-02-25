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

import openapi.generator.OpenApiUrlReader;
import xml.Interpreter.XMLInterpreter;

public class ViewPanel extends JPanel implements ActionListener{

	private JTable jtb = null;
	private JScrollPane jsp = null;
	private JLabel[] jl = null;
	private JTextField[] jf = null;
	private JPanel[] jp = null;
	private JButton[] jb = null;
	private String[] header = {"����","�����","��������","����","�ٹ�����","�����ο�","���","����"};
	private String[][] content = {};
	private String[] arguments = null;
	private OpenApiUrlReader oaur= null;
	private XMLInterpreter xi = null;
	private SettingPanel sp = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6625582665179918976L;
	
	public ViewPanel(SettingPanel sp) {
		setLayout(new BorderLayout());
		
		this.jp = new JPanel[] {new JPanel(), new JPanel(), new JPanel()};
		this.jl = new JLabel[] {new JLabel("Ű����")};
		this.jf = new JTextField[] {new JTextField(20)};
		this.jtb = new JTable(content,header);
		this.jb = new JButton[] {new JButton("�˻�"), new JButton("����������"),new JButton("����������"), new JButton("�����Է�"), new JButton("��"), new JButton("����")};

		
		this.jp[0].add(this.jl[0]);
		this.jp[0].add(this.jf[0]);
		this.jp[0].add(this.jb[0]);
		this.jp[0].setSize(getWidth(), 100);
		add(this.jp[0],BorderLayout.NORTH);
		
		this.jtb.getColumnModel().setColumnSelectionAllowed(true);
		this.jtb.setPreferredScrollableViewportSize(new Dimension(1000,500));
		this.jsp = new JScrollPane(this.jtb);
		this.jp[1].add(this.jsp);
		this.jp[1].setSize(getWidth(), 500);
		add(this.jp[1],BorderLayout.CENTER);
		
		for(int i=1; i < this.jb.length; i++) {
			this.jp[2].add(this.jb[i]);
			this.jb[i].addActionListener(this);
		}
		this.jp[2].setSize(getWidth(),100);
		add(this.jp[2],BorderLayout.SOUTH);
		
		this.oaur = new OpenApiUrlReader();
		this.sp = sp;
		
		for(int i=0; i<this.jb.length; i++) {
			this.jb[i].addActionListener(this);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb[0])) {
			System.out.println("Ŭ��");
			if(this.xi == null) {
				this.xi = new XMLInterpreter();
			}
			searchJobNListing();
		} else if(e.getSource().equals(jb[1])) {
			if(this.arguments != null || this.xi != null) {
				int start = Integer.valueOf((this.arguments[5].substring(6)));
				if(start < 0) {
					JOptionPane.showMessageDialog(null, "ù��° �������Դϴ�.");
				} else {
					start -= 1;
					this.arguments[5] = "&count="+String.valueOf(start);
					searchJobNListing();
				}
			}
		} else if(e.getSource().equals(jb[2])) {
			if(this.arguments != null || this.xi != null) {
				int start = Integer.valueOf((this.arguments[5].substring(6)));
				start +=1;
				this.arguments[5] = "&count="+String.valueOf(start);
				searchJobNListing();
				
			}
		} else if(e.getSource().equals(jb[3])) {
			if(this.arguments != null || this.xi != null) {
				int start = Integer.valueOf((this.arguments[5].substring(6)));
				if(start < 0) {
					
				} else {
					start +=1;
					this.arguments[5] = "&count="+String.valueOf(start);
					searchJobNListing();
				}
			}
		} else if(e.getSource().equals(jb[4])) {
			
		} else if(e.getSource().equals(jb[5])) {
			
		} else {
			
		}
	}
	
	private void searchJobNListing() {
		String temp = "http://api.saramin.co.kr/job-search?";
		if(this.arguments == null) {
			this.arguments = this.sp.getArguments();
			for(int i=0; i<this.arguments.length; i++) {
				temp += this.arguments[i];
			}
		} else {
			for(int i=0; i<this.arguments.length; i++) {
				temp += this.arguments[i];
			}
		}
		this.oaur.setUrl(temp);
		this.oaur.generate();
		this.xi.init(this.oaur.getXmlData());
		String[][] getDatas = this.xi.getjobs();
		System.out.println(getDatas);
		this.jtb = new JTable(getDatas,header);
	}
}