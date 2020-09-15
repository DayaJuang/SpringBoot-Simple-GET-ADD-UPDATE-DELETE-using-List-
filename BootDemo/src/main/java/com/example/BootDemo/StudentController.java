package com.example.BootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    @ResponseBody
    public String sayHi(){
        return "Hi User!";
    }

    @RequestMapping("/students")
    public List<Student> showAll(){
        return studentService.showAll();
    }

    @RequestMapping("/students/{id}")
    public Student getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }
}
