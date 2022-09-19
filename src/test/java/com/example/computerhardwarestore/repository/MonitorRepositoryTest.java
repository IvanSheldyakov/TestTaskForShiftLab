package com.example.computerhardwarestore.repository;

import com.example.computerhardwarestore.repository.MonitorRepository;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MonitorRepositoryTest {

    @Autowired
    private MonitorRepository monitorRepository;
    private Monitor monitor;


    @BeforeEach
    public void setUp() {
        monitor = new Monitor(null, GoodType.MONITOR,"34235GHJK",
                "asus",1000,10L, 24.5);
    }
    @AfterEach
    public void tearDown() {
        monitorRepository.deleteAll();
        monitor = null;

    }

    @Test
    public void givenMonitorToAddShouldReturnAddedMonitor(){
        Monitor savedMonitor = monitorRepository.save(monitor);
        Monitor fetchedMonitor = monitorRepository.findById(savedMonitor.getId()).get();

        assertEquals(savedMonitor.getId(), fetchedMonitor.getId());
        assertEquals(monitor.getType(), fetchedMonitor.getType());
        assertEquals(monitor.getSerialNumber(), fetchedMonitor.getSerialNumber());
        assertEquals(monitor.getManufacturer(), fetchedMonitor.getManufacturer());
        assertEquals(monitor.getPrice(), fetchedMonitor.getPrice());
        assertEquals(monitor.getQuantityInStock(), fetchedMonitor.getQuantityInStock());
        assertEquals(monitor.getDiagonal(), fetchedMonitor.getDiagonal());

    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheMonitor() {
        Monitor savedMonitor = monitorRepository.save(monitor);
        monitorRepository.deleteById(savedMonitor.getId());

        Optional optional = monitorRepository.findById(savedMonitor.getId());
        assertEquals(Optional.empty(), optional);
    }
}
