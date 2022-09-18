package com.example.computerhardwarestore.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@EqualsAndHashCode(callSuper = true)

public class HardDiskProperties extends GoodProperties {
    @NotNull(message = "Volume cannot be null")
    @Positive(message = "Volume cannot be negative")
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
}
