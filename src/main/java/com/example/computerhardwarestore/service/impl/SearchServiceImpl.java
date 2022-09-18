package com.example.computerhardwarestore.service.impl;

import com.example.computerhardwarestore.repository.*;
import com.example.computerhardwarestore.repository.domain.*;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService {

    private GoodRepository goodRepository;
    private HardDiskRepository hardDiskRepository;
    private MonitorRepository monitorRepository;
    private LaptopRepository laptopRepository;
    private PCRepository pcRepository;

    @Autowired
    public SearchServiceImpl(GoodRepository goodRepository,
                             HardDiskRepository hardDiskRepository,
                             MonitorRepository monitorRepository,
                             LaptopRepository laptopRepository,
                             PCRepository pcRepository) {
        this.goodRepository = goodRepository;
        this.hardDiskRepository = hardDiskRepository;
        this.monitorRepository = monitorRepository;
        this.laptopRepository = laptopRepository;
        this.pcRepository = pcRepository;
    }



    @Override
    public Optional<GoodEntity> findGoodById(Long id) {
        return goodRepository.findById(id);
    }

    @Override
    public List<GoodEntity> findAllByType(GoodType type) {
        return goodRepository.findAllByType(type);
    }

    @Override
    public Optional<Monitor> findMonitorById(Long id) {
        return monitorRepository.findById(id);
    }

    @Override
    public Optional<HardDisk> findHardDiskById(Long id) {
        return hardDiskRepository.findById(id);
    }

    @Override
    public Optional<Laptop> findLaptopById(Long id) {
        return laptopRepository.findById(id);
    }

    @Override
    public Optional<PC> findPCById(Long id) {
        return pcRepository.findById(id);
    }
}
