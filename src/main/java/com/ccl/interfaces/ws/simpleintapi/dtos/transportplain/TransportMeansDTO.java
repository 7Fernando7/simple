package com.ccl.interfaces.ws.simpleintapi.dtos.transportplain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransportMeansDTO {
    private String transporMeansID;
    private String transportMeansType;
    private String transportMeansSubType;
    private String name;
    private LocationDTO nationality;
    private ItineraryDTO itinerary;
    private String damageRemarks;
}
