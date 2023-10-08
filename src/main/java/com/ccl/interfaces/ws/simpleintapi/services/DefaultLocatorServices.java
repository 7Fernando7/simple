package com.ccl.interfaces.ws.simpleintapi.services;

import com.ccl.architecture.tracing.core.interline.DefaultTracingLogService;
import com.ccl.interfaces.ws.simpleintapi.dtos.documents.LocatorOutput;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class DefaultLocatorServices implements LocatorServices {

    @Resource(name = "traceRestTemplate")
    private RestTemplate restTemplate;

    @Resource
    private DefaultTracingLogService tracingLogService;

    @Value("${anubis.core.masterdata}")
    private String anubisCoreMstUrl;

    private static final String OBTAIN_LOCATOR_PATH = "/LOCATOR/F_INSERTA_LOCALIZADOR";

    @Override
    public LocatorOutput getCreateLocator() {
        LocatorOutput locatorOutputResponse;
        try {
            locatorOutputResponse = createLocator();
        } catch (Exception e) {
            log.error("Error in getCreateLocator service with exception: {}", ExceptionUtils.getStackTrace(e));
            tracingLogService.error("Error in getCreateLocator service with exception: {}", e);

            locatorOutputResponse = LocatorOutput.builder()
                    .cdError("1")
                    .dsError("General error in getCreateLocator Service, " + ExceptionUtils.getRootCause(e))
                    .build();
        }
        return locatorOutputResponse;
    }

    private LocatorOutput createLocator() {
        URI targetUrl = UriComponentsBuilder.fromUriString(anubisCoreMstUrl)
                .path(OBTAIN_LOCATOR_PATH)
                .build()
                .encode()
                .toUri();
        return restTemplate.exchange(targetUrl, HttpMethod.POST, null, LocatorOutput.class).getBody();
    }
}
