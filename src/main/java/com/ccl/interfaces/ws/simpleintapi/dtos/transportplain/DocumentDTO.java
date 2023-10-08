package com.ccl.interfaces.ws.simpleintapi.dtos.transportplain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentDTO {
    private String name;
    private String documentType;
    private String mimeType;
    private String documentContent;
    private String documentUrl;
}
