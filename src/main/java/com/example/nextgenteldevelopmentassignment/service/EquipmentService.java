package com.example.nextgenteldevelopmentassignment.service;

import com.example.nextgenteldevelopmentassignment.model.Equipment;
import com.example.nextgenteldevelopmentassignment.model.EquipmentType;

import java.util.Set;

public interface EquipmentService {

    Equipment add(Equipment entity);
    Set<Equipment> findByType(EquipmentType type);
}
