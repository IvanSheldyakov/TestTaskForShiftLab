package com.example.computerhardwarestore.controller;


import com.example.computerhardwarestore.exceptions.EntityNotFoundException;
import com.example.computerhardwarestore.model.GoodsList;
import com.example.computerhardwarestore.repository.domain.GoodEntity;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.service.SearchService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Api
@RestController
@Tag(name = "Adding API", description = "REST API for searching goods")
@RequestMapping("/api/goods/search")
@Log4j2
public class GoodsSearchController {

    private SearchService searchService;

    @Autowired
    public GoodsSearchController(SearchService goodService) {
        this.searchService = goodService;
    }


    @Operation(summary = "Allow to search good by id",tags = "Searching API")
    @ApiResponse(
            responseCode = "200",
            description = "Search the good",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GoodEntity.class))}
    )
    @GetMapping("/by/id")
    public ResponseEntity<GoodEntity> getById(@RequestParam(name = "id") Long id) {

        log.debug("'getById' request with id " + id);

        Optional<GoodEntity> entityOptional = searchService.findGoodById(id);

        if (entityOptional.isPresent()) {

            GoodEntity good = entityOptional.get();

            log.debug("'getById' response " + good);
            return new ResponseEntity<>(good,HttpStatus.OK);
        } else {
            log.error("'getById' response - good with id " + id + " not found");
            throw new EntityNotFoundException(String.format("good with id %d not found",id));
        }

    }


    @Operation(summary = "Allow to search goods by type",tags = "Searching API")
    @ApiResponse(
            responseCode = "200",
            description = "Search goods",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GoodsList.class))}
    )
    @GetMapping("/by/type")
    public ResponseEntity<GoodsList> getByType(@RequestParam(name = "type") GoodType type) {

        log.debug("'getByType' request with type " + type);

        List<GoodEntity> entities = searchService.findAllByType(type);
        GoodsList goods = new GoodsList();
        goods.setGoodEntities(entities);

        log.debug("'getByType' response " + goods);
        return new ResponseEntity<>(goods,HttpStatus.OK);
    }
}
