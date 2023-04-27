package com.explorer.controller;

import com.explorer.entity.CityEntity;
import com.explorer.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/cities")
    public ResponseEntity<List<CityEntity>> getAllCitites() {
        return ok(cityService.getAllCities());
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<CityEntity> getCityById(@PathVariable Long id) {
        return ok(cityService.getCityById(id));
    }

    @PostMapping("/cities")
    public ResponseEntity<CityEntity> createCity(@RequestBody CityEntity cityEntity) {
        return ok(cityService.createCity(cityEntity));
    }

    @PatchMapping("/citites/{id}")
    public ResponseEntity<CityEntity> updateCity(@PathVariable Long id, @RequestBody CityEntity cityEntity) {
        return ok(cityService.updateCity(id, cityEntity));
    }

    @DeleteMapping("/citites/{id}")
    public ResponseEntity<Void> deleteCityById(@PathVariable Long id) {
        cityService.deleteCityById(id);
        return ok().body(null);
    }

    @GetMapping("/citites/country/{countryId}")
    public ResponseEntity<List<CityEntity>> getCitiesByCountryId(@PathVariable Long countryId) {
        return ok(cityService.getCitiesByCountryId(countryId));
    }
}
