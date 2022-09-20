package com.example.computerhardwarestore.controllers;


import com.example.computerhardwarestore.controller.UpdateController;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;
import com.example.computerhardwarestore.repository.domain.possiblevalues.PCFormFactorType;
import com.example.computerhardwarestore.service.SearchService;
import com.example.computerhardwarestore.service.UpdateService;
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

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

@ExtendWith(MockitoExtension.class)
public class UpdateControllerTest {
    @Mock
    private UpdateService updateService;
    @Mock
    private SearchService searchService;

    @InjectMocks
    private UpdateController updateController;

    @Autowired
    private MockMvc mockMvc;


    private PC pc;
    private Laptop laptop;
    private HardDisk hardDisk;
    private Monitor monitor;

    private String updatePCFormFactor = "[{\n" +
            "    \"op\":\"replace\",\n" +
            "    \"path\":\"/form_factor\",\n" +
            "    \"value\":\"NETTOP\"\n" +
            "}]";

    private String updatePriceAndManufacturer = "[{\n" +
            "    \"op\":\"replace\",\n" +
            "    \"path\":\"/price\",\n" +
            "    \"value\":\"1233\"\n" +
            "},\n" +
            "{\n" +
            "    \"op\":\"replace\",\n" +
            "    \"path\":\"/manufacturer\",\n" +
            "    \"value\":\"tech\"\n" +
            "}]";

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(updateController).build();

        pc = new PC(1L, GoodType.PC, "34235GHJK",
                "asus", 1000, 10L, PCFormFactorType.DESKTOP);

        laptop = new Laptop(2L, GoodType.LAPTOP,"HKKH35GHJK",
                "tech",1010,10L, LaptopSize.SEVENTEEN);

        hardDisk = new HardDisk(3L, GoodType.HARD_DISK, "HAAAAA5GHJK",
                "tech", 1010, 10L, 1024);
        monitor = new Monitor(4L, GoodType.MONITOR, "3HKHKHKHKHK",
                "asus", 1000, 10L, 24.5);
    }

    @AfterEach
    public void tearDown() {
        pc = null;
        laptop = null;
        hardDisk = null;
        monitor = null;
    }

    @Test
    public void PatchPCByIdShouldReturnUpdatedPC() throws Exception{
        when(searchService.findPCById(pc.getId())).thenReturn(Optional.ofNullable(pc));
        mockMvc.perform(patch("/app/update/pc")
                        .param("id", Long.toString(pc.getId()))
                        .contentType("application/json-patch+json")
                        .content(updatePCFormFactor))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void PatchLaptopByIdShouldReturnUpdatedLaptop() throws Exception{
        when(searchService.findLaptopById(laptop.getId())).thenReturn(Optional.ofNullable(laptop));
        mockMvc.perform(patch("/app/update/laptop")
                        .param("id", Long.toString(laptop.getId()))
                        .contentType("application/json-patch+json")
                        .content(updatePriceAndManufacturer))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void PatchMonitorByIdShouldReturnUpdatedMonitor() throws Exception{
        when(searchService.findMonitorById(monitor.getId())).thenReturn(Optional.ofNullable(monitor));
        mockMvc.perform(patch("/app/update/monitor")
                        .param("id", Long.toString(monitor.getId()))
                        .contentType("application/json-patch+json")
                        .content(updatePriceAndManufacturer))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void PatchHardDiskByIdShouldReturnUpdatedHardDisk() throws Exception{
        when(searchService.findHardDiskById(hardDisk.getId())).thenReturn(Optional.ofNullable(hardDisk));
        mockMvc.perform(patch("/app/update/harddisk")
                        .param("id", Long.toString(hardDisk.getId()))
                        .contentType("application/json-patch+json")
                        .content(updatePriceAndManufacturer))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
