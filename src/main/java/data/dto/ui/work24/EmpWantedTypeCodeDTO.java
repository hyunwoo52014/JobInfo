package data.dto.ui.work24;

import data.dto.ui.CodeDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmpWantedTypeCodeDTO extends CodeDTO {
	
	@Override
	public String toString() {
		return label;
	}
}
