package com.scylex.lims_backend.services.unitService;

import com.scylex.lims_backend.models.Unit;
import com.scylex.lims_backend.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UnitService {
    List<Unit> getAllUnits();

    Unit getUnitById(Long unitId);
}

@Service
class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitRepository unitRepository;

    @Override
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    @Override
    public Unit getUnitById(Long unitId) {
        return unitRepository.findById(unitId).orElse(null);
    }
}
