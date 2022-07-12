package com.api.contacts.controller.contact;

import com.api.contacts.controller.dto.stdin.ContactStdInDto;
import com.api.contacts.controller.dto.stdout.ContactStdOutDto;
import com.api.contacts.service.mapper.interfaces.IContactService;
import com.api.contacts.util.exceptions.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1.0/contacts")
public class ContactController
{
    private IContactService iContactService;

    @Autowired
    public ContactController(IContactService iContactService) {
        this.iContactService = iContactService;
    }

    @PostMapping("/")
    public ResponseEntity<ContactStdOutDto> save(@Valid @RequestBody ContactStdInDto contactStdInDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }
        return new ResponseEntity<ContactStdOutDto>( iContactService.save(contactStdInDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactStdOutDto> update(@Valid @RequestBody ContactStdInDto contactStdInDto, BindingResult bindingResult, @PathVariable long id){
        if(bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }
        return new ResponseEntity<ContactStdOutDto>( iContactService.update(id,contactStdInDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactStdOutDto> findById(@PathVariable long id){
        return new ResponseEntity<ContactStdOutDto>( iContactService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ContactStdOutDto>> findAll(){
        return new ResponseEntity<List<ContactStdOutDto>>( iContactService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContactStdOutDto> deleteById(@PathVariable long id){
        return new ResponseEntity<ContactStdOutDto>(iContactService.delete(id),HttpStatus.OK);
    }
}
