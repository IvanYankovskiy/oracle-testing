package com.example.oracletesting.repository;

import com.example.oracletesting.entity.SomeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface SomeDataRepository extends JpaRepository<SomeData, Long> {
}
