package data.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import data.dto.ui.BusinessCodeDTO;
import data.dto.ui.EducationDTO;
import data.dto.ui.IndustryCodeDTO;
import data.dto.ui.IndustryRootCodeDTO;
import data.dto.ui.JobCodeDTO;
import data.dto.ui.LocationCodeFirstDTO;
import data.dto.ui.LocationCodeSecondsDTO;
import data.dto.ui.LocationCodeTotalDTO;
import data.dto.ui.OccupationCodeDTO;
import data.dto.ui.SalaryDTO;
import data.dto.ui.SortLabelDTO;
import data.dto.ui.WorkTypeDTO;

@Repository
public class UIDataLabelRepository {

	private UIDataLabelMapper mapper;

	public UIDataLabelRepository(UIDataLabelMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<WorkTypeDTO> getWorkTypeAll() {
		return this.mapper.getWorkTypeAll();
	}
	
	public List<EducationDTO> getEducationAll() {
		return this.mapper.getEducationAll();
	}
	
	public List<SalaryDTO> getSalaryAll() {
		return this.mapper.getSalaryAll();
	}
	
	public List<LocationCodeTotalDTO> getLocationTotalAll() {
		return this.mapper.getLocationTotalAll();
	}
	
	public List<LocationCodeFirstDTO> getLocationFirstAll() {
		return this.mapper.getLocationFirstAll();
	}
	
	public List<LocationCodeSecondsDTO> getLocationSecondsAll() {
		return this.mapper.getLocationSecondsAll();
	}
	
	public List<IndustryRootCodeDTO> getIndustryRootCodeAll() {
		return this.mapper.getIndustryRootCodeAll();
	}
	
	public List<IndustryCodeDTO> getIndustryCodeAll() {
		return this.mapper.getIndustryCodeAll();
	}
	
	public List<BusinessCodeDTO> getBusinessCodeAll() {
		return this.mapper.getBusinessCodeAll();
	}
	
	public List<JobCodeDTO> getJobCodeAll() {
		return this.mapper.getJobCodeAll();
	}
	
	public 	List<OccupationCodeDTO> getOccupationCodeAll() {
		return this.mapper.getOccupationCodeAll();
	}

	public List<SortLabelDTO> getSortLabelAll(){
		return this.mapper.getSortLabelAll();
	}
}