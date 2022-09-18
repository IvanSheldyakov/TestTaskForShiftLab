package com.example.computerhardwarestore.service;

import com.example.computerhardwarestore.repository.domain.Laptop;


import java.util.Optional;

public interface DeleteService {

    void deleteMonitorById(Long id);
    void deleteLaptopById(Long id);
    void deletePCById(Long id);
    void deleteHardDisk(Long id);
}
