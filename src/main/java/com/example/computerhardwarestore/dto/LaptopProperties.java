package com.example.computerhardwarestore.dto;

import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


@Data
@EqualsAndHashCode(callSuper = true)
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
}
