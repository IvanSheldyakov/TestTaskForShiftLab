package com.example.computerhardwarestore.dto;

import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class LaptopProperties extends GoodProperties{

    private LaptopSize size;

    @Override
    public String toString() {
        return "LaptopProperties{" +
                "size=" + size +
                ", type=" + type +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }

    public LaptopProperties(GoodType type, String serialNumber,
                            String manufacturer, Double price, Long quantityInStock, LaptopSize size) {
        super(type, serialNumber, manufacturer, price, quantityInStock);
        this.size = size;
    }
}
