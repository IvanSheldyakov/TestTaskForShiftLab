package com.example.computerhardwarestore.service.impl;

import com.example.computerhardwarestore.controller.UpdateController;
import com.example.computerhardwarestore.exceptions.IllegalPropertiesException;
import com.example.computerhardwarestore.repository.*;
import com.example.computerhardwarestore.repository.domain.*;
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
    private HardDiskRepository hardDiskRepository;
    private LaptopRepository laptopRepository;
    private MonitorRepository monitorRepository;
    private PCRepository pcRepository;

    private ValidatorFactory factory;
    private Validator validator;

    @Autowired
    public AddServiceImpl(HardDiskRepository hardDiskRepository,
                          LaptopRepository laptopRepository,
                          MonitorRepository monitorRepository,
                          PCRepository pcRepository) {
        this.hardDiskRepository = hardDiskRepository;
        this.laptopRepository = laptopRepository;
        this.monitorRepository = monitorRepository;
        this.pcRepository = pcRepository;
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Override
    public HardDisk add(HardDisk hardDisk) {
        validate(hardDisk);
        return hardDiskRepository.save(hardDisk);
    }

    @Override
    public Laptop add(Laptop laptop) {
        validate(laptop);
        return laptopRepository.save(laptop);
    }

    @Override
    public Monitor add(Monitor monitor) {
        validate(monitor);
        return monitorRepository.save(monitor);
    }

    @Override
    public PC add(PC pc) {
        validate(pc);
        return pcRepository.save(pc);
    }

    private <T> void validate(T entity){
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
}
