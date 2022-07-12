package com.api.contacts.controller.dto.stdin;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ContactStdInDto {

    //Attributes
    @Size(max = 45, min=3, message="The name must be between 3 and 45 characters.")
    private String name;

    @Size(max = 45, min=3, message="The lastname must be between 3 and 45 characters.")
    private String lastName;

    @Size(max = 45, min=3, message="The company name must be between 3 and 45 characters.")
    private String company;

    @Size(max = 13, min=7, message="The phone number must be between 7 and 13 digits.")
    @Pattern(regexp = "^[0-9]*$", message="The phone number can only have numbers")
    private String phoneNumber;
    @Size(max = 45, min=3, message="The email must be between 3 and 45 characters.")
    private String email;
    @Size(max = 45, min=3, message="The address must be between 3 and 45 characters.")
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
