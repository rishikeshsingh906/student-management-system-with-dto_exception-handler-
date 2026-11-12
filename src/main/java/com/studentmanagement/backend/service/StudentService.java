
package com.studentmanagement.backend.service;

import com.studentmanagement.backend.entity.Student;
import com.studentmanagement.backend.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.studentmanagement.backend.dto.StudentResponseDto;


@Service
public class StudentService {

    // STEP 1: Repository reference
    private final StudentRepository studentRepository;

    // STEP 2: Constructor Injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // STEP 3: Save Student method
    public StudentResponseDto saveStudent(Student student) {

        Student savedStudent = studentRepository.save(student);

        return mapToResponseDto(savedStudent);
    }
//    public List<Student> getAllStudents() {
//
//        return studentRepository.findAll();
//
//    }
    public List<StudentResponseDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> mapToResponseDto(student))
                .toList();
    }
//    public Student getStudentById(Long id) {
//
//        return studentRepository.findById(id)
//                .orElseThrow(() ->
//                        new ResponseStatusException(
//                                HttpStatus.NOT_FOUND,
//                                "Student not found"
//                        )
//                );
//    }
public StudentResponseDto getStudentById(Long id) {

    Student student = studentRepository.findById(id)
            .orElseThrow(() ->
                    new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Student not found"
                    )
            );

    return mapToResponseDto(student);
}
//    public Student updateStudent(Long id, Student newStudent) {
//
//        // STEP 1: Find existing student
//        Student existingStudent = studentRepository.findById(id)
//                .orElseThrow(() ->
//                        new ResponseStatusException(
//                                HttpStatus.NOT_FOUND,
//                                "Student not found"
//                        )
//                );
//
//        // STEP 2: Update existing values
//        existingStudent.setName(newStudent.getName());
//        existingStudent.setEmail(newStudent.getEmail());
//        existingStudent.setAge(newStudent.getAge());
//
//        // STEP 3: Save updated student
//        return studentRepository.save(existingStudent);
//    }

    public StudentResponseDto updateStudent(Long id, Student newStudent) {

        // STEP 1: Find existing student
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Student not found"
                        )
                );

        // STEP 2: Update existing values
        existingStudent.setName(newStudent.getName());
        existingStudent.setEmail(newStudent.getEmail());
        existingStudent.setAge(newStudent.getAge());

        // STEP 3: Save updated student
        Student updatedStudent = studentRepository.save(existingStudent);

        // STEP 4: Convert Entity into DTO
        return mapToResponseDto(updatedStudent);
    }

    public void deleteStudent(Long id) {

        // STEP 1: Check student exists or not
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Student not found"
                        )
                );

        // STEP 2: Delete student from database
        studentRepository.delete(student);
    }
    private StudentResponseDto mapToResponseDto(Student student) {

        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAge()
        );
    }

}
