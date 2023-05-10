package com.explorer.controller;

import com.explorer.entity.UniversityEntity;
import com.explorer.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping("/universities/{universityId}")
    public ResponseEntity<UniversityEntity> getUniversityById(@PathVariable Long universityId) {
        return ok(universityService.getUniversityById(universityId));
    }

    @PostMapping("/register/university")
    public ResponseEntity<UniversityEntity> registerUniversity(@RequestBody UniversityEntity universityEntity){
        return ok(universityService.createUniversity(universityEntity));
    }

    @GetMapping("/universities")
    public ResponseEntity<List<UniversityEntity>> getAllUniversities() {
        return ok(universityService.getAllUniversities());
    }

    /*@GetMapping("/country/{countryId}/universities")
    public ResponseEntity<List<UniversityEntity>> getUniversitiesByCountryId(@PathVariable Long countryId) {
        return ok(universityService.getUniversitiesByCountryId(countryId));
    }*/
}
