package com.explorer.service;

import com.explorer.repository.RegisteredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisteredService {

    private final RegisteredRepository registeredRepository;
}
