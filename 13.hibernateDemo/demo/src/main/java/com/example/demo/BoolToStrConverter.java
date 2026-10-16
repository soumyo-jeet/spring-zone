package com.example.demo;

import jakarta.persistence.AttributeConverter;

public class BoolToStrConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if(attribute == null) return null;
        if(attribute == true) return "yes";
        return "no";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if(dbData == null) return null;

        if(dbData.equals("yes")) return true;
        return false;
    }
}
