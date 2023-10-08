package com.ccl.interfaces.ws.simpleintapi.dtos.documents;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocatorOutput {

    private String p_localizador;
    private String dsError;
    private String cdError;
}
