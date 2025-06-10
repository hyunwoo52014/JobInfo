package data.dto.ui;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class JobCodeDTO extends CodeDTO {
    int root_code;
    
    public String toString() {
		return label;
	}
}