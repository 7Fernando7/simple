package com.ccl.interfaces.ws.simpleintapi.services;

import com.ccl.interfaces.ws.simpleintapi.dtos.documents.UploadResponse;

public interface DocumentsUploadService {
    UploadResponse uploadDocument(byte[] file, String fileName);
}
