package com.ccl.interfaces.ws.simpleintapi.dtos.transportplain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TransportPlanDetailedDTO {
    private String externalShipmentId;
    private String externalConsignmentId;
    private String externalTransportPlanId;
    private List<LegalPersonDTO> involvedActors;
    private PlaceDTO origin;
    private PlaceDTO destination;
    private List<TransportMeansDTO> transportMean;
    private String observations;
    private List<DocumentDTO> documents;
}
