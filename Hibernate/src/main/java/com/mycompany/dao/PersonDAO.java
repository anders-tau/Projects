package com.mycompany.dao;

import com.mycompany.models.Person;

import java.util.List;

public interface PersonDAO {
    public List<Person> getAll();
    public Person getById(int id);
    public void add(Person person);
    public void delete(int id);
    public void update(Person person);
}
