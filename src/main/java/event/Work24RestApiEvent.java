package event;

import javax.swing.JCheckBox;

import org.springframework.context.ApplicationEvent;

import data.dto.event.RequestWork24DTO;
import data.dto.ui.work24.CompanyCodeDTO;
import data.dto.ui.work24.EmpWantedCareerCodeDTO;
import data.dto.ui.work24.EmpWantedTypeCodeDTO;
import data.dto.ui.work24.SortFieldDTO;
import data.dto.ui.work24.SortOrderByDTO;

public class Work24RestApiEvent extends ApplicationEvent {

	private static final long serialVersionUID = 4771794861777189639L;
	RequestWork24DTO dto;
	
	public Work24RestApiEvent(Object source, RequestWork24DTO dto) {
		super(source);
		this.dto = dto;
	}
	
	public String apiUrl() {
		StringBuilder builder = new StringBuilder("https://www.work24.go.kr/cm/openApi/call/wk/callOpenApiSvcInfo210L21.do");
		builder
			.append("?authKey="+dto.getAccessKey())
			.append("&callTp="+dto.getCallTp())
			.append("&returnType="+dto.getReturnType())
			.append("&startPage="+dto.getStartPage())
			.append("&display="+dto.getDisplay()); 
		
		String empCoNo = dto.getEmpCoNo();
		if(empCoNo != null && empCoNo != "") {
			builder.append("& ="+empCoNo);
		}
		
		JCheckBox[] coClcd = dto.getCoClcd();
		{
			String temp = "";
			CompanyCodeDTO dto;
			for(int i = 0; i < coClcd.length; i++) {
				if(coClcd[i].isSelected()) {
					dto = (CompanyCodeDTO) coClcd[i].getClientProperty("apiKey");
					if(i == 0) {
						temp += "&coClcd="+dto.getCode();
					} else {
						temp += "|"+dto.getCode();
					}
				}
			}
			
			builder.append(temp);
		}
		
		JCheckBox[] empWantedTypeCd = dto.getEmpWantedTypeCd();
		{
			String temp = "";
			EmpWantedTypeCodeDTO dto;
			for (int i = 0; i < empWantedTypeCd.length; i++) {
				if(empWantedTypeCd[i].isSelected()) {
					dto = (EmpWantedTypeCodeDTO) empWantedTypeCd[i].getClientProperty("apiKey");
					if(i == 0) {
						temp += "&empWantedTypeCd="+dto.getCode();
					} else {
						temp += "|"+dto.getCode();
					}
				}
			}
			
			builder.append(temp);
		}
		
		JCheckBox[] empWantedCareerCd = dto.getEmpWantedCareerCd();
		{
			String temp = "";
			EmpWantedCareerCodeDTO dto;
			for (int i = 0; i < empWantedCareerCd.length; i++) {
				if(empWantedCareerCd[i].isSelected()) {
					dto = (EmpWantedCareerCodeDTO) empWantedCareerCd[i].getClientProperty("apiKey");
					if(i == 0) {
						temp += "&empWantedCareerCd="+dto.getCode();
					} else {
						temp += "|"+dto.getCode();
					}
				}
			}
			
			builder.append(temp);
		}
		
		String jobsCd = dto.getJobsCd();
		if(jobsCd != null && jobsCd != "") {
			builder.append("&jobsCd="+jobsCd);
		}
		
		String empWantedTitle = dto.getEmpWantedTitle();
		if(empWantedTitle != null && empWantedTitle != "") {
			builder.append("&empWantedTitle="+empWantedTitle);
		}
		
		JCheckBox[] empWantedEduCd = dto.getEmpWantedEduCd();
		{
			String temp = "";
			EmpWantedCareerCodeDTO dto;
			for (int i = 0; i < empWantedEduCd.length; i++) {
				if(empWantedEduCd[i].isSelected()) {
					dto = (EmpWantedCareerCodeDTO) empWantedEduCd[i].getClientProperty("apiKey");
					if(i == 0) {
						temp += "&empWantedCareerCd="+dto.getCode();
					} else {
						temp += "|"+dto.getCode();
					}
				}
			}
			
			builder.append(temp);
		}
		
		{
			SortFieldDTO fieldDto = dto.getSortField();
			if(fieldDto != null && !fieldDto.getLabel_abbreviation().equalsIgnoreCase("NONE")) {
				builder.append("&sortField="+fieldDto.getLabel());
			}
		}
		
		{
			SortOrderByDTO sortOrderByDTO = dto.getSortOrderBy();
			if(sortOrderByDTO != null && !sortOrderByDTO.getLabel_abbreviation().equalsIgnoreCase("NONE")) {
				builder.append("&sortOrderBy="+sortOrderByDTO.getLabel());
			}
		}
		
		String busino = dto.getBusino();
		if(busino != null && busino != "") {
			builder.append("&busino="+busino);
		}
		
		return builder.toString();
	}

	public RequestWork24DTO getDTO() {
		return this.dto;
	}
}
