package com.explorer.controller;

import com.explorer.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;
}
