package com.example.stalker.data;

import com.example.stalker.model.Person;

import java.util.ArrayList;

public class DAOPerson {
    private static DAOPerson INSTANCE = new DAOPerson();
    private ArrayList<Person> people;

    private DAOPerson () {
        this.people = new ArrayList<Person>();
    }

    public static DAOPerson getINSTANCE() {
        return INSTANCE;
    }

    public ArrayList<Person> getPeople () {
        return people;
    }

    public void addPerson (Person person) {
        this.people.add(person);
    }
}