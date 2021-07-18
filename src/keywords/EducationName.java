package keywords;

public enum EducationName {
	EDNALL(Integer.MIN_VALUE, "전체"),
	EDN1(1, "고등학교 졸업"),
	EDN2(2, "대학(2,3년) 졸업"),
	EDN3(3, "대학교(4년) 졸업"),
	EDN4(4, "석사졸업"),
	EDN5(5, "박사졸업"),
	EDN99(99, "학력무관");
	
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
