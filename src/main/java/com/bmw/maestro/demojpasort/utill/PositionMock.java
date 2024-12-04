package com.bmw.maestro.demojpasort.utill;

import com.bmw.maestro.demojpasort.model.EquipmentCategory;
import com.bmw.maestro.demojpasort.model.FinanceData;
import com.bmw.maestro.demojpasort.model.Position;
import com.bmw.maestro.demojpasort.model.PositionStatus;
import com.bmw.maestro.demojpasort.model.RealizationStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PositionMock {

    public static List<Position> getPositionList() {
        Random random = new Random();

        var quantities = random.ints(1500, 1, 200).toArray();
        var values = random.doubles(1500, 1.00, 300.00).toArray();
        var dates = random.longs(1500, -730, 365).toArray();
        var localDates = Arrays.stream(dates).mapToObj(days -> LocalDate.now().plusDays(days)).sorted().toList();

        var equipmentCategories = random.ints(1500, 1, 365).toArray();
        var positionStatuses = random.ints(1500, 1, 3).toArray();
        var realizationStatuses = random.ints(1500, 1, 11).toArray();
        var positionList = new ArrayList<Position>();

        for (int i = 0; i < 1500; i++) {
            var position = new Position("created",
                new FinanceData(quantities[i], values[i]),
                localDates.get(i),
                new EquipmentCategory(equipmentCategories[i]),
                new PositionStatus(positionStatuses[i]),
                new RealizationStatus(realizationStatuses[i])
            );
            positionList.add(position);
        }
        return positionList;
    }
}
