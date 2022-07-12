package com.api.contacts.util.exceptions;

public class ContactLastNameMandatoryException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ContactLastNameMandatoryException(String message) {
        super(message);
    }
}
