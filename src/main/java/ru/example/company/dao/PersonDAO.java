package ru.example.company.dao;

import org.springframework.stereotype.Component;
import ru.example.company.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT = 0;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 29, "katy@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Nick", 30, "nick@rambler.com"));
        people.add(new Person(++PEOPLE_COUNT, "Max", 27, "max@bk.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}