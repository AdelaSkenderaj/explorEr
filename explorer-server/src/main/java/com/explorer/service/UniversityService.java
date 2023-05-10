package com.explorer.service;

import com.explorer.entity.CountryEntity;
import com.explorer.entity.UniversityEntity;
import com.explorer.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityEntity findById(Long id) {
        return universityRepository.findById(id).orElse(null);
    }

    public List<UniversityEntity> getAllUniversities() {
        return universityRepository.findAll();
    }

    /*public List<UniversityEntity> getUniversitiesByCountryId(Long countryId) {
        return universityRepository.findByCountryId(countryId);
    }*/

    public UniversityEntity createUniversity(UniversityEntity universityEntity) {
        return universityRepository.save(universityEntity);
    }

    public void deleteUniversityById(Long id) {
        universityRepository.deleteById(id);
    }

    public UniversityEntity getUniversityById(Long universityId) {
        UniversityEntity university = findById(universityId);
        if (university == null) {
            throw new RuntimeException("University not found");
        }
        return university;
    }
}
