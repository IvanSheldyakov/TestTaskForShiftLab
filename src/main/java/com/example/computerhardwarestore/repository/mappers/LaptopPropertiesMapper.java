package com.example.computerhardwarestore.repository.mappers;

import com.example.computerhardwarestore.dto.LaptopProperties;
import com.example.computerhardwarestore.repository.domain.Laptop;
import org.springframework.stereotype.Component;

@Component
public class LaptopPropertiesMapper extends GoodPropertiesMapper {

    public Laptop map(LaptopProperties properties) {
        Laptop laptop = new Laptop();
        mapGoodProperties(properties,laptop);
        laptop.setSize(properties.getSize());
        return laptop;
    }
}
