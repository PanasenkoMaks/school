package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class StudentService {

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final StudentRepository studentRepository;


    public Student addStudent (Student student){
        return studentRepository.save(student);
    }
    public Student findStudentById(Long studentId){
        return studentRepository.findById(studentId).get();
    }
    public Student updateStudent (Student student){
        return studentRepository.save(student);
    }
    public void deletaStudent (Long studentId){
        studentRepository.deleteById(studentId);
    }

    public Collection<Student> findStudentByAge (int age) {
        ArrayList<Student> result = new ArrayList<>();
            for (Student student : studentRepository.findAll()) {
                if (student.getAge() == age) {
                    result.add(student);
                }
            }
            return result;
    }
}
