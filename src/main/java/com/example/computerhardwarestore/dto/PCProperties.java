package com.example.computerhardwarestore.dto;

import com.example.computerhardwarestore.repository.domain.possiblevalues.PCFormFactorType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;





@Data
@EqualsAndHashCode(callSuper = true)
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
}
