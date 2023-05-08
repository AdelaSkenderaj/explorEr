package com.explorer.service;

import com.explorer.entity.FacultyEntity;
import com.explorer.entity.UniversityEntity;
import com.explorer.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyEntity findById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public List<FacultyEntity> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public List<FacultyEntity> getFacultiesByUniversityId(Long universityId) {
        return facultyRepository.findByUniversityId(universityId);
    }

    public FacultyEntity createFaculty(FacultyEntity faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteUniversityById(Long id) {
        facultyRepository.deleteById(id);
    }

    public FacultyEntity getFacultyById(Long facultyId) {
        FacultyEntity faculty = findById(facultyId);
        if (faculty == null) {
            throw new RuntimeException("University not found");
        }
        return faculty;
    }
}
