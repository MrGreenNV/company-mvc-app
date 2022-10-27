package ru.example.company.dao;

import org.springframework.stereotype.Component;
import ru.example.company.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;

    private static final String URL = "jdbc:postgresql://localhost:5432/company_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return people;
    }

    public Person show(int id) {
        Person person;

        String SQL = "SELECT * FROM Person WHERE id = ?";
        try {
            PreparedStatement prSt = connection.prepareStatement(SQL);
            prSt.setInt(1, id);

            ResultSet resSet = prSt.executeQuery();

            resSet.next();

            person = new Person();
            person.setId(resSet.getInt("id"));
            person.setName(resSet.getString("name"));
            person.setAge(resSet.getInt("age"));
            person.setEmail(resSet.getString("email"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);

        try {
            String SQL = "INSERT INTO Person VALUES(?, ?, ?, ?)";
            PreparedStatement prSt = connection.prepareStatement(SQL);

            prSt.setInt(1, person.getId());
            prSt.setString(2, person.getName());
            prSt.setInt(3, person.getAge());
            prSt.setString(4, person.getEmail());

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Person updatedPerson) {
        String SQL = "UPDATE Person SET name = ?, age = ?, email = ? WHERE id = ?";
        try {
            PreparedStatement prSt = connection.prepareStatement(SQL);

            prSt.setString(1, updatedPerson.getName());
            prSt.setInt(2, updatedPerson.getAge());
            prSt.setString(3, updatedPerson.getEmail());
            prSt.setInt(4, id);

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String SQL = "DELETE FROM Person WHERE id = ?";
        try {
            PreparedStatement prSt = connection.prepareStatement(SQL);

            prSt.setInt(1, id);

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}