package com.api.contacts.util.exceptions;

/**
 * Class representing exception when a contact does not exist
 */
public class ContactDoesNotExistException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ContactDoesNotExistException(String message){
        super(message);
    }
}
