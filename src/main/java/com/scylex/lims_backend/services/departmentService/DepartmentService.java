package com.scylex.lims_backend.services.departmentService;

import com.scylex.lims_backend.models.Department;
import com.scylex.lims_backend.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
}

@Service
class DepartmentSerivceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
