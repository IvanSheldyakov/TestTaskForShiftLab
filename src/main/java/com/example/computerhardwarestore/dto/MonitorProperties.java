package com.example.computerhardwarestore.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
@EqualsAndHashCode(callSuper = true)

public class MonitorProperties extends GoodProperties{


    private Double diagonal;

    @Override
    public String toString() {
        return "MonitorProperties{" +
                "diagonal=" + diagonal +
                ", type=" + type +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
