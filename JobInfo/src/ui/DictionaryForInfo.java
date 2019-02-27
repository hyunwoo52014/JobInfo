package ui;

import java.util.HashMap;
import java.util.Map;

public class DictionaryForInfo {
	private Map<String, String> edu_lv = new HashMap<String, String>();
	private Map<String, String> ind_cd = new HashMap<String, String>();
	private Map<String, String> job_category = new HashMap<String, String>();
	private Map<String, String> jobtype = new HashMap<String, String>();
	private Map<String, String> loc_cd = new HashMap<String, String>();
	private Map<String, String> salary = new HashMap<String, String>();
	
	public DictionaryForInfo() {
		edu_lv_init();
		ind_cd_init();
		job_category_init();
		jobtype_init();
		loc_cd_init();
		salary_init();
	}

	private void salary_init() {
		// TODO Auto-generated method stub
		this.salary.put("0","회사내규에 따름");
		this.salary.put("3","1,400 만원 이하");
		this.salary.put("4","1,400~1,600만원");
		this.salary.put("5","1,600~1,800만원");
		this.salary.put("6","1,800~2,000만원");
		this.salary.put("7","2,000~2,200만원");
		this.salary.put("8","2,200~2,400만원");
		this.salary.put("9","2,400~2,600만원");
		this.salary.put("10","2,600~2,800만원");
		this.salary.put("11","2,800~3,000만원");
		this.salary.put("12","3,000~3,200만원");
		this.salary.put("13","3,200~3,400만원");
		this.salary.put("14","3,400~3,600만원");
		this.salary.put("15","3,600~3,800만원");
		this.salary.put("16","3,800~4,000만원");
		this.salary.put("17","4,000~5,000만원");
		this.salary.put("18","5,000~6,000만원");
		this.salary.put("19","6,000~7,000만원");
		this.salary.put("20","7,000~8,000만원");
		this.salary.put("21","8,000~9,000만원");
		this.salary.put("22","9,000~1억원");
		this.salary.put("23","1억원 이상");
		this.salary.put("99","면접후 결정");
	}

	private void loc_cd_init() {
		// TODO Auto-generated method stub
		this.loc_cd.put("101000","서울전체");
		this.loc_cd.put("102000","경기전체");
	}
	
	private void jobtype_init() {
		// TODO Auto-generated method stub
		this.jobtype.put("1","정규직");
		this.jobtype.put("2","계약직");
		this.jobtype.put("3","병역특례");
		this.jobtype.put("4","인턴직");
		this.jobtype.put("5","아르바이트");
		this.jobtype.put("6","파견직");
		this.jobtype.put("7","해외취업");
		this.jobtype.put("8","위촉직");
		this.jobtype.put("9","프리랜서");
		this.jobtype.put("10","계약직 (정규직 전환가능)");
		this.jobtype.put("11","인턴직 (정규직 전환가능)");
		this.jobtype.put("12","교육생");
		this.jobtype.put("13","별정직");
		this.jobtype.put("14","파트");
		this.jobtype.put("15","전임");
		this.jobtype.put("16","기간제");
		this.jobtype.put("17","무기계약직");
		this.jobtype.put("18","전문계약직");
		this.jobtype.put("19","전문연구요원");
		this.jobtype.put("20","산업기능요원");
		this.jobtype.put("21","현역");
		this.jobtype.put("22","보충역");
	}
	
	private void job_category_init() {
		// TODO Auto-generated method stub
		this.job_category.put("401","웹마스터·QA·테스터");
		this.job_category.put("402","서버·네트워크·보안");
		this.job_category.put("403","웹기획·PM");
		this.job_category.put("404","웹개발");
		this.job_category.put("405","게임·Game");
		this.job_category.put("406","컨텐츠·사이트운영");
		this.job_category.put("407","응용프로그램개발");
		this.job_category.put("408","시스템개발");
		this.job_category.put("409","ERP·시스템분석·설계");
		this.job_category.put("410","통신·모바일");
		this.job_category.put("411","하드웨어·소프트웨어");
		this.job_category.put("412","웹디자인");
		this.job_category.put("413","퍼블리싱·UI개발");
		this.job_category.put("414","동영상·편집·코덱");
		this.job_category.put("415","IT·디자인·컴퓨터교육");
		this.job_category.put("416","데이터베이스·DBA");
		this.job_category.put("417","인공지능(AI)·빅데이터");
	}
	
	private void ind_cd_init() {
		// TODO Auto-generated method stub
		this.ind_cd.put("301","솔루션·SI·ERP·CRM");
		this.ind_cd.put("302","웹에이젼시");
		this.ind_cd.put("304","쇼핑몰·오픈마켓");
		this.ind_cd.put("305","포털·인터넷·컨텐츠");
		this.ind_cd.put("306","네트워크·통신·모바일");
		this.ind_cd.put("307","하드웨어·장비");
		this.ind_cd.put("308","정보보안·백신");
		this.ind_cd.put("313","IT컨설팅");
		this.ind_cd.put("314","게임");
	}
	
	private void edu_lv_init() {
		this.edu_lv.put("0","학력무관");
		this.edu_lv.put("1","고등학교졸업");
		this.edu_lv.put("2","대학졸업(2,3년)");
		this.edu_lv.put("3","대학교졸업(4년)");
		this.edu_lv.put("4","석사졸업");
		this.edu_lv.put("5","박사졸업");
		this.edu_lv.put("6","고등학교졸업이상");
		this.edu_lv.put("7","대학졸업(2,3년)이상");
		this.edu_lv.put("8","대학교졸업(4년)이상");
		this.edu_lv.put("9","석사졸업이상");
	}

	
	private String getJobTypeValue(String index) {
		return this.jobtype.get(index);
	}
	
	private String getJobTypeKey(String value) {
		for(Object o : this.jobtype.keySet()) {
			if(this.jobtype.get(o).equals(value)) {
				return o.toString();
			}
		}
		return "";
	}

	private String getEduLvValue(String index) {
		return this.edu_lv.get(index);
	}
	
	private String getEduLvKey(String value) {
		for(Object o : this.edu_lv.keySet()) {
			if(this.edu_lv.get(o).equals(value)) {
				return o.toString();
			}
		}
		return "";
	}

	private String getLocCdValue(String index) {
		return this.loc_cd.get(index);
	}

	private String getLocCdKey(String value) {
		for(Object o : this.loc_cd.keySet()) {
			if(this.loc_cd.get(o).equals(value)) {
				return o.toString();
			}
		}
		return "";
	}

	private String getIndCdValue(String index) {
		return this.ind_cd.get(index);
	}

	private String getIndCdKey(String value) {
		for(Object o : this.ind_cd.keySet()) {
			if(this.ind_cd.get(o).equals(value)) {
				return o.toString();
			}
		}
		return "";
	}

	private String getJobCategoryValue(String index) {
		return this.job_category.get(index);
	}

	private String getJobCategoryKey(String value) {
		for(Object o : this.job_category.keySet()) {
			if(this.job_category.get(o).equals(value)) {
				return o.toString();
			}
		}
		return "";
	}

	private String getSalaryValue(String index) {
		return this.salary.get(index);
	}
	
	private String getSalaryKey(String value) {
		for(Object o : this.salary.keySet()) {
			if(this.salary.get(o).equals(value)) {
				return o.toString();
			}
		}
		return "";
	}

	public String getKey(int selector, String index) {
		switch(selector) {
		case 0: return getJobTypeKey(index);
		case 1: return getEduLvKey(index);
		case 2: return getLocCdKey(index);
		case 3: return getIndCdKey(index);
		case 4: return getJobCategoryKey(index);
		case 5: return getSalaryKey(index);
		default: break;
		}
		return null;
	}
	
	public String getValue(int selector, String index) {
		switch(selector) {
		case 0: return getJobTypeValue(index);
		case 1: return getEduLvValue(index);
		case 2: return getLocCdValue(index);
		case 3: return getIndCdValue(index);
		case 4: return getJobCategoryValue(index);
		case 5: return getSalaryValue(index);
		default: break;
		}
		return null;
	}
}