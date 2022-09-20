package com.example.computerhardwarestore.repository;

import com.example.computerhardwarestore.repository.HardDiskRepository;
import com.example.computerhardwarestore.repository.domain.HardDisk;
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
public class HardDiskRepositoryTest {

    @Autowired
    private HardDiskRepository hardDiskRepository;
    private HardDisk hardDisk;


    @BeforeEach
    public void setUp() {
        hardDisk = new HardDisk(null, GoodType.HARD_DISK,"HKKH35GHJK",
                "tech",1010,10L, 1024);
    }
    @AfterEach
    public void tearDown() {
        hardDiskRepository.deleteAll();
        hardDisk = null;

    }

    @Test
    public void givenHardDiskToAddShouldReturnAddedHardDisk(){
        HardDisk savedHardDisk = hardDiskRepository.save(hardDisk);
        HardDisk fetchedHardDisk = hardDiskRepository.findById(hardDisk.getId()).get();

        assertEquals(savedHardDisk.getId(), fetchedHardDisk.getId());
        assertEquals(hardDisk.getType(), fetchedHardDisk.getType());
        assertEquals(hardDisk.getSerialNumber(), fetchedHardDisk.getSerialNumber());
        assertEquals(hardDisk.getManufacturer(), fetchedHardDisk.getManufacturer());
        assertEquals(hardDisk.getPrice(), fetchedHardDisk.getPrice());
        assertEquals(hardDisk.getQuantityInStock(), fetchedHardDisk.getQuantityInStock());
        assertEquals(hardDisk.getVolume(), fetchedHardDisk.getVolume());

    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheHardDisk() {
        HardDisk savedHardDisk = hardDiskRepository.save(hardDisk);
        hardDiskRepository.deleteById(savedHardDisk.getId());
        Optional optional = hardDiskRepository.findById(savedHardDisk.getId());
        assertEquals(Optional.empty(), optional);
    }

}
