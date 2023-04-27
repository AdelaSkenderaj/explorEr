package com.explorer.controller;

import com.explorer.entity.CountryEntity;
import com.explorer.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RequiredArgsConstructor
@RestController
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<List<CountryEntity>> getAllCountries() {
        return ok(countryService.getAllCountries());
    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<CountryEntity> getCountryById(@PathVariable Long id) {
        return ok(countryService.getCountryById(id));
    }

    @PostMapping("/countries")
    public ResponseEntity<CountryEntity> createCountry(@RequestBody CountryEntity countryEntity) {
        return ok(countryService.creatCountry(countryEntity));
    }

    @DeleteMapping("/countries/{id}")
    public ResponseEntity<Void> deleteCountryById(@PathVariable Long id) {
        countryService.deleteCountryById(id);
        return ok().body(null);
    }

    @PatchMapping("/countries/{id}")
    public ResponseEntity<CountryEntity> updateCountry(@PathVariable Long id, @RequestBody CountryEntity countryEntity) {
        return ok(countryService.updateCountry(id, countryEntity));
    }

}
