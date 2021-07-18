package works.model.sub;

public enum SortFlagList {
	
	Default("�ֱٰԽ��ϼ�(�⺻��)", ""),
	newly("�ֱٰԽ��ϼ�", "pd"),
	PostedDate("�Խ��ϼ�", "pa"),
	LatelyUpdated("�ֱټ����ϼ�", "ud"),
	UpdatedDate("�����ϼ�", "ua"),
	DeadlineDate("�����ϼ�", "da"),
	ReverseDeadlineDate("�����ϼ�(����)","dd"),
	ViewCount("��ȸ��", "rc"),
	ApplicantCount("�����ڼ�", "ac"),
	ReplyCount("��ۼ�", "re");
	
	String name;
	String sortFlag;
	
	private SortFlagList(String name, String flag) {
		this.name = name;
		this.sortFlag = flag;
	}
	
	public String getNameTag() {
		return this.name;
	}

	public String getFlagTag() {
		return this.sortFlag;
	}

	public int returnLength() {
		return SortFlagList.values().length;
	}
}