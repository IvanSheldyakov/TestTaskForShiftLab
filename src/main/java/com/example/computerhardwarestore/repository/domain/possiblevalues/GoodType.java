package com.example.computerhardwarestore.repository.domain.possiblevalues;

public enum GoodType {
    LAPTOP("laptop"),
    HARD_DISK("hard_disk"),
    PC("pc"),
    MONITOR("monitor");

    private String type;

    private GoodType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
