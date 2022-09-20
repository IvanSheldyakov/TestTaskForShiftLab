package com.example.computerhardwarestore.dto;

import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
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

    public MonitorProperties(GoodType type, String serialNumber,
                             String manufacturer, Double price, Long quantityInStock, Double diagonal) {
        super(type, serialNumber, manufacturer, price, quantityInStock);
        this.diagonal = diagonal;
    }
}
