package com.scylex.lims_backend.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scylex.lims_backend.models.Unit;
import lombok.Builder;

@Builder
public class LabWithUnit {
    @JsonProperty("id")
    Long id;

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

    @JsonProperty("unit")
    Unit unit;
}
