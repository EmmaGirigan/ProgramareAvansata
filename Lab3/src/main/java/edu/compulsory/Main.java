package edu.compulsory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node p1 = new Person("Emma");
        Node p2 = new Person("Gavri");
        Node p3 = new Person("Geo");
        Node p4 = new Person("Delia");
        Node p5 = new Person(null);
        Node c1 = new Company("Amazon");
        Node c2 = new Company("Continental");
        Node c3 = new Company("Apple");
        Node c4 = new Company(null);
        List<Node> list = new ArrayList<>();
        list.add(p4);
        list.add(p1);
        list.add(p3);
        list.add(p2);
        list.add(c2);
        //list.add(c4);
        list.add(new Company("Microsoft"));
        System.out.println(list);
    }
}