package edu.compulsory;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var studentArray = IntStream.rangeClosed(0,2)
                .mapToObj( i -> new Student("S" + i))
                .toArray(Student[] :: new);
        List<Student> studentList = new ArrayList<>();
        for (Student s : studentArray){
            studentList.add(s);
        }
        Collections.sort(studentList,
                ((u, v) -> u.getName().compareTo(v.getName())));
        for(Student s : studentList){
            System.out.println(s);
        }
        var projectArray = IntStream.rangeClosed(0,2)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[] :: new);
        Set<Project> projectSet = new TreeSet<>();
        for (Project p : projectArray){
            projectSet.addAll(Arrays.asList(projectArray));
        }
        for (Project p : projectSet){
            System.out.println(p);
        }

        Map<Student, List<Project>> projectToStudentMap = new HashMap<>();
        List<Project> projectList = new ArrayList<>();
        projectList.add(projectArray[0]);
        projectList.add(projectArray[1]);
        projectList.add(projectArray[2]);
        projectToStudentMap.put(studentArray[0], projectList);
        projectToStudentMap.put(studentArray[1], Arrays.asList(projectArray[0], projectArray[1]));
        projectToStudentMap.put(studentArray[2], Arrays.asList(projectArray[0]));
        for(Map.Entry sp : projectToStudentMap.entrySet()){
            System.out.println(sp.getKey()+ "=" + sp.getValue());
        }
    }
}
