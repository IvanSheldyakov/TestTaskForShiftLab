package com.example.computerhardwarestore.service.impl;


import com.example.computerhardwarestore.repository.HardDiskRepository;
import com.example.computerhardwarestore.repository.LaptopRepository;
import com.example.computerhardwarestore.repository.MonitorRepository;
import com.example.computerhardwarestore.repository.PCRepository;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.PC;

import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UpdateServiceImpl implements UpdateService {

    private HardDiskRepository hardDiskRepository;
    private LaptopRepository laptopRepository;
    private MonitorRepository monitorRepository;
    private PCRepository pcRepository;

    @Autowired
    public UpdateServiceImpl(HardDiskRepository hardDiskRepository,
                             LaptopRepository laptopRepository,
                             MonitorRepository monitorRepository,
                             PCRepository pcRepository) {
        this.hardDiskRepository = hardDiskRepository;
        this.laptopRepository = laptopRepository;
        this.monitorRepository = monitorRepository;
        this.pcRepository = pcRepository;
    }

    @Override
    public Monitor update(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    @Override
    public PC update(PC pc) {
        return pcRepository.save(pc);
    }

    @Override
    public HardDisk update(HardDisk hardDisk) {
        return hardDiskRepository.save(hardDisk);
    }

    @Override
    public Laptop update(Laptop laptop) {
        return laptopRepository.save(laptop);
    }
}
