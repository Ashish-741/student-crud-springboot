package com.ashu.crud_operations.service;

import com.ashu.crud_operations.model.Student;
import com.ashu.crud_operations.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public void save(Student s) { repo.save(s); }

    public List<Student> getAll() { return repo.getAll(); }

    public Student getById(int id) {
        try {
            return repo.getById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public void update(int id, Student s) { repo.update(id, s); }

    public void delete(int id) { repo.delete(id); }
}