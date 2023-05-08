package com.explorer.controller;

import com.explorer.entity.FacultyEntity;
import com.explorer.entity.UniversityEntity;
import com.explorer.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping("/faculty/{facultyId}")
    public ResponseEntity<FacultyEntity> getFa(@PathVariable Long facultyId) {
        return ok(facultyService.getFacultyById(facultyId));
    }

    @PostMapping("/faculty")
    public ResponseEntity<FacultyEntity> createFaculty(@RequestBody FacultyEntity faculty){
        return ok(facultyService.createFaculty(faculty));
    }

    @GetMapping("/university/{universityId}/faculties")
    public ResponseEntity<List<FacultyEntity>> getAllUniversities(@PathVariable Long universityId) {
        return ok(facultyService.getFacultiesByUniversityId(universityId));
    }
}
