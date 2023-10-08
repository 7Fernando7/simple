package com.ccl.interfaces.ws.simpleintapi.dtos.transportplain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalizationDTO {
    private String addressName;
    private String addressNumber;
    private LocationDTO location;
    private String roadType;
    private String localizationRole;
    private TerminalNodeDTO terminalNode;
}
