package com.example.BootDemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1,"Bob","Sport"));
        students.add(new Student(2,"Alfred","Science"));
        students.add(new Student(3,"Mary","Engineering"));
    }

    public List<Student> showAll(){
        return students;
    }

    public Student getById(int id){
        Student s = students.stream().filter(student -> student.getId()==id).findFirst().get();
        return s;
    }

    public String addStudent(Student student){
        students.add(student);
        return "Successfully add a student";
    }

    public String updateStudent(int id,Student student){
        for(int i=0;i<students.size();i++){
            Student s = students.get(i);
            if(s.getId()==id){
                students.set(i, student);
                return "Update Successfully!";
            }
        }
        return "Update Failed";
    }

    public String deleteStudent(int id){
        students.removeIf(student -> student.getId()==id);
        return "Successfully Remove Student";
    }

}
