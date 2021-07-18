package works.model;

import java.util.ArrayList;

import works.model.sub.ResultViewData;

public class ResultAllData {
	
	private String currentPos;
	private String totalCount;
	private URLParameter urlParameter;
	private ArrayList<ResultViewData> resultViewData;
	
	public ResultAllData() {
		this.resultViewData = new ArrayList<ResultViewData>();
	}
	
	public String getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(String currentPos) {
		this.currentPos = currentPos;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public ArrayList<ResultViewData> getResultViewData() {
		return resultViewData;
	}

	public void addResultViewData(ResultViewData resultViewData) {
		this.resultViewData.add(resultViewData);
	}
	
	public void setURLParameter(URLParameter urlParameter) {
		this.urlParameter = urlParameter;
	}
	
	public URLParameter getURLParameter() {
		return this.urlParameter;
	}

}
