package com.edu.mvc.service;

import com.edu.mvc.model.Contact;
import com.edu.mvc.model.Photo;
import com.edu.mvc.repository.ContactRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author Kostiuk Nikita
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Resource
    private ContactRepository contactRepository;

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact, Long id) {
        return contactRepository.update(contact, id);
    }

    @Override
    public Contact getById(Long id) {
        return contactRepository.getById(id);
    }

    @Override
    public Contact getByFirstAndLastName(String firstName, String lastName) {
        return contactRepository.getByFirstAndLastName(firstName, lastName);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Collection<Contact> getAll() {
        return contactRepository.getAll();
    }

    @Override
    public Photo getPhotoByContactId(Long contactId) {
        return contactRepository.getPhotoByContactId(contactId);
    }
}
