package data.dao;

import org.springframework.stereotype.Repository;

import data.dto.ApiDTO;

@Repository
public class ApiRepository {

	private ApiMapper apiMapper;
	
	public ApiRepository(ApiMapper apiMapper) {
		this.apiMapper = apiMapper;
	}
	
	public ApiDTO getApiDTO(int orderValue) {
		return this.apiMapper.getApiDTO(orderValue);
	}
}
