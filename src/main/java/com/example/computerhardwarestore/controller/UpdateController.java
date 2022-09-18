package com.example.computerhardwarestore.controller;

import com.example.computerhardwarestore.exceptions.EntityNotFoundException;
import com.example.computerhardwarestore.exceptions.JsonProcessingException;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;
import com.example.computerhardwarestore.service.SearchService;
import com.example.computerhardwarestore.service.UpdateService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;


import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("app/update")
@Api
public class UpdateController {

    private static Logger logger = LoggerFactory.getLogger(UpdateController.class);
    private UpdateService updateService;
    private SearchService searchService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public UpdateController(UpdateService updateService, SearchService searchService) {
        this.updateService = updateService;
        this.searchService = searchService;
    }

    @PatchMapping(value = "/monitor", consumes = "application/json-patch+json")
    public ResponseEntity<Monitor> updateMonitor(@RequestParam(name = "id") Long id,
                                                 @RequestBody JsonPatch patch) {

        logger.debug("'updateMonitor' request with id " + id + " and json patch " + patch);

        Optional<Monitor> monitorOptional = searchService.findMonitorById(id);
        if (monitorOptional.isPresent()) {
            Monitor monitor = applyPatchToMonitor(patch, monitorOptional.get());
            updateService.update(monitor);

            logger.debug("'updateMonitor' response " + monitor);
            return new ResponseEntity<>(monitor, HttpStatus.OK);
        } else {
            logger.error("'updateMonitor' response - monitor with id " + id + " not found");
            throw new EntityNotFoundException(String.format("monitor with id %d not found", id));
        }
    }

    private Monitor applyPatchToMonitor(JsonPatch patch, Monitor targetMonitor) {
        try {
            JsonNode patched = patch.apply(objectMapper.convertValue(targetMonitor, JsonNode.class));
            return objectMapper.treeToValue(patched, Monitor.class);
        } catch (Exception e) {
            logger.error("'applyPatchToMonitor' cant apply patch " + patch);
            throw new JsonProcessingException(e);
        }

    }

    @PatchMapping(value = "/harddisk", consumes = "application/json-patch+json")
    public ResponseEntity<?> updateHardDisk(@RequestParam(name = "id") Long id,
                                            @RequestBody JsonPatch patch) {

        logger.debug("'updateHardDisk' request with id " + id + " and json patch " + patch);

        Optional<HardDisk> hardDiskOptional = searchService.findHardDiskById(id);
        if (hardDiskOptional.isPresent()) {
            HardDisk hardDisk = applyPatchToHardDisk(patch, hardDiskOptional.get());
            updateService.update(hardDisk);

            logger.debug("'updateMonitor' response " + hardDisk);
            return new ResponseEntity<>(hardDisk, HttpStatus.OK);
        } else {
            logger.error("'updateMonitor' response - hard disk with id " + id + " not found");
            throw new EntityNotFoundException(String.format("hard disk with id %d not found", id));
        }

    }

    private HardDisk applyPatchToHardDisk(JsonPatch patch, HardDisk targetHardDisk) {
        try {
            JsonNode patched = patch.apply(objectMapper.convertValue(targetHardDisk, JsonNode.class));
            return objectMapper.treeToValue(patched, HardDisk.class);
        } catch (Exception e) {
            logger.error("'applyPatchToHardDisk' cant apply patch " + patch);
            throw new JsonProcessingException(e);
        }

    }

    @PatchMapping(value = "/pc",consumes = "application/json-patch+json")
    public ResponseEntity<PC> updatePC(@RequestParam(name = "id") Long id,
                                       @RequestBody JsonPatch patch) {

        logger.debug("'updatePC' request with id " + id + " and json patch " + patch);

        Optional<PC> pcOptional = searchService.findPCById(id);
        if (pcOptional.isPresent()) {
            PC pc = applyPatchToPC(patch, pcOptional.get());
            updateService.update(pc);

            logger.debug("'updatePC' response " + pc);
            return new ResponseEntity<>(pc, HttpStatus.OK);
        } else {
            logger.error("'updatePC' response - pc with id " + id + " not found");
            throw new EntityNotFoundException(String.format("pc with id %d not found", id));
        }
    }

    private PC applyPatchToPC(JsonPatch patch, PC targetPC) {
        try {
            JsonNode patched = patch.apply(objectMapper.convertValue(targetPC, JsonNode.class));
            return objectMapper.treeToValue(patched, PC.class);
        } catch (Exception e) {
            logger.error("'applyPatchToPC' cant apply patch " + patch);
            throw new JsonProcessingException(e);
        }

    }

    @PatchMapping(value = "/laptop",consumes = "application/json-patch+json")
    public ResponseEntity<Laptop> updateLaptop(@RequestParam(name = "id") Long id,
                                               @RequestBody JsonPatch patch) {

        logger.debug("'updateLaptop' request with id " + id + " and json patch " + patch);

        Optional<Laptop> laptopOptional = searchService.findLaptopById(id);
        if (laptopOptional.isPresent()) {
            Laptop laptop = applyPatchToLaptop(patch, laptopOptional.get());
            updateService.update(laptop);

            logger.debug("'updateLaptop' response " + laptop);
            return new ResponseEntity<>(laptop, HttpStatus.OK);
        } else {
            logger.error("'updateLaptop' response - laptop with id " + id + " not found");
            throw new EntityNotFoundException(String.format("laptop with id %d not found", id));
        }
    }

    private Laptop applyPatchToLaptop(JsonPatch patch, Laptop targetLaptop) {
        try {
            JsonNode patched = patch.apply(objectMapper.convertValue(targetLaptop, JsonNode.class));
            return objectMapper.treeToValue(patched, Laptop.class);
        } catch (Exception e) {
            logger.error("'applyPatchToLaptop' cant apply patch " + patch);
            throw new JsonProcessingException(e);
        }

    }

}
