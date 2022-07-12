package com.api.contacts.util.exceptions;

public class ContactPhoneNumberMandatoryException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ContactPhoneNumberMandatoryException(String message) {
        super(message);
    }
}
