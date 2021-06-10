package keywords;

public enum EducationName {
	EDN1(1, "고등학교 졸업"),
	EDN2(2, "대학(2,3년) 졸업"),
	EDN3(3, "대학교(4년) 졸업"),
	EDN4(4, "석사졸업"),
	EDN5(5, "박사졸업"),
	EDN99(99, "학력무관");
	
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
