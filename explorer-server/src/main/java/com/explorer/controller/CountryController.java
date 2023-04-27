package com.explorer.controller;

import com.explorer.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CountryController {

    private final CountryService countryService;
}
