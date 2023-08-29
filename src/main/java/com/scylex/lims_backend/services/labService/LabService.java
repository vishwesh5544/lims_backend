package com.scylex.lims_backend.services.labService;

import com.scylex.lims_backend.models.Lab;
import com.scylex.lims_backend.repositories.LabRepository;
import com.scylex.lims_backend.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface LabService {
    Lab addLab(Lab lab);

    List<Lab> getAllLabs();

    Lab deleteLabById(Long id);

}

@Service
class LabServiceImpl implements LabService {

    @Autowired
    private LabRepository labRepository;
    @Autowired
    private UnitRepository unitRepository;

    @Override
    public Lab addLab(@org.jetbrains.annotations.NotNull Lab lab) {
        if (unitRepository.findById(lab.getUnitId()).isPresent()) {
            return labRepository.save(lab);
        } else {
            return null;
        }
    }

    @Override
    public List<Lab> getAllLabs() {
        return labRepository.findAll();
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
}

