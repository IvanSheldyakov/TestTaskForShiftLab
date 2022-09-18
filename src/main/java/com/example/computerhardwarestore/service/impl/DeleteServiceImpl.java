package com.example.computerhardwarestore.service.impl;

import com.example.computerhardwarestore.repository.LaptopRepository;
import com.example.computerhardwarestore.repository.MonitorRepository;
import com.example.computerhardwarestore.repository.PCRepository;

import com.example.computerhardwarestore.repository.HardDiskRepository;

import com.example.computerhardwarestore.service.DeleteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DeleteServiceImpl implements DeleteService {

    private HardDiskRepository hardDiskRepository;
    private LaptopRepository laptopRepository;
    private MonitorRepository monitorRepository;
    private PCRepository pcRepository;

    @Autowired
    public DeleteServiceImpl(HardDiskRepository hardDiskRepository,
                             LaptopRepository laptopRepository,
                             MonitorRepository monitorRepository,
                             PCRepository pcRepository) {
        this.hardDiskRepository = hardDiskRepository;
        this.laptopRepository = laptopRepository;
        this.monitorRepository = monitorRepository;
        this.pcRepository = pcRepository;
    }

    @Override
    public void deleteMonitorById(Long id) {
        monitorRepository.deleteById(id);
    }

    @Override
    public void deleteLaptopById(Long id) {
        laptopRepository.deleteById(id);
    }

    @Override
    public void deletePCById(Long id) {
        pcRepository.deleteById(id);
    }

    @Override
    public void deleteHardDisk(Long id) {
        hardDiskRepository.deleteById(id);
    }
}
