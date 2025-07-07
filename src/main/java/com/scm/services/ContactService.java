package com.scm.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.scm.entities.Contact;
import com.scm.entities.User;

public interface ContactService {

    // save Contacts
    Contact save(Contact contact);

    // update Contacts
    Contact update(Contact contact);

    // get contacts
    List<Contact> getAll();

    // get contact by id
    Contact getById(String id);

    // delete contact
    void delete(String id);

    // search contact
    Page<Contact> searchbyName(String nameKeyword, int size, int page, String sortBy, String order, User user);

    Page<Contact> searchbyEmail(String emailKeyword, int size, int page, String sortBy, String order, User user);

    Page<Contact> searchbyPhoneNumber(String phoneNumberKeyword, int size, int page, String sortBy, String order,
            User user);

    // get contacts by userId
    List<Contact> getByUserId(String userId);

    Page<Contact> getByUser(User user, int page, int size, String sortBy, String direction);

}
