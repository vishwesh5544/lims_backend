package com.scylex.lims_backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    @Setter
    int statusCode;
    @Setter
    T data;
    @Setter
    String message;
}
