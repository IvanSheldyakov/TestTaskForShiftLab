package com.example.computerhardwarestore.repository.domain;

import com.example.computerhardwarestore.repository.domain.possiblevalues.PCFormFactorType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pc")
public class PC extends GoodEntity {

    @Column(name = "form_factor")
    private PCFormFactorType formFactor;


    public PCFormFactorType getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(PCFormFactorType formFactor) {
        this.formFactor = formFactor;
    }

    @Override
    public String toString() {
        return "PC{" +
                "formFactor='" + formFactor + '\'' +
                ", id=" + id +
                ", type=" + type +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
