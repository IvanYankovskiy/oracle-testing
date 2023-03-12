package com.example.oracletesting.service;

import com.example.oracletesting.entity.SomeData;
import com.example.oracletesting.repository.SomeDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class SomeDataService {
    private final SomeDataRepository someDataRepository;

    public List<SomeData> generate(int counts) {
        return IntStream
                .range(0, counts)
                .mapToObj(i -> new SomeData(null, i + "-" + UUID.randomUUID()))
                .collect(Collectors.toList());
    }

    public List<SomeData> generateAndSave(int n) {
        return someDataRepository.saveAll(generate(n));
    }
}
