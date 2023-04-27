package com.explorer.service;

import com.explorer.entity.CityEntity;
import com.explorer.entity.CountryEntity;
import com.explorer.repository.CityRepository;
import com.explorer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public CityEntity findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public CityEntity getCityById(Long id) {
        return findById(id);
    }

    public List<CityEntity> getAllCities() {
        return cityRepository.findAll();
    }

    public CityEntity createCity(CityEntity cityEntity) {
        return cityRepository.save(cityEntity);
    }

    public void deleteCityById(Long id) {
        cityRepository.deleteById(id);
    }

    public CityEntity updateCity(Long id, CityEntity cityEntity) {
        CityEntity ce = findById(id);
        if (ce == null) {
            throw new RuntimeException("City does not exist");
        }
        ofNullable(cityEntity.getName()).ifPresent(ce::setName);

        Long countryId = cityEntity.getCountryId();
        if (countryId != null) {
            CountryEntity countryEntity = countryRepository.findById(countryId).orElse(null);
            if (countryEntity == null) {
                throw new RuntimeException("There does not exist a country with that id");
            }
            ce.setCountryId(countryId);
        }
        return cityRepository.save(ce);
    }

    public List<CityEntity> getCitiesByCountryId(Long countryId) {
        return cityRepository.findByCountryId(countryId);
    }
}
