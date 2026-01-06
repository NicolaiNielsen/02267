package org.acme;

import java.util.List;
import java.util.ArrayList;

public class PersonService {

    public PersonService() {
    }

    // Setup dummy data
    private static List<Person> People = new ArrayList<>();

    static {
        Person p1 = new Person();
        p1.setId("1");
        p1.setName("Test1");
        p1.setCountry("Denmark");

        Person p2 = new Person();
        p2.setId("2");
        p2.setName("Test2");
        p2.setCountry("Denmark");

        Person p3 = new Person();
        p3.setId("3");
        p3.setName("Test3");
        p3.setCountry("Denmark");

        People.add(p1);
        People.add(p2);
        People.add(p3);
    }

    public List<Person> getPeople() {
        return People;
    }

    public Person getPerson(String id) {
        // loop through the peeps
        for (int i = 0; i < People.size(); i++) {
            Person p = People.get(i);
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void updatePerson(String id, Person p) {
        Person old = getPerson(id);
        old.setId(id);
        old.setName(p.getName());
        old.setCountry(p.getCountry());
    }

}
