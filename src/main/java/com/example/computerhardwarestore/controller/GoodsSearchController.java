package com.example.computerhardwarestore.controller;


import com.example.computerhardwarestore.exceptions.EntityNotFoundException;
import com.example.computerhardwarestore.model.GoodsList;
import com.example.computerhardwarestore.repository.domain.GoodEntity;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.service.SearchService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/goods/search")
@Api
public class GoodsSearchController {

    private static Logger logger = LoggerFactory.getLogger(GoodsSearchController.class);
    private SearchService searchService;

    @Autowired
    public GoodsSearchController(SearchService goodService) {
        this.searchService = goodService;
    }

    @GetMapping("/by/id")
    public ResponseEntity<GoodEntity> getById(@RequestParam(name = "id") Long id) {

        logger.debug("'getById' request with id " + id);

        Optional<GoodEntity> entityOptional = searchService.findGoodById(id);

        if (entityOptional.isPresent()) {

            GoodEntity good = entityOptional.get();

            logger.debug("'getById' response " + good);
            return new ResponseEntity<>(good,HttpStatus.OK);
        } else {
            logger.error("'getById' response - good with id " + id + " not found");
            throw new EntityNotFoundException(String.format("good with id %d not found",id));
        }

    }

    @GetMapping("/by/type")
    public ResponseEntity<GoodsList> getByType(@RequestParam(name = "type") GoodType type) {

        logger.debug("'getByType' request with type " + type);

        List<GoodEntity> entities = searchService.findAllByType(type);
        GoodsList goods = new GoodsList();
        goods.setGoodEntities(entities);

        logger.debug("'getByType' response " + goods);
        return new ResponseEntity<>(goods,HttpStatus.OK);
    }
}
