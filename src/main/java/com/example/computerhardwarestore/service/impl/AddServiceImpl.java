package com.example.computerhardwarestore.service.impl;

import com.example.computerhardwarestore.repository.*;
import com.example.computerhardwarestore.repository.domain.*;
import com.example.computerhardwarestore.service.AddService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AddServiceImpl implements AddService {


    private HardDiskRepository hardDiskRepository;
    private LaptopRepository laptopRepository;
    private MonitorRepository monitorRepository;
    private PCRepository pcRepository;

    @Autowired
    public AddServiceImpl(HardDiskRepository hardDiskRepository,
                          LaptopRepository laptopRepository,
                          MonitorRepository monitorRepository,
                          PCRepository pcRepository) {
        this.hardDiskRepository = hardDiskRepository;
        this.laptopRepository = laptopRepository;
        this.monitorRepository = monitorRepository;
        this.pcRepository = pcRepository;
    }

    @Override
    public HardDisk add(HardDisk hardDisk) {
        return hardDiskRepository.save(hardDisk);
    }

    @Override
    public Laptop add(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public Monitor add(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    @Override
    public PC add(PC pc) {
        return pcRepository.save(pc);
    }
}
