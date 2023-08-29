package com.scylex.lims_backend.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddLabRequest {
    @JsonProperty("labName")
    String labName;

    @JsonProperty("email")
    String email;

    @JsonProperty("phoneNumber")
    String phoneNumber;

    @JsonProperty("addressOne")
    String addressOne;

    @JsonProperty("addressTwo")
    String addressTwo;

    @JsonProperty("city")
    String city;

    @JsonProperty("postalCode")
    String postalCode;

    @JsonProperty("state")
    String state;

    @JsonProperty("country")
    String country;

    @JsonProperty("unitId")
    Long unitId;
}
