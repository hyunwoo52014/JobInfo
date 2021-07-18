package keywords;

public enum EducationName {
	EDNALL(Integer.MIN_VALUE, "��ü"),
	EDN1(1, "����б� ����"),
	EDN2(2, "����(2,3��) ����"),
	EDN3(3, "���б�(4��) ����"),
	EDN4(4, "��������"),
	EDN5(5, "�ڻ�����"),
	EDN99(99, "�з¹���");
	
	int number;
	String nameTag;
	
	EducationName(int n, String s) {
		this.number = n;
		this.nameTag = s;
	}
	
	public int returnNumberFromNameTag(String s) {
		
		for(EducationName en : EducationName.values()) {
			
			if(en.nameTag.equalsIgnoreCase(s)) {
				return en.number;
			}
		}
		
		return Integer.MIN_VALUE;
	}
	
	public String returnNameFromNumber(int n) {
		
		for(EducationName en : EducationName.values()) {
			if(n == en.number) {
				return en.nameTag;
			}
		}
		return null;
	}
	
	public int returnLength() {
		return EducationName.values().length;
	}

	public int getNumber() {
		return number;
	}

	public String getNameTag() {
		return nameTag;
	}

}
