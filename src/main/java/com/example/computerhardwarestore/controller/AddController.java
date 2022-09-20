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
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@Tag(name = "Adding API", description = "REST API for adding new goods")
@RequestMapping("api/add")
@Log4j2
public class AddController {

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


    @Operation(summary = "Allow to add new monitor",tags = "Adding API")
    @ApiResponse(
            responseCode = "201",
            description = "Add new monitor",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = IdMessage.class))}
    )
    @PostMapping("/monitor")
    public ResponseEntity<IdMessage> addMonitor(@RequestBody  MonitorProperties properties) {

        log.debug("'addMonitor' request with properties " + properties);

        Monitor monitor = addService.add(monitorPropertiesMapper.map(properties));
        IdMessage message = new IdMessage(monitor.getId());

        log.debug("'addMonitor' response " + message);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }



    @Operation(summary = "Allow to add new hard disk",tags = "Adding API")
    @ApiResponse(
        responseCode = "201",
        description = "Add new hard disk",
        content = {
                @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = IdMessage.class))}
    )
    @PostMapping("/harddisk")
    public ResponseEntity<IdMessage> addHardDisk(@RequestBody HardDiskProperties properties) {

        log.debug("'addHardDisk' request with properties " + properties);

        HardDisk hardDisk = addService.add(hardDiskPropertiesMapper.map(properties));
        IdMessage message = new IdMessage(hardDisk.getId());

        log.debug("'addHardDisk' response " + message);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }



    @Operation(summary = "Allow to add new pc",tags = "Adding API")
    @ApiResponse(
            responseCode = "201",
            description = "Add new pc",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = IdMessage.class))}
    )
    @PostMapping("/pc")
    public ResponseEntity<?> addPC(@RequestBody PCProperties properties) {

        log.debug("'addPC' request with properties " + properties);

        PC pc = addService.add(pcPropertiesMapper.map(properties));
        IdMessage message = new IdMessage(pc.getId());

        log.debug("'addPC' response " + message);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }



    @Operation(summary = "Allow to add new laptop",tags = "Adding API")
    @ApiResponse(
            responseCode = "201",
            description = "Add new laptop",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = IdMessage.class))}
    )
    @PostMapping("/laptop")
    public ResponseEntity<?> addLaptop(@RequestBody LaptopProperties properties) {

        log.debug("'addLaptop' request with properties " + properties);

        Laptop laptop = addService.add(laptopPropertiesMapper.map(properties));
        IdMessage message = new IdMessage(laptop.getId());

        log.debug("'addLaptop' response " + message);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

}
