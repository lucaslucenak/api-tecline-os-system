package com.lucaslucena.APIosSystemTecLine.util.exceptions;

import java.io.Serial;

public class InvalidCepException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidCepException() {
        super("Invalid CEP");
    }
}
