package com.example.computerhardwarestore.repository.mappers;

import com.example.computerhardwarestore.dto.GoodProperties;
import com.example.computerhardwarestore.repository.domain.GoodEntity;

public abstract class GoodPropertiesMapper {

    protected void mapGoodProperties(GoodProperties properties, GoodEntity entity) {
        entity.setSerialNumber(properties.getSerialNumber());
        entity.setManufacturer(properties.getManufacturer());
        entity.setPrice(properties.getPrice());
        entity.setQuantityInStock(properties.getQuantityInStock());
        entity.setType(properties.getType());
    }
}
