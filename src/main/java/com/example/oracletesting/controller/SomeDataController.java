package com.example.oracletesting.controller;

import com.example.oracletesting.entity.SomeData;
import com.example.oracletesting.repository.SomeDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SomeDataController {
    private final SomeDataRepository someDataRepository;

    @GetMapping("/all")
    public List<SomeData> findAll() {
        return someDataRepository.findAll();
    }
}
