package com.mycompany.dao;

import com.mycompany.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Person> getAll() {
        return (ArrayList) getCurrentSession().createQuery("from Person").list();
    }

    public Person getById(int id) {
        return getCurrentSession().get(Person.class, id);
    }

    public void add(Person person) { getCurrentSession().saveOrUpdate(person); }

    public void delete(int id) { getCurrentSession().delete(getById(id)); }

    public void update(Person person) { getCurrentSession().update(person); }
}
