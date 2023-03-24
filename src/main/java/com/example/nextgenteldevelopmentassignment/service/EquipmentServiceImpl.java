package com.example.nextgenteldevelopmentassignment.service;

import com.example.nextgenteldevelopmentassignment.model.Equipment;
import com.example.nextgenteldevelopmentassignment.model.EquipmentType;
import com.example.nextgenteldevelopmentassignment.repository.EquipmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final Logger logger = LoggerFactory.getLogger(EquipmentServiceImpl.class);

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Equipment add(Equipment entity) {
        return equipmentRepository.save(entity);
    }

    @Override
    public Set<Equipment> findByType(EquipmentType type) {
        Collection<Equipment> allEquipment = equipmentRepository.findAll();
        Set<Equipment> equipmentOfType = new HashSet<>();
        for (Equipment equipment : allEquipment) {
            if (equipment.getType() == type) {
                equipmentOfType.add(equipment);
            }
        }
        return equipmentOfType;
    }
}
