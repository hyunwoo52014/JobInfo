package ui;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingPanel extends JPanel{

	private String arguments = null;
	private JPanel[] jp = null;
	private JLabel[] jl = null;
	private Choice[] ce= null;
	private JButton[] jb = null;
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -4619141006909198823L;
	
	public SettingPanel() {
		this.arguments = new String();
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
		
		ce[1].add("�з¹���");ce[1].add("����б�����");ce[1].add("��������(2,3��)");ce[1].add("���б�����(4��)");ce[1].add("��������");
		ce[1].add("�ڻ�����");ce[1].add("����б������̻�");ce[1].add("��������(2,3��)�̻�");ce[1].add("���б�����(4��)�̻�");ce[1].add("���������̻�");
		
		ce[2].add("ȸ�系�Կ� ����");ce[2].add("1,400 ���� ����");ce[2].add("1,400~1,600����");ce[2].add("1,600~1,800����");ce[2].add("1,800~2,000����");
		ce[2].add("2,000~2,200����");ce[2].add("2,200~2,400����");ce[2].add("2,400~2,600����");ce[2].add("2,600~2,800����");ce[2].add("2,800~3,000����");
		ce[2].add("3,000~3,200����");ce[2].add("3,200~3,400����");ce[2].add("3,400~3,600����");ce[2].add("3,600~3,800����");ce[2].add("3,800~4,000����");
		ce[2].add("4,000~5,000����");ce[2].add("5,000~6,000����");ce[2].add("6,000~7,000����");ce[2].add("7,000~8,000����");ce[2].add("8,000~9,000����");
		ce[2].add("9,000~1���");ce[2].add("1��� �̻�");ce[2].add("������ ����");
		
		ce[3].add("������ü");ce[3].add("�����ü");
		
		ce[4].add("�ַ�ǡ�SI��ERP��CRM");ce[4].add("����������");ce[4].add("���θ������¸���");ce[4].add("���С����ͳݡ�������");
		ce[4].add("��Ʈ��ũ����š������");ce[4].add("�ϵ������");ce[4].add("�������ȡ����");ce[4].add("IT������");
		ce[4].add("����");
		
		ce[5].add("�������͡�QA���׽���");ce[5].add("��������Ʈ��ũ������");ce[5].add("����ȹ��PM");ce[5].add("������");ce[5].add("���ӡ�Game");
		ce[5].add("������������Ʈ�");ce[5].add("�������α׷�����");ce[5].add("�ý��۰���");ce[5].add("ERP���ý��ۺм�������");ce[5].add("��š������");
		ce[5].add("�ϵ�������Ʈ����");ce[5].add("��������");ce[5].add("�ۺ��̡�UI����");ce[5].add("�������������ڵ�");ce[5].add("IT�������Ρ���ǻ�ͱ���");
		ce[5].add("�����ͺ��̽���DBA");ce[5].add("�ΰ�����(AI)��������");
		
	}
	
	public String getArguments() {
		
		return this.arguments;
	}
}
