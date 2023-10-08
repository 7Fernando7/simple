package com.ccl.interfaces.ws.simpleintapi.dtos.transportplain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActorAdressDTO {
    private String zipCode;
    private CountryDTO country;
    private CityDTO city;
}
