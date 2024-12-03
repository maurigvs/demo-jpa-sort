package com.bmw.maestro.demojpasort.service;

import com.bmw.maestro.demojpasort.model.Position;
import com.bmw.maestro.demojpasort.repository.PositionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private static final Sort DEFAULT_SORT = Sort.by(Sort.Direction.DESC, Position.TEXT_A);

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> findAll() {
        return positionRepository.findAll(DEFAULT_SORT);
    }

    /*
    Sort.by(List.of(
            new Sort.Order(Sort.Direction.DESC, "textA"),
            new Sort.Order(Sort.Direction.ASC, "textE"),
            new Sort.Order(Sort.Direction.ASC, "textC")
        ))
     */
}
