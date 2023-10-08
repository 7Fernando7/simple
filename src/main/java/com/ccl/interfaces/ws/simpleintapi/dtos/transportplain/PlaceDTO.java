package com.ccl.interfaces.ws.simpleintapi.dtos.transportplain;

import com.ccl.interfaces.ws.simpleintapi.types.DateTimeType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDTO {
    private LocalizationDTO placeLocalization;
    private DateTimeType dateTimeType;
}
