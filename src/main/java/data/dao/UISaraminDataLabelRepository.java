package data.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import data.dto.ui.saramin.BusinessCodeDTO;
import data.dto.ui.saramin.EducationDTO;
import data.dto.ui.saramin.IndustryCodeDTO;
import data.dto.ui.saramin.IndustryRootCodeDTO;
import data.dto.ui.saramin.JobCodeDTO;
import data.dto.ui.saramin.LocationCodeFirstDTO;
import data.dto.ui.saramin.LocationCodeSecondsDTO;
import data.dto.ui.saramin.LocationCodeTotalDTO;
import data.dto.ui.saramin.OccupationCodeDTO;
import data.dto.ui.saramin.SalaryDTO;
import data.dto.ui.saramin.SortLabelDTO;
import data.dto.ui.saramin.WorkTypeDTO;

@Repository
public class UISaraminDataLabelRepository {

	private UISaraminDataLabelMapper mapper;

	public UISaraminDataLabelRepository(UISaraminDataLabelMapper mapper) {
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