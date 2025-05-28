package data.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public abstract class CodeDTO {
	protected int code;
	protected String label;

}