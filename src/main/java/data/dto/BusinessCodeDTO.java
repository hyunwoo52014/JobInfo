package data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessCodeDTO extends CodeDTO {	
	int industry_code;
	
	@Override
	public String toString() {
		return label;
	}
}