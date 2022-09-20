package com.example.computerhardwarestore.dto;

import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class GoodProperties {



    protected GoodType type;

    @JsonProperty("serial_number")

    protected String serialNumber;

    protected String manufacturer;

    protected Double price;

    @JsonProperty("quantity_in_stock")
    protected Long quantityInStock;


    public GoodProperties(GoodType type, String serialNumber, String manufacturer, Double price, Long quantityInStock) {
        this.type = type;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }
}
