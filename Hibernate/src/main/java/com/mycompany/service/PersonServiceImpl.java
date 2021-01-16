package com.mycompany.service;

import com.mycompany.dao.PersonDAO;
import com.mycompany.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;
    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public List<Person> getAll() { return personDAO.getAll(); }

    public Person getById(int id) { return personDAO.getById(id); }

    public void add(Person person) { personDAO.add(person); }

    public void delete(int id) { personDAO.delete(id); }

    public void update(Person person) { personDAO.update(person); }
}
