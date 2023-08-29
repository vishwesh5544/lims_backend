package com.scylex.lims_backend.controllers;

import com.scylex.lims_backend.models.response.ApiResponse;
import com.scylex.lims_backend.models.Unit;
import com.scylex.lims_backend.services.unitService.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;


    @GetMapping("/all")
    ResponseEntity<ApiResponse<List<Unit>>> getAllUnits() {
        ApiResponse<List<Unit>> response = new ApiResponse<List<Unit>>(
                HttpStatus.OK.value(), unitService.getAllUnits(), "All units fetched successfully!"
        );

        return ResponseEntity.ok(response);
    }
}
