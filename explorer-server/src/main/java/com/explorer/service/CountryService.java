package com.explorer.service;

import com.explorer.entity.CountryEntity;
import com.explorer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryEntity findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }
    public List<CountryEntity> getAllCountries() {
        return countryRepository.findAll();
    }

    public CountryEntity getCountryById(Long countryId) {
        return findById(countryId);
    }

    public CountryEntity creatCountry(CountryEntity countryEntity) {
        return countryRepository.save(countryEntity);
    }

    public void deleteCountryById(Long countryId) {
        countryRepository.deleteById(countryId);
    }

    public CountryEntity updateCountry(Long countryId, CountryEntity countryEntity) {
        CountryEntity ce = findById(countryId);
        if (ce == null) {
            throw new RuntimeException("country does not exist");
        }
        ofNullable(countryEntity.getName()).ifPresent(ce::setName);
        return countryRepository.save(ce);
    }
}
