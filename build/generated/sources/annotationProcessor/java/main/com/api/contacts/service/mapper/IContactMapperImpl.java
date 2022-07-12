package com.api.contacts.service.mapper;

import com.api.contacts.controller.dto.stdin.ContactStdInDto;
import com.api.contacts.controller.dto.stdout.ContactStdOutDto;
import com.api.contacts.model.contact.Contact;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-12T14:53:58-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 18.0.1.1 (Oracle Corporation)"
)
public class IContactMapperImpl implements IContactMapper {

    @Override
    public ContactStdOutDto asContactToContactStdOutDto(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        ContactStdOutDto contactStdOutDto = new ContactStdOutDto();

        contactStdOutDto.setName( contact.getName() );
        contactStdOutDto.setLastName( contact.getLastName() );
        contactStdOutDto.setCompany( contact.getCompany() );
        contactStdOutDto.setPhoneNumber( contact.getPhoneNumber() );
        contactStdOutDto.setEmail( contact.getEmail() );
        contactStdOutDto.setAddress( contact.getAddress() );
        contactStdOutDto.setId( contact.getId() );

        return contactStdOutDto;
    }

    @Override
    public Contact asContactStdInDtoToContact(ContactStdInDto contactStdInDto) {
        if ( contactStdInDto == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setName( contactStdInDto.getName() );
        contact.setLastName( contactStdInDto.getLastName() );
        contact.setCompany( contactStdInDto.getCompany() );
        contact.setPhoneNumber( contactStdInDto.getPhoneNumber() );
        contact.setEmail( contactStdInDto.getEmail() );
        contact.setAddress( contactStdInDto.getAddress() );

        return contact;
    }

    @Override
    public List<ContactStdOutDto> asListContactEntitiesToListContactStdInDto(List<Contact> contacts) {
        if ( contacts == null ) {
            return null;
        }

        List<ContactStdOutDto> list = new ArrayList<ContactStdOutDto>( contacts.size() );
        for ( Contact contact : contacts ) {
            list.add( asContactToContactStdOutDto( contact ) );
        }

        return list;
    }
}
