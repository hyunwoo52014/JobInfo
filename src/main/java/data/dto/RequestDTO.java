package data.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RequestDTO extends ApiDTO{
	
	String keywords;
	Boolean bbs_gb = false;
	String[] stock;
	Boolean sr = false;
	String loc_cd;
	String loc_mcd;
	String loc_bcd;
	String ind_cd;
	String job_mid_cd;
	String job_cd;
	String job_type;
	String edu_lv;
	String[] fields;
	Date published; // (ex. 2019-03-20)
	Timestamp published_min; // (ex. 2019-03-20 19:55:00 | Unix timestamp)
	Timestamp published_max;
	Date updated; // (ex. 2019-03-20)
	Timestamp update_min;
	Timestamp update_max;
	String deadline_str; //[today | tomorrow] 중 하나
	Timestamp deadline_timeStamp;
	int start; // 기본값 0
	int count; // 최소 10, 최대 110
	String sort; //[ pd | pa | ud | ua | da | dd | rc | ac ] 중 하나
	
	public String toString() {
		StringBuilder builder = new StringBuilder("https://oapi.saramin.co.kr/job-search");
		builder.append("?"+apiKey);
		if(bbs_gb) {
			builder.append("&bbs_gb=1");
		}
		
		if(stock != null && stock.length >=1) {
			builder.append("&stock=");
			for(int i = 0; i < stock.length; i++) {
				builder.append(stock[i]);
				if(stock.length-1 == i) {
					break;
				}
				builder.append("+");
			}
		} 
		
		if(sr) {
			builder.append("&sr=directhire");
		}
		
		
		return null;
	}
}