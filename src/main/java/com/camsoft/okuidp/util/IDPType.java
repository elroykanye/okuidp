package com.camsoft.okuidp.util;

public enum IDPType {

    FAMILY("Family"),
    INDIVIDUAL("Individual");

    private final String value;

    IDPType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
