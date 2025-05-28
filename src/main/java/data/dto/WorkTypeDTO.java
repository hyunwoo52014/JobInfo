package data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
public class WorkTypeDTO extends CodeDTO {

	@Override
	public String toString() {
		return label;
	}
}