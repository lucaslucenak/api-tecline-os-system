package com.lucaslucena.APIosSystemTecLine.util.validation;

import org.springframework.stereotype.Component;

public interface Validator<T> {
    public Boolean isValid(T value);
}
