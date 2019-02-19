package ui;

public enum WorkingStyle {
	Code1(1,"������"),
	Code2(2,"�����"),
	Code3(3,"����Ư��"),
	Code4(4,"������"),
	Code5(5,"�Ƹ�����Ʈ"),
	Code6(6,"�İ���"),
	Code7(7,"�ؿ����"),
	Code8(8,"������"),
	Code9(9,"��������"),
	Code10(10,"����� (������ ��ȯ����)"),
	Code11(11,"������ (������ ��ȯ����)"),
	Code12(12,"������"),
	Code13(13,"������"),
	Code14(14,"��Ʈ"),
	Code15(15,"����"),
	Code16(16,"�Ⱓ��"),
	Code17(17,"��������"),
	Code18(18,"���������"),
	Code19(19,"�����������"),
	Code20(20,"�����ɿ��"),
	Code21(21,"����"),
	Code22(22,"���濪");
	
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
