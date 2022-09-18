package com.example.computerhardwarestore.service;


import com.example.computerhardwarestore.repository.domain.HardDisk;
import com.example.computerhardwarestore.repository.domain.Laptop;
import com.example.computerhardwarestore.repository.domain.Monitor;
import com.example.computerhardwarestore.repository.domain.PC;

import java.util.Optional;

public interface UpdateService {

    Monitor update(Monitor monitor);
    PC update(PC pc);
    HardDisk update(HardDisk hardDisk);
    Laptop update(Laptop laptop);
}
