package api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import data.dao.ApiRepository;
import data.dto.ApiDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Service
public class ApiService {
	
	private ApiRepository apiRepository;
	private final String address = "https://oapi.saramin.co.kr/job-search";
	public ApiService(ApiRepository apiRepository) {
		this.apiRepository = apiRepository;
	}
	
	
	public void getJobPosting() {
		
	}
}