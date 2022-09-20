package com.example.computerhardwarestore.controller;

import com.example.computerhardwarestore.repository.domain.*;
import com.example.computerhardwarestore.service.DeleteService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@Tag(name = "Deleting API", description = "REST API for deleting goods")
@RequestMapping("api/delete")
@Log4j2
public class DeleteController {

    private DeleteService deleteService;

    @Autowired
    public DeleteController(DeleteService deleteService) {
        this.deleteService = deleteService;
    }


    @Operation(summary = "Allow to delete monitor",tags = "Deleting API")
    @ApiResponse(
            responseCode = "200",
            description = "Delete the monitor",
            content = {
                    @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Monitor.class))}
    )
    @DeleteMapping("/monitor")
    public ResponseEntity<Monitor> deleteMonitor(@RequestParam(name = "id") Long id) {

        log.debug("'deleteMonitor' request with id " + id);

        Monitor monitor = deleteService.deleteMonitorById(id);

        log.debug("'deleteMonitor' response " + monitor);
        return new ResponseEntity<>(monitor,HttpStatus.OK);
    }


    @Operation(summary = "Allow to delete hard disk",tags = "Deleting API")
    @ApiResponse(
            responseCode = "200",
            description = "Delete the hard disk",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = HardDisk.class))}
    )
    @DeleteMapping("/harddisk")
    public ResponseEntity<HardDisk> deleteHardDisk(@RequestParam(name = "id") Long id) {

        log.debug("'deleteHardDisk' request with id " + id);

        HardDisk hardDisk = deleteService.deleteHardDiskById(id);

        log.debug("'deleteHardDisk' response " + hardDisk);
        return new ResponseEntity<>(hardDisk,HttpStatus.OK);
    }


    @Operation(summary = "Allow to delete pc",tags = "Deleting API")
    @ApiResponse(
            responseCode = "200",
            description = "Delete the pc",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PC.class))}

    )
    @DeleteMapping("/pc")
    public ResponseEntity<PC> deletePC(@RequestParam(name = "id") Long id) {

        log.debug("'deletePC' request with id " + id);

        PC pc = deleteService.deletePCById(id);

        log.debug("'deletePC' response " + pc);
        return new ResponseEntity<>(pc,HttpStatus.OK);
    }


    @Operation(summary = "Allow to delete laptop",tags = "Deleting API")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Delete the laptop",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Laptop.class))}
            )
    })
    @DeleteMapping("/laptop")
    public ResponseEntity<Laptop> deleteLaptop(@RequestParam(name = "id") Long id) {

        log.debug("'deleteLaptop' request with id " + id);

        Laptop laptop = deleteService.deleteLaptopById(id);

        log.debug("'deleteLaptop' response " + laptop);
        return new ResponseEntity<>(laptop,HttpStatus.OK);
    }

}
