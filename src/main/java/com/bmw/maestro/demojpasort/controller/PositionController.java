package com.bmw.maestro.demojpasort.controller;

import com.bmw.maestro.demojpasort.model.Position;
import com.bmw.maestro.demojpasort.service.PositionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postPositions(){
        positionService.saveAll();
    }

    @GetMapping
    public List<String> getAllPositions() {
        return positionService.findAll().stream().map(Position::toString).toList();
    }
}
