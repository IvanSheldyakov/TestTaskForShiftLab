package com.example.computerhardwarestore.repository;

import com.example.computerhardwarestore.repository.LaptopRepository;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.repository.domain.possiblevalues.LaptopSize;
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
public class LaptopRepositoryTest {


    @Autowired
    private LaptopRepository laptopRepository;
    private Laptop laptop;


    @BeforeEach
    public void setUp() {
        laptop = new Laptop(null, GoodType.HARD_DISK,"HKKH35GHJK",
                "tech",1010,10L, LaptopSize.SEVENTEEN);
    }
    @AfterEach
    public void tearDown() {
        laptopRepository.deleteAll();
        laptop = null;

    }

    @Test
    public void givenLaptopToAddShouldReturnAddedLaptop(){
        Laptop savedLaptop = laptopRepository.save(laptop);
        Laptop fetchedLaptop = laptopRepository.findById(laptop.getId()).get();

        assertEquals(savedLaptop.getId(), fetchedLaptop.getId());
        assertEquals(laptop.getType(), fetchedLaptop.getType());
        assertEquals(laptop.getSerialNumber(), fetchedLaptop.getSerialNumber());
        assertEquals(laptop.getManufacturer(), fetchedLaptop.getManufacturer());
        assertEquals(laptop.getPrice(), fetchedLaptop.getPrice());
        assertEquals(laptop.getQuantityInStock(), fetchedLaptop.getQuantityInStock());
        assertEquals(laptop.getSize(), fetchedLaptop.getSize());

    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheLaptop() {
        Laptop savedLaptop = laptopRepository.save(laptop);
        laptopRepository.deleteById(savedLaptop.getId());
        Optional optional = laptopRepository.findById(savedLaptop.getId());
        assertEquals(Optional.empty(), optional);
    }
}
