package com.lucaslucena.APIosSystemTecLine.util.validation;

public class PhoneNumberValidator implements Validator<String> {
    @Override
    public Boolean isValid(String value) {
        return value.length() == 11;
    }
}
