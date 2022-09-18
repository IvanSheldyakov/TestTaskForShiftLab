package com.example.computerhardwarestore.repository;

import com.example.computerhardwarestore.repository.domain.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {

}
