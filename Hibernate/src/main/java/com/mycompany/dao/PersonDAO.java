package com.mycompany.dao;

import com.mycompany.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PersonDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public PersonDAO (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Person> getAll() {
        return getCurrentSession().createQuery("from Person").list();
    }

    public Person getById(int id) {
        Person person = getCurrentSession().get(Person.class, id);
        return person;
    }

    public void create(Person person) {
        getCurrentSession().save(person);
    }

    public void delete(int id) {
        Person person = getById(id);
        if (person != null)
            getCurrentSession().delete(person);
    }

    public void update(Person person) {
        Person personToUpdate = getById(person.getId());
        personToUpdate.setName(person.getName());
        personToUpdate.setAge(person.getAge());
        personToUpdate.setEmail(person.getEmail());
        getCurrentSession().update(personToUpdate);
    }
}
