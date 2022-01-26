package com.example.tourapi.test.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDAO {
    List<TestDTO> getTestList();

    int insertTest(TestDTO testDTO);
}
