package com.example.computerhardwarestore.service.impl;

import com.example.computerhardwarestore.exceptions.GoodAlreadyExistsException;
import com.example.computerhardwarestore.exceptions.IllegalPropertiesException;
import com.example.computerhardwarestore.repository.*;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;
import com.example.computerhardwarestore.service.AddService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


@Service
public class AddServiceImpl implements AddService {

    private static Logger logger = LoggerFactory.getLogger(AddServiceImpl.class);
    private final HardDiskRepository hardDiskRepository;
    private final LaptopRepository laptopRepository;
    private final MonitorRepository monitorRepository;
    private final PCRepository pcRepository;

    private final GoodRepository goodRepository;
    private final Validator validator;



    @Autowired
    public AddServiceImpl(HardDiskRepository hardDiskRepository,
                          LaptopRepository laptopRepository,
                          MonitorRepository monitorRepository,
                          PCRepository pcRepository,
                          GoodRepository goodRepository) {
        this.hardDiskRepository = hardDiskRepository;
        this.laptopRepository = laptopRepository;
        this.monitorRepository = monitorRepository;
        this.pcRepository = pcRepository;
        this.goodRepository = goodRepository;

        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }


    @Override
    public HardDisk add(HardDisk hardDisk) {
        validateFields(hardDisk);
        validateExistenceBySerialNumber(hardDisk.getSerialNumber());
        return hardDiskRepository.save(hardDisk);
    }

    @Override
    public Laptop add(Laptop laptop) {
        validateFields(laptop);
        validateExistenceBySerialNumber(laptop.getSerialNumber());
        return laptopRepository.save(laptop);
    }

    @Override
    public Monitor add(Monitor monitor) {
        validateFields(monitor);
        validateExistenceBySerialNumber(monitor.getSerialNumber());
        return monitorRepository.save(monitor);
    }

    @Override
    public PC add(PC pc) {
        validateFields(pc);
        validateExistenceBySerialNumber(pc.getSerialNumber());
        return pcRepository.save(pc);
    }

    private <T> void validateFields(T entity){
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        StringBuilder stringBuilder = new StringBuilder();
        for (var violation : violations) {
            stringBuilder.append(violation.getMessage()).append(", ");
        }
        if (!stringBuilder.isEmpty()) {
            logger.error("'add service' illegal properties");
            throw new IllegalPropertiesException(stringBuilder.toString());
        }
    }

    private void validateExistenceBySerialNumber(String serialNumber) {
        if (goodRepository.existsGoodEntityBySerialNumber(serialNumber)) {
            throw new GoodAlreadyExistsException("such good is already existed");
        }
    }


}
