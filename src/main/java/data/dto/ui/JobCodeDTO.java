/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  data.dto.ui.CodeDTO
 *  data.dto.ui.JobCodeDTO
 *  lombok.Generated
 */
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