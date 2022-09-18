package com.example.computerhardwarestore.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
@EqualsAndHashCode(callSuper = true)
public class LaptopProperties extends GoodProperties{

    @NotNull(message = "Size cannot be null")
    @Positive(message = "Size cannot be negative")
    private Integer size;

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
}
