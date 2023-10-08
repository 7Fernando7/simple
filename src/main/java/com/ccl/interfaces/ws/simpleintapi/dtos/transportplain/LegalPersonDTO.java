package com.ccl.interfaces.ws.simpleintapi.dtos.transportplain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LegalPersonDTO {
    private ActorAdressDTO actorAdress;
    private ActorIdDTO actorID;
    private String actorName;
    private List<String> actorRoles;
    private String actorWebSite;
    private String actorEmail;
    private String actorPhoneNumber;
}
