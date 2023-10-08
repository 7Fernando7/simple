package com.ccl.interfaces.ws.simpleintapi.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDto {

    private long id;
    private String name;
    private int age;
    private String city;

}
