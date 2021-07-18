package works.task.sub;

import works.model.URLParameter;

public class GetParameterForPreviousPage {

	private URLParameter urlParameter;
	
	public GetParameterForPreviousPage(URLParameter urlParameter) {
		this.urlParameter = urlParameter;
	}
	
	public URLParameter getPreviousPageParameter() {
		int nowNum = this.urlParameter.getStart();
		Integer preNum = new Integer(--nowNum);
		
		URLParameter newParameter = new URLParameter.Builder()
				.addSearchWord(this.urlParameter.getKeyword())
				.addRecruitmentOption(this.urlParameter.getBbs_gb())
				.addStockListingOption(this.urlParameter.getStock())
				.addHeadHuntingOrDispatchOption(this.urlParameter.getSr())
				.addJobType(this.urlParameter.getJob_type())
				.addEducationLevel(this.urlParameter.getEdu_lv())
				.addLocalCode(this.urlParameter.getLoc_cd())
				.addIndustyCode(this.urlParameter.getInd_cd())
				.addJobCategory(this.urlParameter.getJob_category())
				.setStart(preNum)
				.setCount(this.urlParameter.getCount())
				.addFields(this.urlParameter.getFields())
				.build();
		
		return newParameter;
	}
	
}
