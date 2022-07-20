package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping
    public ResponseEntity createFaculty (@RequestBody Faculty faculty){
        Faculty createFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createFaculty);
    }
    @GetMapping
    public ResponseEntity getFaculty(@PathVariable long facultyId){
        Faculty faculty = facultyService.getFaculty(facultyId);
        if (faculty == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(faculty);
    }
    public ResponseEntity updateFaculty (@RequestBody Faculty faculty){
        Faculty updateFaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(updateFaculty);
    }
    @GetMapping({"color"})
    public ResponseEntity findFacultyColor (@PathVariable String color){
        Faculty findFacultyColor = facultyService.findFaculty(color);
        if (findFacultyColor == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(findFacultyColor);
    }
}
