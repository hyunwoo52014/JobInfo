package data.dto.event;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@XmlRootElement(name = "dhsOpenEmpInfoList")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@EqualsAndHashCode(callSuper = false)
public class Work24ResponseXml extends ResponseDTO{

	int total;
	int startPage;
	int display;
	
	@XmlElement(name = "dhsOpenEmpInfo")
	List<DhsOpenEmpInfo> dhsOpenEmpInfos;
	
	@Data
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class DhsOpenEmpInfo {
		String empSeqno;
		String empWantedTitle;
		String empBusiNm;
		String coClcdNm;
		String empWantedStdt;
		String empWantedEndt;
		String empWantedTypeNm;
		String regLogImgNm;
		String empWantedHomepgDetail;
		String empWantedMobileUrl;
	}
}
