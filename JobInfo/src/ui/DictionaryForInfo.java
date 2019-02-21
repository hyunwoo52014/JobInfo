package ui;

public enum DictionaryForInfo {
	edu_lv0(0,"학력무관"),
	edu_lv1(1,"고등학교졸업"),
	edu_lv2(2,"대학졸업(2,3년)"),
	edu_lv3(3,"대학교졸업(4년)"),
	edu_lv4(4,"석사졸업"),
	edu_lv5(5,"박사졸업"),
	edu_lv6(6,"고등학교졸업이상"),
	edu_lv7(7,"대학졸업(2,3년)이상"),
	edu_lv8(8,"대학교졸업(4년)이상"),
	edu_lv9(9,"석사졸업이상"),
	ind_cd301(301,"솔루션·SI·ERP·CRM"),
	ind_cd302(302,"웹에이젼시"),
	ind_cd304(304,"쇼핑몰·오픈마켓"),
	ind_cd305(305,"포털·인터넷·컨텐츠"),
	ind_cd306(306,"네트워크·통신·모바일"),
	ind_cd307(307,"하드웨어·장비"),
	ind_cd308(308,"정보보안·백신"),
	ind_cd313(313,"IT컨설팅"),
	ind_cd314(314,"게임"),
	job_category401(401,"웹마스터·QA·테스터"),
	job_category402(402,"서버·네트워크·보안"),
	job_category403(403,"웹기획·PM"),
	job_category404(404,"웹개발"),
	job_category405(405,"게임·Game"),
	job_category406(406,"컨텐츠·사이트운영"),
	job_category407(407,"응용프로그램개발"),
	job_category408(408,"시스템개발"),
	job_category409(409,"ERP·시스템분석·설계"),
	job_category410(410,"통신·모바일"),
	job_category411(411,"하드웨어·소프트웨어"),
	job_category412(412,"웹디자인"),
	job_category413(413,"퍼블리싱·UI개발"),
	job_category414(414,"동영상·편집·코덱"),
	job_category415(415,"IT·디자인·컴퓨터교육"),
	job_category416(416,"데이터베이스·DBA"),
	job_category417(417,"인공지능(AI)·빅데이터"),
	jobtype1(1,"정규직"),
	jobtype2(2,"계약직"),
	jobtype3(3,"병역특례"),
	jobtype4(4,"인턴직"),
	jobtype5(5,"아르바이트"),
	jobtype6(6,"파견직"),
	jobtype7(7,"해외취업"),
	jobtype8(8,"위촉직"),
	jobtype9(9,"프리랜서"),
	jobtype10(10,"계약직 (정규직 전환가능)"),
	jobtype11(11,"인턴직 (정규직 전환가능)"),
	jobtype12(12,"교육생"),
	jobtype13(13,"별정직"),
	jobtype14(14,"파트"),
	jobtype15(15,"전임"),
	jobtype16(16,"기간제"),
	jobtype17(17,"무기계약직"),
	jobtype18(18,"전문계약직"),
	jobtype19(19,"전문연구요원"),
	jobtype20(20,"산업기능요원"),
	jobtype21(21,"현역"),
	jobtype22(22,"보충역"),
	loc_cd101000(101000,"서울전체"),
	loc_cd102000(102000,"경기전체"),
	salary0(0,"회사내규에 따름"),
	salary3(3,"1,400 만원 이하"),
	salary4(4,"1,400~1,600만원"),
	salary5(5,"1,600~1,800만원"),
	salary6(6,"1,800~2,000만원"),
	salary7(7,"2,000~2,200만원"),
	salary8(8,"2,200~2,400만원"),
	salary9(9,"2,400~2,600만원"),
	salary10(10,"2,600~2,800만원"),
	salary11(11,"2,800~3,000만원"),
	salary12(12,"3,000~3,200만원"),
	salary13(13,"3,200~3,400만원"),
	salary14(14,"3,400~3,600만원"),
	salary15(15,"3,600~3,800만원"),
	salary16(16,"3,800~4,000만원"),
	salary17(17,"4,000~5,000만원"),
	salary18(18,"5,000~6,000만원"),
	salary19(19,"6,000~7,000만원"),
	salary20(20,"7,000~8,000만원"),
	salary21(21,"8,000~9,000만원"),
	salary22(22,"9,000~1억원"),
	salary23(23,"1억원 이상"),
	salary99(99,"면접후 결정");
	
	private int index;
	private String name;
	
	private DictionaryForInfo(int index, String name) {
		this.index = index;
		this.name = name;
	}
	
	public int getIndex() {
		return index;
	}
	
	public String getName() {
		return name;
	}
}
