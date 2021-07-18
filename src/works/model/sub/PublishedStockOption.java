package works.model.sub;

public enum PublishedStockOption {

	KOSPI("kospi", 0),
	KOSDAQ("kosdaq", 1),
	NASDAQ("nasdaq", 2);
	
	String nameTag;
	int number;
	
	private PublishedStockOption(String tag, int num) {
		this.nameTag = tag;
		this.number = num;
	}
	
	public int returnNumberFromNameTag(String s) {
		
		for(PublishedStockOption pso : PublishedStockOption.values()) {
			
			if(pso.getNameTag().equalsIgnoreCase(s)) {
				return pso.getNumber();
			}
			
		}
		
		return 0;
	}
	
	public String returnNameTagFromNumber(int num) {
		
		for(PublishedStockOption pso : PublishedStockOption.values()) {
			if(pso.getNumber() == num) {
				return pso.getNameTag();
			}
		}
		
		return null;
	}
	
	public String getNameTag() {
		return this.nameTag;
	}
	
	public String getNumberToString() {
		return String.valueOf(this.number);
	}
	
	public int getNumber() {
		return this.number;
	}
	
}
