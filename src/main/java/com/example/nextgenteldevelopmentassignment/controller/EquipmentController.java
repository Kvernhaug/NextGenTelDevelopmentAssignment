package com.example.nextgenteldevelopmentassignment.controller;

import com.example.nextgenteldevelopmentassignment.model.Equipment;
import com.example.nextgenteldevelopmentassignment.model.EquipmentType;
import com.example.nextgenteldevelopmentassignment.service.EquipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "api/v1/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Equipment equipment) throws URISyntaxException {
        equipmentService.add(equipment);
        URI uri = new URI("api/v1/equipment/" + 1);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("type/{type}")
    public ResponseEntity findByType(@PathVariable EquipmentType type) {
        return ResponseEntity.ok(
                equipmentService.findByType(type)
        );
    }
}
