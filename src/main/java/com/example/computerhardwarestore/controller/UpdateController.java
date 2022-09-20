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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api
@RestController
@Tag(name = "Updating API", description = "REST API for updating goods")
@RequestMapping("app/update")
@Log4j2
public class UpdateController {

    private UpdateService updateService;
    private SearchService searchService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public UpdateController(UpdateService updateService, SearchService searchService) {
        this.updateService = updateService;
        this.searchService = searchService;
    }


    @Operation(summary = "Allow to update monitor",tags = "Updating API")
    @ApiResponse(
            responseCode = "200",
            description = "Update the monitor",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Monitor.class))
            }
    )
    @PatchMapping(value = "/monitor", consumes = "application/json-patch+json")
    public ResponseEntity<Monitor> updateMonitor(@RequestParam(name = "id") Long id,
                                                 @RequestBody JsonPatch patch) {

        log.debug("'updateMonitor' request with id " + id + " and json patch " + patch);

        Optional<Monitor> monitorOptional = searchService.findMonitorById(id);
        if (monitorOptional.isPresent()) {
            Monitor monitor = applyPatch(patch, monitorOptional.get(),Monitor.class);
            updateService.update(monitor);

            log.debug("'updateMonitor' response " + monitor);
            return new ResponseEntity<>(monitor, HttpStatus.OK);
        } else {
            log.error("'updateMonitor' response - monitor with id " + id + " not found");
            throw new EntityNotFoundException(String.format("monitor with id %d not found", id));
        }
    }


    @Operation(summary = "Allow to update hard disk",tags = "Updating API")
    @ApiResponse(
            responseCode = "200",
            description = "Update the hard disk",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = HardDisk.class))
            }
    )
    @PatchMapping(value = "/harddisk", consumes = "application/json-patch+json")
    public ResponseEntity<HardDisk> updateHardDisk(@RequestParam(name = "id") Long id,
                                            @RequestBody JsonPatch patch) {

        log.debug("'updateHardDisk' request with id " + id + " and json patch " + patch);

        Optional<HardDisk> hardDiskOptional = searchService.findHardDiskById(id);
        if (hardDiskOptional.isPresent()) {
            HardDisk hardDisk = applyPatch(patch, hardDiskOptional.get(),HardDisk.class);
            updateService.update(hardDisk);

            log.debug("'updateMonitor' response " + hardDisk);
            return new ResponseEntity<>(hardDisk, HttpStatus.OK);
        } else {
            log.error("'updateMonitor' response - hard disk with id " + id + " not found");
            throw new EntityNotFoundException(String.format("hard disk with id %d not found", id));
        }

    }


    @Operation(summary = "Allow to update pc",tags = "Updating API")
    @ApiResponse(
            responseCode = "200",
            description = "Update the pc",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PC.class))
            }
    )
    @PatchMapping(value = "/pc",consumes = "application/json-patch+json")
    public ResponseEntity<PC> updatePC(@RequestParam(name = "id") Long id,
                                       @RequestBody JsonPatch patch) {

        log.debug("'updatePC' request with id " + id + " and json patch " + patch);

        Optional<PC> pcOptional = searchService.findPCById(id);
        if (pcOptional.isPresent()) {
            PC pc = applyPatch(patch, pcOptional.get(),PC.class);
            updateService.update(pc);

            log.debug("'updatePC' response " + pc);
            return new ResponseEntity<>(pc, HttpStatus.OK);
        } else {
            log.error("'updatePC' response - pc with id " + id + " not found");
            throw new EntityNotFoundException(String.format("pc with id %d not found", id));
        }
    }


    @Operation(summary = "Allow to update laptop",tags = "Updating API")
    @ApiResponse(
            responseCode = "200",
            description = "Update the laptop",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Laptop.class))
            }
    )
    @PatchMapping(value = "/laptop",consumes = "application/json-patch+json")
    public ResponseEntity<Laptop> updateLaptop(@RequestParam(name = "id") Long id,
                                               @RequestBody JsonPatch patch) {

        log.debug("'updateLaptop' request with id " + id + " and json patch " + patch);

        Optional<Laptop> laptopOptional = searchService.findLaptopById(id);
        if (laptopOptional.isPresent()) {
            Laptop laptop = applyPatch(patch, laptopOptional.get(),Laptop.class);
            updateService.update(laptop);

            log.debug("'updateLaptop' response " + laptop);
            return new ResponseEntity<>(laptop, HttpStatus.OK);
        } else {
            log.error("'updateLaptop' response - laptop with id " + id + " not found");
            throw new EntityNotFoundException(String.format("laptop with id %d not found", id));
        }
    }

    private <T> T applyPatch(JsonPatch patch, T target, Class<T> clazz) {
        try {
            JsonNode patched = patch.apply(objectMapper.convertValue(target, JsonNode.class));
            return objectMapper.treeToValue(patched, clazz);
        } catch (Exception e) {
            log.error("cant apply patch " + patch);
            throw new JsonProcessingException(e);
        }
    }
}
