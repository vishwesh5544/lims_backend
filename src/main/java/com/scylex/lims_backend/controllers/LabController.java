package com.scylex.lims_backend.controllers;


import com.scylex.lims_backend.models.Lab;
import com.scylex.lims_backend.models.dto.LabWithUnit;
import com.scylex.lims_backend.models.request.AddLabRequest;
import com.scylex.lims_backend.models.response.ApiResponse;
import com.scylex.lims_backend.services.labService.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab")
public class LabController {
    @Autowired
    private LabService labService;

    @PostMapping
    ResponseEntity<ApiResponse<Lab>> addLab(
            @RequestBody AddLabRequest addLabRequest
    ) {
        Lab labToAdd = Lab.builder()
                .labName(addLabRequest.getLabName())
                .email(addLabRequest.getEmail())
                .phoneNumber(addLabRequest.getPhoneNumber())
                .addressOne(addLabRequest.getAddressOne())
                .addressTwo(addLabRequest.getAddressTwo())
                .city(addLabRequest.getCity())
                .postalCode(addLabRequest.getPostalCode())
                .state(addLabRequest.getState())
                .country(addLabRequest.getCountry())
                .unitId(addLabRequest.getUnitId())
                .build();

        Lab createdLab = labService.addLab(labToAdd);
        if (createdLab != null && createdLab.getId() != null) {
            ApiResponse<Lab> apiResponse = new ApiResponse<>(HttpStatus.CREATED.value(),
                    createdLab, "Lab created successfully!");

            return ResponseEntity.ok(apiResponse);
        } else {
            return ResponseEntity.badRequest().body(
                    new ApiResponse<Lab>(HttpStatus.BAD_REQUEST.value(), null, "Lab creation failed!")
            );
        }
    }

    @GetMapping("/all")
    ResponseEntity<ApiResponse<List<LabWithUnit>>> getAllLabs() {
        ApiResponse<List<LabWithUnit>> apiResponse = new ApiResponse<>(HttpStatus.OK.value(),
                labService.getAllLabs(), "All labs fetched successfully!");
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<Lab>> deleteLabForId(@PathVariable Long id) {
        Lab deletedLab = labService.deleteLabById(id);

        if (deletedLab != null && deletedLab.getId() != null) {
            ApiResponse<Lab> apiResponse = new ApiResponse<>(HttpStatus.NO_CONTENT.value(),
                    deletedLab, "Lab deleted successfully!");

            return ResponseEntity.ok(apiResponse);
        } else {
            return ResponseEntity.badRequest().body(
                    new ApiResponse<Lab>(HttpStatus.BAD_REQUEST.value(), null, "Lab deletion failed!")
            );
        }
    }
}
