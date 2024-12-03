package com.bmw.maestro.demojpasort.service;

import com.bmw.maestro.demojpasort.model.EquipmentCategory;
import com.bmw.maestro.demojpasort.model.Position;
import com.bmw.maestro.demojpasort.model.PositionStatus;
import com.bmw.maestro.demojpasort.model.RealizationStatus;
import com.bmw.maestro.demojpasort.repository.PositionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PositionService {

    private static final Sort DEFAULT_SORT = Sort.by(
            new Sort.Order(Sort.Direction.ASC, "equipmentCategory.name"),
            new Sort.Order(Sort.Direction.DESC, "status.name"),
            new Sort.Order(Sort.Direction.ASC, "realizationStatus.name"));

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public void saveAll(){
        Random random = new Random();
        var equipmentCategoryIds = random.ints(1500, 1, 365).toArray();
        var positionStatusIds = random.ints(1500, 1, 3).toArray();
        var realizationStatusIds = random.ints(1500, 1, 11).toArray();
        var positionList = new ArrayList<Position>();

        for (int i = 0; i < 1500; i++) {
            positionList.add(new Position("created",
                    new EquipmentCategory(equipmentCategoryIds[i]),
                    new PositionStatus(positionStatusIds[i]),
                    new RealizationStatus(realizationStatusIds[i])));
        }

        positionRepository.saveAll(positionList);
    }

    public List<Position> findAll() {
        return positionRepository.findAll(DEFAULT_SORT);
    }
}
