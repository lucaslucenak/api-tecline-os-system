package com.lucaslucena.APIosSystemTecLine.util.validation;

public interface Validator<T> {
    public Boolean isValid(T value);
}
