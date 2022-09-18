package com.example.computerhardwarestore.controller;

import com.example.computerhardwarestore.service.DeleteService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
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
            description = "Delete monitor"
    )
    @DeleteMapping("/monitor")
    public ResponseEntity<?> deleteMonitor(@RequestParam(name = "id") Long id) {

        log.debug("'deleteMonitor' request with id " + id);

        deleteService.deleteMonitorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Allow to delete hard disk",tags = "Deleting API")
    @ApiResponse(
            responseCode = "200",
            description = "Delete hard disk"
    )
    @DeleteMapping("/harddisk")
    public ResponseEntity<?> deleteHardDisk(@RequestParam(name = "id") Long id) {

        log.debug("'deleteHardDisk' request with id " + id);

        deleteService.deleteHardDisk(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Allow to delete pc",tags = "Deleting API")
    @ApiResponse(
            responseCode = "200",
            description = "Delete pc"
    )
    @DeleteMapping("/pc")
    public ResponseEntity<?> deletePC(@RequestParam(name = "id") Long id) {

        log.debug("'deletePC' request with id " + id);

        deleteService.deletePCById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Allow to delete laptop",tags = "Deleting API")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Delete laptop"
            )
    })
    @DeleteMapping("/laptop")
    public ResponseEntity<?> deleteLaptop(@RequestParam(name = "id") Long id) {

        log.debug("'deleteLaptop' request with id " + id);

        deleteService.deleteLaptopById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
