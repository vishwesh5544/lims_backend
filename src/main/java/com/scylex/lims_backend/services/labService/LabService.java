package com.scylex.lims_backend.services.labService;

import com.scylex.lims_backend.models.Lab;
import com.scylex.lims_backend.models.Unit;
import com.scylex.lims_backend.models.dto.LabWithUnit;
import com.scylex.lims_backend.repositories.LabRepository;
import com.scylex.lims_backend.repositories.UnitRepository;
import com.scylex.lims_backend.services.unitService.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface LabService {
    Lab addLab(Lab lab);

    List<LabWithUnit> getAllLabs();

    Lab deleteLabById(Long id);

}

@Service
class LabServiceImpl implements LabService {

    @Autowired
    private LabRepository labRepository;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private UnitService unitService;

    @Override
    public Lab addLab(@org.jetbrains.annotations.NotNull Lab lab) {
        if (unitRepository.findById(lab.getUnitId()).isPresent()) {
            return labRepository.save(lab);
        } else {
            return null;
        }
    }

    @Override
    public List<LabWithUnit> getAllLabs() {
        List<Lab> labs = labRepository.findAll();
        List<LabWithUnit> labsWithUnit = new java.util.ArrayList<>(Collections.emptyList());
        for (Lab lab : labs) {
            labsWithUnit.add(buildLabWithUnit(lab));
        }
        return labsWithUnit;
    }

    @Override
    public Lab deleteLabById(Long id) {
        Optional<Lab> existingLab = labRepository.findById(id);
        if (existingLab.isPresent()) {
            labRepository.deleteById(id);
            return existingLab.get();
        } else {
            return null;
        }
    }

    private LabWithUnit buildLabWithUnit(Lab lab) {
        Unit unit = unitService.getUnitById(lab.getUnitId());
        return LabWithUnit.builder()
                .id(lab.getId())
                .labName(lab.getLabName())
                .email(lab.getEmail())
                .phoneNumber(lab.getPhoneNumber())
                .addressOne(lab.getAddressOne())
                .addressTwo(lab.getAddressTwo())
                .city(lab.getCity())
                .state(lab.getState())
                .country(lab.getCountry())
                .postalCode(lab.getPostalCode())
                .unit(unit)
                .build();
    }
}

