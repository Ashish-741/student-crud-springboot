package com.ashu.crud_operations.repository;

import com.ashu.crud_operations.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // CREATE
    public void save(Student s) {
        String sql = "INSERT INTO students(name, email, course) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, s.getName(), s.getEmail(), s.getCourse());
    }

    // READ ALL
    public List<Student> getAll() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    // READ BY ID
    public Student getById(int id) {
        String sql = "SELECT * FROM students WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
    }

    // UPDATE
    public void update(int id, Student s) {
        String sql = "UPDATE students SET name=?, email=?, course=? WHERE id=?";
        jdbcTemplate.update(sql, s.getName(), s.getEmail(), s.getCourse(), id);
    }

    // DELETE
    public void delete(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}