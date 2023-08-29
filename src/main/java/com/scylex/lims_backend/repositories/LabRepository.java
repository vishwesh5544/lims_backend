package com.scylex.lims_backend.repositories;

import com.scylex.lims_backend.models.Lab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabRepository extends JpaRepository<Lab, Long> {
}
