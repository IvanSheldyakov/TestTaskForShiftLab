package com.example.computerhardwarestore.dto;


import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class HardDiskProperties extends GoodProperties {

    private Double volume;

    @Override
    public String toString() {
        return "HardDiskProperties{" +
                "volume=" + volume +
                ", type=" + type +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }

    public HardDiskProperties(GoodType type, String serialNumber,
                              String manufacturer, Double price, Long quantityInStock, Double volume) {
        super(type, serialNumber, manufacturer, price, quantityInStock);
        this.volume = volume;
    }
}
