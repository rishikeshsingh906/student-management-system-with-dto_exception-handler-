
package com.studentmanagement.backend.controller;

import com.studentmanagement.backend.entity.Student;
import com.studentmanagement.backend.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    // STEP 1: Service reference
    private final StudentService studentService;

    // STEP 2: Constructor Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // STEP 3: POST API
    @PostMapping
    public ResponseEntity<Student> addStudent(
            @RequestBody Student student) {

        // STEP 4: Service call
        Student savedStudent = studentService.saveStudent(student);

        // STEP 5: Return response
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> students = studentService.getAllStudents();

        return ResponseEntity.ok(students);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable Long id) {

        Student student = studentService.getStudentById(id);

        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        // STEP 1: Service call
        Student updatedStudent =
                studentService.updateStudent(id, student);

        // STEP 2: Return updated student
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long id) {

        // STEP 1: Service call
        studentService.deleteStudent(id);

        // STEP 2: Return HTTP 204
        return ResponseEntity.noContent().build();
    }

}
