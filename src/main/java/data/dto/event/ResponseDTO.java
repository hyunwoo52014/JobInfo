// 
// Decompiled by Procyon v0.6.0
// 

package data.dto.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

import data.dto.api.ApiDTO;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class ResponseDTO
{
    ApiDTO request;
    
}
