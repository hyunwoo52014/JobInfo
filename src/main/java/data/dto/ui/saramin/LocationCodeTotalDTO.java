/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  data.dto.ui.LocationCodeDTO
 *  data.dto.ui.LocationCodeTotalDTO
 *  lombok.Generated
 */
package data.dto.ui.saramin;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocationCodeTotalDTO extends LocationCodeDTO {
    int first_code;
    int seconds_code;
}