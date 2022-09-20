package com.example.computerhardwarestore.controllers;

import com.example.computerhardwarestore.controller.DeleteController;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;
import com.example.computerhardwarestore.repository.domain.possiblevalues.PCFormFactorType;
import com.example.computerhardwarestore.service.DeleteService;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class DeleteControllerTest {

    @Mock
    private DeleteService deleteService;

    @InjectMocks
    private DeleteController deleteController;

    @Autowired
    private MockMvc mockMvc;


    private PC pc;
    private Laptop laptop;
    private HardDisk hardDisk;
    private Monitor monitor;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(deleteController).build();

        pc = new PC(1L, GoodType.PC,"34235GHJK",
                "asus",1000,10L, PCFormFactorType.DESKTOP);
        laptop = new Laptop(2L, GoodType.LAPTOP,"HKKH35GHJK",
                "tech",1010,10L, LaptopSize.SEVENTEEN);
        hardDisk = new HardDisk(3L, GoodType.HARD_DISK,"HAAAAA5GHJK",
                "tech",1010,10L, 1024);
        monitor = new Monitor(4L, GoodType.MONITOR,"3HKHKHKHKHK",
                "asus",1000,10L, 24.5);
    }

    @AfterEach
    public void tearDown() {
        pc = null;
        laptop = null;
        hardDisk = null;
        monitor = null;
    }

    @Test
    public void DeleteByIdThenShouldReturnDeletedPC() throws Exception {
        when(deleteService.deletePCById(pc.getId())).thenReturn(pc);
        mockMvc.perform(delete("/api/delete/pc")
                        .param("id",Long.toString(pc.getId())))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(deleteService, times(1)).deletePCById(pc.getId());
    }

    @Test
    public void DeleteByIdThenShouldReturnDeletedLaptop() throws Exception {
        when(deleteService.deleteLaptopById(laptop.getId())).thenReturn(laptop);
        mockMvc.perform(delete("/api/delete/laptop")
                        .param("id",Long.toString(laptop.getId())))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(deleteService, times(1)).deleteLaptopById(laptop.getId());
    }

    @Test
    public void DeleteByIdThenShouldReturnDeletedHardDisk() throws Exception {
        when(deleteService.deleteHardDiskById(hardDisk.getId())).thenReturn(hardDisk);
        mockMvc.perform(delete("/api/delete/harddisk")
                        .param("id",Long.toString(hardDisk.getId())))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(deleteService, times(1)).deleteHardDiskById(hardDisk.getId());
    }

    @Test
    public void DeleteByIdThenShouldReturnDeletedMonitor() throws Exception {
        when(deleteService.deleteMonitorById(monitor.getId())).thenReturn(monitor);
        mockMvc.perform(delete("/api/delete/monitor")
                        .param("id",Long.toString(monitor.getId())))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(deleteService, times(1)).deleteMonitorById(monitor.getId());
    }
}
