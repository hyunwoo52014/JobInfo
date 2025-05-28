package data.dao;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import data.dto.*;

@Mapper
public interface UIDataLabelMapper {
	
	List<WorkTypeDTO> getWorkTypeAll();
	List<EducationDTO> getEducationAll();
	List<SalaryDTO> getSalaryAll();
	List<LocationCodeTotalDTO> getLocationTotalAll();
	List<LocationCodeFirstDTO> getLocationFirstAll();
	List<LocationCodeSecondsDTO> getLocationSecondsAll();
	List<IndustryRootCodeDTO> getIndustryRootCodeAll();
	List<IndustryCodeDTO> getIndustryCodeAll();
	List<BusinessCodeDTO> getBusinessCodeAll();
	List<JobNOccupationDTO> getJobNOccupationAll();
	
}
