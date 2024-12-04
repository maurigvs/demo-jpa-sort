package com.bmw.maestro.demojpasort.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class FinanceData {

    private int quantity;

    private double value;

    public FinanceData() {
    }

    public FinanceData(int quantity, double value) {
        this.quantity = quantity;
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return quantity + ", " + value;
    }
}
