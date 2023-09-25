package com.offroadrepairservice.model.entity;


public enum PartTypes {

    SUSPENSION("Suspension"),

    BODY("Body"),

    ENGINE("Engine");

    private final String value;

    private PartTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
