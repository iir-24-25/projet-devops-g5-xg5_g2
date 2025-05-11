package org.example.gestion_stock.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    PHARMACIEN, RESPONSABLE;
    @JsonCreator
    public static Role fromString(String value) {
        return valueOf(value.toUpperCase());
    }

    @JsonValue
    public String getValue() {
        return this.name().toLowerCase();
    }
}
