package com.example.computerhardwarestore.repository.domain.possiblevalues;

public enum PCFormFactorType {
    DESKTOP("desktop"),
    NETTOP("nettop"),
    MONOBLOCK("monoblock");

    private String type;
    private PCFormFactorType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
