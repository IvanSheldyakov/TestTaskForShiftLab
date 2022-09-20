package com.example.computerhardwarestore.service;



import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;

public interface AddService {
    HardDisk add(HardDisk hardDisk);
    Laptop add(Laptop laptop);
    Monitor add(Monitor monitor);
    PC add(PC pc);

}
