package com.edu.mvc;

import com.edu.mvc.model.Contact;
import com.edu.mvc.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Collection;

/**
 * @author Kostiuk Nikita
 */
@Slf4j
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("META-INF/spring/datasource-tx-jpa.xml");
        ContactService contactService = context.getBean("contactService", ContactService.class);

        Collection<Contact> contacts = contactService.getAll();

        log.info("{}", contacts);
    }
}
