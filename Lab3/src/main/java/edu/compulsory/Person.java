package edu.compulsory;

public class Person implements Node, Comparable<Person>{
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    /**
     * Metoda compara doua obiecte de tip Person comparand numele acestora
     * Returneaza NullPointerException daca unul dintre nume este null
     * @param person obiectul Person cu care se compara
     * @return 0 daca sunt egale, 1 daca this.name > person.name, -1 daca this.name < person.name
     */
    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
