package com.scylex.lims_backend.controllers;


import com.scylex.lims_backend.models.response.ApiResponse;
import com.scylex.lims_backend.models.Department;
import com.scylex.lims_backend.services.departmentService.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/all")
    ResponseEntity<ApiResponse<List<Department>>> getAllDepartments() {
        ApiResponse<List<Department>> apiResponse = new ApiResponse<List<Department>>(
                HttpStatus.OK.value(), departmentService.getAllDepartments(), "All departments fetched successfully!"
        );

        return ResponseEntity.ok(apiResponse);
    }
}
