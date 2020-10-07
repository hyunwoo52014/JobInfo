package ui;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import data.IndustryCode;
import data.JobTypeCode;
import data.LocalCode;


public class SettingPanel extends JPanel{

	private static final long serialVersionUID = -4619141006909198823L;
	private JRadioButton[] bbs_gb;
	private JCheckBox[] stocks;
	private JCheckBox sr;
	private ButtonGroup job_type_group;
	private ButtonGroup edu_lv_group;
	private JComboBox<String> local;
	private JComboBox<String> industry;
	private JComboBox<String> jobtype;
	
	public SettingPanel() {

		JPanel[] subpanels = new JPanel[6];
		for(int i = 0 ; i < subpanels.length; i++) {
			subpanels[i] = new JPanel();
			subpanels[i].setLayout(new GridLayout(0,6));
		}
		
		//�� subpanels�� ��
		JLabel[] labels = {new JLabel("��ä����"), new JLabel("���忩��"), new JLabel("����/���Լ���"), new JLabel("�ٹ� ����"),
				new JLabel("�з�"), new JLabel("����"), new JLabel("����"), new JLabel("����")};
		
		//subpanels[0], ��ä����
		ButtonGroup bbs_gb_group = new ButtonGroup();
		this.bbs_gb = new JRadioButton[] {new JRadioButton("��� ä�����"), new JRadioButton("����� ��ä�Ӻ��� ����")};
		
		//subpanels[1], ���忩��
		this.stocks = new JCheckBox[] {new JCheckBox("��������"), new JCheckBox("�ڽ���"), new JCheckBox("������")};
		
		//subpanels[2], ����/���Լ���
		this.sr = new JCheckBox("�������/�İ߾�ü ���� ����");
		
		//subpanels[3], �ٹ�����
		this.job_type_group = new ButtonGroup();
		JRadioButton[] job_type = new JRadioButton[] {new JRadioButton("��ü"), new JRadioButton("������"), new JRadioButton("�����"), new JRadioButton("����Ư��"), new JRadioButton("������"), 
				new JRadioButton("�Ƹ�����Ʈ"), new JRadioButton("�İ���"), new JRadioButton("�ؿ����"), new JRadioButton("������"), new JRadioButton("��������"), 
				new JRadioButton("����� (������ ��ȯ����)"), new JRadioButton("������ (������ ��ȯ����)"), new JRadioButton("������"), new JRadioButton("������"), new JRadioButton("��Ʈ"), 
				new JRadioButton("����"), new JRadioButton("�Ⱓ��"), new JRadioButton("��������"), new JRadioButton("���������"), new JRadioButton("�����������"),
				new JRadioButton("�����ɿ��"), new JRadioButton("����"), new JRadioButton("���濪")};
		
		//subpanels[4], �з�
		this.edu_lv_group = new ButtonGroup();
		JRadioButton[] edu_lv = new JRadioButton[] {new JRadioButton("��ü"), new JRadioButton("����б� ����"), new JRadioButton("����(2,3��) ����"), new JRadioButton("���б�(4��) ����"), new JRadioButton("��������"), 
				new JRadioButton("�ڻ�����"), new JRadioButton("�з¹���")};
		
		// ����
		this.local = new JComboBox<String>();
		this.local.addItem("��ü");
		for(LocalCode lc : LocalCode.values()) {
			this.local.addItem(lc.getLocalName());
		}
		
		// ����
		this.industry = new JComboBox<String>();
		this.industry.addItem("��ü");
		for(IndustryCode idc : IndustryCode.values()) {
			this.industry.addItem(idc.getIndCodeName());
		}
		
		// ����
		this.jobtype = new JComboBox<String>();
		this.jobtype.addItem("��ü");
		for(JobTypeCode jtc : JobTypeCode.values()) {
			this.jobtype.addItem(jtc.getJobTypeName());
		}
		
		//subpanels 4�� �� �߰�
		for(int i = 0; i < subpanels.length-1; i++) {
			subpanels[i].add(labels[i]);
		}
		
		//subpanels[0]�� ��ä���� �׸� �߰�
		for(int i = 0; i < bbs_gb.length; i++) {
			bbs_gb_group.add(bbs_gb[i]);
			subpanels[0].add(bbs_gb[i]);
		}
		
		//subpannels[1]�� ���忩�� �׸� �߰�
		for(int i =0; i < stocks.length; i++) {
			subpanels[1].add(stocks[i]);
		}
		
		//subpannels[2]�� ���忩�� �׸� �߰�
		subpanels[2].add(sr);
		
		//subpanels[3]�� �ٹ����� ���� ���� ��ư �߰�
		for(int i = 0; i < job_type.length; i++) {
			this.job_type_group.add(job_type[i]);
			subpanels[3].add(job_type[i]);
		}
		
		//subpanels[4]�� �з°��� ��ư �߰�
		for(int i = 0; i < edu_lv.length; i++) {
			this.edu_lv_group.add(edu_lv[i]);
			subpanels[4].add(edu_lv[i]);
		}
		
		//subpannels[5] ����, ����, ���� ���� �߰�
		
		labels[5].setHorizontalAlignment(JLabel.CENTER);
		subpanels[5].add(labels[5]);
		subpanels[5].add(this.local);
		labels[6].setHorizontalAlignment(JLabel.CENTER);
		subpanels[5].add(labels[6]);
		subpanels[5].add(this.industry);
		labels[7].setHorizontalAlignment(JLabel.CENTER);
		subpanels[5].add(labels[7]);
		subpanels[5].add(this.jobtype);
		
		setLayout(new GridLayout(0,1));
		
		for(int i = 0; i < subpanels.length; i++) {
			add(subpanels[i]);
		}
		
	}
	
	public String apiUrlString(String keyword, int start, int count) {
		StringBuffer buf = new StringBuffer();
		boolean currentParameterisFirst = true;
		buf.append("https://oapi.saramin.co.kr/job-search");
		buf.append("?access-key=FPNIlnU9yxRehTduycQeOFm1zYGVzPntsJMMgBAEUPnxBr2VnJ0u");
		// Ű����
		if(keyword == "" || keyword == null) {
			buf.append("");
		} else {
			buf.append("&keywords="+keyword);
		}
		
		// ��ä����
		if(this.bbs_gb[0].isSelected()) {
			buf.append("&bbs_gb=0");
		} else if(this.bbs_gb[1].isSelected()) {
			buf.append("&bbs_gb=1");
		} else {
			buf.append("");
		}
		
		// ���忩��
		if(this.stocks[0].isSelected()) {
			if(currentParameterisFirst) {
				buf.append("&stocks=");
			} else {
				buf.append("&stocks=kospi");
				currentParameterisFirst = false;
			}
		}
		
		if(this.stocks[1].isSelected()) {
			if(currentParameterisFirst) {
				buf.append("&stocks=kosdaq");
			} else {
				buf.append("+kosdaq");
				currentParameterisFirst = false;
			}
		}
		
		if(this.stocks[2].isSelected()) {
			if(currentParameterisFirst) {
				buf.append("&stocks=nasdaq");
			} else {
				buf.append("+nasdaq");
				currentParameterisFirst = false;
			}
		}
				
		if(this.stocks[0].isSelected() == false && this.stocks[1].isSelected() == false && this.stocks[2].isSelected() == false) {
			buf.append("");
		}
		currentParameterisFirst = true;

		// �������/�İ߾�ü ���� ����
		if(this.sr.isSelected()) {
			buf.append("&sr=directhire");
		} else {
			buf.append("");
		}
		
		// �ٹ� ����
		Enumeration<AbstractButton> job_type_enums = this.job_type_group.getElements();
		String name = "";
		while(job_type_enums.hasMoreElements()) {
			AbstractButton ab = job_type_enums.nextElement();
			JRadioButton jb = (JRadioButton)ab;
			
			if(jb.isSelected()) {
				name = jb.getText();
			}
		}
		
		switch(name) {
			case "��ü":	buf.append("&job_type=");
				break;
			case "������": buf.append("&job_type=1");
				break;
			case "�����": buf.append("&job_type=2");
				break;
			case "����Ư��": buf.append("&job_type=3");
				break;
			case "������": buf.append("&job_type=4");
				break;
			case "�Ƹ�����Ʈ": buf.append("&job_type=5");
				break;
			case "�İ���": buf.append("&job_type=6");
				break;
			case "�ؿ����": buf.append("&job_type=7");
				break;
			case "������": buf.append("&job_type=8");
				break;
			case "��������": buf.append("&job_type=9");
				break;
			case "����� (������ ��ȯ����)": buf.append("&job_type=10");
				break;
			case "������ (������ ��ȯ����)": buf.append("&job_type=11");
				break;
			case "������": buf.append("&job_type=12");
				break;
			case "������": buf.append("&job_type=13");
				break;
			case "��Ʈ": buf.append("&job_type=14");
				break;
			case "����": buf.append("&job_type=15");
				break;
			case "�Ⱓ��": buf.append("&job_type=16");
				break;
			case "��������": buf.append("&job_type=17");
				break;
			case "���������" : buf.append("&job_type=18");
				break;
			case "�����������" : buf.append("&job_type=19");
				break;
			case "�����ɿ��" : buf.append("&job_type=20");
				break;
			case "����" : buf.append("&job_type=21");
				break;
			case "���濪" : buf.append("&job_type=22");
				break;
			default : buf.append("");
				break;
		}
		
		// �з°��� 
		Enumeration<AbstractButton> edu_lv_enums = this.job_type_group.getElements();
		name = "";
		while(edu_lv_enums.hasMoreElements()) {
			AbstractButton ab = edu_lv_enums.nextElement();
			JRadioButton jb = (JRadioButton)ab;
			
			if(jb.isSelected()) {
				name = jb.getText();
			}
		}
		
		switch(name) {
			case "��ü" : buf.append("&edu_lv=");
				break;
			case "�з¹���" : buf.append("&edu_lv=0");
				break;
			case "����б�����" : buf.append("&edu_lv=1");
				break;
			case "��������(2,3��)" : buf.append("&edu_lv=2");
				break;
			case "���б�����(4��)" : buf.append("&edu_lv=3");
				break;
			case "��������" : buf.append("&edu_lv=4");
				break;
			case "�ڻ�����" : buf.append("&edu_lv=5");
				break;
			case "����б������̻�" : buf.append("&edu_lv=6");
				break;
			case "��������(2,3��)�̻�" : buf.append("&edu_lv=7");
				break;
			case "���б�����(4��)�̻�" : buf.append("&edu_lv=8");
				break;
			case "���������̻�" : buf.append("&edu_lv=9");
				break;
			default : buf.append("");
				break;
		}
		
		if(!this.local.getSelectedItem().toString().equalsIgnoreCase("��ü")) {
			LocalCode lc = LocalCode.L1;
			buf.append("&loc_cd=");
			buf.append(lc.returnCode(this.local.getSelectedItem().toString()));
		}
		
		if(!this.industry.getSelectedItem().toString().equalsIgnoreCase("��ü")) {
			IndustryCode ic = IndustryCode.ind_cd0;
			buf.append("&ind_cd=");
			buf.append(ic.returnIndCode(this.industry.getSelectedItem().toString()));
		}
		
		if(!this.jobtype.getSelectedItem().toString().equalsIgnoreCase("��ü")) {
			JobTypeCode jc = JobTypeCode.JT0;
			buf.append("&job_category=");
			buf.append(jc.returnJobTypeCode(this.jobtype.getSelectedItem().toString()));
		}
		
		buf.append("&fields=posting-date+expiration-date+keyword-code+count");
		buf.append("&start="+start);
		buf.append("&count="+count);
		
		System.out.println(buf.toString());
		
		return buf.toString();
	}
}
