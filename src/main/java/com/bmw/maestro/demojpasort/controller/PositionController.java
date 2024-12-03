package com.bmw.maestro.demojpasort.controller;

import com.bmw.maestro.demojpasort.model.Position;
import com.bmw.maestro.demojpasort.service.PositionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<String> getAllPositions() {
        return positionService.findAll().stream().map(Position::toString).toList();
    }
}
