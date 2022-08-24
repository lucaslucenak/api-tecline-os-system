package com.lucaslucena.APIosSystemTecLine.util.validation;

public class CepValidator implements Validator<String> {
    @Override
    public Boolean isValid(String value) {
        return value.length() == 8;
    }
}
