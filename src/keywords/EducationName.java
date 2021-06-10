package keywords;

public enum EducationName {
	EDN1(1, "����б� ����"),
	EDN2(2, "����(2,3��) ����"),
	EDN3(3, "���б�(4��) ����"),
	EDN4(4, "��������"),
	EDN5(5, "�ڻ�����"),
	EDN99(99, "�з¹���");
	
	int number;
	String name;
	
	EducationName(int n, String s) {
		this.number = n;
		this.name = s;
	}
	
	public String returnName(int n) {
		
		for(EducationName en : EducationName.values()) {
			if(n == en.number) {
				return en.name;
			}
		}
		return null;
	}
	
	public int returnValue(String s) {
		for(EducationName en : EducationName.values()) {
			if(s.equalsIgnoreCase(en.name)) {
				return en.number;
			}
		}
		
		return -1;
	}
	
	public int returnLength() {
		return EducationName.values().length;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

}
