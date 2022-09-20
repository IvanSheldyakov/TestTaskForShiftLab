package com.example.computerhardwarestore.controllers;

import com.example.computerhardwarestore.controller.GoodsSearchController;
import com.example.computerhardwarestore.repository.domain.GoodEntity;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;
import com.example.computerhardwarestore.service.SearchService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
public class GoodsSearchControllerTest {

    @Mock
    private SearchService goodsSearchService;

    @InjectMocks
    private GoodsSearchController searchController;

    @Autowired
    private MockMvc mockMvc;


    private GoodEntity laptop1;
    private GoodEntity laptop2;

    private List<GoodEntity> laptopsList;
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();

        laptop1 = new Laptop(1L, GoodType.LAPTOP, "2342342",
                "lg", 234.34, 34L, LaptopSize.FOURTEEN);
        laptop2 = new Laptop(2L, GoodType.LAPTOP, "234JKJLJ2342",
                "sam", 287, 1L, LaptopSize.FIFTEEN);
        laptopsList = new ArrayList<>();
        laptopsList.add(laptop1);
        laptopsList.add(laptop2);
    }

    @AfterEach
    public void tearDown() {
        laptop1 = laptop2 = null;
        laptopsList = null;
    }
    @Test
    public void GetByIdOfGoodShouldReturnRespectiveGood() throws Exception {
        when(goodsSearchService.findGoodById(laptop1.getId())).thenReturn(Optional.ofNullable(laptop1));
        mockMvc.perform(get("/api/goods/search/by/id").
                        param("id",Long.toString(laptop1.getId()))).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void GetByTypeOfGoodsShouldReturnRespectiveGoods() throws Exception {
        when(goodsSearchService.findAllByType(GoodType.LAPTOP)).thenReturn(laptopsList);
        mockMvc.perform(get("/api/goods/search/by/type").
                        param("type",GoodType.LAPTOP.toString())).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andDo(MockMvcResultHandlers.print());
    }
}
