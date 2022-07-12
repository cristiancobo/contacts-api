package com.api.contacts.util.exceptions;

public class ContactNameMandatoryException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ContactNameMandatoryException(String message) {
        super(message);
    }
}
