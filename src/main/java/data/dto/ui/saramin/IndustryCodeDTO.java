/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  data.dto.ui.CodeDTO
 *  data.dto.ui.IndustryCodeDTO
 *  lombok.Generated
 */
package data.dto.ui.saramin;

import data.dto.ui.CodeDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IndustryCodeDTO extends CodeDTO {
	
    int root_code;
    
    public String toString() {
		return this.label;
	}
}