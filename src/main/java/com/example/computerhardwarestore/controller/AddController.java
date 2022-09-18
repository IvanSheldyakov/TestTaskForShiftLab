package com.example.computerhardwarestore.controller;

import com.example.computerhardwarestore.dto.HardDiskProperties;
import com.example.computerhardwarestore.dto.LaptopProperties;
import com.example.computerhardwarestore.dto.MonitorProperties;
import com.example.computerhardwarestore.dto.PCProperties;
import com.example.computerhardwarestore.model.IdMessage;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;
import com.example.computerhardwarestore.repository.mappers.HardDiskPropertiesMapper;
import com.example.computerhardwarestore.repository.mappers.LaptopPropertiesMapper;
import com.example.computerhardwarestore.repository.mappers.MonitorPropertiesMapper;
import com.example.computerhardwarestore.repository.mappers.PCPropertiesMapper;
import com.example.computerhardwarestore.service.AddService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/add")
public class AddController {

    private static Logger logger = LoggerFactory.getLogger(AddController.class);

    private AddService addService;
    private MonitorPropertiesMapper monitorPropertiesMapper;
    private LaptopPropertiesMapper laptopPropertiesMapper;
    private HardDiskPropertiesMapper hardDiskPropertiesMapper;
    private PCPropertiesMapper pcPropertiesMapper;

    @Autowired
    public AddController(AddService addService,
                         MonitorPropertiesMapper monitorPropertiesMapper,
                         LaptopPropertiesMapper laptopPropertiesMapper,
                         HardDiskPropertiesMapper hardDiskPropertiesMapper,
                         PCPropertiesMapper pcPropertiesMapper) {
        this.addService = addService;
        this.monitorPropertiesMapper = monitorPropertiesMapper;
        this.laptopPropertiesMapper = laptopPropertiesMapper;
        this.hardDiskPropertiesMapper = hardDiskPropertiesMapper;
        this.pcPropertiesMapper = pcPropertiesMapper;
    }

    @PostMapping("/monitor")
    public ResponseEntity<IdMessage> addMonitor(@RequestBody MonitorProperties properties) {

        logger.debug("'addMonitor' request with properties " + properties);

        Monitor monitor = addService.add(monitorPropertiesMapper.map(properties));
        IdMessage message = new IdMessage(monitor.getId());

        logger.debug("'addMonitor' response " + message);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PostMapping("/harddisk")
    public ResponseEntity<IdMessage> addHardDisk(@RequestBody HardDiskProperties properties) {

        logger.debug("'addHardDisk' request with properties " + properties);

        HardDisk hardDisk = addService.add(hardDiskPropertiesMapper.map(properties));
        IdMessage message = new IdMessage(hardDisk.getId());

        logger.debug("'addHardDisk' response " + message);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PostMapping("/pc")
    public ResponseEntity<?> addPC(@RequestBody PCProperties properties) {

        logger.debug("'addPC' request with properties " + properties);

        PC pc = addService.add(pcPropertiesMapper.map(properties));
        IdMessage message = new IdMessage(pc.getId());

        logger.debug("'addPC' response " + message);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PostMapping("/laptop")
    public ResponseEntity<?> addLaptop(@RequestBody LaptopProperties properties) {

        logger.debug("'addLaptop' request with properties " + properties);

        Laptop laptop = addService.add(laptopPropertiesMapper.map(properties));
        IdMessage message = new IdMessage(laptop.getId());

        logger.debug("'addLaptop' response " + message);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
