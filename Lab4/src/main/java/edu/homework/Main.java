package edu.homework;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Problem problem = new Problem(7, 5);

        for(Map.Entry sp : problem.getProjectToStudentMap().entrySet()){
            System.out.println(sp.getKey()+ "=" + sp.getValue());
        }
        List<Student> studentsWithFewerProjects;
        studentsWithFewerProjects = problem.getStudentList()
                .stream()
                .filter(s -> problem.getProjectToStudentMap().get(s).size()
                        <
                        problem.getProjectToStudentMap().values()
                            .stream()
                            .mapToInt(List::size).average().getAsDouble())
                .collect(Collectors.toList());
        System.out.println(studentsWithFewerProjects);
    }

}
