package com.bmw.maestro.demojpasort.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "equipment_category_id")
    private EquipmentCategory equipmentCategory;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private PositionStatus positionStatus;

    @ManyToOne
    @JoinColumn(name = "realization_status_id")
    private RealizationStatus realizationStatus;

    public Position() {
    }

    public Position(String comment, EquipmentCategory equipmentCategory, PositionStatus positionStatus, RealizationStatus realizationStatus) {
        this.comment = comment;
        this.equipmentCategory = equipmentCategory;
        this.positionStatus = positionStatus;
        this.realizationStatus = realizationStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public EquipmentCategory getEquipmentCategory() {
        return equipmentCategory;
    }

    public void setEquipmentCategory(EquipmentCategory equipmentCategory) {
        this.equipmentCategory = equipmentCategory;
    }

    public PositionStatus getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(PositionStatus status) {
        this.positionStatus = status;
    }

    public RealizationStatus getRealizationStatus() {
        return realizationStatus;
    }

    public void setRealizationStatus(RealizationStatus realizationStatus) {
        this.realizationStatus = realizationStatus;
    }

    @Override
    public String toString() {
        return id +
                ", " + comment +
                ", " + equipmentCategory +
                ", " + positionStatus +
                ", " + realizationStatus;
    }
}
