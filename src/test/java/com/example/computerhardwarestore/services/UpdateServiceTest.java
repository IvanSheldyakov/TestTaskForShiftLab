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
import com.example.computerhardwarestore.service.impl.UpdateServiceImpl;
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
public class UpdateServiceTest {
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
    private UpdateServiceImpl updateService;

    private PC pc;

    private Laptop laptop;

    private HardDisk hardDisk;
    private Monitor monitor;

    @BeforeEach
    public void setUp() {
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
    void givenPCToAddShouldReturnUpdatedPC() {

        when(pcRepository.save(any())).thenReturn(pc);
        updateService.update(pc);
        verify(pcRepository,times(1)).save(any());
    }

    @Test
    void givenLaptopToAddShouldReturnUpdatedLaptop()  {

        when(laptopRepository.save(any())).thenReturn(laptop);
        updateService.update(laptop);
        verify(laptopRepository,times(1)).save(any());
    }

    @Test
    void givenHardDiskToAddShouldReturnUpdatedHardDisk()  {

        when(hardDiskRepository.save(any())).thenReturn(hardDisk);
        updateService.update(hardDisk);
        verify(hardDiskRepository,times(1)).save(any());
    }

    @Test
    void givenMonitorToAddShouldReturnUpdatedMonitor()  {

        when(monitorRepository.save(any())).thenReturn(monitor);
        updateService.update(monitor);
        verify(monitorRepository,times(1)).save(any());
    }
}
