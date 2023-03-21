package edu.homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Problem {
    private final int numberOfStudents;
    private final int numberOfProjects;
    private List<Student> studentList = new ArrayList<>();
    private List<Project> projectList = new ArrayList<>();
    private Map<Student, List<Project>> projectToStudentMap = new HashMap<>();

    public Problem(int s, int p) {
        numberOfStudents = s;
        numberOfProjects = p;
        studentList = makeStudents();
        projectList = makeProjects();
        projectToStudentMap = makeMap();
    }

    private List<Student> makeStudents(){
        var studentArray = IntStream.rangeClosed(0, numberOfStudents)
                .mapToObj(i -> new Student(new Faker().name().firstName()))
                .toArray(Student[]::new);
        for(Student student: studentArray){
            studentList.add(student);
        }
        return studentList;
    }

    private List<Project> makeProjects(){
        var projectArray = IntStream.rangeClosed(0, numberOfProjects)
                .mapToObj( i -> new Project(new Faker().pokemon().name()))
                .toArray(Project[] :: new);
        List<Project> projectList = new ArrayList<>();
        for (Project project : projectArray){
            projectList.add(project);
        }
        return projectList;
    }

    public static List<Project> assignProjects(List<Project> projects, int numberOfProjectsAssigned) {
        Collections.shuffle(projects);
        List<Project> projectsAssigned = new ArrayList<>();
        projectsAssigned = projects.subList(0, numberOfProjectsAssigned);
        Collections.sort(projectsAssigned);
        return projectsAssigned;
    }

    private int randomNumberOfProjects(){
        Random random = new Random();
        int number = 0;
        while(number == 0) {
            number = random.nextInt(numberOfProjects);
        }
        return number;
    }
    private Map<Student, List<Project>> makeMap(){
        for(int i = 0; i < numberOfStudents; i++){
            List<Project> projects = new ArrayList<>(assignProjects(projectList, randomNumberOfProjects()));
            projectToStudentMap.put(studentList.get(i), projects);
        }
        return projectToStudentMap;
    }

    public Map<Student, List<Project>> getProjectToStudentMap() {
        return projectToStudentMap;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public List<Project> getStudentProjects(Student student){
        List<Project> list = new ArrayList(getProjectToStudentMap().get(student));
        return list;
    }

}
