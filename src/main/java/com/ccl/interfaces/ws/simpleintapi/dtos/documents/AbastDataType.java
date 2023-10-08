package com.ccl.interfaces.ws.simpleintapi.dtos.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbastDataType {

    private Integer idScanvisioDocument;
    private String companyCode;
    private String typeId;
    private String title;
    private String mainDescription;
    private String idocPadre;
    private String application;
    private String user;
    private String userRole;
    private String documentDescription;
    private String client;
    private String docNumber;
}
