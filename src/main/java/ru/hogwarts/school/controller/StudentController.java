package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collections;
import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.addStudent(student);
    return ResponseEntity.ok(createdStudent);
    }
    @GetMapping({"id"})
    public ResponseEntity<Student> findStudentById (@PathVariable long studentId){
        Student student = studentService.findStudentById(studentId);
        if (student == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(student);
    }
    @PutMapping
    public ResponseEntity<Student> updateStudent (@RequestBody Student student){
        Student updateStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updateStudent);
    }
    @DeleteMapping({"id"})
    public ResponseEntity<Student> deleteStudent (@PathVariable long id){
        studentService.deletaStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Object>> findStudentByAge(@RequestParam(required = false) int age){
        if (age > 0){
            ResponseEntity.ok(studentService.findStudentByAge(age));
        }
    return ResponseEntity.ok(Collections.emptyList());
    }
}
