package ru.hogwarts.school.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.*;

@Service

public class FacultyService {
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    private final FacultyRepository facultyRepository;


    public Faculty addFaculty (Faculty faculty){
        return facultyRepository.save(faculty);

    }
    public Faculty findFacultyById(Long facultyId){
        return facultyRepository.findById(facultyId).get();
    }
    public Faculty updateFaculty  (Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public void deleteFaculty(Long facultyId){
         facultyRepository.deleteById(facultyId);
    }

    public Collection<Faculty> findFacultyByColor(long color){
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : facultyRepository.findAll()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }

}
