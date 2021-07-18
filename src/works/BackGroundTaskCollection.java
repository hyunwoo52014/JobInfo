package works;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import view.ResultWindow;
import view.subContainer.JobTypeNEducation;
import view.subContainer.LocalIndustryJobCategoryCodelist;
import view.subContainer.OptionalItem;
import view.subContainer.SaraminRecruitmentOption;
import view.subContainer.SearchWindows;

public class BackGroundTaskCollection {
	
	private final ExecutorService ex;
	public final SearchWindows SearchWindows;
	public final SaraminRecruitmentOption SaraminRecruitmentOption;
	public final JobTypeNEducation JobTypeNEducation;
	public final LocalIndustryJobCategoryCodelist LocalIndustryJobCategoryCodelist;
	public final OptionalItem OptionalItem;
	public final ResultWindow ResultWindow;
	
	private BackGroundTaskCollection() {
		this.SearchWindows = new SearchWindows();
		this.SaraminRecruitmentOption = new SaraminRecruitmentOption();
		this.JobTypeNEducation = new JobTypeNEducation();
		this.LocalIndustryJobCategoryCodelist = new LocalIndustryJobCategoryCodelist();
		this.OptionalItem = new OptionalItem();
		this.ResultWindow = new ResultWindow();
		this.ex = Executors.newCachedThreadPool();
	}
	
	
	protected static class BackGroundTaskCollectionHolder {
		public static final BackGroundTaskCollection INSTANCE = new BackGroundTaskCollection();
	}
	
	public static BackGroundTaskCollection getInstance() {
		return BackGroundTaskCollectionHolder.INSTANCE;
	}

	public Future<?> doTask(Callable<?> task) {
		Future<?> f = null;
		f = ex.submit(task);
		return f;
	}

}