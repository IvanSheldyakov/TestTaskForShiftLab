package com.example.computerhardwarestore.repository.mappers;

import com.example.computerhardwarestore.dto.HardDiskProperties;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import org.springframework.stereotype.Component;

@Component
public class HardDiskPropertiesMapper extends GoodPropertiesMapper{


    public HardDisk map(HardDiskProperties properties) {
        HardDisk hardDisk = new HardDisk();
        mapGoodProperties(properties,hardDisk);
        hardDisk.setVolume(properties.getVolume());
        return hardDisk;
    }
}
