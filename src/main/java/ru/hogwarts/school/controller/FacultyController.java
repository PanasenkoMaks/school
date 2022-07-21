package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.Collections;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping
    public ResponseEntity addFaculty (@RequestBody Faculty faculty){
        Faculty createFaculty = facultyService.addFaculty(faculty);
        return ResponseEntity.ok(createFaculty);
    }
    @GetMapping({"id"})
    public ResponseEntity findFacultyById(@PathVariable long facultyId){
        Faculty faculty = facultyService.findFacultyById(facultyId);
        if (faculty == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(faculty);
    }
    public ResponseEntity updateFaculty (@RequestBody Faculty faculty){
        Faculty updateFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(updateFaculty);
    }
    @DeleteMapping({"id"})
    public ResponseEntity deleteFaculty (@PathVariable long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Collection<Faculty>> findFacultyByColor(@RequestParam(required = false) long color){
        if (color > 0) {
            return ResponseEntity.ok(facultyService.findFacultyByColor(color));
        }
        return ResponseEntity.ok().build();
//        return ResponseEntity.ok(Collections.emptyList());
    }
}
