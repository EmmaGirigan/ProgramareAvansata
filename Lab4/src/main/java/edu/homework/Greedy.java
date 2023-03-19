package edu.homework;

import java.util.*;

public class Greedy {
    private Map<Student, Project> assignments;
    public void addAssignment(Student student, Project project) {
        assignments.put(student, project);
    }

    public Project getAssignment(Student student) {
        return assignments.get(student);
    }

    public boolean existsAssignment(Project project) {
        return assignments.containsValue(project);
    }
    public void solve (Problem problem) {
        List<Student> sortedStudents = new ArrayList(problem.getStudentList());
        sortedStudents.sort(Comparator.comparing(student -> problem.getStudentProjects().size()));

        System.out.println(sortedStudents);
        for (Student student : sortedStudents) {
            for(Project project: problem.getStudentProjects()){
                if(!existsAssignment(project)){
                    addAssignment(student, project);
                    break;
                }
            }

        }
    }
}
