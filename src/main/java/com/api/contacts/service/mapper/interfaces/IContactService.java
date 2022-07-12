package com.api.contacts.service.mapper.interfaces;

import com.api.contacts.controller.dto.stdin.ContactStdInDto;
import com.api.contacts.controller.dto.stdout.ContactStdOutDto;

import java.util.List;

public interface IContactService {

    public ContactStdOutDto save(ContactStdInDto contactStdInDto);
    public ContactStdOutDto update(Long id, ContactStdInDto contactStdInDto);
    public ContactStdOutDto delete(Long id);
    public ContactStdOutDto findById(Long id);
    public List<ContactStdOutDto> findAll();
}
