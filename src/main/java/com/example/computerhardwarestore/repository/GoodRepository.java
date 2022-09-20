package com.example.computerhardwarestore.repository;

import com.example.computerhardwarestore.repository.domain.GoodEntity;
import com.example.computerhardwarestore.repository.domain.possiblevalues.GoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodRepository extends JpaRepository<GoodEntity,Long> {

    @Override
    Optional<GoodEntity> findById(Long id);

    List<GoodEntity> findAllByType(GoodType type);

    boolean existsGoodEntityBySerialNumber(String serialNumber);
}
