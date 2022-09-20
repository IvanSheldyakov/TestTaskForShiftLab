package com.example.computerhardwarestore.service.impl;

import com.example.computerhardwarestore.exceptions.EntityNotFoundException;
import com.example.computerhardwarestore.repository.HardDiskRepository;
import com.example.computerhardwarestore.repository.LaptopRepository;
import com.example.computerhardwarestore.repository.MonitorRepository;
import com.example.computerhardwarestore.repository.PCRepository;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;
import com.example.computerhardwarestore.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


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
    public Monitor deleteMonitorById(Long id) {
        return deleteGood(monitorRepository,id);
    }

    @Override
    public Laptop deleteLaptopById(Long id) {
        return deleteGood(laptopRepository,id);
    }

    @Override
    public PC deletePCById(Long id) {
        return deleteGood(pcRepository,id);
    }

    @Override
    public HardDisk deleteHardDiskById(Long id) {
        return deleteGood(hardDiskRepository,id);
    }
    private <T> T deleteGood(JpaRepository<T, Long> repository, Long id) {
        Optional<T> optional = repository.findById(id);
        if (optional.isPresent()) {
            T good = optional.get();
            repository.deleteById(id);
            return good;
        } else {
            String entityNotFoundExceptionMessage = "no good with id %d";
            throw new EntityNotFoundException(String.format(entityNotFoundExceptionMessage, id));
        }
    }


}
