package com.scylex.lims_backend.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    @Setter
    int statusCode;
    @Setter
    T data;
    @Setter
    String message;


    public static ApiResponse<String> createBadRequestResponseWithMessage(String message) {
        return new ApiResponse<String>(HttpStatus.BAD_REQUEST.value(), null, message);
    }
}
