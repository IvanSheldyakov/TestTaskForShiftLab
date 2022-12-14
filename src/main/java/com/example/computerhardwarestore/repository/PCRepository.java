package com.example.computerhardwarestore.repository;

import com.example.computerhardwarestore.repository.domain.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PCRepository extends JpaRepository<PC, Long> {

}
