package com.ccl.interfaces.ws.simpleintapi.dtos.transportplain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationCommandDTO {
    private String messageType;
    private TransportPlanDetailedDTO message;
}
