package com.example.computerhardwarestore.service;

import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;

public interface DeleteService {

    Monitor deleteMonitorById(Long id);
    Laptop deleteLaptopById(Long id);
    PC deletePCById(Long id);
    HardDisk deleteHardDiskById(Long id);
}
