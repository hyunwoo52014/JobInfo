package keywords;

public enum JobTypeName {
	JobTypeName1(1,"������"),
	JobTypeName2(2, "�����"),
	JobTypeName3(3, "����Ư��"),
	JobTypeName4(4, "������"),
	JobTypeName5(5, "�Ƹ�����Ʈ"),
	JobTypeName6(6, "�İ���"),
	JobTypeName7(7, "�ؿ����"),
	JobTypeName8(8, "������"),
	JobTypeName9(9, "��������"),
	JobTypeName10(10, "����� (������ ��ȯ����)"),
	JobTypeName11(11, "������ (������ ��ȯ����)"),
	JobTypeName12(12, "������"),
	JobTypeName13(13, "������"),
	JobTypeName14(14, "��Ʈ"),
	JobTypeName15(15, "����"),
	JobTypeName16(16, "�Ⱓ��"),
	JobTypeName17(17, "��������"),
	JobTypeName18(18, "���������"),
	JobTypeName19(19, "�����������"),
	JobTypeName20(20, "�����ɿ��"),
	JobTypeName21(21, "����"),
	JobTypeName22(22, "���濪");
	
	int number;
	String str;
	
	private JobTypeName(int n, String s) {
		this.number = n;
		this.str = s;
	}
	
	public String returnString(int n) {
		for(JobTypeName jtn : JobTypeName.values()) {
			if(n == jtn.number) {
				return jtn.str;
			}
		}
		return null;
	}
	
	public int returnLength() {
		return JobTypeName.values().length;
	}
}
