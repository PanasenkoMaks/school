package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;
@Service
public class StudentService {
    private Map<Long, Student> studentMap = new HashMap<>();
    private long generatedStudensId = 0L;

    public Student createStudent (Student student){
        studentMap.put(generatedStudensId, student);
        generatedStudensId ++;
        return student;
    }
    public Student getStudent (Long studentId){
        return studentMap.get(studentId);
    }
    public Student updateStudent (Long studentId, Student student){
        studentMap.put(studentId, student);
        return student;
    }
    public Student deletaStudent (Long studentId){
        return studentMap.remove(studentId);
    }
    public Student findStudent (int age){
       return (Student) studentMap.values().stream().filter(a -> a.getAge() == age);
        //не понимаю почему не работает поиск
    }
}
