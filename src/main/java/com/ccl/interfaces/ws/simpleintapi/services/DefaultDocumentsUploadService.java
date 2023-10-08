package com.ccl.interfaces.ws.simpleintapi.services;

import com.ccl.architecture.tracing.core.interline.DefaultTracingLogService;
import com.ccl.interfaces.ws.simpleintapi.dtos.documents.*;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.OffsetDateTime;


@Service
@Slf4j
public class DefaultDocumentsUploadService implements DocumentsUploadService {

    @Resource
    private LocatorServices locatorServices;

    @Resource(name = "traceRestTemplate")
    private RestTemplate restTemplate;

    @Value("${document.management.url}")
    private String documentManagementUrl;

    private static final String SIMPLE_PT_CATEGORY = "31";


    @Override
    public UploadResponse uploadDocument(byte[] file, String fileName) {
        log.info("IN uploadDocument :: fileName: {}", fileName);

        //1. Obtenemos el localizador, sino se puede recuperar, devolvemos response erronea
        LocatorOutput locator = locatorServices.getCreateLocator();

        if (StringUtils.isEmpty(locator.getP_localizador())) {
            final String LOG_ERROR = "Error in uploadDocument service: NULL locator";
            log.error(LOG_ERROR);
            return UploadResponse.builder()
                    .cdError("1")
                    .dsError(LOG_ERROR)
                    .build();
        }

        //2. Creamos el objeto DocumentProcessRequestType completo
        OffsetDateTime currentDate = OffsetDateTime.now();
        DocumentProcessRequestType docRequest = generateDocumentProcessRequestType(file, fileName, locator.getP_localizador(), currentDate);

        //3. Realizamos la subida del documento
        UploadResponse uploadResponse = null;
        try {
            uploadResponse = uploadDocumentUrl(docRequest);
            if (StringUtils.isNotEmpty(uploadResponse.getId()) && !uploadResponse.getId().equals("0") ) {
                uploadResponse.setCdError("0");
            } else if (StringUtils.isEmpty(uploadResponse.getCdError())){
                uploadResponse.setCdError("1");
            }
        } catch (Exception e) {
            log.error("Error in uploadDocument service with exception: {}", ExceptionUtils.getStackTrace(e));
           // tracingLogService.error("Error in uploadDocument service with exception: {}", e);
            uploadResponse = UploadResponse.builder()
                    .cdError("1")
                    .dsError("General error in uploadDocument Service, " + ExceptionUtils.getRootCause(e))
                    .build();
        }
        log.info("OUT uploadDocument");
        return uploadResponse;
    }

    private UploadResponse uploadDocumentUrl(DocumentProcessRequestType documentRequest) {

        UploadResponse uploadResponse = new UploadResponse();
        URI targetUrl = UriComponentsBuilder.fromUriString(documentManagementUrl)
                .path("/documentResponse")
                .build()
                .encode()
                .toUri();
        try {
            uploadResponse = restTemplate.exchange(targetUrl, HttpMethod.POST, new HttpEntity<>(documentRequest), UploadResponse.class).getBody();
        } catch (Exception e) {
            log.error("Upload document error: document Name {} with error {} ", documentRequest.getDocument().getImageName(), ExceptionUtils.getStackTrace(e));
            uploadResponse.setCdError("-1");
            uploadResponse.setDsError("Upload document error: ".concat(documentRequest.getDocument().getImageName())
                    .concat(", with exception: ").concat(ExceptionUtils.getMessage(e)));
        }
        return uploadResponse;
    }

    private DocumentProcessRequestType generateDocumentProcessRequestType(byte[] file, String fileName, String locator, OffsetDateTime date) {

        String description = "pie de tren para el plan de transporte XXX";

        DocumentProcessRequestType docReq = new DocumentProcessRequestType();
        docReq.setUuid(java.util.UUID.randomUUID().toString());

        NotificationDataType notDataType = new NotificationDataType();
        notDataType.setOrigin("SIMPLE_INT_API");
        notDataType.setOperationType("UPLOAD_DOCUMENT");
        docReq.setNotificationData(notDataType);

        AbastDataType abDataType = new AbastDataType();
        abDataType.setCompanyCode("TF");
        abDataType.setTypeId("1");
        abDataType.setTitle("SIMPLE_INT_API");
        abDataType.setMainDescription("La descripcion no se envia desde la app");
        abDataType.setIdocPadre("0");
        abDataType.setApplication("SIMPLE_INT_API");
        abDataType.setUser("simple_int_api");
        abDataType.setUserRole("admin");
        abDataType.setDocumentDescription(description);
        abDataType.setDocNumber("1");
        docReq.setAbastData(abDataType);

        DocumentType docType = new DocumentType();
        docType.setCategory(SIMPLE_PT_CATEGORY);
        docType.setComments(description);
        docType.setDeliveryStatus("0");
        docType.setImageName(fileName);

        docType.setLocator(locator);  // ANUBIS MASTER DATA -- F_INSERTA_LOCALIZADOR
        docType.setDateLocator(date);  // FECHA ACTUAL
        docType.setImageContent(file); // array bytes excel
        docReq.setDocument(docType);

        return docReq;
    }
}

