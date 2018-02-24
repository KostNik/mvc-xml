package com.edu.mvc.controller;

import com.edu.mvc.model.Contact;
import com.edu.mvc.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author Kostiuk Nikita
 */

@Slf4j
@Controller("/contacts")
public class ContactController {

    @Resource
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        Collection<Contact> all = contactService.getAll();
        model.addAttribute("contacts", all);
        log.info("Contacts", all);
        return "contacts/list";
    }
}
