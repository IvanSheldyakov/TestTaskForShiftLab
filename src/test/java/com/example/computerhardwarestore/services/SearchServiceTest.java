package com.example.computerhardwarestore.services;

import com.example.computerhardwarestore.repository.*;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;
import com.example.computerhardwarestore.repository.domain.possiblevalues.PCFormFactorType;
import com.example.computerhardwarestore.service.impl.SearchServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private HardDiskRepository hardDiskRepository;
    @Mock
    private LaptopRepository laptopRepository;
    @Mock
    private MonitorRepository monitorRepository;
    @Mock
    private PCRepository pcRepository;
    @Mock
    private GoodRepository goodRepository;

    @Autowired
    @InjectMocks
    private SearchServiceImpl searchService;

    private PC pc;

    private Laptop laptop;

    private HardDisk hardDisk;
    private Monitor monitor;

    @BeforeEach
    public void setUp() {
        pc = new PC(1L, GoodType.PC,"34235GHJK",
                "asus",1000,10L, PCFormFactorType.DESKTOP);
        laptop = new Laptop(2L, GoodType.HARD_DISK,"HKKH35GHJK",
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
    public void givenIdThenShouldReturnPCOfThatId() {
        when(pcRepository.findById(pc.getId())).thenReturn(Optional.ofNullable(pc));
        assertThat(searchService.findPCById(pc.getId()).get()).isEqualTo(pc);
    }

    @Test
    public void givenIdThenShouldReturnLaptopOfThatId() {
        when(laptopRepository.findById(laptop.getId())).thenReturn(Optional.ofNullable(laptop));
        assertThat(searchService.findLaptopById(laptop.getId()).get()).isEqualTo(laptop);
    }

    @Test
    public void givenIdThenShouldReturnMonitorOfThatId() {
        when(monitorRepository.findById(monitor.getId())).thenReturn(Optional.ofNullable(monitor));
        assertThat(searchService.findMonitorById(monitor.getId()).get()).isEqualTo(monitor);
    }

    @Test
    public void givenIdThenShouldReturnHardDiskOfThatId() {
        when(hardDiskRepository.findById(hardDisk.getId())).thenReturn(Optional.ofNullable(hardDisk));
        assertThat(searchService.findHardDiskById(hardDisk.getId()).get()).isEqualTo(hardDisk);
    }

}//TODO
