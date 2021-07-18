package keywords;

public enum IndustryCode {
	
	ind_cdAll(Integer.MIN_VALUE, "전체"),
	ind_cd0(108,"호텔·여행·항공"),
	ind_cd1(109,"외식업·식음료"),
	ind_cd2(111,"시설관리·경비·용역"),
	ind_cd3(115,"레저·스포츠·여가"),
	ind_cd4(118,"AS·카센터·주유"),
	ind_cd5(119,"렌탈·임대"),
	ind_cd6(120,"웨딩·장례·이벤트"),
	ind_cd7(121,"기타서비스업"),
	ind_cd8(122,"뷰티·미용"),
	ind_cd9(201,"전기·전자·제어"),
	ind_cd10(202,"기계·설비·자동차"),
	ind_cd11(204,"석유·화학·에너지"),
	ind_cd12(205,"섬유·의류·패션"),
	ind_cd13(207,"화장품·뷰티"),
	ind_cd14(208,"생활용품·소비재·사무"),
	ind_cd15(209,"가구·목재·제지"),
	ind_cd16(210,"농업·어업·광업·임업"),
	ind_cd17(211,"금속·재료·철강·요업"),
	ind_cd18(212,"조선·항공·우주"),
	ind_cd19(213,"기타제조업"),
	ind_cd20(214,"식품가공·개발"),
	ind_cd21(215,"반도체·광학·LCD"),
	ind_cd22(216,"환경"),
	ind_cd23(301,"솔루션·SI·ERP·CRM"),
	ind_cd24(302,"웹에이젼시"),
	ind_cd25(304,"쇼핑몰·오픈마켓"),
	ind_cd26(305,"포털·인터넷·컨텐츠"),
	ind_cd27(306,"네트워크·통신·모바일"),
	ind_cd28(307,"하드웨어·장비"),
	ind_cd29(308,"정보보안·백신"),
	ind_cd30(313,"IT컨설팅"),
	ind_cd31(314,"게임"),
	ind_cd32(401,"은행·금융·저축"),
	ind_cd33(402,"대출·캐피탈·여신"),
	ind_cd34(405,"기타금융"),
	ind_cd35(406,"증권·보험·카드"),
	ind_cd36(501,"신문·잡지·언론사"),
	ind_cd37(502,"방송사·케이블"),
	ind_cd38(503,"연예·엔터테인먼트"),
	ind_cd39(504,"광고·홍보·전시"),
	ind_cd40(505,"영화·배급·음악"),
	ind_cd41(506,"공연·예술·문화"),
	ind_cd42(509,"출판·인쇄·사진"),
	ind_cd43(510,"캐릭터·애니메이션"),
	ind_cd44(511,"디자인·설계"),
	ind_cd45(601,"초중고·대학"),
	ind_cd46(602,"학원·어학원"),
	ind_cd47(603,"유아·유치원"),
	ind_cd48(604,"교재·학습지"),
	ind_cd49(605,"전문·기능학원"),
	ind_cd50(701,"의료(진료과목별)"),
	ind_cd51(702,"의료(병원종류별)"),
	ind_cd52(703,"제약·보건·바이오"),
	ind_cd53(704,"사회복지"),
	ind_cd54(801,"판매(매장종류별)"),
	ind_cd55(802,"판매(상품품목별)"),
	ind_cd56(803,"유통·무역·상사"),
	ind_cd57(804,"운송·운수·물류"),
	ind_cd58(901,"건설·건축·토목·시공"),
	ind_cd59(902,"실내·인테리어·조경"),
	ind_cd60(903,"환경·설비"),
	ind_cd61(904,"부동산·임대·중개"),
	ind_cd62(1001,"정부·공공기관·공기업"),
	ind_cd63(1002,"협회·단체"),
	ind_cd64(1003,"법률·법무·특허"),
	ind_cd65(1004,"세무·회계"),
	ind_cd66(1005,"연구소·컨설팅·조사");
	
	
	private int number;
	private String nameTag;
	
	IndustryCode(int n, String s) {
		this.number = n;
		this.nameTag = s;
	}
	
	public int returnNumberFromNameTag(String s) {
		
		for(IndustryCode ic : IndustryCode.values()) {
			
			if(ic.nameTag.equalsIgnoreCase(s)) {
				return ic.number;
			}
		}
		
		return Integer.MIN_VALUE;
	}
	
	public String returnNameTagFromNumber(int n) {
		
		for(IndustryCode ic : IndustryCode.values()) {
			
			if(ic.number == n) {
				return ic.nameTag;
			}
		}
		return null;
	}
	
	public int returnLength() {
		return IndustryCode.values().length;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getNameTag() {
		return this.nameTag;
	}
	
}