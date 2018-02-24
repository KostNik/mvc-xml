package com.edu.mvc.repository;

import com.edu.mvc.model.Contact;
import com.edu.mvc.model.Photo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

/**
 * @author Kostiuk Nikita
 */
@Repository
@Transactional
public class ContactRepositoryImpl implements ContactRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Contact save(Contact contact) {
        entityManager.persist(contact);
        return contact;
    }

    @Override
    public Contact update(Contact contact, Long id) {
        contact.setId(id);
        return entityManager.merge(contact);
    }

    @Override
    public Contact getById(Long id) {
        return entityManager.find(Contact.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public Contact getByFirstAndLastName(String firstName, String lastName) {
        TypedQuery<Contact> namedQuery = entityManager.createNamedQuery("Contact.getByFirstAndLastName", Contact.class);
        namedQuery.setParameter("firstName", firstName);
        namedQuery.setParameter("lastName", lastName);
        return namedQuery.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(Contact.class, id));
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Contact> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contact> query = criteriaBuilder.createQuery(Contact.class);
        Root<Contact> contactRoot = query.from(Contact.class);
        query.select(contactRoot);
        return entityManager.createQuery(query).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Photo getPhotoByContactId(Long contactId) {
        TypedQuery<Photo> namedQuery = entityManager.createNamedQuery("Contact.getPhoto", Photo.class);
        return namedQuery.getSingleResult();
    }
}
