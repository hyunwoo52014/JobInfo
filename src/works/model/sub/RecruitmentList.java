package works.model.sub;

public enum RecruitmentList {

	All(0),
	InSaramin(1);

	int number;
	
	private RecruitmentList(int num) {
		this.number = num;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getNumberToString() {
		return String.valueOf(this.number);
	}
}
