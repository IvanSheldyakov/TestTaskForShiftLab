package com.example.computerhardwarestore.dto;

import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;


@Data
@ToString
public abstract class GoodProperties {



    protected GoodType type;

    @JsonProperty("serial_number")

    protected String serialNumber;

    protected String manufacturer;

    protected Double price;

    @JsonProperty("quantity_in_stock")
    protected Long quantityInStock;

}
