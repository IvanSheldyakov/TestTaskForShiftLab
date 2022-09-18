package com.example.computerhardwarestore.repository.domain;


import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "laptop")
public class Laptop extends GoodEntity {

    @Column(name = "size")
    @NotNull(message = "Type cannot be null")
    private LaptopSize size;

    public LaptopSize getSize() {
        return size;
    }

    public void setSize(LaptopSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "size=" + size +
                ", id=" + id +
                ", type=" + type +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
