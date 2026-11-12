
package com.studentmanagement.backend.controller;

import com.studentmanagement.backend.dto.StudentRequestDto;
import com.studentmanagement.backend.dto.StudentResponseDto;
import com.studentmanagement.backend.entity.Student;
import com.studentmanagement.backend.service.StudentService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    // Constructor Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE STUDENT
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDto saveStudent(
            @Valid @RequestBody StudentRequestDto requestDto) {

        Student student = new Student();

        student.setName(requestDto.getName());
        student.setEmail(requestDto.getEmail());
        student.setAge(requestDto.getAge());

        return studentService.saveStudent(student);
    }

    // GET ALL STUDENTS
    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    // GET STUDENT BY ID
    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // UPDATE STUDENT
    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDto requestDto) {

        Student student = new Student();

        student.setName(requestDto.getName());
        student.setEmail(requestDto.getEmail());
        student.setAge(requestDto.getAge());

        return studentService.updateStudent(id, student);
    }

    // DELETE STUDENT
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
