package com.example.computerhardwarestore.services;


import com.example.computerhardwarestore.repository.HardDiskRepository;
import com.example.computerhardwarestore.repository.LaptopRepository;
import com.example.computerhardwarestore.repository.MonitorRepository;
import com.example.computerhardwarestore.repository.PCRepository;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;
import com.example.computerhardwarestore.repository.domain.possiblevalues.PCFormFactorType;
import com.example.computerhardwarestore.service.impl.DeleteServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteServiceTest {

    @Mock
    private HardDiskRepository hardDiskRepository;
    @Mock
    private LaptopRepository laptopRepository;
    @Mock
    private MonitorRepository monitorRepository;
    @Mock
    private PCRepository pcRepository;

    @Autowired
    @InjectMocks
    private DeleteServiceImpl deleteService;

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
    public void givenIdTODeleteThenShouldDeleteThePC() {

        when(pcRepository.findById(pc.getId())).thenReturn(Optional.ofNullable(pc));
        deleteService.deletePCById(pc.getId());
        verify(pcRepository,times(1)).deleteById(pc.getId());
    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheLaptop() {

        when(laptopRepository.findById(laptop.getId())).thenReturn(Optional.ofNullable(laptop));
        deleteService.deleteLaptopById(laptop.getId());
        verify(laptopRepository,times(1)).deleteById(laptop.getId());
    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheHardDisk(){

        when(hardDiskRepository.findById(hardDisk.getId())).thenReturn(Optional.ofNullable(hardDisk));
        deleteService.deleteHardDisk(hardDisk.getId());
        verify(hardDiskRepository,times(1)).deleteById(hardDisk.getId());
    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheMonitor(){

        when(monitorRepository.findById(monitor.getId())).thenReturn(Optional.ofNullable(monitor));
        deleteService.deleteMonitorById(monitor.getId());
        verify(monitorRepository,times(1)).deleteById(monitor.getId());
    }
}
