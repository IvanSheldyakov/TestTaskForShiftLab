package com.example.computerhardwarestore.model;

import lombok.Data;

@Data
public class IdMessage {

    private Long id;

    public IdMessage(Long id) {
        this.id = id;
    }



}
