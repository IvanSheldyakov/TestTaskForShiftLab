package com.example.computerhardwarestore.controllers;

import com.example.computerhardwarestore.controller.AddController;
import com.example.computerhardwarestore.dto.HardDiskProperties;
import com.example.computerhardwarestore.dto.LaptopProperties;
import com.example.computerhardwarestore.dto.MonitorProperties;
import com.example.computerhardwarestore.dto.PCProperties;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;
import com.example.computerhardwarestore.repository.domain.possiblevalues.PCFormFactorType;
import com.example.computerhardwarestore.repository.mappers.HardDiskPropertiesMapper;
import com.example.computerhardwarestore.repository.mappers.LaptopPropertiesMapper;
import com.example.computerhardwarestore.repository.mappers.MonitorPropertiesMapper;
import com.example.computerhardwarestore.repository.mappers.PCPropertiesMapper;
import com.example.computerhardwarestore.service.AddService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AddControllerTest {

    @Mock
    private AddService addService;
    @Mock
    private MonitorPropertiesMapper monitorPropertiesMapper;
    @Mock
    private LaptopPropertiesMapper laptopPropertiesMapper;
    @Mock
    private HardDiskPropertiesMapper hardDiskPropertiesMapper;
    @Mock
    private PCPropertiesMapper pcPropertiesMapper;

    @InjectMocks
    private AddController addController;

    @Autowired
    private MockMvc mockMvc;

    private PC pc;
    private Laptop laptop;
    private HardDisk hardDisk;
    private Monitor monitor;

    private PCProperties pcProperties;
    private LaptopProperties laptopProperties;
    private HardDiskProperties hardDiskProperties;
    private MonitorProperties monitorProperties;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(addController).build();


        pcProperties = new PCProperties(GoodType.PC, "34235GHJK",
                "asus", 1000D, 10L, PCFormFactorType.DESKTOP);
        pc = new PC(1L, GoodType.PC, "34235GHJK",
                "asus", 1000, 10L, PCFormFactorType.DESKTOP);

        laptopProperties = new LaptopProperties(GoodType.LAPTOP, "HKKH35GHJK",
                "tech", 1010D, 10L, LaptopSize.SEVENTEEN);
        laptop = new Laptop(2L, GoodType.LAPTOP, "HKKH35GHJK",
                "tech", 1010, 10L, LaptopSize.SEVENTEEN);

        hardDiskProperties = new HardDiskProperties(GoodType.HARD_DISK, "HAAAAA5GHJK",
                "tech", 1010D, 10L, 1024D);
        hardDisk = new HardDisk(3L, GoodType.HARD_DISK, "HAAAAA5GHJK",
                "tech", 1010, 10L, 1024);

        monitorProperties = new MonitorProperties(GoodType.MONITOR, "3HKHKHKHKHK",
                "asus", 1000D, 10L, 24.5);
        monitor = new Monitor(4L, GoodType.MONITOR, "3HKHKHKHKHK",
                "asus", 1000, 10L, 24.5);
    }

    @AfterEach
    void tearDown() {
        pc = null;
        pcProperties = null;
        laptop = null;
        laptopProperties = null;
        hardDisk = null;
        hardDiskProperties = null;
        monitor = null;
        monitorProperties = null;
    }

    @Test
    public void postMappingOfPC() throws Exception {
        when(addService.add(pc)).thenReturn(pc);
        when(pcPropertiesMapper.map(any())).thenReturn(pc);
        mockMvc.perform(post("/api/add/pc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pcProperties)))
                .andExpect(status().isCreated());
        verify(addService, times(1)).add(pc);
    }

    @Test
    public void postMappingOfLaptop() throws Exception {
        when(addService.add(laptop)).thenReturn(laptop);
        when(laptopPropertiesMapper.map(any())).thenReturn(laptop);
        mockMvc.perform(post("/api/add/laptop")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(laptopProperties)))
                .andExpect(status().isCreated());
        verify(addService, times(1)).add(laptop);
    }

    @Test
    public void postMappingOfHardDisk() throws Exception {
        when(addService.add(hardDisk)).thenReturn(hardDisk);
        when(hardDiskPropertiesMapper.map(any())).thenReturn(hardDisk);
        mockMvc.perform(post("/api/add/harddisk")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(hardDiskProperties)))
                .andExpect(status().isCreated());
        verify(addService, times(1)).add(hardDisk);
    }

    @Test
    public void postMappingOfMonitor() throws Exception {
        when(addService.add(monitor)).thenReturn(monitor);
        when(monitorPropertiesMapper.map(any())).thenReturn(monitor);
        mockMvc.perform(post("/api/add/monitor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(monitorProperties)))
                .andExpect(status().isCreated());
        verify(addService, times(1)).add(monitor);
    }
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
