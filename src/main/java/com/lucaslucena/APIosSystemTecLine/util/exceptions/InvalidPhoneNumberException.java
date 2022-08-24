package com.lucaslucena.APIosSystemTecLine.util.exceptions;

import java.io.Serial;

public class InvalidPhoneNumberException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidPhoneNumberException() {
        super("Invalid Phone Number");
    }

}
