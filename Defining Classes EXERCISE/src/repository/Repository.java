package repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository {
    private Map<Integer, Person> persons;
    private int ID;

    public Repository() {
        this.persons = new LinkedHashMap<>();
        this.ID = 0;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void add(Person person) {
        this.persons.putIfAbsent(getID(), person);
        this.ID += 1;
    }

    public Person get(int id) {
        return persons.get(id);
    }

    public boolean update(int id, Person newPerson) {
        if (persons.containsKey(id)) {
            persons.put(id, newPerson);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (persons.containsKey(id)) {
            persons.remove(id);
            return true;
        }

        return false;
    }

    public int getCount() {
        return persons.size();
    }
}
