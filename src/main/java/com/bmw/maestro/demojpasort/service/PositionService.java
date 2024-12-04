package com.bmw.maestro.demojpasort.service;

import com.bmw.maestro.demojpasort.model.Position;
import com.bmw.maestro.demojpasort.repository.PositionRepository;
import com.bmw.maestro.demojpasort.utill.SortOrderParam;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bmw.maestro.demojpasort.utill.PositionMock.getPositionList;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public void saveAll(){
        var positionList = getPositionList();
        positionRepository.saveAll(positionList);
    }

    public List<Position> findAll(SortOrderParam param) {
        return positionRepository.findAll(param.getSortList());
    }
}
