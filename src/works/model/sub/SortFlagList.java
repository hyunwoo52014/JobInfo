package works.model.sub;

public enum SortFlagList {
	
	Default("최근게시일순(기본값)", ""),
	newly("최근게시일순", "pd"),
	PostedDate("게시일순", "pa"),
	LatelyUpdated("최근수정일순", "ud"),
	UpdatedDate("수정일순", "ua"),
	DeadlineDate("마감일순", "da"),
	ReverseDeadlineDate("마감일순(역순)","dd"),
	ViewCount("조회수", "rc"),
	ApplicantCount("지원자수", "ac"),
	ReplyCount("댓글순", "re");
	
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