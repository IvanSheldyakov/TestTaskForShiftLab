package com.example.computerhardwarestore.model;

import com.example.computerhardwarestore.repository.domain.GoodEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GoodsList {

    @JsonProperty("goods")
    private List<GoodEntity> goodEntities;



}
