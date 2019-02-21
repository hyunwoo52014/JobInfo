package ui;

public enum DictionaryForInfo {
	edu_lv0(0,"�з¹���"),
	edu_lv1(1,"����б�����"),
	edu_lv2(2,"��������(2,3��)"),
	edu_lv3(3,"���б�����(4��)"),
	edu_lv4(4,"��������"),
	edu_lv5(5,"�ڻ�����"),
	edu_lv6(6,"����б������̻�"),
	edu_lv7(7,"��������(2,3��)�̻�"),
	edu_lv8(8,"���б�����(4��)�̻�"),
	edu_lv9(9,"���������̻�"),
	ind_cd301(301,"�ַ�ǡ�SI��ERP��CRM"),
	ind_cd302(302,"����������"),
	ind_cd304(304,"���θ������¸���"),
	ind_cd305(305,"���С����ͳݡ�������"),
	ind_cd306(306,"��Ʈ��ũ����š������"),
	ind_cd307(307,"�ϵ������"),
	ind_cd308(308,"�������ȡ����"),
	ind_cd313(313,"IT������"),
	ind_cd314(314,"����"),
	job_category401(401,"�������͡�QA���׽���"),
	job_category402(402,"��������Ʈ��ũ������"),
	job_category403(403,"����ȹ��PM"),
	job_category404(404,"������"),
	job_category405(405,"���ӡ�Game"),
	job_category406(406,"������������Ʈ�"),
	job_category407(407,"�������α׷�����"),
	job_category408(408,"�ý��۰���"),
	job_category409(409,"ERP���ý��ۺм�������"),
	job_category410(410,"��š������"),
	job_category411(411,"�ϵ�������Ʈ����"),
	job_category412(412,"��������"),
	job_category413(413,"�ۺ��̡�UI����"),
	job_category414(414,"�������������ڵ�"),
	job_category415(415,"IT�������Ρ���ǻ�ͱ���"),
	job_category416(416,"�����ͺ��̽���DBA"),
	job_category417(417,"�ΰ�����(AI)��������"),
	jobtype1(1,"������"),
	jobtype2(2,"�����"),
	jobtype3(3,"����Ư��"),
	jobtype4(4,"������"),
	jobtype5(5,"�Ƹ�����Ʈ"),
	jobtype6(6,"�İ���"),
	jobtype7(7,"�ؿ����"),
	jobtype8(8,"������"),
	jobtype9(9,"��������"),
	jobtype10(10,"����� (������ ��ȯ����)"),
	jobtype11(11,"������ (������ ��ȯ����)"),
	jobtype12(12,"������"),
	jobtype13(13,"������"),
	jobtype14(14,"��Ʈ"),
	jobtype15(15,"����"),
	jobtype16(16,"�Ⱓ��"),
	jobtype17(17,"��������"),
	jobtype18(18,"���������"),
	jobtype19(19,"�����������"),
	jobtype20(20,"�����ɿ��"),
	jobtype21(21,"����"),
	jobtype22(22,"���濪"),
	loc_cd101000(101000,"������ü"),
	loc_cd102000(102000,"�����ü"),
	salary0(0,"ȸ�系�Կ� ����"),
	salary3(3,"1,400 ���� ����"),
	salary4(4,"1,400~1,600����"),
	salary5(5,"1,600~1,800����"),
	salary6(6,"1,800~2,000����"),
	salary7(7,"2,000~2,200����"),
	salary8(8,"2,200~2,400����"),
	salary9(9,"2,400~2,600����"),
	salary10(10,"2,600~2,800����"),
	salary11(11,"2,800~3,000����"),
	salary12(12,"3,000~3,200����"),
	salary13(13,"3,200~3,400����"),
	salary14(14,"3,400~3,600����"),
	salary15(15,"3,600~3,800����"),
	salary16(16,"3,800~4,000����"),
	salary17(17,"4,000~5,000����"),
	salary18(18,"5,000~6,000����"),
	salary19(19,"6,000~7,000����"),
	salary20(20,"7,000~8,000����"),
	salary21(21,"8,000~9,000����"),
	salary22(22,"9,000~1���"),
	salary23(23,"1��� �̻�"),
	salary99(99,"������ ����");
	
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
