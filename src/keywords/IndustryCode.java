package keywords;

public enum IndustryCode {
	
	ind_cdAll(Integer.MIN_VALUE, "��ü"),
	ind_cd0(108,"ȣ�ڡ����ࡤ�װ�"),
	ind_cd1(109,"�ܽľ���������"),
	ind_cd2(111,"�ü���������񡤿뿪"),
	ind_cd3(115,"������������������"),
	ind_cd4(118,"AS��ī���͡�����"),
	ind_cd5(119,"��Ż���Ӵ�"),
	ind_cd6(120,"��������ʡ��̺�Ʈ"),
	ind_cd7(121,"��Ÿ���񽺾�"),
	ind_cd8(122,"��Ƽ���̿�"),
	ind_cd9(201,"���⡤���ڡ�����"),
	ind_cd10(202,"��衤�����ڵ���"),
	ind_cd11(204,"������ȭ�С�������"),
	ind_cd12(205,"�������Ƿ����м�"),
	ind_cd13(207,"ȭ��ǰ����Ƽ"),
	ind_cd14(208,"��Ȱ��ǰ���Һ��硤�繫"),
	ind_cd15(209,"���������硤����"),
	ind_cd16(210,"�����������������Ӿ�"),
	ind_cd17(211,"�ݼӡ���ᡤö�������"),
	ind_cd18(212,"�������װ�������"),
	ind_cd19(213,"��Ÿ������"),
	ind_cd20(214,"��ǰ����������"),
	ind_cd21(215,"�ݵ�ü�����С�LCD"),
	ind_cd22(216,"ȯ��"),
	ind_cd23(301,"�ַ�ǡ�SI��ERP��CRM"),
	ind_cd24(302,"����������"),
	ind_cd25(304,"���θ������¸���"),
	ind_cd26(305,"���С����ͳݡ�������"),
	ind_cd27(306,"��Ʈ��ũ����š������"),
	ind_cd28(307,"�ϵ������"),
	ind_cd29(308,"�������ȡ����"),
	ind_cd30(313,"IT������"),
	ind_cd31(314,"����"),
	ind_cd32(401,"���ࡤ����������"),
	ind_cd33(402,"���⡤ĳ��Ż������"),
	ind_cd34(405,"��Ÿ����"),
	ind_cd35(406,"���ǡ����衤ī��"),
	ind_cd36(501,"�Ź�����������л�"),
	ind_cd37(502,"��ۻ硤���̺�"),
	ind_cd38(503,"�������������θ�Ʈ"),
	ind_cd39(504,"����ȫ��������"),
	ind_cd40(505,"��ȭ����ޡ�����"),
	ind_cd41(506,"��������������ȭ"),
	ind_cd42(509,"���ǡ��μ⡤����"),
	ind_cd43(510,"ĳ���͡��ִϸ��̼�"),
	ind_cd44(511,"�����Ρ�����"),
	ind_cd45(601,"���߰�����"),
	ind_cd46(602,"�п������п�"),
	ind_cd47(603,"���ơ���ġ��"),
	ind_cd48(604,"���硤�н���"),
	ind_cd49(605,"����������п�"),
	ind_cd50(701,"�Ƿ�(�������)"),
	ind_cd51(702,"�Ƿ�(����������)"),
	ind_cd52(703,"���ࡤ���ǡ����̿�"),
	ind_cd53(704,"��ȸ����"),
	ind_cd54(801,"�Ǹ�(����������)"),
	ind_cd55(802,"�Ǹ�(��ǰǰ��)"),
	ind_cd56(803,"���롤���������"),
	ind_cd57(804,"��ۡ����������"),
	ind_cd58(901,"�Ǽ������ࡤ��񡤽ð�"),
	ind_cd59(902,"�ǳ������׸������"),
	ind_cd60(903,"ȯ�桤����"),
	ind_cd61(904,"�ε��ꡤ�Ӵ롤�߰�"),
	ind_cd62(1001,"���Ρ���������������"),
	ind_cd63(1002,"��ȸ����ü"),
	ind_cd64(1003,"������������Ư��"),
	ind_cd65(1004,"������ȸ��"),
	ind_cd66(1005,"�����ҡ������á�����");
	
	
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