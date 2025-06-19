/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  data.dto.ui.LocationCodeDTO
 *  data.dto.ui.LocationCodeSecondsDTO
 *  lombok.Generated
 */
package data.dto.ui.saramin;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocationCodeSecondsDTO extends LocationCodeDTO {
	public String toString() {
		return this.label;
	}
}