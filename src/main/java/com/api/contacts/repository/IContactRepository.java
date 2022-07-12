package com.api.contacts.repository;

import com.api.contacts.model.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Contact repository
 */
@Repository
public interface IContactRepository extends JpaRepository<Contact,Long> {

}
