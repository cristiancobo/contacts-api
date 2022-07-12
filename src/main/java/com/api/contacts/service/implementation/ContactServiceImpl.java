package com.api.contacts.service.implementation;
import com.api.contacts.controller.dto.stdin.ContactStdInDto;
import com.api.contacts.controller.dto.stdout.ContactStdOutDto;
import com.api.contacts.model.contact.Contact;
import com.api.contacts.repository.IContactRepository;
import com.api.contacts.service.mapper.interfaces.IContactService;
import com.api.contacts.service.mapper.IContactMapperImpl;
import com.api.contacts.util.exceptions.ContactDoesNotExistException;
import com.api.contacts.util.exceptions.ContactLastNameMandatoryException;
import com.api.contacts.util.exceptions.ContactNameMandatoryException;
import com.api.contacts.util.exceptions.ContactPhoneNumberMandatoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImpl implements IContactService {
    private IContactRepository iContactRepository;
    @Autowired
    public ContactServiceImpl(IContactRepository iContactRepository) {
        this.iContactRepository = iContactRepository;
    }

    @Override
    public ContactStdOutDto save(ContactStdInDto contactStdInDto) {

        Contact contact = IContactMapperImpl.INSTANCE.asContactStdInDtoToContact(contactStdInDto);
        if(contactStdInDto.getName() == null){
            throw new ContactNameMandatoryException("Contact name is mandatory");
        }
        if(contactStdInDto.getLastName() == null){
            throw new ContactLastNameMandatoryException("Contact lastname is mandatory");
        }
        if(contactStdInDto.getPhoneNumber() == null){
            throw new ContactPhoneNumberMandatoryException("Contact phonenumber is mandatory");
        }
        ContactStdOutDto contactStdOutDto = IContactMapperImpl.INSTANCE.asContactToContactStdOutDto(contact);
        long id = iContactRepository.saveAndFlush(contact).getId();
        contactStdOutDto.setId(id);
        return contactStdOutDto;
    }

    @Override
    public ContactStdOutDto update(Long id, ContactStdInDto contactStdInDto) {
        if(!iContactRepository.existsById(id)){
            throw new ContactDoesNotExistException("Contact with id "+ id+ " does not exist");
        }
        Contact contact = iContactRepository.findById(id).get();
        if(contactStdInDto.getName() == null){
            throw new ContactNameMandatoryException("Contact name is mandatory");
        }
        if(contactStdInDto.getLastName() == null){
            throw new ContactLastNameMandatoryException("Contact lastname is mandatory");
        }
        if(contactStdInDto.getPhoneNumber() == null){
            throw new ContactPhoneNumberMandatoryException("Contact phone number is mandatory");
        }
        contact.setName(contactStdInDto.getName());
        contact.setLastName(contactStdInDto.getLastName());
        contact.setAddress(contactStdInDto.getAddress());
        contact.setCompany(contactStdInDto.getCompany());
        contact.setEmail(contactStdInDto.getEmail());
        contact.setPhoneNumber(contactStdInDto.getPhoneNumber());
        iContactRepository.save(contact);
        ContactStdOutDto contactStdOutDto = IContactMapperImpl.INSTANCE.asContactToContactStdOutDto(contact);
        return contactStdOutDto;
    }

    @Override
    public ContactStdOutDto delete(Long id) {
        if(!iContactRepository.existsById(id)){
            throw new ContactDoesNotExistException("Contact with id "+ id+ " does not exist");
        }
        Contact contact = iContactRepository.findById(id).get();
        ContactStdOutDto contactStdOutDto = IContactMapperImpl.INSTANCE.asContactToContactStdOutDto(contact);
        iContactRepository.deleteById(id);
        return contactStdOutDto;
    }

    @Override
    public ContactStdOutDto findById(Long id) {
        if(!iContactRepository.existsById(id)){
            throw new ContactDoesNotExistException("Contact with id "+ id+ " does not exist");
        }
        Contact contact = iContactRepository.findById(id).get();
        ContactStdOutDto contactStdOutDto = IContactMapperImpl.INSTANCE.asContactToContactStdOutDto(contact);
        return contactStdOutDto;
    }

    @Override
    public List<ContactStdOutDto> findAll() {
        List<Contact> contacts = iContactRepository.findAll();
        List<ContactStdOutDto> contactStdOutDto = IContactMapperImpl.INSTANCE.asListContactEntitiesToListContactStdInDto(contacts);
        return contactStdOutDto;
    }
}
