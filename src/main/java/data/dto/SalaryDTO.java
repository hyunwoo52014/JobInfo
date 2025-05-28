package data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SalaryDTO extends CodeDTO {

	@Override
	public String toString() {
		return label;
	}
}
