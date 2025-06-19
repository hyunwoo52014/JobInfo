package data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.ui.work24.CompanyCodeDTO;
import data.dto.ui.work24.EmpWantedCareerCodeDTO;
import data.dto.ui.work24.EmpWantedEducationCodeDTO;
import data.dto.ui.work24.EmpWantedTypeCodeDTO;
import data.dto.ui.work24.SortFieldDTO;
import data.dto.ui.work24.SortOrderByDTO;


@Mapper
public interface UIWork24DataLabelMapper {
	List<CompanyCodeDTO> getCompanyCodeAll();
	List<EmpWantedTypeCodeDTO> getEmpWantedTypeCodeAll();
	List<EmpWantedCareerCodeDTO> getEmpWantedCareerCodeAll();
	List<EmpWantedEducationCodeDTO> getEmpWantedEducationCodeAll();
	List<SortFieldDTO> getSortFieldAll();
	List<SortOrderByDTO> getSortOrderByAll();
}
