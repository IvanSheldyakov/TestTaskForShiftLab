package com.example.computerhardwarestore.controller;

import com.example.computerhardwarestore.service.DeleteService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/delete")
@Api
public class DeleteController {

    private static Logger logger = LoggerFactory.getLogger(DeleteController.class);
    private DeleteService deleteService;

    @Autowired
    public DeleteController(DeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @DeleteMapping("/monitor")
    public ResponseEntity<?> deleteMonitor(@RequestParam(name = "id") Long id) {

        logger.debug("'deleteMonitor' request with id " + id);

        deleteService.deleteMonitorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/harddisk")
    public ResponseEntity<?> deleteHardDisk(@RequestParam(name = "id") Long id) {

        logger.debug("'deleteHardDisk' request with id " + id);

        deleteService.deleteHardDisk(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/pc")
    public ResponseEntity<?> deletePC(@RequestParam(name = "id") Long id) {

        logger.debug("'deletePC' request with id " + id);

        deleteService.deletePCById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/laptop")
    public ResponseEntity<?> deleteLaptop(@RequestParam(name = "id") Long id) {

        logger.debug("'deleteLaptop' request with id " + id);

        deleteService.deleteLaptopById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
