package com.edu.mvc.repository;

import com.edu.mvc.model.Contact;
import com.edu.mvc.model.Photo;

import java.util.Collection;

/**
 * @author Kostiuk Nikita
 */
public interface ContactRepository {

    Contact save(Contact contact);

    Contact update(Contact contact, Long id);

    Contact getById(Long id);

    Contact getByFirstAndLastName(String firstName, String lastName);

    void deleteById(Long id);

    Collection<Contact> getAll();

    Photo getPhotoByContactId(Long contactId);

}
