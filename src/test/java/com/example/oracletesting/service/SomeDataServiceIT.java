package com.example.oracletesting.service;

import com.example.oracletesting.IntegrationTest;
import com.example.oracletesting.entity.SomeData;
import com.example.oracletesting.repository.SomeDataRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@IntegrationTest
class SomeDataServiceIT {

    @Autowired
    private SomeDataService someDataService;
    @Autowired
    private SomeDataRepository someDataRepository;

    @Test
    void shouldGenerateAndSaveObjects() {
        // given

        // when
        List<SomeData> actual = someDataService.generateAndSave(5000);

        // then
        Assertions.assertThat(someDataRepository.findAll()).hasSize(5000);
    }

}
