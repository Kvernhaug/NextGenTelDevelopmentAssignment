package com.example.nextgenteldevelopmentassignment.controller;

import com.example.nextgenteldevelopmentassignment.model.Equipment;
import com.example.nextgenteldevelopmentassignment.model.EquipmentType;
import com.example.nextgenteldevelopmentassignment.service.EquipmentService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ProblemDetail;
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
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)
                    )
            )
    })
    public ResponseEntity add(@RequestBody Equipment equipment) throws URISyntaxException {
        equipmentService.add(equipment);
        URI uri = new URI("api/v1/equipment/" + 1);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("type/{type}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(
                                            schema = @Schema(
                                                    implementation = Equipment.class
                                            )
                                    )
                            )
                    }
            )
    })
    public ResponseEntity findByType(@PathVariable EquipmentType type) {
        return ResponseEntity.ok(
                equipmentService.findByType(type)
        );
    }
}
