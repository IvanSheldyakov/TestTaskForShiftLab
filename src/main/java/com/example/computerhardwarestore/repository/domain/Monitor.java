package com.example.computerhardwarestore.repository.domain;

import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "monitor")
public class Monitor extends GoodEntity {

    @Column(name = "diagonal")
    @NotNull(message = "Diagonal cannot be null")
    @Positive(message = "Diagonal cannot be negative")
    private  Double diagonal;

    public Monitor(Long id, GoodType type, String serialNumber, String manufacturer,
                   double price, Long quantityInStock, double diagonal) {
        super(id, type, serialNumber, manufacturer, price, quantityInStock);
        this.diagonal = diagonal;
    }

    public Monitor() {

    }


    public @NotNull(message = "Diagonal cannot be null") @Positive(message = "Diagonal cannot be negative") Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(@NotNull(message = "Diagonal cannot be null") @Positive(message = "Diagonal cannot be negative") Double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "diagonal=" + diagonal +
                ", id=" + id +
                ", type=" + type +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
