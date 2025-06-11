/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  data.dto.ui.CodeDTO
 *  data.dto.ui.WorkTypeDTO
 *  lombok.Generated
 */
package data.dto.ui;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class WorkTypeDTO extends CodeDTO {
	
	public String toString() {
		return label;
	}
	
}