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
		this.jl = new JLabel[] {new JLabel("�ٹ�����"), new JLabel("�з�"), new JLabel("����"), new JLabel("�ٹ���"), new JLabel("���/����"), new JLabel("����/����")};
		this.ce = new Choice[] {new Choice(), new Choice(), new Choice(), new Choice(), new Choice(), new Choice()};
		this.jb = new JButton[] {};
		this.setLayout(new GridLayout(0,1));
		for(int i=0; i<jp.length; i++) {
			this.jp[i].add(jl[i]);
			this.jp[i].add(ce[i]);
			this.add(jp[i]);
		}
		ce[0].add("������");ce[0].add("�����");ce[0].add("����Ư��");ce[0].add("������");ce[0].add("�Ƹ�����Ʈ");
		ce[0].add("�İ���");ce[0].add("�ؿ����");ce[0].add("������");ce[0].add("��������");ce[0].add("����� (������ ��ȯ����)");
		ce[0].add("������ (������ ��ȯ����)");ce[0].add("������");ce[0].add("������");ce[0].add("��Ʈ");ce[0].add("����");
		ce[0].add("�Ⱓ��");ce[0].add("��������");ce[0].add("���������");ce[0].add("�����������");ce[0].add("�����ɿ��");
		ce[0].add("����");ce[0].add("	���濪");
		
		ce[1].add("");ce[1].add("");ce[1].add("");ce[1].add("");ce[1].add("");
		ce[1].add("");ce[1].add("");ce[1].add("");ce[1].add("");
	}
}
