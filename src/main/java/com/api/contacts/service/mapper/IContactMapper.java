package com.api.contacts.service.mapper;

import com.api.contacts.controller.dto.stdin.ContactStdInDto;
import com.api.contacts.controller.dto.stdout.ContactStdOutDto;
import com.api.contacts.model.contact.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IContactMapper {
    IContactMapper INSTANCE = Mappers.getMapper(IContactMapper.class);
    ContactStdOutDto asContactToContactStdOutDto(Contact contact);
    Contact asContactStdInDtoToContact(ContactStdInDto contactStdInDto);
    List<ContactStdOutDto> asListContactEntitiesToListContactStdInDto(List<Contact> contacts);
}
