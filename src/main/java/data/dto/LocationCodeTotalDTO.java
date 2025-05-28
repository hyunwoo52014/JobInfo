package data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocationCodeTotalDTO extends CodeDTO {

	int first_code;
	int seconds_code;
	
	@Override
	public String toString() {
		return label;
	}
}
