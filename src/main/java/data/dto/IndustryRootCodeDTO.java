package data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IndustryRootCodeDTO extends CodeDTO {
	@Override
	public String toString() {
		return label;
	}
}
