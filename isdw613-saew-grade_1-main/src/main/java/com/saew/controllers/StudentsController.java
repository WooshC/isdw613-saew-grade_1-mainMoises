package com.saew.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saew.dto.Student;
@RestController
@RequestMapping("/students")
public class StudentsController {

    private final List<Student> studentList;

    public StudentsController() {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Bob Johnson", "bobJ@gmail.com", 17.5f));
        studentList.add(new Student(2, "Alice Brown", "alice@gmail.com", 19.2f));
        studentList.add(new Student(3, "Mora Aldaz", "mora@gmail.com", 20.0f));
        studentList.add(new Student(4, "Alice Brown", "alice@gmail.com", 20.0f));
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return new ResponseEntity<>(student, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentList.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getId() == id) {
                // Actualizar los campos del estudiante
                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                student.setGPA(updatedStudent.getGPA());

                studentList.set(i, student);
                return new ResponseEntity<>(student, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentList.remove(student);
                return new ResponseEntity<>(student, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
