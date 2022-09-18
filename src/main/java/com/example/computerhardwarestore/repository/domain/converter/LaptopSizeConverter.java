package com.example.computerhardwarestore.repository.domain.converter;

import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class LaptopSizeConverter implements AttributeConverter<LaptopSize,Integer> {
    @Override
    public Integer convertToDatabaseColumn(LaptopSize laptopSize) {
        return laptopSize.getSize();
    }

    @Override
    public LaptopSize convertToEntityAttribute(Integer size) {
        if (size == null) {
            return null;
        }
        return Stream.of(LaptopSize.values())
                .filter(s -> s.getSize() == size)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
