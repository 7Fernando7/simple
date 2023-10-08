package com.ccl.interfaces.ws.simpleintapi.dtos.transportplain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDTO {
    private String cityLoCode;
    private String name;
    private String coordinates;
}
