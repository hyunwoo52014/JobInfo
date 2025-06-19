package data.dao;

import org.apache.ibatis.annotations.Mapper;
import data.dto.ui.*;
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

import java.util.List;


@Mapper
public interface UISaraminDataLabelMapper {
	
	List<WorkTypeDTO> getWorkTypeAll();
	List<EducationDTO> getEducationAll();
	List<SalaryDTO> getSalaryAll();
	List<LocationCodeTotalDTO> getLocationTotalAll();
	List<LocationCodeFirstDTO> getLocationFirstAll();
	List<LocationCodeSecondsDTO> getLocationSecondsAll();
	List<IndustryRootCodeDTO> getIndustryRootCodeAll();
	List<IndustryCodeDTO> getIndustryCodeAll();
	List<BusinessCodeDTO> getBusinessCodeAll();
	List<JobCodeDTO> getJobCodeAll();
	List<OccupationCodeDTO> getOccupationCodeAll();
	List<SortLabelDTO> getSortLabelAll();
}
