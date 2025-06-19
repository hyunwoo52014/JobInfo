package data.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import data.dto.ui.work24.CompanyCodeDTO;
import data.dto.ui.work24.EmpWantedCareerCodeDTO;
import data.dto.ui.work24.EmpWantedEducationCodeDTO;
import data.dto.ui.work24.EmpWantedTypeCodeDTO;
import data.dto.ui.work24.SortFieldDTO;
import data.dto.ui.work24.SortOrderByDTO;


@Repository
public class UIWork24DataLabelRepository {
	
	UIWork24DataLabelMapper mapper;
	
	public UIWork24DataLabelRepository(UIWork24DataLabelMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<CompanyCodeDTO> getCompanyCodeAll() {
		return mapper.getCompanyCodeAll();
	}
	
	public List<EmpWantedTypeCodeDTO> getEmpWantedTypeCodeAll() {
		return mapper.getEmpWantedTypeCodeAll();
	}
	
	public List<EmpWantedCareerCodeDTO> getEmpWantedCareerCodeAll() {
		return mapper.getEmpWantedCareerCodeAll();
	}
	
	public List<EmpWantedEducationCodeDTO> getEmpWantedEducationCodeAll() {
		return mapper.getEmpWantedEducationCodeAll();
	}
	
	public List<SortFieldDTO> getSortFieldAll() {
		return mapper.getSortFieldAll();
	}
	
	public List<SortOrderByDTO> getSortOrderByAll() {
		return mapper.getSortOrderByAll();
	}
}
