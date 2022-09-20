package com.example.computerhardwarestore.repository.mappers;

import com.example.computerhardwarestore.dto.PCProperties;
import com.example.computerhardwarestore.repository.domain.PC;
import org.springframework.stereotype.Component;

@Component
public class PCPropertiesMapper extends GoodPropertiesMapper{

    public PC map(PCProperties properties) {
        PC pc = new PC();
        mapGoodProperties(properties,pc);
        pc.setFormFactor(properties.getFormFactor());
        return pc;
    }
}
