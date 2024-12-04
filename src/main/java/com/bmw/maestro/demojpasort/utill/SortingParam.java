package com.bmw.maestro.demojpasort.utill;

import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SortingParam {

    private static final String OUTER_SPLIT = ";";
    private static final String INNER_SPLIT = ",";
    private static final String HEADER_KEY = "sorting";

    private static final Map<String, String> SORTABLE_FIELDS = Map.of(
            "id", "id",
            "equipmentCategory", "equipmentCategory.name",
            "status", "status.name",
            "realizationStatus", "realizationStatus.name");

    private final List<Sort.Order> orderList;

    public SortingParam(Map<String, String> params) {
        this.orderList = hasSorting(params) ? mapSortList(params) : mapDefault();
    }

    public Sort getSortList() {
        return Sort.by(orderList);
    }

    private static boolean hasSorting(Map<String, String> params) {
        return params != null && params.containsKey(HEADER_KEY);
    }

    private List<Sort.Order> mapDefault() {
        return mapSortList(Map.of(HEADER_KEY, "id,asc"));
    }

    private static List<Sort.Order> mapSortList(Map<String, String> params) {
        return Arrays.stream(getFieldParams(params))
                .map(SortingParam::getSortParams)
                .map(SortingParam::mapSortOrder)
                .toList();
    }

    private static String[] getFieldParams(Map<String, String> headerMap) {
        return headerMap.get(HEADER_KEY).split(OUTER_SPLIT);
    }

    private static String[] getSortParams(String params) {
        return params.split(INNER_SPLIT);
    }

    private static Sort.Order mapSortOrder(String[] params) {
        if(Sort.Direction.fromOptionalString(params[1]).isEmpty())
            throw new IllegalArgumentException("Invalid sort direction: " + params[1]);

        return new Sort.Order(Sort.Direction.fromString(params[1]), mapSortField(params[0]));
    }

    public static String mapSortField(String field) {
        if(!SORTABLE_FIELDS.containsKey(field))
            throw new IllegalArgumentException("Invalid field name: " + field);

        return SORTABLE_FIELDS.get(field);
    }
}
