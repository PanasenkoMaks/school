package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;
@Service
public class FacultyService {
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private long generatedFacultyId = 0;
    public Faculty createFaculty (Faculty faculty){
        facultyMap.put(generatedFacultyId, faculty);
        generatedFacultyId ++;
        return faculty;
    }
    public Faculty getFaculty (Long facultyId){
        return facultyMap.get(facultyId);
    }
    public Faculty updateFaculty (Long facultyId, Faculty faculty){
        facultyMap.put(facultyId, faculty);
        return faculty;
    }
    public Faculty deletaFaculty (Long facultyId){
        return facultyMap.remove(facultyId);
    }
    public Faculty findFaculty (String color){
        return (Faculty) facultyMap.values().stream().filter(c -> c.getColor() == color);
        //не понимаю почему не работает поиск
    }

}
