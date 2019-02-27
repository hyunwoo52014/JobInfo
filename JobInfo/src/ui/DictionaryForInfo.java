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
		this.salary.put("0","ȸ�系�Կ� ����");
		this.salary.put("3","1,400 ���� ����");
		this.salary.put("4","1,400~1,600����");
		this.salary.put("5","1,600~1,800����");
		this.salary.put("6","1,800~2,000����");
		this.salary.put("7","2,000~2,200����");
		this.salary.put("8","2,200~2,400����");
		this.salary.put("9","2,400~2,600����");
		this.salary.put("10","2,600~2,800����");
		this.salary.put("11","2,800~3,000����");
		this.salary.put("12","3,000~3,200����");
		this.salary.put("13","3,200~3,400����");
		this.salary.put("14","3,400~3,600����");
		this.salary.put("15","3,600~3,800����");
		this.salary.put("16","3,800~4,000����");
		this.salary.put("17","4,000~5,000����");
		this.salary.put("18","5,000~6,000����");
		this.salary.put("19","6,000~7,000����");
		this.salary.put("20","7,000~8,000����");
		this.salary.put("21","8,000~9,000����");
		this.salary.put("22","9,000~1���");
		this.salary.put("23","1��� �̻�");
		this.salary.put("99","������ ����");
	}

	private void loc_cd_init() {
		// TODO Auto-generated method stub
		this.loc_cd.put("101000","������ü");
		this.loc_cd.put("102000","�����ü");
	}
	
	private void jobtype_init() {
		// TODO Auto-generated method stub
		this.jobtype.put("1","������");
		this.jobtype.put("2","�����");
		this.jobtype.put("3","����Ư��");
		this.jobtype.put("4","������");
		this.jobtype.put("5","�Ƹ�����Ʈ");
		this.jobtype.put("6","�İ���");
		this.jobtype.put("7","�ؿ����");
		this.jobtype.put("8","������");
		this.jobtype.put("9","��������");
		this.jobtype.put("10","����� (������ ��ȯ����)");
		this.jobtype.put("11","������ (������ ��ȯ����)");
		this.jobtype.put("12","������");
		this.jobtype.put("13","������");
		this.jobtype.put("14","��Ʈ");
		this.jobtype.put("15","����");
		this.jobtype.put("16","�Ⱓ��");
		this.jobtype.put("17","��������");
		this.jobtype.put("18","���������");
		this.jobtype.put("19","�����������");
		this.jobtype.put("20","�����ɿ��");
		this.jobtype.put("21","����");
		this.jobtype.put("22","���濪");
	}
	
	private void job_category_init() {
		// TODO Auto-generated method stub
		this.job_category.put("401","�������͡�QA���׽���");
		this.job_category.put("402","��������Ʈ��ũ������");
		this.job_category.put("403","����ȹ��PM");
		this.job_category.put("404","������");
		this.job_category.put("405","���ӡ�Game");
		this.job_category.put("406","������������Ʈ�");
		this.job_category.put("407","�������α׷�����");
		this.job_category.put("408","�ý��۰���");
		this.job_category.put("409","ERP���ý��ۺм�������");
		this.job_category.put("410","��š������");
		this.job_category.put("411","�ϵ�������Ʈ����");
		this.job_category.put("412","��������");
		this.job_category.put("413","�ۺ��̡�UI����");
		this.job_category.put("414","�������������ڵ�");
		this.job_category.put("415","IT�������Ρ���ǻ�ͱ���");
		this.job_category.put("416","�����ͺ��̽���DBA");
		this.job_category.put("417","�ΰ�����(AI)��������");
	}
	
	private void ind_cd_init() {
		// TODO Auto-generated method stub
		this.ind_cd.put("301","�ַ�ǡ�SI��ERP��CRM");
		this.ind_cd.put("302","����������");
		this.ind_cd.put("304","���θ������¸���");
		this.ind_cd.put("305","���С����ͳݡ�������");
		this.ind_cd.put("306","��Ʈ��ũ����š������");
		this.ind_cd.put("307","�ϵ������");
		this.ind_cd.put("308","�������ȡ����");
		this.ind_cd.put("313","IT������");
		this.ind_cd.put("314","����");
	}
	
	private void edu_lv_init() {
		this.edu_lv.put("0","�з¹���");
		this.edu_lv.put("1","����б�����");
		this.edu_lv.put("2","��������(2,3��)");
		this.edu_lv.put("3","���б�����(4��)");
		this.edu_lv.put("4","��������");
		this.edu_lv.put("5","�ڻ�����");
		this.edu_lv.put("6","����б������̻�");
		this.edu_lv.put("7","��������(2,3��)�̻�");
		this.edu_lv.put("8","���б�����(4��)�̻�");
		this.edu_lv.put("9","���������̻�");
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