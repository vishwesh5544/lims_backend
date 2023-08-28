package com.scylex.lims_backend.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("id")
    Long id;

    @JsonProperty("departmentName")
    @Column(name = "name")
    String name;

    @JsonProperty("value")
    @Column(name = "value")
    String value;
}
