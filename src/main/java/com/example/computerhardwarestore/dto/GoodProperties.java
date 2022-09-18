package com.example.computerhardwarestore.dto;

import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;


@Data
@ToString
public abstract class GoodProperties {


    @NotNull(message = "Type cannot be null")
    protected GoodType type;

    @JsonProperty("serial_number")
    @NotBlank(message = "serial number cannot be blank")
    protected String serialNumber;

    @NotBlank(message = "serial manufacturer cannot be blank")
    protected String manufacturer;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price cannot be negative")
    protected Double price;

    @JsonProperty("quantity_in_stock")
    @NotNull(message = "Quantity cannot be null")
    @PositiveOrZero(message = "Quantity cannot be negative")
    protected Long quantityInStock;

}
