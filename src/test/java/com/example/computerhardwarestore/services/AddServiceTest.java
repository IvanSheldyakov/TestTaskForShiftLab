package com.example.computerhardwarestore.services;

import com.example.computerhardwarestore.repository.*;
import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;
import com.example.computerhardwarestore.repository.domain.possiblevalues.PCFormFactorType;
import com.example.computerhardwarestore.service.impl.AddServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddServiceTest {

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
    private AddServiceImpl addService;

    private PC pc;

    private Laptop laptop;

    private HardDisk hardDisk;
    private Monitor monitor;

    @BeforeEach
    public void setUp() {
        pc = new PC(null, GoodType.PC,"34235GHJK",
                "asus",1000,10L, PCFormFactorType.DESKTOP);
        laptop = new Laptop(null, GoodType.HARD_DISK,"HKKH35GHJK",
                "tech",1010,10L, LaptopSize.SEVENTEEN);
        hardDisk = new HardDisk(null, GoodType.HARD_DISK,"HAAAAA5GHJK",
                "tech",1010,10L, 1024);
        monitor = new Monitor(null, GoodType.MONITOR,"3HKHKHKHKHK",
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
    void givenPCToAddShouldReturnAddedPC()  {

        when(pcRepository.save(any())).thenReturn(pc);
        addService.add(pc);
        verify(pcRepository,times(1)).save(any());
    }

    @Test
    void givenLaptopToAddShouldReturnAddedLaptop()  {

        when(laptopRepository.save(any())).thenReturn(laptop);
        addService.add(laptop);
        verify(laptopRepository,times(1)).save(any());
    }

    @Test
    void givenHardDiskToAddShouldReturnAddedHardDisk()  {

        when(hardDiskRepository.save(any())).thenReturn(hardDisk);
        addService.add(hardDisk);
        verify(hardDiskRepository,times(1)).save(any());
    }

    @Test
    void givenMonitorToAddShouldReturnAddedMonitor()  {

        when(monitorRepository.save(any())).thenReturn(monitor);
        addService.add(monitor);
        verify(monitorRepository,times(1)).save(any());
    }
}
