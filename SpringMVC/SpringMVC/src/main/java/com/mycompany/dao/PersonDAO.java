package com.mycompany.dao;

import com.mycompany.models.Person;
import org.springframework.stereotype.Component;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static Connection connection;

    static {
        InitialContext context = null;
        try {
            context = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        DataSource ds = null;
        try {
            assert context != null;
            ds = (DataSource) context.lookup("java:/comp/env/jdbc/test");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        try {
            assert ds != null;
            connection = ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "select * from person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
        Person person = new Person();
        try {
            Statement statement = connection.createStatement();
            String SQL = "select * from person where id = " + id;
            ResultSet resultSet = statement.executeQuery(SQL);
            if (resultSet.next()) {
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String SQLmaxId = "select max(id) as maxid from person";
            ResultSet resultSet = statement.executeQuery(SQLmaxId);
            int maxId = 0;
            if (resultSet.next()) {
                maxId = resultSet.getInt("maxid");
            }
            if (maxId != 0) {
                maxId = maxId + 1;
                String SQL = "insert into person values(" + maxId + ",'" + person.getName() +
                        "'," + person.getAge() + ",'" + person.getEmail() + "')";
                statement.executeUpdate(SQL);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "update person set name = '" + updatedPerson.getName() +
                         "', age = " + updatedPerson.getAge() + ", email = '" +
                         updatedPerson.getEmail() + "' where id = " + id;
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "delete from Person where id = " + id;
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}