package data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocationCodeFirstDTO extends LocationCodeDTO {
	
	@Override
	public String toString() {
		return label;
	}
}
