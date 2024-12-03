package com.bmw.maestro.demojpasort.model;

public record PositionDto(
        String line
) {

    public PositionDto(Position position) {
        this(position.toString());
    }
}
