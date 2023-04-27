package com.explorer.controller;

import com.explorer.service.RegisteredService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisteredController {

    private final RegisteredService registeredService;
}
