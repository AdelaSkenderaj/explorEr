package com.explorer.controller;

import com.explorer.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;
}
