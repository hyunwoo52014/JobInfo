package works.task.sub;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import view.subContainer.JobTypeNEducation;
import view.subContainer.LocalIndustryJobCategoryCodelist;
import view.subContainer.OptionalItem;
import view.subContainer.SaraminRecruitmentOption;
import view.subContainer.SearchWindows;
import works.BackGroundTaskCollection;
import works.model.URLParameter;

public class GetFromComponent {
	
	public URLParameter returnURLParameter() throws UnsupportedEncodingException {
		SearchWindows searchWindows = BackGroundTaskCollection.getInstance().SearchWindows;
		SaraminRecruitmentOption saraminRecruOpt = BackGroundTaskCollection.getInstance().SaraminRecruitmentOption;
		JobTypeNEducation jobTypeNEdu = BackGroundTaskCollection.getInstance().JobTypeNEducation;
		LocalIndustryJobCategoryCodelist localIndusJobCateCodeList = BackGroundTaskCollection.getInstance().LocalIndustryJobCategoryCodelist;
		OptionalItem optionItem = BackGroundTaskCollection.getInstance().OptionalItem;
		
		String str = searchWindows.getSearchWord();
		
		if(str != null) {
			str = URLEncoder.encode(str, "UTF-8");
		}
		
		URLParameter param = new URLParameter.Builder()
				.addSearchWord(str)
				.addRecruitmentOption(saraminRecruOpt.getRecruitmentOptionValue())
				.addStockListingOption(saraminRecruOpt.getPublicOptionValue())
				.addHeadHuntingOrDispatchOption(saraminRecruOpt.getHeadHuntingValue())
				.addJobType(jobTypeNEdu.getJobTypeCode())
				.addEducationLevel(jobTypeNEdu.getEduCode())
				.addLocalCode(localIndusJobCateCodeList.getLocalCodes())
				.addIndustyCode(localIndusJobCateCodeList.getIndustyCodes())
				.addJobCategory(localIndusJobCateCodeList.getJobCategoryCodes())
				.setCount(optionItem.getCount())
				.setStart(optionItem.getStart())
				.addFields(optionItem.getSortOptionNameTag())
				.build();
		
		return param;
	}

}
