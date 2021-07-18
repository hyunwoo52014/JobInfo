package keywords;

public enum JobTypeName {
	JobTypeALL(Integer.MIN_VALUE, "전체"),
	JobTypeName1(1,"정규직"),
	JobTypeName2(2, "계약직"),
	JobTypeName3(3, "병역특례"),
	JobTypeName4(4, "인턴직"),
	JobTypeName5(5, "아르바이트"),
	JobTypeName6(6, "파견직"),
	JobTypeName7(7, "해외취업"),
	JobTypeName8(8, "위촉직"),
	JobTypeName9(9, "프리랜서"),
	JobTypeName10(10, "계약직 (정규직 전환가능)"),
	JobTypeName11(11, "인턴직 (정규직 전환가능)"),
	JobTypeName12(12, "교육생"),
	JobTypeName13(13, "별정직"),
	JobTypeName14(14, "파트"),
	JobTypeName15(15, "전임"),
	JobTypeName16(16, "기간제"),
	JobTypeName17(17, "무기계약직"),
	JobTypeName18(18, "전문계약직"),
	JobTypeName19(19, "전문연구요원"),
	JobTypeName20(20, "산업기능요원"),
	JobTypeName21(21, "현역"),
	JobTypeName22(22, "보충역");
	
	int number;
	String nameTag;
	
	private JobTypeName(int n, String s) {
		this.number = n;
		this.nameTag = s;
	}
	
	public int returnNumberFromNameTag(String s) {
		
		for(JobTypeName jtn : JobTypeName.values()) {
			if(jtn.nameTag.equalsIgnoreCase(s)) {
				return jtn.number;
			}
		}
		
		return Integer.MIN_VALUE;
	}
	
	public String returnNameTagFromNumber(int n) {
		
		for(JobTypeName jtn : JobTypeName.values()) {
			if(n == 0) {
				return JobTypeALL.nameTag;
			}
			
			if(n == jtn.number) {
				return jtn.nameTag;
			}
		}
		
		return null;
	}

	public int returnLength() {
		return JobTypeName.values().length;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getNameTag() {
		return this.nameTag;
	}


}
