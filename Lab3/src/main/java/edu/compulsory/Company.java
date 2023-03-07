package edu.compulsory;

public class Company implements Node, Comparable<Company>{
    private final String name;

    public Company(String name) {
        this.name = name;
    }

    /**
     * Metoda compara doua obiecte de tip Company comparand numele acestora
     * Returneaza NullPointerException daca unul dintre nume este null
     * @param company obiectul Company cu care se compara
     * @return 0 daca sunt egale, 1 daca this.name > company.name, -1 daca this.name < company.name
     */
    @Override
    public int compareTo(Company company) {
        return this.name.compareTo(company.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
