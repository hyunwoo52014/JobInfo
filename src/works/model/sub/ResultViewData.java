package works.model.sub;

public class ResultViewData {
	
	/* ����� a
	 * �������� a
	 * ���� a
	 * �ٹ����� a
	 * �з� a
	 * ����ڵ� a
	 * �Խ��� 
	 * ������ a
	 * ���� url a
	 * ȸ�� ���� url a
	 * ���� ��ġ
	 * ��ü����
	 */
	private String companyName;
	private String recruitmentTitle;
	private String localTag;
	private String jobType;
	private String requiredEducationLevel;
	private String experienceLevel;
	private String postingTimestamp;
	private String expirationTimestamp;
	private String recruitmentUrl;
	private String companyInfoUrl;
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getRecruitmentTitle() {
		return recruitmentTitle;
	}
	
	public void setRecruitmentTitle(String recruitmentTitle) {
		this.recruitmentTitle = recruitmentTitle;
	}
	
	public String getLocalTag() {
		return localTag;
	}
	
	public void setLocalTag(String localTag) {
		this.localTag = localTag;
	}
	
	public String getJobType() {
		return jobType;
	}
	
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	public String getRequiredEducationLevel() {
		return requiredEducationLevel;
	}
	
	public void setRequiredEducationLevel(String requiredEducationLevel) {
		this.requiredEducationLevel = requiredEducationLevel;
	}
	
	public String getExperienceLevel() {
		
		return experienceLevel;
	}
	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	
	public String getPostingTimestamp() {
		return postingTimestamp;
	}
	
	public void setPostingTimestamp(String postingTimestamp) {
		this.postingTimestamp = postingTimestamp;
	}
	
	public String getExpirationTimestamp() {
		return expirationTimestamp;
	}
	
	public void setExpirationTimestamp(String expirationTimestamp) {
		this.expirationTimestamp = expirationTimestamp;
	}

	public String getRecruitmentUrl() {
		return recruitmentUrl;
	}

	public void setRecruitmentUrl(String recruitmentUrl) {
		this.recruitmentUrl = recruitmentUrl;
	}

	public String getCompanyInfoUrl() {
		return companyInfoUrl;
	}

	public void setCompanyInfoUrl(String companyInfoUrl) {
		this.companyInfoUrl = companyInfoUrl;
	}

	public int realLength() {
		return 10;
	}
	
	public int viewDataLength() {
		return 8;
	}
	
}
