/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  data.dto.ui.CodeDTO
 *  data.dto.ui.SalaryDTO
 *  lombok.Generated
 */
package data.dto.ui.saramin;

import data.dto.ui.CodeDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SalaryDTO extends CodeDTO {
	public String toString() {
		return this.label;
	}
}