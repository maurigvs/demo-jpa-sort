package com.bmw.maestro.demojpasort.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String comment;

    @Embedded
    private FinanceData financeData;

    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "equipment_category_id")
    private EquipmentCategory equipmentCategory;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private PositionStatus positionStatus;

    @ManyToOne
    @JoinColumn(name = "realization_status_id")
    private RealizationStatus realizationStatus;

    public Position(String comment, FinanceData financeData, LocalDate createdDate, EquipmentCategory equipmentCategory, PositionStatus positionStatus, RealizationStatus realizationStatus) {
        this.comment = comment;
        this.financeData = financeData;
        this.createdDate = createdDate;
        this.equipmentCategory = equipmentCategory;
        this.positionStatus = positionStatus;
        this.realizationStatus = realizationStatus;
    }

    public Position() {
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

    public FinanceData getFinanceData() {
        return financeData;
    }

    public void setFinanceData(FinanceData financeData) {
        this.financeData = financeData;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
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

    public void setPositionStatus(PositionStatus positionStatus) {
        this.positionStatus = positionStatus;
    }

    public RealizationStatus getRealizationStatus() {
        return realizationStatus;
    }

    public void setRealizationStatus(RealizationStatus realizationStatus) {
        this.realizationStatus = realizationStatus;
    }

    @Override
    public String toString() {
        return id + ", " + comment +
                ", " + financeData +
                ", " + createdDate +
                ", " + equipmentCategory +
                ", " + positionStatus +
                ", " + realizationStatus;
    }
}
