package org.example;

import java.util.Objects;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return hasAge() ? age : -1;
    }

    public void setAddress() {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) age++;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean getAddress() {
        return hasAddress();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public PersonBuilder newChildBuilder() {

        return new PersonBuilder()
                .setName(name)
                .setSurname(surname)
                .setAge(1)
                .setAddress(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }

    @Override
    public String toString() {
        return "{ " + name + " " + surname + " " + age + " " + address + " }";
    }

}