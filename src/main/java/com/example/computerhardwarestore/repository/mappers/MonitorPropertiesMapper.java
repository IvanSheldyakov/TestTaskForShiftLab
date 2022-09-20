package com.example.computerhardwarestore.repository.mappers;

import com.example.computerhardwarestore.dto.MonitorProperties;
import com.example.computerhardwarestore.repository.domain.Monitor;
import org.springframework.stereotype.Component;

@Component
public class MonitorPropertiesMapper extends GoodPropertiesMapper{

    public Monitor map(MonitorProperties properties) {
        Monitor monitor = new Monitor();
        mapGoodProperties(properties,monitor);
        monitor.setDiagonal(properties.getDiagonal());
        return monitor;
    }
}
