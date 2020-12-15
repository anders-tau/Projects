package com.mycompany.dao;

import com.mycompany.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final DataSource dataSource;

    @Autowired
    private PersonDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Person> getAll() throws SQLException {
        List<Person> people = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        try {
            String sql = "SELECT * FROM person";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            connection.close();
        }
        return people;
    }

    public Person getById(int id) throws SQLException {
        Person person = new Person();
        Connection connection = dataSource.getConnection();
        try {
            String sql = "SELECT * FROM person WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            connection.close();
        }
        return person;
    }

    public void create(Person person) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            String sql = "INSERT INTO person (name,age,email) VALUES(?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void update(int id, Person updatedPerson) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            String sql = "UPDATE person SET name = ?, age = ?, email = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setInt(2, updatedPerson.getAge());
            preparedStatement.setString(3, updatedPerson.getEmail());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void delete(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            String sql = "DELETE FROM Person WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
