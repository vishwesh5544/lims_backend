package com.scylex.lims_backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Builder
@Table(name = "labs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Lab {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("id")
    Long id = null;

    @JsonProperty("labName")
    @Column(name = "lab_name")
    String labName;

    @JsonProperty("email")
    @Column(name = "email")
    String email;

    @JsonProperty("phoneNumber")
    @Column(name = "phone_number")
    String phoneNumber;

    @JsonProperty("addressOne")
    @Column(name = "address_one")
    String addressOne;

    @JsonProperty("addressTwo")
    @Column(name = "address_two")
    String addressTwo;

    @JsonProperty("city")
    @Column(name = "city")
    String city;

    @JsonProperty("postalCode")
    @Column(name = "postal_code")
    String postalCode;

    @JsonProperty("state")
    @Column(name = "state")
    String state;

    @JsonProperty("country")
    @Column(name = "country")
    String country;

    @JsonProperty("unitId")
    @Column(name = "unit_id")
    Long unitId;
}
