package com.bmw.maestro.demojpasort.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Position {

    public static final String TEXT_A = "textA";
    public static final String TEXT_B = "textB";
    public static final String TEXT_C = "textC";
    public static final String TEXT_D = "textD";
    public static final String TEXT_E = "textE";
    public static final String TEXT_F = "textF";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "text_a")
    private String textA;

    @Column(name = "text_b")
    private String textB;

    @Column(name = "text_c")
    private String textC;

    @Column(name = "text_d")
    private String textD;

    @Column(name = "text_e")
    private String textE;

    @Column(name = "text_f")
    private String textF;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTextA() {
        return textA;
    }

    public void setTextA(String textA) {
        this.textA = textA;
    }

    public String getTextB() {
        return textB;
    }

    public void setTextB(String textB) {
        this.textB = textB;
    }

    public String getTextC() {
        return textC;
    }

    public void setTextC(String textC) {
        this.textC = textC;
    }

    public String getTextD() {
        return textD;
    }

    public void setTextD(String textD) {
        this.textD = textD;
    }

    public String getTextE() {
        return textE;
    }

    public void setTextE(String textE) {
        this.textE = textE;
    }

    public String getTextF() {
        return textF;
    }

    public void setTextF(String textF) {
        this.textF = textF;
    }

    @Override
    public String toString() {
        return id +
                ", " + textA +
                ", " + textB +
                ", " + textC +
                ", " + textD +
                ", " + textE +
                ", " + textF;
    }
}
