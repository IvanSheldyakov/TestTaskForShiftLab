package com.example.computerhardwarestore.repository;

import com.example.computerhardwarestore.repository.domain.HardDisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HardDiskRepository extends JpaRepository<HardDisk,Long> {
    @Override
    Optional<HardDisk> findById(Long id);


}

