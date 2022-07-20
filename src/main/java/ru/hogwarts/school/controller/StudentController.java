package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

@RequestMapping("student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
    return ResponseEntity.ok(createdStudent);
    }
    @GetMapping
    public ResponseEntity<Student> getStudent(@PathVariable long studentId){
        Student student = studentService.getStudent(studentId);
        if (student == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(student);
    }
    @PutMapping
    public ResponseEntity<Student> updateStudent (@RequestBody Student student){
        Student updateStudent = studentService.updateStudent(student.getId(), student);
        return ResponseEntity.ok(updateStudent);
    }
    @GetMapping({"age"})
    public ResponseEntity<Student> findStudentAge (@PathVariable int age){
        Student findStudent = studentService.findStudent(age);
        if (findStudent == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    return ResponseEntity.ok(findStudent);
    }
}
