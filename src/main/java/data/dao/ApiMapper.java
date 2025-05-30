package data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import data.dto.ApiDTO;

@Mapper
public interface ApiMapper {
	
	ApiDTO getApiDTO(@Param("orderValue")int orderValue);
}
