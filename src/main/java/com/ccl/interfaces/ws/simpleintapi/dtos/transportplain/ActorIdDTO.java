package com.ccl.interfaces.ws.simpleintapi.dtos.transportplain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActorIdDTO {
    private String ID;
    private String documentType;
}
