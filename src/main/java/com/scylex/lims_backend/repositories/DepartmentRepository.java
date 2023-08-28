package com.scylex.lims_backend.repositories;

import com.scylex.lims_backend.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
