package data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IndustryCodeDTO extends CodeDTO {
	int root_code;
	
	@Override
	public String toString() {
		return label;
	}
}
