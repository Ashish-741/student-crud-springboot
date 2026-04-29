package com.ashu.crud_operations.controller;

import com.ashu.crud_operations.model.Student;
import com.ashu.crud_operations.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // CREATE
    @PostMapping
    public String create(@RequestBody Student s) {
        service.save(s);
        return "Student Added Successfully";
    }

    // READ ALL
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student s) {
        service.update(id, s);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}