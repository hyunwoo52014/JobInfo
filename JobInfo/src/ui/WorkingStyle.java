package ui;

public enum WorkingStyle {
	Code1(1,"정규직"),
	Code2(2,"계약직"),
	Code3(3,"병역특례"),
	Code4(4,"인턴직"),
	Code5(5,"아르바이트"),
	Code6(6,"파견직"),
	Code7(7,"해외취업"),
	Code8(8,"위촉직"),
	Code9(9,"프리랜서"),
	Code10(10,"계약직 (정규직 전환가능)"),
	Code11(11,"인턴직 (정규직 전환가능)"),
	Code12(12,"교육생"),
	Code13(13,"별정직"),
	Code14(14,"파트"),
	Code15(15,"전임"),
	Code16(16,"기간제"),
	Code17(17,"무기계약직"),
	Code18(18,"전문계약직"),
	Code19(19,"전문연구요원"),
	Code20(20,"산업기능요원"),
	Code21(21,"현역"),
	Code22(22,"보충역");
	
	@SuppressWarnings("unused")
	private int number;
	@SuppressWarnings("unused")
	private String name;
	
	WorkingStyle(int number, String stylename) {
		this.number = number;
		this.name = stylename;
	}

	public String getKey() {
		return name();
	}
	
	public String getValue() {
		return this.name;
	}
}
