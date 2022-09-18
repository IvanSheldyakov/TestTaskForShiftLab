package com.example.computerhardwarestore.service;

import com.example.computerhardwarestore.repository.domain.*;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;

import java.util.List;
import java.util.Optional;

public interface SearchService {

    Optional<GoodEntity> findGoodById(Long id);
    List<GoodEntity> findAllByType(GoodType type);

    Optional<Monitor> findMonitorById(Long id);

    Optional<HardDisk> findHardDiskById(Long id);

    Optional<Laptop> findLaptopById(Long id);

    Optional<PC> findPCById(Long id);

}
