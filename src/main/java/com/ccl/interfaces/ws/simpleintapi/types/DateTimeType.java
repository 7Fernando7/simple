package com.ccl.interfaces.ws.simpleintapi.types;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DateTimeType {
    private String dateTime;
    private String type;
}
