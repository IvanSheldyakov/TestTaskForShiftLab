package com.example.computerhardwarestore.repository;


import com.example.computerhardwarestore.repository.domain.GoodEntity;
import com.example.computerhardwarestore.repository.domain.HardDisk;
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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GoodRepositoryTest {

    @Autowired
    private GoodRepository goodRepository;

    private GoodEntity laptop1;
    private GoodEntity laptop2;
    private GoodEntity hardDisk;

    @BeforeEach
    public void setUp() {
        laptop1 = new Laptop(null, GoodType.LAPTOP, "2342342",
                "lg", 234.34, 34L, LaptopSize.FOURTEEN);
        hardDisk = new HardDisk(null, GoodType.HARD_DISK, "GHJGJJG",
                "tech", 23.99, 354L, 512);
        laptop2 = new Laptop(null, GoodType.LAPTOP, "234JKJLJ2342",
                "sam", 287, 1L, LaptopSize.FIFTEEN);
    }

    @AfterEach
    public void tearDown() {
        goodRepository.deleteAll();
        laptop1 = null;
        laptop2 = null;
        hardDisk = null;
    }


    @Test
    public void givenGoodToAddShouldReturnAddedGood() {
        GoodEntity savedLaptop = goodRepository.save(laptop1);
        GoodEntity fetchedGood = goodRepository.findById(savedLaptop.getId()).get();

        assertEquals(savedLaptop.getId(), fetchedGood.getId());
        assertEquals(laptop1.getType(), fetchedGood.getType());
        assertEquals(laptop1.getSerialNumber(), fetchedGood.getSerialNumber());
        assertEquals(laptop1.getManufacturer(), fetchedGood.getManufacturer());
        assertEquals(laptop1.getPrice(), fetchedGood.getPrice());
        assertEquals(laptop1.getQuantityInStock(), fetchedGood.getQuantityInStock());

        Laptop fetchedLaptop = (Laptop) fetchedGood;
        assertEquals(LaptopSize.FOURTEEN, fetchedLaptop.getSize());
    }

    @Test
    public void givenTypeShouldReturnAllGoodsOfThatType() {
        goodRepository.save(laptop1);
        goodRepository.save(hardDisk);
        goodRepository.save(laptop2);

        List<GoodEntity> laptops = goodRepository.findAllByType(GoodType.LAPTOP);
        assertEquals(laptops.get(0).getType(), GoodType.LAPTOP);
        assertEquals(laptops.get(1).getType(), GoodType.LAPTOP);

        List<GoodEntity> hardDisk = goodRepository.findAllByType(GoodType.HARD_DISK);
        assertEquals(hardDisk.get(0).getType(), GoodType.HARD_DISK);
    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheGood() {
        GoodEntity savedHardDisk = goodRepository.save(hardDisk);
        goodRepository.deleteById(savedHardDisk.getId());

        Optional optional = goodRepository.findById(savedHardDisk.getId());
        assertEquals(Optional.empty(), optional);
    }

}
