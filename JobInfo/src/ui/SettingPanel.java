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
		this.jl = new JLabel[] {new JLabel("근무형태"), new JLabel("학력"), new JLabel("연봉"), new JLabel("근무지"), new JLabel("산업/업종"), new JLabel("직업/직종")};
		this.ce = new Choice[] {new Choice(), new Choice(), new Choice(), new Choice(), new Choice(), new Choice()};
		this.jb = new JButton[] {};
		this.setLayout(new GridLayout(0,1));
		for(int i=0; i<jp.length; i++) {
			this.jp[i].add(jl[i]);
			this.jp[i].add(ce[i]);
			this.add(jp[i]);
		}
		ce[0].add("정규직");ce[0].add("계약직");ce[0].add("병역특례");ce[0].add("인턴직");ce[0].add("아르바이트");
		ce[0].add("파견직");ce[0].add("해외취업");ce[0].add("위촉직");ce[0].add("프리랜서");ce[0].add("계약직 (정규직 전환가능)");
		ce[0].add("인턴직 (정규직 전환가능)");ce[0].add("교육생");ce[0].add("별정직");ce[0].add("파트");ce[0].add("전임");
		ce[0].add("기간제");ce[0].add("무기계약직");ce[0].add("전문계약직");ce[0].add("전문연구요원");ce[0].add("산업기능요원");
		ce[0].add("현역");ce[0].add("	보충역");
		
		ce[1].add("학력무관");ce[1].add("고등학교졸업");ce[1].add("대학졸업(2,3년)");ce[1].add("대학교졸업(4년)");ce[1].add("석사졸업");
		ce[1].add("박사졸업");ce[1].add("고등학교졸업이상");ce[1].add("대학졸업(2,3년)이상");ce[1].add("대학교졸업(4년)이상");ce[1].add("석사졸업이상");
		
		ce[2].add("회사내규에 따름");ce[2].add("1,400 만원 이하");ce[2].add("1,400~1,600만원");ce[2].add("1,600~1,800만원");ce[2].add("1,800~2,000만원");
		ce[2].add("2,000~2,200만원");ce[2].add("2,200~2,400만원");ce[2].add("2,400~2,600만원");ce[2].add("2,600~2,800만원");ce[2].add("2,800~3,000만원");
		ce[2].add("3,000~3,200만원");ce[2].add("3,200~3,400만원");ce[2].add("3,400~3,600만원");ce[2].add("3,600~3,800만원");ce[2].add("3,800~4,000만원");
		ce[2].add("4,000~5,000만원");ce[2].add("5,000~6,000만원");ce[2].add("6,000~7,000만원");ce[2].add("7,000~8,000만원");ce[2].add("8,000~9,000만원");
		ce[2].add("9,000~1억원");ce[2].add("1억원 이상");ce[2].add("면접후 결정");
		
		ce[3].add("서울전체");ce[3].add("경기전체");
		
		ce[4].add("솔루션·SI·ERP·CRM");ce[4].add("웹에이젼시");ce[4].add("쇼핑몰·오픈마켓");ce[4].add("포털·인터넷·컨텐츠");
		ce[4].add("네트워크·통신·모바일");ce[4].add("하드웨어·장비");ce[4].add("정보보안·백신");ce[4].add("IT컨설팅");
		ce[4].add("게임");
		
		ce[5].add("웹마스터·QA·테스터");ce[5].add("서버·네트워크·보안");ce[5].add("웹기획·PM");ce[5].add("웹개발");ce[5].add("게임·Game");
		ce[5].add("컨텐츠·사이트운영");ce[5].add("응용프로그램개발");ce[5].add("시스템개발");ce[5].add("ERP·시스템분석·설계");ce[5].add("통신·모바일");
		ce[5].add("하드웨어·소프트웨어");ce[5].add("웹디자인");ce[5].add("퍼블리싱·UI개발");ce[5].add("동영상·편집·코덱");ce[5].add("IT·디자인·컴퓨터교육");
		ce[5].add("데이터베이스·DBA");ce[5].add("인공지능(AI)·빅데이터");
		
	}
	
	public String getArguments() {
		
		return this.arguments;
	}
}
