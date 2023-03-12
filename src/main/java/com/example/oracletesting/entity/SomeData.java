package com.example.oracletesting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SomeData {
    @Id
    @GeneratedValue(generator = "sd_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sd_sequence", sequenceName = "some_data_sequence", allocationSize = 100)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "value_1")
    private String value1;
}
