package com.example.computerhardwarestore.dto;

import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.repository.domain.possiblevalues.PCFormFactorType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class PCProperties extends GoodProperties {

    @JsonProperty("form_factor")
    private PCFormFactorType formFactor;


    @Override
    public String toString() {
        return "PCProperties{" +
                "formFactor='" + formFactor + '\'' +
                ", type=" + type +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }

    public PCProperties(GoodType type, String serialNumber,
                        String manufacturer, Double price, Long quantityInStock, PCFormFactorType formFactor) {
        super(type, serialNumber, manufacturer, price, quantityInStock);
        this.formFactor = formFactor;
    }
}
