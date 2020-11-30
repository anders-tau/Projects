package com.mycompany.dao;

import com.mycompany.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Thomas Anders"));
        people.add(new Person(++PEOPLE_COUNT, "Diter Bolen"));
        people.add(new Person(++PEOPLE_COUNT, "Freddie Mercury"));
        people.add(new Person(++PEOPLE_COUNT, "Till Lindemann"));
    }

    public List<Person> index() {
        return people;
    }
    public Person show(int id) {
        return people.stream().filter(person->person.getId() == id).findAny().orElse(null);
    }
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
