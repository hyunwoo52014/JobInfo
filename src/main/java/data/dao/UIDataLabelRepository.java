package data.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import data.dto.BusinessCodeDTO;
import data.dto.EducationDTO;
import data.dto.IndustryCodeDTO;
import data.dto.IndustryRootCodeDTO;
import data.dto.JobNOccupationDTO;
import data.dto.LocationCodeFirstDTO;
import data.dto.LocationCodeSecondsDTO;
import data.dto.LocationCodeTotalDTO;
import data.dto.SalaryDTO;
import data.dto.WorkTypeDTO;

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
	
	public List<JobNOccupationDTO> getJobNOccupationAll() {
		return this.mapper.getJobNOccupationAll();
	}
}