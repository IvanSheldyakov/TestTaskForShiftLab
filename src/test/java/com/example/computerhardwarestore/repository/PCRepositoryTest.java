package com.example.computerhardwarestore.repository;


import com.example.computerhardwarestore.repository.PCRepository;
import com.example.computerhardwarestore.repository.domain.PC;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import com.example.computerhardwarestore.repository.domain.possiblevalues.PCFormFactorType;
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
public class PCRepositoryTest {

	@Autowired
	private PCRepository pcRepository;
	private PC pc;


	@BeforeEach
	public void setUp() {
		pc = new PC(null, GoodType.PC,"34235GHJK",
				"asus",1000,10L, PCFormFactorType.DESKTOP);
	}
	@AfterEach
	public void tearDown() {
		pcRepository.deleteAll();
		pc = null;

	}

	@Test
	public void givenPCToAddShouldReturnAddedPC(){
		PC savedPC = pcRepository.save(pc);
		PC fetchedPC = pcRepository.findById(savedPC.getId()).get();

		assertEquals(savedPC.getId(), fetchedPC.getId());
		assertEquals(pc.getType(), fetchedPC.getType());
		assertEquals(pc.getSerialNumber(), fetchedPC.getSerialNumber());
		assertEquals(pc.getManufacturer(), fetchedPC.getManufacturer());
		assertEquals(pc.getPrice(), fetchedPC.getPrice());
		assertEquals(pc.getQuantityInStock(), fetchedPC.getQuantityInStock());
		assertEquals(pc.getFormFactor(), fetchedPC.getFormFactor());

	}

	@Test
	public void givenIdTODeleteThenShouldDeleteThePC() {
		PC savedPC = pcRepository.save(pc);
		pcRepository.deleteById(savedPC.getId());

		Optional optional = pcRepository.findById(savedPC.getId());
		assertEquals(Optional.empty(), optional);
	}

}
