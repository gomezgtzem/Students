package org.generation.Students.controller;

import org.generation.Students.StudentsApplication;
import org.generation.Students.data.entity.Student;
import org.generation.Students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentsController {
    private StudentService studentService;

    public StudentsController(@Autowired StudentService studentService )
    {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public Iterable<Student> allStudents()
    {
        //apuntamos al servicio y el metodo requerido
        return studentService.all();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id)
    {
        return studentService.get(id);
    }
    @PostMapping("/add/student")
    public void saveStudent(@RequestBody Student student)
    {
        //guardando estudiantes
        studentService.save(student);
    }

}