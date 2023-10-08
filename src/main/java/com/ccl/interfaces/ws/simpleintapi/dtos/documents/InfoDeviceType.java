package com.ccl.interfaces.ws.simpleintapi.dtos.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoDeviceType {

    private String imei;
    private String deviceId;
    private String mac;
    private String deviceSO;
    private String appVersion;
}
