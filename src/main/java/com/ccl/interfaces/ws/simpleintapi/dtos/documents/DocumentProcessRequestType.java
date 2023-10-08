package com.ccl.interfaces.ws.simpleintapi.dtos.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentProcessRequestType {

    private String uuid;
    private NotificationDataType notificationData;
    private AbastDataType abastData;
    private DocumentType document;
}
