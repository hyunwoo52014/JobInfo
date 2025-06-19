/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  data.dto.ui.SortLabelDTO
 *  lombok.Generated
 */
package data.dto.ui.saramin;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class SortLabelDTO {
    String abbreviation;
    String label;

    public String toString() {
        return this.label;
    }
}

