package com.lucaslucena.APIosSystemTecLine.util.validation;

public class EmailValidator implements Validator<String>{
    @Override
    public Boolean isValid(String value) {
        return value.contains("@") && value.contains(".com");
    }
}
