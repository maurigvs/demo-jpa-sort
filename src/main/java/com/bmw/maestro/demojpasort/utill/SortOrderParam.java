package com.bmw.maestro.demojpasort.utill;

import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SortOrderParam {

    private static final String OUTER_SPLIT = ";";
    private static final String INNER_SPLIT = ",";
    private static final String HEADER_KEY = "sorting";

    /*
       Make sure that the values in this Map are the same as the field names in the Position class.
    */
    private static final Map<String, String> SORTABLE_FIELDS = Map.of(
            "id", "id",
            "quantity", "financeData.quantity",
            "value", "financeData.value",
            "createdDate", "createdDate",
            "equipmentCategory", "equipmentCategory.name",
            "positionStatus", "positionStatus.name",
            "realizationStatus", "realizationStatus.name");

    private final List<Sort.Order> orderList;

    public SortOrderParam(Map<String, String> params) {
        this.orderList = hasSorting(params) ? mapSortList(params) : mapDefault();
    }

    public Sort getSortList() {
        return Sort.by(orderList);
    }

    private List<Sort.Order> mapDefault() {
        return mapSortList(Map.of(HEADER_KEY, "id,asc"));
    }

    private static boolean hasSorting(Map<String, String> params) {
        return params != null && params.containsKey(HEADER_KEY);
    }

    private static List<Sort.Order> mapSortList(Map<String, String> params) {
        return Arrays.stream(params.get(HEADER_KEY).split(OUTER_SPLIT))
                .map(param -> param.split(INNER_SPLIT))
                .map(SortOrderParam::mapOrder)
                .toList();
    }

    private static Sort.Order mapOrder(String[] params) {
        if(params.length != 2)
            throw new IllegalArgumentException("Field name or sort order is missing in: %s"
                    .formatted(String.join(",", params)));

        if(Sort.Direction.fromOptionalString(params[1]).isEmpty())
            throw new IllegalArgumentException("Unknown sort order: %s".formatted(params[1]));

        return new Sort.Order(Sort.Direction.fromString(params[1]), mapSortField(params[0]));
    }

    public static String mapSortField(String field) {
        if(!SORTABLE_FIELDS.containsKey(field))
            throw new IllegalArgumentException("Unknown field name: %s".formatted(field));

        return SORTABLE_FIELDS.get(field);
    }
}
