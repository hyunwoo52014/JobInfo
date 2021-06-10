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
		
		//각 subpanels의 라벨
		JLabel[] labels = {new JLabel("공채구분"), new JLabel("상장여부"), new JLabel("제외/포함설정"), new JLabel("근무 형태"),
				new JLabel("학력"), new JLabel("지역"), new JLabel("업종"), new JLabel("직종")};
		
		//subpanels[0], 공채구분
		ButtonGroup bbs_gb_group = new ButtonGroup();
		this.bbs_gb = new JRadioButton[] {new JRadioButton("모든 채용공고"), new JRadioButton("사람인 공채속보만 포함")};
		
		//subpanels[1], 상장여부
		this.stocks = new JCheckBox[] {new JCheckBox("유가증권"), new JCheckBox("코스닥"), new JCheckBox("나스닥")};
		
		//subpanels[2], 제외/포함설정
		this.sr = new JCheckBox("헤드헌팅/파견업체 공고 제외");
		
		//subpanels[3], 근무형태
		this.job_type_group = new ButtonGroup();
		JRadioButton[] job_type = new JRadioButton[] {new JRadioButton("전체"), new JRadioButton("정규직"), new JRadioButton("계약직"), new JRadioButton("병역특례"), new JRadioButton("인턴직"), 
				new JRadioButton("아르바이트"), new JRadioButton("파견직"), new JRadioButton("해외취업"), new JRadioButton("위촉직"), new JRadioButton("프리랜서"), 
				new JRadioButton("계약직 (정규직 전환가능)"), new JRadioButton("인턴직 (정규직 전환가능)"), new JRadioButton("교육생"), new JRadioButton("별정직"), new JRadioButton("파트"), 
				new JRadioButton("전임"), new JRadioButton("기간제"), new JRadioButton("무기계약직"), new JRadioButton("전문계약직"), new JRadioButton("전문연구요원"),
				new JRadioButton("산업기능요원"), new JRadioButton("현역"), new JRadioButton("보충역")};
		
		//subpanels[4], 학력
		this.edu_lv_group = new ButtonGroup();
		JRadioButton[] edu_lv = new JRadioButton[] {new JRadioButton("전체"), new JRadioButton("고등학교 졸업"), new JRadioButton("대학(2,3년) 졸업"), new JRadioButton("대학교(4년) 졸업"), new JRadioButton("석사졸업"), 
				new JRadioButton("박사졸업"), new JRadioButton("학력무관")};
		
		// 지역
		this.local = new JComboBox<String>();
		this.local.addItem("전체");
		for(LocalCode lc : LocalCode.values()) {
			this.local.addItem(lc.getLocalName());
		}
		
		// 업종
		this.industry = new JComboBox<String>();
		this.industry.addItem("전체");
		for(IndustryCode idc : IndustryCode.values()) {
			this.industry.addItem(idc.getIndCodeName());
		}
		
		// 직종
		this.jobtype = new JComboBox<String>();
		this.jobtype.addItem("전체");
		for(JobTypeCode jtc : JobTypeCode.values()) {
			this.jobtype.addItem(jtc.getJobTypeName());
		}
		
		//subpanels 4개 라벨 추가
		for(int i = 0; i < subpanels.length-1; i++) {
			subpanels[i].add(labels[i]);
		}
		
		//subpanels[0]에 공채구분 항목 추가
		for(int i = 0; i < bbs_gb.length; i++) {
			bbs_gb_group.add(bbs_gb[i]);
			subpanels[0].add(bbs_gb[i]);
		}
		
		//subpannels[1]에 상장여부 항목 추가
		for(int i =0; i < stocks.length; i++) {
			subpanels[1].add(stocks[i]);
		}
		
		//subpannels[2]에 상장여부 항목 추가
		subpanels[2].add(sr);
		
		//subpanels[3]에 근무형태 관련 라디오 버튼 추가
		for(int i = 0; i < job_type.length; i++) {
			this.job_type_group.add(job_type[i]);
			subpanels[3].add(job_type[i]);
		}
		
		//subpanels[4]에 학력관련 버튼 추가
		for(int i = 0; i < edu_lv.length; i++) {
			this.edu_lv_group.add(edu_lv[i]);
			subpanels[4].add(edu_lv[i]);
		}
		
		//subpannels[5] 지역, 업종, 직종 관련 추가
		
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
		// 키워드
		if(keyword == "" || keyword == null) {
			buf.append("");
		} else {
			buf.append("&keywords="+keyword);
		}
		
		// 공채구분
		if(this.bbs_gb[0].isSelected()) {
			buf.append("&bbs_gb=0");
		} else if(this.bbs_gb[1].isSelected()) {
			buf.append("&bbs_gb=1");
		} else {
			buf.append("");
		}
		
		// 상장여부
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

		// 헤드헌팅/파견업체 공고 제외
		if(this.sr.isSelected()) {
			buf.append("&sr=directhire");
		} else {
			buf.append("");
		}
		
		// 근무 형태
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
			case "전체":	buf.append("&job_type=");
				break;
			case "정규직": buf.append("&job_type=1");
				break;
			case "계약직": buf.append("&job_type=2");
				break;
			case "병역특례": buf.append("&job_type=3");
				break;
			case "인턴직": buf.append("&job_type=4");
				break;
			case "아르바이트": buf.append("&job_type=5");
				break;
			case "파견직": buf.append("&job_type=6");
				break;
			case "해외취업": buf.append("&job_type=7");
				break;
			case "위촉직": buf.append("&job_type=8");
				break;
			case "프리랜서": buf.append("&job_type=9");
				break;
			case "계약직 (정규직 전환가능)": buf.append("&job_type=10");
				break;
			case "인턴직 (정규직 전환가능)": buf.append("&job_type=11");
				break;
			case "교육생": buf.append("&job_type=12");
				break;
			case "별정직": buf.append("&job_type=13");
				break;
			case "파트": buf.append("&job_type=14");
				break;
			case "전임": buf.append("&job_type=15");
				break;
			case "기간제": buf.append("&job_type=16");
				break;
			case "무기계약직": buf.append("&job_type=17");
				break;
			case "전문계약직" : buf.append("&job_type=18");
				break;
			case "전문연구요원" : buf.append("&job_type=19");
				break;
			case "산업기능요원" : buf.append("&job_type=20");
				break;
			case "현역" : buf.append("&job_type=21");
				break;
			case "보충역" : buf.append("&job_type=22");
				break;
			default : buf.append("");
				break;
		}
		
		// 학력관련 
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
			case "전체" : buf.append("&edu_lv=");
				break;
			case "학력무관" : buf.append("&edu_lv=0");
				break;
			case "고등학교졸업" : buf.append("&edu_lv=1");
				break;
			case "대학졸업(2,3년)" : buf.append("&edu_lv=2");
				break;
			case "대학교졸업(4년)" : buf.append("&edu_lv=3");
				break;
			case "석사졸업" : buf.append("&edu_lv=4");
				break;
			case "박사졸업" : buf.append("&edu_lv=5");
				break;
			case "고등학교졸업이상" : buf.append("&edu_lv=6");
				break;
			case "대학졸업(2,3년)이상" : buf.append("&edu_lv=7");
				break;
			case "대학교졸업(4년)이상" : buf.append("&edu_lv=8");
				break;
			case "석사졸업이상" : buf.append("&edu_lv=9");
				break;
			default : buf.append("");
				break;
		}
		
		if(!this.local.getSelectedItem().toString().equalsIgnoreCase("전체")) {
			LocalCode lc = LocalCode.L1;
			buf.append("&loc_cd=");
			buf.append(lc.returnCode(this.local.getSelectedItem().toString()));
		}
		
		if(!this.industry.getSelectedItem().toString().equalsIgnoreCase("전체")) {
			IndustryCode ic = IndustryCode.ind_cd0;
			buf.append("&ind_cd=");
			buf.append(ic.returnIndCode(this.industry.getSelectedItem().toString()));
		}
		
		if(!this.jobtype.getSelectedItem().toString().equalsIgnoreCase("전체")) {
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
