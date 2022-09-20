package com.example.computerhardwarestore.repository.domain;

import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;


@Entity
@Table(name = "good")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class GoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(name = "type")
    @NotNull(message = "Type cannot be null")
    @JsonIgnore
    protected GoodType type;

    @Column(name = "serial_number")
    @NotBlank(message = "serial number cannot be blank")
    @JsonProperty("serial_number")
    protected String serialNumber;

    @Column(name = "manufacturer")
    @NotBlank(message = "serial manufacturer cannot be blank")
    protected String manufacturer;

    @Column(name = "price")
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price cannot be negative")
    protected Double price;

    @Column(name = "quantity_in_stock")
    @NotNull(message = "Quantity cannot be null")
    @PositiveOrZero(message = "Quantity cannot be negative")
    @JsonProperty("quantity_in_stock")
    protected Long quantityInStock;

    public GoodEntity(Long id, GoodType type, String serialNumber,
                      String manufacturer, double price, Long quantityInStock) {
        this.id = id;
        this.type = type;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public GoodEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GoodType getType() {
        return type;
    }

    public void setType(GoodType type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public @NotNull(message = "Price cannot be null") @Positive(message = "Price cannot be negative") Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price cannot be null") @Positive(message = "Price cannot be negative") Double price) {
        this.price = price;
    }

    public Long getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Long quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "GoodEntity{" +
                "id=" + id +
                ", type=" + type +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
