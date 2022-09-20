package com.example.computerhardwarestore.repository.domain.converter;

import com.example.computerhardwarestore.exceptions.IllegalPropertiesException;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class GoodTypeConverter implements AttributeConverter<GoodType,String> {
    @Override
    public String convertToDatabaseColumn(GoodType goodType) {
        return goodType.getType();
    }

    @Override
    public GoodType convertToEntityAttribute(String type) {
        if (type == null) {
            return null;
        }
        return Stream.of(GoodType.values())
                        .filter(s -> s.getType().equals(type))
                        .findFirst()
                        .orElseThrow(IllegalPropertiesException::new);
    }
}
