package com.ccl.interfaces.ws.simpleintapi.dtos.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentType {

    private Integer idAnubisCiDocument;
    private String locator;
    private OffsetDateTime dateLocator;
    private String deliveryStatus;
    private String comments;
    private String imageName;
    private byte[] imageContent;
    private String category;
    private GpsCoordinatesType gpsCoordinates;
    private InfoDeviceType infoDevice;
}
