/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  data.dto.ui.BusinessCodeDTO
 *  data.dto.ui.CodeDTO
 *  lombok.Generated
 */
package data.dto.ui;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessCodeDTO extends CodeDTO {
    int industry_code;

    public String toString() {
        return label;
    }
}