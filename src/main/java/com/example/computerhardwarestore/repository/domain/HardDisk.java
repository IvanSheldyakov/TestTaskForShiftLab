package com.example.computerhardwarestore.repository.domain;

import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "hard_disk")
public class HardDisk extends GoodEntity{

    @Column(name = "volume")
    @NotNull(message = "Volume cannot be null")
    @Positive(message = "Volume cannot be negative")
    private double volume;

    public HardDisk(Long id, GoodType type, String serialNumber,
                    String manufacturer, double price, Long quantityInStock, double volume) {
        super(id, type, serialNumber, manufacturer, price, quantityInStock);
        this.volume = volume;
    }

    public HardDisk() {

    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "HardDisk{" +
                "volume=" + volume +
                ", id=" + id +
                ", type=" + type +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
