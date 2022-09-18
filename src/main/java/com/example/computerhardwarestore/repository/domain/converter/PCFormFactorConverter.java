package com.example.computerhardwarestore.repository.domain.converter;

import com.example.computerhardwarestore.repository.domain.possiblevalues.PCFormFactorType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class PCFormFactorConverter implements AttributeConverter<PCFormFactorType,String> {
    @Override
    public String convertToDatabaseColumn(PCFormFactorType pcFormFactorType) {
        return pcFormFactorType.getType();
    }

    @Override
    public PCFormFactorType convertToEntityAttribute(String type) {
        if (type == null) {
            return null;
        }
        return Stream.of(PCFormFactorType.values())
                .filter(s -> s.getType().equals(type))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
